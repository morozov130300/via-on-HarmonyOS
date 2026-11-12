// 原版 bb\i.java（RecordContainerFragment）容器与三个子页之间的契约。
//
// 原版返回链路：o8\h.java V2()/bb\i.k3() → 当前子 Fragment 实现 bb\i.c 的 W()/l()，
// 子页「已消费返回」（退出多选、回上级文件夹、清空搜索等）时容器不 pop，
// 否则 N0().e1() 弹出整个容器。ArkUI 里 Tabs 的子 TabContent 不是 NavDestination，
// 拿不到 .onBackPressed，故由子页把「返回拦截」注册进 controller，容器统一分发。
export class RecordBackController {
  handler: (() => boolean) | null = null

  // true = 子页已消费本次返回，容器不得 pop
  handle(): boolean {
    return this.handler === null ? false : this.handler()
  }
}
