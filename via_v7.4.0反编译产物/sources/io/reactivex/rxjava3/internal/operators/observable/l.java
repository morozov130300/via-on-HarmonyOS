package io.reactivex.rxjava3.internal.operators.observable;

import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.f f7336j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends io.reactivex.rxjava3.internal.observers.a {

        /* renamed from: n, reason: collision with root package name */
        public final a7.f f7337n;

        public a(x6.m mVar, a7.f fVar) {
            super(mVar);
            this.f7337n = fVar;
        }

        @Override // x6.m
        public void onNext(Object obj) {
            if (this.f7211l) {
                return;
            }
            if (this.f7212m != 0) {
                this.f7208e.onNext(null);
                return;
            }
            try {
                Object objApply = this.f7337n.apply(obj);
                Objects.requireNonNull(objApply, "The mapper function returned a null value.");
                this.f7208e.onNext(objApply);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // d7.e
        public Object poll() {
            Object objPoll = this.f7210k.poll();
            if (objPoll == null) {
                return null;
            }
            Object objApply = this.f7337n.apply(objPoll);
            Objects.requireNonNull(objApply, "The mapper function returned a null value.");
            return objApply;
        }

        @Override // d7.b
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public l(x6.l lVar, a7.f fVar) {
        super(lVar);
        this.f7336j = fVar;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f7295e.b(new a(mVar, this.f7336j));
    }
}
