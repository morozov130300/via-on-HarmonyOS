package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t0 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7863a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7864b;

    public t0(i7.a aVar, i7.a aVar2) {
        this.f7863a = aVar;
        this.f7864b = aVar2;
    }

    public static t0 a(i7.a aVar, i7.a aVar2) {
        return new t0(aVar, aVar2);
    }

    public static s0 c(ca.d dVar, w9.l lVar) {
        return new s0(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s0 get() {
        return c((ca.d) this.f7863a.get(), (w9.l) this.f7864b.get());
    }
}
