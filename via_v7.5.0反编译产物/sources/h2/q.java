package h2;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q implements d, c, b, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f5666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f5667c;

    public q(Executor executor, a aVar, d0 d0Var) {
        this.f5665a = executor;
        this.f5666b = aVar;
        this.f5667c = d0Var;
    }

    @Override // h2.z
    public final void a(f fVar) {
        this.f5665a.execute(new p(this, fVar));
    }

    @Override // h2.b
    public final void b() {
        this.f5667c.p();
    }

    @Override // h2.c
    public final void c(Exception exc) {
        this.f5667c.n(exc);
    }

    @Override // h2.d
    public final void onSuccess(Object obj) {
        this.f5667c.o(obj);
    }
}
