package a8;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p1 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f247a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f248b;

    public p1(i7.a aVar, i7.a aVar2) {
        this.f247a = aVar;
        this.f248b = aVar2;
    }

    public static p1 a(i7.a aVar, i7.a aVar2) {
        return new p1(aVar, aVar2);
    }

    public static o1 c(y9.a aVar, o9.c cVar) {
        return new o1(aVar, cVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o1 get() {
        return c((y9.a) this.f247a.get(), (o9.c) this.f248b.get());
    }
}
