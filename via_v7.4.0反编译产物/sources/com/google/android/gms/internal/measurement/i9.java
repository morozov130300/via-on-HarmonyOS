package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i9 extends u7 implements RandomAccess, j9 {

    /* renamed from: k, reason: collision with root package name */
    public static final i9 f3556k;

    /* renamed from: l, reason: collision with root package name */
    public static final j9 f3557l;

    /* renamed from: j, reason: collision with root package name */
    public final List f3558j;

    static {
        i9 i9Var = new i9(false);
        f3556k = i9Var;
        f3557l = i9Var;
    }

    public i9(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        super(true);
        this.f3558j = arrayList;
    }

    public i9(ArrayList arrayList) {
        super(true);
        this.f3558j = arrayList;
    }

    public i9(boolean z10) {
        super(false);
        this.f3558j = Collections.EMPTY_LIST;
    }

    public static String g(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzka ? ((zzka) obj).zzm(h9.f3536b) : h9.d((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        c();
        this.f3558j.add(i10, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        c();
        if (collection instanceof j9) {
            collection = ((j9) collection).e();
        }
        boolean zAddAll = this.f3558j.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.f3558j.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final j9 d() {
        return b() ? new va(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final List e() {
        return Collections.unmodifiableList(this.f3558j);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final String get(int i10) {
        Object obj = this.f3558j.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzka) {
            zzka zzkaVar = (zzka) obj;
            String strZzm = zzkaVar.zzm(h9.f3536b);
            if (zzkaVar.zzi()) {
                this.f3558j.set(i10, strZzm);
            }
            return strZzm;
        }
        byte[] bArr = (byte[]) obj;
        String strD = h9.d(bArr);
        if (eb.d(bArr)) {
            this.f3558j.set(i10, strD);
        }
        return strD;
    }

    @Override // com.google.android.gms.internal.measurement.g9
    public final /* bridge */ /* synthetic */ g9 j(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f3558j);
        return new i9(arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final Object m(int i10) {
        return this.f3558j.get(i10);
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final void r(zzka zzkaVar) {
        c();
        this.f3558j.add(zzkaVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        c();
        Object objRemove = this.f3558j.remove(i10);
        ((AbstractList) this).modCount++;
        return g(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        c();
        return g(this.f3558j.set(i10, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3558j.size();
    }
}
