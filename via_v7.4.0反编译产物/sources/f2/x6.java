package f2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzlk;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x6 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f5812e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o7 f5813j;

    public x6(o7 o7Var, Bundle bundle) {
        this.f5813j = o7Var;
        this.f5812e = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o7 o7Var = this.f5813j;
        Bundle bundle = this.f5812e;
        o7Var.h();
        o7Var.i();
        t1.f.h(bundle);
        String strD = t1.f.d(bundle.getString("name"));
        if (!o7Var.f5030a.o()) {
            o7Var.f5030a.d().v().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            o7Var.f5030a.L().s(new zzac(bundle.getString("app_id"), "", new zzlk(strD, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), o7Var.f5030a.N().y0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
