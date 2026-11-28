package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends b0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f13175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b0.e.a f13177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b0.e.f f13178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b0.e.AbstractC0148e f13179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b0.e.c f13180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f13181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f13182k;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f13185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f13187e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b0.e.a f13188f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b0.e.f f13189g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public b0.e.AbstractC0148e f13190h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public b0.e.c f13191i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public c0 f13192j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f13193k;

        @Override // v2.b0.e.b
        public b0.e a() {
            String str = "";
            if (this.f13183a == null) {
                str = " generator";
            }
            if (this.f13184b == null) {
                str = str + " identifier";
            }
            if (this.f13185c == null) {
                str = str + " startedAt";
            }
            if (this.f13187e == null) {
                str = str + " crashed";
            }
            if (this.f13188f == null) {
                str = str + " app";
            }
            if (this.f13193k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new h(this.f13183a, this.f13184b, this.f13185c.longValue(), this.f13186d, this.f13187e.booleanValue(), this.f13188f, this.f13189g, this.f13190h, this.f13191i, this.f13192j, this.f13193k.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.b
        public b0.e.b b(b0.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f13188f = aVar;
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b c(boolean z10) {
            this.f13187e = Boolean.valueOf(z10);
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b d(b0.e.c cVar) {
            this.f13191i = cVar;
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b e(Long l10) {
            this.f13186d = l10;
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b f(c0 c0Var) {
            this.f13192j = c0Var;
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f13183a = str;
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b h(int i10) {
            this.f13193k = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f13184b = str;
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b k(b0.e.AbstractC0148e abstractC0148e) {
            this.f13190h = abstractC0148e;
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b l(long j10) {
            this.f13185c = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.b
        public b0.e.b m(b0.e.f fVar) {
            this.f13189g = fVar;
            return this;
        }

        public b() {
        }

        public b(b0.e eVar) {
            this.f13183a = eVar.f();
            this.f13184b = eVar.h();
            this.f13185c = Long.valueOf(eVar.k());
            this.f13186d = eVar.d();
            this.f13187e = Boolean.valueOf(eVar.m());
            this.f13188f = eVar.b();
            this.f13189g = eVar.l();
            this.f13190h = eVar.j();
            this.f13191i = eVar.c();
            this.f13192j = eVar.e();
            this.f13193k = Integer.valueOf(eVar.g());
        }
    }

    @Override // v2.b0.e
    public b0.e.a b() {
        return this.f13177f;
    }

    @Override // v2.b0.e
    public b0.e.c c() {
        return this.f13180i;
    }

    @Override // v2.b0.e
    public Long d() {
        return this.f13175d;
    }

    @Override // v2.b0.e
    public c0 e() {
        return this.f13181j;
    }

    public boolean equals(Object obj) {
        Long l10;
        b0.e.f fVar;
        b0.e.AbstractC0148e abstractC0148e;
        b0.e.c cVar;
        c0 c0Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e) {
            b0.e eVar = (b0.e) obj;
            if (this.f13172a.equals(eVar.f()) && this.f13173b.equals(eVar.h()) && this.f13174c == eVar.k() && ((l10 = this.f13175d) != null ? l10.equals(eVar.d()) : eVar.d() == null) && this.f13176e == eVar.m() && this.f13177f.equals(eVar.b()) && ((fVar = this.f13178g) != null ? fVar.equals(eVar.l()) : eVar.l() == null) && ((abstractC0148e = this.f13179h) != null ? abstractC0148e.equals(eVar.j()) : eVar.j() == null) && ((cVar = this.f13180i) != null ? cVar.equals(eVar.c()) : eVar.c() == null) && ((c0Var = this.f13181j) != null ? c0Var.equals(eVar.e()) : eVar.e() == null) && this.f13182k == eVar.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.b0.e
    public String f() {
        return this.f13172a;
    }

    @Override // v2.b0.e
    public int g() {
        return this.f13182k;
    }

    @Override // v2.b0.e
    public String h() {
        return this.f13173b;
    }

    public int hashCode() {
        int iHashCode = (((this.f13172a.hashCode() ^ 1000003) * 1000003) ^ this.f13173b.hashCode()) * 1000003;
        long j10 = this.f13174c;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        Long l10 = this.f13175d;
        int iHashCode2 = (((((i10 ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f13176e ? 1231 : 1237)) * 1000003) ^ this.f13177f.hashCode()) * 1000003;
        b0.e.f fVar = this.f13178g;
        int iHashCode3 = (iHashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        b0.e.AbstractC0148e abstractC0148e = this.f13179h;
        int iHashCode4 = (iHashCode3 ^ (abstractC0148e == null ? 0 : abstractC0148e.hashCode())) * 1000003;
        b0.e.c cVar = this.f13180i;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        c0 c0Var = this.f13181j;
        return ((iHashCode5 ^ (c0Var != null ? c0Var.hashCode() : 0)) * 1000003) ^ this.f13182k;
    }

    @Override // v2.b0.e
    public b0.e.AbstractC0148e j() {
        return this.f13179h;
    }

    @Override // v2.b0.e
    public long k() {
        return this.f13174c;
    }

    @Override // v2.b0.e
    public b0.e.f l() {
        return this.f13178g;
    }

    @Override // v2.b0.e
    public boolean m() {
        return this.f13176e;
    }

    @Override // v2.b0.e
    public b0.e.b n() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f13172a + ", identifier=" + this.f13173b + ", startedAt=" + this.f13174c + ", endedAt=" + this.f13175d + ", crashed=" + this.f13176e + ", app=" + this.f13177f + ", user=" + this.f13178g + ", os=" + this.f13179h + ", device=" + this.f13180i + ", events=" + this.f13181j + ", generatorType=" + this.f13182k + "}";
    }

    public h(String str, String str2, long j10, Long l10, boolean z10, b0.e.a aVar, b0.e.f fVar, b0.e.AbstractC0148e abstractC0148e, b0.e.c cVar, c0 c0Var, int i10) {
        this.f13172a = str;
        this.f13173b = str2;
        this.f13174c = j10;
        this.f13175d = l10;
        this.f13176e = z10;
        this.f13177f = aVar;
        this.f13178g = fVar;
        this.f13179h = abstractC0148e;
        this.f13180i = cVar;
        this.f13181j = c0Var;
        this.f13182k = i10;
    }
}
