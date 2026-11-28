package g2;

import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzac f4994c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f4995e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z5 f4996m;

    public j5(z5 z5Var, zzac zzacVar, zzq zzqVar) {
        this.f4996m = z5Var;
        this.f4994c = zzacVar;
        this.f4995e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4996m.f5487d.e();
        if (this.f4994c.f3253m.c() == null) {
            this.f4996m.f5487d.t(this.f4994c, this.f4995e);
        } else {
            this.f4996m.f5487d.z(this.f4994c, this.f4995e);
        }
    }
}
