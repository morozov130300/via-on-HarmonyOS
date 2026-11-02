package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p1 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7815a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7816b;

    public p1(i7.a aVar, i7.a aVar2) {
        this.f7815a = aVar;
        this.f7816b = aVar2;
    }

    public static p1 a(i7.a aVar, i7.a aVar2) {
        return new p1(aVar, aVar2);
    }

    public static o1 c(ca.d dVar, w9.l lVar) {
        return new o1(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o1 get() {
        return c((ca.d) this.f7815a.get(), (w9.l) this.f7816b.get());
    }
}
