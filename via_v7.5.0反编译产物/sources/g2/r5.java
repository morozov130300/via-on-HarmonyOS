package g2;

import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5268c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z5 f5269e;

    public r5(z5 z5Var, zzq zzqVar) {
        this.f5269e = z5Var;
        this.f5268c = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5269e.f5487d.e();
        pa paVar = this.f5269e.f5487d;
        zzq zzqVar = this.f5268c;
        paVar.f().h();
        paVar.g();
        u1.f.d(zzqVar.f3275c);
        f6 f6VarC = f6.c(zzqVar.F, 100);
        f6 f6VarC0 = paVar.c0(zzqVar.f3275c);
        paVar.d().v().c("Setting consent, package, consent", zzqVar.f3275c, f6VarC);
        paVar.A(zzqVar.f3275c, f6VarC);
        if (f6VarC.m(f6VarC0)) {
            paVar.v(zzqVar);
        }
    }
}
