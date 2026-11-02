package y9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f14511a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f14512b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f14513c;

    /* renamed from: d, reason: collision with root package name */
    public final i7.a f14514d;

    /* renamed from: e, reason: collision with root package name */
    public final i7.a f14515e;

    public c(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5) {
        this.f14511a = aVar;
        this.f14512b = aVar2;
        this.f14513c = aVar3;
        this.f14514d = aVar4;
        this.f14515e = aVar5;
    }

    public static c a(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5) {
        return new c(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static b c(ea.a aVar, ga.a aVar2, fa.a aVar3, ia.c cVar, ja.d dVar) {
        return new b(aVar, aVar2, aVar3, cVar, dVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b get() {
        return c((ea.a) this.f14511a.get(), (ga.a) this.f14512b.get(), (fa.a) this.f14513c.get(), (ia.c) this.f14514d.get(), (ja.d) this.f14515e.get());
    }
}
