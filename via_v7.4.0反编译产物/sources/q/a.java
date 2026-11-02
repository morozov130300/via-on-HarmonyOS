package q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f11166a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11167b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11168c;

    /* renamed from: d, reason: collision with root package name */
    public final float f11169d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11170e;

    /* renamed from: f, reason: collision with root package name */
    public final float f11171f;

    /* renamed from: g, reason: collision with root package name */
    public final float f11172g;

    /* renamed from: h, reason: collision with root package name */
    public final float f11173h;

    /* renamed from: i, reason: collision with root package name */
    public final float f11174i;

    public a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f11166a = f10;
        this.f11167b = f11;
        this.f11168c = f12;
        this.f11169d = f13;
        this.f11170e = f14;
        this.f11171f = f15;
        this.f11172g = f16;
        this.f11173h = f17;
        this.f11174i = f18;
    }

    public static a b(float f10, float f11, float f12) {
        float f13 = 100.0f;
        float f14 = 1000.0f;
        a aVar = null;
        float f15 = 1000.0f;
        float f16 = 0.0f;
        while (Math.abs(f16 - f13) > 0.01f) {
            float f17 = ((f13 - f16) / 2.0f) + f16;
            int iP = e(f17, f11, f10).p();
            float fB = b.b(iP);
            float fAbs = Math.abs(f12 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iP);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f10));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f14 = fAbs;
                    f15 = fA;
                }
            }
            if (f14 == 0.0f && f15 == 0.0f) {
                return aVar;
            }
            if (fB < f12) {
                f16 = f17;
            } else {
                f13 = f17;
            }
        }
        return aVar;
    }

    public static a c(int i10) {
        return d(i10, f.f11188k);
    }

    public static a d(int i10, f fVar) {
        float[] fArrF = b.f(i10);
        float[][] fArr = b.f11175a;
        float f10 = fArrF[0];
        float[] fArr2 = fArr[0];
        float f11 = fArr2[0] * f10;
        float f12 = fArrF[1];
        float f13 = f11 + (fArr2[1] * f12);
        float f14 = fArrF[2];
        float f15 = f13 + (fArr2[2] * f14);
        float[] fArr3 = fArr[1];
        float f16 = (fArr3[0] * f10) + (fArr3[1] * f12) + (fArr3[2] * f14);
        float[] fArr4 = fArr[2];
        float f17 = (f10 * fArr4[0]) + (f12 * fArr4[1]) + (f14 * fArr4[2]);
        float f18 = fVar.i()[0] * f15;
        float f19 = fVar.i()[1] * f16;
        float f20 = fVar.i()[2] * f17;
        double dC = fVar.c() * Math.abs(f18);
        Double.isNaN(dC);
        float fPow = (float) Math.pow(dC / 100.0d, 0.42d);
        double dC2 = fVar.c() * Math.abs(f19);
        Double.isNaN(dC2);
        float fPow2 = (float) Math.pow(dC2 / 100.0d, 0.42d);
        double dC3 = fVar.c() * Math.abs(f20);
        Double.isNaN(dC3);
        float fPow3 = (float) Math.pow(dC3 / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f18) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f19) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f20) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum;
        Double.isNaN(d10);
        double d11 = fSignum2;
        Double.isNaN(d11);
        double d12 = fSignum3;
        Double.isNaN(d12);
        float f21 = ((float) (((d10 * 11.0d) + (d11 * (-12.0d))) + d12)) / 11.0f;
        double d13 = fSignum + fSignum2;
        Double.isNaN(d12);
        Double.isNaN(d13);
        float f22 = ((float) (d13 - (d12 * 2.0d))) / 9.0f;
        float f23 = fSignum2 * 20.0f;
        float f24 = (((fSignum * 20.0f) + f23) + (21.0f * fSignum3)) / 20.0f;
        float f25 = (((fSignum * 40.0f) + f23) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f22, f21)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f26 = fAtan2;
        float f27 = (3.1415927f * f26) / 180.0f;
        float fPow4 = ((float) Math.pow((f25 * fVar.f()) / fVar.a(), fVar.b() * fVar.j())) * 100.0f;
        float fB = (4.0f / fVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (fVar.a() + 4.0f) * fVar.d();
        Double.isNaN(((double) f26) < 20.14d ? 360.0f + f26 : f26);
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, fVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((r1 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * fVar.g()) * fVar.h()) * ((float) Math.sqrt((f21 * f21) + (f22 * f22)))) / (f24 + 0.305f), 0.9d));
        double d14 = fPow4;
        Double.isNaN(d14);
        float fSqrt = fPow5 * ((float) Math.sqrt(d14 / 100.0d));
        float fD = fSqrt * fVar.d();
        float fSqrt2 = ((float) Math.sqrt((fPow5 * fVar.b()) / (fVar.a() + 4.0f))) * 50.0f;
        float f28 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d15 = f27;
        return new a(f26, fSqrt, fPow4, fB, fD, fSqrt2, f28, fLog * ((float) Math.cos(d15)), fLog * ((float) Math.sin(d15)));
    }

    public static a e(float f10, float f11, float f12) {
        return f(f10, f11, f12, f.f11188k);
    }

    public static a f(float f10, float f11, float f12, f fVar) {
        float fB = 4.0f / fVar.b();
        double d10 = f10;
        Double.isNaN(d10);
        float fSqrt = fB * ((float) Math.sqrt(d10 / 100.0d)) * (fVar.a() + 4.0f) * fVar.d();
        float fD = fVar.d() * f11;
        float fSqrt2 = ((float) Math.sqrt(((f11 / ((float) Math.sqrt(r4))) * fVar.b()) / (fVar.a() + 4.0f))) * 50.0f;
        float f13 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        double d11 = fD;
        Double.isNaN(d11);
        float fLog = ((float) Math.log((d11 * 0.0228d) + 1.0d)) * 43.85965f;
        double d12 = (3.1415927f * f12) / 180.0f;
        return new a(f12, f11, f10, fSqrt, fD, fSqrt2, f13, ((float) Math.cos(d12)) * fLog, fLog * ((float) Math.sin(d12)));
    }

    public static int m(float f10, float f11, float f12) {
        return n(f10, f11, f12, f.f11188k);
    }

    public static int n(float f10, float f11, float f12, f fVar) {
        if (f11 < 1.0d || Math.round(f12) <= 0.0d || Math.round(f12) >= 100.0d) {
            return b.a(f12);
        }
        float fMin = f10 < 0.0f ? 0.0f : Math.min(360.0f, f10);
        float f13 = f11;
        a aVar = null;
        float f14 = 0.0f;
        boolean z10 = true;
        while (Math.abs(f14 - f11) >= 0.4f) {
            a aVarB = b(fMin, f13, f12);
            if (!z10) {
                if (aVarB == null) {
                    f11 = f13;
                } else {
                    f14 = f13;
                    aVar = aVarB;
                }
                f13 = ((f11 - f14) / 2.0f) + f14;
            } else {
                if (aVarB != null) {
                    return aVarB.o(fVar);
                }
                f13 = ((f11 - f14) / 2.0f) + f14;
                z10 = false;
            }
        }
        return aVar == null ? b.a(f12) : aVar.o(fVar);
    }

    public float a(a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    public float g() {
        return this.f11173h;
    }

    public float h() {
        return this.f11174i;
    }

    public float i() {
        return this.f11167b;
    }

    public float j() {
        return this.f11166a;
    }

    public float k() {
        return this.f11168c;
    }

    public float l() {
        return this.f11172g;
    }

    public int o(f fVar) {
        float fSqrt;
        if (i() == 0.0d || k() == 0.0d) {
            fSqrt = 0.0f;
        } else {
            float fI = i();
            double dK = k();
            Double.isNaN(dK);
            fSqrt = fI / ((float) Math.sqrt(dK / 100.0d));
        }
        double d10 = fSqrt;
        double dPow = Math.pow(1.64d - Math.pow(0.29d, fVar.e()), 0.73d);
        Double.isNaN(d10);
        float fPow = (float) Math.pow(d10 / dPow, 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        Double.isNaN(dJ);
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = fVar.a();
        double dK2 = k();
        Double.isNaN(dK2);
        double dB = fVar.b();
        Double.isNaN(dB);
        double d11 = 1.0d / dB;
        double dJ2 = fVar.j();
        Double.isNaN(dJ2);
        float fPow2 = fA * ((float) Math.pow(dK2 / 100.0d, d11 / dJ2));
        float fG = fCos * 3846.1538f * fVar.g() * fVar.h();
        float f10 = fPow2 / fVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f11 = (((0.305f + f10) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f12 = fCos2 * f11;
        float f13 = f11 * fSin;
        float f14 = f10 * 460.0f;
        float f15 = (((451.0f * f12) + f14) + (288.0f * f13)) / 1403.0f;
        float f16 = ((f14 - (891.0f * f12)) - (261.0f * f13)) / 1403.0f;
        float f17 = ((f14 - (f12 * 220.0f)) - (f13 * 6300.0f)) / 1403.0f;
        Double.isNaN(Math.abs(f15));
        Double.isNaN(Math.abs(f15));
        float fSignum = Math.signum(f15) * (100.0f / fVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (r6 * 27.13d) / (400.0d - r11)), 2.380952380952381d));
        Double.isNaN(Math.abs(f16));
        Double.isNaN(Math.abs(f16));
        float fSignum2 = Math.signum(f16) * (100.0f / fVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (r11 * 27.13d) / (400.0d - r1)), 2.380952380952381d));
        Double.isNaN(Math.abs(f17));
        Double.isNaN(Math.abs(f17));
        float fSignum3 = Math.signum(f17) * (100.0f / fVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (r11 * 27.13d) / (400.0d - r9)), 2.380952380952381d));
        float f18 = fSignum / fVar.i()[0];
        float f19 = fSignum2 / fVar.i()[1];
        float f20 = fSignum3 / fVar.i()[2];
        float[][] fArr = b.f11176b;
        float[] fArr2 = fArr[0];
        float f21 = (fArr2[0] * f18) + (fArr2[1] * f19) + (fArr2[2] * f20);
        float[] fArr3 = fArr[1];
        float f22 = (fArr3[0] * f18) + (fArr3[1] * f19) + (fArr3[2] * f20);
        float[] fArr4 = fArr[2];
        return r.a.a(f21, f22, (f18 * fArr4[0]) + (f19 * fArr4[1]) + (f20 * fArr4[2]));
    }

    public int p() {
        return o(f.f11188k);
    }
}
