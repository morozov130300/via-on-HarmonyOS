package f2;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5503e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Bundle f5504j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d9 f5505k;

    public m8(d9 d9Var, zzq zzqVar, Bundle bundle) {
        this.f5505k = d9Var;
        this.f5503e = zzqVar;
        this.f5504j = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5505k;
        l3 l3Var = d9Var.f5098d;
        if (l3Var == null) {
            d9Var.f5030a.d().r().a("Failed to send default event parameters to service");
            return;
        }
        try {
            t1.f.h(this.f5503e);
            l3Var.i(this.f5504j, this.f5503e);
        } catch (RemoteException e10) {
            this.f5505k.f5030a.d().r().b("Failed to send default event parameters to service", e10);
        }
    }
}
