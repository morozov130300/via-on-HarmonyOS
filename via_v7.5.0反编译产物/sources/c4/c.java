package c4;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import java.util.Map;
import t3.f;
import t3.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t3.b f1944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f1945b;

    public c(t3.b bVar) {
        this.f1944a = bVar;
    }

    public static int c(k kVar, k kVar2, k kVar3, float f10) throws NotFoundException {
        int iC = (u3.a.c(k.b(kVar, kVar2) / f10) + u3.a.c(k.b(kVar, kVar3) / f10)) / 2;
        int i10 = iC + 7;
        int i11 = i10 & 3;
        if (i11 == 0) {
            return iC + 8;
        }
        if (i11 == 2) {
            return iC + 6;
        }
        if (i11 != 3) {
            return i10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static t3.k d(k kVar, k kVar2, k kVar3, k kVar4, int i10) {
        float fC;
        float fD;
        float f10;
        float f11 = i10 - 3.5f;
        if (kVar4 != null) {
            fC = kVar4.c();
            fD = kVar4.d();
            f10 = f11 - 3.0f;
        } else {
            fC = (kVar2.c() - kVar.c()) + kVar3.c();
            fD = (kVar2.d() - kVar.d()) + kVar3.d();
            f10 = f11;
        }
        return t3.k.b(3.5f, 3.5f, f11, 3.5f, f10, f10, 3.5f, f11, kVar.c(), kVar.d(), kVar2.c(), kVar2.d(), fC, fD, kVar3.c(), kVar3.d());
    }

    public static t3.b h(t3.b bVar, t3.k kVar, int i10) {
        return i.b().c(bVar, i10, i10, kVar);
    }

    public final float a(k kVar, k kVar2, k kVar3) {
        return (b(kVar, kVar2) + b(kVar, kVar3)) / 2.0f;
    }

    public final float b(k kVar, k kVar2) {
        float fJ = j((int) kVar.c(), (int) kVar.d(), (int) kVar2.c(), (int) kVar2.d());
        float fJ2 = j((int) kVar2.c(), (int) kVar2.d(), (int) kVar.c(), (int) kVar.d());
        if (Float.isNaN(fJ)) {
            return fJ2 / 7.0f;
        }
        return Float.isNaN(fJ2) ? fJ / 7.0f : (fJ + fJ2) / 14.0f;
    }

    public final f e(Map map) {
        this.f1945b = map == null ? null : (l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return g(new FinderPatternFinder(this.f1944a, this.f1945b).g(map));
    }

    public final a f(float f10, int i10, int i11, float f11) throws NotFoundException {
        int i12 = (int) (f11 * f10);
        int iMax = Math.max(0, i10 - i12);
        int iMin = Math.min(this.f1944a.m() - 1, i10 + i12) - iMax;
        float f12 = 3.0f * f10;
        if (iMin < f12) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i11 - i12);
        int iMin2 = Math.min(this.f1944a.k() - 1, i11 + i12) - iMax2;
        if (iMin2 >= f12) {
            return new b(this.f1944a, iMax, iMax2, iMin, iMin2, f10, this.f1945b).c();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final f g(e eVar) throws NotFoundException, FormatException {
        a aVarF;
        d dVarB = eVar.b();
        d dVarC = eVar.c();
        d dVarA = eVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iC = c(dVarB, dVarC, dVarA, fA);
        b4.f fVarG = b4.f.g(iC);
        int iE = fVarG.e() - 7;
        if (fVarG.d().length <= 0) {
            aVarF = null;
            break;
        }
        float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
        float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
        float f10 = 1.0f - (3.0f / iE);
        int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f10));
        int iD = (int) (dVarB.d() + (f10 * (fD - dVarB.d())));
        int i10 = 4;
        while (true) {
            if (i10 > 16) {
                aVarF = null;
                break;
            }
            try {
                aVarF = f(fA, iC2, iD, i10);
                break;
            } catch (NotFoundException unused) {
                i10 <<= 1;
            }
        }
        return new f(h(this.f1944a, d(dVarB, dVarC, dVarA, aVarF, iC), iC), aVarF == null ? new k[]{dVarA, dVarB, dVarC} : new k[]{dVarA, dVarB, dVarC, aVarF});
    }

    public final float i(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = 1;
        boolean z10 = Math.abs(i13 - i11) > Math.abs(i12 - i10);
        if (z10) {
            i15 = i10;
            i14 = i11;
            i17 = i12;
            i16 = i13;
        } else {
            i14 = i10;
            i15 = i11;
            i16 = i12;
            i17 = i13;
        }
        int iAbs = Math.abs(i16 - i14);
        int iAbs2 = Math.abs(i17 - i15);
        int i19 = (-iAbs) / 2;
        int i20 = i14 < i16 ? 1 : -1;
        int i21 = i15 < i17 ? 1 : -1;
        int i22 = i16 + i20;
        int i23 = i14;
        int i24 = i15;
        int i25 = 0;
        while (i23 != i22) {
            boolean z11 = z10;
            int i26 = iAbs;
            if ((i25 == i18) == this.f1944a.i(z10 ? i24 : i23, z10 ? i23 : i24)) {
                if (i25 == 2) {
                    return u3.a.b(i23, i24, i14, i15);
                }
                i25++;
            }
            i19 += iAbs2;
            if (i19 > 0) {
                if (i24 == i17) {
                    break;
                }
                i24 += i21;
                i19 -= i26;
            }
            i23 += i20;
            iAbs = i26;
            z10 = z11;
            i18 = 1;
        }
        if (i25 == 2) {
            return u3.a.b(i22, i17, i14, i15);
        }
        return Float.NaN;
    }

    public final float j(int i10, int i11, int i12, int i13) {
        float fM;
        float fK;
        float fI = i(i10, i11, i12, i13);
        int iM = i10 - (i12 - i10);
        int iK = 0;
        if (iM < 0) {
            fM = i10 / (i10 - iM);
            iM = 0;
        } else if (iM >= this.f1944a.m()) {
            fM = ((this.f1944a.m() - 1) - i10) / (iM - i10);
            iM = this.f1944a.m() - 1;
        } else {
            fM = 1.0f;
        }
        float f10 = i11;
        int i14 = (int) (f10 - ((i13 - i11) * fM));
        if (i14 < 0) {
            fK = f10 / (i11 - i14);
        } else if (i14 >= this.f1944a.k()) {
            fK = ((this.f1944a.k() - 1) - i11) / (i14 - i11);
            iK = this.f1944a.k() - 1;
        } else {
            iK = i14;
            fK = 1.0f;
        }
        return (fI + i(i10, i11, (int) (i10 + ((iM - i10) * fK)), iK)) - 1.0f;
    }
}
