package f2;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.wb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t9 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u9 f5713a;

    public t9(u9 u9Var) {
        this.f5713a = u9Var;
    }

    public final void a() {
        this.f5713a.h();
        if (this.f5713a.f5030a.F().v(this.f5713a.f5030a.a().a())) {
            this.f5713a.f5030a.F().f5438l.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f5713a.f5030a.d().v().a("Detected application was in foreground");
                c(this.f5713a.f5030a.a().a(), false);
            }
        }
    }

    public final void b(long j10, boolean z10) {
        this.f5713a.h();
        this.f5713a.u();
        if (this.f5713a.f5030a.F().v(j10)) {
            this.f5713a.f5030a.F().f5438l.a(true);
            ae.b();
            if (this.f5713a.f5030a.z().B(null, i3.f5326p0)) {
                this.f5713a.f5030a.B().v();
            }
        }
        this.f5713a.f5030a.F().f5441o.b(j10);
        if (this.f5713a.f5030a.F().f5438l.b()) {
            c(j10, z10);
        }
    }

    public final void c(long j10, boolean z10) {
        this.f5713a.h();
        if (this.f5713a.f5030a.o()) {
            this.f5713a.f5030a.F().f5441o.b(j10);
            this.f5713a.f5030a.d().v().b("Session started, time", Long.valueOf(this.f5713a.f5030a.a().b()));
            long j11 = j10 / 1000;
            this.f5713a.f5030a.I().M("auto", "_sid", Long.valueOf(j11), j10);
            this.f5713a.f5030a.F().f5442p.b(j11);
            this.f5713a.f5030a.F().f5438l.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j11);
            if (this.f5713a.f5030a.z().B(null, i3.f5302d0) && z10) {
                bundle.putLong("_aib", 1L);
            }
            this.f5713a.f5030a.I().v("auto", "_s", j10, bundle);
            wb.b();
            if (this.f5713a.f5030a.z().B(null, i3.f5308g0)) {
                String strA = this.f5713a.f5030a.F().f5447u.a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strA);
                this.f5713a.f5030a.I().v("auto", "_ssr", j10, bundle2);
            }
        }
    }
}
