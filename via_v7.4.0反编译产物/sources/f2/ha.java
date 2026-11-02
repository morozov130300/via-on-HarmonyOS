package f2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ha implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ za f5283e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5284j;

    public ha(AppMeasurementDynamiteService appMeasurementDynamiteService, za zaVar) {
        this.f5284j = appMeasurementDynamiteService;
        this.f5283e = zaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5284j.f3950d.I().H(this.f5283e);
    }
}
