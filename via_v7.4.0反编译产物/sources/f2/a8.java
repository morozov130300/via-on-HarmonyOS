package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5036e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d8 f5037j;

    public a8(d8 d8Var, long j10) {
        this.f5037j = d8Var;
        this.f5036e = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5037j.f5030a.y().n(this.f5036e);
        this.f5037j.f5089e = null;
    }
}
