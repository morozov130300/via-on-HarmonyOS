package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5013e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f5014j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ a2 f5015k;

    public a(a2 a2Var, String str, long j10) {
        this.f5015k = a2Var;
        this.f5013e = str;
        this.f5014j = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a2.i(this.f5015k, this.f5013e, this.f5014j);
    }
}
