package ga;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f5594a;

    public b(c7.a aVar) {
        this.f5594a = aVar;
    }

    public static b a(c7.a aVar) {
        return new b(aVar);
    }

    public static a c(o9.a aVar) {
        return new a(aVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a get() {
        return c((o9.a) this.f5594a.get());
    }
}
