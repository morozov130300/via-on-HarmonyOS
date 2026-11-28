package g2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f4769c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4770e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f4771m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f4772n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4773o;

    public e9(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.k1 k1Var, String str, String str2, boolean z10) {
        this.f4773o = appMeasurementDynamiteService;
        this.f4769c = k1Var;
        this.f4770e = str;
        this.f4771m = str2;
        this.f4772n = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4773o.f3249d.L().V(this.f4769c, this.f4770e, this.f4771m, this.f4772n);
    }
}
