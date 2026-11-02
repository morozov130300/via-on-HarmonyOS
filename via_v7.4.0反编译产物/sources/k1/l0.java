package k1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l0 implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f8092a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f8093b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f8094c;

    /* renamed from: d, reason: collision with root package name */
    public final i7.a f8095d;

    public l0(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4) {
        this.f8092a = aVar;
        this.f8093b = aVar2;
        this.f8094c = aVar3;
        this.f8095d = aVar4;
    }

    public static l0 a(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4) {
        return new l0(aVar, aVar2, aVar3, aVar4);
    }

    public static k0 c(Executor executor, l1.d dVar, m0 m0Var, m1.a aVar) {
        return new k0(executor, dVar, m0Var, aVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k0 get() {
        return c((Executor) this.f8092a.get(), (l1.d) this.f8093b.get(), (m0) this.f8094c.get(), (m1.a) this.f8095d.get());
    }
}
