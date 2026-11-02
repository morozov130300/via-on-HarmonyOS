package s2;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final a f11768a;

    /* renamed from: b, reason: collision with root package name */
    public final z2.g f11769b;

    /* renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f11770c;

    /* renamed from: d, reason: collision with root package name */
    public final p2.a f11771d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f11772e = new AtomicBoolean(false);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(z2.g gVar, Thread thread, Throwable th);
    }

    public q(a aVar, z2.g gVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, p2.a aVar2) {
        this.f11768a = aVar;
        this.f11769b = gVar;
        this.f11770c = uncaughtExceptionHandler;
        this.f11771d = aVar2;
    }

    public boolean a() {
        return this.f11772e.get();
    }

    public final boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            p2.f.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            p2.f.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.f11771d.b()) {
            return true;
        }
        p2.f.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f11772e.set(true);
        try {
            try {
                if (b(thread, th)) {
                    this.f11768a.a(this.f11769b, thread, th);
                } else {
                    p2.f.f().b("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e10) {
                p2.f.f().e("An error occurred in the uncaught exception handler", e10);
            }
            p2.f.f().b("Completed exception processing. Invoking default exception handler.");
            this.f11770c.uncaughtException(thread, th);
            this.f11772e.set(false);
        } catch (Throwable th2) {
            p2.f.f().b("Completed exception processing. Invoking default exception handler.");
            this.f11770c.uncaughtException(thread, th);
            this.f11772e.set(false);
            throw th2;
        }
    }
}
