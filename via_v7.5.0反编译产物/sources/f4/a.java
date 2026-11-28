package f4;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements f4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f4453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f4.c f4454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f4455c;

    /* JADX INFO: renamed from: f4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class RunnableC0067a implements Runnable {
        public RunnableC0067a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f4454b.b();
            } catch (Exception e10) {
                a.this.h(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f4454b.c();
            } catch (Exception e10) {
                a.this.h(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f4458c;

        public c(String str) {
            this.f4458c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f4454b.a(this.f4458c);
            } catch (Exception e10) {
                a.this.h(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f4460c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ m f4461e;

        public d(String str, m mVar) {
            this.f4460c = str;
            this.f4461e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f4454b.d(this.f4460c, this.f4461e);
            } catch (Exception e10) {
                a.this.h(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f4463c;

        public e(Throwable th) {
            this.f4463c = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i(this.f4463c);
        }
    }

    public a(Executor executor, f4.c cVar, l lVar) {
        this.f4453a = executor;
        this.f4454b = cVar;
        this.f4455c = lVar;
    }

    @Override // f4.c
    public void a(String str) {
        this.f4453a.execute(new c(str));
    }

    @Override // f4.c
    public void b() {
        this.f4453a.execute(new RunnableC0067a());
    }

    @Override // f4.c
    public void c() {
        this.f4453a.execute(new b());
    }

    @Override // f4.c
    public void d(String str, m mVar) {
        this.f4453a.execute(new d(str, mVar));
    }

    public final void h(Throwable th) {
        this.f4455c.d("Caught unexpected error from EventHandler: " + th.toString());
        this.f4455c.b("Stack trace: {}", new k(th));
        i(th);
    }

    public final void i(Throwable th) {
        try {
            this.f4454b.onError(th);
        } catch (Throwable th2) {
            this.f4455c.d("Caught unexpected error from EventHandler.onError(): " + th2.toString());
            this.f4455c.b("Stack trace: {}", new k(th));
        }
    }

    @Override // f4.c
    public void onError(Throwable th) {
        this.f4453a.execute(new e(th));
    }
}
