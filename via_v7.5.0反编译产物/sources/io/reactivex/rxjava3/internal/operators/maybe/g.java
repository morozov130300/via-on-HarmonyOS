package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import r6.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g extends io.reactivex.rxjava3.internal.operators.maybe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.g f6476e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.h, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r6.h f6477c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final u6.g f6478e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s6.b f6479m;

        public a(r6.h hVar, u6.g gVar) {
            this.f6477c = hVar;
            this.f6478e = gVar;
        }

        @Override // s6.b
        public void dispose() {
            s6.b bVar = this.f6479m;
            this.f6479m = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6479m.isDisposed();
        }

        @Override // r6.h
        public void onComplete() {
            this.f6477c.onComplete();
        }

        @Override // r6.h
        public void onError(Throwable th) {
            this.f6477c.onError(th);
        }

        @Override // r6.h
        public void onSubscribe(s6.b bVar) {
            if (DisposableHelper.validate(this.f6479m, bVar)) {
                this.f6479m = bVar;
                this.f6477c.onSubscribe(this);
            }
        }

        @Override // r6.h
        public void onSuccess(Object obj) {
            try {
                Object objApply = this.f6478e.apply(obj);
                Objects.requireNonNull(objApply, "The mapper returned a null item");
                this.f6477c.onSuccess(objApply);
            } catch (Throwable th) {
                t6.a.b(th);
                this.f6477c.onError(th);
            }
        }
    }

    public g(i iVar, u6.g gVar) {
        super(iVar);
        this.f6476e = gVar;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        this.f6456c.c(new a(hVar, this.f6476e));
    }
}
