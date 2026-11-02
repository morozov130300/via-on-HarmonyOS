package f2;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzau;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5149e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ zzau f5150j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5151k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5152l;

    public e8(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.k1 k1Var, zzau zzauVar, String str) {
        this.f5152l = appMeasurementDynamiteService;
        this.f5149e = k1Var;
        this.f5150j = zzauVar;
        this.f5151k = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5152l.f3950d.L().p(this.f5149e, this.f5150j, this.f5151k);
    }
}
