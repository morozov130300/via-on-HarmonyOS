package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ v7 f5851e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ v7 f5852j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f5853k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f5854l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d8 f5855m;

    public y7(d8 d8Var, v7 v7Var, v7 v7Var2, long j10, boolean z10) {
        this.f5855m = d8Var;
        this.f5851e = v7Var;
        this.f5852j = v7Var2;
        this.f5853k = j10;
        this.f5854l = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5855m.o(this.f5851e, this.f5852j, this.f5853k, this.f5854l, null);
    }
}
