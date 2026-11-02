package x6;

import io.reactivex.rxjava3.internal.observers.CallbackCompletableObserver;
import io.reactivex.rxjava3.internal.operators.completable.CompletableSubscribeOn;
import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a implements c {
    public static a b() {
        return f7.a.j(io.reactivex.rxjava3.internal.operators.completable.b.f7216a);
    }

    public static a c(a7.i iVar) {
        Objects.requireNonNull(iVar, "supplier is null");
        return f7.a.j(new io.reactivex.rxjava3.internal.operators.completable.a(iVar));
    }

    public static a d(Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return f7.a.j(new io.reactivex.rxjava3.internal.operators.completable.c(th));
    }

    public static a e(a7.a aVar) {
        Objects.requireNonNull(aVar, "action is null");
        return f7.a.j(new io.reactivex.rxjava3.internal.operators.completable.d(aVar));
    }

    public static NullPointerException i(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // x6.c
    public final void a(b bVar) {
        Objects.requireNonNull(bVar, "observer is null");
        try {
            b bVarS = f7.a.s(this, bVar);
            Objects.requireNonNull(bVarS, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            g(bVarS);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            z6.a.b(th);
            f7.a.o(th);
            throw i(th);
        }
    }

    public final y6.b f(a7.a aVar, a7.e eVar) {
        Objects.requireNonNull(eVar, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(eVar, aVar);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public abstract void g(b bVar);

    public final a h(n nVar) {
        Objects.requireNonNull(nVar, "scheduler is null");
        return f7.a.j(new CompletableSubscribeOn(this, nVar));
    }
}
