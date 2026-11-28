package h2;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y implements d, c, b, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f5685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f5686c;

    public y(Executor executor, e eVar, d0 d0Var) {
        this.f5684a = executor;
        this.f5685b = eVar;
        this.f5686c = d0Var;
    }

    @Override // h2.z
    public final void a(f fVar) {
        this.f5684a.execute(new x(this, fVar));
    }

    @Override // h2.b
    public final void b() {
        this.f5686c.p();
    }

    @Override // h2.c
    public final void c(Exception exc) {
        this.f5686c.n(exc);
    }

    @Override // h2.d
    public final void onSuccess(Object obj) {
        this.f5686c.o(obj);
    }
}
