package b4;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import java.util.Map;
import s3.f;
import s3.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final s3.b f1814a;

    /* renamed from: b, reason: collision with root package name */
    public l f1815b;

    public c(s3.b bVar) {
        this.f1814a = bVar;
    }

    public static int c(k kVar, k kVar2, k kVar3, float f10) throws NotFoundException {
        int iC = (t3.a.c(k.b(kVar, kVar2) / f10) + t3.a.c(k.b(kVar, kVar3) / f10)) / 2;
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

    public static s3.k d(k kVar, k kVar2, k kVar3, k kVar4, int i10) {
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
        return s3.k.b(3.5f, 3.5f, f11, 3.5f, f10, f10, 3.5f, f11, kVar.c(), kVar.d(), kVar2.c(), kVar2.d(), fC, fD, kVar3.c(), kVar3.d());
    }

    public static s3.b h(s3.b bVar, s3.k kVar, int i10) {
        return i.b().c(bVar, i10, i10, kVar);
    }

    public final float a(k kVar, k kVar2, k kVar3) {
        return (b(kVar, kVar2) + b(kVar, kVar3)) / 2.0f;
    }

    public final float b(k kVar, k kVar2) {
        float fJ = j((int) kVar.c(), (int) kVar.d(), (int) kVar2.c(), (int) kVar2.d());
        float fJ2 = j((int) kVar2.c(), (int) kVar2.d(), (int) kVar.c(), (int) kVar.d());
        return Float.isNaN(fJ) ? fJ2 / 7.0f : Float.isNaN(fJ2) ? fJ / 7.0f : (fJ + fJ2) / 14.0f;
    }

    public final f e(Map map) {
        this.f1815b = map == null ? null : (l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return g(new FinderPatternFinder(this.f1814a, this.f1815b).g(map));
    }

    public final a f(float f10, int i10, int i11, float f11) throws NotFoundException {
        int i12 = (int) (f11 * f10);
        int iMax = Math.max(0, i10 - i12);
        int iMin = Math.min(this.f1814a.m() - 1, i10 + i12) - iMax;
        float f12 = 3.0f * f10;
        if (iMin < f12) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i11 - i12);
        int iMin2 = Math.min(this.f1814a.j() - 1, i11 + i12) - iMax2;
        if (iMin2 >= f12) {
            return new b(this.f1814a, iMax, iMax2, iMin, iMin2, f10, this.f1815b).c();
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
        a4.f fVarG = a4.f.g(iC);
        int iE = fVarG.e() - 7;
        if (fVarG.d().length > 0) {
            float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
            float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
            float f10 = 1.0f - (3.0f / iE);
            int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f10));
            int iD = (int) (dVarB.d() + (f10 * (fD - dVarB.d())));
            for (int i10 = 4; i10 <= 16; i10 <<= 1) {
                try {
                    aVarF = f(fA, iC2, iD, i10);
                    break;
                } catch (NotFoundException unused) {
                }
            }
            aVarF = null;
        } else {
            aVarF = null;
        }
        return new f(h(this.f1814a, d(dVarB, dVarC, dVarA, aVarF, iC), iC), aVarF == null ? new k[]{dVarA, dVarB, dVarC} : new k[]{dVarA, dVarB, dVarC, aVarF});
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
            if ((i25 == i18) == this.f1814a.e(z10 ? i24 : i23, z10 ? i23 : i24)) {
                if (i25 == 2) {
                    return t3.a.b(i23, i24, i14, i15);
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
            return t3.a.b(i22, i17, i14, i15);
        }
        return Float.NaN;
    }

    public final float j(int i10, int i11, int i12, int i13) {
        float fM;
        float fJ;
        float fI = i(i10, i11, i12, i13);
        int iM = i10 - (i12 - i10);
        int iJ = 0;
        if (iM < 0) {
            fM = i10 / (i10 - iM);
            iM = 0;
        } else if (iM >= this.f1814a.m()) {
            fM = ((this.f1814a.m() - 1) - i10) / (iM - i10);
            iM = this.f1814a.m() - 1;
        } else {
            fM = 1.0f;
        }
        float f10 = i11;
        int i14 = (int) (f10 - ((i13 - i11) * fM));
        if (i14 < 0) {
            fJ = f10 / (i11 - i14);
        } else if (i14 >= this.f1814a.j()) {
            fJ = ((this.f1814a.j() - 1) - i11) / (i14 - i11);
            iJ = this.f1814a.j() - 1;
        } else {
            iJ = i14;
            fJ = 1.0f;
        }
        return (fI + i(i10, i11, (int) (i10 + ((iM - i10) * fJ)), iJ)) - 1.0f;
    }
}
