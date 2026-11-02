package f1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements i7.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5008c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile i7.a f5009a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f5010b = f5008c;

    public a(i7.a aVar) {
        this.f5009a = aVar;
    }

    public static i7.a a(i7.a aVar) {
        d.b(aVar);
        return aVar instanceof a ? aVar : new a(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f5008c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // i7.a
    public Object get() {
        Object obj;
        Object obj2 = this.f5010b;
        Object obj3 = f5008c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f5010b;
                if (obj == obj3) {
                    obj = this.f5009a.get();
                    this.f5010b = b(this.f5010b, obj);
                    this.f5009a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
