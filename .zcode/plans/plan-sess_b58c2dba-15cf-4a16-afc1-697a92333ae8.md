## Context

对齐原版 Via 的「设置内搜索」：原版（真机版本）设置页最上方有搜索框，可搜索设置条目。经核查，现有 7.4.0 反编译产物中该功能未接线（工具栏搜索 API 为死代码，classes.dex 原始字节已复核仅有 2 处 SearchView 字符串引用），官方开源仓库只有资源无源码；因此以真机行为为基准自实现，交互尽量贴近原版：设置首页顶部常驻「搜索」输入框，输入后列表切换为匹配的设置条目结果，点击结果跳到对应设置子页。

## 实现方案

### 1. 设置条目集中索引（新文件 `entry/src/main/ets/common/SettingsSearchIndex.ets`）
- 定义 `SettingsIndexEntry { label: string; desc?: string; route: string }`，label/desc 为**运行时解析后的文案**。
- 覆盖全部设置子页条目：以 `components/SettingRows.ets` 的 `SettingNavRow/SettingCheckRow`（及其自定义 UI 页的关键条目）逐页梳理，条目→路由名映射从各页 `onTapRow` 内联闭包中提取（如 `settingsSearch`、`settingsSearchToolbar`、`settingsToolbar` 等已注册路由）。
- 提供同步查询接口 `searchSettingsEntries(keyword: string): SettingsIndexEntry[]`：大小写不敏感的 includes 匹配 label 与 desc。

### 2. 文案解析
- `$r('app.string.*')` 资源引用用 `getContext().resourceManager.getStringSync(resId)` 解析为当前语言文案再匹配；硬编码中文字符串直接匹配。索引在进入设置页时构建（文案随系统语言变化），不做持久化。

### 3. 设置首页搜索框（修改 `entry/src/main/ets/view/SettingsPage.ets`）
- 顶部加 TextInput（hint 用原版 `search_hint` 文案「搜索」，样式与页面一致）。
- 无输入时显示原有 7 个分类行；有输入时列表切换为 `searchSettingsEntries` 结果（复用 SettingNavRow 样式展示 label，desc 作副标题）；结果为空显示空态。
- 点击结果 `pushPathByName(route)` 跳到对应设置子页；搜索词在返回后保留与否不做特殊处理（清空恢复分类列表）。
- 子页内不做高亮定位（原版行为未取证，不加猜测性扩展）。

## 关键文件
- 新增：`entry/src/main/ets/common/SettingsSearchIndex.ets`
- 修改：`entry/src/main/ets/view/SettingsPage.ets`
- 参考（只读梳理条目）：`entry/src/main/ets/components/SettingRows.ets`、各 `view/Settings*.ets`

## 版本号
按记忆规范：versionCode 8 位定长（版本名段拼接 + 功能序号 +1），versionName 同步更新。

## 验证
1. devecocli 编译通过。
2. 编译通过后即报告停手；真机效果（搜索匹配、点击跳转）由用户验证。