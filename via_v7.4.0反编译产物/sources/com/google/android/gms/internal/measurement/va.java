package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class va extends AbstractList implements RandomAccess, j9 {

    /* renamed from: e, reason: collision with root package name */
    public final j9 f3852e;

    public va(j9 j9Var) {
        this.f3852e = j9Var;
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final j9 d() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final List e() {
        return this.f3852e.e();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((i9) this.f3852e).get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new ua(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        return new ta(this, i10);
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final Object m(int i10) {
        return this.f3852e.m(i10);
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final void r(zzka zzkaVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3852e.size();
    }
}
