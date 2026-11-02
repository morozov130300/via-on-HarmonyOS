package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e1 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7683a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7684b;

    public e1(i7.a aVar, i7.a aVar2) {
        this.f7683a = aVar;
        this.f7684b = aVar2;
    }

    public static e1 a(i7.a aVar, i7.a aVar2) {
        return new e1(aVar, aVar2);
    }

    public static d1 c(ca.d dVar, w9.l lVar) {
        return new d1(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d1 get() {
        return c((ca.d) this.f7683a.get(), (w9.l) this.f7684b.get());
    }
}
