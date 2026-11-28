package g2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzau;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f4765c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzau f4766e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f4767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4768n;

    public e8(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.k1 k1Var, zzau zzauVar, String str) {
        this.f4768n = appMeasurementDynamiteService;
        this.f4765c = k1Var;
        this.f4766e = zzauVar;
        this.f4767m = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4768n.f3249d.L().p(this.f4765c, this.f4766e, this.f4767m);
    }
}
