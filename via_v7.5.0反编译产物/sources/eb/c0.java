package eb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f4339a;

    public c0(c7.a aVar) {
        this.f4339a = aVar;
    }

    public static c0 a(c7.a aVar) {
        return new c0(aVar);
    }

    public static b0 c(ea.g gVar) {
        return new b0(gVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b0 get() {
        return c((ea.g) this.f4339a.get());
    }
}
