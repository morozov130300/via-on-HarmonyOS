package g2;

import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5195c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z5 f5196e;

    public p5(z5 z5Var, zzq zzqVar) {
        this.f5196e = z5Var;
        this.f5195c = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5196e.f5487d.e();
        this.f5196e.f5487d.v(this.f5195c);
    }
}
