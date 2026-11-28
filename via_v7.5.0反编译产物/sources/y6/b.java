package y6;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import r6.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o, s6.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f14854c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14855e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public s6.b f14856m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14857n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public io.reactivex.rxjava3.internal.util.a f14858o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f14859p;

    public b(o oVar) {
        this(oVar, false);
    }

    public void a() {
        io.reactivex.rxjava3.internal.util.a aVar;
        do {
            synchronized (this) {
                try {
                    aVar = this.f14858o;
                    if (aVar == null) {
                        this.f14857n = false;
                        return;
                    }
                    this.f14858o = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!aVar.a(this.f14854c));
    }

    @Override // s6.b
    public void dispose() {
        this.f14859p = true;
        this.f14856m.dispose();
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.f14856m.isDisposed();
    }

    @Override // r6.o
    public void onComplete() {
        if (this.f14859p) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f14859p) {
                    return;
                }
                if (!this.f14857n) {
                    this.f14859p = true;
                    this.f14857n = true;
                    this.f14854c.onComplete();
                } else {
                    io.reactivex.rxjava3.internal.util.a aVar = this.f14858o;
                    if (aVar == null) {
                        aVar = new io.reactivex.rxjava3.internal.util.a(4);
                        this.f14858o = aVar;
                    }
                    aVar.b(NotificationLite.complete());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // r6.o
    public void onError(Throwable th) {
        if (this.f14859p) {
            z6.a.o(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z10 = true;
                if (!this.f14859p) {
                    if (this.f14857n) {
                        this.f14859p = true;
                        io.reactivex.rxjava3.internal.util.a aVar = this.f14858o;
                        if (aVar == null) {
                            aVar = new io.reactivex.rxjava3.internal.util.a(4);
                            this.f14858o = aVar;
                        }
                        Object objError = NotificationLite.error(th);
                        if (this.f14855e) {
                            aVar.b(objError);
                        } else {
                            aVar.d(objError);
                        }
                        return;
                    }
                    this.f14859p = true;
                    this.f14857n = true;
                    z10 = false;
                }
                if (z10) {
                    z6.a.o(th);
                } else {
                    this.f14854c.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // r6.o
    public void onNext(Object obj) {
        if (this.f14859p) {
            return;
        }
        if (obj == null) {
            this.f14856m.dispose();
            onError(ExceptionHelper.b("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f14859p) {
                    return;
                }
                if (!this.f14857n) {
                    this.f14857n = true;
                    this.f14854c.onNext(obj);
                    a();
                } else {
                    io.reactivex.rxjava3.internal.util.a aVar = this.f14858o;
                    if (aVar == null) {
                        aVar = new io.reactivex.rxjava3.internal.util.a(4);
                        this.f14858o = aVar;
                    }
                    aVar.b(NotificationLite.next(obj));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // r6.o
    public void onSubscribe(s6.b bVar) {
        if (DisposableHelper.validate(this.f14856m, bVar)) {
            this.f14856m = bVar;
            this.f14854c.onSubscribe(this);
        }
    }

    public b(o oVar, boolean z10) {
        this.f14854c = oVar;
        this.f14855e = z10;
    }
}
