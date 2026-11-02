package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ta implements ListIterator {

    /* renamed from: e, reason: collision with root package name */
    public final ListIterator f3783e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3784j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ va f3785k;

    public ta(va vaVar, int i10) {
        this.f3785k = vaVar;
        this.f3784j = i10;
        this.f3783e = vaVar.f3852e.listIterator(i10);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f3783e.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3783e.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f3783e.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3783e.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f3783e.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3783e.previousIndex();
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
