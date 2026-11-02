package y6;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements b, c {

    /* renamed from: e, reason: collision with root package name */
    public io.reactivex.rxjava3.internal.util.c f14470e;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f14471j;

    @Override // y6.c
    public boolean a(b bVar) {
        Objects.requireNonNull(bVar, "disposable is null");
        if (this.f14471j) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f14471j) {
                    return false;
                }
                io.reactivex.rxjava3.internal.util.c cVar = this.f14470e;
                if (cVar != null && cVar.e(bVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // y6.c
    public boolean b(b bVar) {
        Objects.requireNonNull(bVar, "disposable is null");
        if (!this.f14471j) {
            synchronized (this) {
                try {
                    if (!this.f14471j) {
                        io.reactivex.rxjava3.internal.util.c cVar = this.f14470e;
                        if (cVar == null) {
                            cVar = new io.reactivex.rxjava3.internal.util.c();
                            this.f14470e = cVar;
                        }
                        cVar.a(bVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // y6.c
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
                    z6.a.b(th);
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

    @Override // y6.b
    public void dispose() {
        if (this.f14471j) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f14471j) {
                    return;
                }
                this.f14471j = true;
                io.reactivex.rxjava3.internal.util.c cVar = this.f14470e;
                this.f14470e = null;
                d(cVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y6.b
    public boolean isDisposed() {
        return this.f14471j;
    }
}
