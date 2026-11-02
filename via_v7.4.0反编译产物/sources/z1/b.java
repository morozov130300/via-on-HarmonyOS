package z1;

import android.os.Looper;
import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ClassLoader f14555a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Thread f14556b;

    public static synchronized ClassLoader a() {
        try {
            if (f14555a == null) {
                f14555a = b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f14555a;
    }

    public static synchronized ClassLoader b() {
        ClassLoader contextClassLoader = null;
        if (f14556b == null) {
            f14556b = c();
            if (f14556b == null) {
                return null;
            }
        }
        synchronized (f14556b) {
            try {
                contextClassLoader = f14556b.getContextClassLoader();
            } catch (SecurityException e10) {
                Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e10.getMessage());
            }
        }
        return contextClassLoader;
    }

    public static synchronized Thread c() {
        SecurityException e10;
        Thread aVar;
        Thread thread;
        ThreadGroup threadGroup;
        ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
        if (threadGroup2 == null) {
            return null;
        }
        synchronized (Void.class) {
            try {
                try {
                    int iActiveGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= iActiveGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i11];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i11++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int iActiveCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[iActiveCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i10 >= iActiveCount) {
                            thread = null;
                            break;
                        }
                        thread = threadArr[i10];
                        if ("GmsDynamite".equals(thread.getName())) {
                            break;
                        }
                        i10++;
                    }
                } finally {
                }
            } catch (SecurityException e11) {
                e10 = e11;
                aVar = null;
            }
            if (thread == null) {
                try {
                    aVar = new a(threadGroup, "GmsDynamite");
                    try {
                        aVar.setContextClassLoader(null);
                        aVar.start();
                    } catch (SecurityException e12) {
                        e10 = e12;
                        Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e10.getMessage());
                        thread = aVar;
                        return thread;
                    }
                } catch (SecurityException e13) {
                    e10 = e13;
                    aVar = thread;
                }
                thread = aVar;
            }
        }
        return thread;
    }
}
