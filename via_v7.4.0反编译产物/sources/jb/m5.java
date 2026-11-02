package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m5 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7790a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7791b;

    public m5(i7.a aVar, i7.a aVar2) {
        this.f7790a = aVar;
        this.f7791b = aVar2;
    }

    public static m5 a(i7.a aVar, i7.a aVar2) {
        return new m5(aVar, aVar2);
    }

    public static l5 c(ca.d dVar, w9.l lVar) {
        return new l5(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l5 get() {
        return c((ca.d) this.f7790a.get(), (w9.l) this.f7791b.get());
    }
}
