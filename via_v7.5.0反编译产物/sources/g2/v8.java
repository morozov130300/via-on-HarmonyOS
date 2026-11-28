package g2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5387c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5388e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzq f5389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5390n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d9 f5391o;

    public v8(d9 d9Var, String str, String str2, zzq zzqVar, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5391o = d9Var;
        this.f5387c = str;
        this.f5388e = str2;
        this.f5389m = zzqVar;
        this.f5390n = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h5 h5Var;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                d9 d9Var = this.f5391o;
                l3 l3Var = d9Var.f4714d;
                if (l3Var == null) {
                    d9Var.f4646a.d().r().c("Failed to get conditional properties; not connected to service", this.f5387c, this.f5388e);
                    h5Var = this.f5391o.f4646a;
                } else {
                    u1.f.h(this.f5389m);
                    arrayList = wa.v(l3Var.D(this.f5387c, this.f5388e, this.f5389m));
                    this.f5391o.E();
                    h5Var = this.f5391o.f4646a;
                }
            } catch (RemoteException e10) {
                this.f5391o.f4646a.d().r().d("Failed to get conditional properties; remote exception", this.f5387c, this.f5388e, e10);
                h5Var = this.f5391o.f4646a;
            }
            wa waVarN = h5Var.N();
        } finally {
            this.f5391o.f4646a.N().F(this.f5390n, arrayList);
        }
    }
}
