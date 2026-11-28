package g2;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5119c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f5120e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d9 f5121m;

    public m8(d9 d9Var, zzq zzqVar, Bundle bundle) {
        this.f5121m = d9Var;
        this.f5119c = zzqVar;
        this.f5120e = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5121m;
        l3 l3Var = d9Var.f4714d;
        if (l3Var == null) {
            d9Var.f4646a.d().r().a("Failed to send default event parameters to service");
            return;
        }
        try {
            u1.f.h(this.f5119c);
            l3Var.i(this.f5120e, this.f5119c);
        } catch (RemoteException e10) {
            this.f5121m.f4646a.d().r().b("Failed to send default event parameters to service", e10);
        }
    }
}
