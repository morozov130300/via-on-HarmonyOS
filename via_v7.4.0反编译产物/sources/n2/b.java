package n2;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements ThreadFactory {

    /* renamed from: m, reason: collision with root package name */
    public static final ThreadFactory f10142m = Executors.defaultThreadFactory();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicLong f10143e = new AtomicLong();

    /* renamed from: j, reason: collision with root package name */
    public final String f10144j;

    /* renamed from: k, reason: collision with root package name */
    public final int f10145k;

    /* renamed from: l, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f10146l;

    public b(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        this.f10144j = str;
        this.f10145k = i10;
        this.f10146l = threadPolicy;
    }

    public static /* synthetic */ void a(b bVar, Runnable runnable) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(bVar.f10145k);
        StrictMode.ThreadPolicy threadPolicy = bVar.f10146l;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f10142m.newThread(new Runnable() { // from class: n2.a
            @Override // java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                b.a(this.f10140e, runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f10144j, Long.valueOf(this.f10143e.getAndIncrement())));
        return threadNewThread;
    }
}
