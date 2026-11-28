package autodispose2;

import java.util.concurrent.atomic.AtomicReference;
import r6.s;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k implements s, s6.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f1662c = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference f1663e = new AtomicReference();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r6.c f1664m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final s f1665n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends y6.a {
        public a() {
        }

        @Override // r6.b
        public void onComplete() {
            k.this.f1663e.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(k.this.f1662c);
        }

        @Override // r6.b
        public void onError(Throwable th) {
            k.this.f1663e.lazySet(AutoDisposableHelper.DISPOSED);
            k.this.onError(th);
        }
    }

    public k(r6.c cVar, s sVar) {
        this.f1664m = cVar;
        this.f1665n = sVar;
    }

    @Override // s6.b
    public void dispose() {
        AutoDisposableHelper.dispose(this.f1663e);
        AutoDisposableHelper.dispose(this.f1662c);
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.f1662c.get() == AutoDisposableHelper.DISPOSED;
    }

    @Override // r6.s
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.f1662c.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1663e);
        this.f1665n.onError(th);
    }

    @Override // r6.s
    public void onSubscribe(s6.b bVar) {
        a aVar = new a();
        if (d.c(this.f1663e, aVar, k.class)) {
            this.f1665n.onSubscribe(this);
            this.f1664m.a(aVar);
            d.c(this.f1662c, bVar, k.class);
        }
    }

    @Override // r6.s
    public void onSuccess(Object obj) {
        if (isDisposed()) {
            return;
        }
        this.f1662c.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1663e);
        this.f1665n.onSuccess(obj);
    }
}
