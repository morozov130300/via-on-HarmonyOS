package f2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.mc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s9 {

    /* renamed from: a, reason: collision with root package name */
    public long f5683a;

    /* renamed from: b, reason: collision with root package name */
    public long f5684b;

    /* renamed from: c, reason: collision with root package name */
    public final n f5685c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u9 f5686d;

    public s9(u9 u9Var) {
        this.f5686d = u9Var;
        this.f5685c = new r9(this, u9Var.f5030a);
        long jB = u9Var.f5030a.a().b();
        this.f5683a = jB;
        this.f5684b = jB;
    }

    public final void a() {
        this.f5685c.b();
        this.f5683a = 0L;
        this.f5684b = 0L;
    }

    public final void b(long j10) {
        this.f5685c.b();
    }

    public final void c(long j10) {
        this.f5686d.h();
        this.f5685c.b();
        this.f5683a = j10;
        this.f5684b = j10;
    }

    public final boolean d(boolean z10, boolean z11, long j10) {
        this.f5686d.h();
        this.f5686d.i();
        mc.b();
        if (!this.f5686d.f5030a.z().B(null, i3.f5310h0) || this.f5686d.f5030a.o()) {
            this.f5686d.f5030a.F().f5441o.b(this.f5686d.f5030a.a().a());
        }
        long j11 = j10 - this.f5683a;
        if (!z10 && j11 < 1000) {
            this.f5686d.f5030a.d().v().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j11));
            return false;
        }
        if (!z11) {
            j11 = j10 - this.f5684b;
            this.f5684b = j10;
        }
        this.f5686d.f5030a.d().v().b("Recording user engagement, ms", Long.valueOf(j11));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j11);
        wa.y(this.f5686d.f5030a.K().s(!this.f5686d.f5030a.z().D()), bundle, true);
        if (!z11) {
            this.f5686d.f5030a.I().u("auto", "_e", bundle);
        }
        this.f5683a = j10;
        this.f5685c.b();
        this.f5685c.d(3600000L);
        return true;
    }
}
