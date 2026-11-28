package g2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzq;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4970c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f4971e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d9 f4972m;

    public i8(d9 d9Var, AtomicReference atomicReference, zzq zzqVar) {
        this.f4972m = d9Var;
        this.f4970c = atomicReference;
        this.f4971e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        synchronized (this.f4970c) {
            try {
                try {
                    if (this.f4972m.f4646a.F().q().j(zzha.ANALYTICS_STORAGE)) {
                        d9 d9Var = this.f4972m;
                        l3 l3Var = d9Var.f4714d;
                        if (l3Var != null) {
                            u1.f.h(this.f4971e);
                            this.f4970c.set(l3Var.o(this.f4971e));
                            String str = (String) this.f4970c.get();
                            if (str != null) {
                                this.f4972m.f4646a.I().C(str);
                                this.f4972m.f4646a.F().f5049g.b(str);
                            }
                            this.f4972m.E();
                            atomicReference = this.f4970c;
                            atomicReference.notify();
                            return;
                        }
                        d9Var.f4646a.d().r().a("Failed to get app instance id");
                        atomicReference2 = this.f4970c;
                    } else {
                        this.f4972m.f4646a.d().x().a("Analytics storage consent denied; will not get app instance id");
                        this.f4972m.f4646a.I().C(null);
                        this.f4972m.f4646a.F().f5049g.b(null);
                        this.f4970c.set(null);
                        atomicReference2 = this.f4970c;
                    }
                    atomicReference2.notify();
                } catch (RemoteException e10) {
                    this.f4972m.f4646a.d().r().b("Failed to get app instance id", e10);
                    atomicReference = this.f4970c;
                }
            } catch (Throwable th) {
                this.f4970c.notify();
                throw th;
            }
        }
    }
}
