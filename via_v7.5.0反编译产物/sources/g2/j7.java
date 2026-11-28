package g2;

import com.google.android.gms.internal.measurement.ae;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f6 f4997c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4998e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f4999m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f5000n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ f6 f5001o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ o7 f5002p;

    public j7(o7 o7Var, f6 f6Var, long j10, long j11, boolean z10, f6 f6Var2) {
        this.f5002p = o7Var;
        this.f4997c = f6Var;
        this.f4998e = j10;
        this.f4999m = j11;
        this.f5000n = z10;
        this.f5001o = f6Var2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5002p.J(this.f4997c);
        this.f5002p.z(this.f4998e, false);
        o7.c0(this.f5002p, this.f4997c, this.f4999m, true, this.f5000n);
        ae.b();
        if (this.f5002p.f4646a.z().B(null, i3.f4942p0)) {
            o7.b0(this.f5002p, this.f4997c, this.f5001o);
        }
    }
}
