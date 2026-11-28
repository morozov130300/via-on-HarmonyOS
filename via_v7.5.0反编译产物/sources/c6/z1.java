package c6;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f2142j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f2144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f2145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f2146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f2147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f2148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f2149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f2150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2151i;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final String a(String host) {
            kotlin.jvm.internal.h.f(host, "host");
            int i10 = 0;
            while (i10 < host.length()) {
                char cCharAt = host.charAt(i10);
                if (cCharAt == 12290 || cCharAt == 65294 || cCharAt == 65377) {
                    StringBuilder sb2 = new StringBuilder(host.length());
                    sb2.append((CharSequence) host, 0, i10);
                    while (i10 < host.length()) {
                        char cCharAt2 = host.charAt(i10);
                        if (cCharAt2 == 12290 || cCharAt2 == 65294 || cCharAt2 == 65377) {
                            cCharAt2 = '.';
                        }
                        sb2.append(cCharAt2);
                        i10++;
                    }
                    String string = sb2.toString();
                    kotlin.jvm.internal.h.e(string, "toString(...)");
                    return string;
                }
                i10++;
            }
            return host;
        }

        public final z1 b(String str) {
            return new z1(str);
        }

        public a() {
        }
    }

    public z1(String str) {
        this.f2143a = str != null ? kotlin.text.z.v0(str).toString() : null;
        o();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0082  */
    public final boolean a() {
        String str = this.f2143a;
        if (str == null || str.length() == 0) {
            return false;
        }
        w wVar = w.f2124a;
        int iD = wVar.d(this.f2143a, 0);
        String strK = k();
        if (strK == null) {
            int[] iArr = this.f2148f;
            if (iArr == null) {
                return false;
            }
            if (iD > 0) {
                kotlin.jvm.internal.h.c(iArr);
                if (iD < iArr[0]) {
                    return false;
                }
            }
            return r(c());
        }
        if (kotlin.jvm.internal.h.a("http", strK) || kotlin.jvm.internal.h.a("https", strK) || kotlin.jvm.internal.h.a("ftp", strK)) {
            int[] iArr2 = this.f2146d;
            if (iArr2 != null) {
                kotlin.jvm.internal.h.c(iArr2);
                if ((iD > iArr2[0] || iD < 0) && p(c(), true)) {
                    return true;
                }
            }
            return false;
        }
        int[] iArr3 = this.f2148f;
        if (iArr3 != null) {
            kotlin.jvm.internal.h.c(iArr3);
            int i10 = iArr3[0];
            int[] iArr4 = this.f2144b;
            kotlin.jvm.internal.h.c(iArr4);
            if (i10 == iArr4[1] + 1) {
                if (!kotlin.jvm.internal.h.a("javascript", strK) && !kotlin.jvm.internal.h.a("data", strK)) {
                    if (kotlin.jvm.internal.h.a("about", strK)) {
                        int[] iArr5 = this.f2148f;
                        kotlin.jvm.internal.h.c(iArr5);
                        int i11 = iArr5[0];
                        int[] iArr6 = this.f2148f;
                        kotlin.jvm.internal.h.c(iArr6);
                        if (i11 != iArr6[1] && !wVar.h(g(), 3, new int[]{45})) {
                            if (kotlin.jvm.internal.h.a("view-source", strK) && !kotlin.jvm.internal.h.a("magnet", strK) && !kotlin.jvm.internal.h.a("sms", strK) && !kotlin.jvm.internal.h.a("tel", strK) && !kotlin.jvm.internal.h.a("mailto", strK) && !kotlin.jvm.internal.h.a("geo", strK) && !kotlin.jvm.internal.h.a("tg", strK)) {
                                return false;
                            }
                        }
                    } else if (kotlin.jvm.internal.h.a("view-source", strK)) {
                    }
                }
                return true;
            }
        }
        return iD < 0;
    }

    public final String b() {
        return l(this.f2150h);
    }

    public final String c() {
        String strL = l(this.f2146d);
        if (strL == null) {
            return null;
        }
        String lowerCase = strL.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final int[] d() {
        return this.f2146d;
    }

    public final String e() {
        return l(f());
    }

    public final int[] f() {
        int[] iArr = this.f2148f;
        if (iArr == null) {
            return null;
        }
        kotlin.jvm.internal.h.c(iArr);
        int i10 = iArr[1];
        String str = this.f2143a;
        kotlin.jvm.internal.h.c(str);
        if (str.charAt(i10 - 1) == '/') {
            i10--;
        }
        int[] iArr2 = this.f2148f;
        kotlin.jvm.internal.h.c(iArr2);
        return j(Math.max(iArr2[0], kotlin.text.z.Y(this.f2143a, '/', i10 - 1, false, 4, null) + 1), i10);
    }

    public final String g() {
        return l(this.f2148f);
    }

    public final String h() {
        return l(this.f2147e);
    }

    public final String i() {
        return l(this.f2149g);
    }

    public final int[] j(int i10, int i11) {
        if (i10 < 0 || i11 < i10) {
            return null;
        }
        return new int[]{i10, i11};
    }

    public final String k() {
        String strL;
        if (!n() || (strL = l(this.f2144b)) == null) {
            return null;
        }
        String lowerCase = strL.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final String l(int[] iArr) {
        if (iArr == null || iArr.length < 2 || iArr[1] < iArr[0]) {
            return null;
        }
        String str = this.f2143a;
        kotlin.jvm.internal.h.c(str);
        String strSubstring = str.substring(iArr[0], iArr[1]);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String m() {
        return l(this.f2145c);
    }

    public final boolean n() {
        return this.f2144b != null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:49:0x0126  */
    public final void o() {
        int i10;
        int i11;
        int[] iArrJ;
        String str = this.f2143a;
        if (str == null || str.length() == 0) {
            this.f2144b = null;
            this.f2145c = null;
            this.f2146d = null;
            this.f2147e = null;
            this.f2148f = null;
            this.f2149g = null;
            this.f2150h = null;
            this.f2151i = false;
            return;
        }
        int length = this.f2143a.length();
        int[] iArrT = t(0, kotlin.text.z.S(this.f2143a, ':', 0, false, 4, null));
        this.f2144b = iArrT;
        if (iArrT != null) {
            kotlin.jvm.internal.h.c(iArrT);
            int i12 = iArrT[1];
            int i13 = i12 + 1;
            int i14 = i12 + 2;
            if (i14 >= length || this.f2143a.charAt(i13) != '/' || this.f2143a.charAt(i14) != '/') {
                this.f2148f = j(i13, length);
                this.f2151i = a();
                return;
            }
            i10 = i12 + 3;
        } else {
            i10 = 0;
        }
        if (i10 >= length) {
            this.f2151i = a();
            return;
        }
        int[] iArrJ2 = j(kotlin.text.z.Y(this.f2143a, '#', length, false, 4, null), length);
        this.f2150h = iArrJ2;
        if (iArrJ2 != null) {
            kotlin.jvm.internal.h.c(iArrJ2);
            length = iArrJ2[0];
            int[] iArr = this.f2150h;
            kotlin.jvm.internal.h.c(iArr);
            iArr[0] = iArr[0] + 1;
        }
        int i15 = length;
        int i16 = i10;
        int[] iArrJ3 = j(kotlin.text.z.S(this.f2143a, '?', i16, false, 4, null), i15);
        this.f2149g = iArrJ3;
        if (iArrJ3 != null) {
            kotlin.jvm.internal.h.c(iArrJ3);
            i15 = iArrJ3[0];
            int[] iArr2 = this.f2149g;
            kotlin.jvm.internal.h.c(iArr2);
            iArr2[0] = iArr2[0] + 1;
        }
        int[] iArrJ4 = j(kotlin.text.z.S(this.f2143a, '/', i16, false, 4, null), i15);
        this.f2148f = iArrJ4;
        if (iArrJ4 != null) {
            kotlin.jvm.internal.h.c(iArrJ4);
            i15 = iArrJ4[0];
        } else {
            this.f2148f = new int[]{i15, i15};
        }
        int i17 = i15;
        int iY = kotlin.text.z.Y(this.f2143a, ':', i17, false, 4, null);
        if (iY > 0 && iY < i17) {
            int i18 = iY + 1;
            if (i18 != i17) {
                w wVar = w.f2124a;
                String strSubstring = this.f2143a.substring(i18, i17);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                if (w.i(wVar, strSubstring, 4, null, 4, null)) {
                    iArrJ = j(i18, i17);
                    this.f2147e = iArrJ;
                    if (iArrJ != null) {
                        kotlin.jvm.internal.h.c(iArrJ);
                        i17 = iArrJ[0] - 1;
                    }
                }
            } else {
                iArrJ = j(i18, i17);
                this.f2147e = iArrJ;
                if (iArrJ != null) {
                    kotlin.jvm.internal.h.c(iArrJ);
                    i17 = iArrJ[0] - 1;
                }
            }
        }
        int iS = kotlin.text.z.S(this.f2143a, '@', i16, false, 4, null);
        if (iS <= 0 || iS > i17) {
            i11 = i16;
        } else {
            int[] iArrJ5 = j(i16, iS);
            this.f2145c = iArrJ5;
            if (iArrJ5 != null) {
                kotlin.jvm.internal.h.c(iArrJ5);
                i11 = iArrJ5[1] + 1;
            } else {
                i11 = i16;
            }
        }
        this.f2146d = j(i11, i17);
        this.f2151i = a();
    }

    public final boolean p(String str, boolean z10) {
        return !w.f2124a.b(str, z10 ? new int[]{33, 35, 36, 38, 34, 39, 40, 41, 42, 43, 44, 47, 59, 60, 61, 62, 63, 64, 92, 94, 96, 123, 124, 125, 126} : new int[]{33, 35, 36, 37, 38, 34, 39, 40, 41, 42, 43, 44, 47, 59, 60, 61, 62, 63, 64, 92, 94, 95, 96, 123, 124, 125, 126});
    }

    public final boolean q(String str) {
        if (str != null && str.length() >= 7) {
            int length = str.length();
            int i10 = 1;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                char cCharAt = str.charAt(i12);
                if (kotlin.jvm.internal.h.h(cCharAt, 48) >= 0 && kotlin.jvm.internal.h.h(cCharAt, 57) <= 0) {
                    i11 = (i11 * 10) + (cCharAt - '0');
                    if (i11 > 255) {
                        return false;
                    }
                } else {
                    if (cCharAt != '.' || (i10 = i10 + 1) > 4) {
                        return false;
                    }
                    i11 = 0;
                }
            }
            if (i10 == 4) {
                return true;
            }
        }
        return false;
    }

    public final boolean r(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String strA = f2142j.a(str);
        if (kotlin.jvm.internal.h.a("localhost", strA) || (this.f2144b != null && w.i(w.f2124a, strA, 6, null, 4, null))) {
            return true;
        }
        if (strA.charAt(0) == '[' && strA.charAt(strA.length() - 1) == ']') {
            if (strA.length() > 3) {
                w wVar = w.f2124a;
                String strSubstring = strA.substring(1, strA.length() - 1);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                if (wVar.h(strSubstring, 8, new int[]{58})) {
                    return true;
                }
            }
            return false;
        }
        int iY = kotlin.text.z.Y(strA, '.', 0, false, 6, null);
        if (iY == strA.length() - 1 || strA.charAt(0) == '.' || ((iY > 0 && kotlin.text.z.I(strA, "..", false, 2, null)) || !p(strA, false))) {
            return false;
        }
        if (kotlin.jvm.internal.h.a("/", g())) {
            return true;
        }
        if (iY < 0) {
            return false;
        }
        String strSubstring2 = strA.substring(iY + 1);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        return w.i(w.f2124a, strSubstring2, 4, null, 4, null) ? q(strA) : v1.f2123a.a(strSubstring2);
    }

    public final boolean s() {
        return this.f2151i;
    }

    public final int[] t(int i10, int i11) {
        if (i11 <= i10 || i10 < 0) {
            return null;
        }
        w wVar = w.f2124a;
        String str = this.f2143a;
        kotlin.jvm.internal.h.c(str);
        if (!w.g(wVar, str.charAt(i10), 3, null, 4, null)) {
            return null;
        }
        String strSubstring = this.f2143a.substring(i10, i11);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        if (!wVar.h(strSubstring, 7, new int[]{43, 46, 45})) {
            return null;
        }
        if (i11 - i10 == 7) {
            String strSubstring2 = this.f2143a.substring(i10, i11);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            String lowerCase = strSubstring2.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
            if (kotlin.jvm.internal.h.a("localhost", lowerCase)) {
                return null;
            }
        }
        if (kotlin.text.z.S(this.f2143a, '.', i10, false, 4, null) < i11) {
            String strSubstring3 = this.f2143a.substring(i10, i11);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            if (new z1(strSubstring3).f2151i) {
                return null;
            }
        }
        return new int[]{i10, i11};
    }

    public String toString() {
        return "UrlParser{url='" + this.f2143a + "', scheme=" + k() + ", userInfo=" + m() + ", host=" + c() + ", port=" + h() + ", path=" + g() + ", lastPathComponent=" + e() + ", query=" + i() + ", fragment=" + b() + ", validUrl=" + this.f2151i + '}';
    }
}
