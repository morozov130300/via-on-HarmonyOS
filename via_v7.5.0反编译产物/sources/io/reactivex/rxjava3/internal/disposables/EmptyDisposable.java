package io.reactivex.rxjava3.internal.disposables;

import r6.b;
import r6.h;
import r6.o;
import r6.s;
import x6.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public enum EmptyDisposable implements a {
    INSTANCE,
    NEVER;

    public static void complete(o oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onComplete();
    }

    public static void error(Throwable th, o oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onError(th);
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // x6.e
    public boolean isEmpty() {
        return true;
    }

    @Override // x6.e
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // x6.e
    public Object poll() {
        return null;
    }

    @Override // x6.b
    public int requestFusion(int i10) {
        return i10 & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(h hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onComplete();
    }

    public static void error(Throwable th, b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    public static void complete(b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th, s sVar) {
        sVar.onSubscribe(INSTANCE);
        sVar.onError(th);
    }

    public static void error(Throwable th, h hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onError(th);
    }

    @Override // x6.e
    public void clear() {
    }

    @Override // s6.b
    public void dispose() {
    }
}
