package g2;

import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5248c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z5 f5249e;

    public q5(z5 z5Var, zzq zzqVar) {
        this.f5249e = z5Var;
        this.f5248c = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5249e.f5487d.e();
        pa paVar = this.f5249e.f5487d;
        zzq zzqVar = this.f5248c;
        paVar.f().h();
        paVar.g();
        u1.f.d(zzqVar.f3275c);
        paVar.S(zzqVar);
    }
}
