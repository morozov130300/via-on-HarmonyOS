package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t extends b0.e.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f13294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f13299f;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f13300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f13301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f13302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f13303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f13304e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f13305f;

        @Override // v2.b0.e.d.c.a
        public b0.e.d.c a() {
            String str = "";
            if (this.f13301b == null) {
                str = " batteryVelocity";
            }
            if (this.f13302c == null) {
                str = str + " proximityOn";
            }
            if (this.f13303d == null) {
                str = str + " orientation";
            }
            if (this.f13304e == null) {
                str = str + " ramUsed";
            }
            if (this.f13305f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new t(this.f13300a, this.f13301b.intValue(), this.f13302c.booleanValue(), this.f13303d.intValue(), this.f13304e.longValue(), this.f13305f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.c.a
        public b0.e.d.c.a b(Double d10) {
            this.f13300a = d10;
            return this;
        }

        @Override // v2.b0.e.d.c.a
        public b0.e.d.c.a c(int i10) {
            this.f13301b = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.d.c.a
        public b0.e.d.c.a d(long j10) {
            this.f13305f = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.d.c.a
        public b0.e.d.c.a e(int i10) {
            this.f13303d = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.d.c.a
        public b0.e.d.c.a f(boolean z10) {
            this.f13302c = Boolean.valueOf(z10);
            return this;
        }

        @Override // v2.b0.e.d.c.a
        public b0.e.d.c.a g(long j10) {
            this.f13304e = Long.valueOf(j10);
            return this;
        }
    }

    @Override // v2.b0.e.d.c
    public Double b() {
        return this.f13294a;
    }

    @Override // v2.b0.e.d.c
    public int c() {
        return this.f13295b;
    }

    @Override // v2.b0.e.d.c
    public long d() {
        return this.f13299f;
    }

    @Override // v2.b0.e.d.c
    public int e() {
        return this.f13297d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.c) {
            b0.e.d.c cVar = (b0.e.d.c) obj;
            Double d10 = this.f13294a;
            if (d10 != null ? d10.equals(cVar.b()) : cVar.b() == null) {
                if (this.f13295b == cVar.c() && this.f13296c == cVar.g() && this.f13297d == cVar.e() && this.f13298e == cVar.f() && this.f13299f == cVar.d()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // v2.b0.e.d.c
    public long f() {
        return this.f13298e;
    }

    @Override // v2.b0.e.d.c
    public boolean g() {
        return this.f13296c;
    }

    public int hashCode() {
        Double d10 = this.f13294a;
        int iHashCode = ((((((((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003) ^ this.f13295b) * 1000003) ^ (this.f13296c ? 1231 : 1237)) * 1000003) ^ this.f13297d) * 1000003;
        long j10 = this.f13298e;
        long j11 = this.f13299f;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f13294a + ", batteryVelocity=" + this.f13295b + ", proximityOn=" + this.f13296c + ", orientation=" + this.f13297d + ", ramUsed=" + this.f13298e + ", diskUsed=" + this.f13299f + "}";
    }

    public t(Double d10, int i10, boolean z10, int i11, long j10, long j11) {
        this.f13294a = d10;
        this.f13295b = i10;
        this.f13296c = z10;
        this.f13297d = i11;
        this.f13298e = j10;
        this.f13299f = j11;
    }
}
