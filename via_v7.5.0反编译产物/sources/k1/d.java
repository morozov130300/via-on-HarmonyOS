package k1;

import java.util.concurrent.Executor;
import l1.m0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f7163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c7.a f7164e;

    public d(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5) {
        this.f7160a = aVar;
        this.f7161b = aVar2;
        this.f7162c = aVar3;
        this.f7163d = aVar4;
        this.f7164e = aVar5;
    }

    public static d a(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, f1.d dVar, m0 m0Var, m1.d dVar2, n1.a aVar) {
        return new c(executor, dVar, m0Var, dVar2, aVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.f7160a.get(), (f1.d) this.f7161b.get(), (m0) this.f7162c.get(), (m1.d) this.f7163d.get(), (n1.a) this.f7164e.get());
    }
}
