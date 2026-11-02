package f2;

import android.os.RemoteException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ v7 f5458e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d9 f5459j;

    public l8(d9 d9Var, v7 v7Var) {
        this.f5459j = d9Var;
        this.f5458e = v7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5459j;
        l3 l3Var = d9Var.f5098d;
        if (l3Var == null) {
            d9Var.f5030a.d().r().a("Failed to send current screen to service");
            return;
        }
        try {
            v7 v7Var = this.f5458e;
            if (v7Var == null) {
                l3Var.H(0L, null, null, d9Var.f5030a.c().getPackageName());
            } else {
                l3Var.H(v7Var.f5767c, v7Var.f5765a, v7Var.f5766b, d9Var.f5030a.c().getPackageName());
            }
            this.f5459j.E();
        } catch (RemoteException e10) {
            this.f5459j.f5030a.d().r().b("Failed to send current screen to the service", e10);
        }
    }
}
