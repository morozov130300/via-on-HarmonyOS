package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ObservableScalarXMap {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class ScalarDisposable<T> extends AtomicInteger implements d7.a, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final x6.m observer;
        final T value;

        public ScalarDisposable(x6.m mVar, T t10) {
            this.observer = mVar;
            this.value = t10;
        }

        @Override // d7.e
        public void clear() {
            lazySet(3);
        }

        @Override // y6.b
        public void dispose() {
            set(3);
        }

        @Override // y6.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // d7.e
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // d7.e
        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public boolean offer(T t10, T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // d7.e
        public T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // d7.b
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
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends x6.j {

        /* renamed from: e, reason: collision with root package name */
        public final Object f7277e;

        /* renamed from: j, reason: collision with root package name */
        public final a7.f f7278j;

        public a(Object obj, a7.f fVar) {
            this.f7277e = obj;
            this.f7278j = fVar;
        }

        @Override // x6.j
        public void C(x6.m mVar) {
            try {
                Object objApply = this.f7278j.apply(this.f7277e);
                Objects.requireNonNull(objApply, "The mapper returned a null ObservableSource");
                x6.l lVar = (x6.l) objApply;
                if (!(lVar instanceof a7.i)) {
                    lVar.b(mVar);
                    return;
                }
                try {
                    Object obj = ((a7.i) lVar).get();
                    if (obj == null) {
                        EmptyDisposable.complete(mVar);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(mVar, obj);
                    mVar.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th) {
                    z6.a.b(th);
                    EmptyDisposable.error(th, mVar);
                }
            } catch (Throwable th2) {
                z6.a.b(th2);
                EmptyDisposable.error(th2, mVar);
            }
        }
    }

    public static x6.j a(Object obj, a7.f fVar) {
        return f7.a.l(new a(obj, fVar));
    }

    public static boolean b(x6.l lVar, x6.m mVar, a7.f fVar) {
        if (!(lVar instanceof a7.i)) {
            return false;
        }
        try {
            Object obj = ((a7.i) lVar).get();
            if (obj == null) {
                EmptyDisposable.complete(mVar);
                return true;
            }
            try {
                Object objApply = fVar.apply(obj);
                Objects.requireNonNull(objApply, "The mapper returned a null ObservableSource");
                x6.l lVar2 = (x6.l) objApply;
                if (lVar2 instanceof a7.i) {
                    try {
                        Object obj2 = ((a7.i) lVar2).get();
                        if (obj2 == null) {
                            EmptyDisposable.complete(mVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(mVar, obj2);
                        mVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        z6.a.b(th);
                        EmptyDisposable.error(th, mVar);
                        return true;
                    }
                } else {
                    lVar2.b(mVar);
                }
                return true;
            } catch (Throwable th2) {
                z6.a.b(th2);
                EmptyDisposable.error(th2, mVar);
                return true;
            }
        } catch (Throwable th3) {
            z6.a.b(th3);
            EmptyDisposable.error(th3, mVar);
            return true;
        }
    }
}
