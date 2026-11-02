package b8;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f1920a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f1921b;

    public z(i7.a aVar, i7.a aVar2) {
        this.f1920a = aVar;
        this.f1921b = aVar2;
    }

    public static z a(i7.a aVar, i7.a aVar2) {
        return new z(aVar, aVar2);
    }

    public static y c(y9.a aVar, o9.c cVar) {
        return new y(aVar, cVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y get() {
        return c((y9.a) this.f1920a.get(), (o9.c) this.f1921b.get());
    }
}
