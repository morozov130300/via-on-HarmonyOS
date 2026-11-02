package f2;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ab implements k6 {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.n1 f5040a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5041b;

    public ab(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.n1 n1Var) {
        this.f5041b = appMeasurementDynamiteService;
        this.f5040a = n1Var;
    }

    @Override // f2.k6
    public final void a(String str, String str2, Bundle bundle, long j10) {
        try {
            this.f5040a.d(str, str2, bundle, j10);
        } catch (RemoteException e10) {
            h5 h5Var = this.f5041b.f3950d;
            if (h5Var != null) {
                h5Var.d().w().b("Event listener threw exception", e10);
            }
        }
    }
}
