package g2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5038c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d9 f5039e;

    public k8(d9 d9Var, zzq zzqVar) {
        this.f5039e = d9Var;
        this.f5038c = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5039e;
        l3 l3Var = d9Var.f4714d;
        if (l3Var == null) {
            d9Var.f4646a.d().r().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            u1.f.h(this.f5038c);
            l3Var.C(this.f5038c);
            this.f5039e.f4646a.C().t();
            this.f5039e.r(l3Var, null, this.f5038c);
            this.f5039e.E();
        } catch (RemoteException e10) {
            this.f5039e.f4646a.d().r().b("Failed to send app launch to the service", e10);
        }
    }
}
