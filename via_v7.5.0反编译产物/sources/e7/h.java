package e7;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f4276n = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object[] f4277o = new Object[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4278c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f4279e = f4277o;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4280m;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public a() {
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        s();
        h(size() + elements.size());
        c(p(this.f4278c + size()), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        s();
        h(size() + 1);
        int iG = g(this.f4278c);
        this.f4278c = iG;
        this.f4279e[iG] = obj;
        this.f4280m = size() + 1;
    }

    public final void addLast(Object obj) {
        s();
        h(size() + 1);
        this.f4279e[p(this.f4278c + size())] = obj;
        this.f4280m = size() + 1;
    }

    public final void c(int i10, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f4279e.length;
        while (i10 < length && it.hasNext()) {
            this.f4279e[i10] = it.next();
            i10++;
        }
        int i11 = this.f4278c;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f4279e[i12] = it.next();
        }
        this.f4280m = size() + collection.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            s();
            o(this.f4278c, p(this.f4278c + size()));
        }
        this.f4278c = 0;
        this.f4280m = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void f(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f4279e;
        k.d(objArr2, objArr, 0, this.f4278c, objArr2.length);
        Object[] objArr3 = this.f4279e;
        int length = objArr3.length;
        int i11 = this.f4278c;
        k.d(objArr3, objArr, length - i11, 0, i11);
        this.f4278c = 0;
        this.f4279e = objArr;
    }

    public final int g(int i10) {
        return i10 == 0 ? l.n(this.f4279e) : i10 - 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        c.Companion.a(i10, size());
        return this.f4279e[p(this.f4278c + i10)];
    }

    @Override // e7.e
    public int getSize() {
        return this.f4280m;
    }

    public final void h(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f4279e;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f4277o) {
            this.f4279e = new Object[s7.e.a(i10, 10)];
        } else {
            f(c.Companion.d(objArr.length, i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i10;
        int iP = p(this.f4278c + size());
        int length = this.f4278c;
        if (length < iP) {
            while (length < iP) {
                if (kotlin.jvm.internal.h.a(obj, this.f4279e[length])) {
                    i10 = this.f4278c;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iP) {
            return -1;
        }
        int length2 = this.f4279e.length;
        while (length < length2) {
            if (kotlin.jvm.internal.h.a(obj, this.f4279e[length])) {
                i10 = this.f4278c;
            } else {
                length++;
            }
        }
        for (int i11 = 0; i11 < iP; i11++) {
            if (kotlin.jvm.internal.h.a(obj, this.f4279e[i11])) {
                length = i11 + this.f4279e.length;
                i10 = this.f4278c;
            }
        }
        return -1;
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int k(int i10) {
        if (i10 == l.n(this.f4279e)) {
            return 0;
        }
        return i10 + 1;
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.f4279e[p(this.f4278c + o.j(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iN;
        int i10;
        int iP = p(this.f4278c + size());
        int i11 = this.f4278c;
        if (i11 < iP) {
            iN = iP - 1;
            if (i11 <= iN) {
                while (!kotlin.jvm.internal.h.a(obj, this.f4279e[iN])) {
                    if (iN != i11) {
                        iN--;
                    }
                }
                i10 = this.f4278c;
                return iN - i10;
            }
            return -1;
        }
        if (i11 > iP) {
            for (int i12 = iP - 1; -1 < i12; i12--) {
                if (kotlin.jvm.internal.h.a(obj, this.f4279e[i12])) {
                    iN = i12 + this.f4279e.length;
                    i10 = this.f4278c;
                    return iN - i10;
                }
            }
            iN = l.n(this.f4279e);
            int i13 = this.f4278c;
            if (i13 <= iN) {
                while (!kotlin.jvm.internal.h.a(obj, this.f4279e[iN])) {
                    if (iN != i13) {
                        iN--;
                    }
                }
                i10 = this.f4278c;
                return iN - i10;
            }
        }
        return -1;
    }

    public final int n(int i10) {
        return i10 < 0 ? i10 + this.f4279e.length : i10;
    }

    public final void o(int i10, int i11) {
        if (i10 < i11) {
            k.g(this.f4279e, null, i10, i11);
            return;
        }
        Object[] objArr = this.f4279e;
        k.g(objArr, null, i10, objArr.length);
        k.g(this.f4279e, null, 0, i11);
    }

    public final int p(int i10) {
        Object[] objArr = this.f4279e;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection elements) {
        int iP;
        kotlin.jvm.internal.h.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f4279e.length != 0) {
            int iP2 = p(this.f4278c + size());
            int i10 = this.f4278c;
            if (i10 < iP2) {
                iP = i10;
                while (i10 < iP2) {
                    Object obj = this.f4279e[i10];
                    if (elements.contains(obj)) {
                        z10 = true;
                    } else {
                        this.f4279e[iP] = obj;
                        iP++;
                    }
                    i10++;
                }
                k.g(this.f4279e, null, iP, iP2);
            } else {
                int length = this.f4279e.length;
                int i11 = i10;
                boolean z11 = false;
                while (i10 < length) {
                    Object[] objArr = this.f4279e;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.f4279e[i11] = obj2;
                        i11++;
                    }
                    i10++;
                }
                iP = p(i11);
                for (int i12 = 0; i12 < iP2; i12++) {
                    Object[] objArr2 = this.f4279e;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.f4279e[iP] = obj3;
                        iP = k(iP);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                s();
                this.f4280m = n(iP - this.f4278c);
            }
        }
        return z10;
    }

    @Override // e7.e
    public Object removeAt(int i10) {
        c.Companion.a(i10, size());
        if (i10 == o.j(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        s();
        int iP = p(this.f4278c + i10);
        Object obj = this.f4279e[iP];
        if (i10 < (size() >> 1)) {
            int i11 = this.f4278c;
            if (iP >= i11) {
                Object[] objArr = this.f4279e;
                k.d(objArr, objArr, i11 + 1, i11, iP);
            } else {
                Object[] objArr2 = this.f4279e;
                k.d(objArr2, objArr2, 1, 0, iP);
                Object[] objArr3 = this.f4279e;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i12 = this.f4278c;
                k.d(objArr3, objArr3, i12 + 1, i12, objArr3.length - 1);
            }
            Object[] objArr4 = this.f4279e;
            int i13 = this.f4278c;
            objArr4[i13] = null;
            this.f4278c = k(i13);
        } else {
            int iP2 = p(this.f4278c + o.j(this));
            if (iP <= iP2) {
                Object[] objArr5 = this.f4279e;
                k.d(objArr5, objArr5, iP, iP + 1, iP2 + 1);
            } else {
                Object[] objArr6 = this.f4279e;
                k.d(objArr6, objArr6, iP, iP + 1, objArr6.length);
                Object[] objArr7 = this.f4279e;
                objArr7[objArr7.length - 1] = objArr7[0];
                k.d(objArr7, objArr7, 0, 1, iP2 + 1);
            }
            this.f4279e[iP2] = null;
        }
        this.f4280m = size() - 1;
        return obj;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        s();
        Object[] objArr = this.f4279e;
        int i10 = this.f4278c;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f4278c = k(i10);
        this.f4280m = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        s();
        int iP = p(this.f4278c + o.j(this));
        Object[] objArr = this.f4279e;
        Object obj = objArr[iP];
        objArr[iP] = null;
        this.f4280m = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        c.Companion.c(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == 0) {
            return;
        }
        if (i12 == size()) {
            clear();
            return;
        }
        if (i12 == 1) {
            remove(i10);
            return;
        }
        s();
        if (i10 < size() - i11) {
            t(i10, i11);
            int iP = p(this.f4278c + i12);
            o(this.f4278c, iP);
            this.f4278c = iP;
        } else {
            u(i10, i11);
            int iP2 = p(this.f4278c + size());
            o(n(iP2 - i12), iP2);
        }
        this.f4280m = size() - i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection elements) {
        int iP;
        kotlin.jvm.internal.h.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f4279e.length != 0) {
            int iP2 = p(this.f4278c + size());
            int i10 = this.f4278c;
            if (i10 < iP2) {
                iP = i10;
                while (i10 < iP2) {
                    Object obj = this.f4279e[i10];
                    if (elements.contains(obj)) {
                        this.f4279e[iP] = obj;
                        iP++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                k.g(this.f4279e, null, iP, iP2);
            } else {
                int length = this.f4279e.length;
                int i11 = i10;
                boolean z11 = false;
                while (i10 < length) {
                    Object[] objArr = this.f4279e;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        this.f4279e[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                iP = p(i11);
                for (int i12 = 0; i12 < iP2; i12++) {
                    Object[] objArr2 = this.f4279e;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        this.f4279e[iP] = obj3;
                        iP = k(iP);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                s();
                this.f4280m = n(iP - this.f4278c);
            }
        }
        return z10;
    }

    public final void s() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i10, Object obj) {
        c.Companion.a(i10, size());
        int iP = p(this.f4278c + i10);
        Object[] objArr = this.f4279e;
        Object obj2 = objArr[iP];
        objArr[iP] = obj;
        return obj2;
    }

    public final void t(int i10, int i11) {
        int iP = p(this.f4278c + (i10 - 1));
        int iP2 = p(this.f4278c + (i11 - 1));
        while (i10 > 0) {
            int i12 = iP + 1;
            int iMin = Math.min(i10, Math.min(i12, iP2 + 1));
            Object[] objArr = this.f4279e;
            int i13 = iP2 - iMin;
            int i14 = iP - iMin;
            k.d(objArr, objArr, i13 + 1, i14 + 1, i12);
            iP = n(i14);
            iP2 = n(i13);
            i10 -= iMin;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.h.f(array, "array");
        if (array.length < size()) {
            array = i.a(array, size());
        }
        Object[] objArr = array;
        int iP = p(this.f4278c + size());
        int i10 = this.f4278c;
        if (i10 < iP) {
            k.e(this.f4279e, objArr, 0, i10, iP, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f4279e;
            k.d(objArr2, objArr, 0, this.f4278c, objArr2.length);
            Object[] objArr3 = this.f4279e;
            k.d(objArr3, objArr, objArr3.length - this.f4278c, 0, iP);
        }
        return n.f(size(), objArr);
    }

    public final void u(int i10, int i11) {
        int iP = p(this.f4278c + i11);
        int iP2 = p(this.f4278c + i10);
        int size = size();
        while (true) {
            size -= i11;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.f4279e;
            i11 = Math.min(size, Math.min(objArr.length - iP, objArr.length - iP2));
            Object[] objArr2 = this.f4279e;
            int i12 = iP + i11;
            k.d(objArr2, objArr2, iP2, iP, i12);
            iP = p(i12);
            iP2 = p(iP2 + i11);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        c.Companion.b(i10, size());
        if (i10 == size()) {
            addLast(obj);
            return;
        }
        if (i10 == 0) {
            addFirst(obj);
            return;
        }
        s();
        h(size() + 1);
        int iP = p(this.f4278c + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int iG = g(iP);
            int iG2 = g(this.f4278c);
            int i11 = this.f4278c;
            if (iG >= i11) {
                Object[] objArr = this.f4279e;
                objArr[iG2] = objArr[i11];
                k.d(objArr, objArr, i11, i11 + 1, iG + 1);
            } else {
                Object[] objArr2 = this.f4279e;
                k.d(objArr2, objArr2, i11 - 1, i11, objArr2.length);
                Object[] objArr3 = this.f4279e;
                objArr3[objArr3.length - 1] = objArr3[0];
                k.d(objArr3, objArr3, 0, 1, iG + 1);
            }
            this.f4279e[iG] = obj;
            this.f4278c = iG2;
        } else {
            int iP2 = p(this.f4278c + size());
            if (iP < iP2) {
                Object[] objArr4 = this.f4279e;
                k.d(objArr4, objArr4, iP + 1, iP, iP2);
            } else {
                Object[] objArr5 = this.f4279e;
                k.d(objArr5, objArr5, 1, 0, iP2);
                Object[] objArr6 = this.f4279e;
                objArr6[0] = objArr6[objArr6.length - 1];
                k.d(objArr6, objArr6, iP + 1, iP, objArr6.length - 1);
            }
            this.f4279e[iP] = obj;
        }
        this.f4280m = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        c.Companion.b(i10, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(elements);
        }
        s();
        h(size() + elements.size());
        int iP = p(this.f4278c + size());
        int iP2 = p(this.f4278c + i10);
        int size = elements.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i11 = this.f4278c;
            int length = i11 - size;
            if (iP2 < i11) {
                Object[] objArr = this.f4279e;
                k.d(objArr, objArr, length, i11, objArr.length);
                if (size >= iP2) {
                    Object[] objArr2 = this.f4279e;
                    k.d(objArr2, objArr2, objArr2.length - size, 0, iP2);
                } else {
                    Object[] objArr3 = this.f4279e;
                    k.d(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f4279e;
                    k.d(objArr4, objArr4, 0, size, iP2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f4279e;
                k.d(objArr5, objArr5, length, i11, iP2);
            } else {
                Object[] objArr6 = this.f4279e;
                length += objArr6.length;
                int i12 = iP2 - i11;
                int length2 = objArr6.length - length;
                if (length2 >= i12) {
                    k.d(objArr6, objArr6, length, i11, iP2);
                } else {
                    k.d(objArr6, objArr6, length, i11, i11 + length2);
                    Object[] objArr7 = this.f4279e;
                    k.d(objArr7, objArr7, 0, this.f4278c + length2, iP2);
                }
            }
            this.f4278c = length;
            c(n(iP2 - size), elements);
        } else {
            int i13 = iP2 + size;
            if (iP2 < iP) {
                int i14 = size + iP;
                Object[] objArr8 = this.f4279e;
                if (i14 <= objArr8.length) {
                    k.d(objArr8, objArr8, i13, iP2, iP);
                } else if (i13 >= objArr8.length) {
                    k.d(objArr8, objArr8, i13 - objArr8.length, iP2, iP);
                } else {
                    int length3 = iP - (i14 - objArr8.length);
                    k.d(objArr8, objArr8, 0, length3, iP);
                    Object[] objArr9 = this.f4279e;
                    k.d(objArr9, objArr9, i13, iP2, length3);
                }
            } else {
                Object[] objArr10 = this.f4279e;
                k.d(objArr10, objArr10, size, 0, iP);
                Object[] objArr11 = this.f4279e;
                if (i13 >= objArr11.length) {
                    k.d(objArr11, objArr11, i13 - objArr11.length, iP2, objArr11.length);
                } else {
                    k.d(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f4279e;
                    k.d(objArr12, objArr12, i13, iP2, objArr12.length - size);
                }
            }
            c(iP2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
