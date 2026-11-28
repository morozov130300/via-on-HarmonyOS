package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import r6.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements o, x6.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f6439c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s6.b f6440e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public x6.a f6441m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6442n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6443o;

    public a(o oVar) {
        this.f6439c = oVar;
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th) {
        t6.a.b(th);
        this.f6440e.dispose();
        onError(th);
    }

    @Override // x6.e
    public void clear() {
        this.f6441m.clear();
    }

    public final int d(int i10) {
        x6.a aVar = this.f6441m;
        if (aVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = aVar.requestFusion(i10);
        if (iRequestFusion != 0) {
            this.f6443o = iRequestFusion;
        }
        return iRequestFusion;
    }

    @Override // s6.b
    public void dispose() {
        this.f6440e.dispose();
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.f6440e.isDisposed();
    }

    @Override // x6.e
    public boolean isEmpty() {
        return this.f6441m.isEmpty();
    }

    @Override // x6.e
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // r6.o
    public void onComplete() {
        if (this.f6442n) {
            return;
        }
        this.f6442n = true;
        this.f6439c.onComplete();
    }

    @Override // r6.o
    public void onError(Throwable th) {
        if (this.f6442n) {
            z6.a.o(th);
        } else {
            this.f6442n = true;
            this.f6439c.onError(th);
        }
    }

    @Override // r6.o
    public final void onSubscribe(s6.b bVar) {
        if (DisposableHelper.validate(this.f6440e, bVar)) {
            this.f6440e = bVar;
            if (bVar instanceof x6.a) {
                this.f6441m = (x6.a) bVar;
            }
            if (b()) {
                this.f6439c.onSubscribe(this);
                a();
            }
        }
    }

    public void a() {
    }
}
