package jb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f6814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f6815b;

    public g0(c7.a aVar, c7.a aVar2) {
        this.f6814a = aVar;
        this.f6815b = aVar2;
    }

    public static g0 a(c7.a aVar, c7.a aVar2) {
        return new g0(aVar, aVar2);
    }

    public static f0 c(z9.d dVar, u9.l lVar) {
        return new f0(dVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f0 get() {
        return c((z9.d) this.f6814a.get(), (u9.l) this.f6815b.get());
    }
}
