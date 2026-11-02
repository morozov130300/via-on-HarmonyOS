package i6;

import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: j, reason: collision with root package name */
    public static final a f6995j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f6996a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f6997b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f6998c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f6999d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f7000e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f7001f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f7002g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f7003h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7004i;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final String a(String host) {
            kotlin.jvm.internal.h.f(host, "host");
            int i10 = 0;
            while (i10 < host.length()) {
                char cCharAt = host.charAt(i10);
                if (cCharAt == '\u3002' || cCharAt == '\uff0e' || cCharAt == '\uff61') {
                    StringBuilder sb2 = new StringBuilder(host.length());
                    sb2.append((CharSequence) host, 0, i10);
                    while (i10 < host.length()) {
                        char cCharAt2 = host.charAt(i10);
                        if (cCharAt2 == '\u3002' || cCharAt2 == '\uff0e' || cCharAt2 == '\uff61') {
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

        public final h0 b(String str) {
            return new h0(str);
        }
    }

    public h0(String str) {
        this.f6996a = str != null ? v7.m.I(str).toString() : null;
        o();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        String str = this.f6996a;
        if (str == null || str.length() == 0) {
            return false;
        }
        f fVar = f.f6990a;
        int iD = fVar.d(this.f6996a, 0);
        String strK = k();
        if (strK == null) {
            int[] iArr = this.f7001f;
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
            int[] iArr2 = this.f6999d;
            if (iArr2 != null) {
                kotlin.jvm.internal.h.c(iArr2);
                if ((iD > iArr2[0] || iD < 0) && p(c(), true)) {
                    return true;
                }
            }
            return false;
        }
        int[] iArr3 = this.f7001f;
        if (iArr3 != null) {
            kotlin.jvm.internal.h.c(iArr3);
            int i10 = iArr3[0];
            int[] iArr4 = this.f6997b;
            kotlin.jvm.internal.h.c(iArr4);
            if (i10 == iArr4[1] + 1) {
                if (!kotlin.jvm.internal.h.a("javascript", strK) && !kotlin.jvm.internal.h.a("data", strK)) {
                    if (kotlin.jvm.internal.h.a("about", strK)) {
                        int[] iArr5 = this.f7001f;
                        kotlin.jvm.internal.h.c(iArr5);
                        int i11 = iArr5[0];
                        int[] iArr6 = this.f7001f;
                        kotlin.jvm.internal.h.c(iArr6);
                        if (i11 != iArr6[1] && !fVar.h(g(), 3, new int[]{45})) {
                            if (!kotlin.jvm.internal.h.a("view-source", strK) && !kotlin.jvm.internal.h.a("magnet", strK) && !kotlin.jvm.internal.h.a("sms", strK) && !kotlin.jvm.internal.h.a("tel", strK) && !kotlin.jvm.internal.h.a("mailto", strK) && !kotlin.jvm.internal.h.a("geo", strK) && !kotlin.jvm.internal.h.a("tg", strK)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }
        return iD < 0;
    }

    public final String b() {
        return l(this.f7003h);
    }

    public final String c() {
        String strL = l(this.f6999d);
        if (strL == null) {
            return null;
        }
        String lowerCase = strL.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final int[] d() {
        return this.f6999d;
    }

    public final String e() {
        return l(f());
    }

    public final int[] f() {
        int[] iArr = this.f7001f;
        if (iArr == null) {
            return null;
        }
        kotlin.jvm.internal.h.c(iArr);
        int i10 = iArr[1];
        String str = this.f6996a;
        kotlin.jvm.internal.h.c(str);
        if (str.charAt(i10 - 1) == '/') {
            i10--;
        }
        int[] iArr2 = this.f7001f;
        kotlin.jvm.internal.h.c(iArr2);
        return j(Math.max(iArr2[0], v7.m.A(this.f6996a, '/', i10 - 1, false, 4, null) + 1), i10);
    }

    public final String g() {
        return l(this.f7001f);
    }

    public final String h() {
        return l(this.f7000e);
    }

    public final String i() {
        return l(this.f7002g);
    }

    public final int[] j(int i10, int i11) {
        if (i10 < 0 || i11 < i10) {
            return null;
        }
        return new int[]{i10, i11};
    }

    public final String k() {
        String strL;
        if (!n() || (strL = l(this.f6997b)) == null) {
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
        String str = this.f6996a;
        kotlin.jvm.internal.h.c(str);
        String strSubstring = str.substring(iArr[0], iArr[1]);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String m() {
        return l(this.f6998c);
    }

    public final boolean n() {
        return this.f6997b != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o() {
        int i10;
        int i11;
        String str = this.f6996a;
        if (str == null || str.length() == 0) {
            this.f6997b = null;
            this.f6998c = null;
            this.f6999d = null;
            this.f7000e = null;
            this.f7001f = null;
            this.f7002g = null;
            this.f7003h = null;
            this.f7004i = false;
            return;
        }
        int length = this.f6996a.length();
        int[] iArrT = t(0, v7.m.v(this.f6996a, ':', 0, false, 4, null));
        this.f6997b = iArrT;
        if (iArrT != null) {
            kotlin.jvm.internal.h.c(iArrT);
            int i12 = iArrT[1];
            int i13 = i12 + 1;
            int i14 = i12 + 2;
            if (i14 >= length || this.f6996a.charAt(i13) != '/' || this.f6996a.charAt(i14) != '/') {
                this.f7001f = j(i13, length);
                this.f7004i = a();
                return;
            }
            i10 = i12 + 3;
        } else {
            i10 = 0;
        }
        if (i10 >= length) {
            this.f7004i = a();
            return;
        }
        int[] iArrJ = j(v7.m.A(this.f6996a, '#', length, false, 4, null), length);
        this.f7003h = iArrJ;
        if (iArrJ != null) {
            kotlin.jvm.internal.h.c(iArrJ);
            length = iArrJ[0];
            int[] iArr = this.f7003h;
            kotlin.jvm.internal.h.c(iArr);
            iArr[0] = iArr[0] + 1;
        }
        int i15 = length;
        int i16 = i10;
        int[] iArrJ2 = j(v7.m.v(this.f6996a, '?', i16, false, 4, null), i15);
        this.f7002g = iArrJ2;
        if (iArrJ2 != null) {
            kotlin.jvm.internal.h.c(iArrJ2);
            i15 = iArrJ2[0];
            int[] iArr2 = this.f7002g;
            kotlin.jvm.internal.h.c(iArr2);
            iArr2[0] = iArr2[0] + 1;
        }
        int[] iArrJ3 = j(v7.m.v(this.f6996a, '/', i16, false, 4, null), i15);
        this.f7001f = iArrJ3;
        if (iArrJ3 != null) {
            kotlin.jvm.internal.h.c(iArrJ3);
            i15 = iArrJ3[0];
        } else {
            this.f7001f = new int[]{i15, i15};
        }
        int i17 = i15;
        int iA = v7.m.A(this.f6996a, ':', i17, false, 4, null);
        if (iA > 0 && iA < i17) {
            int i18 = iA + 1;
            if (i18 != i17) {
                f fVar = f.f6990a;
                String strSubstring = this.f6996a.substring(i18, i17);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                if (f.i(fVar, strSubstring, 4, null, 4, null)) {
                    int[] iArrJ4 = j(i18, i17);
                    this.f7000e = iArrJ4;
                    if (iArrJ4 != null) {
                        kotlin.jvm.internal.h.c(iArrJ4);
                        i17 = iArrJ4[0] - 1;
                    }
                }
            }
        }
        int iV = v7.m.v(this.f6996a, '@', i16, false, 4, null);
        if (iV <= 0 || iV > i17) {
            i11 = i16;
        } else {
            int[] iArrJ5 = j(i16, iV);
            this.f6998c = iArrJ5;
            if (iArrJ5 != null) {
                kotlin.jvm.internal.h.c(iArrJ5);
                i11 = iArrJ5[1] + 1;
            }
        }
        this.f6999d = j(i11, i17);
        this.f7004i = a();
    }

    public final boolean p(String str, boolean z10) {
        return !f.f6990a.b(str, z10 ? new int[]{33, 35, 36, 38, 34, 39, 40, 41, 42, 43, 44, 47, 59, 60, 61, 62, 63, 64, 92, 94, 96, 123, 124, 125, 126} : new int[]{33, 35, 36, 37, 38, 34, 39, 40, 41, 42, 43, 44, 47, 59, 60, 61, 62, 63, 64, 92, 94, 95, 96, 123, 124, 125, 126});
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
        String strA = f6995j.a(str);
        if (kotlin.jvm.internal.h.a("localhost", strA) || (this.f6997b != null && f.i(f.f6990a, strA, 6, null, 4, null))) {
            return true;
        }
        if (strA.charAt(0) == '[' && strA.charAt(strA.length() - 1) == ']') {
            if (strA.length() > 3) {
                f fVar = f.f6990a;
                String strSubstring = strA.substring(1, strA.length() - 1);
                kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
                if (fVar.h(strSubstring, 8, new int[]{58})) {
                    return true;
                }
            }
            return false;
        }
        int iA = v7.m.A(strA, '.', 0, false, 6, null);
        if (iA == strA.length() - 1 || strA.charAt(0) == '.' || ((iA > 0 && v7.m.p(strA, "..", false, 2, null)) || !p(strA, false))) {
            return false;
        }
        if (kotlin.jvm.internal.h.a("/", g())) {
            return true;
        }
        if (iA < 0) {
            return false;
        }
        String strSubstring2 = strA.substring(iA + 1);
        kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
        return f.i(f.f6990a, strSubstring2, 4, null, 4, null) ? q(strA) : d0.f6987a.a(strSubstring2);
    }

    public final boolean s() {
        return this.f7004i;
    }

    public final int[] t(int i10, int i11) {
        if (i11 <= i10 || i10 < 0) {
            return null;
        }
        f fVar = f.f6990a;
        String str = this.f6996a;
        kotlin.jvm.internal.h.c(str);
        if (!f.g(fVar, str.charAt(i10), 3, null, 4, null)) {
            return null;
        }
        String strSubstring = this.f6996a.substring(i10, i11);
        kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
        if (!fVar.h(strSubstring, 7, new int[]{43, 46, 45})) {
            return null;
        }
        if (i11 - i10 == 7) {
            String strSubstring2 = this.f6996a.substring(i10, i11);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            String lowerCase = strSubstring2.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
            if (kotlin.jvm.internal.h.a("localhost", lowerCase)) {
                return null;
            }
        }
        if (v7.m.v(this.f6996a, '.', i10, false, 4, null) < i11) {
            String strSubstring3 = this.f6996a.substring(i10, i11);
            kotlin.jvm.internal.h.e(strSubstring3, "substring(...)");
            if (new h0(strSubstring3).f7004i) {
                return null;
            }
        }
        return new int[]{i10, i11};
    }

    public String toString() {
        return "UrlParser{url='" + this.f6996a + "', scheme=" + k() + ", userInfo=" + m() + ", host=" + c() + ", port=" + h() + ", path=" + g() + ", lastPathComponent=" + e() + ", query=" + i() + ", fragment=" + b() + ", validUrl=" + this.f7004i + '}';
    }
}
