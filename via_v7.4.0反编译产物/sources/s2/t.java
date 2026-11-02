package s2;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements ThreadFactory {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f11786e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f11787j;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: s2.t$a$a, reason: collision with other inner class name */
        public class C0121a extends c {

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Runnable f11788e;

            public C0121a(Runnable runnable) {
                this.f11788e = runnable;
            }

            @Override // s2.c
            public void a() {
                this.f11788e.run();
            }
        }

        public a(String str, AtomicLong atomicLong) {
            this.f11786e = str;
            this.f11787j = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(new C0121a(runnable));
            threadNewThread.setName(this.f11786e + this.f11787j.getAndIncrement());
            return threadNewThread;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends c {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f11790e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ExecutorService f11791j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ long f11792k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ TimeUnit f11793l;

        public b(String str, ExecutorService executorService, long j10, TimeUnit timeUnit) {
            this.f11790e = str;
            this.f11791j = executorService;
            this.f11792k = j10;
            this.f11793l = timeUnit;
        }

        @Override // s2.c
        public void a() {
            try {
                p2.f.f().b("Executing shutdown hook for " + this.f11790e);
                this.f11791j.shutdown();
                if (this.f11791j.awaitTermination(this.f11792k, this.f11793l)) {
                    return;
                }
                p2.f.f().b(this.f11790e + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f11791j.shutdownNow();
            } catch (InterruptedException unused) {
                p2.f.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f11790e));
                this.f11791j.shutdownNow();
            }
        }
    }

    public static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2L, TimeUnit.SECONDS);
    }

    public static void b(String str, ExecutorService executorService, long j10, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new b(str, executorService, j10, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }

    public static ExecutorService c(String str) {
        ExecutorService executorServiceE = e(d(str), new ThreadPoolExecutor.DiscardPolicy());
        a(str, executorServiceE);
        return executorServiceE;
    }

    public static ThreadFactory d(String str) {
        return new a(str, new AtomicLong(1L));
    }

    public static ExecutorService e(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler));
    }
}
