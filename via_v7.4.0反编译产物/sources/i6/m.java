package i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m {
    public static final a A = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public boolean f7012a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7013b;

    /* renamed from: c, reason: collision with root package name */
    public int f7014c;

    /* renamed from: d, reason: collision with root package name */
    public String f7015d;

    /* renamed from: e, reason: collision with root package name */
    public float f7016e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7017f;

    /* renamed from: g, reason: collision with root package name */
    public int f7018g;

    /* renamed from: h, reason: collision with root package name */
    public int f7019h;

    /* renamed from: i, reason: collision with root package name */
    public int f7020i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7021j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7022k;

    /* renamed from: l, reason: collision with root package name */
    public String f7023l;

    /* renamed from: m, reason: collision with root package name */
    public int f7024m;

    /* renamed from: n, reason: collision with root package name */
    public int f7025n;

    /* renamed from: o, reason: collision with root package name */
    public int f7026o;

    /* renamed from: p, reason: collision with root package name */
    public int f7027p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7028q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7029r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7030s;

    /* renamed from: t, reason: collision with root package name */
    public int f7031t;

    /* renamed from: u, reason: collision with root package name */
    public float f7032u;

    /* renamed from: v, reason: collision with root package name */
    public int f7033v;

    /* renamed from: w, reason: collision with root package name */
    public float f7034w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7035x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f7036y;

    /* renamed from: z, reason: collision with root package name */
    public String f7037z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public m() {
        this(false, false, 0, null, 0.0f, false, 0, 0, 0, false, false, null, 0, 0, 0, 0, false, false, false, 0, 0.0f, 0, 0.0f, false, false, null, 67108863, null);
    }

    public m(boolean z10, boolean z11, int i10, String str, float f10, boolean z12, int i11, int i12, int i13, boolean z13, boolean z14, String logoPath, int i14, int i15, int i16, int i17, boolean z15, boolean z16, boolean z17, int i18, float f11, int i19, float f12, boolean z18, boolean z19, String str2) {
        kotlin.jvm.internal.h.f(logoPath, "logoPath");
        this.f7012a = z10;
        this.f7013b = z11;
        this.f7014c = i10;
        this.f7015d = str;
        this.f7016e = f10;
        this.f7017f = z12;
        this.f7018g = i11;
        this.f7019h = i12;
        this.f7020i = i13;
        this.f7021j = z13;
        this.f7022k = z14;
        this.f7023l = logoPath;
        this.f7024m = i14;
        this.f7025n = i15;
        this.f7026o = i16;
        this.f7027p = i17;
        this.f7028q = z15;
        this.f7029r = z16;
        this.f7030s = z17;
        this.f7031t = i18;
        this.f7032u = f11;
        this.f7033v = i19;
        this.f7034w = f12;
        this.f7035x = z18;
        this.f7036y = z19;
        this.f7037z = str2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ m(boolean z10, boolean z11, int i10, String str, float f10, boolean z12, int i11, int i12, int i13, boolean z13, boolean z14, String str2, int i14, int i15, int i16, int i17, boolean z15, boolean z16, boolean z17, int i18, float f11, int i19, float f12, boolean z18, boolean z19, String str3, int i20, kotlin.jvm.internal.f fVar) {
        boolean z20 = (i20 & 1) != 0 ? false : z10;
        boolean z21 = (i20 & 2) != 0 ? false : z11;
        int i21 = (i20 & 4) != 0 ? -16776961 : i10;
        String str4 = (i20 & 8) != 0 ? "" : str;
        float f13 = (i20 & 16) != 0 ? 1.0f : f10;
        boolean z22 = (i20 & 32) != 0 ? false : z12;
        int i22 = (i20 & 64) != 0 ? 54 : i11;
        int i23 = (i20 & 128) != 0 ? 54 : i12;
        int i24 = (i20 & 256) != 0 ? i22 / 2 : i13;
        boolean z23 = (i20 & 512) != 0 ? false : z13;
        boolean z24 = (i20 & 1024) != 0 ? false : z14;
        String str5 = (i20 & 2048) != 0 ? "data:image/svg+xml;base64,PHN2ZyBmaWxsPSJub25lIiBoZWlnaHQ9IjkwIiB2aWV3Qm94PSIwIDAgMTI0IDkwIiB3aWR0aD0iMTI0IiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPjxwYXRoIGQ9Im0yMS43Mzg0IDI2LjY3MzljLjE5MzktMS42MTY1IDEuMzQ4My0yLjk1NDEgMi45MTktMy4zODI1bDExLjM3NTYtMy4xMDI0YzEuMjcyMy0uMzQ3IDIuNTI2Mi42MTA4IDIuNTI2MiAxLjkyOTV2MTcuODgxNWwtMjEuMDU5MiAyMnoiIGZpbGw9IiMwMGE1ZjYiLz48cGF0aCBkPSJtNjcgNy41IDMuNSAyMy0zMS43MTE0IDM3Ljg2NDRjLTEuMDc0OSAxLjI4MzQtMi44MzU0IDEuNzYxOC00LjQxMiAxLjE5ODdsLTE1LjUzNDktNS41NDgyYy0xLjM0ODQtLjQ4MTYtMS43Njg4LTIuMTgyNS0uOC0zLjIzNjd6IiBmaWxsPSIjZmYzZTAwIi8+PHBhdGggZD0ibTY2LjcyMTQgOC4yOTQzYy0uMTExNC0uNjUxMDkuNDI3OS0xLjIyOTM3IDEuMDg1Mi0xLjE2MzY0bDE3LjM5MjEgMS43MzkyMWMuNzkwNS4wNzkwNSAxLjQ1OTMuNjE4NTMgMS43MDM5IDEuMzc0NDNsMjAuOTEwNCA2NC42MzM1Yy4zNjcgMS4xMzI4LS4zMzEgMi4zMzI5LTEuNDk3IDIuNTc0MWwtMjIuNzYxIDQuNzA5MWMtMi4yMTY1LjQ1ODYtNC4zNzE2LTEuMDExNi00Ljc1MzItMy4yNDI2eiIgZmlsbD0iI2ZmYjcwMCIvPjwvc3ZnPg==" : str2;
        int i25 = (i20 & 4096) != 0 ? 0 : i14;
        int i26 = (i20 & 8192) == 0 ? i15 : 54;
        this(z20, z21, i21, str4, f13, z22, i22, i23, i24, z23, z24, str5, i25, i26, (i20 & 16384) != 0 ? i26 / 2 : i16, (i20 & 32768) != 0 ? 28 : i17, (i20 & 65536) != 0 ? true : z15, (i20 & 131072) != 0 ? false : z16, (i20 & 262144) != 0 ? false : z17, (i20 & 524288) != 0 ? 100 : i18, (i20 & 1048576) != 0 ? 0.0f : f11, (i20 & 2097152) == 0 ? i19 : 1, (i20 & 4194304) != 0 ? 0.5f : f12, (i20 & 8388608) != 0 ? false : z18, (i20 & 16777216) != 0 ? false : z19, (i20 & 33554432) != 0 ? null : str3);
    }

    public final void A(String str) {
        this.f7037z = str;
    }

    public final void B(float f10) {
        this.f7016e = f10;
    }

    public final void C(String str) {
        this.f7015d = str;
    }

    public final void D(boolean z10) {
        this.f7021j = z10;
    }

    public final void E(boolean z10) {
        this.f7022k = z10;
    }

    public final void F(int i10) {
        this.f7019h = i10;
    }

    public final void G(int i10) {
        this.f7020i = i10;
    }

    public final void H(int i10) {
        this.f7018g = i10;
    }

    public final void I(boolean z10) {
        this.f7036y = z10;
    }

    public final void J(boolean z10) {
        this.f7028q = z10;
    }

    public final void K(int i10) {
        this.f7027p = i10;
    }

    public final void L(int i10) {
        this.f7025n = i10;
    }

    public final void M(boolean z10) {
        this.f7029r = z10;
    }

    public final void N(int i10) {
        this.f7026o = i10;
    }

    public final void O(int i10) {
        this.f7024m = i10;
    }

    public final void P(boolean z10) {
        this.f7013b = z10;
    }

    public final void Q(boolean z10) {
        this.f7012a = z10;
    }

    public final void R(float f10) {
        this.f7032u = f10;
    }

    public final void S(boolean z10) {
        this.f7030s = z10;
    }

    public final void T(boolean z10) {
        this.f7035x = z10;
    }

    public final void U(int i10) {
        this.f7031t = i10;
    }

    public final void V(float f10) {
        this.f7034w = f10;
    }

    public final void W(int i10) {
        this.f7033v = i10;
    }

    public final void X(boolean z10) {
        this.f7017f = z10;
    }

    public final int a() {
        return this.f7014c;
    }

    public final String b() {
        return this.f7037z;
    }

    public final String c() {
        return this.f7015d;
    }

    public final boolean d() {
        return this.f7021j;
    }

    public final boolean e() {
        return this.f7022k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f7012a == mVar.f7012a && this.f7013b == mVar.f7013b && this.f7014c == mVar.f7014c && kotlin.jvm.internal.h.a(this.f7015d, mVar.f7015d) && Float.compare(this.f7016e, mVar.f7016e) == 0 && this.f7017f == mVar.f7017f && this.f7018g == mVar.f7018g && this.f7019h == mVar.f7019h && this.f7020i == mVar.f7020i && this.f7021j == mVar.f7021j && this.f7022k == mVar.f7022k && kotlin.jvm.internal.h.a(this.f7023l, mVar.f7023l) && this.f7024m == mVar.f7024m && this.f7025n == mVar.f7025n && this.f7026o == mVar.f7026o && this.f7027p == mVar.f7027p && this.f7028q == mVar.f7028q && this.f7029r == mVar.f7029r && this.f7030s == mVar.f7030s && this.f7031t == mVar.f7031t && Float.compare(this.f7032u, mVar.f7032u) == 0 && this.f7033v == mVar.f7033v && Float.compare(this.f7034w, mVar.f7034w) == 0 && this.f7035x == mVar.f7035x && this.f7036y == mVar.f7036y && kotlin.jvm.internal.h.a(this.f7037z, mVar.f7037z);
    }

    public final int f() {
        return this.f7019h;
    }

    public final int g() {
        return this.f7020i;
    }

    public final int h() {
        return this.f7018g;
    }

    public int hashCode() {
        int iA = ((((l.a(this.f7012a) * 31) + l.a(this.f7013b)) * 31) + this.f7014c) * 31;
        String str = this.f7015d;
        int iHashCode = (((((((((((((((((((((((((((((((((((((((((((iA + (str == null ? 0 : str.hashCode())) * 31) + Float.floatToIntBits(this.f7016e)) * 31) + l.a(this.f7017f)) * 31) + this.f7018g) * 31) + this.f7019h) * 31) + this.f7020i) * 31) + l.a(this.f7021j)) * 31) + l.a(this.f7022k)) * 31) + this.f7023l.hashCode()) * 31) + this.f7024m) * 31) + this.f7025n) * 31) + this.f7026o) * 31) + this.f7027p) * 31) + l.a(this.f7028q)) * 31) + l.a(this.f7029r)) * 31) + l.a(this.f7030s)) * 31) + this.f7031t) * 31) + Float.floatToIntBits(this.f7032u)) * 31) + this.f7033v) * 31) + Float.floatToIntBits(this.f7034w)) * 31) + l.a(this.f7035x)) * 31) + l.a(this.f7036y)) * 31;
        String str2 = this.f7037z;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final int i() {
        return this.f7027p;
    }

    public final int j() {
        return this.f7025n;
    }

    public final String k() {
        return this.f7023l;
    }

    public final int l() {
        return this.f7026o;
    }

    public final int m() {
        return this.f7024m;
    }

    public final float n() {
        return this.f7032u;
    }

    public final boolean o() {
        return this.f7030s;
    }

    public final boolean p() {
        return this.f7035x;
    }

    public final int q() {
        return this.f7031t;
    }

    public final float r() {
        return this.f7034w;
    }

    public final int s() {
        return this.f7033v;
    }

    public final boolean t() {
        return this.f7017f;
    }

    public String toString() {
        return "HomepageConfig(isRtl=" + this.f7012a + ", isNight=" + this.f7013b + ", accentColor=" + this.f7014c + ", backgroundPath=" + this.f7015d + ", backgroundOpacity=" + this.f7016e + ", usingBlur=" + this.f7017f + ", favoriteItemWidth=" + this.f7018g + ", favoriteItemHeight=" + this.f7019h + ", favoriteItemRadius=" + this.f7020i + ", favoriteColorDisabled=" + this.f7021j + ", favoriteIconDisabled=" + this.f7022k + ", logoPath=" + this.f7023l + ", logoWidth=" + this.f7024m + ", logoHeight=" + this.f7025n + ", logoRadius=" + this.f7026o + ", logoFontSize=" + this.f7027p + ", isLogoBold=" + this.f7028q + ", isLogoItalic=" + this.f7029r + ", searchBarEnabled=" + this.f7030s + ", searchBarRadius=" + this.f7031t + ", searchBarAlpha=" + this.f7032u + ", searchBarStrokeWidth=" + this.f7033v + ", searchBarStrokeAlpha=" + this.f7034w + ", searchBarLineEnabled=" + this.f7035x + ", isLight=" + this.f7036y + ", additionalStyleSheet=" + this.f7037z + ')';
    }

    public final boolean u() {
        return this.f7036y;
    }

    public final boolean v() {
        return this.f7028q;
    }

    public final boolean w() {
        return this.f7029r;
    }

    public final boolean x() {
        return this.f7013b;
    }

    public final boolean y() {
        return this.f7012a;
    }

    public final void z(int i10) {
        this.f7014c = i10;
    }
}
