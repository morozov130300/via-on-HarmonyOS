package g2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ha implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ za f4899c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4900e;

    public ha(AppMeasurementDynamiteService appMeasurementDynamiteService, za zaVar) {
        this.f4900e = appMeasurementDynamiteService;
        this.f4899c = zaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4900e.f3249d.I().H(this.f4899c);
    }
}
