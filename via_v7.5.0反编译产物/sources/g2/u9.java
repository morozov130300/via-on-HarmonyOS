package g2;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u9 extends c4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f5354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t9 f5356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s9 f5357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q9 f5358g;

    public u9(h5 h5Var) {
        super(h5Var);
        this.f5355d = true;
        this.f5356e = new t9(this);
        this.f5357f = new s9(this);
        this.f5358g = new q9(this);
    }

    public static /* bridge */ /* synthetic */ void q(u9 u9Var, long j10) {
        u9Var.h();
        u9Var.u();
        u9Var.f4646a.d().v().b("Activity paused, time", Long.valueOf(j10));
        u9Var.f5358g.a(j10);
        if (u9Var.f4646a.z().D()) {
            u9Var.f5357f.b(j10);
        }
    }

    public static /* bridge */ /* synthetic */ void r(u9 u9Var, long j10) {
        u9Var.h();
        u9Var.u();
        u9Var.f4646a.d().v().b("Activity resumed, time", Long.valueOf(j10));
        if (u9Var.f4646a.z().B(null, i3.I0)) {
            if (u9Var.f4646a.z().D() || u9Var.f5355d) {
                u9Var.f5357f.c(j10);
            }
        } else if (u9Var.f4646a.z().D() || u9Var.f4646a.F().f5060r.b()) {
            u9Var.f5357f.c(j10);
        }
        u9Var.f5358g.b();
        t9 t9Var = u9Var.f5356e;
        t9Var.f5329a.h();
        if (t9Var.f5329a.f4646a.o()) {
            t9Var.b(t9Var.f5329a.f4646a.a().a(), false);
        }
    }

    @Override // g2.c4
    public final boolean n() {
        return false;
    }

    public final void s(boolean z10) {
        h();
        this.f5355d = z10;
    }

    public final boolean t() {
        h();
        return this.f5355d;
    }

    public final void u() {
        h();
        if (this.f5354c == null) {
            this.f5354c = new com.google.android.gms.internal.measurement.c1(Looper.getMainLooper());
        }
    }
}
