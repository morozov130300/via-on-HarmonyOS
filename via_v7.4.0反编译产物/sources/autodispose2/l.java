package autodispose2;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l {
    public static void a(x6.m mVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thTerminate = atomicThrowable.terminate();
            if (thTerminate != null) {
                mVar.onError(thTerminate);
            } else {
                mVar.onComplete();
            }
        }
    }

    public static void b(x6.m mVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            f7.a.o(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            mVar.onError(atomicThrowable.terminate());
        }
    }

    public static boolean c(x6.m mVar, Object obj, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            mVar.onNext(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thTerminate = atomicThrowable.terminate();
                if (thTerminate != null) {
                    mVar.onError(thTerminate);
                } else {
                    mVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }
}
