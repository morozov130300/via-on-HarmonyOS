package z9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f15533a;

    public c(c7.a aVar) {
        this.f15533a = aVar;
    }

    public static c a(c7.a aVar) {
        return new c(aVar);
    }

    public static b c(aa.c cVar) {
        return new b(cVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b get() {
        return c((aa.c) this.f15533a.get());
    }
}
