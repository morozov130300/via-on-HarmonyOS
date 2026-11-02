package j6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h implements i7.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f7583c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile i7.a f7584a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f7585b = f7583c;

    public h(i7.a aVar) {
        this.f7584a = aVar;
    }

    public static i7.a a(i7.a aVar) {
        return ((aVar instanceof h) || (aVar instanceof c)) ? aVar : new h((i7.a) g.a(aVar));
    }

    @Override // i7.a
    public Object get() {
        Object obj = this.f7585b;
        if (obj != f7583c) {
            return obj;
        }
        i7.a aVar = this.f7584a;
        if (aVar == null) {
            return this.f7585b;
        }
        Object obj2 = aVar.get();
        this.f7585b = obj2;
        this.f7584a = null;
        return obj2;
    }
}
