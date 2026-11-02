package f2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzq;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5354e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ zzq f5355j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d9 f5356k;

    public i8(d9 d9Var, AtomicReference atomicReference, zzq zzqVar) {
        this.f5356k = d9Var;
        this.f5354e = atomicReference;
        this.f5355j = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        synchronized (this.f5354e) {
            try {
                try {
                } catch (RemoteException e10) {
                    this.f5356k.f5030a.d().r().b("Failed to get app instance id", e10);
                    atomicReference = this.f5354e;
                }
                if (this.f5356k.f5030a.F().q().j(zzha.ANALYTICS_STORAGE)) {
                    d9 d9Var = this.f5356k;
                    l3 l3Var = d9Var.f5098d;
                    if (l3Var != null) {
                        t1.f.h(this.f5355j);
                        this.f5354e.set(l3Var.o(this.f5355j));
                        String str = (String) this.f5354e.get();
                        if (str != null) {
                            this.f5356k.f5030a.I().C(str);
                            this.f5356k.f5030a.F().f5433g.b(str);
                        }
                        this.f5356k.E();
                        atomicReference = this.f5354e;
                        atomicReference.notify();
                        return;
                    }
                    d9Var.f5030a.d().r().a("Failed to get app instance id");
                    atomicReference2 = this.f5354e;
                } else {
                    this.f5356k.f5030a.d().x().a("Analytics storage consent denied; will not get app instance id");
                    this.f5356k.f5030a.I().C(null);
                    this.f5356k.f5030a.F().f5433g.b(null);
                    this.f5354e.set(null);
                    atomicReference2 = this.f5354e;
                }
                atomicReference2.notify();
            } catch (Throwable th) {
                this.f5354e.notify();
                throw th;
            }
        }
    }
}
