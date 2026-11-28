package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import u6.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends io.reactivex.rxjava3.internal.operators.maybe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f6457e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.h, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.h f6458c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i f6459e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s6.b f6460m;

        public a(r6.h hVar, i iVar) {
            this.f6458c = hVar;
            this.f6459e = iVar;
        }

        @Override // s6.b
        public void dispose() {
            s6.b bVar = this.f6460m;
            this.f6460m = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6460m.isDisposed();
        }

        @Override // r6.h
        public void onComplete() {
            this.f6458c.onComplete();
        }

        @Override // r6.h
        public void onError(Throwable th) {
            this.f6458c.onError(th);
        }

        @Override // r6.h
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6460m, bVar)) {
                this.f6460m = bVar;
                this.f6458c.onSubscribe(this);
            }
        }

        @Override // r6.h
        public void onSuccess(Object obj) {
            try {
                if (this.f6459e.test(obj)) {
                    this.f6458c.onSuccess(obj);
                } else {
                    this.f6458c.onComplete();
                }
            } catch (Throwable th) {
                t6.a.b(th);
                this.f6458c.onError(th);
            }
        }
    }

    public b(r6.i iVar, i iVar2) {
        super(iVar);
        this.f6457e = iVar2;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        this.f6456c.c(new a(hVar, this.f6457e));
    }
}
