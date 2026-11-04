# VIA 鸿蒙移植：无法实现与差异存根

> 更新：2026-11-04。对照基准：Via 7.4.0（`via_v7.4.0反编译产物/`）。
> 本文档收录鸿蒙平台**确实无法 1:1 实现**的内容与已确认的功能性差异。其余功能均已按原版 1:1 移植。

## 一、平台能力缺失（鸿蒙无对应 API，docs 已查证）

| 功能 | 原版实现 | 鸿蒙现状 | 查证结论 |
|---|---|---|---|
| 表单数据清理（退出清除第 2 位） | WebView 表单自动填充数据清理 | 勾选后不清理（WebDataBase 仅 HTTP 认证凭据，无表单填充数据 API） | ArkWeb WebDataBase 文档 |
| 文本选取搜索（PROCESS_TEXT）、WEB_SEARCH | mark.via.Search 注册系统文本选取菜单 | 无入口；仅保留系统分享（sendData）接收文本→搜索 | 鸿蒙无第三方文本选取处理注册机制 |
| NFC NDEF 分发 | Trampoline NDEF 分支 | 无 | 鸿蒙无应用级 TAG 分发 |
| saveWebArchive（.mht 存档） | WebView saveWebArchive | 降级：JS 序列化单文件 HTML（canvas 内联 dataURL + outerHTML），外部 CSS/JS 仍引 URL | ArkWeb 无该 API |
| socks 代理隧道 | ProxySelector 按 scheme 原样设置 | setAppHttpProxy 仅 HTTP host/port；socks:// 解析为 host:port 传入，隧道不保证 | @ohos.net.connection 文档 |
| 反向代理模式（Reverse bypass，仅指定域走代理） | WebView PROXY_OVERRIDE_REVERSE_BYPASS 特性 | 无法表达，恒按普通 bypass（排除）模式；配置项仍完整读写（备份互通） | exclusionList 仅排除语义 |
| 系统级文本选中文本翻译弹窗（via://translator/PROCESS_TEXT 路径） | k6.Eb→f8.w0 | via://translator/translate 命令 no-op | 依赖 PROCESS_TEXT，鸿蒙缺失 |
| 通知 icon 字段 | 前台通知小图标/按钮图标 | 通知按钮无 icon 字段（仅文本），通知小图标用应用图标 | NotificationKit 无该字段 |
| 透明卡片背板 | 透明搜索小部件（xml/i） | 布局 1:1 但真透明需 API 22 `transparencyEnabled` + AGC「背板透明卡片」开放能力申请（手动签名、审批 1-3 工作日），未开启 | Form Kit 文档 |
| layer-list 快捷方式图标 | xml/g 静态快捷方式 oval+inset 双层图标 | 按原版定义 1:1 栅格化为单 PNG（鸿蒙 shortcut icon 仅支持单 media 资源） | shortcuts_config 规范 |
| 桌面小部件 4×1 规格 | appwidget 4×1（minWidth 220dp/40dp） | 选 1*2 最接近横向条形卡；无 previewImage 机制（画廊实时渲染） | Form Kit 无 4×1 规格 |
| 通知点击打开已下载文件 | 完成态点通知直接开文件 | 跳下载页（通知体 want 无法直接打开沙箱文件） | Want 无法跨应用开沙箱文件 |

## 二、系统能力限制（可用但行为受限）

| 功能 | 原版 | 鸿蒙限制 |
|---|---|---|
| TTS 语速 | SeekBar 0.25x–3.5x（max13 step0.25） | UI 滑条 1:1 保留；系统 TTS 实际语速被限制在 [0.5, 2] |
| Web 下载通道 | DownloadManager 统一下载 | WebView 触发下载仅能走 WebDownloadDelegate；「下载链接」/新建/重下已切自研分块引擎（8 线程、断点续传、并发 3、状态机 1:1） |
| HTTP 重定向最终 URL | 手动跟随重定向可获 final URL | 鸿蒙 http 自动跟随，final URL 不可得；探测改用 Range: bytes=0-0（206/200 判定可续传） |
| 下载进度通知（无 Content-Length） | 不显示进度条 | progressValue 传 0 |
| 外置视频播放器 | 枚举第三方播放器（ADM/1DM 等）打开 | 无法枚举第三方播放器，降级为「关闭/系统分享」（待拍板定性） |

## 三、用户已拍板的豁免项（2026-11-01 确认）

