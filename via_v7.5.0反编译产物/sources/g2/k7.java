package g2;

import com.google.android.gms.internal.measurement.ae;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f6 f5033c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5034e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f5035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ f6 f5036n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ o7 f5037o;

    public k7(o7 o7Var, f6 f6Var, long j10, boolean z10, f6 f6Var2) {
        this.f5037o = o7Var;
        this.f5033c = f6Var;
        this.f5034e = j10;
        this.f5035m = z10;
        this.f5036n = f6Var2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5037o.J(this.f5033c);
        o7.c0(this.f5037o, this.f5033c, this.f5034e, false, this.f5035m);
        ae.b();
        if (this.f5037o.f4646a.z().B(null, i3.f4942p0)) {
            o7.b0(this.f5037o, this.f5033c, this.f5036n);
        }
    }
}
