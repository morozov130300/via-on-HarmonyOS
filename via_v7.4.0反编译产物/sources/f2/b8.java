package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ v7 f5057e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f5058j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d8 f5059k;

    public b8(d8 d8Var, v7 v7Var, long j10) {
        this.f5059k = d8Var;
        this.f5057e = v7Var;
        this.f5058j = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5059k.p(this.f5057e, false, this.f5058j);
        d8 d8Var = this.f5059k;
        d8Var.f5089e = null;
        d8Var.f5030a.L().u(null);
    }
}
