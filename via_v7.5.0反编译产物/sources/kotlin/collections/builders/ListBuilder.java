package kotlin.collections.builders;

import e7.e;
import e7.k;
import e7.n;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ListBuilder<E> extends e implements List<E>, RandomAccess, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f7274c = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ListBuilder f7275e;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class BuilderSubList<E> extends e implements List<E>, RandomAccess, Serializable {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class a implements ListIterator {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final BuilderSubList f7276c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f7277e;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f7278m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f7279n;

            public a(BuilderSubList list, int i10) {
                h.f(list, "list");
                this.f7276c = list;
                this.f7277e = i10;
                this.f7278m = -1;
                this.f7279n = ((AbstractList) list).modCount;
            }

            public final void a() {
                if (((AbstractList) this.f7276c.root).modCount != this.f7279n) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                a();
                BuilderSubList builderSubList = this.f7276c;
                int i10 = this.f7277e;
                this.f7277e = i10 + 1;
                builderSubList.add(i10, obj);
                this.f7278m = -1;
                this.f7279n = ((AbstractList) this.f7276c).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f7277e < this.f7276c.length;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f7277e > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                a();
                if (this.f7277e >= this.f7276c.length) {
                    throw new NoSuchElementException();
                }
                int i10 = this.f7277e;
                this.f7277e = i10 + 1;
                this.f7278m = i10;
                return this.f7276c.backing[this.f7276c.offset + this.f7278m];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f7277e;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                a();
                int i10 = this.f7277e;
                if (i10 <= 0) {
                    throw new NoSuchElementException();
                }
                int i11 = i10 - 1;
                this.f7277e = i11;
                this.f7278m = i11;
                return this.f7276c.backing[this.f7276c.offset + this.f7278m];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f7277e - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                a();
                int i10 = this.f7278m;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                this.f7276c.remove(i10);
                this.f7277e = this.f7278m;
                this.f7278m = -1;
                this.f7279n = ((AbstractList) this.f7276c).modCount;
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                a();
                int i10 = this.f7278m;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.f7276c.set(i10, obj);
            }
        }

        public BuilderSubList(E[] backing, int i10, int i11, BuilderSubList<E> builderSubList, ListBuilder<E> root) {
            h.f(backing, "backing");
            h.f(root, "root");
            this.backing = backing;
            this.offset = i10;
            this.length = i11;
            this.parent = builderSubList;
            this.root = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final void o() {
            ((AbstractList) this).modCount++;
        }

        private final Object writeReplace() throws NotSerializableException {
            if (n()) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E e10) {
            h();
            g();
            f(this.offset + this.length, e10);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> elements) {
            h.f(elements, "elements");
            h();
            g();
            int size = elements.size();
            c(this.offset + this.length, elements, size);
            return size > 0;
        }

        public final void c(int i10, Collection collection, int i11) {
            o();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.c(i10, collection, i11);
            } else {
                this.root.c(i10, collection, i11);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length += i11;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            h();
            g();
            s(this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            g();
            if (obj != this) {
                return (obj instanceof List) && k((List) obj);
            }
            return true;
        }

        public final void f(int i10, Object obj) {
            o();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.f(i10, obj);
            } else {
                this.root.f(i10, obj);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length++;
        }

        public final void g() {
            if (((AbstractList) this.root).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i10) {
            g();
            e7.c.Companion.a(i10, this.length);
            return this.backing[this.offset + i10];
        }

        @Override // e7.e
        public int getSize() {
            g();
            return this.length;
        }

        public final void h() {
            if (n()) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            g();
            return f7.b.i(this.backing, this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            g();
            for (int i10 = 0; i10 < this.length; i10++) {
                if (h.a(this.backing[this.offset + i10], obj)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            g();
            return this.length == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        public final boolean k(List list) {
            return f7.b.h(this.backing, this.offset, this.length, list);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            g();
            for (int i10 = this.length - 1; i10 >= 0; i10--) {
                if (h.a(this.backing[this.offset + i10], obj)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        public final boolean n() {
            return ((ListBuilder) this.root).isReadOnly;
        }

        public final Object p(int i10) {
            o();
            BuilderSubList<E> builderSubList = this.parent;
            Object objP = builderSubList != null ? builderSubList.p(i10) : this.root.s(i10);
            this.length--;
            return objP;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            h();
            g();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                remove(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> elements) {
            h.f(elements, "elements");
            h();
            g();
            return t(this.offset, this.length, elements, false) > 0;
        }

        @Override // e7.e
        public E removeAt(int i10) {
            h();
            g();
            e7.c.Companion.a(i10, this.length);
            return (E) p(this.offset + i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> elements) {
            h.f(elements, "elements");
            h();
            g();
            return t(this.offset, this.length, elements, true) > 0;
        }

        public final void s(int i10, int i11) {
            if (i11 > 0) {
                o();
            }
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.s(i10, i11);
            } else {
                this.root.t(i10, i11);
            }
            this.length -= i11;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i10, E e10) {
            h();
            g();
            e7.c.Companion.a(i10, this.length);
            E[] eArr = this.backing;
            int i11 = this.offset;
            E e11 = eArr[i11 + i10];
            eArr[i11 + i10] = e10;
            return e11;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int i10, int i11) {
            e7.c.Companion.c(i10, i11, this.length);
            return new BuilderSubList(this.backing, this.offset + i10, i11 - i10, this, this.root);
        }

        public final int t(int i10, int i11, Collection collection, boolean z10) {
            BuilderSubList<E> builderSubList = this.parent;
            int iT = builderSubList != null ? builderSubList.t(i10, i11, collection, z10) : this.root.u(i10, i11, collection, z10);
            if (iT > 0) {
                o();
            }
            this.length -= iT;
            return iT;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] array) {
            h.f(array, "array");
            g();
            int length = array.length;
            int i10 = this.length;
            if (length >= i10) {
                E[] eArr = this.backing;
                int i11 = this.offset;
                k.d(eArr, array, 0, i11, i10 + i11);
                return (T[]) n.f(this.length, array);
            }
            E[] eArr2 = this.backing;
            int i12 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr2, i12, i10 + i12, array.getClass());
            h.e(tArr, "copyOfRange(...)");
            return tArr;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            g();
            return f7.b.j(this.backing, this.offset, this.length, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i10) {
            g();
            e7.c.Companion.b(i10, this.length);
            return new a(this, i10);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i10, E e10) {
            h();
            g();
            e7.c.Companion.b(i10, this.length);
            f(this.offset + i10, e10);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i10, Collection<? extends E> elements) {
            h.f(elements, "elements");
            h();
            g();
            e7.c.Companion.b(i10, this.length);
            int size = elements.size();
            c(this.offset + i10, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            g();
            E[] eArr = this.backing;
            int i10 = this.offset;
            return k.f(eArr, i10, this.length + i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements ListIterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ListBuilder f7280c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7281e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7282m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7283n;

        public b(ListBuilder list, int i10) {
            h.f(list, "list");
            this.f7280c = list;
            this.f7281e = i10;
            this.f7282m = -1;
            this.f7283n = ((AbstractList) list).modCount;
        }

        public final void a() {
            if (((AbstractList) this.f7280c).modCount != this.f7283n) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            a();
            ListBuilder listBuilder = this.f7280c;
            int i10 = this.f7281e;
            this.f7281e = i10 + 1;
            listBuilder.add(i10, obj);
            this.f7282m = -1;
            this.f7283n = ((AbstractList) this.f7280c).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f7281e < this.f7280c.length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f7281e > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            a();
            if (this.f7281e >= this.f7280c.length) {
                throw new NoSuchElementException();
            }
            int i10 = this.f7281e;
            this.f7281e = i10 + 1;
            this.f7282m = i10;
            return this.f7280c.backing[this.f7282m];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f7281e;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            a();
            int i10 = this.f7281e;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.f7281e = i11;
            this.f7282m = i11;
            return this.f7280c.backing[this.f7282m];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f7281e - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i10 = this.f7282m;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.f7280c.remove(i10);
            this.f7281e = this.f7282m;
            this.f7282m = -1;
            this.f7283n = ((AbstractList) this.f7280c).modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            a();
            int i10 = this.f7282m;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.f7280c.set(i10, obj);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        f7275e = listBuilder;
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i10, Collection collection, int i11) {
        p();
        o(i10, i11);
        Iterator<E> it = collection.iterator();
        for (int i12 = 0; i12 < i11; i12++) {
            this.backing[i10 + i12] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int i10, Object obj) {
        p();
        o(i10, 1);
        ((E[]) this.backing)[i10] = obj;
    }

    private final void g() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean h(List list) {
        return f7.b.h(this.backing, 0, this.length, list);
    }

    private final void p() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(int i10) {
        p();
        E[] eArr = this.backing;
        E e10 = eArr[i10];
        k.d(eArr, eArr, i10, i10 + 1, this.length);
        f7.b.f(this.backing, this.length - 1);
        this.length--;
        return e10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int i10, int i11) {
        if (i11 > 0) {
            p();
        }
        E[] eArr = this.backing;
        k.d(eArr, eArr, i10, i10 + i11, this.length);
        E[] eArr2 = this.backing;
        int i12 = this.length;
        f7.b.g(eArr2, i12 - i11, i12);
        this.length -= i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int u(int i10, int i11, Collection collection, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.backing[i14]) == z10) {
                E[] eArr = this.backing;
                i12++;
                eArr[i13 + i10] = eArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        E[] eArr2 = this.backing;
        k.d(eArr2, eArr2, i10 + i13, i11 + i10, this.length);
        E[] eArr3 = this.backing;
        int i16 = this.length;
        f7.b.g(eArr3, i16 - i15, i16);
        if (i15 > 0) {
            p();
        }
        this.length -= i15;
        return i15;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        g();
        f(this.length, e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        h.f(elements, "elements");
        g();
        int size = elements.size();
        c(this.length, elements, size);
        return size > 0;
    }

    public final List<E> build() {
        g();
        this.isReadOnly = true;
        return this.length > 0 ? this : f7275e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        g();
        t(0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof List) && h((List) obj);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        e7.c.Companion.a(i10, this.length);
        return this.backing[i10];
    }

    @Override // e7.e
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return f7.b.i(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.length; i10++) {
            if (h.a(this.backing[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    public final void k(int i10) {
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.backing;
        if (i10 > eArr.length) {
            this.backing = (E[]) f7.b.e(this.backing, e7.c.Companion.d(eArr.length, i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i10 = this.length - 1; i10 >= 0; i10--) {
            if (h.a(this.backing[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public final void n(int i10) {
        k(this.length + i10);
    }

    public final void o(int i10, int i11) {
        n(i11);
        E[] eArr = this.backing;
        k.d(eArr, eArr, i10 + i11, i10, this.length);
        this.length += i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        g();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        h.f(elements, "elements");
        g();
        return u(0, this.length, elements, false) > 0;
    }

    @Override // e7.e
    public E removeAt(int i10) {
        g();
        e7.c.Companion.a(i10, this.length);
        return (E) s(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        h.f(elements, "elements");
        g();
        return u(0, this.length, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        g();
        e7.c.Companion.a(i10, this.length);
        E[] eArr = this.backing;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        return e11;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i10, int i11) {
        e7.c.Companion.c(i10, i11, this.length);
        return new BuilderSubList(this.backing, i10, i11 - i10, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        h.f(array, "array");
        int length = array.length;
        int i10 = this.length;
        if (length >= i10) {
            k.d(this.backing, array, 0, 0, i10);
            return (T[]) n.f(this.length, array);
        }
        T[] tArr = (T[]) Arrays.copyOfRange(this.backing, 0, i10, array.getClass());
        h.e(tArr, "copyOfRange(...)");
        return tArr;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return f7.b.j(this.backing, 0, this.length, this);
    }

    public ListBuilder(int i10) {
        this.backing = (E[]) f7.b.d(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i10) {
        e7.c.Companion.b(i10, this.length);
        return new b(this, i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        g();
        e7.c.Companion.b(i10, this.length);
        f(i10, e10);
    }

    public /* synthetic */ ListBuilder(int i10, int i11, f fVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends E> elements) {
        h.f(elements, "elements");
        g();
        e7.c.Companion.b(i10, this.length);
        int size = elements.size();
        c(i10, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return k.f(this.backing, 0, this.length);
    }
}
