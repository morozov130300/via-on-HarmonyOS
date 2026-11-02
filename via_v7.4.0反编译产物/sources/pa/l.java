package pa;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11106a;

    public l(c cVar) {
        this.f11106a = cVar;
    }

    public static l a(c cVar) {
        return new l(cVar);
    }

    public static ka.g c(c cVar) {
        return (ka.g) j6.g.b(cVar.j(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ka.g get() {
        return c(this.f11106a);
    }
}
