package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j9 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ pa f5390e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Runnable f5391j;

    public j9(l9 l9Var, pa paVar, Runnable runnable) {
        this.f5390e = paVar;
        this.f5391j = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5390e.e();
        this.f5390e.l0(this.f5391j);
        this.f5390e.C();
    }
}
