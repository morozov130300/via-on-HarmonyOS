package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.i f6547e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends io.reactivex.rxjava3.internal.observers.a {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final u6.i f6548p;

        public a(r6.o oVar, u6.i iVar) {
            super(oVar);
            this.f6548p = iVar;
        }

        @Override // r6.o
        public void onNext(Object obj) {
            if (this.f6443o != 0) {
                this.f6439c.onNext(null);
                return;
            }
            try {
                if (this.f6548p.test(obj)) {
                    this.f6439c.onNext(obj);
                }
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // x6.e
        public Object poll() {
            Object objPoll;
            do {
                objPoll = this.f6441m.poll();
                if (objPoll == null) {
                    break;
                }
            } while (!this.f6548p.test(objPoll));
            return objPoll;
        }

        @Override // x6.b
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public e(r6.n nVar, u6.i iVar) {
        super(nVar);
        this.f6547e = iVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f6528c.c(new a(oVar, this.f6547e));
    }
}
