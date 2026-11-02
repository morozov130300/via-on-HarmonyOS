package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q9 {

    /* renamed from: a, reason: collision with root package name */
    public p9 f5642a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u9 f5643b;

    public q9(u9 u9Var) {
        this.f5643b = u9Var;
    }

    public final void a(long j10) {
        this.f5642a = new p9(this, this.f5643b.f5030a.a().a(), j10);
        this.f5643b.f5738c.postDelayed(this.f5642a, 2000L);
    }

    public final void b() {
        this.f5643b.h();
        p9 p9Var = this.f5642a;
        if (p9Var != null) {
            this.f5643b.f5738c.removeCallbacks(p9Var);
        }
        this.f5643b.f5030a.F().f5444r.a(false);
        this.f5643b.s(false);
    }
}
