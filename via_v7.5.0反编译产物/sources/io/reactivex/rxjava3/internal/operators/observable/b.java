package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.g f6529e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u6.c f6530m;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends io.reactivex.rxjava3.internal.observers.a {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final u6.g f6531p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final u6.c f6532q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f6533r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f6534s;

        public a(r6.o oVar, u6.g gVar, u6.c cVar) {
            super(oVar);
            this.f6531p = gVar;
            this.f6532q = cVar;
        }

        @Override // r6.o
        public void onNext(Object obj) {
            if (this.f6442n) {
                return;
            }
            if (this.f6443o != 0) {
                this.f6439c.onNext(obj);
                return;
            }
            try {
                Object objApply = this.f6531p.apply(obj);
                if (this.f6534s) {
                    boolean zA = this.f6532q.a(this.f6533r, objApply);
                    this.f6533r = objApply;
                    if (zA) {
                        return;
                    }
                } else {
                    this.f6534s = true;
                    this.f6533r = objApply;
                }
                this.f6439c.onNext(obj);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // x6.e
        public Object poll() {
            while (true) {
                Object objPoll = this.f6441m.poll();
                if (objPoll == null) {
                    return null;
                }
                Object objApply = this.f6531p.apply(objPoll);
                if (!this.f6534s) {
                    this.f6534s = true;
                    this.f6533r = objApply;
                    return objPoll;
                }
                if (!this.f6532q.a(this.f6533r, objApply)) {
                    this.f6533r = objApply;
                    return objPoll;
                }
                this.f6533r = objApply;
            }
        }

        @Override // x6.b
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public b(r6.n nVar, u6.g gVar, u6.c cVar) {
        super(nVar);
        this.f6529e = gVar;
        this.f6530m = cVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new a(oVar, this.f6529e, this.f6530m));
    }
}
