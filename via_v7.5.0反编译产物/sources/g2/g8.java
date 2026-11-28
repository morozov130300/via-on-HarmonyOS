package g2;

import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f4828c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f4829e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzlk f4830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d9 f4831n;

    public g8(d9 d9Var, zzq zzqVar, boolean z10, zzlk zzlkVar) {
        this.f4831n = d9Var;
        this.f4828c = zzqVar;
        this.f4829e = z10;
        this.f4830m = zzlkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f4831n;
        l3 l3Var = d9Var.f4714d;
        if (l3Var == null) {
            d9Var.f4646a.d().r().a("Discarding data. Failed to set user property");
            return;
        }
        u1.f.h(this.f4828c);
        this.f4831n.r(l3Var, this.f4829e ? null : this.f4830m, this.f4828c);
        this.f4831n.E();
    }
}
