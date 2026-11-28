package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends b0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f13140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f13141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f13143i;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f13144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f13146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f13147d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f13148e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f13149f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Long f13150g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f13151h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public c0 f13152i;

        @Override // v2.b0.a.b
        public b0.a a() {
            String str = "";
            if (this.f13144a == null) {
                str = " pid";
            }
            if (this.f13145b == null) {
                str = str + " processName";
            }
            if (this.f13146c == null) {
                str = str + " reasonCode";
            }
            if (this.f13147d == null) {
                str = str + " importance";
            }
            if (this.f13148e == null) {
                str = str + " pss";
            }
            if (this.f13149f == null) {
                str = str + " rss";
            }
            if (this.f13150g == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new c(this.f13144a.intValue(), this.f13145b, this.f13146c.intValue(), this.f13147d.intValue(), this.f13148e.longValue(), this.f13149f.longValue(), this.f13150g.longValue(), this.f13151h, this.f13152i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.a.b
        public b0.a.b b(c0 c0Var) {
            this.f13152i = c0Var;
            return this;
        }

        @Override // v2.b0.a.b
        public b0.a.b c(int i10) {
            this.f13147d = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.a.b
        public b0.a.b d(int i10) {
            this.f13144a = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.a.b
        public b0.a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f13145b = str;
            return this;
        }

        @Override // v2.b0.a.b
        public b0.a.b f(long j10) {
            this.f13148e = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.a.b
        public b0.a.b g(int i10) {
            this.f13146c = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.a.b
        public b0.a.b h(long j10) {
            this.f13149f = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.a.b
        public b0.a.b i(long j10) {
            this.f13150g = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.a.b
        public b0.a.b j(String str) {
            this.f13151h = str;
            return this;
        }
    }

    @Override // v2.b0.a
    public c0 b() {
        return this.f13143i;
    }

    @Override // v2.b0.a
    public int c() {
        return this.f13138d;
    }

    @Override // v2.b0.a
    public int d() {
        return this.f13135a;
    }

    @Override // v2.b0.a
    public String e() {
        return this.f13136b;
    }

    public boolean equals(Object obj) {
        String str;
        c0 c0Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.a) {
            b0.a aVar = (b0.a) obj;
            if (this.f13135a == aVar.d() && this.f13136b.equals(aVar.e()) && this.f13137c == aVar.g() && this.f13138d == aVar.c() && this.f13139e == aVar.f() && this.f13140f == aVar.h() && this.f13141g == aVar.i() && ((str = this.f13142h) != null ? str.equals(aVar.j()) : aVar.j() == null) && ((c0Var = this.f13143i) != null ? c0Var.equals(aVar.b()) : aVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.b0.a
    public long f() {
        return this.f13139e;
    }

    @Override // v2.b0.a
    public int g() {
        return this.f13137c;
    }

    @Override // v2.b0.a
    public long h() {
        return this.f13140f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f13135a ^ 1000003) * 1000003) ^ this.f13136b.hashCode()) * 1000003) ^ this.f13137c) * 1000003) ^ this.f13138d) * 1000003;
        long j10 = this.f13139e;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f13140f;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f13141g;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        String str = this.f13142h;
        int iHashCode2 = (i12 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        c0 c0Var = this.f13143i;
        return iHashCode2 ^ (c0Var != null ? c0Var.hashCode() : 0);
    }

    @Override // v2.b0.a
    public long i() {
        return this.f13141g;
    }

    @Override // v2.b0.a
    public String j() {
        return this.f13142h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f13135a + ", processName=" + this.f13136b + ", reasonCode=" + this.f13137c + ", importance=" + this.f13138d + ", pss=" + this.f13139e + ", rss=" + this.f13140f + ", timestamp=" + this.f13141g + ", traceFile=" + this.f13142h + ", buildIdMappingForArch=" + this.f13143i + "}";
    }

    public c(int i10, String str, int i11, int i12, long j10, long j11, long j12, String str2, c0 c0Var) {
        this.f13135a = i10;
        this.f13136b = str;
        this.f13137c = i11;
        this.f13138d = i12;
        this.f13139e = j10;
        this.f13140f = j11;
        this.f13141g = j12;
        this.f13142h = str2;
        this.f13143i = c0Var;
    }
}
