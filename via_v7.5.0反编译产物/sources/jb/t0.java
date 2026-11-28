package jb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f6974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f6975b;

    public t0(c7.a aVar, c7.a aVar2) {
        this.f6974a = aVar;
        this.f6975b = aVar2;
    }

    public static t0 a(c7.a aVar, c7.a aVar2) {
        return new t0(aVar, aVar2);
    }

    public static s0 c(z9.d dVar, u9.l lVar) {
        return new s0(dVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public s0 get() {
        return c((z9.d) this.f6974a.get(), (u9.l) this.f6975b.get());
    }
}
