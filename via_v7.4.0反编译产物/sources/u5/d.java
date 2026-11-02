package u5;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    public static d f12859e;

    /* renamed from: a, reason: collision with root package name */
    public Handler f12860a;

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f12861b;

    /* renamed from: c, reason: collision with root package name */
    public int f12862c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f12863d = new Object();

    public static d d() {
        if (f12859e == null) {
            f12859e = new d();
        }
        return f12859e;
    }

    public final void a() {
        synchronized (this.f12863d) {
            try {
                if (this.f12860a == null) {
                    if (this.f12862c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f12861b = handlerThread;
                    handlerThread.start();
                    this.f12860a = new Handler(this.f12861b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f12863d) {
            try {
                int i10 = this.f12862c - 1;
                this.f12862c = i10;
                if (i10 == 0) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Runnable runnable) {
        synchronized (this.f12863d) {
            a();
            this.f12860a.post(runnable);
        }
    }

    public void e(Runnable runnable) {
        synchronized (this.f12863d) {
            this.f12862c++;
            c(runnable);
        }
    }

    public final void f() {
        synchronized (this.f12863d) {
            this.f12861b.quit();
            this.f12861b = null;
            this.f12860a = null;
        }
    }
}
