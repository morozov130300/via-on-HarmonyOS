package com.google.zxing.qrcode.detector;

import b4.d;
import b4.e;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s3.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class FinderPatternFinder {

    /* renamed from: f, reason: collision with root package name */
    public static final EstimatedModuleComparator f4162f = new EstimatedModuleComparator();

    /* renamed from: a, reason: collision with root package name */
    public final b f4163a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4165c;

    /* renamed from: e, reason: collision with root package name */
    public final l f4167e;

    /* renamed from: b, reason: collision with root package name */
    public final List f4164b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final int[] f4166d = new int[5];

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class EstimatedModuleComparator implements Comparator<d>, Serializable {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return Float.compare(dVar.i(), dVar2.i());
        }
    }

    public FinderPatternFinder(b bVar, l lVar) {
        this.f4163a = bVar;
        this.f4167e = lVar;
    }

    public static float a(int[] iArr, int i10) {
        return ((i10 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static void e(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    public static void f(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public static boolean i(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = f10 / 2.0f;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 3.0f) - ((float) iArr[2])) < 3.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
    }

    public static boolean j(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = f10 / 1.333f;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 3.0f) - ((float) iArr[2])) < 3.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
    }

    public static double o(d dVar, d dVar2) {
        double dC = dVar.c() - dVar2.c();
        double d10 = dVar.d() - dVar2.d();
        Double.isNaN(dC);
        Double.isNaN(dC);
        Double.isNaN(d10);
        Double.isNaN(d10);
        return (dC * dC) + (d10 * d10);
    }

    public final boolean b(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int[] iArrK = k();
        int i15 = 0;
        while (i10 >= i15 && i11 >= i15 && this.f4163a.e(i11 - i15, i10 - i15)) {
            iArrK[2] = iArrK[2] + 1;
            i15++;
        }
        if (iArrK[2] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && !this.f4163a.e(i11 - i15, i10 - i15)) {
            iArrK[1] = iArrK[1] + 1;
            i15++;
        }
        if (iArrK[1] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && this.f4163a.e(i11 - i15, i10 - i15)) {
            iArrK[0] = iArrK[0] + 1;
            i15++;
        }
        if (iArrK[0] == 0) {
            return false;
        }
        int iJ = this.f4163a.j();
        int iM = this.f4163a.m();
        int i16 = 1;
        while (true) {
            int i17 = i10 + i16;
            if (i17 >= iJ || (i14 = i11 + i16) >= iM || !this.f4163a.e(i14, i17)) {
                break;
            }
            iArrK[2] = iArrK[2] + 1;
            i16++;
        }
        while (true) {
            int i18 = i10 + i16;
            if (i18 >= iJ || (i13 = i11 + i16) >= iM || this.f4163a.e(i13, i18)) {
                break;
            }
            iArrK[3] = iArrK[3] + 1;
            i16++;
        }
        if (iArrK[3] == 0) {
            return false;
        }
        while (true) {
            int i19 = i10 + i16;
            if (i19 >= iJ || (i12 = i11 + i16) >= iM || !this.f4163a.e(i12, i19)) {
                break;
            }
            iArrK[4] = iArrK[4] + 1;
            i16++;
        }
        if (iArrK[4] == 0) {
            return false;
        }
        return j(iArrK);
    }

    public final float c(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        b bVar = this.f4163a;
        int iM = bVar.m();
        int[] iArrK = k();
        int i17 = i10;
        while (i17 >= 0 && bVar.e(i17, i11)) {
            iArrK[2] = iArrK[2] + 1;
            i17--;
        }
        if (i17 < 0) {
            return Float.NaN;
        }
        while (i17 >= 0 && !bVar.e(i17, i11)) {
            int i18 = iArrK[1];
            if (i18 > i12) {
                break;
            }
            iArrK[1] = i18 + 1;
            i17--;
        }
        if (i17 >= 0 && iArrK[1] <= i12) {
            while (i17 >= 0 && bVar.e(i17, i11) && (i16 = iArrK[0]) <= i12) {
                iArrK[0] = i16 + 1;
                i17--;
            }
            if (iArrK[0] > i12) {
                return Float.NaN;
            }
            int i19 = i10 + 1;
            while (i19 < iM && bVar.e(i19, i11)) {
                iArrK[2] = iArrK[2] + 1;
                i19++;
            }
            if (i19 == iM) {
                return Float.NaN;
            }
            while (i19 < iM && !bVar.e(i19, i11) && (i15 = iArrK[3]) < i12) {
                iArrK[3] = i15 + 1;
                i19++;
            }
            if (i19 != iM && iArrK[3] < i12) {
                while (i19 < iM && bVar.e(i19, i11) && (i14 = iArrK[4]) < i12) {
                    iArrK[4] = i14 + 1;
                    i19++;
                }
                int i20 = iArrK[4];
                if (i20 < i12 && Math.abs(((((iArrK[0] + iArrK[1]) + iArrK[2]) + iArrK[3]) + i20) - i13) * 5 < i13 && i(iArrK)) {
                    return a(iArrK, i19);
                }
            }
        }
        return Float.NaN;
    }

    public final float d(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        b bVar = this.f4163a;
        int iJ = bVar.j();
        int[] iArrK = k();
        int i17 = i10;
        while (i17 >= 0 && bVar.e(i11, i17)) {
            iArrK[2] = iArrK[2] + 1;
            i17--;
        }
        if (i17 < 0) {
            return Float.NaN;
        }
        while (i17 >= 0 && !bVar.e(i11, i17)) {
            int i18 = iArrK[1];
            if (i18 > i12) {
                break;
            }
            iArrK[1] = i18 + 1;
            i17--;
        }
        if (i17 >= 0 && iArrK[1] <= i12) {
            while (i17 >= 0 && bVar.e(i11, i17) && (i16 = iArrK[0]) <= i12) {
                iArrK[0] = i16 + 1;
                i17--;
            }
            if (iArrK[0] > i12) {
                return Float.NaN;
            }
            int i19 = i10 + 1;
            while (i19 < iJ && bVar.e(i11, i19)) {
                iArrK[2] = iArrK[2] + 1;
                i19++;
            }
            if (i19 == iJ) {
                return Float.NaN;
            }
            while (i19 < iJ && !bVar.e(i11, i19) && (i15 = iArrK[3]) < i12) {
                iArrK[3] = i15 + 1;
                i19++;
            }
            if (i19 != iJ && iArrK[3] < i12) {
                while (i19 < iJ && bVar.e(i11, i19) && (i14 = iArrK[4]) < i12) {
                    iArrK[4] = i14 + 1;
                    i19++;
                }
                int i20 = iArrK[4];
                if (i20 < i12 && Math.abs(((((iArrK[0] + iArrK[1]) + iArrK[2]) + iArrK[3]) + i20) - i13) * 5 < i13 * 2 && i(iArrK)) {
                    return a(iArrK, i19);
                }
            }
        }
        return Float.NaN;
    }

    public final e g(Map map) throws NotFoundException {
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int iJ = this.f4163a.j();
        int iM = this.f4163a.m();
        int i10 = (iJ * 3) / 388;
        if (i10 < 3 || z10) {
            i10 = 3;
        }
        int[] iArr = new int[5];
        int i11 = i10 - 1;
        boolean zM = false;
        while (i11 < iJ && !zM) {
            e(iArr);
            int i12 = 0;
            int i13 = 0;
            while (i12 < iM) {
                if (this.f4163a.e(i12, i11)) {
                    if ((i13 & 1) == 1) {
                        i13++;
                    }
                    iArr[i13] = iArr[i13] + 1;
                } else if ((i13 & 1) != 0) {
                    iArr[i13] = iArr[i13] + 1;
                } else if (i13 != 4) {
                    i13++;
                    iArr[i13] = iArr[i13] + 1;
                } else if (i(iArr) && l(iArr, i11, i12)) {
                    if (this.f4165c) {
                        zM = m();
                    } else {
                        int iH = h();
                        int i14 = iArr[2];
                        if (iH > i14) {
                            i11 += (iH - i14) - 2;
                            i12 = iM - 1;
                        }
                    }
                    e(iArr);
                    i10 = 2;
                    i13 = 0;
                } else {
                    f(iArr);
                    i13 = 3;
                }
                i12++;
            }
            if (i(iArr) && l(iArr, i11, iM)) {
                i10 = iArr[0];
                if (this.f4165c) {
                    zM = m();
                }
            }
            i11 += i10;
        }
        d[] dVarArrN = n();
        k.e(dVarArrN);
        return new e(dVarArrN);
    }

    public final int h() {
        if (this.f4164b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f4164b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f4165c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    public final int[] k() {
        e(this.f4166d);
        return this.f4166d;
    }

    public final boolean l(int[] iArr, int i10, int i11) {
        int i12 = 0;
        int i13 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i11);
        float fD = d(i10, iA, iArr[2], i13);
        if (!Float.isNaN(fD)) {
            int i14 = (int) fD;
            float fC = c(iA, i14, iArr[2], i13);
            if (!Float.isNaN(fC) && b(i14, (int) fC)) {
                float f10 = i13 / 7.0f;
                while (true) {
                    if (i12 < this.f4164b.size()) {
                        d dVar = (d) this.f4164b.get(i12);
                        if (dVar.f(f10, fD, fC)) {
                            this.f4164b.set(i12, dVar.g(fD, fC, f10));
                            break;
                        }
                        i12++;
                    } else {
                        d dVar2 = new d(fC, fD, f10);
                        this.f4164b.add(dVar2);
                        l lVar = this.f4167e;
                        if (lVar != null) {
                            lVar.a(dVar2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean m() {
        int size = this.f4164b.size();
        float fAbs = 0.0f;
        int i10 = 0;
        float fI = 0.0f;
        for (d dVar : this.f4164b) {
            if (dVar.h() >= 2) {
                i10++;
                fI += dVar.i();
            }
        }
        if (i10 < 3) {
            return false;
        }
        float f10 = fI / size;
        Iterator it = this.f4164b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(((d) it.next()).i() - f10);
        }
        return fAbs <= fI * 0.05f;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d[] n() throws NotFoundException {
        int i10;
        double d10;
        double dAbs;
        if (this.f4164b.size() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        Iterator it = this.f4164b.iterator();
        while (true) {
            i10 = 2;
            if (!it.hasNext()) {
                break;
            }
            if (((d) it.next()).h() < 2) {
                it.remove();
            }
        }
        Collections.sort(this.f4164b, f4162f);
        d[] dVarArr = new d[3];
        double d11 = Double.MAX_VALUE;
        int i11 = 0;
        while (i11 < this.f4164b.size() - i10) {
            d dVar = (d) this.f4164b.get(i11);
            float fI = dVar.i();
            i11++;
            int i12 = i11;
            while (i12 < this.f4164b.size() - 1) {
                d dVar2 = (d) this.f4164b.get(i12);
                double dO = o(dVar, dVar2);
                i12++;
                for (int i13 = i12; i13 < this.f4164b.size(); i13++) {
                    d dVar3 = (d) this.f4164b.get(i13);
                    if (dVar3.i() <= 1.4f * fI) {
                        double dO2 = o(dVar2, dVar3);
                        double dO3 = o(dVar, dVar3);
                        if (dO < dO2) {
                            if (dO2 <= dO3) {
                                dO3 = dO2;
                                dO2 = dO3;
                            } else if (dO >= dO3) {
                                d10 = dO3;
                                dO3 = dO;
                                dAbs = Math.abs(dO2 - (dO3 * 2.0d)) + Math.abs(dO2 - (d10 * 2.0d));
                                if (dAbs >= d11) {
                                    dVarArr[0] = dVar;
                                    dVarArr[1] = dVar2;
                                    dVarArr[2] = dVar3;
                                    d11 = dAbs;
                                }
                            }
                            d10 = dO;
                            dAbs = Math.abs(dO2 - (dO3 * 2.0d)) + Math.abs(dO2 - (d10 * 2.0d));
                            if (dAbs >= d11) {
                            }
                        } else {
                            if (dO2 >= dO3) {
                                d10 = dO3;
                                dO3 = dO2;
                            } else if (dO < dO3) {
                                d10 = dO2;
                                dO2 = dO3;
                                dO3 = dO;
                                dAbs = Math.abs(dO2 - (dO3 * 2.0d)) + Math.abs(dO2 - (d10 * 2.0d));
                                if (dAbs >= d11) {
                                }
                            } else {
                                d10 = dO2;
                            }
                            dO2 = dO;
                            dAbs = Math.abs(dO2 - (dO3 * 2.0d)) + Math.abs(dO2 - (d10 * 2.0d));
                            if (dAbs >= d11) {
                            }
                        }
                    }
                }
                i10 = 2;
            }
        }
        if (d11 != Double.MAX_VALUE) {
            return dVarArr;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
