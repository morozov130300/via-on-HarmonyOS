package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import x6.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class MaybeFlatten extends a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.f f7219j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<y6.b> implements x6.h, y6.b {
        private static final long serialVersionUID = 4375739915521278546L;
        final x6.h downstream;
        final a7.f mapper;
        y6.b upstream;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public final class a implements x6.h {
            public a() {
            }

            @Override // x6.h
            public void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }

            @Override // x6.h
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.downstream.onError(th);
            }

            @Override // x6.h
            public void onSubscribe(y6.b bVar) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, bVar);
            }

            @Override // x6.h
            public void onSuccess(Object obj) {
                FlatMapMaybeObserver.this.downstream.onSuccess(obj);
            }
        }

        public FlatMapMaybeObserver(x6.h hVar, a7.f fVar) {
            this.downstream = hVar;
            this.mapper = fVar;
        }

        @Override // y6.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // x6.h
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // x6.h
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // x6.h
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // x6.h
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
                z6.a.b(th);
                this.downstream.onError(th);
            }
        }
    }

    public MaybeFlatten(i iVar, a7.f fVar) {
        super(iVar);
        this.f7219j = fVar;
    }

    @Override // x6.f
    public void m(x6.h hVar) {
        this.f7225e.c(new FlatMapMaybeObserver(hVar, this.f7219j));
    }
}
