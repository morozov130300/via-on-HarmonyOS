package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x5 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7927a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7928b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f7929c;

    public x5(i7.a aVar, i7.a aVar2, i7.a aVar3) {
        this.f7927a = aVar;
        this.f7928b = aVar2;
        this.f7929c = aVar3;
    }

    public static x5 a(i7.a aVar, i7.a aVar2, i7.a aVar3) {
        return new x5(aVar, aVar2, aVar3);
    }

    public static w5 c(y9.a aVar, ca.d dVar, w9.l lVar) {
        return new w5(aVar, dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w5 get() {
        return c((y9.a) this.f7927a.get(), (ca.d) this.f7928b.get(), (w9.l) this.f7929c.get());
    }
}
