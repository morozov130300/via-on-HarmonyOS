package jb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l2 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f6882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f6883b;

    public l2(c7.a aVar, c7.a aVar2) {
        this.f6882a = aVar;
        this.f6883b = aVar2;
    }

    public static l2 a(c7.a aVar, c7.a aVar2) {
        return new l2(aVar, aVar2);
    }

    public static k2 c(z9.d dVar, u9.l lVar) {
        return new k2(dVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k2 get() {
        return c((z9.d) this.f6882a.get(), (u9.l) this.f6883b.get());
    }
}
