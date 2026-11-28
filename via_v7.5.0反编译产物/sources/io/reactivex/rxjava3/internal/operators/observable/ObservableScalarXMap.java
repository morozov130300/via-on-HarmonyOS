package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class ObservableScalarXMap {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class ScalarDisposable<T> extends AtomicInteger implements x6.a, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final r6.o observer;
        final T value;

        public ScalarDisposable(r6.o oVar, T t10) {
            this.observer = oVar;
            this.value = t10;
        }

        @Override // x6.e
        public void clear() {
            lazySet(3);
        }

        @Override // s6.b
        public void dispose() {
            set(3);
        }

        @Override // s6.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // x6.e
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // x6.e
        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // x6.e
        public T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // x6.b
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        public boolean offer(T t10, T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends r6.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f6510c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final u6.g f6511e;

        public a(Object obj, u6.g gVar) {
            this.f6510c = obj;
            this.f6511e = gVar;
        }

        @Override // r6.j
        public void F(r6.o oVar) {
            try {
                Object objApply = this.f6511e.apply(this.f6510c);
                Objects.requireNonNull(objApply, "The mapper returned a null ObservableSource");
                r6.n nVar = (r6.n) objApply;
                if (!(nVar instanceof u6.j)) {
                    nVar.c(oVar);
                    return;
                }
                try {
                    Object obj = ((u6.j) nVar).get();
                    if (obj == null) {
                        EmptyDisposable.complete(oVar);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(oVar, obj);
                    oVar.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th) {
                    t6.a.b(th);
                    EmptyDisposable.error(th, oVar);
                }
            } catch (Throwable th2) {
                t6.a.b(th2);
                EmptyDisposable.error(th2, oVar);
            }
        }
    }

    public static r6.j a(Object obj, u6.g gVar) {
        return z6.a.l(new a(obj, gVar));
    }

    public static boolean b(r6.n nVar, r6.o oVar, u6.g gVar) {
        if (!(nVar instanceof u6.j)) {
            return false;
        }
        try {
            Object obj = ((u6.j) nVar).get();
            if (obj == null) {
                EmptyDisposable.complete(oVar);
                return true;
            }
            try {
                Object objApply = gVar.apply(obj);
                Objects.requireNonNull(objApply, "The mapper returned a null ObservableSource");
                r6.n nVar2 = (r6.n) objApply;
                if (nVar2 instanceof u6.j) {
                    try {
                        Object obj2 = ((u6.j) nVar2).get();
                        if (obj2 == null) {
                            EmptyDisposable.complete(oVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(oVar, obj2);
                        oVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        t6.a.b(th);
                        EmptyDisposable.error(th, oVar);
                        return true;
                    }
                } else {
                    nVar2.c(oVar);
                }
                return true;
            } catch (Throwable th2) {
                t6.a.b(th2);
                EmptyDisposable.error(th2, oVar);
                return true;
            }
        } catch (Throwable th3) {
            t6.a.b(th3);
            EmptyDisposable.error(th3, oVar);
            return true;
        }
    }
}
