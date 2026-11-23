// 公开仓同步：取 main 的树，剔除敏感路径，生成提交并推送到 public/main
const { execFileSync } = require('child_process')
const fs = require('fs')
const path = require('path')

const SENSITIVE_EXACT = ['.env', 'AGENTS.md', 'build-profile.json5', 'local.properties']
const SENSITIVE_DIRS = ['signing/']

function git(args, opts) {
  return execFileSync('git', args, Object.assign({ maxBuffer: 1 << 28 }, opts || {}))
}

const gitDir = git(['rev-parse', '--git-dir']).toString().trim()
const idx = path.resolve(gitDir, 'uc-mirror.index')
try { fs.unlinkSync(idx) } catch (e) {}

const env = Object.assign({}, process.env, { GIT_INDEX_FILE: idx })
const all = git(['ls-tree', '-r', '-z', '--name-only', 'main']).toString('utf8').split('\0').filter(Boolean)
const drop = all.filter(p =>
  SENSITIVE_EXACT.indexOf(p) >= 0 || SENSITIVE_DIRS.some(d => p === d.slice(0, -1) || p.startsWith(d))
)

if (drop.length === 0) {
  console.log('[public-sync] 无需剔除文件')
} else {
  git(['read-tree', 'main'], { env })
  git(['update-index', '--force-remove', '--stdin'], { env, input: drop.join('\n') })
}
const tree = git(['write-tree'], { env }).toString().trim()
try { fs.unlinkSync(idx) } catch (e) {}

const parent = git(['rev-parse', 'public/main']).toString().trim()
const parentTree = git(['rev-parse', parent + '^{tree}']).toString().trim()
if (tree === parentTree) {
  console.log('[public-sync] 公开内容无变化，跳过')
  process.exit(0)
}

const subject = git(['log', '-1', '--format=%s', 'main']).toString().trim()
const msg = subject + '\n\n同步自私有主仓库 ' + git(['rev-parse', '--short', 'main']).toString().trim()
const commit = git(['commit-tree', tree, '-p', parent], { input: msg }).toString().trim()
git(['push', 'public', commit + ':main'], { stdio: 'inherit' })
console.log('[public-sync] 已推送 ' + commit.slice(0, 7) + ' 到 public/main（剔除 ' + drop.length + ' 个敏感文件）')
