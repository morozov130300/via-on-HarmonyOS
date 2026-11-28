package e5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f4210b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f4211a;

    public static b b() {
        if (f4210b == null) {
            synchronized (b.class) {
                try {
                    if (f4210b == null) {
                        f4210b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4210b;
    }

    public g a() {
        if (this.f4211a == null) {
            synchronized (c.class) {
                try {
                    if (this.f4211a == null) {
                        this.f4211a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f4211a;
    }
}
