package jb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x5 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7039c;

    public x5(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        this.f7037a = aVar;
        this.f7038b = aVar2;
        this.f7039c = aVar3;
    }

    public static x5 a(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        return new x5(aVar, aVar2, aVar3);
    }

    public static w5 c(w9.a aVar, z9.d dVar, u9.l lVar) {
        return new w5(aVar, dVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public w5 get() {
        return c((w9.a) this.f7037a.get(), (z9.d) this.f7038b.get(), (u9.l) this.f7039c.get());
    }
}
