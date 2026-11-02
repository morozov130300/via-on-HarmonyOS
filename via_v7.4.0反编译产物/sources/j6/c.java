package j6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c implements i7.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f7578c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile i7.a f7579a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f7580b = f7578c;

    public c(i7.a aVar) {
        this.f7579a = aVar;
    }

    public static i7.a a(i7.a aVar) {
        g.a(aVar);
        return aVar instanceof c ? aVar : new c(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f7578c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // i7.a
    public Object get() {
        Object obj;
        Object obj2 = this.f7580b;
        Object obj3 = f7578c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f7580b;
                if (obj == obj3) {
                    obj = this.f7579a.get();
                    this.f7580b = b(this.f7580b, obj);
                    this.f7579a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
