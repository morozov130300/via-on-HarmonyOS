package k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements Cloneable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f7080o = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7081c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long[] f7082e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Object[] f7083m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7084n;

    public d() {
        this(10);
    }

    public void a() {
        int i10 = this.f7084n;
        Object[] objArr = this.f7083m;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f7084n = 0;
        this.f7081c = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f7082e = (long[]) this.f7082e.clone();
            dVar.f7083m = (Object[]) this.f7083m.clone();
            return dVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean d(long j10) {
        return k(j10) >= 0;
    }

    public final void e() {
        int i10 = this.f7084n;
        long[] jArr = this.f7082e;
        Object[] objArr = this.f7083m;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f7080o) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f7081c = false;
        this.f7084n = i11;
    }

    public Object i(long j10) {
        return j(j10, null);
    }

    public Object j(long j10, Object obj) {
        Object obj2;
        int iB = c.b(this.f7082e, this.f7084n, j10);
        return (iB < 0 || (obj2 = this.f7083m[iB]) == f7080o) ? obj : obj2;
    }

    public int k(long j10) {
        if (this.f7081c) {
            e();
        }
        return c.b(this.f7082e, this.f7084n, j10);
    }

    public boolean l() {
        return q() == 0;
    }

    public long m(int i10) {
        if (this.f7081c) {
            e();
        }
        return this.f7082e[i10];
    }

    public void n(long j10, Object obj) {
        int iB = c.b(this.f7082e, this.f7084n, j10);
        if (iB >= 0) {
            this.f7083m[iB] = obj;
            return;
        }
        int iB2 = iB ^ (-1);
        int i10 = this.f7084n;
        if (iB2 < i10) {
            Object[] objArr = this.f7083m;
            if (objArr[iB2] == f7080o) {
                this.f7082e[iB2] = j10;
                objArr[iB2] = obj;
                return;
            }
        }
        if (this.f7081c && i10 >= this.f7082e.length) {
            e();
            iB2 = c.b(this.f7082e, this.f7084n, j10) ^ (-1);
        }
        int i11 = this.f7084n;
        if (i11 >= this.f7082e.length) {
            int iF = c.f(i11 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f7082e;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f7083m;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f7082e = jArr;
            this.f7083m = objArr2;
        }
        int i12 = this.f7084n;
        if (i12 - iB2 != 0) {
            long[] jArr3 = this.f7082e;
            int i13 = iB2 + 1;
            System.arraycopy(jArr3, iB2, jArr3, i13, i12 - iB2);
            Object[] objArr4 = this.f7083m;
            System.arraycopy(objArr4, iB2, objArr4, i13, this.f7084n - iB2);
        }
        this.f7082e[iB2] = j10;
        this.f7083m[iB2] = obj;
        this.f7084n++;
    }

    public void o(long j10) {
        int iB = c.b(this.f7082e, this.f7084n, j10);
        if (iB >= 0) {
            Object[] objArr = this.f7083m;
            Object obj = objArr[iB];
            Object obj2 = f7080o;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f7081c = true;
            }
        }
    }

    public void p(int i10) {
        Object[] objArr = this.f7083m;
        Object obj = objArr[i10];
        Object obj2 = f7080o;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f7081c = true;
        }
    }

    public int q() {
        if (this.f7081c) {
            e();
        }
        return this.f7084n;
    }

    public Object r(int i10) {
        if (this.f7081c) {
            e();
        }
        return this.f7083m[i10];
    }

    public String toString() {
        if (q() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f7084n * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f7084n; i10++) {
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

    public d(int i10) {
        this.f7081c = false;
        if (i10 == 0) {
            this.f7082e = c.f7078b;
            this.f7083m = c.f7079c;
        } else {
            int iF = c.f(i10);
            this.f7082e = new long[iF];
            this.f7083m = new Object[iF];
        }
    }
}
