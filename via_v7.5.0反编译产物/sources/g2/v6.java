package g2;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v6 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5379c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f5380e;

    public v6(o7 o7Var, long j10) {
        this.f5380e = o7Var;
        this.f5379c = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5380e.z(this.f5379c, true);
        this.f5380e.f4646a.L().S(new AtomicReference());
    }
}
