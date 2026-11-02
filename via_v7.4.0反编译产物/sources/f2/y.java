package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5825e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f5826j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ a2 f5827k;

    public y(a2 a2Var, String str, long j10) {
        this.f5827k = a2Var;
        this.f5825e = str;
        this.f5826j = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a2.j(this.f5827k, this.f5825e, this.f5826j);
    }
}
