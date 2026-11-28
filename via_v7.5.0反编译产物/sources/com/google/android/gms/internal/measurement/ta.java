package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ta implements ListIterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ListIterator f3082c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3083e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ va f3084m;

    public ta(va vaVar, int i10) {
        this.f3084m = vaVar;
        this.f3083e = i10;
        this.f3082c = vaVar.f3151c.listIterator(i10);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f3082c.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3082c.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f3082c.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3082c.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f3082c.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3082c.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
