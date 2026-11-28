package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Iterator;
import java.util.Objects;
import r6.i;
import r6.j;
import r6.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f6466c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.g f6467e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends io.reactivex.rxjava3.internal.observers.b implements r6.h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f6468c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final u6.g f6469e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s6.b f6470m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public volatile Iterator f6471n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public volatile boolean f6472o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f6473p;

        public a(o oVar, u6.g gVar) {
            this.f6468c = oVar;
            this.f6469e = gVar;
        }

        @Override // x6.e
        public void clear() {
            this.f6471n = null;
        }

        @Override // s6.b
        public void dispose() {
            this.f6472o = true;
            this.f6470m.dispose();
            this.f6470m = DisposableHelper.DISPOSED;
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6472o;
        }

        @Override // x6.e
        public boolean isEmpty() {
            return this.f6471n == null;
        }

        @Override // r6.h
        public void onComplete() {
            this.f6468c.onComplete();
        }

        @Override // r6.h
        public void onError(Throwable th) {
            this.f6470m = DisposableHelper.DISPOSED;
            this.f6468c.onError(th);
        }

        @Override // r6.h
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6470m, bVar)) {
                this.f6470m = bVar;
                this.f6468c.onSubscribe(this);
            }
        }

        @Override // r6.h
        public void onSuccess(Object obj) {
            o oVar = this.f6468c;
            try {
                Iterator it = ((Iterable) this.f6469e.apply(obj)).iterator();
                if (!it.hasNext()) {
                    oVar.onComplete();
                    return;
                }
                this.f6471n = it;
                if (this.f6473p) {
                    oVar.onNext(null);
                    oVar.onComplete();
                    return;
                }
                while (!this.f6472o) {
                    try {
                        oVar.onNext(it.next());
                        if (this.f6472o) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                oVar.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            t6.a.b(th);
                            oVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        t6.a.b(th2);
                        oVar.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                t6.a.b(th3);
                oVar.onError(th3);
            }
        }

        @Override // x6.e
        public Object poll() {
            Iterator it = this.f6471n;
            if (it == null) {
                return null;
            }
            Object next = it.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f6471n = null;
            }
            return next;
        }

        @Override // x6.b
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.f6473p = true;
            return 2;
        }
    }

    public d(i iVar, u6.g gVar) {
        this.f6466c = iVar;
        this.f6467e = gVar;
    }

    @Override // r6.j
    public void F(o oVar) {
        this.f6466c.c(new a(oVar, this.f6467e));
    }
}
