package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q9 extends u7 implements RandomAccess, f9, ha {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final q9 f3005n = new q9(new long[0], 0, false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long[] f3006e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3007m;

    public q9(long[] jArr, int i10, boolean z10) {
        super(z10);
        this.f3006e = jArr;
        this.f3007m = i10;
    }

    public static q9 f() {
        return f3005n;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        long jLongValue = ((Long) obj).longValue();
        c();
        if (i10 < 0 || i10 > (i11 = this.f3007m)) {
            throw new IndexOutOfBoundsException(h(i10));
        }
        long[] jArr = this.f3006e;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f3006e, i10, jArr2, i10 + 1, this.f3007m - i10);
            this.f3006e = jArr2;
        }
        this.f3006e[i10] = jLongValue;
        this.f3007m++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        c();
        Charset charset = h9.f2834a;
        collection.getClass();
        if (!(collection instanceof q9)) {
            return super.addAll(collection);
        }
        q9 q9Var = (q9) collection;
        int i10 = q9Var.f3007m;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f3007m;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f3006e;
        if (i12 > jArr.length) {
            this.f3006e = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(q9Var.f3006e, 0, this.f3006e, this.f3007m, q9Var.f3007m);
        this.f3007m = i12;
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
        if (!(obj instanceof q9)) {
            return super.equals(obj);
        }
        q9 q9Var = (q9) obj;
        if (this.f3007m != q9Var.f3007m) {
            return false;
        }
        long[] jArr = q9Var.f3006e;
        for (int i10 = 0; i10 < this.f3007m; i10++) {
            if (this.f3006e[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void g(long j10) {
        c();
        int i10 = this.f3007m;
        long[] jArr = this.f3006e;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f3006e = jArr2;
        }
        long[] jArr3 = this.f3006e;
        int i11 = this.f3007m;
        this.f3007m = i11 + 1;
        jArr3[i11] = j10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        k(i10);
        return Long.valueOf(this.f3006e[i10]);
    }

    public final String h(int i10) {
        return "Index:" + i10 + ", Size:" + this.f3007m;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f3007m; i11++) {
            long j10 = this.f3006e[i11];
            Charset charset = h9.f2834a;
            i10 = (i10 * 31) + ((int) (j10 ^ (j10 >>> 32)));
        }
        return i10;
    }

    @Override // com.google.android.gms.internal.measurement.f9
    public final long i(int i10) {
        k(i10);
        return this.f3006e[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i10 = this.f3007m;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f3006e[i11] == jLongValue) {
                return i11;
            }
        }
        return -1;
    }

    public final void k(int i10) {
        if (i10 < 0 || i10 >= this.f3007m) {
            throw new IndexOutOfBoundsException(h(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.g9
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final f9 j(int i10) {
        if (i10 >= this.f3007m) {
            return new q9(Arrays.copyOf(this.f3006e, i10), this.f3007m, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        c();
        k(i10);
        long[] jArr = this.f3006e;
        long j10 = jArr[i10];
        int i11 = this.f3007m;
        if (i10 < i11 - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (i11 - i10) - 1);
        }
        this.f3007m--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        c();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f3006e;
        System.arraycopy(jArr, i11, jArr, i10, this.f3007m - i11);
        this.f3007m -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        c();
        k(i10);
        long[] jArr = this.f3006e;
        long j10 = jArr[i10];
        jArr[i10] = jLongValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3007m;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Long) obj).longValue());
        return true;
    }
}
