package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import r6.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class MaybeFlatten extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.g f6450e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<s6.b> implements r6.h, s6.b {
        private static final long serialVersionUID = 4375739915521278546L;
        final r6.h downstream;
        final u6.g mapper;
        s6.b upstream;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public final class a implements r6.h {
            public a() {
            }

            @Override // r6.h
            public void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }

            @Override // r6.h
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.downstream.onError(th);
            }

            @Override // r6.h
            public void onSubscribe(s6.b bVar) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, bVar);
            }

            @Override // r6.h
            public void onSuccess(Object obj) {
                FlatMapMaybeObserver.this.downstream.onSuccess(obj);
            }
        }

        public FlatMapMaybeObserver(r6.h hVar, u6.g gVar) {
            this.downstream = hVar;
            this.mapper = gVar;
        }

        @Override // s6.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // r6.h
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // r6.h
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // r6.h
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // r6.h
        public void onSuccess(T t10) {
            try {
                Object objApply = this.mapper.apply(t10);
                Objects.requireNonNull(objApply, "The mapper returned a null MaybeSource");
                i iVar = (i) objApply;
                if (isDisposed()) {
                    return;
                }
                iVar.c(new a());
            } catch (Throwable th) {
                t6.a.b(th);
                this.downstream.onError(th);
            }
        }
    }

    public MaybeFlatten(i iVar, u6.g gVar) {
        super(iVar);
        this.f6450e = gVar;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        this.f6456c.c(new FlatMapMaybeObserver(hVar, this.f6450e));
    }
}