| 项 | 决策 |
|---|---|
| 密码管理器 | 不建原版五项子页面，点击弹系统密码保险箱说明框 |
| 导出数据「保存的密码」 | 保留选项，导出空密码库 |
| 备份 ZIP 设置位 | 安卓键名(w9.l)↔鸿蒙键名(SYNC_KEYS) 映射互通 |
| APK 自装（应用内更新） | 不移植下载/MD5/安装；检查更新→changelog 弹窗→跳应用市场详情页 |
| CustomTabs | 豁免 |
| 画中画/PiP | 豁免 |
| 云备份 | 不要求与原版一致 |
| 反向屏幕方向 | 塌缩处理 |

## 四、已确认的功能性差异（实现载体不同，行为对齐）

| 功能 | 原版载体 | 鸿蒙载体 |
|---|---|---|
| PDF 渲染 | PdfRenderer 自绘（3 线程池+LruCache） | PDF Kit PdfView 系统渲染（分页/缩放/连续滚动等价） |
| file:// PDF 打开 | za.g Activity | TabWeb 内全屏覆盖层（Index 拿不到导航栈的必要取舍，视觉/交互一致） |
| 网页脚本页（ua.y） | Fragment+ViewPager 双 tab（脚本/GM 命令） | 单列表 + 行点击 ActionSheet 执行 GM 命令 |
| 脚本编辑器「+」 | sa.o 纯代码输入+帮助长文弹窗 | 复用 ScriptEditOverlay 四字段编辑器；帮助/Metadata 块弹窗未复刻 |
| 下载文件预分配 | RandomAccessFile.setLength | 稀疏写（offset 定位），行为等价 |
| 下载完成通知点击 | 打开文件 | 跳下载页（见一） |
| 空下载列表 tab 行 | 隐藏 tab 行 | tab 行恒显（仅空文本时） |
| 网页脚本图标 | 原版 c_.png/de.png | 字节原样复制（via_offline_glyph_*） |
| 全局搜索小部件搜索 | PendingInten mark.via.SEARCH | FormLink router → via://search 命令管线 |
| 主页朗读 | — | 原生 HomePage 无 WebView，朗读时 toast 提示无法朗读 |
| 朗读面板「设置」入口 | 跳系统 TTS 设置 | 暂为暂停/恢复切换（系统 TTS 设置页跳转待定） |

## 五、settings.txt 互通未映射键（原版可选导出，我方无对应存储/载体，导入丢弃不破坏互操作）

`taghome`、`searchshortcuts`、`bookmarksviewmode`、`bookmarksorder`、`version`（内部 data_version）、`favinfo`、`logoinfo2`、`searchinfo`、`custominfo`、`urlbox`、`appui2`、`logochioce`、`urlbarcolor`、`fab`、`fableftaction`、`fabrightaction`、`fabupaction`、`fabdownaction`（标签主页/搜索快捷串/主页旧 UI 定制族）、`updater_scripts`（脚本更新时间戳，功能本身未做）。其余 w9/i.java 白名单键已全量映射（含 Base64 编码的 csstheme/readercustomcss、菜单数字 id↔字符串 id 39 项映射 displayedmenus/hiddenmenus）。

## 六、已修复复核缺口记录（2026-11-04）

- 菜单「广告拦截」点击=切换开关/长按=规则页（k6.O9/P9 case28 1:1）✅
- settings.txt 补映射 12+ 键 ✅
- via://scanner 接扫码（k6.u 8624）✅
- via://bookmarks folder 参数 + folder:// 深链 ✅
- via://tabs/restore 按 id 恢复存活标签 ✅（限制：SavedTab 无 id，已关闭标签无法按 id 复活，仅命中存活标签；原版从 tabs DB 按 id 查）
- 澄清：原版 ReadAloudService 无 MediaSession，AVSession 非对齐需求，不做

## 七、待拍板/待验证

| 项 | 状态 |
|---|---|
| 外置视频播放器降级定性（豁免 or 保留降级） | 待用户拍板 |
| AGENTS.md 列名差异逐项录屏验真（网站设定顺序、菜单动画参数、阅读模式副标题/预览卡、主页定制卡片化、通用设置紧凑弹窗等） | 待验证授权 |
| AGENTS.md 其余列名差异（搜索建议浮动卡片、夜间滤镜弹窗、AI 设置行等） | 已实现带原版引用注释，待录屏核对 |
| 透明卡片背板 AGC 开放能力申请 | 待用户决定是否申请 |
| via://bookmarks folder 参数、via://scanner、via://tabs/restore | 命令已解析，落地受限于书签文件夹路由/无扫码功能/TabStore 无按 id 恢复入口（与既有 no-op 决策一致） |
