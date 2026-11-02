package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Iterator;
import java.util.Objects;
import x6.i;
import x6.j;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends j {

    /* renamed from: e, reason: collision with root package name */
    public final i f7235e;

    /* renamed from: j, reason: collision with root package name */
    public final a7.f f7236j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends io.reactivex.rxjava3.internal.observers.b implements x6.h {

        /* renamed from: e, reason: collision with root package name */
        public final m f7237e;

        /* renamed from: j, reason: collision with root package name */
        public final a7.f f7238j;

        /* renamed from: k, reason: collision with root package name */
        public y6.b f7239k;

        /* renamed from: l, reason: collision with root package name */
        public volatile Iterator f7240l;

        /* renamed from: m, reason: collision with root package name */
        public volatile boolean f7241m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f7242n;

        public a(m mVar, a7.f fVar) {
            this.f7237e = mVar;
            this.f7238j = fVar;
        }

        @Override // d7.e
        public void clear() {
            this.f7240l = null;
        }

        @Override // y6.b
        public void dispose() {
            this.f7241m = true;
            this.f7239k.dispose();
            this.f7239k = DisposableHelper.DISPOSED;
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7241m;
        }

        @Override // d7.e
        public boolean isEmpty() {
            return this.f7240l == null;
        }

        @Override // x6.h
        public void onComplete() {
            this.f7237e.onComplete();
        }

        @Override // x6.h
        public void onError(Throwable th) {
            this.f7239k = DisposableHelper.DISPOSED;
            this.f7237e.onError(th);
        }

        @Override // x6.h
        public void onSubscribe(y6.b bVar) {
            if (DisposableHelper.validate(this.f7239k, bVar)) {
                this.f7239k = bVar;
                this.f7237e.onSubscribe(this);
            }
        }

        @Override // x6.h
        public void onSuccess(Object obj) {
            m mVar = this.f7237e;
            try {
                Iterator it = ((Iterable) this.f7238j.apply(obj)).iterator();
                if (!it.hasNext()) {
                    mVar.onComplete();
                    return;
                }
                this.f7240l = it;
                if (this.f7242n) {
                    mVar.onNext(null);
                    mVar.onComplete();
                    return;
                }
                while (!this.f7241m) {
                    try {
                        mVar.onNext(it.next());
                        if (this.f7241m) {
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
                mVar.onError(th3);
            }
        }

        @Override // d7.e
        public Object poll() {
            Iterator it = this.f7240l;
            if (it == null) {
                return null;
            }
            Object next = it.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f7240l = null;
            }
            return next;
        }

        @Override // d7.b
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.f7242n = true;
            return 2;
        }
    }

    public d(i iVar, a7.f fVar) {
        this.f7235e = iVar;
        this.f7236j = fVar;
    }

    @Override // x6.j
    public void C(m mVar) {
        this.f7235e.c(new a(mVar, this.f7236j));
    }
}
