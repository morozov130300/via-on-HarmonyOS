package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l2 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7771a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7772b;

    public l2(i7.a aVar, i7.a aVar2) {
        this.f7771a = aVar;
        this.f7772b = aVar2;
    }

    public static l2 a(i7.a aVar, i7.a aVar2) {
        return new l2(aVar, aVar2);
    }

    public static k2 c(ca.d dVar, w9.l lVar) {
        return new k2(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k2 get() {
        return c((ca.d) this.f7771a.get(), (w9.l) this.f7772b.get());
    }
}
