package cb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l1 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f3154a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f3155b;

    public l1(i7.a aVar, i7.a aVar2) {
        this.f3154a = aVar;
        this.f3155b = aVar2;
    }

    public static l1 a(i7.a aVar, i7.a aVar2) {
        return new l1(aVar, aVar2);
    }

    public static k1 c(o9.c cVar, w9.l lVar) {
        return new k1(cVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k1 get() {
        return c((o9.c) this.f3154a.get(), (w9.l) this.f3155b.get());
    }
}
