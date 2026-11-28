package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1.c f5392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5393b;

    public v9(x1.c cVar) {
        u1.f.h(cVar);
        this.f5392a = cVar;
    }

    public final void a() {
        this.f5393b = 0L;
    }

    public final void b() {
        this.f5393b = this.f5392a.b();
    }

    public final boolean c(long j10) {
        return this.f5393b == 0 || this.f5392a.b() - this.f5393b >= 3600000;
    }
}
