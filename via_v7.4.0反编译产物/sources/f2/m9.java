package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m9 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5506e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u9 f5507j;

    public m9(u9 u9Var, long j10) {
        this.f5507j = u9Var;
        this.f5506e = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u9.r(this.f5507j, this.f5506e);
    }
}
