package g2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.mc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f5301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u9 f5302d;

    public s9(u9 u9Var) {
        this.f5302d = u9Var;
        this.f5301c = new r9(this, u9Var.f4646a);
        long jB = u9Var.f4646a.a().b();
        this.f5299a = jB;
        this.f5300b = jB;
    }

    public final void a() {
        this.f5301c.b();
        this.f5299a = 0L;
        this.f5300b = 0L;
    }

    public final void b(long j10) {
        this.f5301c.b();
    }

    public final void c(long j10) {
        this.f5302d.h();
        this.f5301c.b();
        this.f5299a = j10;
        this.f5300b = j10;
    }

    public final boolean d(boolean z10, boolean z11, long j10) {
        this.f5302d.h();
        this.f5302d.i();
        mc.b();
        if (!this.f5302d.f4646a.z().B(null, i3.f4926h0) || this.f5302d.f4646a.o()) {
            this.f5302d.f4646a.F().f5057o.b(this.f5302d.f4646a.a().a());
        }
        long j11 = j10 - this.f5299a;
        if (!z10 && j11 < 1000) {
            this.f5302d.f4646a.d().v().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j11));
            return false;
        }
        if (!z11) {
            j11 = j10 - this.f5300b;
            this.f5300b = j10;
        }
        this.f5302d.f4646a.d().v().b("Recording user engagement, ms", Long.valueOf(j11));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j11);
        wa.y(this.f5302d.f4646a.K().s(!this.f5302d.f4646a.z().D()), bundle, true);
        if (!z11) {
            this.f5302d.f4646a.I().u("auto", "_e", bundle);
        }
        this.f5299a = j10;
        this.f5301c.b();
        this.f5301c.d(3600000L);
        return true;
    }
}
