package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w2 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7910a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7911b;

    public w2(i7.a aVar, i7.a aVar2) {
        this.f7910a = aVar;
        this.f7911b = aVar2;
    }

    public static w2 a(i7.a aVar, i7.a aVar2) {
        return new w2(aVar, aVar2);
    }

    public static v2 c(ca.d dVar, w9.l lVar) {
        return new v2(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v2 get() {
        return c((ca.d) this.f7910a.get(), (w9.l) this.f7911b.get());
    }
}
