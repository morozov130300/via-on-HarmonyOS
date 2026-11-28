package jb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f6862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f6863b;

    public k(c7.a aVar, c7.a aVar2) {
        this.f6862a = aVar;
        this.f6863b = aVar2;
    }

    public static k a(c7.a aVar, c7.a aVar2) {
        return new k(aVar, aVar2);
    }

    public static j c(z9.d dVar, u9.l lVar) {
        return new j(dVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j get() {
        return c((z9.d) this.f6862a.get(), (u9.l) this.f6863b.get());
    }
}
