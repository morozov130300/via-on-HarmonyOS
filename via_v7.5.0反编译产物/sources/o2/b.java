package o2;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ThreadFactory f10866o = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f10867c = new AtomicLong();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10868e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f10869m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f10870n;

    public b(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        this.f10868e = str;
        this.f10869m = i10;
        this.f10870n = threadPolicy;
    }

    public static /* synthetic */ void a(b bVar, Runnable runnable) {
        Process.setThreadPriority(bVar.f10869m);
        StrictMode.ThreadPolicy threadPolicy = bVar.f10870n;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f10866o.newThread(new Runnable() { // from class: o2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.a(this.f10864c, runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f10868e, Long.valueOf(this.f10867c.getAndIncrement())));
        return threadNewThread;
    }
}
