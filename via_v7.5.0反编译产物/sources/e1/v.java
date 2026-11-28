package e1;

import l1.g0;
import l1.k0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f4160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f4161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f4162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f4163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c7.a f4164e;

    public v(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5) {
        this.f4160a = aVar;
        this.f4161b = aVar2;
        this.f4162c = aVar3;
        this.f4163d = aVar4;
        this.f4164e = aVar5;
    }

    public static v a(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static t c(o1.a aVar, o1.a aVar2, k1.e eVar, g0 g0Var, k0 k0Var) {
        return new t(aVar, aVar2, eVar, g0Var, k0Var);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t get() {
        return c((o1.a) this.f4160a.get(), (o1.a) this.f4161b.get(), (k1.e) this.f4162c.get(), (g0) this.f4163d.get(), (k0) this.f4164e.get());
    }
}
