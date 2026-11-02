package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7751a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7752b;

    public k(i7.a aVar, i7.a aVar2) {
        this.f7751a = aVar;
        this.f7752b = aVar2;
    }

    public static k a(i7.a aVar, i7.a aVar2) {
        return new k(aVar, aVar2);
    }

    public static j c(ca.d dVar, w9.l lVar) {
        return new j(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j get() {
        return c((ca.d) this.f7751a.get(), (w9.l) this.f7752b.get());
    }
}
