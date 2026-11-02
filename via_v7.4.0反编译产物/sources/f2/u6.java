package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u6 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5728e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5729j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5730k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f5731l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ o7 f5732m;

    public u6(o7 o7Var, String str, String str2, Object obj, long j10) {
        this.f5732m = o7Var;
        this.f5728e = str;
        this.f5729j = str2;
        this.f5730k = obj;
        this.f5731l = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5732m.M(this.f5728e, this.f5729j, this.f5730k, this.f5731l);
    }
}
