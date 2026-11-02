package k;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g {

    /* renamed from: l, reason: collision with root package name */
    public static Object[] f8008l;

    /* renamed from: m, reason: collision with root package name */
    public static int f8009m;

    /* renamed from: n, reason: collision with root package name */
    public static Object[] f8010n;

    /* renamed from: o, reason: collision with root package name */
    public static int f8011o;

    /* renamed from: e, reason: collision with root package name */
    public int[] f8012e;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f8013j;

    /* renamed from: k, reason: collision with root package name */
    public int f8014k;

    public g() {
        this.f8012e = c.f7977a;
        this.f8013j = c.f7979c;
        this.f8014k = 0;
    }

    public g(int i10) {
        if (i10 == 0) {
            this.f8012e = c.f7977a;
            this.f8013j = c.f7979c;
        } else {
            a(i10);
        }
        this.f8014k = 0;
    }

    public static int b(int[] iArr, int i10, int i11) {
        try {
            return c.a(iArr, i10, i11);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void d(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                try {
                    if (f8011o < 10) {
                        objArr[0] = f8010n;
                        objArr[1] = iArr;
                        for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        f8010n = objArr;
                        f8011o++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                try {
                    if (f8009m < 10) {
                        objArr[0] = f8008l;
                        objArr[1] = iArr;
                        for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        f8008l = objArr;
                        f8009m++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i10) {
        if (i10 == 8) {
            synchronized (g.class) {
                try {
                    Object[] objArr = f8010n;
                    if (objArr != null) {
                        this.f8013j = objArr;
                        f8010n = (Object[]) objArr[0];
                        this.f8012e = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f8011o--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i10 == 4) {
            synchronized (g.class) {
                try {
                    Object[] objArr2 = f8008l;
                    if (objArr2 != null) {
                        this.f8013j = objArr2;
                        f8008l = (Object[]) objArr2[0];
                        this.f8012e = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f8009m--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f8012e = new int[i10];
        this.f8013j = new Object[i10 << 1];
    }

    public void c(int i10) {
        int i11 = this.f8014k;
        int[] iArr = this.f8012e;
        if (iArr.length < i10) {
            Object[] objArr = this.f8013j;
            a(i10);
            if (this.f8014k > 0) {
                System.arraycopy(iArr, 0, this.f8012e, 0, i11);
                System.arraycopy(objArr, 0, this.f8013j, 0, i11 << 1);
            }
            d(iArr, objArr, i11);
        }
        if (this.f8014k != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i10 = this.f8014k;
        if (i10 > 0) {
            int[] iArr = this.f8012e;
            Object[] objArr = this.f8013j;
            this.f8012e = c.f7977a;
            this.f8013j = c.f7979c;
            this.f8014k = 0;
            d(iArr, objArr, i10);
        }
        if (this.f8014k > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public int e(Object obj, int i10) {
        int i11 = this.f8014k;
        if (i11 == 0) {
            return -1;
        }
        int iB = b(this.f8012e, i11, i10);
        if (iB < 0 || obj.equals(this.f8013j[iB << 1])) {
            return iB;
        }
        int i12 = iB + 1;
        while (i12 < i11 && this.f8012e[i12] == i10) {
            if (obj.equals(this.f8013j[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iB - 1; i13 >= 0 && this.f8012e[i13] == i10; i13--) {
            if (obj.equals(this.f8013j[i13 << 1])) {
                return i13;
            }
        }
        return i12 ^ (-1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f8014k; i10++) {
                try {
                    Object objI = i(i10);
                    Object objL = l(i10);
                    Object obj2 = gVar.get(objI);
                    if (objL == null) {
                        if (obj2 != null || !gVar.containsKey(objI)) {
                            return false;
                        }
                    } else if (!objL.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.f8014k; i11++) {
                try {
                    Object objI2 = i(i11);
                    Object objL2 = l(i11);
                    Object obj3 = map.get(objI2);
                    if (objL2 == null) {
                        if (obj3 != null || !map.containsKey(objI2)) {
                            return false;
                        }
                    } else if (!objL2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    public int g() {
        int i10 = this.f8014k;
        if (i10 == 0) {
            return -1;
        }
        int iB = b(this.f8012e, i10, 0);
        if (iB < 0 || this.f8013j[iB << 1] == null) {
            return iB;
        }
        int i11 = iB + 1;
        while (i11 < i10 && this.f8012e[i11] == 0) {
            if (this.f8013j[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iB - 1; i12 >= 0 && this.f8012e[i12] == 0; i12--) {
            if (this.f8013j[i12 << 1] == null) {
                return i12;
            }
        }
        return i11 ^ (-1);
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iF = f(obj);
        return iF >= 0 ? this.f8013j[(iF << 1) + 1] : obj2;
    }

    public int h(Object obj) {
        int i10 = this.f8014k * 2;
        Object[] objArr = this.f8013j;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f8012e;
        Object[] objArr = this.f8013j;
        int i10 = this.f8014k;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    public Object i(int i10) {
        return this.f8013j[i10 << 1];
    }

    public boolean isEmpty() {
        return this.f8014k <= 0;
    }

    public Object j(int i10) {
        Object[] objArr = this.f8013j;
        int i11 = i10 << 1;
        Object obj = objArr[i11 + 1];
        int i12 = this.f8014k;
        int i13 = 0;
        if (i12 <= 1) {
            d(this.f8012e, objArr, i12);
            this.f8012e = c.f7977a;
            this.f8013j = c.f7979c;
        } else {
            int i14 = i12 - 1;
            int[] iArr = this.f8012e;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    int i16 = i14 - i10;
                    System.arraycopy(iArr, i15, iArr, i10, i16);
                    Object[] objArr2 = this.f8013j;
                    System.arraycopy(objArr2, i15 << 1, objArr2, i11, i16 << 1);
                }
                Object[] objArr3 = this.f8013j;
                int i17 = i14 << 1;
                objArr3[i17] = null;
                objArr3[i17 + 1] = null;
            } else {
                a(i12 > 8 ? i12 + (i12 >> 1) : 8);
                if (i12 != this.f8014k) {
                    throw new ConcurrentModificationException();
                }
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f8012e, 0, i10);
                    System.arraycopy(objArr, 0, this.f8013j, 0, i11);
                }
                if (i10 < i14) {
                    int i18 = i10 + 1;
                    int i19 = i14 - i10;
                    System.arraycopy(iArr, i18, this.f8012e, i10, i19);
                    System.arraycopy(objArr, i18 << 1, this.f8013j, i11, i19 << 1);
                }
            }
            i13 = i14;
        }
        if (i12 != this.f8014k) {
            throw new ConcurrentModificationException();
        }
        this.f8014k = i13;
        return obj;
    }

    public Object k(int i10, Object obj) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f8013j;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        return obj2;
    }

    public Object l(int i10) {
        return this.f8013j[(i10 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i10;
        int iE;
        int i11 = this.f8014k;
        if (obj == null) {
            iE = g();
            i10 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i10 = iHashCode;
            iE = e(obj, iHashCode);
        }
        if (iE >= 0) {
            int i12 = (iE << 1) + 1;
            Object[] objArr = this.f8013j;
            Object obj3 = objArr[i12];
            objArr[i12] = obj2;
            return obj3;
        }
        int i13 = iE ^ (-1);
        int[] iArr = this.f8012e;
        if (i11 >= iArr.length) {
            int i14 = 8;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i14 = 4;
            }
            Object[] objArr2 = this.f8013j;
            a(i14);
            if (i11 != this.f8014k) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f8012e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f8013j, 0, objArr2.length);
            }
            d(iArr, objArr2, i11);
        }
        if (i13 < i11) {
            int[] iArr3 = this.f8012e;
            int i15 = i13 + 1;
            System.arraycopy(iArr3, i13, iArr3, i15, i11 - i13);
            Object[] objArr3 = this.f8013j;
            System.arraycopy(objArr3, i13 << 1, objArr3, i15 << 1, (this.f8014k - i13) << 1);
        }
        int i16 = this.f8014k;
        if (i11 == i16) {
            int[] iArr4 = this.f8012e;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                Object[] objArr4 = this.f8013j;
                int i17 = i13 << 1;
                objArr4[i17] = obj;
                objArr4[i17 + 1] = obj2;
                this.f8014k = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return j(iF);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        Object objL = l(iF);
        if (obj2 != objL && (obj2 == null || !obj2.equals(objL))) {
            return false;
        }
        j(iF);
        return true;
    }

    public Object replace(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF >= 0) {
            return k(iF, obj2);
        }
        return null;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        Object objL = l(iF);
        if (objL != obj2 && (obj2 == null || !obj2.equals(objL))) {
            return false;
        }
        k(iF, obj3);
        return true;
    }

    public int size() {
        return this.f8014k;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f8014k * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f8014k; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object objI = i(i10);
            if (objI != this) {
                sb2.append(objI);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object objL = l(i10);
            if (objL != this) {
                sb2.append(objL);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
