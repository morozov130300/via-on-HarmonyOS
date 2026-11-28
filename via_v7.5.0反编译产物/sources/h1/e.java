package h1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f5629c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5631b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5632a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5633b = 0;

        public e a() {
            return new e(this.f5632a, this.f5633b);
        }

        public a b(long j10) {
            this.f5633b = j10;
            return this;
        }

        public a c(long j10) {
            this.f5632a = j10;
            return this;
        }
    }

    public e(long j10, long j11) {
        this.f5630a = j10;
        this.f5631b = j11;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f5631b;
    }

    public long b() {
        return this.f5630a;
    }
}
