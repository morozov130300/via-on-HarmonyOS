package wa;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f14390b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14391a;

    public static c a() {
        if (f14390b == null) {
            f14390b = new c();
        }
        return f14390b;
    }

    public boolean b() {
        return System.currentTimeMillis() < this.f14391a;
    }

    public void c() {
        this.f14391a = System.currentTimeMillis() + 120000;
    }
}
