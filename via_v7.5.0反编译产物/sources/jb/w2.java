package jb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w2 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7021b;

    public w2(c7.a aVar, c7.a aVar2) {
        this.f7020a = aVar;
        this.f7021b = aVar2;
    }

    public static w2 a(c7.a aVar, c7.a aVar2) {
        return new w2(aVar, aVar2);
    }

    public static v2 c(z9.d dVar, u9.l lVar) {
        return new v2(dVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v2 get() {
        return c((z9.d) this.f7020a.get(), (u9.l) this.f7021b.get());
    }
}
