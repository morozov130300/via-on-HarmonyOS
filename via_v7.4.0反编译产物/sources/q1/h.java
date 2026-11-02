package q1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public static h f11249c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11250a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f11251b;

    public h(Context context) {
        this.f11250a = context.getApplicationContext();
    }

    public static h a(Context context) {
        t1.f.h(context);
        synchronized (h.class) {
            try {
                if (f11249c == null) {
                    v.d(context);
                    f11249c = new h(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f11249c;
    }

    public static final r d(PackageInfo packageInfo, r... rVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        s sVar = new s(packageInfo.signatures[0].toByteArray());
        for (int i10 = 0; i10 < rVarArr.length; i10++) {
            if (rVarArr[i10].equals(sVar)) {
                return rVarArr[i10];
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z10) {
        if (z10 && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z10 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z10 ? d(packageInfo, u.f11260a) : d(packageInfo, u.f11260a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (g.b(this.f11250a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i10) throws PackageManager.NameNotFoundException {
        c0 c0VarC;
        int length;
        String[] packagesForUid = this.f11250a.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c0VarC = null;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    t1.f.h(c0VarC);
                    break;
                }
                c0VarC = f(packagesForUid[i11], false, false);
                if (c0VarC.f11240a) {
                    break;
                }
                i11++;
            }
        } else {
            c0VarC = c0.c("no pkgs");
        }
        c0VarC.e();
        return c0VarC.f11240a;
    }

    public final c0 f(String str, boolean z10, boolean z11) throws PackageManager.NameNotFoundException {
        c0 c0VarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return c0.c("null pkg");
        }
        if (str.equals(this.f11251b)) {
            return c0.b();
        }
        if (v.e()) {
            c0VarC = v.b(str, g.b(this.f11250a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f11250a.getPackageManager().getPackageInfo(str, 64);
                boolean zB = g.b(this.f11250a);
                if (packageInfo == null) {
                    c0VarC = c0.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        c0VarC = c0.c("single cert required");
                    } else {
                        s sVar = new s(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        c0 c0VarA = v.a(str2, sVar, zB, false);
                        c0VarC = (!c0VarA.f11240a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !v.a(str2, sVar, false, true).f11240a) ? c0VarA : c0.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e10) {
                return c0.d("no pkg ".concat(str), e10);
            }
        }
        if (c0VarC.f11240a) {
            this.f11251b = str;
        }
        return c0VarC;
    }
}
