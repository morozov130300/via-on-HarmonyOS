package u7;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g extends h implements Iterator, h7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12889c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f12890e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Iterator f12891m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h7.a f12892n;

    @Override // u7.h
    public Object a(Object obj, h7.a aVar) {
        this.f12890e = obj;
        this.f12889c = 3;
        this.f12892n = aVar;
        Object objB = kotlin.coroutines.intrinsics.a.b();
        if (objB == kotlin.coroutines.intrinsics.a.b()) {
            i7.e.c(aVar);
        }
        return objB == kotlin.coroutines.intrinsics.a.b() ? objB : d7.h.f3935a;
    }

    public final Throwable b() {
        int i10 = this.f12889c;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f12889c);
    }

    public final Object c() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void d(h7.a aVar) {
        this.f12892n = aVar;
    }

    @Override // h7.a
    public kotlin.coroutines.b getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i10 = this.f12889c;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator it = this.f12891m;
                kotlin.jvm.internal.h.c(it);
                if (it.hasNext()) {
                    this.f12889c = 2;
                    return true;
                }
                this.f12891m = null;
            }
            this.f12889c = 5;
            h7.a aVar = this.f12892n;
            kotlin.jvm.internal.h.c(aVar);
            this.f12892n = null;
            Result.a aVar2 = Result.Companion;
            aVar.resumeWith(Result.m9constructorimpl(d7.h.f3935a));
        }
    }

    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i10 = this.f12889c;
        if (i10 == 0 || i10 == 1) {
            return c();
        }
        if (i10 == 2) {
            this.f12889c = 1;
            Iterator it = this.f12891m;
            kotlin.jvm.internal.h.c(it);
            return it.next();
        }
        if (i10 != 3) {
            throw b();
        }
        this.f12889c = 0;
        Object obj = this.f12890e;
        this.f12890e = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // h7.a
    public void resumeWith(Object obj) throws Throwable {
        kotlin.b.b(obj);
        this.f12889c = 4;
    }
}
