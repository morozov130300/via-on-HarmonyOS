import { fileIo } from '@kit.CoreFileKit'
import { common, Want } from '@kit.AbilityKit'
import { zlib } from '@kit.BasicServicesKit'
import { AppSettings } from './Settings'

// 皮肤条目：name = 皮肤目录名（默认项为空字符串），mtime = 目录最后修改时间
export class SkinEntry {
  name: string
  mtime: number

  constructor(name: string, mtime: number) {
    this.name = name
    this.mtime = mtime
  }
}

// 原版 lb/mb 包：皮肤仓库（skins 目录，皮肤 = 含 ic_*.png 的目录，按修改时间倒序）
// mb.b.g()：列出 skins 下所有目录，按 lastModified 降序（mb.a 比较器）
// lb.k.h3：导入 = 解压 zip 到 skins/<去扩展名文件名>，源文件 ≤ 12582912 字节（12MB）
// lb.a.a()：图标查询 = 当前皮肤目录下 <name>.png（仅 ic_ 前缀），96x96 位图
export class SkinStore {
  private static instance: SkinStore | null = null

  private constructor() {
  }

  static getInstance(): SkinStore {
    if (SkinStore.instance === null) {
      SkinStore.instance = new SkinStore()
    }
    return SkinStore.instance
  }

  // 原版 z8.c1.F：skins 根目录（外部私有目录不可用时回退 filesDir）
  dir(context: common.Context): string {
    return `${context.filesDir}/skins`
  }

  ensureDir(context: common.Context): void {
    const dir = this.dir(context)
    if (!fileIo.accessSync(dir)) {
      fileIo.mkdirSync(dir, true)
    }
  }

  // 原版 mb.b.g + mb.a：目录按 mtime 降序
  list(context: common.Context): SkinEntry[] {
    const result: SkinEntry[] = []
    const dir = this.dir(context)
    try {
      if (!fileIo.accessSync(dir)) {
        return result
      }
      const names = fileIo.listFileSync(dir)
      for (const name of names) {
        const path = `${dir}/${name}`
        try {
          const stat = fileIo.statSync(path)
          if (stat.isDirectory()) {
            result.push(new SkinEntry(name, stat.mtime))
          }
        } catch (error) {
          // Skip inaccessible entries.
        }
      }
    } catch (error) {
      return result
    }
    result.sort((a: SkinEntry, b: SkinEntry) => {
      if (a.mtime === b.mtime) {
        return 0
      }
      return a.mtime > b.mtime ? -1 : 1
    })
    return result
  }

  private hasSkinIcons(path: string): boolean {
    try {
      const names = fileIo.listFileSync(path)
      for (const name of names) {
        if (name.startsWith('ic_') && name.endsWith('.png')) {
          const iconPath = `${path}/${name}`
          if (fileIo.statSync(iconPath).isFile()) {
            return true
          }
        }
      }
    } catch (error) {
      return false
    }
    return false
  }

  private removeTree(path: string): boolean {
    try {
      const stat = fileIo.statSync(path)
      if (stat.isDirectory()) {
        const names = fileIo.listFileSync(path)
        for (const name of names) {
          if (!this.removeTree(`${path}/${name}`)) {
            return false
          }
        }
        fileIo.rmdirSync(path)
      } else {
        fileIo.unlinkSync(path)
      }
      return true
    } catch (error) {
      return false
    }
  }

  // 原版 mb.b.f/e：皮肤目录绝对路径
  skinPath(context: common.Context, name: string): string {
    return `${this.dir(context)}/${name}`
  }

  // 原版 lb.a.a/d：当前皮肤下 <iconName>.png 存在则返回绝对路径，否则 null
  // （原版仅 ic_ 前缀名走皮肤，96x96 解码）
  skinIconPath(context: common.Context, iconName: string): string | null {
    const skin = AppSettings.getInstance().skin
    if (skin === '' || iconName === '' || !iconName.startsWith('ic_')) {
      return null
    }
    const path = `${this.skinPath(context, skin)}/${iconName}.png`
    try {
      if (fileIo.accessSync(path)) {
        return path
      }
    } catch (error) {
      return null
    }
    return null
  }

