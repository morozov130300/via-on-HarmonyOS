package l1;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f7442d;

    public l0(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4) {
        this.f7439a = aVar;
        this.f7440b = aVar2;
        this.f7441c = aVar3;
        this.f7442d = aVar4;
    }

    public static l0 a(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4) {
        return new l0(aVar, aVar2, aVar3, aVar4);
    }

    public static k0 c(Executor executor, m1.d dVar, m0 m0Var, n1.a aVar) {
        return new k0(executor, dVar, m0Var, aVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k0 get() {
        return c((Executor) this.f7439a.get(), (m1.d) this.f7440b.get(), (m0) this.f7441c.get(), (n1.a) this.f7442d.get());
    }
}
