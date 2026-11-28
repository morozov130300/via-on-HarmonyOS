package g2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.ud;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5200c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5201e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ q9 f5202m;

    public p9(q9 q9Var, long j10, long j11) {
        this.f5202m = q9Var;
        this.f5200c = j10;
        this.f5201e = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5202m.f5259b.f4646a.f().z(new Runnable() { // from class: g2.o9
            @Override // java.lang.Runnable
            public final void run() {
                p9 p9Var = this.f5183c;
                q9 q9Var = p9Var.f5202m;
                long j10 = p9Var.f5200c;
                long j11 = p9Var.f5201e;
                q9Var.f5259b.h();
                q9Var.f5259b.f4646a.d().q().a("Application going to the background");
                q9Var.f5259b.f4646a.F().f5060r.a(true);
                q9Var.f5259b.s(true);
                if (!q9Var.f5259b.f4646a.z().D()) {
                    q9Var.f5259b.f5357f.b(j11);
                    q9Var.f5259b.f5357f.d(false, false, j11);
                }
                ud.b();
                if (q9Var.f5259b.f4646a.z().B(null, i3.D0)) {
                    q9Var.f5259b.f4646a.d().u().b("Application backgrounded at: timestamp_millis", Long.valueOf(j10));
                } else {
                    q9Var.f5259b.f4646a.I().v("auto", "_ab", j10, new Bundle());
                }
            }
        });
    }
}
