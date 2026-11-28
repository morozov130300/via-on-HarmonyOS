package g2;

import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5294c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f5295e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzau f5296m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f5297n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d9 f5298o;

    public s8(d9 d9Var, boolean z10, zzq zzqVar, boolean z11, zzau zzauVar, String str) {
        this.f5298o = d9Var;
        this.f5294c = zzqVar;
        this.f5295e = z11;
        this.f5296m = zzauVar;
        this.f5297n = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5298o;
        l3 l3Var = d9Var.f4714d;
        if (l3Var == null) {
            d9Var.f4646a.d().r().a("Discarding data. Failed to send event to service");
            return;
        }
        u1.f.h(this.f5294c);
        this.f5298o.r(l3Var, this.f5295e ? null : this.f5296m, this.f5294c);
        this.f5298o.E();
    }
}
