package io.reactivex.rxjava3.internal.operators.observable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.h f7314j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends io.reactivex.rxjava3.internal.observers.a {

        /* renamed from: n, reason: collision with root package name */
        public final a7.h f7315n;

        public a(x6.m mVar, a7.h hVar) {
            super(mVar);
            this.f7315n = hVar;
        }

        @Override // x6.m
        public void onNext(Object obj) {
            if (this.f7212m != 0) {
                this.f7208e.onNext(null);
                return;
            }
            try {
                if (this.f7315n.test(obj)) {
                    this.f7208e.onNext(obj);
                }
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // d7.e
        public Object poll() {
            Object objPoll;
            do {
                objPoll = this.f7210k.poll();
                if (objPoll == null) {
                    break;
                }
            } while (!this.f7315n.test(objPoll));
            return objPoll;
        }

        @Override // d7.b
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public e(x6.l lVar, a7.h hVar) {
        super(lVar);
        this.f7314j = hVar;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f7295e.b(new a(mVar, this.f7314j));
    }
}
