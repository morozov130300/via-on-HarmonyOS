package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h extends x6.j {

    /* renamed from: e, reason: collision with root package name */
    public final Iterable f7323e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends io.reactivex.rxjava3.internal.observers.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.m f7324e;

        /* renamed from: j, reason: collision with root package name */
        public final Iterator f7325j;

        /* renamed from: k, reason: collision with root package name */
        public volatile boolean f7326k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f7327l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f7328m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f7329n;

        public a(x6.m mVar, Iterator it) {
            this.f7324e = mVar;
            this.f7325j = it;
        }

        public void a() {
            while (!isDisposed()) {
                try {
                    Object next = this.f7325j.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    this.f7324e.onNext(next);
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f7325j.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f7324e.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        z6.a.b(th);
                        this.f7324e.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    z6.a.b(th2);
                    this.f7324e.onError(th2);
                    return;
                }
            }
        }

        @Override // d7.e
        public void clear() {
            this.f7328m = true;
        }

        @Override // y6.b
        public void dispose() {
            this.f7326k = true;
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7326k;
        }

        @Override // d7.e
        public boolean isEmpty() {
            return this.f7328m;
        }

        @Override // d7.e
        public Object poll() {
            if (this.f7328m) {
                return null;
            }
            if (!this.f7329n) {
                this.f7329n = true;
            } else if (!this.f7325j.hasNext()) {
                this.f7328m = true;
                return null;
            }
            Object next = this.f7325j.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            return next;
        }

        @Override // d7.b
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f7327l = true;
            return 1;
        }
    }

    public h(Iterable iterable) {
        this.f7323e = iterable;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        try {
            Iterator it = this.f7323e.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(mVar);
                    return;
                }
                a aVar = new a(mVar, it);
                mVar.onSubscribe(aVar);
                if (aVar.f7327l) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                z6.a.b(th);
                EmptyDisposable.error(th, mVar);
            }
        } catch (Throwable th2) {
            z6.a.b(th2);
            EmptyDisposable.error(th2, mVar);
        }
    }
}
