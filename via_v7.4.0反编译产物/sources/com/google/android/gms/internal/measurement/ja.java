package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ja extends u7 implements RandomAccess {

    /* renamed from: l, reason: collision with root package name */
    public static final ja f3577l = new ja(new Object[0], 0, false);

    /* renamed from: j, reason: collision with root package name */
    public Object[] f3578j;

    /* renamed from: k, reason: collision with root package name */
    public int f3579k;

    public ja(Object[] objArr, int i10, boolean z10) {
        super(z10);
        this.f3578j = objArr;
        this.f3579k = i10;
    }

    public static ja f() {
        return f3577l;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        c();
        if (i10 < 0 || i10 > (i11 = this.f3579k)) {
            throw new IndexOutOfBoundsException(g(i10));
        }
        Object[] objArr = this.f3578j;
        if (i11 < objArr.length) {
            System.arraycopy(objArr, i10, objArr, i10 + 1, i11 - i10);
        } else {
            Object[] objArr2 = new Object[((i11 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i10);
            System.arraycopy(this.f3578j, i10, objArr2, i10 + 1, this.f3579k - i10);
            this.f3578j = objArr2;
        }
        this.f3578j[i10] = obj;
        this.f3579k++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        c();
        int i10 = this.f3579k;
        Object[] objArr = this.f3578j;
        if (i10 == objArr.length) {
            this.f3578j = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f3578j;
        int i11 = this.f3579k;
        this.f3579k = i11 + 1;
        objArr2[i11] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final String g(int i10) {
        return "Index:" + i10 + ", Size:" + this.f3579k;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        h(i10);
        return this.f3578j[i10];
    }

    public final void h(int i10) {
        if (i10 < 0 || i10 >= this.f3579k) {
            throw new IndexOutOfBoundsException(g(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.g9
    public final /* bridge */ /* synthetic */ g9 j(int i10) {
        if (i10 >= this.f3579k) {
            return new ja(Arrays.copyOf(this.f3578j, i10), this.f3579k, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.u7, java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        c();
        h(i10);
        Object[] objArr = this.f3578j;
        Object obj = objArr[i10];
        if (i10 < this.f3579k - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (r2 - i10) - 1);
        }
        this.f3579k--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        c();
        h(i10);
        Object[] objArr = this.f3578j;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3579k;
    }
}
