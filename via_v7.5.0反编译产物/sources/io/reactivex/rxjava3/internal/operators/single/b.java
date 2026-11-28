package io.reactivex.rxjava3.internal.operators.single;

import r6.q;
import r6.s;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6597a;

    public b(Object obj) {
        this.f6597a = obj;
    }

    @Override // r6.q
    public void j(s sVar) {
        sVar.onSubscribe(io.reactivex.rxjava3.disposables.a.a());
        sVar.onSuccess(this.f6597a);
    }
}
