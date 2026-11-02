package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a implements m, d7.a {

    /* renamed from: e, reason: collision with root package name */
    public final m f7208e;

    /* renamed from: j, reason: collision with root package name */
    public y6.b f7209j;

    /* renamed from: k, reason: collision with root package name */
    public d7.a f7210k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7211l;

    /* renamed from: m, reason: collision with root package name */
    public int f7212m;

    public a(m mVar) {
        this.f7208e = mVar;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th) {
        z6.a.b(th);
        this.f7209j.dispose();
        onError(th);
    }

    @Override // d7.e
    public void clear() {
        this.f7210k.clear();
    }

    public final int d(int i10) {
        d7.a aVar = this.f7210k;
        if (aVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = aVar.requestFusion(i10);
        if (iRequestFusion != 0) {
            this.f7212m = iRequestFusion;
        }
        return iRequestFusion;
    }

    @Override // y6.b
    public void dispose() {
        this.f7209j.dispose();
    }

    @Override // y6.b
    public boolean isDisposed() {
        return this.f7209j.isDisposed();
    }

    @Override // d7.e
    public boolean isEmpty() {
        return this.f7210k.isEmpty();
    }

    @Override // d7.e
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // x6.m
    public void onComplete() {
        if (this.f7211l) {
            return;
        }
        this.f7211l = true;
        this.f7208e.onComplete();
    }

    @Override // x6.m
    public void onError(Throwable th) {
        if (this.f7211l) {
            f7.a.o(th);
        } else {
            this.f7211l = true;
            this.f7208e.onError(th);
        }
    }

    @Override // x6.m
    public final void onSubscribe(y6.b bVar) {
        if (DisposableHelper.validate(this.f7209j, bVar)) {
            this.f7209j = bVar;
            if (bVar instanceof d7.a) {
                this.f7210k = (d7.a) bVar;
            }
            if (b()) {
                this.f7208e.onSubscribe(this);
                a();
            }
        }
    }
}
