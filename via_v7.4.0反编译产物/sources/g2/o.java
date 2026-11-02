package g2;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o implements z {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6163a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6164b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f6165c;

    public o(Executor executor, a aVar, d0 d0Var) {
        this.f6163a = executor;
        this.f6164b = aVar;
        this.f6165c = d0Var;
    }

    @Override // g2.z
    public final void a(f fVar) {
        this.f6163a.execute(new n(this, fVar));
    }
}
