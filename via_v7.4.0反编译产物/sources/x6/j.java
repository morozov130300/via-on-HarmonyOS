package x6;

import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableObserveOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableZip;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class j implements l {
    public static j L(l lVar, l lVar2, a7.b bVar) {
        Objects.requireNonNull(lVar, "source1 is null");
        Objects.requireNonNull(lVar2, "source2 is null");
        Objects.requireNonNull(bVar, "zipper is null");
        return M(c7.a.d(bVar), false, d(), lVar, lVar2);
    }

    public static j M(a7.f fVar, boolean z10, int i10, l... lVarArr) {
        Objects.requireNonNull(lVarArr, "sources is null");
        if (lVarArr.length == 0) {
            return l();
        }
        Objects.requireNonNull(fVar, "zipper is null");
        c7.b.b(i10, "bufferSize");
        return f7.a.l(new ObservableZip(lVarArr, null, fVar, i10, z10));
    }

    public static int d() {
        return e.a();
    }

    public static j l() {
        return f7.a.l(io.reactivex.rxjava3.internal.operators.observable.d.f7313e);
    }

    public static j r(Object... objArr) {
        Objects.requireNonNull(objArr, "items is null");
        return objArr.length == 0 ? l() : objArr.length == 1 ? w(objArr[0]) : f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.f(objArr));
    }

    public static j s(Callable callable) {
        Objects.requireNonNull(callable, "callable is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.g(callable));
    }

    public static j t(Iterable iterable) {
        Objects.requireNonNull(iterable, "source is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.h(iterable));
    }

    public static j w(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.k(obj));
    }

    public static j y(l lVar, l lVar2) {
        Objects.requireNonNull(lVar, "source1 is null");
        Objects.requireNonNull(lVar2, "source2 is null");
        return r(lVar, lVar2).p(c7.a.c(), false, 2);
    }

    public final j A(n nVar, boolean z10, int i10) {
        Objects.requireNonNull(nVar, "scheduler is null");
        c7.b.b(i10, "bufferSize");
        return f7.a.l(new ObservableObserveOn(this, nVar, z10, i10));
    }

    public final j B(long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? f7.a.l(this) : f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.m(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 expected but it was " + j10);
    }

    public abstract void C(m mVar);

    public final j D(n nVar) {
        Objects.requireNonNull(nVar, "scheduler is null");
        return f7.a.l(new ObservableSubscribeOn(this, nVar));
    }

    public final j E(l lVar) {
        Objects.requireNonNull(lVar, "other is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.n(this, lVar));
    }

    public final j F(a7.f fVar) {
        return G(fVar, d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j G(a7.f fVar, int i10) {
        Objects.requireNonNull(fVar, "mapper is null");
        c7.b.b(i10, "bufferSize");
        if (!(this instanceof d7.c)) {
            return f7.a.l(new ObservableSwitchMap(this, fVar, i10, false));
        }
        Object obj = ((d7.c) this).get();
        return obj == null ? l() : ObservableScalarXMap.a(obj, fVar);
    }

    public final j H(a7.h hVar) {
        Objects.requireNonNull(hVar, "stopPredicate is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.o(this, hVar));
    }

    public final Object I(k kVar) {
        Objects.requireNonNull(kVar, "converter is null");
        return kVar.c(this);
    }

    public final o J() {
        return K(16);
    }

    public final o K(int i10) {
        c7.b.b(i10, "capacityHint");
        return f7.a.m(new io.reactivex.rxjava3.internal.operators.observable.p(this, i10));
    }

    public final y6.b a(a7.e eVar, a7.e eVar2) {
        return c(eVar, eVar2, c7.a.f2310c);
    }

    @Override // x6.l
    public final void b(m mVar) {
        Objects.requireNonNull(mVar, "observer is null");
        try {
            m mVarU = f7.a.u(this, mVar);
            Objects.requireNonNull(mVarU, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            C(mVarU);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            z6.a.b(th);
            f7.a.o(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final y6.b c(a7.e eVar, a7.e eVar2, a7.a aVar) {
        Objects.requireNonNull(eVar, "onNext is null");
        Objects.requireNonNull(eVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        LambdaObserver lambdaObserver = new LambdaObserver(eVar, eVar2, aVar, c7.a.b());
        b(lambdaObserver);
        return lambdaObserver;
    }

    public final j e(i iVar) {
        Objects.requireNonNull(iVar, "other is null");
        return f7.a.l(new ObservableConcatWithMaybe(this, iVar));
    }

    public final j f(long j10, TimeUnit timeUnit) {
        return g(j10, timeUnit, g7.a.a());
    }

    public final j g(long j10, TimeUnit timeUnit, n nVar) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(nVar, "scheduler is null");
        return f7.a.l(new ObservableDebounceTimed(this, j10, timeUnit, nVar));
    }

    public final j h() {
        return i(c7.a.c());
    }

    public final j i(a7.f fVar) {
        Objects.requireNonNull(fVar, "keySelector is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.b(this, fVar, c7.b.a()));
    }

    public final j j(a7.a aVar) {
        return k(c7.a.b(), c7.a.b(), aVar, c7.a.f2310c);
    }

    public final j k(a7.e eVar, a7.e eVar2, a7.a aVar, a7.a aVar2) {
        Objects.requireNonNull(eVar, "onNext is null");
        Objects.requireNonNull(eVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        Objects.requireNonNull(aVar2, "onAfterTerminate is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.c(this, eVar, eVar2, aVar, aVar2));
    }

    public final j m(a7.h hVar) {
        Objects.requireNonNull(hVar, "predicate is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.e(this, hVar));
    }

    public final j n(a7.f fVar) {
        return o(fVar, false);
    }

    public final j o(a7.f fVar, boolean z10) {
        return p(fVar, z10, Integer.MAX_VALUE);
    }

    public final j p(a7.f fVar, boolean z10, int i10) {
        return q(fVar, z10, i10, d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j q(a7.f fVar, boolean z10, int i10, int i11) {
        Objects.requireNonNull(fVar, "mapper is null");
        c7.b.b(i10, "maxConcurrency");
        c7.b.b(i11, "bufferSize");
        if (!(this instanceof d7.c)) {
            return f7.a.l(new ObservableFlatMap(this, fVar, z10, i10, i11));
        }
        Object obj = ((d7.c) this).get();
        return obj == null ? l() : ObservableScalarXMap.a(obj, fVar);
    }

    public final j u() {
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.i(this));
    }

    public final a v() {
        return f7.a.j(new io.reactivex.rxjava3.internal.operators.observable.j(this));
    }

    public final j x(a7.f fVar) {
        Objects.requireNonNull(fVar, "mapper is null");
        return f7.a.l(new io.reactivex.rxjava3.internal.operators.observable.l(this, fVar));
    }

    public final j z(n nVar) {
        return A(nVar, false, d());
    }
}
