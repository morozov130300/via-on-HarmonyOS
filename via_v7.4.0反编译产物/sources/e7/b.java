package e7;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements m, y6.b {

    /* renamed from: e, reason: collision with root package name */
    public final m f4787e;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4788j;

    /* renamed from: k, reason: collision with root package name */
    public y6.b f4789k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4790l;

    /* renamed from: m, reason: collision with root package name */
    public io.reactivex.rxjava3.internal.util.a f4791m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f4792n;

    public b(m mVar) {
        this(mVar, false);
    }

    public b(m mVar, boolean z10) {
        this.f4787e = mVar;
        this.f4788j = z10;
    }

    public void a() {
        io.reactivex.rxjava3.internal.util.a aVar;
        do {
            synchronized (this) {
                try {
                    aVar = this.f4791m;
                    if (aVar == null) {
                        this.f4790l = false;
                        return;
                    }
                    this.f4791m = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!aVar.a(this.f4787e));
    }

    @Override // y6.b
    public void dispose() {
        this.f4792n = true;
        this.f4789k.dispose();
    }

    @Override // y6.b
    public boolean isDisposed() {
        return this.f4789k.isDisposed();
    }

    @Override // x6.m
    public void onComplete() {
        if (this.f4792n) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f4792n) {
                    return;
                }
                if (!this.f4790l) {
                    this.f4792n = true;
                    this.f4790l = true;
                    this.f4787e.onComplete();
                } else {
                    io.reactivex.rxjava3.internal.util.a aVar = this.f4791m;
                    if (aVar == null) {
                        aVar = new io.reactivex.rxjava3.internal.util.a(4);
                        this.f4791m = aVar;
                    }
                    aVar.b(NotificationLite.complete());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x6.m
    public void onError(Throwable th) {
        if (this.f4792n) {
            f7.a.o(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z10 = true;
                if (!this.f4792n) {
                    if (this.f4790l) {
                        this.f4792n = true;
                        io.reactivex.rxjava3.internal.util.a aVar = this.f4791m;
                        if (aVar == null) {
                            aVar = new io.reactivex.rxjava3.internal.util.a(4);
                            this.f4791m = aVar;
                        }
                        Object objError = NotificationLite.error(th);
                        if (this.f4788j) {
                            aVar.b(objError);
                        } else {
                            aVar.d(objError);
                        }
                        return;
                    }
                    this.f4792n = true;
                    this.f4790l = true;
                    z10 = false;
                }
                if (z10) {
                    f7.a.o(th);
                } else {
                    this.f4787e.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // x6.m
    public void onNext(Object obj) {
        if (this.f4792n) {
            return;
        }
        if (obj == null) {
            this.f4789k.dispose();
            onError(ExceptionHelper.b("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f4792n) {
                    return;
                }
                if (!this.f4790l) {
                    this.f4790l = true;
                    this.f4787e.onNext(obj);
                    a();
                } else {
                    io.reactivex.rxjava3.internal.util.a aVar = this.f4791m;
                    if (aVar == null) {
                        aVar = new io.reactivex.rxjava3.internal.util.a(4);
                        this.f4791m = aVar;
                    }
                    aVar.b(NotificationLite.next(obj));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x6.m
    public void onSubscribe(y6.b bVar) {
        if (DisposableHelper.validate(this.f4789k, bVar)) {
            this.f4789k = bVar;
            this.f4787e.onSubscribe(this);
        }
    }
}
