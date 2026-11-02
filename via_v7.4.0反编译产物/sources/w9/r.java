package w9;

import android.content.pm.PackageInfo;
import android.os.Build;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public String f13382a;

    /* renamed from: b, reason: collision with root package name */
    public String f13383b;

    /* renamed from: c, reason: collision with root package name */
    public long f13384c;

    /* renamed from: d, reason: collision with root package name */
    public int f13385d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13386e;

    public r() {
        this(null, null, 0L, 0);
    }

    public r(String str, String str2, long j10, int i10) {
        this.f13382a = str;
        this.f13383b = str2;
        this.f13384c = j10;
        this.f13385d = i10;
        this.f13386e = Build.VERSION.SDK_INT >= 29;
    }

    public static r a(PackageInfo packageInfo) throws NumberFormatException {
        int i10;
        if (packageInfo == null) {
            return new r();
        }
        int iIndexOf = packageInfo.versionName.indexOf(46);
        if (iIndexOf > 0) {
            try {
                i10 = Integer.parseInt(packageInfo.versionName.substring(0, iIndexOf));
            } catch (NumberFormatException e10) {
                pc.a.i(e10);
            }
        } else {
            i10 = 0;
        }
        return new r(packageInfo.packageName, packageInfo.versionName, Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode, i10);
    }

    public int b() {
        return this.f13385d;
    }

    public String c() {
        return this.f13382a;
    }

    public long d() {
        return this.f13384c;
    }

    public String e() {
        return this.f13383b;
    }

    public boolean f() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        String str = this.f13382a;
        return str == null || str.isEmpty();
    }

    public boolean g() {
        return Build.VERSION.SDK_INT >= 29 || this.f13385d >= 76;
    }

    public boolean h() {
        return this.f13386e;
    }

    public String toString() {
        return "WebViewProvider{packageName='" + this.f13382a + "', versionName='" + this.f13383b + "', versionCode=" + this.f13384c + ", majorVersion=" + this.f13385d + ", forceDarkAvailable=" + this.f13386e + '}';
    }
}
