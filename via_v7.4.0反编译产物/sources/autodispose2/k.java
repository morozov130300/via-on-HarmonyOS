package autodispose2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k implements x6.q, y6.b {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f1763e = new AtomicReference();

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReference f1764j = new AtomicReference();

    /* renamed from: k, reason: collision with root package name */
    public final x6.c f1765k;

    /* renamed from: l, reason: collision with root package name */
    public final x6.q f1766l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends e7.a {
        public a() {
        }

        @Override // x6.b
        public void onComplete() {
            k.this.f1764j.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(k.this.f1763e);
        }

        @Override // x6.b
        public void onError(Throwable th) {
            k.this.f1764j.lazySet(AutoDisposableHelper.DISPOSED);
            k.this.onError(th);
        }
    }

    public k(x6.c cVar, x6.q qVar) {
        this.f1765k = cVar;
        this.f1766l = qVar;
    }

    @Override // y6.b
    public void dispose() {
        AutoDisposableHelper.dispose(this.f1764j);
        AutoDisposableHelper.dispose(this.f1763e);
    }

    @Override // y6.b
    public boolean isDisposed() {
        return this.f1763e.get() == AutoDisposableHelper.DISPOSED;
    }

    @Override // x6.q
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.f1763e.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1764j);
        this.f1766l.onError(th);
    }

    @Override // x6.q
    public void onSubscribe(y6.b bVar) {
        a aVar = new a();
        if (d.c(this.f1764j, aVar, k.class)) {
            this.f1766l.onSubscribe(this);
            this.f1765k.a(aVar);
            d.c(this.f1763e, bVar, k.class);
        }
    }

    @Override // x6.q
    public void onSuccess(Object obj) {
        if (isDisposed()) {
            return;
        }
        this.f1763e.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1764j);
        this.f1766l.onSuccess(obj);
    }
}
