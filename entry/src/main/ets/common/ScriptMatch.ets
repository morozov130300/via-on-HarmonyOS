import { UserScriptRec, parseJsonArray, globMatches } from './Types'

// 原版 r5/d.java v(String)：排除规则不命中且任一匹配规则命中
export function scriptMatchesUrl(script: UserScriptRec, url: string): boolean {
  const excludes = parseJsonArray(script.excludes)
  for (let j = 0; j < excludes.length; j++) {
    if (globMatches(excludes[j], url)) {
      return false
    }
  }
  const includes = parseJsonArray(script.includes)
  for (let j = 0; j < includes.length; j++) {
    if (globMatches(includes[j], url)) {
      return true
    }
  }
  return false
}

// 原版 p5/a.java C(String)：任一持久化脚本（id>=0）匹配规则命中该网址（不筛启用位）
export function scriptPatternMatches(url: string, scripts: UserScriptRec[]): boolean {
  if (url === '') {
    return false
  }
  for (let i = 0; i < scripts.length; i++) {
    const script = scripts[i]
    if (script.id >= 0 && scriptMatchesUrl(script, url)) {
      return true
    }
  }
  return false
}
