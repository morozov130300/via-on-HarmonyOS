package f2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzau;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzau f5563e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5564j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5565k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d9 f5566l;

    public o8(d9 d9Var, zzau zzauVar, String str, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5566l = d9Var;
        this.f5563e = zzauVar;
        this.f5564j = str;
        this.f5565k = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h5 h5Var;
        byte[] bArrV = null;
        try {
            try {
                d9 d9Var = this.f5566l;
                l3 l3Var = d9Var.f5098d;
                if (l3Var == null) {
                    d9Var.f5030a.d().r().a("Discarding data. Failed to send event to service to bundle");
                    h5Var = this.f5566l.f5030a;
                } else {
                    bArrV = l3Var.V(this.f5563e, this.f5564j);
                    this.f5566l.E();
                    h5Var = this.f5566l.f5030a;
                }
            } catch (RemoteException e10) {
                this.f5566l.f5030a.d().r().b("Failed to send event to the service to bundle", e10);
                h5Var = this.f5566l.f5030a;
            }
            h5Var.N().H(this.f5565k, bArrV);
        } catch (Throwable th) {
            this.f5566l.f5030a.N().H(this.f5565k, bArrV);
            throw th;
        }
    }
}
