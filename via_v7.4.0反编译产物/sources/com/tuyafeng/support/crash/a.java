package com.tuyafeng.support.crash;

import android.os.Handler;
import android.os.Looper;
import java.lang.Thread;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static c f4272a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f4273b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f4274c = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.tuyafeng.support.crash.a$a, reason: collision with other inner class name */
    public class RunnableC0055a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    if (th instanceof UnknowException) {
                        return;
                    }
                    if (a.f4272a != null) {
                        a.f4272a.a(Looper.getMainLooper().getThread(), th);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (a.f4272a != null) {
                a.f4272a.a(thread, th);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void a(Thread thread, Throwable th);
    }

    public static synchronized void b(c cVar) {
        if (f4274c) {
            return;
        }
        f4274c = true;
        f4272a = cVar;
        new Handler(Looper.getMainLooper()).post(new RunnableC0055a());
        f4273b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new b());
    }
}
