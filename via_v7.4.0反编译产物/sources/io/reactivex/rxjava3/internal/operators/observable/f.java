package io.reactivex.rxjava3.internal.operators.observable;

import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f extends x6.j {

    /* renamed from: e, reason: collision with root package name */
    public final Object[] f7316e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends io.reactivex.rxjava3.internal.observers.b {

        /* renamed from: e, reason: collision with root package name */
        public final x6.m f7317e;

        /* renamed from: j, reason: collision with root package name */
        public final Object[] f7318j;

        /* renamed from: k, reason: collision with root package name */
        public int f7319k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f7320l;

        /* renamed from: m, reason: collision with root package name */
        public volatile boolean f7321m;

        public a(x6.m mVar, Object[] objArr) {
            this.f7317e = mVar;
            this.f7318j = objArr;
        }

        public void a() {
            Object[] objArr = this.f7318j;
            int length = objArr.length;
            for (int i10 = 0; i10 < length && !isDisposed(); i10++) {
                Object obj = objArr[i10];
                if (obj == null) {
                    this.f7317e.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                this.f7317e.onNext(obj);
            }
            if (isDisposed()) {
                return;
            }
            this.f7317e.onComplete();
        }

        @Override // d7.e
        public void clear() {
            this.f7319k = this.f7318j.length;
        }

        @Override // y6.b
        public void dispose() {
            this.f7321m = true;
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7321m;
        }

        @Override // d7.e
        public boolean isEmpty() {
            return this.f7319k == this.f7318j.length;
        }

        @Override // d7.e
        public Object poll() {
            int i10 = this.f7319k;
            Object[] objArr = this.f7318j;
            if (i10 == objArr.length) {
                return null;
            }
            this.f7319k = i10 + 1;
            Object obj = objArr[i10];
            Objects.requireNonNull(obj, "The array element is null");
            return obj;
        }

        @Override // d7.b
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f7320l = true;
            return 1;
        }
    }

    public f(Object[] objArr) {
        this.f7316e = objArr;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        a aVar = new a(mVar, this.f7316e);
        mVar.onSubscribe(aVar);
        if (aVar.f7320l) {
            return;
        }
        aVar.a();
    }
}
