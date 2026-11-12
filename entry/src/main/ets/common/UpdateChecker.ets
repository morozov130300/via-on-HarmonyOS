import { bundleManager } from '@kit.AbilityKit'
import { common, Want } from '@kit.AbilityKit'

// 豁免项11：检查更新改用华为应用市场官方接口——不再连 Via 原作者服务器拉版本 JSON。
// 应用市场内详情页自会显示本应用是否有新版本并提供更新入口；本端只负责拉起详情页。
export class UpdateChecker {
  // 拉起华为应用市场本应用详情页（ohos.want.action.appdetail +
  // store://appgallery.huawei.com/app/detail?id=<bundleName>，见 AppGallery Kit 文档）
  static async openAppGalleryDetail(context: common.UIAbilityContext): Promise<void> {
    const want: Want = {
      action: 'ohos.want.action.appdetail',
      uri: `store://appgallery.huawei.com/app/detail?id=${context.abilityInfo.bundleName}`
    }
    try {
      await context.startAbility(want)
    } catch (error) {
      console.error('open appgallery detail failed')
    }
  }

  static getLocalVersionCode(): number {
    try {
      const info = bundleManager.getBundleInfoForSelfSync(bundleManager.BundleFlag.GET_BUNDLE_INFO_DEFAULT)
      return info.versionCode
    } catch (error) {
      return 0
    }
  }
}
