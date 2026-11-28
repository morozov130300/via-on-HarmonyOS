package g2;

import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzlk f5376c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5377e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z5 f5378m;

    public v5(z5 z5Var, zzlk zzlkVar, zzq zzqVar) {
        this.f5378m = z5Var;
        this.f5376c = zzlkVar;
        this.f5377e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5378m.f5487d.e();
        if (this.f5376c.c() == null) {
            this.f5378m.f5487d.u(this.f5376c.f3269e, this.f5377e);
        } else {
            this.f5378m.f5487d.B(this.f5376c, this.f5377e);
        }
    }
}
