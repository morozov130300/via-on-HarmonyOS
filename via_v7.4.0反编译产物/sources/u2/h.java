package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h extends b0.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f12633a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12634b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12635c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f12636d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12637e;

    /* renamed from: f, reason: collision with root package name */
    public final b0.e.a f12638f;

    /* renamed from: g, reason: collision with root package name */
    public final b0.e.f f12639g;

    /* renamed from: h, reason: collision with root package name */
    public final b0.e.AbstractC0143e f12640h;

    /* renamed from: i, reason: collision with root package name */
    public final b0.e.c f12641i;

    /* renamed from: j, reason: collision with root package name */
    public final c0 f12642j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12643k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.b {

        /* renamed from: a, reason: collision with root package name */
        public String f12644a;

        /* renamed from: b, reason: collision with root package name */
        public String f12645b;

        /* renamed from: c, reason: collision with root package name */
        public Long f12646c;

        /* renamed from: d, reason: collision with root package name */
        public Long f12647d;

        /* renamed from: e, reason: collision with root package name */
        public Boolean f12648e;

        /* renamed from: f, reason: collision with root package name */
        public b0.e.a f12649f;

        /* renamed from: g, reason: collision with root package name */
        public b0.e.f f12650g;

        /* renamed from: h, reason: collision with root package name */
        public b0.e.AbstractC0143e f12651h;

        /* renamed from: i, reason: collision with root package name */
        public b0.e.c f12652i;

        /* renamed from: j, reason: collision with root package name */
        public c0 f12653j;

        /* renamed from: k, reason: collision with root package name */
        public Integer f12654k;

        public b() {
        }

        public b(b0.e eVar) {
            this.f12644a = eVar.f();
            this.f12645b = eVar.h();
            this.f12646c = Long.valueOf(eVar.k());
            this.f12647d = eVar.d();
            this.f12648e = Boolean.valueOf(eVar.m());
            this.f12649f = eVar.b();
            this.f12650g = eVar.l();
            this.f12651h = eVar.j();
            this.f12652i = eVar.c();
            this.f12653j = eVar.e();
            this.f12654k = Integer.valueOf(eVar.g());
        }

        @Override // u2.b0.e.b
        public b0.e a() {
            String str = "";
            if (this.f12644a == null) {
                str = " generator";
            }
            if (this.f12645b == null) {
                str = str + " identifier";
            }
            if (this.f12646c == null) {
                str = str + " startedAt";
            }
            if (this.f12648e == null) {
                str = str + " crashed";
            }
            if (this.f12649f == null) {
                str = str + " app";
            }
            if (this.f12654k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new h(this.f12644a, this.f12645b, this.f12646c.longValue(), this.f12647d, this.f12648e.booleanValue(), this.f12649f, this.f12650g, this.f12651h, this.f12652i, this.f12653j, this.f12654k.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.b
        public b0.e.b b(b0.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f12649f = aVar;
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b c(boolean z10) {
            this.f12648e = Boolean.valueOf(z10);
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b d(b0.e.c cVar) {
            this.f12652i = cVar;
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b e(Long l10) {
            this.f12647d = l10;
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b f(c0 c0Var) {
            this.f12653j = c0Var;
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f12644a = str;
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b h(int i10) {
            this.f12654k = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f12645b = str;
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b k(b0.e.AbstractC0143e abstractC0143e) {
            this.f12651h = abstractC0143e;
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b l(long j10) {
            this.f12646c = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.b
        public b0.e.b m(b0.e.f fVar) {
            this.f12650g = fVar;
            return this;
        }
    }

    public h(String str, String str2, long j10, Long l10, boolean z10, b0.e.a aVar, b0.e.f fVar, b0.e.AbstractC0143e abstractC0143e, b0.e.c cVar, c0 c0Var, int i10) {
        this.f12633a = str;
        this.f12634b = str2;
        this.f12635c = j10;
        this.f12636d = l10;
        this.f12637e = z10;
        this.f12638f = aVar;
        this.f12639g = fVar;
        this.f12640h = abstractC0143e;
        this.f12641i = cVar;
        this.f12642j = c0Var;
        this.f12643k = i10;
    }

    @Override // u2.b0.e
    public b0.e.a b() {
        return this.f12638f;
    }

    @Override // u2.b0.e
    public b0.e.c c() {
        return this.f12641i;
    }

    @Override // u2.b0.e
    public Long d() {
        return this.f12636d;
    }

    @Override // u2.b0.e
    public c0 e() {
        return this.f12642j;
    }

    public boolean equals(Object obj) {
        Long l10;
        b0.e.f fVar;
        b0.e.AbstractC0143e abstractC0143e;
        b0.e.c cVar;
        c0 c0Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e) {
            b0.e eVar = (b0.e) obj;
            if (this.f12633a.equals(eVar.f()) && this.f12634b.equals(eVar.h()) && this.f12635c == eVar.k() && ((l10 = this.f12636d) != null ? l10.equals(eVar.d()) : eVar.d() == null) && this.f12637e == eVar.m() && this.f12638f.equals(eVar.b()) && ((fVar = this.f12639g) != null ? fVar.equals(eVar.l()) : eVar.l() == null) && ((abstractC0143e = this.f12640h) != null ? abstractC0143e.equals(eVar.j()) : eVar.j() == null) && ((cVar = this.f12641i) != null ? cVar.equals(eVar.c()) : eVar.c() == null) && ((c0Var = this.f12642j) != null ? c0Var.equals(eVar.e()) : eVar.e() == null) && this.f12643k == eVar.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.b0.e
    public String f() {
        return this.f12633a;
    }

    @Override // u2.b0.e
    public int g() {
        return this.f12643k;
    }

    @Override // u2.b0.e
    public String h() {
        return this.f12634b;
    }

    public int hashCode() {
        int iHashCode = (((this.f12633a.hashCode() ^ 1000003) * 1000003) ^ this.f12634b.hashCode()) * 1000003;
        long j10 = this.f12635c;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        Long l10 = this.f12636d;
        int iHashCode2 = (((((i10 ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f12637e ? 1231 : 1237)) * 1000003) ^ this.f12638f.hashCode()) * 1000003;
        b0.e.f fVar = this.f12639g;
        int iHashCode3 = (iHashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        b0.e.AbstractC0143e abstractC0143e = this.f12640h;
        int iHashCode4 = (iHashCode3 ^ (abstractC0143e == null ? 0 : abstractC0143e.hashCode())) * 1000003;
        b0.e.c cVar = this.f12641i;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        c0 c0Var = this.f12642j;
        return ((iHashCode5 ^ (c0Var != null ? c0Var.hashCode() : 0)) * 1000003) ^ this.f12643k;
    }

    @Override // u2.b0.e
    public b0.e.AbstractC0143e j() {
        return this.f12640h;
    }

    @Override // u2.b0.e
    public long k() {
        return this.f12635c;
    }

    @Override // u2.b0.e
    public b0.e.f l() {
        return this.f12639g;
    }

    @Override // u2.b0.e
    public boolean m() {
        return this.f12637e;
    }

    @Override // u2.b0.e
    public b0.e.b n() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f12633a + ", identifier=" + this.f12634b + ", startedAt=" + this.f12635c + ", endedAt=" + this.f12636d + ", crashed=" + this.f12637e + ", app=" + this.f12638f + ", user=" + this.f12639g + ", os=" + this.f12640h + ", device=" + this.f12641i + ", events=" + this.f12642j + ", generatorType=" + this.f12643k + "}";
    }
}
