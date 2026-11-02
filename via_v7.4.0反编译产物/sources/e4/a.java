package e4;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements e4.c {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f4737a;

    /* renamed from: b, reason: collision with root package name */
    public final e4.c f4738b;

    /* renamed from: c, reason: collision with root package name */
    public final l f4739c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: e4.a$a, reason: collision with other inner class name */
    public class RunnableC0066a implements Runnable {
        public RunnableC0066a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f4738b.b();
            } catch (Exception e10) {
                a.this.h(e10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f4738b.d();
            } catch (Exception e10) {
                a.this.h(e10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f4742e;

        public c(String str) {
            this.f4742e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f4738b.a(this.f4742e);
            } catch (Exception e10) {
                a.this.h(e10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f4744e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ m f4745j;

        public d(String str, m mVar) {
            this.f4744e = str;
            this.f4745j = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f4738b.c(this.f4744e, this.f4745j);
            } catch (Exception e10) {
                a.this.h(e10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Throwable f4747e;

        public e(Throwable th) {
            this.f4747e = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i(this.f4747e);
        }
    }

    public a(Executor executor, e4.c cVar, l lVar) {
        this.f4737a = executor;
        this.f4738b = cVar;
        this.f4739c = lVar;
    }

    @Override // e4.c
    public void a(String str) {
        this.f4737a.execute(new c(str));
    }

    @Override // e4.c
    public void b() {
        this.f4737a.execute(new RunnableC0066a());
    }

    @Override // e4.c
    public void c(String str, m mVar) {
        this.f4737a.execute(new d(str, mVar));
    }

    @Override // e4.c
    public void d() {
        this.f4737a.execute(new b());
    }

    public final void h(Throwable th) {
        this.f4739c.d("Caught unexpected error from EventHandler: " + th.toString());
        this.f4739c.b("Stack trace: {}", new k(th));
        i(th);
    }

    public final void i(Throwable th) {
        try {
            this.f4738b.onError(th);
        } catch (Throwable th2) {
            this.f4739c.d("Caught unexpected error from EventHandler.onError(): " + th2.toString());
            this.f4739c.b("Stack trace: {}", new k(th));
        }
    }

    @Override // e4.c
    public void onError(Throwable th) {
        this.f4737a.execute(new e(th));
    }
}
