package a3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f30a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f31b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f32c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f35f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f36g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f37h;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f38a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f39b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f40c;

        public a(boolean z10, boolean z11, boolean z12) {
            this.f38a = z10;
            this.f39b = z11;
            this.f40c = z12;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f42b;

        public b(int i10, int i11) {
            this.f41a = i10;
            this.f42b = i11;
        }
    }

    public d(long j10, b bVar, a aVar, int i10, int i11, double d10, double d11, int i12) {
        this.f32c = j10;
        this.f30a = bVar;
        this.f31b = aVar;
        this.f33d = i10;
        this.f34e = i11;
        this.f35f = d10;
        this.f36g = d11;
        this.f37h = i12;
    }

    public boolean a(long j10) {
        return this.f32c < j10;
    }
}
