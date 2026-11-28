package jb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7005b;

    public v(c7.a aVar, c7.a aVar2) {
        this.f7004a = aVar;
        this.f7005b = aVar2;
    }

    public static v a(c7.a aVar, c7.a aVar2) {
        return new v(aVar, aVar2);
    }

    public static u c(z9.d dVar, u9.l lVar) {
        return new u(dVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c((z9.d) this.f7004a.get(), (u9.l) this.f7005b.get());
    }
}
