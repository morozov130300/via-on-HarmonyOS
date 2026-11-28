package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ja extends u7 implements RandomAccess {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ja f2876n = new ja(new Object[0], 0, false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f2877e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2878m;

    public ja(Object[] objArr, int i10, boolean z10) {
        super(z10);
        this.f2877e = objArr;
        this.f2878m = i10;
    }

    public static ja f() {
        return f2876n;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        c();
        if (i10 < 0 || i10 > (i11 = this.f2878m)) {
            throw new IndexOutOfBoundsException(g(i10));
        }
        Object[] objArr = this.f2877e;
        if (i11 < objArr.length) {
            System.arraycopy(objArr, i10, objArr, i10 + 1, i11 - i10);
        } else {
            Object[] objArr2 = new Object[((i11 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i10);
            System.arraycopy(this.f2877e, i10, objArr2, i10 + 1, this.f2878m - i10);
            this.f2877e = objArr2;
        }
        this.f2877e[i10] = obj;
        this.f2878m++;
        ((AbstractList) this).modCount++;
    }

    public final String g(int i10) {
        return "Index:" + i10 + ", Size:" + this.f2878m;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        h(i10);
        return this.f2877e[i10];
    }

    public final void h(int i10) {
        if (i10 < 0 || i10 >= this.f2878m) {
            throw new IndexOutOfBoundsException(g(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.g9
    public final /* bridge */ /* synthetic */ g9 j(int i10) {
        if (i10 >= this.f2878m) {
            return new ja(Arrays.copyOf(this.f2877e, i10), this.f2878m, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        c();
        h(i10);
        Object[] objArr = this.f2877e;
        Object obj = objArr[i10];
        int i11 = this.f2878m;
        if (i10 < i11 - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (i11 - i10) - 1);
        }
        this.f2878m--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        c();
        h(i10);
        Object[] objArr = this.f2877e;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2878m;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        c();
        int i10 = this.f2878m;
        Object[] objArr = this.f2877e;
        if (i10 == objArr.length) {
            this.f2877e = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f2877e;
        int i11 = this.f2878m;
        this.f2878m = i11 + 1;
        objArr2[i11] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
