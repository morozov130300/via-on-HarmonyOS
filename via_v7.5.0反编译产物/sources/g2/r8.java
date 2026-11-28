package g2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5275c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d9 f5276e;

    public r8(d9 d9Var, zzq zzqVar) {
        this.f5276e = d9Var;
        this.f5275c = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5276e;
        l3 l3Var = d9Var.f4714d;
        if (l3Var == null) {
            d9Var.f4646a.d().r().a("Failed to send consent settings to service");
            return;
        }
        try {
            u1.f.h(this.f5275c);
            l3Var.O(this.f5275c);
            this.f5276e.E();
        } catch (RemoteException e10) {
            this.f5276e.f4646a.d().r().b("Failed to send consent settings to the service", e10);
        }
    }
}
