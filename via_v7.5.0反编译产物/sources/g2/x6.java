package g2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzlk;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x6 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f5428c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f5429e;

    public x6(o7 o7Var, Bundle bundle) {
        this.f5429e = o7Var;
        this.f5428c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o7 o7Var = this.f5429e;
        Bundle bundle = this.f5428c;
        o7Var.h();
        o7Var.i();
        u1.f.h(bundle);
        String strD = u1.f.d(bundle.getString("name"));
        if (!o7Var.f4646a.o()) {
            o7Var.f4646a.d().v().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            o7Var.f4646a.L().s(new zzac(bundle.getString("app_id"), "", new zzlk(strD, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), o7Var.f4646a.N().y0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
