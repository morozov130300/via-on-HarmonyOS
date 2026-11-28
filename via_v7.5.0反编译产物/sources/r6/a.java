package r6;

import io.reactivex.rxjava3.internal.observers.CallbackCompletableObserver;
import io.reactivex.rxjava3.internal.operators.completable.CompletableSubscribeOn;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c {
    public static a b() {
        return z6.a.j(io.reactivex.rxjava3.internal.operators.completable.b.f6447a);
    }

    public static a c(u6.j jVar) {
        Objects.requireNonNull(jVar, "supplier is null");
        return z6.a.j(new io.reactivex.rxjava3.internal.operators.completable.a(jVar));
    }

    public static a d(Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return z6.a.j(new io.reactivex.rxjava3.internal.operators.completable.c(th));
    }

    public static a e(u6.a aVar) {
        Objects.requireNonNull(aVar, "action is null");
        return z6.a.j(new io.reactivex.rxjava3.internal.operators.completable.d(aVar));
    }

    public static NullPointerException i(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // r6.c
    public final void a(b bVar) {
        Objects.requireNonNull(bVar, "observer is null");
        try {
            b bVarS = z6.a.s(this, bVar);
            Objects.requireNonNull(bVarS, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            g(bVarS);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            t6.a.b(th);
            z6.a.o(th);
            throw i(th);
        }
    }

    public final s6.b f(u6.a aVar, u6.f fVar) {
        Objects.requireNonNull(fVar, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(fVar, aVar);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public abstract void g(b bVar);

    public final a h(p pVar) {
        Objects.requireNonNull(pVar, "scheduler is null");
        return z6.a.j(new CompletableSubscribeOn(this, pVar));
    }
}
