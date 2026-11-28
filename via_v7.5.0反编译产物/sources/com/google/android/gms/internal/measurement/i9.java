package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i9 extends u7 implements RandomAccess, j9 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final i9 f2855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final j9 f2856n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f2857e;

    static {
        i9 i9Var = new i9(false);
        f2855m = i9Var;
        f2856n = i9Var;
    }

    public i9(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        super(true);
        this.f2857e = arrayList;
    }

    public static String g(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzka ? ((zzka) obj).zzm(h9.f2835b) : h9.d((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        c();
        this.f2857e.add(i10, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        c();
        if (collection instanceof j9) {
            collection = ((j9) collection).e();
        }
        boolean zAddAll = this.f2857e.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.f2857e.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final j9 d() {
        return b() ? new va(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final List e() {
        return Collections.unmodifiableList(this.f2857e);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final String get(int i10) {
        Object obj = this.f2857e.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzka) {
            zzka zzkaVar = (zzka) obj;
            String strZzm = zzkaVar.zzm(h9.f2835b);
            if (zzkaVar.zzi()) {
                this.f2857e.set(i10, strZzm);
            }
            return strZzm;
        }
        byte[] bArr = (byte[]) obj;
        String strD = h9.d(bArr);
        if (eb.d(bArr)) {
            this.f2857e.set(i10, strD);
        }
        return strD;
    }

    @Override // com.google.android.gms.internal.measurement.g9
    public final /* bridge */ /* synthetic */ g9 j(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f2857e);
        return new i9(arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final Object m(int i10) {
        return this.f2857e.get(i10);
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final void r(zzka zzkaVar) {
        c();
        this.f2857e.add(zzkaVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        c();
        Object objRemove = this.f2857e.remove(i10);
        ((AbstractList) this).modCount++;
        return g(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        c();
        return g(this.f2857e.set(i10, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2857e.size();
    }

    public i9(ArrayList arrayList) {
        super(true);
        this.f2857e = arrayList;
    }

    public i9(boolean z10) {
        super(false);
        this.f2857e = Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
