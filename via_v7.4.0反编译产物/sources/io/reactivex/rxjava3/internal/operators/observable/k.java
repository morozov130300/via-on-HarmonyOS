package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k extends x6.j implements d7.c {

    /* renamed from: e, reason: collision with root package name */
    public final Object f7335e;

    public k(Object obj) {
        this.f7335e = obj;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(mVar, this.f7335e);
        mVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    @Override // d7.c, a7.i
    public Object get() {
        return this.f7335e;
    }
}
