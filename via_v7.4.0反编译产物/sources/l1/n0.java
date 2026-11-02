package l1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n0 implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f8359a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f8360b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f8361c;

    /* renamed from: d, reason: collision with root package name */
    public final i7.a f8362d;

    /* renamed from: e, reason: collision with root package name */
    public final i7.a f8363e;

    public n0(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5) {
        this.f8359a = aVar;
        this.f8360b = aVar2;
        this.f8361c = aVar3;
        this.f8362d = aVar4;
        this.f8363e = aVar5;
    }

    public static n0 a(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(n1.a aVar, n1.a aVar2, Object obj, Object obj2, i7.a aVar3) {
        return new m0(aVar, aVar2, (e) obj, (t0) obj2, aVar3);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((n1.a) this.f8359a.get(), (n1.a) this.f8360b.get(), this.f8361c.get(), this.f8362d.get(), this.f8363e);
    }
}
