package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import x6.q;
import x6.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends x6.f {

    /* renamed from: e, reason: collision with root package name */
    public final r f7230e;

    /* renamed from: j, reason: collision with root package name */
    public final a7.h f7231j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements q, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.h f7232e;

        /* renamed from: j, reason: collision with root package name */
        public final a7.h f7233j;

        /* renamed from: k, reason: collision with root package name */
        public y6.b f7234k;

        public a(x6.h hVar, a7.h hVar2) {
            this.f7232e = hVar;
            this.f7233j = hVar2;
        }

        @Override // y6.b
        public void dispose() {
            y6.b bVar = this.f7234k;
            this.f7234k = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7234k.isDisposed();
        }

        @Override // x6.q
        public void onError(Throwable th) {
            this.f7232e.onError(th);
        }

        @Override // x6.q
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7234k, bVar)) {
                this.f7234k = bVar;
                this.f7232e.onSubscribe(this);
            }
        }

        @Override // x6.q
        public void onSuccess(Object obj) {
            try {
                if (this.f7233j.test(obj)) {
                    this.f7232e.onSuccess(obj);
                } else {
                    this.f7232e.onComplete();
                }
            } catch (Throwable th) {
                z6.a.b(th);
                this.f7232e.onError(th);
            }
        }
    }

    public c(r rVar, a7.h hVar) {
        this.f7230e = rVar;
        this.f7231j = hVar;
    }

    @Override // x6.f
    public void m(x6.h hVar) {
        this.f7230e.c(new a(hVar, this.f7231j));
    }
}
