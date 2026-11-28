package g2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzau;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzau f5179c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5180e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5181m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d9 f5182n;

    public o8(d9 d9Var, zzau zzauVar, String str, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5182n = d9Var;
        this.f5179c = zzauVar;
        this.f5180e = str;
        this.f5181m = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h5 h5Var;
        byte[] bArrV = null;
        try {
            try {
                d9 d9Var = this.f5182n;
                l3 l3Var = d9Var.f4714d;
                if (l3Var == null) {
                    d9Var.f4646a.d().r().a("Discarding data. Failed to send event to service to bundle");
                    h5Var = this.f5182n.f4646a;
                } else {
                    bArrV = l3Var.V(this.f5179c, this.f5180e);
                    this.f5182n.E();
                    h5Var = this.f5182n.f4646a;
                }
            } catch (RemoteException e10) {
                this.f5182n.f4646a.d().r().b("Failed to send event to the service to bundle", e10);
                h5Var = this.f5182n.f4646a;
            }
            wa waVarN = h5Var.N();
        } finally {
            this.f5182n.f4646a.N().H(this.f5181m, bArrV);
        }
    }
}
