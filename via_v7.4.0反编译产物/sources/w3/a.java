package w3;

import com.google.zxing.NotFoundException;
import v3.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a extends q {

    /* renamed from: b, reason: collision with root package name */
    public final int[] f13229b;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f13232e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f13233f;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f13228a = new int[4];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f13230c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f13231d = new float[4];

    public a() {
        int[] iArr = new int[8];
        this.f13229b = iArr;
        this.f13232e = new int[iArr.length / 2];
        this.f13233f = new int[iArr.length / 2];
    }

    public static void h(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            float f11 = fArr[i11];
            if (f11 < f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        iArr[i10] = iArr[i10] - 1;
    }

    public static void o(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            float f11 = fArr[i11];
            if (f11 > f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        iArr[i10] = iArr[i10] + 1;
    }

    public static boolean p(int[] iArr) {
        float f10 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f10 >= 0.7916667f && f10 <= 0.89285713f) {
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MIN_VALUE;
            for (int i12 : iArr) {
                if (i12 > i11) {
                    i11 = i12;
                }
                if (i12 < i10) {
                    i10 = i12;
                }
            }
            if (i11 < i10 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int q(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            if (q.e(iArr, iArr2[i10], 0.45f) < 0.2f) {
                return i10;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] i() {
        return this.f13229b;
    }

    public final int[] j() {
        return this.f13228a;
    }

    public final int[] k() {
        return this.f13233f;
    }

    public final float[] l() {
        return this.f13231d;
    }

    public final int[] m() {
        return this.f13232e;
    }

    public final float[] n() {
        return this.f13230c;
    }
}
