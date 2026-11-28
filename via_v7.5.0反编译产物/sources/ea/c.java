package ea;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f4324a;

    public c(c7.a aVar) {
        this.f4324a = aVar;
    }

    public static c a(c7.a aVar) {
        return new c(aVar);
    }

    public static b c(h hVar) {
        return new b(hVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b get() {
        return c((h) this.f4324a.get());
    }
}
