package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import x6.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends io.reactivex.rxjava3.internal.operators.maybe.a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.h f7226j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements x6.h, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.h f7227e;

        /* renamed from: j, reason: collision with root package name */
        public final a7.h f7228j;

        /* renamed from: k, reason: collision with root package name */
        public y6.b f7229k;

        public a(x6.h hVar, a7.h hVar2) {
            this.f7227e = hVar;
            this.f7228j = hVar2;
        }

        @Override // y6.b
        public void dispose() {
            y6.b bVar = this.f7229k;
            this.f7229k = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7229k.isDisposed();
        }

        @Override // x6.h
        public void onComplete() {
            this.f7227e.onComplete();
        }

        @Override // x6.h
        public void onError(Throwable th) {
            this.f7227e.onError(th);
        }

        @Override // x6.h
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7229k, bVar)) {
                this.f7229k = bVar;
                this.f7227e.onSubscribe(this);
            }
        }

        @Override // x6.h
        public void onSuccess(Object obj) {
            try {
                if (this.f7228j.test(obj)) {
                    this.f7227e.onSuccess(obj);
                } else {
                    this.f7227e.onComplete();
                }
            } catch (Throwable th) {
                z6.a.b(th);
                this.f7227e.onError(th);
            }
        }
    }

    public b(i iVar, a7.h hVar) {
        super(iVar);
        this.f7226j = hVar;
    }

    @Override // x6.f
    public void m(x6.h hVar) {
        this.f7225e.c(new a(hVar, this.f7226j));
    }
}
