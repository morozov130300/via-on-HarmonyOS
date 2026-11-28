package jb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a2 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f6752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f6753b;

    public a2(c7.a aVar, c7.a aVar2) {
        this.f6752a = aVar;
        this.f6753b = aVar2;
    }

    public static a2 a(c7.a aVar, c7.a aVar2) {
        return new a2(aVar, aVar2);
    }

    public static z1 c(z9.d dVar, u9.l lVar) {
        return new z1(dVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public z1 get() {
        return c((z9.d) this.f6752a.get(), (u9.l) this.f6753b.get());
    }
}
