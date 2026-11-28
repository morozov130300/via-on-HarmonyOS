package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MapBuilder f7284c;
    private kotlin.collections.builders.a entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private kotlin.collections.builders.b keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private kotlin.collections.builders.c valuesView;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final int c(int i10) {
            return Integer.highestOneBit(s7.e.a(i10, 1) * 3);
        }

        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }

        public final MapBuilder e() {
            return MapBuilder.f7284c;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapBuilder map) {
            super(map);
            h.f(map, "map");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public c next() {
            a();
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            c cVar = new c(d(), c());
            e();
            return cVar;
        }

        public final void i(StringBuilder sb2) {
            h.f(sb2, "sb");
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().keysArray[c()];
            if (obj == d()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = d().valuesArray;
            h.c(objArr);
            Object obj2 = objArr[c()];
            if (obj2 == d()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            e();
        }

        public final int j() {
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().keysArray[c()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = d().valuesArray;
            h.c(objArr);
            Object obj2 = objArr[c()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c implements Map.Entry {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MapBuilder f7285c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7286e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f7287m;

        public c(MapBuilder map, int i10) {
            h.f(map, "map");
            this.f7285c = map;
            this.f7286e = i10;
            this.f7287m = map.modCount;
        }

        public final void a() {
            if (this.f7285c.modCount != this.f7287m) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return h.a(entry.getKey(), getKey()) && h.a(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            a();
            return this.f7285c.keysArray[this.f7286e];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            a();
            Object[] objArr = this.f7285c.valuesArray;
            h.c(objArr);
            return objArr[this.f7286e];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            this.f7285c.checkIsMutable$kotlin_stdlib();
            Object[] objArrA = this.f7285c.a();
            int i10 = this.f7286e;
            Object obj2 = objArrA[i10];
            objArrA[i10] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MapBuilder f7288c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7289e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7290m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7291n;

        public d(MapBuilder map) {
            h.f(map, "map");
            this.f7288c = map;
            this.f7290m = -1;
            this.f7291n = map.modCount;
            e();
        }

        public final void a() {
            if (this.f7288c.modCount != this.f7291n) {
                throw new ConcurrentModificationException();
            }
        }

        public final int b() {
            return this.f7289e;
        }

        public final int c() {
            return this.f7290m;
        }

        public final MapBuilder d() {
            return this.f7288c;
        }

        public final void e() {
            while (this.f7289e < this.f7288c.length) {
                int[] iArr = this.f7288c.presenceArray;
                int i10 = this.f7289e;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.f7289e = i10 + 1;
                }
            }
        }

        public final void f(int i10) {
            this.f7289e = i10;
        }

        public final void g(int i10) {
            this.f7290m = i10;
        }

        public final boolean hasNext() {
            return this.f7289e < this.f7288c.length;
        }

        public final void remove() {
            a();
            if (this.f7290m == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.f7288c.checkIsMutable$kotlin_stdlib();
            this.f7288c.o(this.f7290m);
            this.f7290m = -1;
            this.f7291n = this.f7288c.modCount;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class e extends d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MapBuilder map) {
            super(map);
            h.f(map, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().keysArray[c()];
            e();
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class f extends d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MapBuilder map) {
            super(map);
            h.f(map, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object[] objArr = d().valuesArray;
            h.c(objArr);
            Object obj = objArr[c()];
            e();
            return obj;
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        f7284c = mapBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MapBuilder(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i10, int i11) {
        this.keysArray = objArr;
        this.valuesArray = objArr2;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i10;
        this.length = i11;
        this.hashShift = Companion.d(h());
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final Object[] a() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) f7.b.d(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    public final int addKey$kotlin_stdlib(K k10) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int i10 = i(k10);
            int iB = s7.e.b(this.maxProbeDistance * 2, h() / 2);
            int i11 = 0;
            while (true) {
                int i12 = this.hashArray[i10];
                if (i12 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        e(1);
                        break;
                    }
                    int i13 = this.length;
                    int i14 = i13 + 1;
                    this.length = i14;
                    this.keysArray[i13] = k10;
                    this.presenceArray[i13] = i10;
                    this.hashArray[i10] = i14;
                    this.size = size() + 1;
                    m();
                    if (i11 > this.maxProbeDistance) {
                        this.maxProbeDistance = i11;
                    }
                    return i13;
                }
                if (h.a(this.keysArray[i12 - 1], k10)) {
                    return -i12;
                }
                i11++;
                if (i11 > iB) {
                    n(h() * 2);
                    break;
                }
                i10 = i10 == 0 ? h() - 1 : i10 - 1;
            }
        }
    }

    public final void b(boolean z10) {
        int i10;
        V[] vArr = this.valuesArray;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.length;
            if (i11 >= i10) {
                break;
            }
            int[] iArr = this.presenceArray;
            int i13 = iArr[i11];
            if (i13 >= 0) {
                K[] kArr = this.keysArray;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                if (z10) {
                    iArr[i12] = i13;
                    this.hashArray[i13] = i12 + 1;
                }
                i12++;
            }
            i11++;
        }
        f7.b.g(this.keysArray, i12, i10);
        if (vArr != null) {
            f7.b.g(vArr, i12, this.length);
        }
        this.length = i12;
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = f7284c;
        h.d(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final boolean c(Map map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i10 = this.length - 1;
        if (i10 >= 0) {
            int i11 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i12 = iArr[i11];
                if (i12 >= 0) {
                    this.hashArray[i12] = 0;
                    iArr[i11] = -1;
                }
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        f7.b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            f7.b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        m();
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m10) {
        h.f(m10, "m");
        for (Object obj : m10) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        h.f(entry, "entry");
        int iF = f(entry.getKey());
        if (iF < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        h.c(vArr);
        return h.a(vArr[iF], entry.getValue());
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final void d(int i10) {
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        if (i10 > getCapacity$kotlin_stdlib()) {
            int iD = e7.c.Companion.d(getCapacity$kotlin_stdlib(), i10);
            this.keysArray = (K[]) f7.b.e(this.keysArray, iD);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) f7.b.e(vArr, iD) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iD);
            h.e(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            int iC = Companion.c(iD);
            if (iC > h()) {
                n(iC);
            }
        }
    }

    public final void e(int i10) {
        if (q(i10)) {
            b(true);
        } else {
            d(this.length + i10);
        }
    }

    public final b entriesIterator$kotlin_stdlib() {
        return new b(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Map) && c((Map) obj);
        }
        return true;
    }

    public final int f(Object obj) {
        int i10 = i(obj);
        int i11 = this.maxProbeDistance;
        while (true) {
            int i12 = this.hashArray[i10];
            if (i12 == 0) {
                return -1;
            }
            if (i12 > 0) {
                int i13 = i12 - 1;
                if (h.a(this.keysArray[i13], obj)) {
                    return i13;
                }
            }
            i11--;
            if (i11 < 0) {
                return -1;
            }
            i10 = i10 == 0 ? h() - 1 : i10 - 1;
        }
    }

    public final int g(Object obj) {
        int i10 = this.length;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.presenceArray[i10] >= 0) {
                V[] vArr = this.valuesArray;
                h.c(vArr);
                if (h.a(vArr[i10], obj)) {
                    return i10;
                }
            }
        }
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        h.c(vArr);
        return vArr[iF];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.a aVar = this.entriesView;
        if (aVar != null) {
            return aVar;
        }
        kotlin.collections.builders.a aVar2 = new kotlin.collections.builders.a(this);
        this.entriesView = aVar2;
        return aVar2;
    }

    public Set<K> getKeys() {
        kotlin.collections.builders.b bVar = this.keysView;
        if (bVar != null) {
            return bVar;
        }
        kotlin.collections.builders.b bVar2 = new kotlin.collections.builders.b(this);
        this.keysView = bVar2;
        return bVar2;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        kotlin.collections.builders.c cVar = this.valuesView;
        if (cVar != null) {
            return cVar;
        }
        kotlin.collections.builders.c cVar2 = new kotlin.collections.builders.c(this);
        this.valuesView = cVar2;
        return cVar2;
    }

    public final int h() {
        return this.hashArray.length;
    }

    @Override // java.util.Map
    public int hashCode() {
        b bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iJ = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            iJ += bVarEntriesIterator$kotlin_stdlib.j();
        }
        return iJ;
    }

    public final int i(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public final boolean j(Collection collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        e(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (k((Map.Entry) it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(Map.Entry entry) {
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        Object[] objArrA = a();
        if (iAddKey$kotlin_stdlib >= 0) {
            objArrA[iAddKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i10 = (-iAddKey$kotlin_stdlib) - 1;
        if (h.a(entry.getValue(), objArrA[i10])) {
            return false;
        }
        objArrA[i10] = entry.getValue();
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final e keysIterator$kotlin_stdlib() {
        return new e(this);
    }

    public final boolean l(int i10) {
        int i11 = i(this.keysArray[i10]);
        int i12 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[i11] == 0) {
                iArr[i11] = i10 + 1;
                this.presenceArray[i10] = i11;
                return true;
            }
            i12--;
            if (i12 < 0) {
                return false;
            }
            i11 = i11 == 0 ? h() - 1 : i11 - 1;
        }
    }

    public final void m() {
        this.modCount++;
    }

    public final void n(int i10) {
        m();
        int i11 = 0;
        if (this.length > size()) {
            b(false);
        }
        this.hashArray = new int[i10];
        this.hashShift = Companion.d(i10);
        while (i11 < this.length) {
            int i12 = i11 + 1;
            if (!l(i11)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i11 = i12;
        }
    }

    public final void o(int i10) {
        f7.b.f(this.keysArray, i10);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            f7.b.f(vArr, i10);
        }
        p(this.presenceArray[i10]);
        this.presenceArray[i10] = -1;
        this.size = size() - 1;
        m();
    }

    public final void p(int i10) {
        int iB = s7.e.b(this.maxProbeDistance * 2, h() / 2);
        int i11 = 0;
        int i12 = i10;
        do {
            i10 = i10 == 0 ? h() - 1 : i10 - 1;
            i11++;
            if (i11 > this.maxProbeDistance) {
                this.hashArray[i12] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i13 = iArr[i10];
            if (i13 == 0) {
                iArr[i12] = 0;
                return;
            }
            if (i13 < 0) {
                iArr[i12] = -1;
            } else {
                int i14 = i13 - 1;
                if (((i(this.keysArray[i14]) - i10) & (h() - 1)) >= i11) {
                    this.hashArray[i12] = i13;
                    this.presenceArray[i14] = i12;
                }
                iB--;
            }
            i12 = i10;
            i11 = 0;
            iB--;
        } while (iB >= 0);
        this.hashArray[i12] = -1;
    }

    @Override // java.util.Map
    public V put(K k10, V v10) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(k10);
        Object[] objArrA = a();
        if (iAddKey$kotlin_stdlib >= 0) {
            objArrA[iAddKey$kotlin_stdlib] = v10;
            return null;
        }
        int i10 = (-iAddKey$kotlin_stdlib) - 1;
        V v11 = (V) objArrA[i10];
        objArrA[i10] = v10;
        return v11;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        h.f(from, "from");
        checkIsMutable$kotlin_stdlib();
        j(from.entrySet());
    }

    public final boolean q(int i10) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i11 = this.length;
        int i12 = capacity$kotlin_stdlib - i11;
        int size = i11 - size();
        return i12 < i10 && i12 + size >= i10 && size >= getCapacity$kotlin_stdlib() / 4;
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        h.c(vArr);
        V v10 = vArr[iF];
        o(iF);
        return v10;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        h.f(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iF = f(entry.getKey());
        if (iF < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        h.c(vArr);
        if (!h.a(vArr[iF], entry.getValue())) {
            return false;
        }
        o(iF);
        return true;
    }

    public final boolean removeKey$kotlin_stdlib(K k10) {
        checkIsMutable$kotlin_stdlib();
        int iF = f(k10);
        if (iF < 0) {
            return false;
        }
        o(iF);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V v10) {
        checkIsMutable$kotlin_stdlib();
        int iG = g(v10);
        if (iG < 0) {
            return false;
        }
        o(iG);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i10 = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            bVarEntriesIterator$kotlin_stdlib.i(sb2);
            i10++;
        }
        sb2.append("}");
        String string = sb2.toString();
        h.e(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f valuesIterator$kotlin_stdlib() {
        return new f(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i10) {
        this(f7.b.d(i10), null, new int[i10], new int[Companion.c(i10)], 2, 0);
    }
}
