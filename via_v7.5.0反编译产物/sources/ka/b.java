package ka;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7252b;

    public b(c7.a aVar, c7.a aVar2) {
        this.f7251a = aVar;
        this.f7252b = aVar2;
    }

    public static b a(c7.a aVar, c7.a aVar2) {
        return new b(aVar, aVar2);
    }

    public static a c(i9.a aVar, i iVar) {
        return new a(aVar, iVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a get() {
        return c((i9.a) this.f7251a.get(), (i) this.f7252b.get());
    }
}
