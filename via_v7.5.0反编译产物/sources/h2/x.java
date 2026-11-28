package h2;

import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f5682c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ y f5683e;

    public x(y yVar, f fVar) {
        this.f5683e = yVar;
        this.f5682c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f fVarA = this.f5683e.f5685b.a(this.f5682c.h());
            if (fVarA == null) {
                this.f5683e.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = h.f5648b;
            fVarA.c(executor, this.f5683e);
            fVarA.b(executor, this.f5683e);
            fVarA.a(executor, this.f5683e);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f5683e.c((Exception) e10.getCause());
            } else {
                this.f5683e.c(e10);
            }
        } catch (CancellationException unused) {
            this.f5683e.b();
        } catch (Exception e11) {
            this.f5683e.c(e11);
        }
    }
}
