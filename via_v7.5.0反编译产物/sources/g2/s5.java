package g2;

import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzau f5289c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5290e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z5 f5291m;

    public s5(z5 z5Var, zzau zzauVar, zzq zzqVar) {
        this.f5291m = z5Var;
        this.f5289c = zzauVar;
        this.f5290e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5291m.c0(this.f5291m.a0(this.f5289c, this.f5290e), this.f5290e);
    }
}
