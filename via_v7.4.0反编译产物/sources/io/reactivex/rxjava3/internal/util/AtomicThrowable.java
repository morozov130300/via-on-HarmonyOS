package io.reactivex.rxjava3.internal.util;

import java.util.concurrent.atomic.AtomicReference;
import x6.h;
import x6.m;
import x6.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean isTerminated() {
        return get() == ExceptionHelper.f7466a;
    }

    public Throwable terminate() {
        return ExceptionHelper.e(this);
    }

    public boolean tryAddThrowable(Throwable th) {
        return ExceptionHelper.a(this, th);
    }

    public boolean tryAddThrowableOrReport(Throwable th) {
        if (tryAddThrowable(th)) {
            return true;
        }
        f7.a.o(th);
        return false;
    }

    public void tryTerminateAndReport() {
        Throwable thTerminate = terminate();
        if (thTerminate == null || thTerminate == ExceptionHelper.f7466a) {
            return;
        }
        f7.a.o(thTerminate);
    }

    public void tryTerminateConsumer(oc.a aVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            aVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f7466a) {
            aVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(x6.b bVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            bVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f7466a) {
            bVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(x6.d dVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            dVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f7466a) {
            dVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(h hVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            hVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f7466a) {
            hVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(m mVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            mVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f7466a) {
            mVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(q qVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null || thTerminate == ExceptionHelper.f7466a) {
            return;
        }
        qVar.onError(thTerminate);
    }
}
