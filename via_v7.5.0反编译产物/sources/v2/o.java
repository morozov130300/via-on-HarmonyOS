package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o extends b0.e.d.a.b.AbstractC0137a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13257d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.a.b.AbstractC0137a.AbstractC0138a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f13258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f13259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f13261d;

        @Override // v2.b0.e.d.a.b.AbstractC0137a.AbstractC0138a
        public b0.e.d.a.b.AbstractC0137a a() {
            String str = "";
            if (this.f13258a == null) {
                str = " baseAddress";
            }
            if (this.f13259b == null) {
                str = str + " size";
            }
            if (this.f13260c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new o(this.f13258a.longValue(), this.f13259b.longValue(), this.f13260c, this.f13261d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.a.b.AbstractC0137a.AbstractC0138a
        public b0.e.d.a.b.AbstractC0137a.AbstractC0138a b(long j10) {
            this.f13258a = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0137a.AbstractC0138a
        public b0.e.d.a.b.AbstractC0137a.AbstractC0138a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f13260c = str;
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0137a.AbstractC0138a
        public b0.e.d.a.b.AbstractC0137a.AbstractC0138a d(long j10) {
            this.f13259b = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0137a.AbstractC0138a
        public b0.e.d.a.b.AbstractC0137a.AbstractC0138a e(String str) {
            this.f13261d = str;
            return this;
        }
    }

    @Override // v2.b0.e.d.a.b.AbstractC0137a
    public long b() {
        return this.f13254a;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0137a
    public String c() {
        return this.f13256c;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0137a
    public long d() {
        return this.f13255b;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0137a
    public String e() {
        return this.f13257d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.AbstractC0137a) {
            b0.e.d.a.b.AbstractC0137a abstractC0137a = (b0.e.d.a.b.AbstractC0137a) obj;
            if (this.f13254a == abstractC0137a.b() && this.f13255b == abstractC0137a.d() && this.f13256c.equals(abstractC0137a.c()) && ((str = this.f13257d) != null ? str.equals(abstractC0137a.e()) : abstractC0137a.e() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f13254a;
        long j11 = this.f13255b;
        int iHashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f13256c.hashCode()) * 1000003;
        String str = this.f13257d;
        return (str == null ? 0 : str.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f13254a + ", size=" + this.f13255b + ", name=" + this.f13256c + ", uuid=" + this.f13257d + "}";
    }

    public o(long j10, long j11, String str, String str2) {
        this.f13254a = j10;
        this.f13255b = j11;
        this.f13256c = str;
        this.f13257d = str2;
    }
}
