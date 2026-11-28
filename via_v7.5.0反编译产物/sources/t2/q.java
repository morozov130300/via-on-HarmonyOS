package t2;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f12436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a3.g f12437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f12438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q2.a f12439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f12440e = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(a3.g gVar, Thread thread, Throwable th);
    }

    public q(a aVar, a3.g gVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, q2.a aVar2) {
        this.f12436a = aVar;
        this.f12437b = gVar;
        this.f12438c = uncaughtExceptionHandler;
        this.f12439d = aVar2;
    }

    public boolean a() {
        return this.f12440e.get();
    }

    public final boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            q2.f.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            q2.f.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.f12439d.b()) {
            return true;
        }
        q2.f.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f12440e.set(true);
        try {
            try {
                if (b(thread, th)) {
                    this.f12436a.a(this.f12437b, thread, th);
                } else {
                    q2.f.f().b("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e10) {
                q2.f.f().e("An error occurred in the uncaught exception handler", e10);
            }
        } finally {
            q2.f.f().b("Completed exception processing. Invoking default exception handler.");
            this.f12438c.uncaughtException(thread, th);
            this.f12440e.set(false);
        }
    }
}
