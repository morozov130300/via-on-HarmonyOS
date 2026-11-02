import { util } from '@kit.ArkTS'
import { cryptoFramework } from '@kit.CryptoArchitectureKit'

// 原版备份加密体系 1:1（已亲自核实）：
// - z8/w0.j（:217-227）：PBKDF2WithHmacSHA1(password, salt=UTF-8(uuid), 10000, 256bit)
// - z8/w0.h（:174-206）：AES/CBC/PKCS5Padding，输出 = IV(16 随机字节) || 密文
// - ZipBackupManager.f（:314-332）/d（:221-252）：info.enc = uuid 字符串
//   UTF-8 字节 XOR {90,60,127,-89}（0x5A,0x3C,0x7F,0xA7 循环）
// - ZipBackupManager.b（:150-151）：uuid = UUID.randomUUID().toString().replace("-","")
// - Android Base64 flag 0：76 字符换行 + 尾部换行（l9/* 全部 base64 输出）
// - u4/a.c（:53-76）filters 文件名 / m9/l.d（:263）：md5 hex（z8/v0.g，小写）
export class BackupCrypto {
  private static readonly XOR_KEY: number[] = [90, 60, 127, 167]

  static utf8Encode(text: string): Uint8Array {
    return new util.TextEncoder().encodeInto(text)
  }

  static utf8Decode(bytes: Uint8Array): string {
    return new util.TextDecoder('utf-8').decodeToString(bytes)
  }

  static randomBytes(count: number): Uint8Array {
    const bytes = new Uint8Array(count)
    for (let i = 0; i < count; i++) {
      bytes[i] = Math.floor(Math.random() * 256)
    }
    return bytes
  }

  // z8/v0.g：MD5 小写 hex（文件名生成，走系统 crypto）
  static async md5Hex(text: string): Promise<string> {
    const md = cryptoFramework.createMd('MD5')
    await md.update({ data: BackupCrypto.utf8Encode(text) })
    const digest = await md.digest()
    let out = ''
    for (let i = 0; i < digest.data.length; i++) {
      const v = digest.data[i]
      out += (v < 16 ? '0' : '') + v.toString(16)
    }
    return out
  }

  // 纯 TS SHA-1（HMAC/PBKDF2 基础）
  static sha1(msg: Uint8Array): Uint8Array {
    const ml = msg.length
    const total = (((ml + 9) >> 6) + 1) << 6
    const buf = new Uint8Array(total)
    buf.set(msg)
    buf[ml] = 0x80
    const view = new DataView(buf.buffer)
    view.setUint32(total - 8, Math.floor(ml / 536870912), false)
    view.setUint32(total - 4, (ml << 3) >>> 0, false)
    let h0 = 0x67452301
    let h1 = 0xEFCDAB89
    let h2 = 0x98BADCFE
    let h3 = 0x10325476
    let h4 = 0xC3D2E1F0
    const w = new Uint32Array(80)
    for (let block = 0; block < total; block += 64) {
      for (let i = 0; i < 16; i++) {
        w[i] = view.getUint32(block + i * 4, false)
      }
      for (let i = 16; i < 80; i++) {
        const n = w[i - 3] ^ w[i - 8] ^ w[i - 14] ^ w[i - 16]
        w[i] = ((n << 1) | (n >>> 31)) >>> 0
      }
      let a = h0
      let b = h1
      let c = h2
      let d = h3
      let e = h4
      for (let i = 0; i < 80; i++) {
        let f = 0
        let k = 0
        if (i < 20) {
          f = (b & c) | (~b & d)
          k = 0x5A827999
        } else if (i < 40) {
          f = b ^ c ^ d
          k = 0x6ED9EBA1
        } else if (i < 60) {
          f = (b & c) | (b & d) | (c & d)
          k = 0x8F1BBCDC
        } else {
          f = b ^ c ^ d
          k = 0xCA62C1D6
        }
        const t = (((((a << 5) | (a >>> 27)) >>> 0) + (f >>> 0) + e + k) >>> 0) + w[i]
        e = d
        d = c
        c = ((b << 30) | (b >>> 2)) >>> 0
        b = a
        a = t >>> 0
      }
      h0 = (h0 + a) >>> 0
      h1 = (h1 + b) >>> 0
      h2 = (h2 + c) >>> 0
      h3 = (h3 + d) >>> 0
      h4 = (h4 + e) >>> 0
    }
    const out = new Uint8Array(20)
    const outView = new DataView(out.buffer)
    outView.setUint32(0, h0, false)
    outView.setUint32(4, h1, false)
    outView.setUint32(8, h2, false)
    outView.setUint32(12, h3, false)
    outView.setUint32(16, h4, false)
    return out
  }

