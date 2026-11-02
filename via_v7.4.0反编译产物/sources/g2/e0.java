package g2;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e0 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d0 f6147e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Callable f6148j;

    public e0(d0 d0Var, Callable callable) {
        this.f6147e = d0Var;
        this.f6148j = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f6147e.o(this.f6148j.call());
        } catch (Exception e10) {
            this.f6147e.n(e10);
        } catch (Throwable th) {
            this.f6147e.n(new RuntimeException(th));
        }
    }
}
