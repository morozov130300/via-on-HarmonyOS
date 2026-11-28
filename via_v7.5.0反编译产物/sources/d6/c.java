package d6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements c7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f3919c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c7.a f3920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f3921b = f3919c;

    public c(c7.a aVar) {
        this.f3920a = aVar;
    }

    public static c7.a a(c7.a aVar) {
        g.a(aVar);
        return aVar instanceof c ? aVar : new c(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f3919c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // c7.a
    public Object get() {
        Object obj;
        Object obj2 = this.f3921b;
        Object obj3 = f3919c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f3921b;
                if (obj == obj3) {
                    obj = this.f3920a.get();
                    this.f3921b = b(this.f3921b, obj);
                    this.f3920a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
