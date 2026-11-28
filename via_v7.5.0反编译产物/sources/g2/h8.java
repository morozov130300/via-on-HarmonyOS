package g2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f4894c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d9 f4895e;

    public h8(d9 d9Var, zzq zzqVar) {
        this.f4895e = d9Var;
        this.f4894c = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f4895e;
        l3 l3Var = d9Var.f4714d;
        if (l3Var == null) {
            d9Var.f4646a.d().r().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            u1.f.h(this.f4894c);
            l3Var.R(this.f4894c);
        } catch (RemoteException e10) {
            this.f4895e.f4646a.d().r().b("Failed to reset data on the service: remote exception", e10);
        }
        this.f4895e.E();
    }
}
