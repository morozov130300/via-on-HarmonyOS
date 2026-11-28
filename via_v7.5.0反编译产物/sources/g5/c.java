package g5;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5525e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5527g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f5530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Uri f5531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f5532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f5533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f5536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Throwable f5537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f5538r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f5539s;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5526f = 90;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5528h = 1;

    public void A(String str) {
        this.f5536p = str;
    }

    public void B(Throwable th) {
        this.f5537q = th;
    }

    public void C(Uri uri) {
        this.f5531k = uri;
        this.f5532l = uri == null ? null : uri.toString();
    }

    public void D(String str) {
        this.f5532l = str;
        try {
            this.f5531k = Uri.parse(str);
        } catch (Exception unused) {
        }
    }

    public void E(int i10) {
        this.f5535o = i10;
    }

    public void F(boolean z10) {
        if (z10) {
            this.f5535o |= 2;
        } else {
            this.f5535o &= -3;
        }
    }

    public void G(Map map) {
        this.f5533m = map;
    }

    public void H(long j10) {
        this.f5521a = j10;
    }

    public void I(boolean z10) {
        if (z10) {
            this.f5535o |= 8;
        } else {
            this.f5535o &= -9;
        }
    }

    public void J(String str) {
        this.f5530j = str;
    }

    public void K(String str) {
        this.f5522b = str;
    }

    public void L(String str) {
        this.f5529i = str;
    }

    public void M(int i10) {
        this.f5534n = i10;
    }

    public void N(String str) {
        if (this.f5533m == null) {
            if (str == null || str.isEmpty()) {
                return;
            } else {
                this.f5533m = new HashMap();
            }
        }
        this.f5533m.remove("Referer");
        this.f5533m.remove("referer");
        if (str != null && !str.isEmpty()) {
            this.f5533m.put("Referer", str);
        }
        if (this.f5533m.isEmpty()) {
            this.f5533m = null;
        }
    }

    public void O(boolean z10) {
        if (z10) {
            this.f5535o |= 1;
        } else {
            this.f5535o &= -2;
        }
    }

    public void P(long j10) {
        this.f5525e = j10;
    }

    public void Q(int i10) {
        this.f5526f = i10;
    }

    public void R(long j10) {
        if (j10 <= 0) {
            O(false);
        }
        this.f5524d = j10;
    }

    public void S(long j10) {
        this.f5539s = j10;
    }

    public void T(String str) {
        this.f5527g = str;
    }

    public void U(boolean z10) {
        if (z10) {
            this.f5535o |= 16;
        } else {
            this.f5535o &= -17;
        }
    }

    public boolean V() {
        return (this.f5535o & 4) == 4;
    }

    public boolean W() {
        return (this.f5535o & 8) != 0;
    }

    public boolean X() {
        return (this.f5535o & 16) != 0;
    }

    public int a() {
        return this.f5528h;
    }

    public long b() {
        return this.f5538r;
    }

    public long c() {
        return this.f5523c;
    }

    public String d() {
        return this.f5536p;
    }

    public Throwable e() {
        return this.f5537q;
    }

    public Uri f() {
        return this.f5531k;
    }

    public String g() {
        return this.f5532l;
    }

    public int h() {
        return this.f5535o;
    }

    public Map i() {
        return this.f5533m;
    }

    public long j() {
        return this.f5521a;
    }

    public String k() {
        return this.f5530j;
    }

    public String l() {
        return this.f5522b;
    }

    public String m() {
        return this.f5529i;
    }

    public int n() {
        return this.f5534n;
    }

    public String o() {
        Map map = this.f5533m;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Referer");
        return str == null ? (String) this.f5533m.get("referer") : str;
    }

    public long p() {
        return this.f5525e;
    }

    public int q() {
        return this.f5526f;
    }

    public long r() {
        return this.f5524d;
    }

    public long s() {
        return this.f5539s;
    }

    public String t() {
        return this.f5527g;
    }

    public String toString() {
        return "DownloadTask{id=" + this.f5521a + ", name='" + this.f5522b + "', downloadedSize=" + this.f5523c + ", totalSize=" + this.f5524d + ", speed=" + this.f5525e + ", status=" + this.f5526f + ", url='" + this.f5527g + "', chunks=" + this.f5528h + ", path='" + this.f5529i + "', mimeType='" + this.f5530j + "', fileUri=" + this.f5531k + ", headers='" + this.f5533m + "', priority=" + this.f5534n + ", flags=" + this.f5535o + ", createdAt=" + this.f5538r + ", updatedAt=" + this.f5539s + '}';
    }

    public boolean u() {
        return (this.f5535o & 2) == 2;
    }

    public boolean v() {
        return (this.f5535o & 1) == 1;
    }

    public void w(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (str2 == null && this.f5533m == null) {
            return;
        }
        if (this.f5533m == null) {
            this.f5533m = new HashMap();
        }
        if (str2 == null) {
            this.f5533m.remove(str);
        } else {
            this.f5533m.put(str, str2);
        }
        if (this.f5533m.isEmpty()) {
            this.f5533m = null;
        }
    }

    public void x(int i10) {
        this.f5528h = i10;
    }

    public void y(long j10) {
        this.f5538r = j10;
    }

    public void z(long j10) {
        this.f5523c = j10;
    }
}
