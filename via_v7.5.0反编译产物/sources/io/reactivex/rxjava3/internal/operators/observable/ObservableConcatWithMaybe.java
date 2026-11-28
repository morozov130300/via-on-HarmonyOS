package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableConcatWithMaybe extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r6.i f6489e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class ConcatWithObserver<T> extends AtomicReference<s6.b> implements r6.o, r6.h, s6.b {
        private static final long serialVersionUID = -1953724749712440952L;
        final r6.o downstream;
        boolean inMaybe;
        r6.i other;

        public ConcatWithObserver(r6.o oVar, r6.i iVar) {
            this.downstream = oVar;
            this.other = iVar;
        }

        @Override // s6.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // s6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // r6.o
        public void onComplete() {
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            r6.i iVar = this.other;
            this.other = null;
            iVar.c(this);
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // r6.o
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            if (!DisposableHelper.setOnce(this, bVar) || this.inMaybe) {
                return;
            }
            this.downstream.onSubscribe(this);
        }

        @Override // r6.h
        public void onSuccess(T t10) {
            this.downstream.onNext(t10);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithMaybe(r6.j jVar, r6.i iVar) {
        super(jVar);
        this.f6489e = iVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new ConcatWithObserver(oVar, this.f6489e));
    }
}
