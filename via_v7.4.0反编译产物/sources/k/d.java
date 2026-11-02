package k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f7980m = new Object();

    /* renamed from: e, reason: collision with root package name */
    public boolean f7981e;

    /* renamed from: j, reason: collision with root package name */
    public long[] f7982j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f7983k;

    /* renamed from: l, reason: collision with root package name */
    public int f7984l;

    public d() {
        this(10);
    }

    public d(int i10) {
        this.f7981e = false;
        if (i10 == 0) {
            this.f7982j = c.f7978b;
            this.f7983k = c.f7979c;
        } else {
            int iF = c.f(i10);
            this.f7982j = new long[iF];
            this.f7983k = new Object[iF];
        }
    }

    public void a() {
        int i10 = this.f7984l;
        Object[] objArr = this.f7983k;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f7984l = 0;
        this.f7981e = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f7982j = (long[]) this.f7982j.clone();
            dVar.f7983k = (Object[]) this.f7983k.clone();
            return dVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean c(long j10) {
        return j(j10) >= 0;
    }

    public final void d() {
        int i10 = this.f7984l;
        long[] jArr = this.f7982j;
        Object[] objArr = this.f7983k;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f7980m) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f7981e = false;
        this.f7984l = i11;
    }

    public Object e(long j10) {
        return i(j10, null);
    }

    public Object i(long j10, Object obj) {
        Object obj2;
        int iB = c.b(this.f7982j, this.f7984l, j10);
        return (iB < 0 || (obj2 = this.f7983k[iB]) == f7980m) ? obj : obj2;
    }

    public int j(long j10) {
        if (this.f7981e) {
            d();
        }
        return c.b(this.f7982j, this.f7984l, j10);
    }

    public boolean l() {
        return q() == 0;
    }

    public long m(int i10) {
        if (this.f7981e) {
            d();
        }
        return this.f7982j[i10];
    }

    public void n(long j10, Object obj) {
        int iB = c.b(this.f7982j, this.f7984l, j10);
        if (iB >= 0) {
            this.f7983k[iB] = obj;
            return;
        }
        int iB2 = iB ^ (-1);
        int i10 = this.f7984l;
        if (iB2 < i10) {
            Object[] objArr = this.f7983k;
            if (objArr[iB2] == f7980m) {
                this.f7982j[iB2] = j10;
                objArr[iB2] = obj;
                return;
            }
        }
        if (this.f7981e && i10 >= this.f7982j.length) {
            d();
            iB2 = c.b(this.f7982j, this.f7984l, j10) ^ (-1);
        }
        int i11 = this.f7984l;
        if (i11 >= this.f7982j.length) {
            int iF = c.f(i11 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f7982j;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f7983k;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f7982j = jArr;
            this.f7983k = objArr2;
        }
        int i12 = this.f7984l;
        if (i12 - iB2 != 0) {
            long[] jArr3 = this.f7982j;
            int i13 = iB2 + 1;
            System.arraycopy(jArr3, iB2, jArr3, i13, i12 - iB2);
            Object[] objArr4 = this.f7983k;
            System.arraycopy(objArr4, iB2, objArr4, i13, this.f7984l - iB2);
        }
        this.f7982j[iB2] = j10;
        this.f7983k[iB2] = obj;
        this.f7984l++;
    }

    public void o(long j10) {
        int iB = c.b(this.f7982j, this.f7984l, j10);
        if (iB >= 0) {
            Object[] objArr = this.f7983k;
            Object obj = objArr[iB];
            Object obj2 = f7980m;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f7981e = true;
            }
        }
    }

    public void p(int i10) {
        Object[] objArr = this.f7983k;
        Object obj = objArr[i10];
        Object obj2 = f7980m;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f7981e = true;
        }
    }

    public int q() {
        if (this.f7981e) {
            d();
        }
        return this.f7984l;
    }

    public Object r(int i10) {
        if (this.f7981e) {
            d();
        }
        return this.f7983k[i10];
    }

    public String toString() {
        if (q() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f7984l * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f7984l; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(m(i10));
            sb2.append('=');
            Object objR = r(i10);
            if (objR != this) {
                sb2.append(objR);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
