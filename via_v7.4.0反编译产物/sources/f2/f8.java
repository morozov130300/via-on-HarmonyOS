package f2;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5183e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5184j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ zzq f5185k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f5186l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5187m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d9 f5188n;

    public f8(d9 d9Var, String str, String str2, zzq zzqVar, boolean z10, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5188n = d9Var;
        this.f5183e = str;
        this.f5184j = str2;
        this.f5185k = zzqVar;
        this.f5186l = z10;
        this.f5187m = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e10;
        Bundle bundle2 = new Bundle();
        try {
            try {
                d9 d9Var = this.f5188n;
                l3 l3Var = d9Var.f5098d;
                if (l3Var == null) {
                    d9Var.f5030a.d().r().c("Failed to get user properties; not connected to service", this.f5183e, this.f5184j);
                    this.f5188n.f5030a.N().G(this.f5187m, bundle2);
                    return;
                }
                t1.f.h(this.f5185k);
                List<zzlk> listQ = l3Var.Q(this.f5183e, this.f5184j, this.f5186l, this.f5185k);
                bundle = new Bundle();
                if (listQ != null) {
                    for (zzlk zzlkVar : listQ) {
                        String str = zzlkVar.f3973m;
                        if (str != null) {
                            bundle.putString(zzlkVar.f3970j, str);
                        } else {
                            Long l10 = zzlkVar.f3972l;
                            if (l10 != null) {
                                bundle.putLong(zzlkVar.f3970j, l10.longValue());
                            } else {
                                Double d10 = zzlkVar.f3975o;
                                if (d10 != null) {
                                    bundle.putDouble(zzlkVar.f3970j, d10.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    this.f5188n.E();
                    this.f5188n.f5030a.N().G(this.f5187m, bundle);
                } catch (RemoteException e11) {
                    e10 = e11;
                    this.f5188n.f5030a.d().r().c("Failed to get user properties; remote exception", this.f5183e, e10);
                    this.f5188n.f5030a.N().G(this.f5187m, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                this.f5188n.f5030a.N().G(this.f5187m, bundle2);
                throw th;
            }
        } catch (RemoteException e12) {
            bundle = bundle2;
            e10 = e12;
        } catch (Throwable th2) {
            th = th2;
            this.f5188n.f5030a.N().G(this.f5187m, bundle2);
            throw th;
        }
    }
}
