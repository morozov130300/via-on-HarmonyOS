package io.reactivex.rxjava3.internal.operators.single;

import a7.f;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import java.util.Objects;
import x6.j;
import x6.m;
import x6.q;
import x6.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class SingleFlatMapIterableObservable extends j {

    /* renamed from: e, reason: collision with root package name */
    public final r f7357e;

    /* renamed from: j, reason: collision with root package name */
    public final f f7358j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements q {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final m downstream;
        volatile Iterator<? extends R> it;
        final f mapper;
        boolean outputFused;
        y6.b upstream;

        public FlatMapIterableObserver(m mVar, f fVar) {
            this.downstream = mVar;
            this.mapper = fVar;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
        public void clear() {
            this.it = null;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, y6.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, y6.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // x6.q
        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        @Override // x6.q
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // x6.q
        public void onSuccess(T t10) {
            m mVar = this.downstream;
            try {
                Iterator<? extends R> it = ((Iterable) this.mapper.apply(t10)).iterator();
                if (!it.hasNext()) {
                    mVar.onComplete();
                    return;
                }
                if (this.outputFused) {
                    this.it = it;
                    mVar.onNext(null);
                    mVar.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        mVar.onNext(it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                mVar.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            z6.a.b(th);
                            mVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        z6.a.b(th2);
                        mVar.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                z6.a.b(th3);
                this.downstream.onError(th3);
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.e
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

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, d7.b
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public SingleFlatMapIterableObservable(r rVar, f fVar) {
        this.f7357e = rVar;
        this.f7358j = fVar;
    }

    @Override // x6.j
    public void C(m mVar) {
        this.f7357e.c(new FlatMapIterableObserver(mVar, this.f7358j));
    }
}
