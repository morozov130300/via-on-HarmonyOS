package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableCreate extends r6.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r6.m f6490c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class CreateEmitter<T> extends AtomicReference<s6.b> implements r6.l, s6.b {
        private static final long serialVersionUID = -3434801548987643227L;
        final r6.o observer;

        public CreateEmitter(r6.o oVar) {
            this.observer = oVar;
        }

        @Override // s6.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // r6.l, s6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // r6.d
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // r6.d
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            z6.a.o(th);
        }

        @Override // r6.d
        public void onNext(T t10) {
            if (t10 == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t10);
            }
        }

        @Override // r6.l
        public r6.l serialize() {
            return new SerializedEmitter(this);
        }

        @Override // r6.l
        public void setCancellable(u6.e eVar) {
            setDisposable(new CancellableDisposable(eVar));
        }

        @Override // r6.l
        public void setDisposable(s6.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }

        public boolean tryOnError(Throwable th) {
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th);
                return true;
            } finally {
                dispose();
            }
        }
    }

    public ObservableCreate(r6.m mVar) {
        this.f6490c = mVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        CreateEmitter createEmitter = new CreateEmitter(oVar);
        oVar.onSubscribe(createEmitter);
        try {
            this.f6490c.a(createEmitter);
        } catch (Throwable th) {
            t6.a.b(th);
            createEmitter.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class SerializedEmitter<T> extends AtomicInteger implements r6.l {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final r6.l emitter;
        final AtomicThrowable errors = new AtomicThrowable();
        final io.reactivex.rxjava3.internal.queue.a queue = new io.reactivex.rxjava3.internal.queue.a(16);

        public SerializedEmitter(r6.l lVar) {
            this.emitter = lVar;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            r6.l lVar = this.emitter;
            io.reactivex.rxjava3.internal.queue.a aVar = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int iAddAndGet = 1;
            while (!lVar.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    aVar.clear();
                    atomicThrowable.tryTerminateConsumer(lVar);
                    return;
                }
                boolean z10 = this.done;
                Object objPoll = aVar.poll();
                boolean z11 = objPoll == null;
                if (z10 && z11) {
                    lVar.onComplete();
                    return;
                } else if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    lVar.onNext(objPoll);
                }
            }
            aVar.clear();
        }

        @Override // r6.l, s6.b
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // r6.d
        public void onComplete() {
            if (this.done || this.emitter.isDisposed()) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // r6.d
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            z6.a.o(th);
        }

        @Override // r6.d
        public void onNext(T t10) {
            if (this.done || this.emitter.isDisposed()) {
                return;
            }
            if (t10 == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t10);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.rxjava3.internal.queue.a aVar = this.queue;
                synchronized (aVar) {
                    aVar.offer(t10);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // r6.l
        public void setCancellable(u6.e eVar) {
            this.emitter.setCancellable(eVar);
        }

        @Override // r6.l
        public void setDisposable(s6.b bVar) {
            this.emitter.setDisposable(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        public boolean tryOnError(Throwable th) {
            if (!this.done && !this.emitter.isDisposed()) {
                if (th == null) {
                    th = ExceptionHelper.b("onError called with a null Throwable.");
                }
                if (this.errors.tryAddThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }

        @Override // r6.l
        public r6.l serialize() {
            return this;
        }
    }
}
