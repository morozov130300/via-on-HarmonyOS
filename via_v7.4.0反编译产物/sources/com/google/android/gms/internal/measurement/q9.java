package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q9 extends u7 implements RandomAccess, f9, ha {

    /* renamed from: l, reason: collision with root package name */
    public static final q9 f3706l = new q9(new long[0], 0, false);

    /* renamed from: j, reason: collision with root package name */
    public long[] f3707j;

    /* renamed from: k, reason: collision with root package name */
    public int f3708k;

    public q9(long[] jArr, int i10, boolean z10) {
        super(z10);
        this.f3707j = jArr;
        this.f3708k = i10;
    }

    public static q9 f() {
        return f3706l;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        long jLongValue = ((Long) obj).longValue();
        c();
        if (i10 < 0 || i10 > (i11 = this.f3708k)) {
            throw new IndexOutOfBoundsException(h(i10));
        }
        long[] jArr = this.f3707j;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f3707j, i10, jArr2, i10 + 1, this.f3708k - i10);
            this.f3707j = jArr2;
        }
        this.f3707j[i10] = jLongValue;
        this.f3708k++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Long) obj).longValue());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        c();
        Charset charset = h9.f3535a;
        collection.getClass();
        if (!(collection instanceof q9)) {
            return super.addAll(collection);
        }
        q9 q9Var = (q9) collection;
        int i10 = q9Var.f3708k;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f3708k;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f3707j;
        if (i12 > jArr.length) {
            this.f3707j = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(q9Var.f3707j, 0, this.f3707j, this.f3708k, q9Var.f3708k);
        this.f3708k = i12;
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
        if (this.f3708k != q9Var.f3708k) {
            return false;
        }
        long[] jArr = q9Var.f3707j;
        for (int i10 = 0; i10 < this.f3708k; i10++) {
            if (this.f3707j[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void g(long j10) {
        c();
        int i10 = this.f3708k;
        long[] jArr = this.f3707j;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f3707j = jArr2;
        }
        long[] jArr3 = this.f3707j;
        int i11 = this.f3708k;
        this.f3708k = i11 + 1;
        jArr3[i11] = j10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        k(i10);
        return Long.valueOf(this.f3707j[i10]);
    }

    public final String h(int i10) {
        return "Index:" + i10 + ", Size:" + this.f3708k;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f3708k; i11++) {
            long j10 = this.f3707j[i11];
            Charset charset = h9.f3535a;
            i10 = (i10 * 31) + ((int) (j10 ^ (j10 >>> 32)));
        }
        return i10;
    }

    @Override // com.google.android.gms.internal.measurement.f9
    public final long i(int i10) {
        k(i10);
        return this.f3707j[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i10 = this.f3708k;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f3707j[i11] == jLongValue) {
                return i11;
            }
        }
        return -1;
    }

    public final void k(int i10) {
        if (i10 < 0 || i10 >= this.f3708k) {
            throw new IndexOutOfBoundsException(h(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.g9
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final f9 j(int i10) {
        if (i10 >= this.f3708k) {
            return new q9(Arrays.copyOf(this.f3707j, i10), this.f3708k, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        c();
        k(i10);
        long[] jArr = this.f3707j;
        long j10 = jArr[i10];
        if (i10 < this.f3708k - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f3708k--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        c();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f3707j;
        System.arraycopy(jArr, i11, jArr, i10, this.f3708k - i11);
        this.f3708k -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        c();
        k(i10);
        long[] jArr = this.f3707j;
        long j10 = jArr[i10];
        jArr[i10] = jLongValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3708k;
    }
}
