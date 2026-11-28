package g1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f4624c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c7.a f4625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f4626b = f4624c;

    public a(c7.a aVar) {
        this.f4625a = aVar;
    }

    public static c7.a a(c7.a aVar) {
        d.b(aVar);
        return aVar instanceof a ? aVar : new a(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f4624c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // c7.a
    public Object get() {
        Object obj;
        Object obj2 = this.f4626b;
        Object obj3 = f4624c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f4626b;
                if (obj == obj3) {
                    obj = this.f4625a.get();
                    this.f4626b = b(this.f4626b, obj);
                    this.f4625a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
