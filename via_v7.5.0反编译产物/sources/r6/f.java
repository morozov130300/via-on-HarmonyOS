package r6;

import io.reactivex.rxjava3.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatten;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeSubscribeOn;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements i {
    public static f h(Callable callable) {
        Objects.requireNonNull(callable, "callable is null");
        return z6.a.k(new io.reactivex.rxjava3.internal.operators.maybe.e(callable));
    }

    public static f i(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return z6.a.k(new io.reactivex.rxjava3.internal.operators.maybe.f(obj));
    }

    public final s6.b a(u6.f fVar, u6.f fVar2) {
        return l(fVar, fVar2, w6.a.f13676c);
    }

    public final s6.b b(u6.f fVar) {
        return l(fVar, w6.a.f13679f, w6.a.f13676c);
    }

    @Override // r6.i
    public final void c(h hVar) {
        Objects.requireNonNull(hVar, "observer is null");
        h hVarT = z6.a.t(this, hVar);
        Objects.requireNonNull(hVarT, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            m(hVarT);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            t6.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final f d(u6.f fVar) {
        u6.f fVarB = w6.a.b();
        Objects.requireNonNull(fVar, "onSuccess is null");
        u6.f fVarB2 = w6.a.b();
        u6.a aVar = w6.a.f13676c;
        return z6.a.k(new io.reactivex.rxjava3.internal.operators.maybe.h(this, fVarB, fVar, fVarB2, aVar, aVar, aVar));
    }

    public final f e(u6.i iVar) {
        Objects.requireNonNull(iVar, "predicate is null");
        return z6.a.k(new io.reactivex.rxjava3.internal.operators.maybe.b(this, iVar));
    }

    public final f f(u6.g gVar) {
        Objects.requireNonNull(gVar, "mapper is null");
        return z6.a.k(new MaybeFlatten(this, gVar));
    }

    public final j g(u6.g gVar) {
        Objects.requireNonNull(gVar, "mapper is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.maybe.d(this, gVar));
    }

    public final f j(u6.g gVar) {
        Objects.requireNonNull(gVar, "mapper is null");
        return z6.a.k(new io.reactivex.rxjava3.internal.operators.maybe.g(this, gVar));
    }

    public final f k(p pVar) {
        Objects.requireNonNull(pVar, "scheduler is null");
        return z6.a.k(new MaybeObserveOn(this, pVar));
    }

    public final s6.b l(u6.f fVar, u6.f fVar2, u6.a aVar) {
        Objects.requireNonNull(fVar, "onSuccess is null");
        Objects.requireNonNull(fVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        return (s6.b) o(new MaybeCallbackObserver(fVar, fVar2, aVar));
    }

    public abstract void m(h hVar);

    public final f n(p pVar) {
        Objects.requireNonNull(pVar, "scheduler is null");
        return z6.a.k(new MaybeSubscribeOn(this, pVar));
    }

    public final h o(h hVar) {
        c(hVar);
        return hVar;
    }

    public final Object p(g gVar) {
        Objects.requireNonNull(gVar, "converter is null");
        return gVar.a(this);
    }
}
