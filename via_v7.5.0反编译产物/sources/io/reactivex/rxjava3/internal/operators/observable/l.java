package io.reactivex.rxjava3.internal.operators.observable;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.g f6569e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends io.reactivex.rxjava3.internal.observers.a {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final u6.g f6570p;

        public a(r6.o oVar, u6.g gVar) {
            super(oVar);
            this.f6570p = gVar;
        }

        @Override // r6.o
        public void onNext(Object obj) {
            if (this.f6442n) {
                return;
            }
            if (this.f6443o != 0) {
                this.f6439c.onNext(null);
                return;
            }
            try {
                Object objApply = this.f6570p.apply(obj);
                Objects.requireNonNull(objApply, "The mapper function returned a null value.");
                this.f6439c.onNext(objApply);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // x6.e
        public Object poll() {
            Object objPoll = this.f6441m.poll();
            if (objPoll == null) {
                return null;
            }
            Object objApply = this.f6570p.apply(objPoll);
            Objects.requireNonNull(objApply, "The mapper function returned a null value.");
            return objApply;
        }

        @Override // x6.b
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public l(r6.n nVar, u6.g gVar) {
        super(nVar);
        this.f6569e = gVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new a(oVar, this.f6569e));
    }
}
