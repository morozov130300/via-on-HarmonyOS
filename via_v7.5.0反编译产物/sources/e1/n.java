package e1;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f4145c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f4146c;

        public a(Runnable runnable) {
            this.f4146c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4146c.run();
            } catch (Exception e10) {
                i1.a.d("Executor", "Background execution failure.", e10);
            }
        }
    }

    public n(Executor executor) {
        this.f4145c = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4145c.execute(new a(runnable));
    }
}
