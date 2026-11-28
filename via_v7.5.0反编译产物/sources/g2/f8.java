package g2;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4799c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4800e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzq f4801m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f4802n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f4803o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d9 f4804p;

    public f8(d9 d9Var, String str, String str2, zzq zzqVar, boolean z10, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f4804p = d9Var;
        this.f4799c = str;
        this.f4800e = str2;
        this.f4801m = zzqVar;
        this.f4802n = z10;
        this.f4803o = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e10;
        Bundle bundle2 = new Bundle();
        try {
            try {
                d9 d9Var = this.f4804p;
                l3 l3Var = d9Var.f4714d;
                if (l3Var == null) {
                    d9Var.f4646a.d().r().c("Failed to get user properties; not connected to service", this.f4799c, this.f4800e);
                    this.f4804p.f4646a.N().G(this.f4803o, bundle2);
                    return;
                }
                u1.f.h(this.f4801m);
                List<zzlk> listP = l3Var.P(this.f4799c, this.f4800e, this.f4802n, this.f4801m);
                bundle = new Bundle();
                if (listP != null) {
                    for (zzlk zzlkVar : listP) {
                        String str = zzlkVar.f3272o;
                        if (str != null) {
                            bundle.putString(zzlkVar.f3269e, str);
                        } else {
                            Long l10 = zzlkVar.f3271n;
                            if (l10 != null) {
                                bundle.putLong(zzlkVar.f3269e, l10.longValue());
                            } else {
                                Double d10 = zzlkVar.f3274q;
                                if (d10 != null) {
                                    bundle.putDouble(zzlkVar.f3269e, d10.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    this.f4804p.E();
                    this.f4804p.f4646a.N().G(this.f4803o, bundle);
                } catch (RemoteException e11) {
                    e10 = e11;
                    this.f4804p.f4646a.d().r().c("Failed to get user properties; remote exception", this.f4799c, e10);
                    this.f4804p.f4646a.N().G(this.f4803o, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                this.f4804p.f4646a.N().G(this.f4803o, bundle2);
                throw th;
            }
        } catch (RemoteException e12) {
            bundle = bundle2;
            e10 = e12;
        } catch (Throwable th2) {
            th = th2;
            this.f4804p.f4646a.N().G(this.f4803o, bundle2);
            throw th;
        }
    }
}
