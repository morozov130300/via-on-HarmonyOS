package m2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u implements i3.b {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f8606c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f8607a = f8606c;

    /* renamed from: b, reason: collision with root package name */
    public volatile i3.b f8608b;

    public u(i3.b bVar) {
        this.f8608b = bVar;
    }

    @Override // i3.b
    public Object get() {
        Object obj;
        Object obj2 = this.f8607a;
        Object obj3 = f8606c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f8607a;
                if (obj == obj3) {
                    obj = this.f8608b.get();
                    this.f8607a = obj;
                    this.f8608b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
