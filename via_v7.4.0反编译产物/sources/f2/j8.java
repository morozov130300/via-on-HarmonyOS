package f2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5387e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5388j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d9 f5389k;

    public j8(d9 d9Var, zzq zzqVar, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5389k = d9Var;
        this.f5387e = zzqVar;
        this.f5388j = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h5 h5Var;
        String strO = null;
        try {
            try {
                if (this.f5389k.f5030a.F().q().j(zzha.ANALYTICS_STORAGE)) {
                    d9 d9Var = this.f5389k;
                    l3 l3Var = d9Var.f5098d;
                    if (l3Var == null) {
                        d9Var.f5030a.d().r().a("Failed to get app instance id");
                        h5Var = this.f5389k.f5030a;
                    } else {
                        t1.f.h(this.f5387e);
                        strO = l3Var.o(this.f5387e);
                        if (strO != null) {
                            this.f5389k.f5030a.I().C(strO);
                            this.f5389k.f5030a.F().f5433g.b(strO);
                        }
                        this.f5389k.E();
                        h5Var = this.f5389k.f5030a;
                    }
                } else {
                    this.f5389k.f5030a.d().x().a("Analytics storage consent denied; will not get app instance id");
                    this.f5389k.f5030a.I().C(null);
                    this.f5389k.f5030a.F().f5433g.b(null);
                    h5Var = this.f5389k.f5030a;
                }
            } catch (RemoteException e10) {
                this.f5389k.f5030a.d().r().b("Failed to get app instance id", e10);
                h5Var = this.f5389k.f5030a;
            }
            h5Var.N().K(this.f5388j, strO);
        } catch (Throwable th) {
            this.f5389k.f5030a.N().K(this.f5388j, null);
            throw th;
        }
    }
}
