package v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f13336h = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f13337i = new a(1033, 1024, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f13338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f13339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f13340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f13341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f13342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f13343o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f13344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f13345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f13346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f13347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f13349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13350g;

    static {
        a aVar = new a(67, 64, 1);
        f13338j = aVar;
        f13339k = new a(19, 16, 1);
        f13340l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f13341m = aVar2;
        f13342n = aVar2;
        f13343o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f13349f = i10;
        this.f13348e = i11;
        this.f13350g = i12;
        this.f13344a = new int[i11];
        this.f13345b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f13344a[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f13345b[this.f13344a[i15]] = i15;
        }
        this.f13346c = new b(this, new int[]{0});
        this.f13347d = new b(this, new int[]{1});
    }

    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f13346c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new b(this, iArr);
    }

    public int c(int i10) {
        return this.f13344a[i10];
    }

    public int d() {
        return this.f13350g;
    }

    public b e() {
        return this.f13347d;
    }

    public int f() {
        return this.f13348e;
    }

    public b g() {
        return this.f13346c;
    }

    public int h(int i10) {
        if (i10 != 0) {
            return this.f13344a[(this.f13348e - this.f13345b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i10) {
        if (i10 != 0) {
            return this.f13345b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f13344a;
        int[] iArr2 = this.f13345b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f13348e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f13349f) + ',' + this.f13348e + ')';
    }
}
