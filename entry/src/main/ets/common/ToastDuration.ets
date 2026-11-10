// Toast 时长统一常量。
// 原版 Android 用 Toast.LENGTH_SHORT / LENGTH_LONG 系统时长，鸿蒙 showToast 无对应量纲，
// 本工程按原版短/长两档取固定值：常规短提示 1500ms、长文案 2000ms、超长说明 2500ms。
export const TOAST_SHORT: number = 1500
export const TOAST_MEDIUM: number = 2000
export const TOAST_LONG: number = 2500
