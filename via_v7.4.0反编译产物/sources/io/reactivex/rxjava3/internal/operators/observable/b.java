package io.reactivex.rxjava3.internal.operators.observable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: j, reason: collision with root package name */
    public final a7.f f7296j;

    /* renamed from: k, reason: collision with root package name */
    public final a7.c f7297k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends io.reactivex.rxjava3.internal.observers.a {

        /* renamed from: n, reason: collision with root package name */
        public final a7.f f7298n;

        /* renamed from: o, reason: collision with root package name */
        public final a7.c f7299o;

        /* renamed from: p, reason: collision with root package name */
        public Object f7300p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f7301q;

        public a(x6.m mVar, a7.f fVar, a7.c cVar) {
            super(mVar);
            this.f7298n = fVar;
            this.f7299o = cVar;
        }

        @Override // x6.m
        public void onNext(Object obj) {
            if (this.f7211l) {
                return;
            }
            if (this.f7212m != 0) {
                this.f7208e.onNext(obj);
                return;
            }
            try {
                Object objApply = this.f7298n.apply(obj);
                if (this.f7301q) {
                    boolean zA = this.f7299o.a(this.f7300p, objApply);
                    this.f7300p = objApply;
                    if (zA) {
                        return;
                    }
                } else {
                    this.f7301q = true;
                    this.f7300p = objApply;
                }
                this.f7208e.onNext(obj);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // d7.e
        public Object poll() {
            while (true) {
                Object objPoll = this.f7210k.poll();
                if (objPoll == null) {
                    return null;
                }
                Object objApply = this.f7298n.apply(objPoll);
                if (!this.f7301q) {
                    this.f7301q = true;
                    this.f7300p = objApply;
                    return objPoll;
                }
                if (!this.f7299o.a(this.f7300p, objApply)) {
                    this.f7300p = objApply;
                    return objPoll;
                }
                this.f7300p = objApply;
            }
        }

        @Override // d7.b
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public b(x6.l lVar, a7.f fVar, a7.c cVar) {
        super(lVar);
        this.f7296j = fVar;
        this.f7297k = cVar;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f7295e.b(new a(mVar, this.f7296j, this.f7297k));
    }
}
