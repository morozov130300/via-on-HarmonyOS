package autodispose2;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j implements r6.h, s6.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f1657c = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference f1658e = new AtomicReference();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r6.c f1659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final r6.h f1660n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends y6.a {
        public a() {
        }

        @Override // r6.b
        public void onComplete() {
            j.this.f1658e.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(j.this.f1657c);
        }

        @Override // r6.b
        public void onError(Throwable th) {
            j.this.f1658e.lazySet(AutoDisposableHelper.DISPOSED);
            j.this.onError(th);
        }
    }

    public j(r6.c cVar, r6.h hVar) {
        this.f1659m = cVar;
        this.f1660n = hVar;
    }

    @Override // s6.b
    public void dispose() {
        AutoDisposableHelper.dispose(this.f1658e);
        AutoDisposableHelper.dispose(this.f1657c);
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.f1657c.get() == AutoDisposableHelper.DISPOSED;
    }

    @Override // r6.h
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        this.f1657c.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1658e);
        this.f1660n.onComplete();
    }

    @Override // r6.h
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.f1657c.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1658e);
        this.f1660n.onError(th);
    }

    @Override // r6.h
    public void onSubscribe(s6.b bVar) {
        a aVar = new a();
        if (d.c(this.f1658e, aVar, j.class)) {
            this.f1660n.onSubscribe(this);
            this.f1659m.a(aVar);
            d.c(this.f1657c, bVar, j.class);
        }
    }

    @Override // r6.h
    public void onSuccess(Object obj) {
        if (isDisposed()) {
            return;
        }
        this.f1657c.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1658e);
        this.f1660n.onSuccess(obj);
    }
}
