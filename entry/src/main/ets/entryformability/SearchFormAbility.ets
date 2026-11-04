// 原版 mark/via/widget/SearchWidgetProvider.java + TransparentSearchWidgetProvider.java：
// 两个桌面搜索小部件共用的卡片扩展（鸿蒙 Form Kit 单 FormExtensionAbility 承载多卡片，
// 由 resources/base/profile/form_config.json 的 forms 数组区分「搜索框/透明搜索框」两张卡片）
import { FormExtensionAbility, formBindingData } from '@kit.FormKit'
import { Want } from '@kit.AbilityKit'

export default class SearchFormAbility extends FormExtensionAbility {
  // 原版 onUpdate：仅绑定点击 PendingIntent（mark.via.SEARCH），无动态数据刷新；
  // 鸿蒙侧卡片为静态卡片（isDynamic: false），点击交互由卡片页面 FormLink(router) 承担
  onAddForm(want: Want): formBindingData.FormBindingData {
    return formBindingData.createFormBindingData({})
  }
}
