package b7;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import y6.b;
import y6.c;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements b, c {

    /* renamed from: e, reason: collision with root package name */
    public List f1843e;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f1844j;

    @Override // y6.c
    public boolean a(b bVar) {
        Objects.requireNonNull(bVar, "Disposable item is null");
        if (this.f1844j) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f1844j) {
                    return false;
                }
                List list = this.f1843e;
                if (list != null && list.remove(bVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // y6.c
    public boolean b(b bVar) {
        Objects.requireNonNull(bVar, "d is null");
        if (!this.f1844j) {
            synchronized (this) {
                try {
                    if (!this.f1844j) {
                        List linkedList = this.f1843e;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f1843e = linkedList;
                        }
                        linkedList.add(bVar);
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
                z6.a.b(th);
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

    @Override // y6.b
    public void dispose() {
        if (this.f1844j) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f1844j) {
                    return;
                }
                this.f1844j = true;
                List list = this.f1843e;
                this.f1843e = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y6.b
    public boolean isDisposed() {
        return this.f1844j;
    }
}
