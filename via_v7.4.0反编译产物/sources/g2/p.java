package g2;

import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f6166e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ q f6167j;

    public p(q qVar, f fVar) {
        this.f6167j = qVar;
        this.f6166e = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f fVar = (f) this.f6167j.f6169b.a(this.f6166e);
            if (fVar == null) {
                this.f6167j.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = h.f6151b;
            fVar.c(executor, this.f6167j);
            fVar.b(executor, this.f6167j);
            fVar.a(executor, this.f6167j);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f6167j.f6170c.n((Exception) e10.getCause());
            } else {
                this.f6167j.f6170c.n(e10);
            }
        } catch (Exception e11) {
            this.f6167j.f6170c.n(e11);
        }
    }
}
