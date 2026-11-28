package g2;

import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f5324c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f5325e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzac f5326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzac f5327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d9 f5328o;

    public t8(d9 d9Var, boolean z10, zzq zzqVar, boolean z11, zzac zzacVar, zzac zzacVar2) {
        this.f5328o = d9Var;
        this.f5324c = zzqVar;
        this.f5325e = z11;
        this.f5326m = zzacVar;
        this.f5327n = zzacVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5328o;
        l3 l3Var = d9Var.f4714d;
        if (l3Var == null) {
            d9Var.f4646a.d().r().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        u1.f.h(this.f5324c);
        this.f5328o.r(l3Var, this.f5325e ? null : this.f5326m, this.f5324c);
        this.f5328o.E();
    }
}
