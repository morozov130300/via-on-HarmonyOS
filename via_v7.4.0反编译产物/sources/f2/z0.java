package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z0 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5861e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a2 f5862j;

    public z0(a2 a2Var, long j10) {
        this.f5862j = a2Var;
        this.f5861e = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5862j.q(this.f5861e);
    }
}
