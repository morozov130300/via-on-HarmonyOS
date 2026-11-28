package cb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o1 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f2461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f2462b;

    public o1(c7.a aVar, c7.a aVar2) {
        this.f2461a = aVar;
        this.f2462b = aVar2;
    }

    public static o1 a(c7.a aVar, c7.a aVar2) {
        return new o1(aVar, aVar2);
    }

    public static n1 c(m9.c cVar, u9.l lVar) {
        return new n1(cVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n1 get() {
        return c((m9.c) this.f2461a.get(), (u9.l) this.f2462b.get());
    }
}
