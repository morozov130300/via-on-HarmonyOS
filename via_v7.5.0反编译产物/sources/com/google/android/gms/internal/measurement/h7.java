package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h7 extends r7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2828c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2829e;

    public h7(int i10, int i11) {
        b7.b(i11, i10, "index");
        this.f2828c = i10;
        this.f2829e = i11;
    }

    public abstract Object a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f2829e < this.f2828c;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2829e > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f2829e;
        this.f2829e = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2829e;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f2829e - 1;
        this.f2829e = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2829e - 1;
    }
}
