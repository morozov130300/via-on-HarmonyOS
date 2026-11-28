package r6;

import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDoFinally;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableObserveOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableZip;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements n {
    public static j B(n nVar, n nVar2) {
        Objects.requireNonNull(nVar, "source1 is null");
        Objects.requireNonNull(nVar2, "source2 is null");
        return u(nVar, nVar2).s(w6.a.c(), false, 2);
    }

    public static j O(n nVar, n nVar2, u6.b bVar) {
        Objects.requireNonNull(nVar, "source1 is null");
        Objects.requireNonNull(nVar2, "source2 is null");
        Objects.requireNonNull(bVar, "zipper is null");
        return P(w6.a.d(bVar), false, d(), nVar, nVar2);
    }

    public static j P(u6.g gVar, boolean z10, int i10, n... nVarArr) {
        Objects.requireNonNull(nVarArr, "sources is null");
        if (nVarArr.length == 0) {
            return o();
        }
        Objects.requireNonNull(gVar, "zipper is null");
        w6.b.b(i10, "bufferSize");
        return z6.a.l(new ObservableZip(nVarArr, null, gVar, i10, z10));
    }

    public static int d() {
        return e.a();
    }

    public static j f(m mVar) {
        Objects.requireNonNull(mVar, "source is null");
        return z6.a.l(new ObservableCreate(mVar));
    }

    public static j o() {
        return z6.a.l(io.reactivex.rxjava3.internal.operators.observable.d.f6546c);
    }

    public static j u(Object... objArr) {
        Objects.requireNonNull(objArr, "items is null");
        if (objArr.length == 0) {
            return o();
        }
        return objArr.length == 1 ? z(objArr[0]) : z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.f(objArr));
    }

    public static j v(Callable callable) {
        Objects.requireNonNull(callable, "callable is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.g(callable));
    }

    public static j w(Iterable iterable) {
        Objects.requireNonNull(iterable, "source is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.h(iterable));
    }

    public static j z(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.k(obj));
    }

    public final j A(u6.g gVar) {
        Objects.requireNonNull(gVar, "mapper is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.l(this, gVar));
    }

    public final j C(p pVar) {
        return D(pVar, false, d());
    }

    public final j D(p pVar, boolean z10, int i10) {
        Objects.requireNonNull(pVar, "scheduler is null");
        w6.b.b(i10, "bufferSize");
        return z6.a.l(new ObservableObserveOn(this, pVar, z10, i10));
    }

    public final j E(long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? z6.a.l(this) : z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.m(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 expected but it was " + j10);
    }

    public abstract void F(o oVar);

    public final j G(p pVar) {
        Objects.requireNonNull(pVar, "scheduler is null");
        return z6.a.l(new ObservableSubscribeOn(this, pVar));
    }

    public final j H(n nVar) {
        Objects.requireNonNull(nVar, "other is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.n(this, nVar));
    }

    public final j I(u6.g gVar) {
        return J(gVar, d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j J(u6.g gVar, int i10) {
        Objects.requireNonNull(gVar, "mapper is null");
        w6.b.b(i10, "bufferSize");
        if (!(this instanceof x6.c)) {
            return z6.a.l(new ObservableSwitchMap(this, gVar, i10, false));
        }
        Object obj = ((x6.c) this).get();
        return obj == null ? o() : ObservableScalarXMap.a(obj, gVar);
    }

    public final j K(u6.i iVar) {
        Objects.requireNonNull(iVar, "stopPredicate is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.o(this, iVar));
    }

    public final Object L(k kVar) {
        Objects.requireNonNull(kVar, "converter is null");
        return kVar.c(this);
    }

    public final q M() {
        return N(16);
    }

    public final q N(int i10) {
        w6.b.b(i10, "capacityHint");
        return z6.a.m(new io.reactivex.rxjava3.internal.operators.observable.p(this, i10));
    }

    public final s6.b a(u6.f fVar, u6.f fVar2) {
        return b(fVar, fVar2, w6.a.f13676c);
    }

    public final s6.b b(u6.f fVar, u6.f fVar2, u6.a aVar) {
        Objects.requireNonNull(fVar, "onNext is null");
        Objects.requireNonNull(fVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        LambdaObserver lambdaObserver = new LambdaObserver(fVar, fVar2, aVar, w6.a.b());
        c(lambdaObserver);
        return lambdaObserver;
    }

    @Override // r6.n
    public final void c(o oVar) {
        Objects.requireNonNull(oVar, "observer is null");
        try {
            o oVarU = z6.a.u(this, oVar);
            Objects.requireNonNull(oVarU, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            F(oVarU);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            t6.a.b(th);
            z6.a.o(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final j e(i iVar) {
        Objects.requireNonNull(iVar, "other is null");
        return z6.a.l(new ObservableConcatWithMaybe(this, iVar));
    }

    public final j g(long j10, TimeUnit timeUnit) {
        return h(j10, timeUnit, a7.a.a());
    }

    public final j h(long j10, TimeUnit timeUnit, p pVar) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(pVar, "scheduler is null");
        return z6.a.l(new ObservableDebounceTimed(this, j10, timeUnit, pVar));
    }

    public final j i() {
        return j(w6.a.c());
    }

    public final j j(u6.g gVar) {
        Objects.requireNonNull(gVar, "keySelector is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.b(this, gVar, w6.b.a()));
    }

    public final j k(u6.a aVar) {
        Objects.requireNonNull(aVar, "onFinally is null");
        return z6.a.l(new ObservableDoFinally(this, aVar));
    }

    public final j l(u6.a aVar) {
        return m(w6.a.b(), w6.a.b(), aVar, w6.a.f13676c);
    }

    public final j m(u6.f fVar, u6.f fVar2, u6.a aVar, u6.a aVar2) {
        Objects.requireNonNull(fVar, "onNext is null");
        Objects.requireNonNull(fVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        Objects.requireNonNull(aVar2, "onAfterTerminate is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.c(this, fVar, fVar2, aVar, aVar2));
    }

    public final j n(u6.f fVar) {
        u6.f fVarB = w6.a.b();
        u6.a aVar = w6.a.f13676c;
        return m(fVar, fVarB, aVar, aVar);
    }

    public final j p(u6.i iVar) {
        Objects.requireNonNull(iVar, "predicate is null");
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.e(this, iVar));
    }

    public final j q(u6.g gVar) {
        return r(gVar, false);
    }

    public final j r(u6.g gVar, boolean z10) {
        return s(gVar, z10, Integer.MAX_VALUE);
    }

    public final j s(u6.g gVar, boolean z10, int i10) {
        return t(gVar, z10, i10, d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j t(u6.g gVar, boolean z10, int i10, int i11) {
        Objects.requireNonNull(gVar, "mapper is null");
        w6.b.b(i10, "maxConcurrency");
        w6.b.b(i11, "bufferSize");
        if (!(this instanceof x6.c)) {
            return z6.a.l(new ObservableFlatMap(this, gVar, z10, i10, i11));
        }
        Object obj = ((x6.c) this).get();
        return obj == null ? o() : ObservableScalarXMap.a(obj, gVar);
    }

    public final j x() {
        return z6.a.l(new io.reactivex.rxjava3.internal.operators.observable.i(this));
    }

    public final a y() {
        return z6.a.j(new io.reactivex.rxjava3.internal.operators.observable.j(this));
    }
}
