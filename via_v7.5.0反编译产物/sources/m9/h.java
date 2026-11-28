package m9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7976a;

    public h(c7.a aVar) {
        this.f7976a = aVar;
    }

    public static h a(c7.a aVar) {
        return new h(aVar);
    }

    public static g c(o9.a aVar) {
        return new g(aVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c((o9.a) this.f7976a.get());
    }
}
