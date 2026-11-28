package g2;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y6 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5463c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5464e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ o7 f5466n;

    public y6(o7 o7Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f5466n = o7Var;
        this.f5463c = atomicReference;
        this.f5464e = str2;
        this.f5465m = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5466n.f4646a.L().U(this.f5463c, null, this.f5464e, this.f5465m);
    }
}
