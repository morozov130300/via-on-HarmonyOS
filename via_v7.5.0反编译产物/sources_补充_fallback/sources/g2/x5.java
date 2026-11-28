package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x5 implements java.lang.Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.measurement.internal.zzq f5426c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g2.z5 f5427e;

    public x5(g2.z5 r1, com.google.android.gms.measurement.internal.zzq r2) {
            r0 = this;
            r0.f5427e = r1
            r0.f5426c = r2
            r0.<init>()
            return
    }

    @Override // java.lang.Runnable
    public final void run() {
            r2 = this;
            g2.z5 r0 = r2.f5427e
            g2.pa r0 = g2.z5.b0(r0)
            r0.e()
            g2.z5 r0 = r2.f5427e
            g2.pa r0 = g2.z5.b0(r0)
            com.google.android.gms.measurement.internal.zzq r1 = r2.f5426c
            r0.q(r1)
            return
    }
}
