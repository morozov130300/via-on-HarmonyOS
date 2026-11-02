package io.reactivex.rxjava3.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f7441a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f7442b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f7443c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public static final Map f7444d = new ConcurrentHashMap();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(f.f7444d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    f.f7444d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements a7.f {
        @Override // a7.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean zB = b(true, "rx3.purge-enabled", true, true, bVar);
        f7441a = zB;
        f7442b = c(zB, "rx3.purge-period-seconds", 1, 1, bVar);
        d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(f7441a, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static boolean b(boolean z10, String str, boolean z11, boolean z12, a7.f fVar) {
        if (!z10) {
            return z12;
        }
        try {
            String str2 = (String) fVar.apply(str);
            return str2 == null ? z11 : "true".equals(str2);
        } catch (Throwable th) {
            z6.a.b(th);
            return z11;
        }
    }

    public static int c(boolean z10, String str, int i10, int i11, a7.f fVar) {
        if (!z10) {
            return i11;
        }
        try {
            String str2 = (String) fVar.apply(str);
            return str2 == null ? i10 : Integer.parseInt(str2);
        } catch (Throwable th) {
            z6.a.b(th);
            return i10;
        }
    }

    public static void d() {
        f(f7441a);
    }

    public static void e(boolean z10, ScheduledExecutorService scheduledExecutorService) {
        if (z10 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f7444d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static void f(boolean z10) {
        if (!z10) {
            return;
        }
        while (true) {
            AtomicReference atomicReference = f7443c;
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (autodispose2.c.a(atomicReference, scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                int i10 = f7442b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, i10, i10, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
