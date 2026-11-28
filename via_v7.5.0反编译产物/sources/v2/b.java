package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f13121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b0.e f13122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b0.d f13123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b0.a f13124j;

    /* JADX INFO: renamed from: v2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0132b extends b0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f13127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f13128d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f13129e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f13130f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b0.e f13131g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public b0.d f13132h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public b0.a f13133i;

        @Override // v2.b0.b
        public b0 a() {
            String str = "";
            if (this.f13125a == null) {
                str = " sdkVersion";
            }
            if (this.f13126b == null) {
                str = str + " gmpAppId";
            }
            if (this.f13127c == null) {
                str = str + " platform";
            }
            if (this.f13128d == null) {
                str = str + " installationUuid";
            }
            if (this.f13129e == null) {
                str = str + " buildVersion";
            }
            if (this.f13130f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new b(this.f13125a, this.f13126b, this.f13127c.intValue(), this.f13128d, this.f13129e, this.f13130f, this.f13131g, this.f13132h, this.f13133i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.b
        public b0.b b(b0.a aVar) {
            this.f13133i = aVar;
            return this;
        }

        @Override // v2.b0.b
        public b0.b c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f13129e = str;
            return this;
        }

        @Override // v2.b0.b
        public b0.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f13130f = str;
            return this;
        }

        @Override // v2.b0.b
        public b0.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f13126b = str;
            return this;
        }

        @Override // v2.b0.b
        public b0.b f(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f13128d = str;
            return this;
        }

        @Override // v2.b0.b
        public b0.b g(b0.d dVar) {
            this.f13132h = dVar;
            return this;
        }

        @Override // v2.b0.b
        public b0.b h(int i10) {
            this.f13127c = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.b
        public b0.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f13125a = str;
            return this;
        }

        @Override // v2.b0.b
        public b0.b j(b0.e eVar) {
            this.f13131g = eVar;
            return this;
        }

        public C0132b() {
        }

        public C0132b(b0 b0Var) {
            this.f13125a = b0Var.j();
            this.f13126b = b0Var.f();
            this.f13127c = Integer.valueOf(b0Var.i());
            this.f13128d = b0Var.g();
            this.f13129e = b0Var.d();
            this.f13130f = b0Var.e();
            this.f13131g = b0Var.k();
            this.f13132h = b0Var.h();
            this.f13133i = b0Var.c();
        }
    }

    @Override // v2.b0
    public b0.a c() {
        return this.f13124j;
    }

    @Override // v2.b0
    public String d() {
        return this.f13120f;
    }

    @Override // v2.b0
    public String e() {
        return this.f13121g;
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
            if (this.f13116b.equals(b0Var.j()) && this.f13117c.equals(b0Var.f()) && this.f13118d == b0Var.i() && this.f13119e.equals(b0Var.g()) && this.f13120f.equals(b0Var.d()) && this.f13121g.equals(b0Var.e()) && ((eVar = this.f13122h) != null ? eVar.equals(b0Var.k()) : b0Var.k() == null) && ((dVar = this.f13123i) != null ? dVar.equals(b0Var.h()) : b0Var.h() == null) && ((aVar = this.f13124j) != null ? aVar.equals(b0Var.c()) : b0Var.c() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.b0
    public String f() {
        return this.f13117c;
    }

    @Override // v2.b0
    public String g() {
        return this.f13119e;
    }

    @Override // v2.b0
    public b0.d h() {
        return this.f13123i;
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.f13116b.hashCode() ^ 1000003) * 1000003) ^ this.f13117c.hashCode()) * 1000003) ^ this.f13118d) * 1000003) ^ this.f13119e.hashCode()) * 1000003) ^ this.f13120f.hashCode()) * 1000003) ^ this.f13121g.hashCode()) * 1000003;
        b0.e eVar = this.f13122h;
        int iHashCode2 = (iHashCode ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        b0.d dVar = this.f13123i;
        int iHashCode3 = (iHashCode2 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        b0.a aVar = this.f13124j;
        return iHashCode3 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // v2.b0
    public int i() {
        return this.f13118d;
    }

    @Override // v2.b0
    public String j() {
        return this.f13116b;
    }

    @Override // v2.b0
    public b0.e k() {
        return this.f13122h;
    }

    @Override // v2.b0
    public b0.b l() {
        return new C0132b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f13116b + ", gmpAppId=" + this.f13117c + ", platform=" + this.f13118d + ", installationUuid=" + this.f13119e + ", buildVersion=" + this.f13120f + ", displayVersion=" + this.f13121g + ", session=" + this.f13122h + ", ndkPayload=" + this.f13123i + ", appExitInfo=" + this.f13124j + "}";
    }

    public b(String str, String str2, int i10, String str3, String str4, String str5, b0.e eVar, b0.d dVar, b0.a aVar) {
        this.f13116b = str;
        this.f13117c = str2;
        this.f13118d = i10;
        this.f13119e = str3;
        this.f13120f = str4;
        this.f13121g = str5;
        this.f13122h = eVar;
        this.f13123i = dVar;
        this.f13124j = aVar;
    }
}
