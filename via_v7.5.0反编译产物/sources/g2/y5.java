package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5458c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5459e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f5461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ z5 f5462o;

    public y5(z5 z5Var, String str, String str2, String str3, long j10) {
        this.f5462o = z5Var;
        this.f5458c = str;
        this.f5459e = str2;
        this.f5460m = str3;
        this.f5461n = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f5458c;
        if (str == null) {
            this.f5462o.f5487d.w(this.f5459e, null);
        } else {
            this.f5462o.f5487d.w(this.f5459e, new v7(this.f5460m, str, this.f5461n));
        }
    }
}
