package io.reactivex.rxjava3.internal.util;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float f7473a;

    /* renamed from: b, reason: collision with root package name */
    public int f7474b;

    /* renamed from: c, reason: collision with root package name */
    public int f7475c;

    /* renamed from: d, reason: collision with root package name */
    public int f7476d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f7477e;

    public c() {
        this(16, 0.75f);
    }

    public c(int i10, float f10) {
        this.f7473a = f10;
        int iA = d.a(i10);
        this.f7474b = iA - 1;
        this.f7476d = (int) (f10 * iA);
        this.f7477e = new Object[iA];
    }

    public static int c(int i10) {
        int i11 = i10 * (-1640531527);
        return i11 ^ (i11 >>> 16);
    }

    public boolean a(Object obj) {
        Object obj2;
        Object[] objArr = this.f7477e;
        int i10 = this.f7474b;
        int iC = c(obj.hashCode()) & i10;
        Object obj3 = objArr[iC];
        if (obj3 != null) {
            if (obj3.equals(obj)) {
                return false;
            }
            do {
                iC = (iC + 1) & i10;
                obj2 = objArr[iC];
                if (obj2 == null) {
                }
            } while (!obj2.equals(obj));
            return false;
        }
        objArr[iC] = obj;
        int i11 = this.f7475c + 1;
        this.f7475c = i11;
        if (i11 >= this.f7476d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f7477e;
    }

    public void d() {
        Object obj;
        Object[] objArr = this.f7477e;
        int length = objArr.length;
        int i10 = length << 1;
        int i11 = i10 - 1;
        Object[] objArr2 = new Object[i10];
        int i12 = this.f7475c;
        while (true) {
            int i13 = i12 - 1;
            if (i12 == 0) {
                this.f7474b = i11;
                this.f7476d = (int) (i10 * this.f7473a);
                this.f7477e = objArr2;
                return;
            }
            do {
                length--;
                obj = objArr[length];
            } while (obj == null);
            int iC = c(obj.hashCode()) & i11;
            if (objArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i11;
                } while (objArr2[iC] != null);
            }
            objArr2[iC] = objArr[length];
            i12 = i13;
        }
    }

    public boolean e(Object obj) {
        Object obj2;
        Object[] objArr = this.f7477e;
        int i10 = this.f7474b;
        int iC = c(obj.hashCode()) & i10;
        Object obj3 = objArr[iC];
        if (obj3 == null) {
            return false;
        }
        if (obj3.equals(obj)) {
            return f(iC, objArr, i10);
        }
        do {
            iC = (iC + 1) & i10;
            obj2 = objArr[iC];
            if (obj2 == null) {
                return false;
            }
        } while (!obj2.equals(obj));
        return f(iC, objArr, i10);
    }

    public boolean f(int i10, Object[] objArr, int i11) {
        int i12;
        Object obj;
        this.f7475c--;
        while (true) {
            int i13 = i10 + 1;
            while (true) {
                i12 = i13 & i11;
                obj = objArr[i12];
                if (obj == null) {
                    objArr[i10] = null;
                    return true;
                }
                int iC = c(obj.hashCode()) & i11;
                if (i10 <= i12) {
                    if (i10 >= iC || iC > i12) {
                        break;
                    }
                    i13 = i12 + 1;
                } else if (i10 < iC || iC <= i12) {
                    i13 = i12 + 1;
                }
            }
            objArr[i10] = obj;
            i10 = i12;
        }
    }
}
