package g5;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public long f6196a;

    /* renamed from: b, reason: collision with root package name */
    public String f6197b;

    /* renamed from: c, reason: collision with root package name */
    public long f6198c;

    /* renamed from: d, reason: collision with root package name */
    public long f6199d;

    /* renamed from: e, reason: collision with root package name */
    public long f6200e;

    /* renamed from: g, reason: collision with root package name */
    public String f6202g;

    /* renamed from: i, reason: collision with root package name */
    public String f6204i;

    /* renamed from: j, reason: collision with root package name */
    public String f6205j;

    /* renamed from: k, reason: collision with root package name */
    public Uri f6206k;

    /* renamed from: l, reason: collision with root package name */
    public String f6207l;

    /* renamed from: m, reason: collision with root package name */
    public Map f6208m;

    /* renamed from: n, reason: collision with root package name */
    public int f6209n;

    /* renamed from: o, reason: collision with root package name */
    public int f6210o;

    /* renamed from: p, reason: collision with root package name */
    public String f6211p;

    /* renamed from: q, reason: collision with root package name */
    public Throwable f6212q;

    /* renamed from: r, reason: collision with root package name */
    public long f6213r;

    /* renamed from: s, reason: collision with root package name */
    public long f6214s;

    /* renamed from: f, reason: collision with root package name */
    public int f6201f = 90;

    /* renamed from: h, reason: collision with root package name */
    public int f6203h = 1;

    public void A(String str) {
        this.f6211p = str;
    }

    public void B(Throwable th) {
        this.f6212q = th;
    }

    public void C(Uri uri) {
        this.f6206k = uri;
        this.f6207l = uri == null ? null : uri.toString();
    }

    public void D(String str) {
        this.f6207l = str;
        try {
            this.f6206k = Uri.parse(str);
        } catch (Exception unused) {
        }
    }

    public void E(int i10) {
        this.f6210o = i10;
    }

    public void F(boolean z10) {
        if (z10) {
            this.f6210o |= 2;
        } else {
            this.f6210o &= -3;
        }
    }

    public void G(Map map) {
        this.f6208m = map;
    }

    public void H(long j10) {
        this.f6196a = j10;
    }

    public void I(String str) {
        this.f6205j = str;
    }

    public void J(String str) {
        this.f6197b = str;
    }

    public void K(String str) {
        this.f6204i = str;
    }

    public void L(int i10) {
        this.f6209n = i10;
    }

    public void M(String str) {
        if (this.f6208m == null) {
            if (str == null || str.isEmpty()) {
                return;
            } else {
                this.f6208m = new HashMap();
            }
        }
        this.f6208m.remove("Referer");
        this.f6208m.remove("referer");
        if (str != null && !str.isEmpty()) {
            this.f6208m.put("Referer", str);
        }
        if (this.f6208m.isEmpty()) {
            this.f6208m = null;
        }
    }

    public void N(boolean z10) {
        if (z10) {
            this.f6210o |= 1;
        } else {
            this.f6210o &= -2;
        }
    }

    public void O(long j10) {
        this.f6200e = j10;
    }

    public void P(int i10) {
        this.f6201f = i10;
    }

    public void Q(long j10) {
        if (j10 <= 0) {
            N(false);
        }
        this.f6199d = j10;
    }

    public void R(long j10) {
        this.f6214s = j10;
    }

    public void S(String str) {
        this.f6202g = str;
    }

    public boolean T() {
        return (this.f6210o & 4) == 4;
    }

    public int a() {
        return this.f6203h;
    }

    public long b() {
        return this.f6213r;
    }

    public long c() {
        return this.f6198c;
    }

    public String d() {
        return this.f6211p;
    }

    public Throwable e() {
        return this.f6212q;
    }

    public Uri f() {
        return this.f6206k;
    }

    public String g() {
        return this.f6207l;
    }

    public int h() {
        return this.f6210o;
    }

    public Map i() {
        return this.f6208m;
    }

    public long j() {
        return this.f6196a;
    }

    public String k() {
        return this.f6205j;
    }

    public String l() {
        return this.f6197b;
    }

    public String m() {
        return this.f6204i;
    }

    public int n() {
        return this.f6209n;
    }

    public String o() {
        Map map = this.f6208m;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Referer");
        return str == null ? (String) this.f6208m.get("referer") : str;
    }

    public long p() {
        return this.f6200e;
    }

    public int q() {
        return this.f6201f;
    }

    public long r() {
        return this.f6199d;
    }

    public long s() {
        return this.f6214s;
    }

    public String t() {
        return this.f6202g;
    }

    public String toString() {
        return "DownloadTask{id=" + this.f6196a + ", name='" + this.f6197b + "', downloadedSize=" + this.f6198c + ", totalSize=" + this.f6199d + ", speed=" + this.f6200e + ", status=" + this.f6201f + ", url='" + this.f6202g + "', chunks=" + this.f6203h + ", path='" + this.f6204i + "', mimeType='" + this.f6205j + "', fileUri=" + this.f6206k + ", headers='" + this.f6208m + "', priority=" + this.f6209n + ", flags=" + this.f6210o + ", createdAt=" + this.f6213r + ", updatedAt=" + this.f6214s + '}';
    }

    public boolean u() {
        return (this.f6210o & 2) == 2;
    }

    public boolean v() {
        return (this.f6210o & 1) == 1;
    }

    public void w(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (str2 == null && this.f6208m == null) {
            return;
        }
        if (this.f6208m == null) {
            this.f6208m = new HashMap();
        }
        if (str2 == null) {
            this.f6208m.remove(str);
        } else {
            this.f6208m.put(str, str2);
        }
        if (this.f6208m.isEmpty()) {
            this.f6208m = null;
        }
    }

    public void x(int i10) {
        this.f6203h = i10;
    }

    public void y(long j10) {
        this.f6213r = j10;
    }

    public void z(long j10) {
        this.f6198c = j10;
    }
}
