package g2;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4647c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4648e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f4649m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f4650n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ o7 f4651o;

    public a7(o7 o7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        this.f4651o = o7Var;
        this.f4647c = atomicReference;
        this.f4648e = str2;
        this.f4649m = str3;
        this.f4650n = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4651o.f4646a.L().W(this.f4647c, null, this.f4648e, this.f4649m, this.f4650n);
    }
}
