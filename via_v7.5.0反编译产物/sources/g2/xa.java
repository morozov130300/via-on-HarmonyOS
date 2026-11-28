package g2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class xa implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5437c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5438e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5440n;

    public xa(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.k1 k1Var, String str, String str2) {
        this.f5440n = appMeasurementDynamiteService;
        this.f5437c = k1Var;
        this.f5438e = str;
        this.f5439m = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5440n.f3249d.L().T(this.f5437c, this.f5438e, this.f5439m);
    }
}
