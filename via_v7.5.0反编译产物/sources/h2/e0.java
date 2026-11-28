package h2;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d0 f5644c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Callable f5645e;

    public e0(d0 d0Var, Callable callable) {
        this.f5644c = d0Var;
        this.f5645e = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5644c.o(this.f5645e.call());
        } catch (Exception e10) {
            this.f5644c.n(e10);
        } catch (Throwable th) {
            this.f5644c.n(new RuntimeException(th));
        }
    }
}
