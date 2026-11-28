package y1;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import x1.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14813a;

    public d(Context context) {
        this.f14813a = context;
    }

    public int a(String str) {
        return this.f14813a.checkCallingOrSelfPermission(str);
    }

    public ApplicationInfo b(String str, int i10) {
        return this.f14813a.getPackageManager().getApplicationInfo(str, i10);
    }

    public PackageInfo c(String str, int i10) {
        return this.f14813a.getPackageManager().getPackageInfo(str, i10);
    }

    public boolean d() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return b.a(this.f14813a);
        }
        if (!j.g() || (nameForUid = this.f14813a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f14813a.getPackageManager().isInstantApp(nameForUid);
    }

    public final boolean e(int i10, String str) {
        if (j.c()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f14813a.getSystemService("appops");
                if (appOpsManager == null) {
                    throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                }
                appOpsManager.checkPackage(i10, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f14813a.getPackageManager().getPackagesForUid(i10);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
