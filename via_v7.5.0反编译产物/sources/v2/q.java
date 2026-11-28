package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q extends b0.e.d.a.b.AbstractC0141d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13274c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.a.b.AbstractC0141d.AbstractC0142a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f13277c;

        @Override // v2.b0.e.d.a.b.AbstractC0141d.AbstractC0142a
        public b0.e.d.a.b.AbstractC0141d a() {
            String str = "";
            if (this.f13275a == null) {
                str = " name";
            }
            if (this.f13276b == null) {
                str = str + " code";
            }
            if (this.f13277c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new q(this.f13275a, this.f13276b, this.f13277c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.a.b.AbstractC0141d.AbstractC0142a
        public b0.e.d.a.b.AbstractC0141d.AbstractC0142a b(long j10) {
            this.f13277c = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0141d.AbstractC0142a
        public b0.e.d.a.b.AbstractC0141d.AbstractC0142a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f13276b = str;
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0141d.AbstractC0142a
        public b0.e.d.a.b.AbstractC0141d.AbstractC0142a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f13275a = str;
            return this;
        }
    }

    @Override // v2.b0.e.d.a.b.AbstractC0141d
    public long b() {
        return this.f13274c;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0141d
    public String c() {
        return this.f13273b;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0141d
    public String d() {
        return this.f13272a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.AbstractC0141d) {
            b0.e.d.a.b.AbstractC0141d abstractC0141d = (b0.e.d.a.b.AbstractC0141d) obj;
            if (this.f13272a.equals(abstractC0141d.d()) && this.f13273b.equals(abstractC0141d.c()) && this.f13274c == abstractC0141d.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.f13272a.hashCode() ^ 1000003) * 1000003) ^ this.f13273b.hashCode()) * 1000003;
        long j10 = this.f13274c;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f13272a + ", code=" + this.f13273b + ", address=" + this.f13274c + "}";
    }

    public q(String str, String str2, long j10) {
        this.f13272a = str;
        this.f13273b = str2;
        this.f13274c = j10;
    }
}
