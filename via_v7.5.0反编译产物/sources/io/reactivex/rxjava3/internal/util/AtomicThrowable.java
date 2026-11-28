package io.reactivex.rxjava3.internal.util;

import java.util.concurrent.atomic.AtomicReference;
import r6.h;
import r6.o;
import r6.s;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean isTerminated() {
        return get() == ExceptionHelper.f6701a;
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
        z6.a.o(th);
        return false;
    }

    public void tryTerminateAndReport() {
        Throwable thTerminate = terminate();
        if (thTerminate == null || thTerminate == ExceptionHelper.f6701a) {
            return;
        }
        z6.a.o(thTerminate);
    }

    public void tryTerminateConsumer(sc.a aVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            aVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f6701a) {
            aVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(o oVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            oVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f6701a) {
            oVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(h hVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            hVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f6701a) {
            hVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(s sVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null || thTerminate == ExceptionHelper.f6701a) {
            return;
        }
        sVar.onError(thTerminate);
    }

    public void tryTerminateConsumer(r6.b bVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            bVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f6701a) {
            bVar.onError(thTerminate);
        }
    }

    public void tryTerminateConsumer(r6.d dVar) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            dVar.onComplete();
        } else if (thTerminate != ExceptionHelper.f6701a) {
            dVar.onError(thTerminate);
        }
    }
}
