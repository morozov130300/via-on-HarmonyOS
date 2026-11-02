package g2;

import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f6185e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ y f6186j;

    public x(y yVar, f fVar) {
        this.f6186j = yVar;
        this.f6185e = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f fVarA = this.f6186j.f6188b.a(this.f6185e.h());
            if (fVarA == null) {
                this.f6186j.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = h.f6151b;
            fVarA.c(executor, this.f6186j);
            fVarA.b(executor, this.f6186j);
            fVarA.a(executor, this.f6186j);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f6186j.c((Exception) e10.getCause());
            } else {
                this.f6186j.c(e10);
            }
        } catch (CancellationException unused) {
            this.f6186j.b();
        } catch (Exception e11) {
            this.f6186j.c(e11);
        }
    }
}
