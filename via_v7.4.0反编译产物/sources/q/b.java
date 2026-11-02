package q;

import android.graphics.Color;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final float[][] f11175a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b, reason: collision with root package name */
    public static final float[][] f11176b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f11177c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d, reason: collision with root package name */
    public static final float[][] f11178d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static int a(float f10) {
        if (f10 < 1.0f) {
            return -16777216;
        }
        if (f10 > 99.0f) {
            return -1;
        }
        float f11 = (f10 + 16.0f) / 116.0f;
        float f12 = f10 > 8.0f ? f11 * f11 * f11 : f10 / 903.2963f;
        float f13 = f11 * f11 * f11;
        boolean z10 = f13 > 0.008856452f;
        float f14 = z10 ? f13 : ((f11 * 116.0f) - 16.0f) / 903.2963f;
        if (!z10) {
            f13 = ((f11 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f11177c;
        return r.a.a(f14 * fArr[0], f12 * fArr[1], f13 * fArr[2]);
    }

    public static float b(int i10) {
        return c(g(i10));
    }

    public static float c(float f10) {
        float f11 = f10 / 100.0f;
        return f11 <= 0.008856452f ? f11 * 903.2963f : (((float) Math.cbrt(f11)) * 116.0f) - 16.0f;
    }

    public static float d(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public static float e(int i10) {
        float f10 = i10 / 255.0f;
        return (f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static float[] f(int i10) {
        float fE = e(Color.red(i10));
        float fE2 = e(Color.green(i10));
        float fE3 = e(Color.blue(i10));
        float[][] fArr = f11178d;
        float[] fArr2 = fArr[0];
        float f10 = (fArr2[0] * fE) + (fArr2[1] * fE2) + (fArr2[2] * fE3);
        float[] fArr3 = fArr[1];
        float f11 = (fArr3[0] * fE) + (fArr3[1] * fE2) + (fArr3[2] * fE3);
        float[] fArr4 = fArr[2];
        return new float[]{f10, f11, (fE * fArr4[0]) + (fE2 * fArr4[1]) + (fE3 * fArr4[2])};
    }

    public static float g(int i10) {
        float fE = e(Color.red(i10));
        float fE2 = e(Color.green(i10));
        float fE3 = e(Color.blue(i10));
        float[] fArr = f11178d[1];
        return (fE * fArr[0]) + (fE2 * fArr[1]) + (fE3 * fArr[2]);
    }

    public static float h(float f10) {
        float fPow;
        if (f10 > 8.0f) {
            double d10 = f10;
            Double.isNaN(d10);
            fPow = (float) Math.pow((d10 + 16.0d) / 116.0d, 3.0d);
        } else {
            fPow = f10 / 903.2963f;
        }
        return fPow * 100.0f;
    }
}
