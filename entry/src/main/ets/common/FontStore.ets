import { fileIo } from '@kit.CoreFileKit'
import { common } from '@kit.AbilityKit'
import { AppSettings } from './Settings'

// 字体条目：name = 文件名（默认项为空字符串），path = 绝对路径
export class FontEntry {
  name: string
  path: string

  constructor(name: string, path: string) {
    this.name = name
    this.path = path
  }
}

// 原版 s9/d.java：字体仓库（fonts 目录，仅 .ttf/.otf/.woff/.woff2，按名排序，默认项在前）
export class FontStore {
  private static instance: FontStore | null = null

  private constructor() {
  }

  static getInstance(): FontStore {
    if (FontStore.instance === null) {
      FontStore.instance = new FontStore()
    }
    return FontStore.instance
  }

  dir(context: common.Context): string {
    return `${context.filesDir}/fonts`
  }

  // 原版 d.<init>：目录不存在则建
  ensureDir(context: common.Context): void {
    const dir = this.dir(context)
    if (!fileIo.accessSync(dir)) {
      fileIo.mkdirSync(dir, true)
    }
  }

  private isFontName(name: string): boolean {
    return name.endsWith('.ttf') || name.endsWith('.otf') || name.endsWith('.woff') || name.endsWith('.woff2')
  }

  // 原版 d.h()：默认项 + 目录内字体文件，忽略大小写按名排序
  list(context: common.Context): FontEntry[] {
    const result: FontEntry[] = [new FontEntry('', '')]
    const dir = this.dir(context)
    if (!fileIo.accessSync(dir)) {
      return result
    }
    const names = fileIo.listFileSync(dir).filter((name: string) => this.isFontName(name))
    names.sort((a: string, b: string) => a.toLowerCase().localeCompare(b.toLowerCase()))
    for (const name of names) {
      result.push(new FontEntry(name, `${dir}/${name}`))
    }
    return result
  }

  // 原版 z8.c1.r：扩展名小写
  private extOf(name: string): string {
    const dot = name.lastIndexOf('.')
    return dot > 0 ? name.substring(dot + 1).toLowerCase() : ''
  }

  // 原版 j2.i3：导入字体。返回错误码 0=成功 1=扩展名不支持 2=超过 50MB 3=同名删除失败 4=复制失败 5=入库失败
  importFromFile(context: common.Context, uri: string): number {
    let name = uri.substring(uri.lastIndexOf('/') + 1)
    try {
      name = decodeURIComponent(name)
    } catch (error) {
      // 保留原样
    }
    if (!this.isFontName(name)) {
      return 1
    }
    this.ensureDir(context)
    const dir = this.dir(context)
    let srcFd = -1
    try {
      const srcStat = fileIo.statSync(uri)
      if (srcStat.size > 52428800) {
        return 2
      }
      const dest = `${dir}/${name}`
      if (fileIo.accessSync(dest)) {
        try {
          fileIo.unlinkSync(dest)
        } catch (error) {
          return 3
        }
      }
      srcFd = fileIo.openSync(uri, fileIo.OpenMode.READ_ONLY).fd
      fileIo.copyFileSync(srcFd, dest)
      if (!fileIo.accessSync(dest)) {
        return 5
      }
      return 0
    } catch (error) {
      return 4
    } finally {
      if (srcFd >= 0) {
        try {
          fileIo.closeSync(srcFd)
        } catch (error) {
          // 忽略关闭失败
        }
      }
    }
  }

  // 原版 d.i：重命名（保留扩展名，目标重名则自动加序号），返回新文件名或 null
  rename(context: common.Context, oldName: string, newBase: string): string | null {
    if (oldName === '' || newBase === '') {
      return null
    }
    const dir = this.dir(context)
    const oldPath = `${dir}/${oldName}`
    if (!fileIo.accessSync(oldPath)) {
      return null
    }
    const dot = oldName.lastIndexOf('.')
    const ext = dot > 0 ? `.${oldName.substring(dot + 1)}` : ''
    let target = `${newBase}${ext}`
    // 原版 c1.K：目标重名时追加 (1)/(2)…
    let seq = 0
    while (target !== oldName && fileIo.accessSync(`${dir}/${target}`)) {
      seq = seq + 1
      target = `${newBase}(${seq})${ext}`
    }
    try {
      fileIo.renameSync(oldPath, `${dir}/${target}`)
      if (AppSettings.getInstance().uiFont === oldName) {
        AppSettings.getInstance().setUiFont(target)
      }
      return target
    } catch (error) {
      return null
    }
  }

  // 原版 d.d：删除字体文件
  remove(context: common.Context, name: string): boolean {
    if (name === '') {
      return false
    }
    const path = `${this.dir(context)}/${name}`
    if (fileIo.accessSync(path)) {
      try {
        fileIo.unlinkSync(path)
        return true
      } catch (error) {
        return false
      }
    }
    return false
  }

  // 原版 d.f：读取字体字节用于 Web 拦截响应
  readBytes(context: common.Context, name: string): ArrayBuffer | null {
    const path = `${this.dir(context)}/${name}`
    if (!fileIo.accessSync(path)) {
      return null
    }
    try {
      const stat = fileIo.statSync(path)
      const file = fileIo.openSync(path, fileIo.OpenMode.READ_ONLY)
      try {
        const buf = new ArrayBuffer(stat.size)
        fileIo.readSync(file.fd, buf)
        return buf
      } finally {
        fileIo.closeSync(file)
      }
    } catch (error) {
      return null
    }
  }

  // 原版 l5.c.c：扩展名 → MIME，默认 font/ttf
  mimeOf(name: string): string {
    const ext = this.extOf(name)
    if (ext === 'otf') {
      return 'font/otf'
    }
    if (ext === 'woff') {
      return 'font/woff'
    }
    if (ext === 'woff2') {
      return 'font/woff2'
    }
    return 'font/ttf'
  }
}
