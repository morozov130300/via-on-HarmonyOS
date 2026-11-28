package h2;

import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f5663c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f5664e;

    public p(q qVar, f fVar) {
        this.f5664e = qVar;
        this.f5663c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f fVar = (f) this.f5664e.f5666b.a(this.f5663c);
            if (fVar == null) {
                this.f5664e.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = h.f5648b;
            fVar.c(executor, this.f5664e);
            fVar.b(executor, this.f5664e);
            fVar.a(executor, this.f5664e);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f5664e.f5667c.n((Exception) e10.getCause());
            } else {
                this.f5664e.f5667c.n(e10);
            }
        } catch (Exception e11) {
            this.f5664e.f5667c.n(e11);
        }
    }
}
