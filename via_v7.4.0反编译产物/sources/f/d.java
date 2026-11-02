package f;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5001a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f5002b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c, reason: collision with root package name */
    public volatile Handler f5003c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements ThreadFactory {

        /* renamed from: e, reason: collision with root package name */
        public final AtomicInteger f5004e = new AtomicInteger(0);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f5004e.getAndIncrement());
            return thread;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // f.e
    public void a(Runnable runnable) {
        this.f5002b.execute(runnable);
    }

    @Override // f.e
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // f.e
    public void c(Runnable runnable) {
        if (this.f5003c == null) {
            synchronized (this.f5001a) {
                try {
                    if (this.f5003c == null) {
                        this.f5003c = d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f5003c.post(runnable);
    }
}
