package f2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ya implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5858e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5859j;

    public ya(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5859j = appMeasurementDynamiteService;
        this.f5858e = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5859j.f3950d.N().E(this.f5858e, this.f5859j.f3950d.n());
    }
}
