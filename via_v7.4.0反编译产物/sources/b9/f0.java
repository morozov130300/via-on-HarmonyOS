package b9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f0 implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f1984a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f1985b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f1986c;

    public f0(i7.a aVar, i7.a aVar2, i7.a aVar3) {
        this.f1984a = aVar;
        this.f1985b = aVar2;
        this.f1986c = aVar3;
    }

    public static f0 a(i7.a aVar, i7.a aVar2, i7.a aVar3) {
        return new f0(aVar, aVar2, aVar3);
    }

    public static e0 c(w9.l lVar, p9.o oVar, k6.e eVar) {
        return new e0(lVar, oVar, eVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e0 get() {
        return c((w9.l) this.f1984a.get(), (p9.o) this.f1985b.get(), (k6.e) this.f1986c.get());
    }
}
