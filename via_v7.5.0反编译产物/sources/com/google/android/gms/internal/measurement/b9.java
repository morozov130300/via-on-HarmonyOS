package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b9 extends u7 implements RandomAccess, e9, ha {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b9 f2711n = new b9(new int[0], 0, false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f2712e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2713m;

    public b9(int[] iArr, int i10, boolean z10) {
        super(z10);
        this.f2712e = iArr;
        this.f2713m = i10;
    }

    public static b9 g() {
        return f2711n;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        int iIntValue = ((Integer) obj).intValue();
        c();
        if (i10 < 0 || i10 > (i11 = this.f2713m)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        int[] iArr = this.f2712e;
        if (i11 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i11 - i10);
        } else {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f2712e, i10, iArr2, i10 + 1, this.f2713m - i10);
            this.f2712e = iArr2;
        }
        this.f2712e[i10] = iIntValue;
        this.f2713m++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        c();
        Charset charset = h9.f2834a;
        collection.getClass();
        if (!(collection instanceof b9)) {
            return super.addAll(collection);
        }
        b9 b9Var = (b9) collection;
        int i10 = b9Var.f2713m;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2713m;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f2712e;
        if (i12 > iArr.length) {
            this.f2712e = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(b9Var.f2712e, 0, this.f2712e, this.f2713m, b9Var.f2713m);
        this.f2713m = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b9)) {
            return super.equals(obj);
        }
        b9 b9Var = (b9) obj;
        if (this.f2713m != b9Var.f2713m) {
            return false;
        }
        int[] iArr = b9Var.f2712e;
        for (int i10 = 0; i10 < this.f2713m; i10++) {
            if (this.f2712e[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final int f(int i10) {
        n(i10);
        return this.f2712e[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        n(i10);
        return Integer.valueOf(this.f2712e[i10]);
    }

    public final void h(int i10) {
        c();
        int i11 = this.f2713m;
        int[] iArr = this.f2712e;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f2712e = iArr2;
        }
        int[] iArr3 = this.f2712e;
        int i12 = this.f2713m;
        this.f2713m = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f2713m; i11++) {
            i10 = (i10 * 31) + this.f2712e[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i10 = this.f2713m;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f2712e[i11] == iIntValue) {
                return i11;
            }
        }
        return -1;
    }

    public final String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f2713m;
    }

    public final void n(int i10) {
        if (i10 < 0 || i10 >= this.f2713m) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.g9
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final e9 j(int i10) {
        if (i10 >= this.f2713m) {
            return new b9(Arrays.copyOf(this.f2712e, i10), this.f2713m, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        c();
        n(i10);
        int[] iArr = this.f2712e;
        int i11 = iArr[i10];
        int i12 = this.f2713m;
        if (i10 < i12 - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (i12 - i10) - 1);
        }
        this.f2713m--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        c();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f2712e;
        System.arraycopy(iArr, i11, iArr, i10, this.f2713m - i11);
        this.f2713m -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        c();
        n(i10);
        int[] iArr = this.f2712e;
        int i11 = iArr[i10];
        iArr[i10] = iIntValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2713m;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        h(((Integer) obj).intValue());
        return true;
    }
}
