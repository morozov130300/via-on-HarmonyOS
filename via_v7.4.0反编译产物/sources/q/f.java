package q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name */
    public static final f f11188k;

    /* renamed from: a, reason: collision with root package name */
    public final float f11189a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11190b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11191c;

    /* renamed from: d, reason: collision with root package name */
    public final float f11192d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11193e;

    /* renamed from: f, reason: collision with root package name */
    public final float f11194f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f11195g;

    /* renamed from: h, reason: collision with root package name */
    public final float f11196h;

    /* renamed from: i, reason: collision with root package name */
    public final float f11197i;

    /* renamed from: j, reason: collision with root package name */
    public final float f11198j;

    static {
        float[] fArr = b.f11177c;
        double dH = b.h(50.0f);
        Double.isNaN(dH);
        f11188k = k(fArr, (float) ((dH * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    public f(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f11194f = f10;
        this.f11189a = f11;
        this.f11190b = f12;
        this.f11191c = f13;
        this.f11192d = f14;
        this.f11193e = f15;
        this.f11195g = fArr;
        this.f11196h = f16;
        this.f11197i = f17;
        this.f11198j = f18;
    }

    public static f k(float[] fArr, float f10, float f11, float f12, boolean z10) {
        float[][] fArr2 = b.f11175a;
        float f13 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f14 = fArr3[0] * f13;
        float f15 = fArr[1];
        float f16 = f14 + (fArr3[1] * f15);
        float f17 = fArr[2];
        float f18 = f16 + (fArr3[2] * f17);
        float[] fArr4 = fArr2[1];
        float f19 = (fArr4[0] * f13) + (fArr4[1] * f15) + (fArr4[2] * f17);
        float[] fArr5 = fArr2[2];
        float f20 = (f13 * fArr5[0]) + (f15 * fArr5[1]) + (f17 * fArr5[2]);
        float f21 = (f12 / 10.0f) + 0.8f;
        float fD = ((double) f21) >= 0.9d ? b.d(0.59f, 0.69f, (f21 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f21 - 0.8f) * 10.0f);
        float fExp = z10 ? 1.0f : (1.0f - (((float) Math.exp(((-f10) - 42.0f) / 92.0f)) * 0.2777778f)) * f21;
        double d10 = fExp;
        if (d10 > 1.0d) {
            fExp = 1.0f;
        } else if (d10 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f18) * fExp) + 1.0f) - fExp, (((100.0f / f19) * fExp) + 1.0f) - fExp, (((100.0f / f20) * fExp) + 1.0f) - fExp};
        float f22 = 1.0f / ((5.0f * f10) + 1.0f);
        float f23 = f22 * f22 * f22 * f22;
        float f24 = 1.0f - f23;
        double d11 = f10;
        Double.isNaN(d11);
        float fCbrt = (f23 * f10) + (0.1f * f24 * f24 * ((float) Math.cbrt(d11 * 5.0d)));
        float fH = b.h(f11) / fArr[1];
        double d12 = fH;
        float fSqrt = ((float) Math.sqrt(d12)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d12, 0.2d));
        double d13 = fArr6[0] * fCbrt * f18;
        Double.isNaN(d13);
        float fPow2 = (float) Math.pow(d13 / 100.0d, 0.42d);
        double d14 = fArr6[1] * fCbrt * f19;
        Double.isNaN(d14);
        float fPow3 = (float) Math.pow(d14 / 100.0d, 0.42d);
        double d15 = fArr6[2] * fCbrt * f20;
        Double.isNaN(d15);
        float[] fArr7 = {fPow2, fPow3, (float) Math.pow(d15 / 100.0d, 0.42d)};
        float f25 = fArr7[0];
        float f26 = (f25 * 400.0f) / (f25 + 27.13f);
        float f27 = fArr7[1];
        float f28 = (f27 * 400.0f) / (f27 + 27.13f);
        float f29 = fArr7[2];
        float[] fArr8 = {f26, f28, (400.0f * f29) / (f29 + 27.13f)};
        return new f(fH, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * fPow, fPow, fPow, fD, f21, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public float a() {
        return this.f11189a;
    }

    public float b() {
        return this.f11192d;
    }

    public float c() {
        return this.f11196h;
    }

    public float d() {
        return this.f11197i;
    }

    public float e() {
        return this.f11194f;
    }

    public float f() {
        return this.f11190b;
    }

    public float g() {
        return this.f11193e;
    }

    public float h() {
        return this.f11191c;
    }

    public float[] i() {
        return this.f11195g;
    }

    public float j() {
        return this.f11198j;
    }
}
