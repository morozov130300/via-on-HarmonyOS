package h2;

import com.google.android.gms.tasks.RuntimeExecutionException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f5658c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f5659e;

    public n(o oVar, f fVar) {
        this.f5659e = oVar;
        this.f5658c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5658c.i()) {
            this.f5659e.f5662c.p();
            return;
        }
        try {
            this.f5659e.f5662c.o(this.f5659e.f5661b.a(this.f5658c));
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f5659e.f5662c.n((Exception) e10.getCause());
            } else {
                this.f5659e.f5662c.n(e10);
            }
        } catch (Exception e11) {
            this.f5659e.f5662c.n(e11);
        }
    }
}
