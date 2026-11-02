package b4;

import com.google.zxing.NotFoundException;
import com.google.zxing.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final s3.b f1805a;

    /* renamed from: c, reason: collision with root package name */
    public final int f1807c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1808d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1809e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1810f;

    /* renamed from: g, reason: collision with root package name */
    public final float f1811g;

    /* renamed from: i, reason: collision with root package name */
    public final l f1813i;

    /* renamed from: b, reason: collision with root package name */
    public final List f1806b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    public final int[] f1812h = new int[3];

    public b(s3.b bVar, int i10, int i11, int i12, int i13, float f10, l lVar) {
        this.f1805a = bVar;
        this.f1807c = i10;
        this.f1808d = i11;
        this.f1809e = i12;
        this.f1810f = i13;
        this.f1811g = f10;
        this.f1813i = lVar;
    }

    public static float a(int[] iArr, int i10) {
        return (i10 - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final float b(int i10, int i11, int i12, int i13) {
        s3.b bVar = this.f1805a;
        int iJ = bVar.j();
        int[] iArr = this.f1812h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i14 = i10;
        while (i14 >= 0 && bVar.e(i11, i14)) {
            int i15 = iArr[1];
            if (i15 > i12) {
                break;
            }
            iArr[1] = i15 + 1;
            i14--;
        }
        if (i14 >= 0 && iArr[1] <= i12) {
            while (i14 >= 0 && !bVar.e(i11, i14)) {
                int i16 = iArr[0];
                if (i16 > i12) {
                    break;
                }
                iArr[0] = i16 + 1;
                i14--;
            }
            if (iArr[0] > i12) {
                return Float.NaN;
            }
            int i17 = i10 + 1;
            while (i17 < iJ && bVar.e(i11, i17)) {
                int i18 = iArr[1];
                if (i18 > i12) {
                    break;
                }
                iArr[1] = i18 + 1;
                i17++;
            }
            if (i17 != iJ && iArr[1] <= i12) {
                while (i17 < iJ && !bVar.e(i11, i17)) {
                    int i19 = iArr[2];
                    if (i19 > i12) {
                        break;
                    }
                    iArr[2] = i19 + 1;
                    i17++;
                }
                int i20 = iArr[2];
                if (i20 <= i12 && Math.abs(((iArr[0] + iArr[1]) + i20) - i13) * 5 < i13 * 2 && d(iArr)) {
                    return a(iArr, i17);
                }
            }
        }
        return Float.NaN;
    }

    public a c() throws NotFoundException {
        a aVarE;
        a aVarE2;
        int i10 = this.f1807c;
        int i11 = this.f1810f;
        int i12 = this.f1809e + i10;
        int i13 = this.f1808d + (i11 / 2);
        int[] iArr = new int[3];
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = ((i14 & 1) == 0 ? (i14 + 1) / 2 : -((i14 + 1) / 2)) + i13;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i16 = i10;
            while (i16 < i12 && !this.f1805a.e(i16, i15)) {
                i16++;
            }
            int i17 = 0;
            while (i16 < i12) {
                if (!this.f1805a.e(i16, i15)) {
                    if (i17 == 1) {
                        i17++;
                    }
                    iArr[i17] = iArr[i17] + 1;
                } else if (i17 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i17 != 2) {
                    i17++;
                    iArr[i17] = iArr[i17] + 1;
                } else {
                    if (d(iArr) && (aVarE2 = e(iArr, i15, i16)) != null) {
                        return aVarE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i17 = 1;
                }
                i16++;
            }
            if (d(iArr) && (aVarE = e(iArr, i15, i12)) != null) {
                return aVarE;
            }
        }
        if (this.f1806b.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (a) this.f1806b.get(0);
    }

    public final boolean d(int[] iArr) {
        float f10 = this.f1811g;
        float f11 = f10 / 2.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            if (Math.abs(f10 - iArr[i10]) >= f11) {
                return false;
            }
        }
        return true;
    }

    public final a e(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i11);
        float fB = b(i10, (int) fA, iArr[1] * 2, i12);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f10 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f1806b) {
            if (aVar.f(f10, fB, fA)) {
                return aVar.g(fB, fA, f10);
            }
        }
        a aVar2 = new a(fA, fB, f10);
        this.f1806b.add(aVar2);
        l lVar = this.f1813i;
        if (lVar == null) {
            return null;
        }
        lVar.a(aVar2);
        return null;
    }
}
