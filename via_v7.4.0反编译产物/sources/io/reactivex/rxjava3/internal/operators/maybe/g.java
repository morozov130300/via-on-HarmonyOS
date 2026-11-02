package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import x6.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g extends io.reactivex.rxjava3.internal.operators.maybe.a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.f f7245j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.h, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.h f7246e;

        /* renamed from: j, reason: collision with root package name */
        public final a7.f f7247j;

        /* renamed from: k, reason: collision with root package name */
        public y6.b f7248k;

        public a(x6.h hVar, a7.f fVar) {
            this.f7246e = hVar;
            this.f7247j = fVar;
        }

        @Override // y6.b
        public void dispose() {
            y6.b bVar = this.f7248k;
            this.f7248k = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7248k.isDisposed();
        }

        @Override // x6.h
        public void onComplete() {
            this.f7246e.onComplete();
        }

        @Override // x6.h
        public void onError(Throwable th) {
            this.f7246e.onError(th);
        }

        @Override // x6.h
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7248k, bVar)) {
                this.f7248k = bVar;
                this.f7246e.onSubscribe(this);
            }
        }

        @Override // x6.h
        public void onSuccess(Object obj) {
            try {
                Object objApply = this.f7247j.apply(obj);
                Objects.requireNonNull(objApply, "The mapper returned a null item");
                this.f7246e.onSuccess(objApply);
            } catch (Throwable th) {
                z6.a.b(th);
                this.f7246e.onError(th);
            }
        }
    }

    public g(i iVar, a7.f fVar) {
        super(iVar);
        this.f7245j = fVar;
    }

    @Override // x6.f
    public void m(x6.h hVar) {
        this.f7225e.c(new a(hVar, this.f7245j));
    }
}
