package g2;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class za implements j6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.n1 f5498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5499b;

    public za(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.n1 n1Var) {
        this.f5499b = appMeasurementDynamiteService;
        this.f5498a = n1Var;
    }

    @Override // g2.j6
    public final void a(String str, String str2, Bundle bundle, long j10) {
        try {
            this.f5498a.d(str, str2, bundle, j10);
        } catch (RemoteException e10) {
            h5 h5Var = this.f5499b.f3249d;
            if (h5Var != null) {
                h5Var.d().w().b("Event interceptor threw exception", e10);
            }
        }
    }
}
