package m1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g implements g1.b {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f7808a = new g();
    }

    public static g a() {
        return a.f7808a;
    }

    public static String b() {
        return (String) g1.d.c(f.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
