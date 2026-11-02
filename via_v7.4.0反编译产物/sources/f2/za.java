package f2;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class za implements j6 {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.n1 f5882a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5883b;

    public za(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.n1 n1Var) {
        this.f5883b = appMeasurementDynamiteService;
        this.f5882a = n1Var;
    }

    @Override // f2.j6
    public final void a(String str, String str2, Bundle bundle, long j10) {
        try {
            this.f5882a.d(str, str2, bundle, j10);
        } catch (RemoteException e10) {
            h5 h5Var = this.f5883b.f3950d;
            if (h5Var != null) {
                h5Var.d().w().b("Event interceptor threw exception", e10);
            }
        }
    }
}
