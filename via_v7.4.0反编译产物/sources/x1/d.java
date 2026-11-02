package x1;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import w1.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13569a;

    public d(Context context) {
        this.f13569a = context;
    }

    public int a(String str) {
        return this.f13569a.checkCallingOrSelfPermission(str);
    }

    public ApplicationInfo b(String str, int i10) {
        return this.f13569a.getPackageManager().getApplicationInfo(str, i10);
    }

    public PackageInfo c(String str, int i10) {
        return this.f13569a.getPackageManager().getPackageInfo(str, i10);
    }

    public boolean d() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return b.a(this.f13569a);
        }
        if (!j.g() || (nameForUid = this.f13569a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f13569a.getPackageManager().isInstantApp(nameForUid);
    }

    public final boolean e(int i10, String str) {
        if (j.c()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f13569a.getSystemService("appops");
                if (appOpsManager == null) {
                    throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                }
                appOpsManager.checkPackage(i10, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f13569a.getPackageManager().getPackagesForUid(i10);
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
