package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends b0.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f12596a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12597b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12598c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12599d;

    /* renamed from: e, reason: collision with root package name */
    public final long f12600e;

    /* renamed from: f, reason: collision with root package name */
    public final long f12601f;

    /* renamed from: g, reason: collision with root package name */
    public final long f12602g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12603h;

    /* renamed from: i, reason: collision with root package name */
    public final c0 f12604i;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.a.b {

        /* renamed from: a, reason: collision with root package name */
        public Integer f12605a;

        /* renamed from: b, reason: collision with root package name */
        public String f12606b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f12607c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f12608d;

        /* renamed from: e, reason: collision with root package name */
        public Long f12609e;

        /* renamed from: f, reason: collision with root package name */
        public Long f12610f;

        /* renamed from: g, reason: collision with root package name */
        public Long f12611g;

        /* renamed from: h, reason: collision with root package name */
        public String f12612h;

        /* renamed from: i, reason: collision with root package name */
        public c0 f12613i;

        @Override // u2.b0.a.b
        public b0.a a() {
            String str = "";
            if (this.f12605a == null) {
                str = " pid";
            }
            if (this.f12606b == null) {
                str = str + " processName";
            }
            if (this.f12607c == null) {
                str = str + " reasonCode";
            }
            if (this.f12608d == null) {
                str = str + " importance";
            }
            if (this.f12609e == null) {
                str = str + " pss";
            }
            if (this.f12610f == null) {
                str = str + " rss";
            }
            if (this.f12611g == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new c(this.f12605a.intValue(), this.f12606b, this.f12607c.intValue(), this.f12608d.intValue(), this.f12609e.longValue(), this.f12610f.longValue(), this.f12611g.longValue(), this.f12612h, this.f12613i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.a.b
        public b0.a.b b(c0 c0Var) {
            this.f12613i = c0Var;
            return this;
        }

        @Override // u2.b0.a.b
        public b0.a.b c(int i10) {
            this.f12608d = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.a.b
        public b0.a.b d(int i10) {
            this.f12605a = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.a.b
        public b0.a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f12606b = str;
            return this;
        }

        @Override // u2.b0.a.b
        public b0.a.b f(long j10) {
            this.f12609e = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.a.b
        public b0.a.b g(int i10) {
            this.f12607c = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.a.b
        public b0.a.b h(long j10) {
            this.f12610f = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.a.b
        public b0.a.b i(long j10) {
            this.f12611g = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.a.b
        public b0.a.b j(String str) {
            this.f12612h = str;
            return this;
        }
    }

    public c(int i10, String str, int i11, int i12, long j10, long j11, long j12, String str2, c0 c0Var) {
        this.f12596a = i10;
        this.f12597b = str;
        this.f12598c = i11;
        this.f12599d = i12;
        this.f12600e = j10;
        this.f12601f = j11;
        this.f12602g = j12;
        this.f12603h = str2;
        this.f12604i = c0Var;
    }

    @Override // u2.b0.a
    public c0 b() {
        return this.f12604i;
    }

    @Override // u2.b0.a
    public int c() {
        return this.f12599d;
    }

    @Override // u2.b0.a
    public int d() {
        return this.f12596a;
    }

    @Override // u2.b0.a
    public String e() {
        return this.f12597b;
    }

    public boolean equals(Object obj) {
        String str;
        c0 c0Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.a) {
            b0.a aVar = (b0.a) obj;
            if (this.f12596a == aVar.d() && this.f12597b.equals(aVar.e()) && this.f12598c == aVar.g() && this.f12599d == aVar.c() && this.f12600e == aVar.f() && this.f12601f == aVar.h() && this.f12602g == aVar.i() && ((str = this.f12603h) != null ? str.equals(aVar.j()) : aVar.j() == null) && ((c0Var = this.f12604i) != null ? c0Var.equals(aVar.b()) : aVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.b0.a
    public long f() {
        return this.f12600e;
    }

    @Override // u2.b0.a
    public int g() {
        return this.f12598c;
    }

    @Override // u2.b0.a
    public long h() {
        return this.f12601f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f12596a ^ 1000003) * 1000003) ^ this.f12597b.hashCode()) * 1000003) ^ this.f12598c) * 1000003) ^ this.f12599d) * 1000003;
        long j10 = this.f12600e;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f12601f;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f12602g;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        String str = this.f12603h;
        int iHashCode2 = (i12 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        c0 c0Var = this.f12604i;
        return iHashCode2 ^ (c0Var != null ? c0Var.hashCode() : 0);
    }

    @Override // u2.b0.a
    public long i() {
        return this.f12602g;
    }

    @Override // u2.b0.a
    public String j() {
        return this.f12603h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f12596a + ", processName=" + this.f12597b + ", reasonCode=" + this.f12598c + ", importance=" + this.f12599d + ", pss=" + this.f12600e + ", rss=" + this.f12601f + ", timestamp=" + this.f12602g + ", traceFile=" + this.f12603h + ", buildIdMappingForArch=" + this.f12604i + "}";
    }
}
