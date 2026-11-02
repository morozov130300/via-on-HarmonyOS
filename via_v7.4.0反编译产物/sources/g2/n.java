package g2;

import com.google.android.gms.tasks.RuntimeExecutionException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f6161e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o f6162j;

    public n(o oVar, f fVar) {
        this.f6162j = oVar;
        this.f6161e = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f6161e.i()) {
            this.f6162j.f6165c.p();
            return;
        }
        try {
            this.f6162j.f6165c.o(this.f6162j.f6164b.a(this.f6161e));
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f6162j.f6165c.n((Exception) e10.getCause());
            } else {
                this.f6162j.f6165c.n(e10);
            }
        } catch (Exception e11) {
            this.f6162j.f6165c.n(e11);
        }
    }
}
