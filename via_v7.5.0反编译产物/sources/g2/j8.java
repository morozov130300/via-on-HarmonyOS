package g2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5003c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5004e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d9 f5005m;

    public j8(d9 d9Var, zzq zzqVar, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5005m = d9Var;
        this.f5003c = zzqVar;
        this.f5004e = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h5 h5Var;
        String strO = null;
        try {
            if (this.f5005m.f4646a.F().q().j(zzha.ANALYTICS_STORAGE)) {
                d9 d9Var = this.f5005m;
                l3 l3Var = d9Var.f4714d;
                if (l3Var == null) {
                    d9Var.f4646a.d().r().a("Failed to get app instance id");
                    h5Var = this.f5005m.f4646a;
                } else {
                    u1.f.h(this.f5003c);
                    strO = l3Var.o(this.f5003c);
                    if (strO != null) {
                        this.f5005m.f4646a.I().C(strO);
                        this.f5005m.f4646a.F().f5049g.b(strO);
                    }
                    this.f5005m.E();
                    h5Var = this.f5005m.f4646a;
                }
            } else {
                this.f5005m.f4646a.d().x().a("Analytics storage consent denied; will not get app instance id");
                this.f5005m.f4646a.I().C(null);
                this.f5005m.f4646a.F().f5049g.b(null);
                h5Var = this.f5005m.f4646a;
            }
        } catch (RemoteException e10) {
            this.f5005m.f4646a.d().r().b("Failed to get app instance id", e10);
            h5Var = this.f5005m.f4646a;
        } finally {
            this.f5005m.f4646a.N().K(this.f5004e, null);
        }
        wa waVarN = h5Var.N();
    }
}
