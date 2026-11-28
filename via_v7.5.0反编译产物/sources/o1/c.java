package o1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements g1.b {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f10862a = new c();
    }

    public static c a() {
        return a.f10862a;
    }

    public static o1.a b() {
        return (o1.a) g1.d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o1.a get() {
        return b();
    }
}
