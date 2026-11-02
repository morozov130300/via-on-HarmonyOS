package f2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5640e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d9 f5641j;

    public q8(d9 d9Var, zzq zzqVar) {
        this.f5641j = d9Var;
        this.f5640e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5641j;
        l3 l3Var = d9Var.f5098d;
        if (l3Var == null) {
            d9Var.f5030a.d().r().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            t1.f.h(this.f5640e);
            l3Var.e(this.f5640e);
            this.f5641j.E();
        } catch (RemoteException e10) {
            this.f5641j.f5030a.d().r().b("Failed to send measurementEnabled to the service", e10);
        }
    }
}
