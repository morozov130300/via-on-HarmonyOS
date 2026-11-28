package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u6 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5344c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5345e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5346m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f5347n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ o7 f5348o;

    public u6(o7 o7Var, String str, String str2, Object obj, long j10) {
        this.f5348o = o7Var;
        this.f5344c = str;
        this.f5345e = str2;
        this.f5346m = obj;
        this.f5347n = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5348o.M(this.f5344c, this.f5345e, this.f5346m, this.f5347n);
    }
}
