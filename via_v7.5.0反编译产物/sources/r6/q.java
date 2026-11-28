package r6;

import io.reactivex.rxjava3.internal.observers.ConsumerSingleObserver;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.rxjava3.internal.operators.single.SingleObserveOn;
import io.reactivex.rxjava3.internal.operators.single.SingleSubscribeOn;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class q implements t {
    public static q f(Callable callable) {
        Objects.requireNonNull(callable, "callable is null");
        return z6.a.m(new io.reactivex.rxjava3.internal.operators.single.a(callable));
    }

    public static q g(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return z6.a.m(new io.reactivex.rxjava3.internal.operators.single.b(obj));
    }

    public final s6.b a(u6.f fVar, u6.f fVar2) {
        Objects.requireNonNull(fVar, "onSuccess is null");
        Objects.requireNonNull(fVar2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(fVar, fVar2);
        c(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public final s6.b b(u6.f fVar) {
        return a(fVar, w6.a.f13679f);
    }

    @Override // r6.t
    public final void c(s sVar) {
        Objects.requireNonNull(sVar, "observer is null");
        s sVarV = z6.a.v(this, sVar);
        Objects.requireNonNull(sVarV, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            j(sVarV);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            t6.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final f d(u6.i iVar) {
        Objects.requireNonNull(iVar, "predicate is null");
        return z6.a.k(new io.reactivex.rxjava3.internal.operators.maybe.c(this, iVar));
    }

    public final j e(u6.g gVar) {
        Objects.requireNonNull(gVar, "mapper is null");
        return z6.a.l(new SingleFlatMapIterableObservable(this, gVar));
    }

    public final q h(u6.g gVar) {
        Objects.requireNonNull(gVar, "mapper is null");
        return z6.a.m(new io.reactivex.rxjava3.internal.operators.single.c(this, gVar));
    }

    public final q i(p pVar) {
        Objects.requireNonNull(pVar, "scheduler is null");
        return z6.a.m(new SingleObserveOn(this, pVar));
    }

    public abstract void j(s sVar);

    public final q k(p pVar) {
        Objects.requireNonNull(pVar, "scheduler is null");
        return z6.a.m(new SingleSubscribeOn(this, pVar));
    }

    public final Object l(r rVar) {
        Objects.requireNonNull(rVar, "converter is null");
        return rVar.b(this);
    }
}
