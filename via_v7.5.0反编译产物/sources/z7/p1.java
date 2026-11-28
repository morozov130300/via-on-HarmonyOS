package z7;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p1 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f15318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f15319b;

    public p1(c7.a aVar, c7.a aVar2) {
        this.f15318a = aVar;
        this.f15319b = aVar2;
    }

    public static p1 a(c7.a aVar, c7.a aVar2) {
        return new p1(aVar, aVar2);
    }

    public static o1 c(w9.a aVar, m9.c cVar) {
        return new o1(aVar, cVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public o1 get() {
        return c((w9.a) this.f15318a.get(), (m9.c) this.f15319b.get());
    }
}
