package g1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f4627b = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4628a;

    public c(Object obj) {
        this.f4628a = obj;
    }

    public static b a(Object obj) {
        return new c(d.c(obj, "instance cannot be null"));
    }

    @Override // c7.a
    public Object get() {
        return this.f4628a;
    }
}
