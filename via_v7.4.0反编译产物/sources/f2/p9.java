package f2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.ud;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p9 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final long f5584e;

    /* renamed from: j, reason: collision with root package name */
    public final long f5585j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ q9 f5586k;

    public p9(q9 q9Var, long j10, long j11) {
        this.f5586k = q9Var;
        this.f5584e = j10;
        this.f5585j = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5586k.f5643b.f5030a.f().z(new Runnable() { // from class: f2.o9
            @Override // java.lang.Runnable
            public final void run() {
                p9 p9Var = this.f5567e;
                q9 q9Var = p9Var.f5586k;
                long j10 = p9Var.f5584e;
                long j11 = p9Var.f5585j;
                q9Var.f5643b.h();
                q9Var.f5643b.f5030a.d().q().a("Application going to the background");
                q9Var.f5643b.f5030a.F().f5444r.a(true);
                q9Var.f5643b.s(true);
                if (!q9Var.f5643b.f5030a.z().D()) {
                    q9Var.f5643b.f5741f.b(j11);
                    q9Var.f5643b.f5741f.d(false, false, j11);
                }
                ud.b();
                if (q9Var.f5643b.f5030a.z().B(null, i3.D0)) {
                    q9Var.f5643b.f5030a.d().u().b("Application backgrounded at: timestamp_millis", Long.valueOf(j10));
                } else {
                    q9Var.f5643b.f5030a.I().v("auto", "_ab", j10, new Bundle());
                }
            }
        });
    }
}
