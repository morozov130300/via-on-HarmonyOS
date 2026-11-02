package f2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5422e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d9 f5423j;

    public k8(d9 d9Var, zzq zzqVar) {
        this.f5423j = d9Var;
        this.f5422e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5423j;
        l3 l3Var = d9Var.f5098d;
        if (l3Var == null) {
            d9Var.f5030a.d().r().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            t1.f.h(this.f5422e);
            l3Var.D(this.f5422e);
            this.f5423j.f5030a.C().t();
            this.f5423j.r(l3Var, null, this.f5422e);
            this.f5423j.E();
        } catch (RemoteException e10) {
            this.f5423j.f5030a.d().r().b("Failed to send app launch to the service", e10);
        }
    }
}
