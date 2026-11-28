package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Boolean f4968c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f4969e;

    public i7(o7 o7Var, Boolean bool) {
        this.f4969e = o7Var;
        this.f4968c = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4969e.O(this.f4968c, true);
    }
}
