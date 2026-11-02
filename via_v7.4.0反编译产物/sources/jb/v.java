package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7894a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7895b;

    public v(i7.a aVar, i7.a aVar2) {
        this.f7894a = aVar;
        this.f7895b = aVar2;
    }

    public static v a(i7.a aVar, i7.a aVar2) {
        return new v(aVar, aVar2);
    }

    public static u c(ca.d dVar, w9.l lVar) {
        return new u(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c((ca.d) this.f7894a.get(), (w9.l) this.f7895b.get());
    }
}
