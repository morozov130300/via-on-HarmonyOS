package t2;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12454c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f12455e;

        /* JADX INFO: renamed from: t2.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0124a extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Runnable f12456c;

            public C0124a(Runnable runnable) {
                this.f12456c = runnable;
            }

            @Override // t2.c
            public void a() {
                this.f12456c.run();
            }
        }

        public a(String str, AtomicLong atomicLong) {
            this.f12454c = str;
            this.f12455e = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(new C0124a(runnable));
            threadNewThread.setName(this.f12454c + this.f12455e.getAndIncrement());
            return threadNewThread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12458c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ExecutorService f12459e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f12460m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ TimeUnit f12461n;

        public b(String str, ExecutorService executorService, long j10, TimeUnit timeUnit) {
            this.f12458c = str;
            this.f12459e = executorService;
            this.f12460m = j10;
            this.f12461n = timeUnit;
        }

        @Override // t2.c
        public void a() {
            try {
                q2.f.f().b("Executing shutdown hook for " + this.f12458c);
                this.f12459e.shutdown();
                if (this.f12459e.awaitTermination(this.f12460m, this.f12461n)) {
                    return;
                }
                q2.f.f().b(this.f12458c + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f12459e.shutdownNow();
            } catch (InterruptedException unused) {
                q2.f.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f12458c));
                this.f12459e.shutdownNow();
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
