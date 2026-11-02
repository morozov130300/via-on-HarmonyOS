package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public final Object[] f8292e;

    /* renamed from: j, reason: collision with root package name */
    public int f8293j;

    public a(Object[] array) {
        h.f(array, "array");
        this.f8292e = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f8293j < this.f8292e.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f8292e;
            int i10 = this.f8293j;
            this.f8293j = i10 + 1;
            return objArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f8293j--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
