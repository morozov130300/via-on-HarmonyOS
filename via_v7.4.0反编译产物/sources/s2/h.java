package s2;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f11678a;

    /* renamed from: b, reason: collision with root package name */
    public g2.f f11679b = g2.i.e(null);

    /* renamed from: c, reason: collision with root package name */
    public final Object f11680c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal f11681d = new ThreadLocal();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f11681d.set(Boolean.TRUE);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements g2.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f11683a;

        public b(Callable callable) {
            this.f11683a = callable;
        }

        @Override // g2.a
        public Object a(g2.f fVar) {
            return this.f11683a.call();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements g2.a {
        public c() {
        }

        @Override // g2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(g2.f fVar) {
            return null;
        }
    }

    public h(Executor executor) {
        this.f11678a = executor;
        executor.execute(new a());
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor c() {
        return this.f11678a;
    }

    public final g2.f d(g2.f fVar) {
        return fVar.e(this.f11678a, new c());
    }

    public final boolean e() {
        return Boolean.TRUE.equals(this.f11681d.get());
    }

    public final g2.a f(Callable callable) {
        return new b(callable);
    }

    public g2.f g(Callable callable) {
        g2.f fVarE;
        synchronized (this.f11680c) {
            fVarE = this.f11679b.e(this.f11678a, f(callable));
            this.f11679b = d(fVarE);
        }
        return fVarE;
    }

    public g2.f h(Callable callable) {
        g2.f fVarF;
        synchronized (this.f11680c) {
            fVarF = this.f11679b.f(this.f11678a, f(callable));
            this.f11679b = d(fVarF);
        }
        return fVarF;
    }
}
