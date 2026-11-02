package x6;

import io.reactivex.rxjava3.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatten;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeSubscribeOn;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f implements i {
    public static f h(Callable callable) {
        Objects.requireNonNull(callable, "callable is null");
        return f7.a.k(new io.reactivex.rxjava3.internal.operators.maybe.e(callable));
    }

    public static f i(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return f7.a.k(new io.reactivex.rxjava3.internal.operators.maybe.f(obj));
    }

    public final y6.b a(a7.e eVar, a7.e eVar2) {
        return l(eVar, eVar2, c7.a.f2310c);
    }

    public final y6.b b(a7.e eVar) {
        return l(eVar, c7.a.f2313f, c7.a.f2310c);
    }

    @Override // x6.i
    public final void c(h hVar) {
        Objects.requireNonNull(hVar, "observer is null");
        h hVarT = f7.a.t(this, hVar);
        Objects.requireNonNull(hVarT, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            m(hVarT);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            z6.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final f d(a7.e eVar) {
        a7.e eVarB = c7.a.b();
        Objects.requireNonNull(eVar, "onSuccess is null");
        a7.e eVarB2 = c7.a.b();
        a7.a aVar = c7.a.f2310c;
        return f7.a.k(new io.reactivex.rxjava3.internal.operators.maybe.h(this, eVarB, eVar, eVarB2, aVar, aVar, aVar));
    }

    public final f e(a7.h hVar) {
        Objects.requireNonNull(hVar, "predicate is null");
        return f7.a.k(new io.reactivex.rxjava3.internal.operators.maybe.b(this, hVar));
    }

    public final f f(a7.f fVar) {
        Objects.requireNonNull(fVar, "mapper is null");
        return f7.a.k(new MaybeFlatten(this, fVar));
    }

    public final j g(a7.f fVar) {
        Objects.requireNonNull(fVar, "mapper is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.maybe.d(this, fVar));
    }

    public final f j(a7.f fVar) {
        Objects.requireNonNull(fVar, "mapper is null");
        return f7.a.k(new io.reactivex.rxjava3.internal.operators.maybe.g(this, fVar));
    }

    public final f k(n nVar) {
        Objects.requireNonNull(nVar, "scheduler is null");
        return f7.a.k(new MaybeObserveOn(this, nVar));
    }

    public final y6.b l(a7.e eVar, a7.e eVar2, a7.a aVar) {
        Objects.requireNonNull(eVar, "onSuccess is null");
        Objects.requireNonNull(eVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        return (y6.b) o(new MaybeCallbackObserver(eVar, eVar2, aVar));
    }

    public abstract void m(h hVar);

    public final f n(n nVar) {
        Objects.requireNonNull(nVar, "scheduler is null");
        return f7.a.k(new MaybeSubscribeOn(this, nVar));
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
