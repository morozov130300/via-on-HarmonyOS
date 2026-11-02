package f2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5085e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5086j;

    public d7(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5086j = appMeasurementDynamiteService;
        this.f5085e = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5086j.f3950d.L().R(this.f5085e);
    }
}
