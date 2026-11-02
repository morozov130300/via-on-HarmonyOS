package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements Collection, Set {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f7966m = new int[0];

    /* renamed from: n, reason: collision with root package name */
    public static final Object[] f7967n = new Object[0];

    /* renamed from: o, reason: collision with root package name */
    public static Object[] f7968o;

    /* renamed from: p, reason: collision with root package name */
    public static int f7969p;

    /* renamed from: q, reason: collision with root package name */
    public static Object[] f7970q;

    /* renamed from: r, reason: collision with root package name */
    public static int f7971r;

    /* renamed from: e, reason: collision with root package name */
    public int[] f7972e;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f7973j;

    /* renamed from: k, reason: collision with root package name */
    public int f7974k;

    /* renamed from: l, reason: collision with root package name */
    public f f7975l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends f {
        public a() {
        }

        @Override // k.f
        public void a() {
            b.this.clear();
        }

        @Override // k.f
        public Object b(int i10, int i11) {
            return b.this.f7973j[i10];
        }

        @Override // k.f
        public Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // k.f
        public int d() {
            return b.this.f7974k;
        }

        @Override // k.f
        public int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // k.f
        public int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // k.f
        public void g(Object obj, Object obj2) {
            b.this.add(obj);
        }

        @Override // k.f
        public void h(int i10) {
            b.this.o(i10);
        }

        @Override // k.f
        public Object i(int i10, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i10) {
        if (i10 == 0) {
            this.f7972e = f7966m;
            this.f7973j = f7967n;
        } else {
            c(i10);
        }
        this.f7974k = 0;
    }

    public static void g(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                try {
                    if (f7971r < 10) {
                        objArr[0] = f7970q;
                        objArr[1] = iArr;
                        for (int i11 = i10 - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        f7970q = objArr;
                        f7971r++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                try {
                    if (f7969p < 10) {
                        objArr[0] = f7968o;
                        objArr[1] = iArr;
                        for (int i12 = i10 - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        f7968o = objArr;
                        f7969p++;
                    }
                } finally {
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i10;
        int iK;
        if (obj == null) {
            iK = n();
            i10 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i10 = iHashCode;
            iK = k(obj, iHashCode);
        }
        if (iK >= 0) {
            return false;
        }
        int i11 = iK ^ (-1);
        int i12 = this.f7974k;
        int[] iArr = this.f7972e;
        if (i12 >= iArr.length) {
            int i13 = 8;
            if (i12 >= 8) {
                i13 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i13 = 4;
            }
            Object[] objArr = this.f7973j;
            c(i13);
            int[] iArr2 = this.f7972e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f7973j, 0, objArr.length);
            }
            g(iArr, objArr, this.f7974k);
        }
        int i14 = this.f7974k;
        if (i11 < i14) {
            int[] iArr3 = this.f7972e;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr2 = this.f7973j;
            System.arraycopy(objArr2, i11, objArr2, i15, this.f7974k - i11);
        }
        this.f7972e[i11] = i10;
        this.f7973j[i11] = obj;
        this.f7974k++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        f(this.f7974k + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final void c(int i10) {
        if (i10 == 8) {
            synchronized (b.class) {
                try {
                    Object[] objArr = f7970q;
                    if (objArr != null) {
                        this.f7973j = objArr;
                        f7970q = (Object[]) objArr[0];
                        this.f7972e = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f7971r--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i10 == 4) {
            synchronized (b.class) {
                try {
                    Object[] objArr2 = f7968o;
                    if (objArr2 != null) {
                        this.f7973j = objArr2;
                        f7968o = (Object[]) objArr2[0];
                        this.f7972e = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f7969p--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f7972e = new int[i10];
        this.f7973j = new Object[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.f7974k;
        if (i10 != 0) {
            g(this.f7972e, this.f7973j, i10);
            this.f7972e = f7966m;
            this.f7973j = f7967n;
            this.f7974k = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f7974k; i10++) {
                try {
                    if (!set.contains(p(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void f(int i10) {
        int[] iArr = this.f7972e;
        if (iArr.length < i10) {
            Object[] objArr = this.f7973j;
            c(i10);
            int i11 = this.f7974k;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f7972e, 0, i11);
                System.arraycopy(objArr, 0, this.f7973j, 0, this.f7974k);
            }
            g(iArr, objArr, this.f7974k);
        }
    }

    public final f h() {
        if (this.f7975l == null) {
            this.f7975l = new a();
        }
        return this.f7975l;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f7972e;
        int i10 = this.f7974k;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        return obj == null ? n() : k(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f7974k <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return h().m().iterator();
    }

    public final int k(Object obj, int i10) {
        int i11 = this.f7974k;
        if (i11 == 0) {
            return -1;
        }
        int iA = c.a(this.f7972e, i11, i10);
        if (iA < 0 || obj.equals(this.f7973j[iA])) {
            return iA;
        }
        int i12 = iA + 1;
        while (i12 < i11 && this.f7972e[i12] == i10) {
            if (obj.equals(this.f7973j[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iA - 1; i13 >= 0 && this.f7972e[i13] == i10; i13--) {
            if (obj.equals(this.f7973j[i13])) {
                return i13;
            }
        }
        return i12 ^ (-1);
    }

    public final int n() {
        int i10 = this.f7974k;
        if (i10 == 0) {
            return -1;
        }
        int iA = c.a(this.f7972e, i10, 0);
        if (iA < 0 || this.f7973j[iA] == null) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f7972e[i11] == 0) {
            if (this.f7973j[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f7972e[i12] == 0; i12--) {
            if (this.f7973j[i12] == null) {
                return i12;
            }
        }
        return i11 ^ (-1);
    }

    public Object o(int i10) {
        Object[] objArr = this.f7973j;
        Object obj = objArr[i10];
        int i11 = this.f7974k;
        if (i11 <= 1) {
            g(this.f7972e, objArr, i11);
            this.f7972e = f7966m;
            this.f7973j = f7967n;
            this.f7974k = 0;
            return obj;
        }
        int[] iArr = this.f7972e;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            int i12 = i11 - 1;
            this.f7974k = i12;
            if (i10 < i12) {
                int i13 = i10 + 1;
                System.arraycopy(iArr, i13, iArr, i10, i12 - i10);
                Object[] objArr2 = this.f7973j;
                System.arraycopy(objArr2, i13, objArr2, i10, this.f7974k - i10);
            }
            this.f7973j[this.f7974k] = null;
            return obj;
        }
        c(i11 > 8 ? i11 + (i11 >> 1) : 8);
        this.f7974k--;
        if (i10 > 0) {
            System.arraycopy(iArr, 0, this.f7972e, 0, i10);
            System.arraycopy(objArr, 0, this.f7973j, 0, i10);
        }
        int i14 = this.f7974k;
        if (i10 < i14) {
            int i15 = i10 + 1;
            System.arraycopy(iArr, i15, this.f7972e, i10, i14 - i10);
            System.arraycopy(objArr, i15, this.f7973j, i10, this.f7974k - i10);
        }
        return obj;
    }

    public Object p(int i10) {
        return this.f7973j[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        o(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z10 = false;
        for (int i10 = this.f7974k - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f7973j[i10])) {
                o(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f7974k;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i10 = this.f7974k;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f7973j, 0, objArr, 0, i10);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f7974k) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f7974k);
        }
        System.arraycopy(this.f7973j, 0, objArr, 0, this.f7974k);
        int length = objArr.length;
        int i10 = this.f7974k;
        if (length > i10) {
            objArr[i10] = null;
        }
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f7974k * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f7974k; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object objP = p(i10);
            if (objP != this) {
                sb2.append(objP);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
