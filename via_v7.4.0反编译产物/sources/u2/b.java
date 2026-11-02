package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public final String f12577b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12578c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12579d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12580e;

    /* renamed from: f, reason: collision with root package name */
    public final String f12581f;

    /* renamed from: g, reason: collision with root package name */
    public final String f12582g;

    /* renamed from: h, reason: collision with root package name */
    public final b0.e f12583h;

    /* renamed from: i, reason: collision with root package name */
    public final b0.d f12584i;

    /* renamed from: j, reason: collision with root package name */
    public final b0.a f12585j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: u2.b$b, reason: collision with other inner class name */
    public static final class C0127b extends b0.b {

        /* renamed from: a, reason: collision with root package name */
        public String f12586a;

        /* renamed from: b, reason: collision with root package name */
        public String f12587b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f12588c;

        /* renamed from: d, reason: collision with root package name */
        public String f12589d;

        /* renamed from: e, reason: collision with root package name */
        public String f12590e;

        /* renamed from: f, reason: collision with root package name */
        public String f12591f;

        /* renamed from: g, reason: collision with root package name */
        public b0.e f12592g;

        /* renamed from: h, reason: collision with root package name */
        public b0.d f12593h;

        /* renamed from: i, reason: collision with root package name */
        public b0.a f12594i;

        public C0127b() {
        }

        public C0127b(b0 b0Var) {
            this.f12586a = b0Var.j();
            this.f12587b = b0Var.f();
            this.f12588c = Integer.valueOf(b0Var.i());
            this.f12589d = b0Var.g();
            this.f12590e = b0Var.d();
            this.f12591f = b0Var.e();
            this.f12592g = b0Var.k();
            this.f12593h = b0Var.h();
            this.f12594i = b0Var.c();
        }

        @Override // u2.b0.b
        public b0 a() {
            String str = "";
            if (this.f12586a == null) {
                str = " sdkVersion";
            }
            if (this.f12587b == null) {
                str = str + " gmpAppId";
            }
            if (this.f12588c == null) {
                str = str + " platform";
            }
            if (this.f12589d == null) {
                str = str + " installationUuid";
            }
            if (this.f12590e == null) {
                str = str + " buildVersion";
            }
            if (this.f12591f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new b(this.f12586a, this.f12587b, this.f12588c.intValue(), this.f12589d, this.f12590e, this.f12591f, this.f12592g, this.f12593h, this.f12594i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.b
        public b0.b b(b0.a aVar) {
            this.f12594i = aVar;
            return this;
        }

        @Override // u2.b0.b
        public b0.b c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f12590e = str;
            return this;
        }

        @Override // u2.b0.b
        public b0.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f12591f = str;
            return this;
        }

        @Override // u2.b0.b
        public b0.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f12587b = str;
            return this;
        }

        @Override // u2.b0.b
        public b0.b f(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f12589d = str;
            return this;
        }

        @Override // u2.b0.b
        public b0.b g(b0.d dVar) {
            this.f12593h = dVar;
            return this;
        }

        @Override // u2.b0.b
        public b0.b h(int i10) {
            this.f12588c = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.b
        public b0.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f12586a = str;
            return this;
        }

        @Override // u2.b0.b
        public b0.b j(b0.e eVar) {
            this.f12592g = eVar;
            return this;
        }
    }

    public b(String str, String str2, int i10, String str3, String str4, String str5, b0.e eVar, b0.d dVar, b0.a aVar) {
        this.f12577b = str;
        this.f12578c = str2;
        this.f12579d = i10;
        this.f12580e = str3;
        this.f12581f = str4;
        this.f12582g = str5;
        this.f12583h = eVar;
        this.f12584i = dVar;
        this.f12585j = aVar;
    }

    @Override // u2.b0
    public b0.a c() {
        return this.f12585j;
    }

    @Override // u2.b0
    public String d() {
        return this.f12581f;
    }

    @Override // u2.b0
    public String e() {
        return this.f12582g;
    }

    public boolean equals(Object obj) {
        b0.e eVar;
        b0.d dVar;
        b0.a aVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            if (this.f12577b.equals(b0Var.j()) && this.f12578c.equals(b0Var.f()) && this.f12579d == b0Var.i() && this.f12580e.equals(b0Var.g()) && this.f12581f.equals(b0Var.d()) && this.f12582g.equals(b0Var.e()) && ((eVar = this.f12583h) != null ? eVar.equals(b0Var.k()) : b0Var.k() == null) && ((dVar = this.f12584i) != null ? dVar.equals(b0Var.h()) : b0Var.h() == null) && ((aVar = this.f12585j) != null ? aVar.equals(b0Var.c()) : b0Var.c() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.b0
    public String f() {
        return this.f12578c;
    }

    @Override // u2.b0
    public String g() {
        return this.f12580e;
    }

    @Override // u2.b0
    public b0.d h() {
        return this.f12584i;
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.f12577b.hashCode() ^ 1000003) * 1000003) ^ this.f12578c.hashCode()) * 1000003) ^ this.f12579d) * 1000003) ^ this.f12580e.hashCode()) * 1000003) ^ this.f12581f.hashCode()) * 1000003) ^ this.f12582g.hashCode()) * 1000003;
        b0.e eVar = this.f12583h;
        int iHashCode2 = (iHashCode ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        b0.d dVar = this.f12584i;
        int iHashCode3 = (iHashCode2 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        b0.a aVar = this.f12585j;
        return iHashCode3 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // u2.b0
    public int i() {
        return this.f12579d;
    }

    @Override // u2.b0
    public String j() {
        return this.f12577b;
    }

    @Override // u2.b0
    public b0.e k() {
        return this.f12583h;
    }

    @Override // u2.b0
    public b0.b l() {
        return new C0127b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f12577b + ", gmpAppId=" + this.f12578c + ", platform=" + this.f12579d + ", installationUuid=" + this.f12580e + ", buildVersion=" + this.f12581f + ", displayVersion=" + this.f12582g + ", session=" + this.f12583h + ", ndkPayload=" + this.f12584i + ", appExitInfo=" + this.f12585j + "}";
    }
}
