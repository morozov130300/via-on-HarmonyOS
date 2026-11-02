package io.reactivex.rxjava3.internal.operators.single;

import x6.o;
import x6.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7368a;

    public c(Object obj) {
        this.f7368a = obj;
    }

    @Override // x6.o
    public void k(q qVar) {
        qVar.onSubscribe(io.reactivex.rxjava3.disposables.a.a());
        qVar.onSuccess(this.f7368a);
    }
}
