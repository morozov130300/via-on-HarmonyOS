package f2;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5771e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5772j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ zzq f5773k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5774l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d9 f5775m;

    public v8(d9 d9Var, String str, String str2, zzq zzqVar, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5775m = d9Var;
        this.f5771e = str;
        this.f5772j = str2;
        this.f5773k = zzqVar;
        this.f5774l = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h5 h5Var;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                d9 d9Var = this.f5775m;
                l3 l3Var = d9Var.f5098d;
                if (l3Var == null) {
                    d9Var.f5030a.d().r().c("Failed to get conditional properties; not connected to service", this.f5771e, this.f5772j);
                    h5Var = this.f5775m.f5030a;
                } else {
                    t1.f.h(this.f5773k);
                    arrayList = wa.v(l3Var.E(this.f5771e, this.f5772j, this.f5773k));
                    this.f5775m.E();
                    h5Var = this.f5775m.f5030a;
                }
            } catch (RemoteException e10) {
                this.f5775m.f5030a.d().r().d("Failed to get conditional properties; remote exception", this.f5771e, this.f5772j, e10);
                h5Var = this.f5775m.f5030a;
            }
            h5Var.N().F(this.f5774l, arrayList);
        } catch (Throwable th) {
            this.f5775m.f5030a.N().F(this.f5774l, arrayList);
            throw th;
        }
    }
}
