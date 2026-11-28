package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import java.util.Objects;
import r6.j;
import r6.o;
import r6.s;
import r6.t;
import u6.g;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class SingleFlatMapIterableObservable extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f6590c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f6591e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements s {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final o downstream;
        volatile Iterator<? extends R> it;
        final g mapper;
        boolean outputFused;
        s6.b upstream;

        public FlatMapIterableObserver(o oVar, g gVar) {
            this.downstream = oVar;
            this.mapper = gVar;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public void clear() {
            this.it = null;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, s6.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, s6.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // r6.s
        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        @Override // r6.s
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // r6.s
        public void onSuccess(T t10) {
            o oVar = this.downstream;
            try {
                Iterator<? extends R> it = ((Iterable) this.mapper.apply(t10)).iterator();
                if (!it.hasNext()) {
                    oVar.onComplete();
                    return;
                }
                if (this.outputFused) {
                    this.it = it;
                    oVar.onNext(null);
                    oVar.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        oVar.onNext(it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                oVar.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            t6.a.b(th);
                            oVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        t6.a.b(th2);
                        oVar.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                t6.a.b(th3);
                this.downstream.onError(th3);
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.e
        public R poll() {
            Iterator<? extends R> it = this.it;
            if (it == null) {
                return null;
            }
            R next = it.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return next;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, x6.b
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public SingleFlatMapIterableObservable(t tVar, g gVar) {
        this.f6590c = tVar;
        this.f6591e = gVar;
    }

    @Override // r6.j
    public void F(o oVar) {
        this.f6590c.c(new FlatMapIterableObserver(oVar, this.f6591e));
    }
}
