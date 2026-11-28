package d6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3922b = new e(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3923a;

    public e(Object obj) {
        this.f3923a = obj;
    }

    public static d a(Object obj) {
        return new e(g.b(obj, "instance cannot be null"));
    }

    @Override // c7.a
    public Object get() {
        return this.f3923a;
    }
}