  // RFC 2104 HMAC-SHA1（key ≤ 64 字节场景）
  static hmacSha1(key: Uint8Array, msg: Uint8Array): Uint8Array {
    const block = new Uint8Array(64)
    if (key.length > 64) {
      block.set(BackupCrypto.sha1(key))
    } else {
      block.set(key)
    }
    const inner = new Uint8Array(64 + msg.length)
    const outer = new Uint8Array(84)
    for (let i = 0; i < 64; i++) {
      inner[i] = block[i] ^ 0x36
      outer[i] = block[i] ^ 0x5C
    }
    inner.set(msg, 64)
    const innerHash = BackupCrypto.sha1(inner)
    outer.set(innerHash, 64)
    return BackupCrypto.sha1(outer)
  }

  // z8/w0.j：PBKDF2-HMAC-SHA1（10000 次、256bit）
  static pbkdf2Sha1(password: string, salt: Uint8Array, iterations: number, dkLen: number): Uint8Array {
    const pw = BackupCrypto.utf8Encode(password)
    const blocks = Math.ceil(dkLen / 20)
    const out = new Uint8Array(blocks * 20)
    for (let i = 1; i <= blocks; i++) {
      const saltMsg = new Uint8Array(salt.length + 4)
      saltMsg.set(salt)
      saltMsg[salt.length] = (i >>> 24) & 0xFF
      saltMsg[salt.length + 1] = (i >>> 16) & 0xFF
      saltMsg[salt.length + 2] = (i >>> 8) & 0xFF
      saltMsg[salt.length + 3] = i & 0xFF
      let u = BackupCrypto.hmacSha1(pw, saltMsg)
      let acc = new Uint8Array(u)
      for (let iter = 1; iter < iterations; iter++) {
        u = BackupCrypto.hmacSha1(pw, u)
        for (let j = 0; j < 20; j++) {
          acc[j] = acc[j] ^ u[j]
        }
      }
      out.set(acc, (i - 1) * 20)
    }
    return out.subarray(0, dkLen)
  }

  // Android Base64 flag 0：76 字符换行 + 尾部换行
  static base64Wrap76(bytes: Uint8Array): string {
    const helper = new util.Base64Helper()
    const raw = helper.encodeToStringSync(bytes)
    let out = ''
    for (let i = 0; i < raw.length; i += 76) {
      out += raw.substring(i, i + 76) + '\n'
    }
    return out
  }

  // 解码兼容带/不带换行
  static base64Decode(text: string): Uint8Array {
    const cleaned = text.replace(/\s/g, '')
    return new util.Base64Helper().decodeSync(cleaned)
  }

  // ZipBackupManager.f：uuid UTF-8 字节 XOR {0x5A,0x3C,0x7F,0xA7}
  static xorInfo(uuid: string): Uint8Array {
    const bytes = BackupCrypto.utf8Encode(uuid)
    for (let i = 0; i < bytes.length; i++) {
      bytes[i] = bytes[i] ^ BackupCrypto.XOR_KEY[i % 4]
    }
    return bytes
  }

  // ZipBackupManager.f 的逆操作（d）
  static xorInfoDecode(bytes: Uint8Array): string {
    const copy = new Uint8Array(bytes)
    for (let i = 0; i < copy.length; i++) {
      copy[i] = copy[i] ^ BackupCrypto.XOR_KEY[i % 4]
    }
    return BackupCrypto.utf8Decode(copy)
  }

  // z8/w0.h：AES-256-CBC-PKCS7 加密（Java PKCS5Padding 对 16 字节块等价 PKCS7）
  static async aesCbcEncrypt(key: Uint8Array, plain: Uint8Array): Promise<Uint8Array> {
    const iv = BackupCrypto.randomBytes(16)
    const cipher = cryptoFramework.createCipher('AES256|CBC|PKCS7')
    const keyGen = cryptoFramework.createSymKeyGenerator('AES256')
    const symKey = await keyGen.convertKey({ data: key } as cryptoFramework.DataBlob)
    const params: cryptoFramework.IvParamsSpec = {
      iv: { data: iv } as cryptoFramework.DataBlob,
      algName: 'IvParamsSpec'
    }
    await cipher.init(cryptoFramework.CryptoMode.ENCRYPT_MODE, symKey, params)
    const encrypted = await cipher.doFinal({ data: plain } as cryptoFramework.DataBlob)
    const out = new Uint8Array(16 + encrypted.data.length)
    out.set(iv)
    out.set(encrypted.data, 16)
    return out
  }

  // z8/w0.c：解密 pass.enc（前 16 字节 IV）
  static async aesCbcDecrypt(key: Uint8Array, data: Uint8Array): Promise<Uint8Array> {
    const iv = data.subarray(0, 16)
    const body = data.subarray(16)
    const cipher = cryptoFramework.createCipher('AES256|CBC|PKCS7')
    const keyGen = cryptoFramework.createSymKeyGenerator('AES256')
    const symKey = await keyGen.convertKey({ data: key } as cryptoFramework.DataBlob)
    const params: cryptoFramework.IvParamsSpec = {
      iv: { data: iv } as cryptoFramework.DataBlob,
      algName: 'IvParamsSpec'
    }
    await cipher.init(cryptoFramework.CryptoMode.DECRYPT_MODE, symKey, params)
    const decrypted = await cipher.doFinal({ data: body } as cryptoFramework.DataBlob)
    return decrypted.data
  }
}
