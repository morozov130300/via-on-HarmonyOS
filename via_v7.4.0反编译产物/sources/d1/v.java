package d1;

import k1.g0;
import k1.k0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f4528a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f4529b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f4530c;

    /* renamed from: d, reason: collision with root package name */
    public final i7.a f4531d;

    /* renamed from: e, reason: collision with root package name */
    public final i7.a f4532e;

    public v(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5) {
        this.f4528a = aVar;
        this.f4529b = aVar2;
        this.f4530c = aVar3;
        this.f4531d = aVar4;
        this.f4532e = aVar5;
    }

    public static v a(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static t c(n1.a aVar, n1.a aVar2, j1.e eVar, g0 g0Var, k0 k0Var) {
        return new t(aVar, aVar2, eVar, g0Var, k0Var);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t get() {
        return c((n1.a) this.f4528a.get(), (n1.a) this.f4529b.get(), (j1.e) this.f4530c.get(), (g0) this.f4531d.get(), (k0) this.f4532e.get());
    }
}
