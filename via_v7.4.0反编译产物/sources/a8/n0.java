package a8;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n0 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f232a;

    public n0(i7.a aVar) {
        this.f232a = aVar;
    }

    public static n0 a(i7.a aVar) {
        return new n0(aVar);
    }

    public static m0 c(o9.c cVar) {
        return new m0(cVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((o9.c) this.f232a.get());
    }
}
