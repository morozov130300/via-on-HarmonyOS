package m1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f7791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f7792f;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f7793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f7794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f7795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f7796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f7797e;

        @Override // m1.e.a
        public e a() {
            String str = "";
            if (this.f7793a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f7794b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f7795c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f7796d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f7797e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f7793a.longValue(), this.f7794b.intValue(), this.f7795c.intValue(), this.f7796d.longValue(), this.f7797e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // m1.e.a
        public e.a b(int i10) {
            this.f7795c = Integer.valueOf(i10);
            return this;
        }

        @Override // m1.e.a
        public e.a c(long j10) {
            this.f7796d = Long.valueOf(j10);
            return this;
        }

        @Override // m1.e.a
        public e.a d(int i10) {
            this.f7794b = Integer.valueOf(i10);
            return this;
        }

        @Override // m1.e.a
        public e.a e(int i10) {
            this.f7797e = Integer.valueOf(i10);
            return this;
        }

        @Override // m1.e.a
        public e.a f(long j10) {
            this.f7793a = Long.valueOf(j10);
            return this;
        }
    }

    @Override // m1.e
    public int b() {
        return this.f7790d;
    }

    @Override // m1.e
    public long c() {
        return this.f7791e;
    }

    @Override // m1.e
    public int d() {
        return this.f7789c;
    }

    @Override // m1.e
    public int e() {
        return this.f7792f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f7788b == eVar.f() && this.f7789c == eVar.d() && this.f7790d == eVar.b() && this.f7791e == eVar.c() && this.f7792f == eVar.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // m1.e
    public long f() {
        return this.f7788b;
    }

    public int hashCode() {
        long j10 = this.f7788b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f7789c) * 1000003) ^ this.f7790d) * 1000003;
        long j11 = this.f7791e;
        return this.f7792f ^ ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f7788b + ", loadBatchSize=" + this.f7789c + ", criticalSectionEnterTimeoutMs=" + this.f7790d + ", eventCleanUpAge=" + this.f7791e + ", maxBlobByteSizePerRow=" + this.f7792f + "}";
    }

    public a(long j10, int i10, int i11, long j11, int i12) {
        this.f7788b = j10;
        this.f7789c = i10;
        this.f7790d = i11;
        this.f7791e = j11;
        this.f7792f = i12;
    }
}
