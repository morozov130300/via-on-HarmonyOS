package io.reactivex.rxjava3.internal.operators.observable;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f extends r6.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f6549c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends io.reactivex.rxjava3.internal.observers.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.o f6550c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object[] f6551e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6552m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f6553n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public volatile boolean f6554o;

        public a(r6.o oVar, Object[] objArr) {
            this.f6550c = oVar;
            this.f6551e = objArr;
        }

        public void a() {
            Object[] objArr = this.f6551e;
            int length = objArr.length;
            for (int i10 = 0; i10 < length && !isDisposed(); i10++) {
                Object obj = objArr[i10];
                if (obj == null) {
                    this.f6550c.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                this.f6550c.onNext(obj);
            }
            if (isDisposed()) {
                return;
            }
            this.f6550c.onComplete();
        }

        @Override // x6.e
        public void clear() {
            this.f6552m = this.f6551e.length;
        }

        @Override // s6.b
        public void dispose() {
            this.f6554o = true;
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6554o;
        }

        @Override // x6.e
        public boolean isEmpty() {
            return this.f6552m == this.f6551e.length;
        }

        @Override // x6.e
        public Object poll() {
            int i10 = this.f6552m;
            Object[] objArr = this.f6551e;
            if (i10 == objArr.length) {
                return null;
            }
            this.f6552m = i10 + 1;
            Object obj = objArr[i10];
            Objects.requireNonNull(obj, "The array element is null");
            return obj;
        }

        @Override // x6.b
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f6553n = true;
            return 1;
        }
    }

    public f(Object[] objArr) {
        this.f6549c = objArr;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        a aVar = new a(oVar, this.f6549c);
        oVar.onSubscribe(aVar);
        if (aVar.f6553n) {
            return;
        }
        aVar.a();
    }
}
