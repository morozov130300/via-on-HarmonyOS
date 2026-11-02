package e5;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends ThreadPoolExecutor implements f, AutoCloseable {
    public d() {
        super(0, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() throws InterruptedException {
        b0.e.a(this);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, e5.f
    public Future submit(Callable callable) {
        return super.submit(callable);
    }
}
