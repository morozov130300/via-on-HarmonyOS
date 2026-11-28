package d6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h implements c7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f3924c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c7.a f3925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f3926b = f3924c;

    public h(c7.a aVar) {
        this.f3925a = aVar;
    }

    public static c7.a a(c7.a aVar) {
        return ((aVar instanceof h) || (aVar instanceof c)) ? aVar : new h((c7.a) g.a(aVar));
    }

    @Override // c7.a
    public Object get() {
        Object obj = this.f3926b;
        if (obj != f3924c) {
            return obj;
        }
        c7.a aVar = this.f3925a;
        if (aVar == null) {
            return this.f3926b;
        }
        Object obj2 = aVar.get();
        this.f3926b = obj2;
        this.f3925a = null;
        return obj2;
    }
}
