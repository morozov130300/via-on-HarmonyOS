package f2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e9 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5153e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5154j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5155k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f5156l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5157m;

    public e9(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.k1 k1Var, String str, String str2, boolean z10) {
        this.f5157m = appMeasurementDynamiteService;
        this.f5153e = k1Var;
        this.f5154j = str;
        this.f5155k = str2;
        this.f5156l = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5157m.f3950d.L().V(this.f5153e, this.f5154j, this.f5155k, this.f5156l);
    }
}
