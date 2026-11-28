package g2;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v7 f5074c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d9 f5075e;

    public l8(d9 d9Var, v7 v7Var) {
        this.f5075e = d9Var;
        this.f5074c = v7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5075e;
        l3 l3Var = d9Var.f4714d;
        if (l3Var == null) {
            d9Var.f4646a.d().r().a("Failed to send current screen to service");
            return;
        }
        try {
            v7 v7Var = this.f5074c;
            if (v7Var == null) {
                l3Var.G(0L, null, null, d9Var.f4646a.c().getPackageName());
            } else {
                l3Var.G(v7Var.f5383c, v7Var.f5381a, v7Var.f5382b, d9Var.f4646a.c().getPackageName());
            }
            this.f5075e.E();
        } catch (RemoteException e10) {
            this.f5075e.f4646a.d().r().b("Failed to send current screen to the service", e10);
        }
    }
}
