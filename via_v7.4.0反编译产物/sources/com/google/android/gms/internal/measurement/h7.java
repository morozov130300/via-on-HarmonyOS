package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h7 extends r7 {

    /* renamed from: e, reason: collision with root package name */
    public final int f3529e;

    /* renamed from: j, reason: collision with root package name */
    public int f3530j;

    public h7(int i10, int i11) {
        b7.b(i11, i10, "index");
        this.f3529e = i10;
        this.f3530j = i11;
    }

    public abstract Object a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f3530j < this.f3529e;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3530j > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f3530j;
        this.f3530j = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3530j;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f3530j - 1;
        this.f3530j = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3530j - 1;
    }
}
