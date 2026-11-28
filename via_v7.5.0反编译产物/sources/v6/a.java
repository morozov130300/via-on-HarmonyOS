package v6;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import s6.b;
import s6.c;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b, c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f13424c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f13425e;

    @Override // s6.c
    public boolean a(b bVar) {
        Objects.requireNonNull(bVar, "Disposable item is null");
        if (this.f13425e) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f13425e) {
                    return false;
                }
                List list = this.f13424c;
                if (list != null && list.remove(bVar)) {
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
        Objects.requireNonNull(bVar, "d is null");
        if (!this.f13425e) {
            synchronized (this) {
                try {
                    if (!this.f13425e) {
                        List linkedList = this.f13424c;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f13424c = linkedList;
                        }
                        linkedList.add(bVar);
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

    public void d(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((b) it.next()).dispose();
            } catch (Throwable th) {
                t6.a.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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
        if (this.f13425e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f13425e) {
                    return;
                }
                this.f13425e = true;
                List list = this.f13424c;
                this.f13424c = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.f13425e;
    }
}
