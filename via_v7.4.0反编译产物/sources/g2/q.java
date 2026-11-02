package g2;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q implements d, c, b, z {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6168a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6169b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f6170c;

    public q(Executor executor, a aVar, d0 d0Var) {
        this.f6168a = executor;
        this.f6169b = aVar;
        this.f6170c = d0Var;
    }

    @Override // g2.z
    public final void a(f fVar) {
        this.f6168a.execute(new p(this, fVar));
    }

    @Override // g2.b
    public final void b() {
        this.f6170c.p();
    }

    @Override // g2.c
    public final void c(Exception exc) {
        this.f6170c.n(exc);
    }

    @Override // g2.d
    public final void onSuccess(Object obj) {
        this.f6170c.o(obj);
    }
}
