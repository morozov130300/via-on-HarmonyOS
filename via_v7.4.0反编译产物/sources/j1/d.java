package j1;

import java.util.concurrent.Executor;
import k1.m0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7528a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7529b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f7530c;

    /* renamed from: d, reason: collision with root package name */
    public final i7.a f7531d;

    /* renamed from: e, reason: collision with root package name */
    public final i7.a f7532e;

    public d(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5) {
        this.f7528a = aVar;
        this.f7529b = aVar2;
        this.f7530c = aVar3;
        this.f7531d = aVar4;
        this.f7532e = aVar5;
    }

    public static d a(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, e1.d dVar, m0 m0Var, l1.d dVar2, m1.a aVar) {
        return new c(executor, dVar, m0Var, dVar2, aVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.f7528a.get(), (e1.d) this.f7529b.get(), (m0) this.f7530c.get(), (l1.d) this.f7531d.get(), (m1.a) this.f7532e.get());
    }
}
