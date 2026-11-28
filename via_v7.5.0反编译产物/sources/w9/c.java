package w9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f14382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f14383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f14384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f14385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c7.a f14386e;

    public c(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5) {
        this.f14382a = aVar;
        this.f14383b = aVar2;
        this.f14384c = aVar3;
        this.f14385d = aVar4;
        this.f14386e = aVar5;
    }

    public static c a(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5) {
        return new c(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static b c(ba.a aVar, da.a aVar2, ca.a aVar3, fa.c cVar, ga.d dVar) {
        return new b(aVar, aVar2, aVar3, cVar, dVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b get() {
        return c((ba.a) this.f14382a.get(), (da.a) this.f14383b.get(), (ca.a) this.f14384c.get(), (fa.c) this.f14385d.get(), (ga.d) this.f14386e.get());
    }
}
