package jb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s3 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7857a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7858b;

    public s3(i7.a aVar, i7.a aVar2) {
        this.f7857a = aVar;
        this.f7858b = aVar2;
    }

    public static s3 a(i7.a aVar, i7.a aVar2) {
        return new s3(aVar, aVar2);
    }

    public static r3 c(ca.d dVar, w9.l lVar) {
        return new r3(dVar, lVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r3 get() {
        return c((ca.d) this.f7857a.get(), (w9.l) this.f7858b.get());
    }
}
