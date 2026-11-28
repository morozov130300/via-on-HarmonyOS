package z7;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e2 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f15245a;

    public e2(c7.a aVar) {
        this.f15245a = aVar;
    }

    public static e2 a(c7.a aVar) {
        return new e2(aVar);
    }

    public static d2 c(m9.c cVar) {
        return new d2(cVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d2 get() {
        return c((m9.c) this.f15245a.get());
    }
}
