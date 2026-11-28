package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {
    public static final a A = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1985j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f1986k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1987l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1988m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1989n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1990o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1991p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1992q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1993r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1994s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f1995t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1996u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f1997v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1998w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1999x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f2000y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2001z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public a() {
        }
    }

    public f0() {
        this(false, false, 0, null, false, 0, 0, 0, false, false, null, 0, 0, 0, 0, false, false, false, 0, 0.0f, 0, 0.0f, false, false, null, false, 67108863, null);
    }

    public final void A(int i10) {
        this.f1978c = i10;
    }

    public final void B(String str) {
        this.f2000y = str;
    }

    public final void C(String str) {
        this.f1979d = str;
    }

    public final void D(boolean z10) {
        this.f1984i = z10;
    }

    public final void E(boolean z10) {
        this.f1985j = z10;
    }

    public final void F(int i10, int i11, int i12) {
        if (i11 == 0) {
            i11 = i10 != 0 ? i10 : 54;
        }
        this.f1982g = i11;
        if (i10 == 0) {
            i10 = i11;
        }
        this.f1981f = i10;
        this.f1983h = (Math.min(i10, i11) * i12) / 200;
    }

    public final void G(boolean z10) {
        this.f1999x = z10;
    }

    public final void H(boolean z10) {
        this.f1991p = z10;
    }

    public final void I(int i10) {
        this.f1990o = i10;
    }

    public final void J(boolean z10) {
        this.f1992q = z10;
    }

    public final void K(int i10, int i11, int i12) {
        this.f1987l = i10;
        if (i10 == 0 && i11 == 0) {
            i11 = 72;
        }
        this.f1988m = i11;
        this.f1989n = (Math.max(i10, i11) * i12) / 200;
    }

    public final void L(boolean z10) {
        this.f1977b = z10;
    }

    public final void M(boolean z10) {
        this.f1976a = z10;
    }

    public final void N(boolean z10) {
        this.f1993r = z10;
    }

    public final void O(boolean z10, int i10, int i11, int i12, int i13) {
        this.f1998w = z10;
        this.f1995t = z10 ? 0.0f : i10 / 100.0f;
        this.f1997v = i11 / 100.0f;
        this.f1996u = i12;
        this.f1994s = z10 ? 0 : ((i12 + 23) * i13) / 100;
    }

    public final void P(boolean z10) {
        this.f2001z = z10;
    }

    public final void Q(boolean z10) {
        this.f1980e = z10;
    }

    public final int a() {
        return this.f1978c;
    }

    public final String b() {
        return this.f2000y;
    }

    public final String c() {
        return this.f1979d;
    }

    public final boolean d() {
        return this.f1984i;
    }

    public final boolean e() {
        return this.f1985j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f1976a == f0Var.f1976a && this.f1977b == f0Var.f1977b && this.f1978c == f0Var.f1978c && kotlin.jvm.internal.h.a(this.f1979d, f0Var.f1979d) && this.f1980e == f0Var.f1980e && this.f1981f == f0Var.f1981f && this.f1982g == f0Var.f1982g && this.f1983h == f0Var.f1983h && this.f1984i == f0Var.f1984i && this.f1985j == f0Var.f1985j && kotlin.jvm.internal.h.a(this.f1986k, f0Var.f1986k) && this.f1987l == f0Var.f1987l && this.f1988m == f0Var.f1988m && this.f1989n == f0Var.f1989n && this.f1990o == f0Var.f1990o && this.f1991p == f0Var.f1991p && this.f1992q == f0Var.f1992q && this.f1993r == f0Var.f1993r && this.f1994s == f0Var.f1994s && Float.compare(this.f1995t, f0Var.f1995t) == 0 && this.f1996u == f0Var.f1996u && Float.compare(this.f1997v, f0Var.f1997v) == 0 && this.f1998w == f0Var.f1998w && this.f1999x == f0Var.f1999x && kotlin.jvm.internal.h.a(this.f2000y, f0Var.f2000y) && this.f2001z == f0Var.f2001z;
    }

    public final int f() {
        return this.f1982g;
    }

    public final int g() {
        return this.f1983h;
    }

    public final int h() {
        return this.f1981f;
    }

    public int hashCode() {
        int iA = ((((e0.a(this.f1976a) * 31) + e0.a(this.f1977b)) * 31) + this.f1978c) * 31;
        String str = this.f1979d;
        int iHashCode = (((((((((((((((((((((((((((((((((((((((((iA + (str == null ? 0 : str.hashCode())) * 31) + e0.a(this.f1980e)) * 31) + this.f1981f) * 31) + this.f1982g) * 31) + this.f1983h) * 31) + e0.a(this.f1984i)) * 31) + e0.a(this.f1985j)) * 31) + this.f1986k.hashCode()) * 31) + this.f1987l) * 31) + this.f1988m) * 31) + this.f1989n) * 31) + this.f1990o) * 31) + e0.a(this.f1991p)) * 31) + e0.a(this.f1992q)) * 31) + e0.a(this.f1993r)) * 31) + this.f1994s) * 31) + Float.floatToIntBits(this.f1995t)) * 31) + this.f1996u) * 31) + Float.floatToIntBits(this.f1997v)) * 31) + e0.a(this.f1998w)) * 31) + e0.a(this.f1999x)) * 31;
        String str2 = this.f2000y;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + e0.a(this.f2001z);
    }

    public final int i() {
        return this.f1990o;
    }

    public final int j() {
        return this.f1988m;
    }

    public final String k() {
        return this.f1986k;
    }

    public final int l() {
        return this.f1989n;
    }

    public final int m() {
        return this.f1987l;
    }

    public final float n() {
        return this.f1995t;
    }

    public final boolean o() {
        return this.f1993r;
    }

    public final boolean p() {
        return this.f1998w;
    }

    public final int q() {
        return this.f1994s;
    }

    public final float r() {
        return this.f1997v;
    }

    public final int s() {
        return this.f1996u;
    }

    public final boolean t() {
        return this.f2001z;
    }

    public String toString() {
        return "HomepageConfig(isRtl=" + this.f1976a + ", isNight=" + this.f1977b + ", accentColor=" + this.f1978c + ", backgroundPath=" + this.f1979d + ", usingBlur=" + this.f1980e + ", favoriteItemWidth=" + this.f1981f + ", favoriteItemHeight=" + this.f1982g + ", favoriteItemRadius=" + this.f1983h + ", favoriteColorDisabled=" + this.f1984i + ", favoriteIconDisabled=" + this.f1985j + ", logoPath=" + this.f1986k + ", logoWidth=" + this.f1987l + ", logoHeight=" + this.f1988m + ", logoRadius=" + this.f1989n + ", logoFontSize=" + this.f1990o + ", isLogoBold=" + this.f1991p + ", isLogoItalic=" + this.f1992q + ", searchBarEnabled=" + this.f1993r + ", searchBarRadius=" + this.f1994s + ", searchBarAlpha=" + this.f1995t + ", searchBarStrokeWidth=" + this.f1996u + ", searchBarStrokeAlpha=" + this.f1997v + ", searchBarLineEnabled=" + this.f1998w + ", isLight=" + this.f1999x + ", additionalStyleSheet=" + this.f2000y + ", searchOnHomepage=" + this.f2001z + ')';
    }

    public final boolean u() {
        return this.f1980e;
    }

    public final boolean v() {
        return this.f1999x;
    }

    public final boolean w() {
        return this.f1991p;
    }

    public final boolean x() {
        return this.f1992q;
    }

    public final boolean y() {
        return this.f1977b;
    }

    public final boolean z() {
        return this.f1976a;
    }

    public f0(boolean z10, boolean z11, int i10, String str, boolean z12, int i11, int i12, int i13, boolean z13, boolean z14, String logoPath, int i14, int i15, int i16, int i17, boolean z15, boolean z16, boolean z17, int i18, float f10, int i19, float f11, boolean z18, boolean z19, String str2, boolean z20) {
        kotlin.jvm.internal.h.f(logoPath, "logoPath");
        this.f1976a = z10;
        this.f1977b = z11;
        this.f1978c = i10;
        this.f1979d = str;
        this.f1980e = z12;
        this.f1981f = i11;
        this.f1982g = i12;
        this.f1983h = i13;
        this.f1984i = z13;
        this.f1985j = z14;
        this.f1986k = logoPath;
        this.f1987l = i14;
        this.f1988m = i15;
        this.f1989n = i16;
        this.f1990o = i17;
        this.f1991p = z15;
        this.f1992q = z16;
        this.f1993r = z17;
        this.f1994s = i18;
        this.f1995t = f10;
        this.f1996u = i19;
        this.f1997v = f11;
        this.f1998w = z18;
        this.f1999x = z19;
        this.f2000y = str2;
        this.f2001z = z20;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ f0(boolean z10, boolean z11, int i10, String str, boolean z12, int i11, int i12, int i13, boolean z13, boolean z14, String str2, int i14, int i15, int i16, int i17, boolean z15, boolean z16, boolean z17, int i18, float f10, int i19, float f11, boolean z18, boolean z19, String str3, boolean z20, int i20, kotlin.jvm.internal.f fVar) {
        boolean z21 = (i20 & 1) != 0 ? false : z10;
        boolean z22 = (i20 & 2) != 0 ? false : z11;
        int i21 = (i20 & 4) != 0 ? -16776961 : i10;
        String str4 = (i20 & 8) != 0 ? "" : str;
        boolean z23 = (i20 & 16) != 0 ? false : z12;
        int i22 = (i20 & 32) != 0 ? 54 : i11;
        int i23 = (i20 & 64) != 0 ? 54 : i12;
        int i24 = (i20 & 128) != 0 ? i22 / 2 : i13;
        boolean z24 = (i20 & 256) != 0 ? false : z13;
        boolean z25 = (i20 & 512) != 0 ? false : z14;
        String str5 = (i20 & 1024) != 0 ? "data:image/svg+xml;base64,PHN2ZyBmaWxsPSJub25lIiBoZWlnaHQ9IjkwIiB2aWV3Qm94PSIwIDAgMTI0IDkwIiB3aWR0aD0iMTI0IiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPjxwYXRoIGQ9Im0yMS43Mzg0IDI2LjY3MzljLjE5MzktMS42MTY1IDEuMzQ4My0yLjk1NDEgMi45MTktMy4zODI1bDExLjM3NTYtMy4xMDI0YzEuMjcyMy0uMzQ3IDIuNTI2Mi42MTA4IDIuNTI2MiAxLjkyOTV2MTcuODgxNWwtMjEuMDU5MiAyMnoiIGZpbGw9IiMwMGE1ZjYiLz48cGF0aCBkPSJtNjcgNy41IDMuNSAyMy0zMS43MTE0IDM3Ljg2NDRjLTEuMDc0OSAxLjI4MzQtMi44MzU0IDEuNzYxOC00LjQxMiAxLjE5ODdsLTE1LjUzNDktNS41NDgyYy0xLjM0ODQtLjQ4MTYtMS43Njg4LTIuMTgyNS0uOC0zLjIzNjd6IiBmaWxsPSIjZmYzZTAwIi8+PHBhdGggZD0ibTY2LjcyMTQgOC4yOTQzYy0uMTExNC0uNjUxMDkuNDI3OS0xLjIyOTM3IDEuMDg1Mi0xLjE2MzY0bDE3LjM5MjEgMS43MzkyMWMuNzkwNS4wNzkwNSAxLjQ1OTMuNjE4NTMgMS43MDM5IDEuMzc0NDNsMjAuOTEwNCA2NC42MzM1Yy4zNjcgMS4xMzI4LS4zMzEgMi4zMzI5LTEuNDk3IDIuNTc0MWwtMjIuNzYxIDQuNzA5MWMtMi4yMTY1LjQ1ODYtNC4zNzE2LTEuMDExNi00Ljc1MzItMy4yNDI2eiIgZmlsbD0iI2ZmYjcwMCIvPjwvc3ZnPg==" : str2;
        int i25 = (i20 & 2048) != 0 ? 0 : i14;
        int i26 = (i20 & 4096) == 0 ? i15 : 54;
        this(z21, z22, i21, str4, z23, i22, i23, i24, z24, z25, str5, i25, i26, (i20 & 8192) != 0 ? i26 / 2 : i16, (i20 & 16384) != 0 ? 28 : i17, (i20 & 32768) != 0 ? true : z15, (i20 & 65536) != 0 ? false : z16, (i20 & 131072) != 0 ? false : z17, (i20 & 262144) != 0 ? 100 : i18, (i20 & 524288) != 0 ? 0.0f : f10, (i20 & 1048576) == 0 ? i19 : 1, (i20 & 2097152) != 0 ? 0.5f : f11, (i20 & 4194304) != 0 ? false : z18, (i20 & 8388608) != 0 ? false : z19, (i20 & 16777216) != 0 ? null : str3, (i20 & 33554432) != 0 ? false : z20);
    }
}
