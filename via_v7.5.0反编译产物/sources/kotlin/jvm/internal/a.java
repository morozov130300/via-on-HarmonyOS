package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f7306c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7307e;

    public a(Object[] array) {
        h.f(array, "array");
        this.f7306c = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7307e < this.f7306c.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f7306c;
            int i10 = this.f7307e;
            this.f7307e = i10 + 1;
            return objArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f7307e--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
