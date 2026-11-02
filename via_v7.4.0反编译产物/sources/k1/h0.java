package k1;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h0 implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f8074a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f8075b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f8076c;

    /* renamed from: d, reason: collision with root package name */
    public final i7.a f8077d;

    /* renamed from: e, reason: collision with root package name */
    public final i7.a f8078e;

    /* renamed from: f, reason: collision with root package name */
    public final i7.a f8079f;

    /* renamed from: g, reason: collision with root package name */
    public final i7.a f8080g;

    /* renamed from: h, reason: collision with root package name */
    public final i7.a f8081h;

    /* renamed from: i, reason: collision with root package name */
    public final i7.a f8082i;

    public h0(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5, i7.a aVar6, i7.a aVar7, i7.a aVar8, i7.a aVar9) {
        this.f8074a = aVar;
        this.f8075b = aVar2;
        this.f8076c = aVar3;
        this.f8077d = aVar4;
        this.f8078e = aVar5;
        this.f8079f = aVar6;
        this.f8080g = aVar7;
        this.f8081h = aVar8;
        this.f8082i = aVar9;
    }

    public static h0 a(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4, i7.a aVar5, i7.a aVar6, i7.a aVar7, i7.a aVar8, i7.a aVar9) {
        return new h0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static g0 c(Context context, e1.d dVar, l1.d dVar2, m0 m0Var, Executor executor, m1.a aVar, n1.a aVar2, n1.a aVar3, l1.c cVar) {
        return new g0(context, dVar, dVar2, m0Var, executor, aVar, aVar2, aVar3, cVar);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g0 get() {
        return c((Context) this.f8074a.get(), (e1.d) this.f8075b.get(), (l1.d) this.f8076c.get(), (m0) this.f8077d.get(), (Executor) this.f8078e.get(), (m1.a) this.f8079f.get(), (n1.a) this.f8080g.get(), (n1.a) this.f8081h.get(), (l1.c) this.f8082i.get());
    }
}
