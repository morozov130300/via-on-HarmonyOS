package z7;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f15303a;

    public n0(c7.a aVar) {
        this.f15303a = aVar;
    }

    public static n0 a(c7.a aVar) {
        return new n0(aVar);
    }

    public static m0 c(m9.c cVar) {
        return new m0(cVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((m9.c) this.f15303a.get());
    }
}
