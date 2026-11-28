package la;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7557a;

    public m(d dVar) {
        this.f7557a = dVar;
    }

    public static m a(d dVar) {
        return new m(dVar);
    }

    public static ha.g c(d dVar) {
        return (ha.g) d6.g.b(dVar.j(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ha.g get() {
        return c(this.f7557a);
    }
}
