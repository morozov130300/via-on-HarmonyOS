package p4;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f11572b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11573a = 1;

    public static b b() {
        if (f11572b == null) {
            synchronized (b.class) {
                try {
                    if (f11572b == null) {
                        f11572b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11572b;
    }

    public int a() {
        int i10 = this.f11573a;
        this.f11573a = i10 + 1;
        return i10;
    }
}
