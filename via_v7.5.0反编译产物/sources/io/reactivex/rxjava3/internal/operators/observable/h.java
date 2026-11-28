package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends r6.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterable f6556c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends io.reactivex.rxjava3.internal.observers.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.o f6557c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Iterator f6558e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public volatile boolean f6559m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f6560n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f6561o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f6562p;

        public a(r6.o oVar, Iterator it) {
            this.f6557c = oVar;
            this.f6558e = it;
        }

        public void a() {
            while (!isDisposed()) {
                try {
                    Object next = this.f6558e.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    this.f6557c.onNext(next);
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f6558e.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f6557c.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        t6.a.b(th);
                        this.f6557c.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    t6.a.b(th2);
                    this.f6557c.onError(th2);
                    return;
                }
            }
        }

        @Override // x6.e
        public void clear() {
            this.f6561o = true;
        }

        @Override // s6.b
        public void dispose() {
            this.f6559m = true;
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6559m;
        }

        @Override // x6.e
        public boolean isEmpty() {
            return this.f6561o;
        }

        @Override // x6.e
        public Object poll() {
            if (this.f6561o) {
                return null;
            }
            if (!this.f6562p) {
                this.f6562p = true;
            } else if (!this.f6558e.hasNext()) {
                this.f6561o = true;
                return null;
            }
            Object next = this.f6558e.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            return next;
        }

        @Override // x6.b
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f6560n = true;
            return 1;
        }
    }

    public h(Iterable iterable) {
        this.f6556c = iterable;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        try {
            Iterator it = this.f6556c.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(oVar);
                    return;
                }
                a aVar = new a(oVar, it);
                oVar.onSubscribe(aVar);
                if (aVar.f6560n) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                t6.a.b(th);
                EmptyDisposable.error(th, oVar);
            }
        } catch (Throwable th2) {
            t6.a.b(th2);
            EmptyDisposable.error(th2, oVar);
        }
    }
}
