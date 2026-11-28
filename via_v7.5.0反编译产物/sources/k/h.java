package k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h implements Cloneable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f7115o = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7116c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f7117e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Object[] f7118m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7119n;

    public h() {
        this(10);
    }

    public void a() {
        int i10 = this.f7119n;
        Object[] objArr = this.f7118m;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f7119n = 0;
        this.f7116c = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f7117e = (int[]) this.f7117e.clone();
            hVar.f7118m = (Object[]) this.f7118m.clone();
            return hVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final void d() {
        int i10 = this.f7119n;
        int[] iArr = this.f7117e;
        Object[] objArr = this.f7118m;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f7115o) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f7116c = false;
        this.f7119n = i11;
    }

    public int e(int i10) {
        if (this.f7116c) {
            d();
        }
        return this.f7117e[i10];
    }

    public int i() {
        if (this.f7116c) {
            d();
        }
        return this.f7119n;
    }

    public Object j(int i10) {
        if (this.f7116c) {
            d();
        }
        return this.f7118m[i10];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f7119n * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f7119n; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(e(i10));
            sb2.append('=');
            Object objJ = j(i10);
            if (objJ != this) {
                sb2.append(objJ);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public h(int i10) {
        this.f7116c = false;
        if (i10 == 0) {
            this.f7117e = c.f7077a;
            this.f7118m = c.f7079c;
        } else {
            int iE = c.e(i10);
            this.f7117e = new int[iE];
            this.f7118m = new Object[iE];
        }
    }
}