  // 原版 lb.k.h3：导入皮肤（zip ≤ 12MB，解压到 skins/<去扩展名文件名>）
  // 返回 null = 失败（toast u.E7「加载皮肤失败」），否则返回新皮肤名
  importFromUri(context: common.Context, uri: string): Promise<string | null> {
    return new Promise<string | null>((resolve) => {
      const cleanUri = uri.split('?')[0].split('#')[0]
      let name = cleanUri.substring(cleanUri.lastIndexOf('/') + 1)
      try {
        name = decodeURIComponent(name)
      } catch (error) {
        // 保留原样
      }
      // 原版 b1.k + h3：取显示名，扩展名在末 5 字符内则去掉
      const dot = name.lastIndexOf('.')
      if (dot >= 0 && dot >= name.length - 5) {
        name = name.substring(0, dot)
      }
      if (name === '') {
        resolve(null)
        return
      }
      this.ensureDir(context)
      let srcFile: fileIo.File | null = null
      let tempZip = ''
      try {
        const srcStat = fileIo.statSync(uri)
        // 原版 j10 > 12582912 直接失败
        if (srcStat.size > 12582912) {
          resolve(null)
          return
        }
        srcFile = fileIo.openSync(uri, fileIo.OpenMode.READ_ONLY)
        tempZip = `${context.cacheDir}/skin_import_${Date.now()}.zip`
        fileIo.copyFileSync(srcFile.fd, tempZip)
      } catch (error) {
        if (srcFile !== null) {
          try {
            fileIo.closeSync(srcFile)
          } catch (closeError) {
            // 忽略
          }
        }
        resolve(null)
        return
      }
      try {
        if (srcFile !== null) {
          fileIo.closeSync(srcFile)
        }
      } catch (error) {
        // 忽略
      }
      const importDir = `${this.dir(context)}/.skin_import_${Date.now()}`
      const destDir = this.skinPath(context, name)
      zlib.decompressFile(tempZip, importDir).then(() => {
        try {
          fileIo.unlinkSync(tempZip)
        } catch (error) {
          // Ignore temporary archive cleanup failures.
        }
        if (!this.hasSkinIcons(importDir)) {
          this.removeTree(importDir)
          resolve(null)
          return
        }
        const backupDir = `${this.dir(context)}/.skin_backup_${Date.now()}`
        let hasBackup = false
        try {
          if (fileIo.accessSync(destDir)) {
            fileIo.renameSync(destDir, backupDir)
            hasBackup = true
          }
          fileIo.renameSync(importDir, destDir)
          if (hasBackup) {
            this.removeTree(backupDir)
          }
          resolve(name)
        } catch (error) {
          if (hasBackup) {
            try {
              fileIo.renameSync(backupDir, destDir)
            } catch (restoreError) {
              // Preserve the backup when restoration fails.
            }
          }
          this.removeTree(importDir)
          resolve(null)
        }
      }).catch(() => {
        try {
          fileIo.unlinkSync(tempZip)
        } catch (error) {
          // Ignore temporary archive cleanup failures.
        }
        this.removeTree(importDir)
        resolve(null)
      })
    })
  }

  // 原版 mb.b.d/e：递归删除皮肤目录
  remove(context: common.Context, name: string): boolean {
    if (name === '') {
      return false
    }
    return this.removeTree(this.skinPath(context, name))
  }

  // 原版 z8.f.k：冷重启应用（makeRestartActivityTask + System.exit）
  // 鸿蒙等效：先 startAbility 拉起新实例，再 terminateSelf 结束旧实例
  restartApp(context: common.UIAbilityContext): void {
    const want: Want = {
      bundleName: context.abilityInfo.bundleName,
      abilityName: context.abilityInfo.name
    }
    context.startAbility(want).then(() => {
      context.terminateSelf().catch(() => {
      })
    }).catch(() => {
    })
  }
}
