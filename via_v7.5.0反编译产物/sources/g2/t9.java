package g2;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.wb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u9 f5329a;

    public t9(u9 u9Var) {
        this.f5329a = u9Var;
    }

    public final void a() {
        this.f5329a.h();
        if (this.f5329a.f4646a.F().v(this.f5329a.f4646a.a().a())) {
            this.f5329a.f4646a.F().f5054l.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f5329a.f4646a.d().v().a("Detected application was in foreground");
                c(this.f5329a.f4646a.a().a(), false);
            }
        }
    }

    public final void b(long j10, boolean z10) {
        this.f5329a.h();
        this.f5329a.u();
        if (this.f5329a.f4646a.F().v(j10)) {
            this.f5329a.f4646a.F().f5054l.a(true);
            ae.b();
            if (this.f5329a.f4646a.z().B(null, i3.f4942p0)) {
                this.f5329a.f4646a.B().v();
            }
        }
        this.f5329a.f4646a.F().f5057o.b(j10);
        if (this.f5329a.f4646a.F().f5054l.b()) {
            c(j10, z10);
        }
    }

    public final void c(long j10, boolean z10) {
        this.f5329a.h();
        if (this.f5329a.f4646a.o()) {
            this.f5329a.f4646a.F().f5057o.b(j10);
            this.f5329a.f4646a.d().v().b("Session started, time", Long.valueOf(this.f5329a.f4646a.a().b()));
            long j11 = j10 / 1000;
            this.f5329a.f4646a.I().M("auto", "_sid", Long.valueOf(j11), j10);
            this.f5329a.f4646a.F().f5058p.b(j11);
            this.f5329a.f4646a.F().f5054l.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j11);
            if (this.f5329a.f4646a.z().B(null, i3.f4918d0) && z10) {
                bundle.putLong("_aib", 1L);
            }
            this.f5329a.f4646a.I().v("auto", "_s", j10, bundle);
            wb.b();
            if (this.f5329a.f4646a.z().B(null, i3.f4924g0)) {
                String strA = this.f5329a.f4646a.F().f5063u.a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strA);
                this.f5329a.f4646a.I().v("auto", "_ssr", j10, bundle2);
            }
        }
    }
}
