package f2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class xa implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5821e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5822j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5823k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5824l;

    public xa(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.k1 k1Var, String str, String str2) {
        this.f5824l = appMeasurementDynamiteService;
        this.f5821e = k1Var;
        this.f5822j = str;
        this.f5823k = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5824l.f3950d.L().T(this.f5821e, this.f5822j, this.f5823k);
    }
}
