package g2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w6 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f5405c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f5406e;

    public w6(o7 o7Var, Bundle bundle) {
        this.f5406e = o7Var;
        this.f5405c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o7 o7Var = this.f5406e;
        Bundle bundle = this.f5405c;
        o7Var.h();
        o7Var.i();
        u1.f.h(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        u1.f.d(string);
        u1.f.d(string2);
        u1.f.h(bundle.get("value"));
        if (!o7Var.f4646a.o()) {
            o7Var.f4646a.d().v().a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzlk zzlkVar = new zzlk(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            zzau zzauVarY0 = o7Var.f4646a.N().y0(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            o7Var.f4646a.L().s(new zzac(bundle.getString("app_id"), string2, zzlkVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), o7Var.f4646a.N().y0(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), zzauVarY0, bundle.getLong("time_to_live"), o7Var.f4646a.N().y0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
