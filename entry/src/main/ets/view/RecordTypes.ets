// 原版 bb\i.java（RecordContainerFragment）容器与三个子页之间的契约。
//
// 原版返回链路：o8\h.java V2()/bb\i.k3() → 当前子 Fragment 实现 bb\i.c 的 W()/l()，
// 子页「已消费返回」（退出多选、回上级文件夹、清空搜索等）时容器不 pop，
// 否则 N0().e1() 弹出整个容器。ArkUI 里 Tabs 的子 TabContent 不是 NavDestination，
// 拿不到 .onBackPressed，故由子页把「返回拦截」注册进 controller，容器统一分发。
//
// 注意：三个子页共用同一个 controller 实例，单 handler 字段会被最后注册的子页
// 覆盖（原版语义是容器只问「当前子 Fragment」），故按标签索引存取。
export class RecordBackController {
  // 各子页按标签位注册的返回拦截（0=书签 1=历史 2=离线页面）
  handlers: Map<number, () => boolean> = new Map()
  // 当前标签索引，由容器页 onReady/onChange 回写
  activeIndex: number = 0

  // true = 当前子页已消费本次返回（退出多选/清搜索/回上级文件夹），容器不得 pop
  handle(): boolean {
    const handler = this.handlers.get(this.activeIndex)
    return handler === undefined ? false : handler()
  }

  // 子页向路由栈压入新页（closedTabs / pdfViewer 等），经容器页的 NavPathStack 执行
  navPathStack: NavPathStack | null = null

  pushPage(name: string, param: string): void {
    if (this.navPathStack !== null) {
      this.navPathStack.pushPathByName(name, param, true)
    }
  }
}
