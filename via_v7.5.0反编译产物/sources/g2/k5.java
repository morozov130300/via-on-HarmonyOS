package g2;

import com.google.android.gms.measurement.internal.zzac;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzac f5031c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z5 f5032e;

    public k5(z5 z5Var, zzac zzacVar) {
        this.f5032e = z5Var;
        this.f5031c = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5032e.f5487d.e();
        if (this.f5031c.f3253m.c() == null) {
            this.f5032e.f5487d.s(this.f5031c);
        } else {
            this.f5032e.f5487d.y(this.f5031c);
        }
    }
}
