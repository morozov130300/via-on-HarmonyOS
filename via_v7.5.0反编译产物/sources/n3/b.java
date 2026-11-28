package n3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f10581a;

    public static b b() {
        if (f10581a == null) {
            f10581a = new b();
        }
        return f10581a;
    }

    @Override // n3.a
    public long a() {
        return System.currentTimeMillis();
    }
}
