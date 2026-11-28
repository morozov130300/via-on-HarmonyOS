package s6;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b, c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.reactivex.rxjava3.internal.util.c f12213c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f12214e;

    @Override // s6.c
    public boolean a(b bVar) {
        Objects.requireNonNull(bVar, "disposable is null");
        if (this.f12214e) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f12214e) {
                    return false;
                }
                io.reactivex.rxjava3.internal.util.c cVar = this.f12213c;
                if (cVar != null && cVar.e(bVar)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s6.c
    public boolean b(b bVar) {
        Objects.requireNonNull(bVar, "disposable is null");
        if (!this.f12214e) {
            synchronized (this) {
                try {
                    if (!this.f12214e) {
                        io.reactivex.rxjava3.internal.util.c cVar = this.f12213c;
                        if (cVar == null) {
                            cVar = new io.reactivex.rxjava3.internal.util.c();
                            this.f12213c = cVar;
                        }
                        cVar.a(bVar);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // s6.c
    public boolean c(b bVar) {
        if (!a(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    public void d(io.reactivex.rxjava3.internal.util.c cVar) {
        if (cVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : cVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    t6.a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.f((Throwable) arrayList.get(0));
        }
    }

    @Override // s6.b
    public void dispose() {
        if (this.f12214e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f12214e) {
                    return;
                }
                this.f12214e = true;
                io.reactivex.rxjava3.internal.util.c cVar = this.f12213c;
                this.f12213c = null;
                d(cVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.f12214e;
    }
}
