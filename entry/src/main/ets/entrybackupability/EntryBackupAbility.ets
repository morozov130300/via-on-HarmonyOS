import { BackupExtensionAbility, BundleVersion } from '@kit.CoreFileKit';
import Logger from '../common/Logger'


export default class EntryBackupAbility extends BackupExtensionAbility {
  async onBackup() {
    Logger.info('testTag', 'onBackup ok');
    await Promise.resolve();
  }

  async onRestore(bundleVersion: BundleVersion) {
    Logger.info('testTag', 'onRestore ok', JSON.stringify(bundleVersion));
    await Promise.resolve();
  }
}