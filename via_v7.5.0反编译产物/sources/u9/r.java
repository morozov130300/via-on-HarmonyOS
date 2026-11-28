package u9;

import android.content.pm.PackageInfo;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12938e;

    public r() {
        this(null, null, 0L, 0);
    }

    public static r a(PackageInfo packageInfo) {
        int i10;
        if (packageInfo == null) {
            return new r();
        }
        int iIndexOf = packageInfo.versionName.indexOf(46);
        if (iIndexOf > 0) {
            try {
                i10 = Integer.parseInt(packageInfo.versionName.substring(0, iIndexOf));
            } catch (NumberFormatException e10) {
                tc.a.j(e10);
                i10 = 0;
            }
        } else {
            i10 = 0;
        }
        return new r(packageInfo.packageName, packageInfo.versionName, Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode, i10);
    }

    public int b() {
        return this.f12937d;
    }

    public String c() {
        return this.f12934a;
    }

    public long d() {
        return this.f12936c;
    }

    public String e() {
        return this.f12935b;
    }

    public boolean f() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        String str = this.f12934a;
        return str == null || str.isEmpty();
    }

    public boolean g() {
        return Build.VERSION.SDK_INT >= 29 || this.f12937d >= 76;
    }

    public boolean h() {
        return this.f12938e;
    }

    public String toString() {
        return "WebViewProvider{packageName='" + this.f12934a + "', versionName='" + this.f12935b + "', versionCode=" + this.f12936c + ", majorVersion=" + this.f12937d + ", forceDarkAvailable=" + this.f12938e + '}';
    }

    public r(String str, String str2, long j10, int i10) {
        this.f12934a = str;
        this.f12935b = str2;
        this.f12936c = j10;
        this.f12937d = i10;
        this.f12938e = Build.VERSION.SDK_INT >= 29;
    }
}
