package bb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f1899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f1900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f1901c;

    public y(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        this.f1899a = aVar;
        this.f1900b = aVar2;
        this.f1901c = aVar3;
    }

    public static y a(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        return new y(aVar, aVar2, aVar3);
    }

    public static x c(w9.a aVar, m9.c cVar, u9.l lVar) {
        return new x(aVar, cVar, lVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c((w9.a) this.f1899a.get(), (m9.c) this.f1900b.get(), (u9.l) this.f1901c.get());
    }
}
