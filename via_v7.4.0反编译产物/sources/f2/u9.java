package f2;

import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u9 extends c4 {

    /* renamed from: c, reason: collision with root package name */
    public Handler f5738c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5739d;

    /* renamed from: e, reason: collision with root package name */
    public final t9 f5740e;

    /* renamed from: f, reason: collision with root package name */
    public final s9 f5741f;

    /* renamed from: g, reason: collision with root package name */
    public final q9 f5742g;

    public u9(h5 h5Var) {
        super(h5Var);
        this.f5739d = true;
        this.f5740e = new t9(this);
        this.f5741f = new s9(this);
        this.f5742g = new q9(this);
    }

    public static /* bridge */ /* synthetic */ void q(u9 u9Var, long j10) {
        u9Var.h();
        u9Var.u();
        u9Var.f5030a.d().v().b("Activity paused, time", Long.valueOf(j10));
        u9Var.f5742g.a(j10);
        if (u9Var.f5030a.z().D()) {
            u9Var.f5741f.b(j10);
        }
    }

    public static /* bridge */ /* synthetic */ void r(u9 u9Var, long j10) {
        u9Var.h();
        u9Var.u();
        u9Var.f5030a.d().v().b("Activity resumed, time", Long.valueOf(j10));
        if (u9Var.f5030a.z().B(null, i3.I0)) {
            if (u9Var.f5030a.z().D() || u9Var.f5739d) {
                u9Var.f5741f.c(j10);
            }
        } else if (u9Var.f5030a.z().D() || u9Var.f5030a.F().f5444r.b()) {
            u9Var.f5741f.c(j10);
        }
        u9Var.f5742g.b();
        t9 t9Var = u9Var.f5740e;
        t9Var.f5713a.h();
        if (t9Var.f5713a.f5030a.o()) {
            t9Var.b(t9Var.f5713a.f5030a.a().a(), false);
        }
    }

    @Override // f2.c4
    public final boolean n() {
        return false;
    }

    public final void s(boolean z10) {
        h();
        this.f5739d = z10;
    }

    public final boolean t() {
        h();
        return this.f5739d;
    }

    public final void u() {
        h();
        if (this.f5738c == null) {
            this.f5738c = new com.google.android.gms.internal.measurement.c1(Looper.getMainLooper());
        }
    }
}
