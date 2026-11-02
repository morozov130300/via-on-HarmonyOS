package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5842e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5843j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5844k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f5845l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z5 f5846m;

    public y5(z5 z5Var, String str, String str2, String str3, long j10) {
        this.f5846m = z5Var;
        this.f5842e = str;
        this.f5843j = str2;
        this.f5844k = str3;
        this.f5845l = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f5842e;
        if (str == null) {
            this.f5846m.f5871d.w(this.f5843j, null);
        } else {
            this.f5846m.f5871d.w(this.f5843j, new v7(this.f5844k, str, this.f5845l));
        }
    }
}
