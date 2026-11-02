package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m6 f5204e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ h5 f5205j;

    public g5(h5 h5Var, m6 m6Var) {
        this.f5205j = h5Var;
        this.f5204e = m6Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws ClassNotFoundException {
        h5.e(this.f5205j, this.f5204e);
        this.f5205j.m(this.f5204e.f5494g);
    }
}
