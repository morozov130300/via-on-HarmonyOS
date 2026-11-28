package m9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7974a;

    public f(c7.a aVar) {
        this.f7974a = aVar;
    }

    public static f a(c7.a aVar) {
        return new f(aVar);
    }

    public static e c(d dVar) {
        return new e(dVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c((d) this.f7974a.get());
    }
}
