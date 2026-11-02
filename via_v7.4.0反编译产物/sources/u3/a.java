package u3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f12797h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f12798i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f12799j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f12800k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f12801l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f12802m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f12803n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f12804o;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f12805a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f12806b;

    /* renamed from: c, reason: collision with root package name */
    public final b f12807c;

    /* renamed from: d, reason: collision with root package name */
    public final b f12808d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12809e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12810f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12811g;

    static {
        a aVar = new a(67, 64, 1);
        f12799j = aVar;
        f12800k = new a(19, 16, 1);
        f12801l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f12802m = aVar2;
        f12803n = aVar2;
        f12804o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f12810f = i10;
        this.f12809e = i11;
        this.f12811g = i12;
        this.f12805a = new int[i11];
        this.f12806b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f12805a[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f12806b[this.f12805a[i15]] = i15;
        }
        this.f12807c = new b(this, new int[]{0});
        this.f12808d = new b(this, new int[]{1});
    }

    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f12807c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new b(this, iArr);
    }

    public int c(int i10) {
        return this.f12805a[i10];
    }

    public int d() {
        return this.f12811g;
    }

    public b e() {
        return this.f12808d;
    }

    public int f() {
        return this.f12809e;
    }

    public b g() {
        return this.f12807c;
    }

    public int h(int i10) {
        if (i10 != 0) {
            return this.f12805a[(this.f12809e - this.f12806b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i10) {
        if (i10 != 0) {
            return this.f12806b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f12805a;
        int[] iArr2 = this.f12806b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f12809e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f12810f) + ',' + this.f12809e + ')';
    }
}
