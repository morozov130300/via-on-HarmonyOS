package x6;

import io.reactivex.rxjava3.internal.observers.ConsumerSingleObserver;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.rxjava3.internal.operators.single.SingleObserveOn;
import io.reactivex.rxjava3.internal.operators.single.SingleSubscribeOn;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class o implements r {
    public static o g(Callable callable) {
        Objects.requireNonNull(callable, "callable is null");
        return f7.a.m(new io.reactivex.rxjava3.internal.operators.single.b(callable));
    }

    public static o h(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return f7.a.m(new io.reactivex.rxjava3.internal.operators.single.c(obj));
    }

    public final y6.b a(a7.e eVar, a7.e eVar2) {
        Objects.requireNonNull(eVar, "onSuccess is null");
        Objects.requireNonNull(eVar2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(eVar, eVar2);
        c(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public final y6.b b(a7.e eVar) {
        return a(eVar, c7.a.f2313f);
    }

    @Override // x6.r
    public final void c(q qVar) {
        Objects.requireNonNull(qVar, "observer is null");
        q qVarV = f7.a.v(this, qVar);
        Objects.requireNonNull(qVarV, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            k(qVarV);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            z6.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final o d(a7.e eVar) {
        Objects.requireNonNull(eVar, "onSuccess is null");
        return f7.a.m(new io.reactivex.rxjava3.internal.operators.single.a(this, eVar));
    }

    public final f e(a7.h hVar) {
        Objects.requireNonNull(hVar, "predicate is null");
        return f7.a.k(new io.reactivex.rxjava3.internal.operators.maybe.c(this, hVar));
    }

    public final j f(a7.f fVar) {
        Objects.requireNonNull(fVar, "mapper is null");
        return f7.a.l(new SingleFlatMapIterableObservable(this, fVar));
    }

    public final o i(a7.f fVar) {
        Objects.requireNonNull(fVar, "mapper is null");
        return f7.a.m(new io.reactivex.rxjava3.internal.operators.single.d(this, fVar));
    }

    public final o j(n nVar) {
        Objects.requireNonNull(nVar, "scheduler is null");
        return f7.a.m(new SingleObserveOn(this, nVar));
    }

    public abstract void k(q qVar);

    public final o l(n nVar) {
        Objects.requireNonNull(nVar, "scheduler is null");
        return f7.a.m(new SingleSubscribeOn(this, nVar));
    }

    public final Object m(p pVar) {
        Objects.requireNonNull(pVar, "converter is null");
        return pVar.b(this);
    }
}
