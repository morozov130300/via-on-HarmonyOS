package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class va extends AbstractList implements RandomAccess, j9 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j9 f3151c;

    public va(j9 j9Var) {
        this.f3151c = j9Var;
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final List e() {
        return this.f3151c.e();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((i9) this.f3151c).get(i10);
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
        return this.f3151c.m(i10);
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final void r(zzka zzkaVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3151c.size();
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final j9 d() {
        return this;
    }
}
