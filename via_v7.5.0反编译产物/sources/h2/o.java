package h2;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f5661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f5662c;

    public o(Executor executor, a aVar, d0 d0Var) {
        this.f5660a = executor;
        this.f5661b = aVar;
        this.f5662c = d0Var;
    }

    @Override // h2.z
    public final void a(f fVar) {
        this.f5660a.execute(new n(this, fVar));
    }
}
