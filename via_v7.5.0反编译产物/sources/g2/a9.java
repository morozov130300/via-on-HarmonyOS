package g2;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c9 f4654c;

    public a9(c9 c9Var) {
        this.f4654c = c9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f4654c.f4691c;
        Context contextC = d9Var.f4646a.c();
        this.f4654c.f4691c.f4646a.b();
        d9.M(d9Var, new ComponentName(contextC, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
