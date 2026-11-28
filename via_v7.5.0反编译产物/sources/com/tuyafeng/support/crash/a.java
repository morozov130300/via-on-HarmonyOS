package com.tuyafeng.support.crash;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f3565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f3566b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f3567c = false;

    /* JADX INFO: renamed from: com.tuyafeng.support.crash.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class RunnableC0049a implements Runnable {
        /* JADX WARN: Bottom block not found for handler: all -> 0x0004 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                android.os.Looper.loop()     // Catch: java.lang.Throwable -> L4
                goto L0
            L4:
                r0 = move-exception
                boolean r1 = r0 instanceof com.tuyafeng.support.crash.UnknowException
                if (r1 == 0) goto La
                return
            La:
                com.tuyafeng.support.crash.a$c r1 = com.tuyafeng.support.crash.a.a()
                if (r1 == 0) goto L0
                com.tuyafeng.support.crash.a$c r1 = com.tuyafeng.support.crash.a.a()
                android.os.Looper r2 = android.os.Looper.getMainLooper()
                java.lang.Thread r2 = r2.getThread()
                r1.a(r2, r0)
                goto L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuyafeng.support.crash.a.RunnableC0049a.run():void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (a.f3565a != null) {
                a.f3565a.a(thread, th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        void a(Thread thread, Throwable th);
    }

    public static synchronized void b(c cVar) {
        if (f3567c) {
            return;
        }
        f3567c = true;
        f3565a = cVar;
        new Handler(Looper.getMainLooper()).post(new RunnableC0049a());
        f3566b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new b());
    }
}
