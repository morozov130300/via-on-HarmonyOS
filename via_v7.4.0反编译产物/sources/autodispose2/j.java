package autodispose2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j implements x6.h, y6.b {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f1758e = new AtomicReference();

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReference f1759j = new AtomicReference();

    /* renamed from: k, reason: collision with root package name */
    public final x6.c f1760k;

    /* renamed from: l, reason: collision with root package name */
    public final x6.h f1761l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends e7.a {
        public a() {
        }

        @Override // x6.b
        public void onComplete() {
            j.this.f1759j.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(j.this.f1758e);
        }

        @Override // x6.b
        public void onError(Throwable th) {
            j.this.f1759j.lazySet(AutoDisposableHelper.DISPOSED);
            j.this.onError(th);
        }
    }

    public j(x6.c cVar, x6.h hVar) {
        this.f1760k = cVar;
        this.f1761l = hVar;
    }

    @Override // y6.b
    public void dispose() {
        AutoDisposableHelper.dispose(this.f1759j);
        AutoDisposableHelper.dispose(this.f1758e);
    }

    @Override // y6.b
    public boolean isDisposed() {
        return this.f1758e.get() == AutoDisposableHelper.DISPOSED;
    }

    @Override // x6.h
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        this.f1758e.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1759j);
        this.f1761l.onComplete();
    }

    @Override // x6.h
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.f1758e.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1759j);
        this.f1761l.onError(th);
    }

    @Override // x6.h
    public void onSubscribe(y6.b bVar) {
        a aVar = new a();
        if (d.c(this.f1759j, aVar, j.class)) {
            this.f1761l.onSubscribe(this);
            this.f1760k.a(aVar);
            d.c(this.f1758e, bVar, j.class);
        }
    }

    @Override // x6.h
    public void onSuccess(Object obj) {
        if (isDisposed()) {
            return;
        }
        this.f1758e.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f1759j);
        this.f1761l.onSuccess(obj);
    }
}
