package o5;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d f10958e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f10959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f10960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10961c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f10962d = new Object();

    public static d d() {
        if (f10958e == null) {
            f10958e = new d();
        }
        return f10958e;
    }

    public final void a() {
        synchronized (this.f10962d) {
            try {
                if (this.f10959a == null) {
                    if (this.f10961c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f10960b = handlerThread;
                    handlerThread.start();
                    this.f10959a = new Handler(this.f10960b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f10962d) {
            try {
                int i10 = this.f10961c - 1;
                this.f10961c = i10;
                if (i10 == 0) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Runnable runnable) {
        synchronized (this.f10962d) {
            a();
            this.f10959a.post(runnable);
        }
    }

    public void e(Runnable runnable) {
        synchronized (this.f10962d) {
            this.f10961c++;
            c(runnable);
        }
    }

    public final void f() {
        synchronized (this.f10962d) {
            this.f10960b.quit();
            this.f10960b = null;
            this.f10959a = null;
        }
    }
}
