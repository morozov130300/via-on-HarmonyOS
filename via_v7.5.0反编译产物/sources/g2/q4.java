package g2;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p4 f5247a;

    public q4(p4 p4Var) {
        u1.f.h(p4Var);
        this.f5247a = p4Var;
    }

    public final void a(Context context, Intent intent) {
        h5 h5VarH = h5.H(context, null, null);
        v3 v3VarD = h5VarH.d();
        if (intent == null) {
            v3VarD.w().a("Receiver called with null intent");
            return;
        }
        h5VarH.b();
        String action = intent.getAction();
        v3VarD.v().b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                v3VarD.w().a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            v3VarD.v().a("Starting wakeful intent.");
            this.f5247a.a(context, className);
        }
    }
}
