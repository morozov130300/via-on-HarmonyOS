package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g0 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7703a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7704b;

    public g0(i7.a aVar, i7.a aVar2) {
        this.f7703a = aVar;
        this.f7704b = aVar2;
    }

    public static g0 a(i7.a aVar, i7.a aVar2) {
        return new g0(aVar, aVar2);
    }

    public static f0 c(ca.d dVar, w9.l lVar) {
        return new f0(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f0 get() {
        return c((ca.d) this.f7703a.get(), (w9.l) this.f7704b.get());
    }
}
