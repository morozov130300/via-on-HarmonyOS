package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s extends b0.e.d.a.b.AbstractC0143e.AbstractC0145b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13288e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f13289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f13293e;

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0145b a() {
            String str = "";
            if (this.f13289a == null) {
                str = " pc";
            }
            if (this.f13290b == null) {
                str = str + " symbol";
            }
            if (this.f13292d == null) {
                str = str + " offset";
            }
            if (this.f13293e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new s(this.f13289a.longValue(), this.f13290b, this.f13291c, this.f13292d.longValue(), this.f13293e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a b(String str) {
            this.f13291c = str;
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a c(int i10) {
            this.f13293e = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a d(long j10) {
            this.f13292d = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a e(long j10) {
            this.f13289a = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f13290b = str;
            return this;
        }
    }

    @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b
    public String b() {
        return this.f13286c;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b
    public int c() {
        return this.f13288e;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b
    public long d() {
        return this.f13287d;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b
    public long e() {
        return this.f13284a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.AbstractC0143e.AbstractC0145b) {
            b0.e.d.a.b.AbstractC0143e.AbstractC0145b abstractC0145b = (b0.e.d.a.b.AbstractC0143e.AbstractC0145b) obj;
            if (this.f13284a == abstractC0145b.e() && this.f13285b.equals(abstractC0145b.f()) && ((str = this.f13286c) != null ? str.equals(abstractC0145b.b()) : abstractC0145b.b() == null) && this.f13287d == abstractC0145b.d() && this.f13288e == abstractC0145b.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b
    public String f() {
        return this.f13285b;
    }

    public int hashCode() {
        long j10 = this.f13284a;
        int iHashCode = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f13285b.hashCode()) * 1000003;
        String str = this.f13286c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j11 = this.f13287d;
        return this.f13288e ^ ((iHashCode2 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f13284a + ", symbol=" + this.f13285b + ", file=" + this.f13286c + ", offset=" + this.f13287d + ", importance=" + this.f13288e + "}";
    }

    public s(long j10, String str, String str2, long j11, int i10) {
        this.f13284a = j10;
        this.f13285b = str;
        this.f13286c = str2;
        this.f13287d = j11;
        this.f13288e = i10;
    }
}
