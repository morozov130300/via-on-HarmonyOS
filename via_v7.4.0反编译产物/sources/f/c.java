package f;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f4996c;

    /* renamed from: d, reason: collision with root package name */
    public static final Executor f4997d = new Executor() { // from class: f.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().c(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public static final Executor f4998e = new Executor() { // from class: f.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().a(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public e f4999a;

    /* renamed from: b, reason: collision with root package name */
    public final e f5000b;

    public c() {
        d dVar = new d();
        this.f5000b = dVar;
        this.f4999a = dVar;
    }

    public static c f() {
        if (f4996c != null) {
            return f4996c;
        }
        synchronized (c.class) {
            try {
                if (f4996c == null) {
                    f4996c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4996c;
    }

    @Override // f.e
    public void a(Runnable runnable) {
        this.f4999a.a(runnable);
    }

    @Override // f.e
    public boolean b() {
        return this.f4999a.b();
    }

    @Override // f.e
    public void c(Runnable runnable) {
        this.f4999a.c(runnable);
    }
}
