package autodispose2;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static void a(r6.o oVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thTerminate = atomicThrowable.terminate();
            if (thTerminate != null) {
                oVar.onError(thTerminate);
            } else {
                oVar.onComplete();
            }
        }
    }

    public static void b(r6.o oVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            z6.a.o(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            oVar.onError(atomicThrowable.terminate());
        }
    }

    public static boolean c(r6.o oVar, Object obj, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            oVar.onNext(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thTerminate = atomicThrowable.terminate();
                if (thTerminate != null) {
                    oVar.onError(thTerminate);
                } else {
                    oVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }
}
