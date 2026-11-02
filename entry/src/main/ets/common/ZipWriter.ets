import { fileIo } from '@kit.CoreFileKit'
import { util } from '@kit.ArkTS'

// 自写 STORE（不压缩）ZIP writer：替换 zlib.compressFile
// 原版 d4.java 用 java.util.zip（默认可压缩），条目名与顺序由
// ZipBackupManager.b 决定（info.enc 最先、data-for-older-versions 最后、平铺无目录）。
// zlib.compressFile 只能整目录打包且条目带目录前缀，无法满足原版平铺布局，
// 故按 ZIP 规范自实现（本地文件头 + 中央目录 + EOCD，STORE 方法 + CRC32）。
class ZipEntry {
  name: string
  data: Uint8Array
  crc: number
  offset: number

  constructor(name: string, data: Uint8Array, crc: number, offset: number) {
    this.name = name
    this.data = data
    this.crc = crc
    this.offset = offset
  }
}

export class ZipStoreWriter {
  private entries: ZipEntry[] = []

  private static crcTable(): number[] {
    const table: number[] = []
    for (let n = 0; n < 256; n++) {
      let c = n
      for (let k = 0; k < 8; k++) {
        c = (c & 1) !== 0 ? (0xEDB88320 ^ (c >>> 1)) : (c >>> 1)
      }
      table.push(c >>> 0)
    }
    return table
  }

  private static crc32(data: Uint8Array): number {
    const table = ZipStoreWriter.crcTable()
    let crc = 0xFFFFFFFF
    for (let i = 0; i < data.length; i++) {
      crc = table[(crc ^ data[i]) & 0xFF] ^ (crc >>> 8)
    }
    return (crc ^ 0xFFFFFFFF) >>> 0
  }

  private static dosDateTime(now: Date): number[] {
    const year = Math.max(now.getFullYear(), 1980)
    const date = ((year - 1980) << 9) | ((now.getMonth() + 1) << 5) | now.getDate()
    const time = (now.getHours() << 11) | (now.getMinutes() << 5) | Math.floor(now.getSeconds() / 2)
    return [date & 0xFF, (date >> 8) & 0xFF, time & 0xFF, (time >> 8) & 0xFF]
  }

  private static u16(value: number): Uint8Array {
    return new Uint8Array([value & 0xFF, (value >> 8) & 0xFF])
  }

  private static u32(value: number): Uint8Array {
    return new Uint8Array([value & 0xFF, (value >> 8) & 0xFF, (value >> 16) & 0xFF, (value >>> 24) & 0xFF])
  }

  private static concat(parts: Uint8Array[]): Uint8Array {
    let size = 0
    for (let i = 0; i < parts.length; i++) {
      size += parts[i].length
    }
    const out = new Uint8Array(size)
    let offset = 0
    for (let i = 0; i < parts.length; i++) {
      out.set(parts[i], offset)
      offset += parts[i].length
    }
    return out
  }

  addText(name: string, text: string): void {
    this.addBytes(name, new util.TextEncoder().encodeInto(text))
  }

  addBytes(name: string, data: Uint8Array): void {
    this.entries.push(new ZipEntry(name, data, ZipStoreWriter.crc32(data), -1))
  }

  // 完整 ZIP 字节序列（writeTo 与 toBytes 共用；icons.zip 嵌套打包用 toBytes）
  private serialize(): Uint8Array {
    const now = new Date()
    const localParts: Uint8Array[] = []
    const centralParts: Uint8Array[] = []
    let offset = 0
    for (let i = 0; i < this.entries.length; i++) {
      const entry = this.entries[i]
      entry.offset = offset
      const nameBytes = new util.TextEncoder().encodeInto(entry.name)
      const header = ZipStoreWriter.concat([
          ZipStoreWriter.u32(0x04034B50),
          ZipStoreWriter.u16(20),
          ZipStoreWriter.u16(0x0800),
          ZipStoreWriter.u16(0),
          new Uint8Array(ZipStoreWriter.dosDateTime(now)),
          ZipStoreWriter.u32(entry.crc),
          ZipStoreWriter.u32(entry.data.length),
          ZipStoreWriter.u32(entry.data.length),
          ZipStoreWriter.u16(nameBytes.length),
          ZipStoreWriter.u16(0),
          nameBytes
        ])
      localParts.push(header)
      localParts.push(entry.data)
      offset += header.length + entry.data.length
      centralParts.push(ZipStoreWriter.concat([
          ZipStoreWriter.u32(0x02014B50),
          ZipStoreWriter.u16(20),
          ZipStoreWriter.u16(20),
          ZipStoreWriter.u16(0x0800),
          ZipStoreWriter.u16(0),
          new Uint8Array(ZipStoreWriter.dosDateTime(now)),
          ZipStoreWriter.u32(entry.crc),
          ZipStoreWriter.u32(entry.data.length),
          ZipStoreWriter.u32(entry.data.length),
          ZipStoreWriter.u16(nameBytes.length),
          ZipStoreWriter.u16(0),
          ZipStoreWriter.u16(0),
          ZipStoreWriter.u16(0),
          ZipStoreWriter.u16(0),
          ZipStoreWriter.u32(0),
          ZipStoreWriter.u32(entry.offset),
          nameBytes
        ]))
      }
      let centralSize = 0
      for (let i = 0; i < centralParts.length; i++) {
        centralSize += centralParts[i].length
      }
      const eocd = ZipStoreWriter.concat([
        ZipStoreWriter.u32(0x06054B50),
        ZipStoreWriter.u16(0),
        ZipStoreWriter.u16(0),
        ZipStoreWriter.u16(this.entries.length),
        ZipStoreWriter.u16(this.entries.length),
        ZipStoreWriter.u32(centralSize),
        ZipStoreWriter.u32(offset),
        ZipStoreWriter.u16(0)
      ])
      const all: Uint8Array[] = []
      for (let i = 0; i < localParts.length; i++) {
        all.push(localParts[i])
      }
      for (let i = 0; i < centralParts.length; i++) {
        all.push(centralParts[i])
      }
      all.push(eocd)
      return ZipStoreWriter.concat(all)
  }

  toBytes(): Uint8Array {
    return this.serialize()
  }

  async writeTo(path: string): Promise<void> {
    const bytes = this.serialize()
    const file = fileIo.openSync(path, fileIo.OpenMode.READ_WRITE | fileIo.OpenMode.CREATE | fileIo.OpenMode.TRUNC)
    try {
      fileIo.writeSync(file.fd, bytes)
    } finally {
      fileIo.closeSync(file)
    }
  }
}
