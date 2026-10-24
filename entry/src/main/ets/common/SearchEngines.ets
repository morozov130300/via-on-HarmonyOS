export class SearchEngineDef {
  key: string
  name: string
  template: string

  constructor(key: string, name: string, template: string) {
    this.key = key
    this.name = name
    this.template = template
  }
}

export const SEARCH_ENGINES: SearchEngineDef[] = [
  new SearchEngineDef('baidu', '百度', 'https://www.baidu.com/s?wd=%s'),
  new SearchEngineDef('bing', '必应', 'https://www.bing.com/search?q=%s'),
  new SearchEngineDef('sogou', '搜狗', 'https://www.sogou.com/web?query=%s'),
  new SearchEngineDef('so360', '360搜索', 'https://www.so.com/s?q=%s'),
  new SearchEngineDef('shenma', '神马', 'https://m.sm.cn/s?q=%s'),
  new SearchEngineDef('quark', '夸克', 'https://quark.sm.cn/s?q=%s'),
  new SearchEngineDef('google', 'Google', 'https://www.google.com/search?q=%s')
]

export function findEngine(key: string): SearchEngineDef {
  const found = SEARCH_ENGINES.find((engine: SearchEngineDef): boolean => engine.key === key)
  if (found !== undefined) {
    return found
  }
  return SEARCH_ENGINES[0]
}

export function buildSearchUrl(engineKey: string, customTemplate: string, query: string): string {
  const encoded = encodeURIComponent(query)
  if (engineKey === 'custom' && customTemplate !== '') {
    return customTemplate.replace('%s', encoded)
  }
  const engine = findEngine(engineKey)
  return engine.template.replace('%s', encoded)
}

export function isUrlLike(input: string): boolean {
  const text = input.trim()
  if (text === '') {
    return false
  }
  if (text.indexOf(' ') >= 0) {
    return false
  }
  if (text.startsWith('http://') || text.startsWith('https://') || text.startsWith('file://')) {
    return true
  }
  const dotIndex = text.indexOf('.')
  if (dotIndex <= 0 || dotIndex === text.length - 1) {
    return false
  }
  if (!/^[\w.-]+(\:[0-9]+)?([\/?#].*)?$/.test(text)) {
    return false
  }
  return true
}

export function normalizeUrl(input: string): string {
  const text = input.trim()
  if (text.startsWith('http://') || text.startsWith('https://') || text.startsWith('file://')) {
    return text
  }
  return 'https://' + text
}

export function hostOf(url: string): string {
  let rest = url
  const schemeIndex = rest.indexOf('://')
  if (schemeIndex >= 0) {
    rest = rest.substring(schemeIndex + 3)
  }
  const slashIndex = rest.indexOf('/')
  if (slashIndex >= 0) {
    rest = rest.substring(0, slashIndex)
  }
  const atIndex = rest.lastIndexOf('@')
  if (atIndex >= 0) {
    rest = rest.substring(atIndex + 1)
  }
  const colonIndex = rest.indexOf(':')
  if (colonIndex >= 0) {
    rest = rest.substring(0, colonIndex)
  }
  return rest.toLowerCase()
}
