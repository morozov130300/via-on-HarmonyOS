package k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f8015m = new Object();

    /* renamed from: e, reason: collision with root package name */
    public boolean f8016e;

    /* renamed from: j, reason: collision with root package name */
    public int[] f8017j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f8018k;

    /* renamed from: l, reason: collision with root package name */
    public int f8019l;

    public h() {
        this(10);
    }

    public h(int i10) {
        this.f8016e = false;
        if (i10 == 0) {
            this.f8017j = c.f7977a;
            this.f8018k = c.f7979c;
        } else {
            int iE = c.e(i10);
            this.f8017j = new int[iE];
            this.f8018k = new Object[iE];
        }
    }

    public void a() {
        int i10 = this.f8019l;
        Object[] objArr = this.f8018k;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f8019l = 0;
        this.f8016e = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f8017j = (int[]) this.f8017j.clone();
            hVar.f8018k = (Object[]) this.f8018k.clone();
            return hVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final void c() {
        int i10 = this.f8019l;
        int[] iArr = this.f8017j;
        Object[] objArr = this.f8018k;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f8015m) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f8016e = false;
        this.f8019l = i11;
    }

    public int d(int i10) {
        if (this.f8016e) {
            c();
        }
        return this.f8017j[i10];
    }

    public int e() {
        if (this.f8016e) {
            c();
        }
        return this.f8019l;
    }

    public Object i(int i10) {
        if (this.f8016e) {
            c();
        }
        return this.f8018k[i10];
    }

    public String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f8019l * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f8019l; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(d(i10));
            sb2.append('=');
            Object objI = i(i10);
            if (objI != this) {
                sb2.append(objI);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
