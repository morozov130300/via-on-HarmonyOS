package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import r6.s;
import r6.t;
import u6.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends r6.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f6461c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f6462e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements s, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.h f6463c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i f6464e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s6.b f6465m;

        public a(r6.h hVar, i iVar) {
            this.f6463c = hVar;
            this.f6464e = iVar;
        }

        @Override // s6.b
        public void dispose() {
            s6.b bVar = this.f6465m;
            this.f6465m = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6465m.isDisposed();
        }

        @Override // r6.s
        public void onError(Throwable th) {
            this.f6463c.onError(th);
        }

        @Override // r6.s
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6465m, bVar)) {
                this.f6465m = bVar;
                this.f6463c.onSubscribe(this);
            }
        }

        @Override // r6.s
        public void onSuccess(Object obj) {
            try {
                if (this.f6464e.test(obj)) {
                    this.f6463c.onSuccess(obj);
                } else {
                    this.f6463c.onComplete();
                }
            } catch (Throwable th) {
                t6.a.b(th);
                this.f6463c.onError(th);
            }
        }
    }

    public c(t tVar, i iVar) {
        this.f6461c = tVar;
        this.f6462e = iVar;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        this.f6461c.c(new a(hVar, this.f6462e));
    }
}
