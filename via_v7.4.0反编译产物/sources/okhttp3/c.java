package okhttp3;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: n, reason: collision with root package name */
    public static final c f10539n = new a().c().a();

    /* renamed from: o, reason: collision with root package name */
    public static final c f10540o = new a().d().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10541a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10542b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10543c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10544d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10545e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10546f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10547g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10548h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10549i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f10550j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10551k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f10552l;

    /* renamed from: m, reason: collision with root package name */
    public String f10553m;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10554a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10555b;

        /* renamed from: c, reason: collision with root package name */
        public int f10556c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f10557d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f10558e = -1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f10559f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f10560g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f10561h;

        public c a() {
            return new c(this);
        }

        public a b(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f10557d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i10);
        }

        public a c() {
            this.f10554a = true;
            return this;
        }

        public a d() {
            this.f10559f = true;
            return this;
        }
    }

    public c(a aVar) {
        this.f10541a = aVar.f10554a;
        this.f10542b = aVar.f10555b;
        this.f10543c = aVar.f10556c;
        this.f10544d = -1;
        this.f10545e = false;
        this.f10546f = false;
        this.f10547g = false;
        this.f10548h = aVar.f10557d;
        this.f10549i = aVar.f10558e;
        this.f10550j = aVar.f10559f;
        this.f10551k = aVar.f10560g;
        this.f10552l = aVar.f10561h;
    }

    public c(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f10541a = z10;
        this.f10542b = z11;
        this.f10543c = i10;
        this.f10544d = i11;
        this.f10545e = z12;
        this.f10546f = z13;
        this.f10547g = z14;
        this.f10548h = i12;
        this.f10549i = i13;
        this.f10550j = z15;
        this.f10551k = z16;
        this.f10552l = z17;
        this.f10553m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c k(q qVar) {
        int i10;
        int iF;
        String strTrim;
        q qVar2 = qVar;
        int iJ = qVar2.j();
        int i11 = 0;
        boolean z10 = true;
        String str = null;
        boolean z11 = false;
        boolean z12 = false;
        int iD = -1;
        int iD2 = -1;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        int iD3 = -1;
        int iD4 = -1;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        while (i11 < iJ) {
            String strE = qVar2.e(i11);
            String strK = qVar2.k(i11);
            if (strE.equalsIgnoreCase("Cache-Control")) {
                if (str == null) {
                    str = strK;
                }
                for (i10 = 0; i10 < strK.length(); i10 = iF) {
                    int iF2 = xb.e.f(strK, i10, "=,;");
                    String strTrim2 = strK.substring(i10, iF2).trim();
                    if (iF2 == strK.length() || strK.charAt(iF2) == ',' || strK.charAt(iF2) == ';') {
                        iF = iF2 + 1;
                        strTrim = null;
                    } else {
                        int iG = xb.e.g(strK, iF2 + 1);
                        if (iG >= strK.length() || strK.charAt(iG) != '\"') {
                            iF = xb.e.f(strK, iG, ",;");
                            strTrim = strK.substring(iG, iF).trim();
                        } else {
                            int i12 = iG + 1;
                            int iF3 = xb.e.f(strK, i12, "\"");
                            strTrim = strK.substring(i12, iF3);
                            iF = iF3 + 1;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim2)) {
                        z11 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim2)) {
                        z12 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim2)) {
                        iD = xb.e.d(strTrim, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim2)) {
                        iD2 = xb.e.d(strTrim, -1);
                    } else if ("private".equalsIgnoreCase(strTrim2)) {
                        z13 = true;
                    } else if ("public".equalsIgnoreCase(strTrim2)) {
                        z14 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim2)) {
                        z15 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim2)) {
                        iD3 = xb.e.d(strTrim, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim2)) {
                        iD4 = xb.e.d(strTrim, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim2)) {
                        z16 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim2)) {
                        z17 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim2)) {
                        z18 = true;
                    }
                }
                i11++;
                qVar2 = qVar;
            } else if (!strE.equalsIgnoreCase("Pragma")) {
                i11++;
                qVar2 = qVar;
            }
            z10 = false;
            while (i10 < strK.length()) {
            }
            i11++;
            qVar2 = qVar;
        }
        return new c(z11, z12, iD, iD2, z13, z14, z15, iD3, iD4, z16, z17, z18, !z10 ? null : str);
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f10541a) {
            sb2.append("no-cache, ");
        }
        if (this.f10542b) {
            sb2.append("no-store, ");
        }
        if (this.f10543c != -1) {
            sb2.append("max-age=");
            sb2.append(this.f10543c);
            sb2.append(", ");
        }
        if (this.f10544d != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.f10544d);
            sb2.append(", ");
        }
        if (this.f10545e) {
            sb2.append("private, ");
        }
        if (this.f10546f) {
            sb2.append("public, ");
        }
        if (this.f10547g) {
            sb2.append("must-revalidate, ");
        }
        if (this.f10548h != -1) {
            sb2.append("max-stale=");
            sb2.append(this.f10548h);
            sb2.append(", ");
        }
        if (this.f10549i != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.f10549i);
            sb2.append(", ");
        }
        if (this.f10550j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f10551k) {
            sb2.append("no-transform, ");
        }
        if (this.f10552l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    public boolean b() {
        return this.f10545e;
    }

    public boolean c() {
        return this.f10546f;
    }

    public int d() {
        return this.f10543c;
    }

    public int e() {
        return this.f10548h;
    }

    public int f() {
        return this.f10549i;
    }

    public boolean g() {
        return this.f10547g;
    }

    public boolean h() {
        return this.f10541a;
    }

    public boolean i() {
        return this.f10542b;
    }

    public boolean j() {
        return this.f10550j;
    }

    public String toString() {
        String str = this.f10553m;
        if (str != null) {
            return str;
        }
        String strA = a();
        this.f10553m = strA;
        return strA;
    }
}
