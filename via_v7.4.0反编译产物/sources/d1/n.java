package d1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n implements Executor {

    /* renamed from: e, reason: collision with root package name */
    public final Executor f4513e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final Runnable f4514e;

        public a(Runnable runnable) {
            this.f4514e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4514e.run();
            } catch (Exception e10) {
                h1.a.d("Executor", "Background execution failure.", e10);
            }
        }
    }

    public n(Executor executor) {
        this.f4513e = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4513e.execute(new a(runnable));
    }
}
