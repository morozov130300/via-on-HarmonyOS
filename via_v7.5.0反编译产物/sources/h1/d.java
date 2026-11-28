package h1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f5624c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5626b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5627a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5628b = 0;

        public d a() {
            return new d(this.f5627a, this.f5628b);
        }

        public a b(long j10) {
            this.f5627a = j10;
            return this;
        }

        public a c(long j10) {
            this.f5628b = j10;
            return this;
        }
    }

    public d(long j10, long j11) {
        this.f5625a = j10;
        this.f5626b = j11;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f5625a;
    }

    public long b() {
        return this.f5626b;
    }
}
