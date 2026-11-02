package w3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import v3.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f13241i = {1, 10, 34, 70, 126};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f13242j = {4, 20, 48, 81};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f13243k = {0, 161, 961, 2015, 2715};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f13244l = {0, 336, 1036, 1516};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f13245m = {8, 6, 4, 3, 1};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f13246n = {2, 4, 6, 8};

    /* renamed from: o, reason: collision with root package name */
    public static final int[][] f13247o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: g, reason: collision with root package name */
    public final List f13248g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List f13249h = new ArrayList();

    public static void r(Collection collection, d dVar) {
        if (dVar == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    public static boolean t(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    public static j u(d dVar, d dVar2) {
        String strValueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb2 = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(strValueOf);
        int i10 = 0;
        for (int i11 = 0; i11 < 13; i11++) {
            int iCharAt = sb2.charAt(i11) - '0';
            if ((i11 & 1) == 0) {
                iCharAt *= 3;
            }
            i10 += iCharAt;
        }
        int i12 = 10 - (i10 % 10);
        if (i12 == 10) {
            i12 = 0;
        }
        sb2.append(i12);
        k[] kVarArrA = dVar.d().a();
        k[] kVarArrA2 = dVar2.d().a();
        j jVar = new j(sb2.toString(), null, new k[]{kVarArrA[0], kVarArrA[1], kVarArrA2[0], kVarArrA2[1]}, BarcodeFormat.RSS_14);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return jVar;
    }

    @Override // v3.q
    public j c(int i10, s3.a aVar, Map map) throws NotFoundException {
        r(this.f13248g, w(aVar, false, i10, map));
        aVar.r();
        r(this.f13249h, w(aVar, true, i10, map));
        aVar.r();
        for (d dVar : this.f13248g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f13249h) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // v3.q, com.google.zxing.i
    public void reset() {
        this.f13248g.clear();
        this.f13249h.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[PHI: r6 r7
  0x002a: PHI (r6v7 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002a: PHI (r7v5 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[PHI: r6 r7
  0x002d: PHI (r6v5 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002d: PHI (r7v3 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(boolean z10, int i10) throws NotFoundException {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int iD = t3.a.d(m());
        int iD2 = t3.a.d(k());
        boolean z15 = true;
        if (z10) {
            if (iD > 12) {
                z11 = false;
                z12 = true;
            } else {
                z11 = iD < 4;
                z12 = false;
            }
            if (iD2 <= 12) {
                z13 = iD2 < 4;
                z14 = false;
            }
            z13 = false;
            z14 = true;
        } else {
            if (iD > 11) {
                z11 = false;
                z12 = true;
            } else {
                z11 = iD < 5;
                z12 = false;
            }
            if (iD2 <= 10) {
                if (iD2 < 4) {
                }
                z14 = false;
            }
            z13 = false;
            z14 = true;
        }
        int i11 = (iD + iD2) - i10;
        boolean z16 = (iD & 1) == z10;
        boolean z17 = (iD2 & 1) == 1;
        if (i11 != -1) {
            if (i11 != 0) {
                if (i11 != 1) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z16) {
                    if (z17) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z15 = z11;
                    z12 = true;
                } else {
                    if (!z17) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z15 = z11;
                    z14 = true;
                }
            } else if (z16) {
                if (!z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iD >= iD2) {
                    z15 = z11;
                    z13 = true;
                    z12 = true;
                }
                z14 = true;
            } else {
                if (z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z15 = z11;
            }
        } else if (z16) {
            if (z17) {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            if (!z17) {
                throw NotFoundException.getNotFoundInstance();
            }
            z15 = z11;
            z13 = true;
        }
        if (z15) {
            if (z12) {
                throw NotFoundException.getNotFoundInstance();
            }
            a.o(m(), n());
        }
        if (z12) {
            a.h(m(), n());
        }
        if (z13) {
            if (z14) {
                throw NotFoundException.getNotFoundInstance();
            }
            a.o(k(), n());
        }
        if (z14) {
            a.h(k(), l());
        }
    }

    public final b v(s3.a aVar, c cVar, boolean z10) throws NotFoundException {
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z10) {
            q.g(aVar, cVar.b()[0], iArrI);
        } else {
            q.f(aVar, cVar.b()[1], iArrI);
            int i10 = 0;
            for (int length = iArrI.length - 1; i10 < length; length--) {
                int i11 = iArrI[i10];
                iArrI[i10] = iArrI[length];
                iArrI[length] = i11;
                i10++;
            }
        }
        int i12 = z10 ? 16 : 15;
        float fD = t3.a.d(iArrI) / i12;
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i13 = 0; i13 < iArrI.length; i13++) {
            float f10 = iArrI[i13] / fD;
            int i14 = (int) (0.5f + f10);
            if (i14 < 1) {
                i14 = 1;
            } else if (i14 > 8) {
                i14 = 8;
            }
            int i15 = i13 / 2;
            if ((i13 & 1) == 0) {
                iArrM[i15] = i14;
                fArrN[i15] = f10 - i14;
            } else {
                iArrK[i15] = i14;
                fArrL[i15] = f10 - i14;
            }
        }
        s(z10, i12);
        int i16 = 0;
        int i17 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            int i18 = iArrM[length2];
            i16 = (i16 * 9) + i18;
            i17 += i18;
        }
        int i19 = 0;
        int i20 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            int i21 = iArrK[length3];
            i19 = (i19 * 9) + i21;
            i20 += i21;
        }
        int i22 = i16 + (i19 * 3);
        if (!z10) {
            if ((i20 & 1) != 0 || i20 > 10 || i20 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i23 = (10 - i20) / 2;
            int i24 = f13246n[i23];
            return new b((f.b(iArrK, 9 - i24, false) * f13242j[i23]) + f.b(iArrM, i24, true) + f13244l[i23], i22);
        }
        if ((i17 & 1) != 0 || i17 > 12 || i17 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i25 = (12 - i17) / 2;
        int i26 = f13245m[i25];
        return new b((f.b(iArrM, i26, false) * f13241i[i25]) + f.b(iArrK, 9 - i26, true) + f13243k[i25], i22);
    }

    public final d w(s3.a aVar, boolean z10, int i10, Map map) {
        try {
            c cVarY = y(aVar, i10, z10, x(aVar, z10));
            l lVar = map == null ? null : (l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (lVar != null) {
                int[] iArrB = cVarY.b();
                float fN = ((iArrB[0] + iArrB[1]) - 1) / 2.0f;
                if (z10) {
                    fN = (aVar.n() - 1) - fN;
                }
                lVar.a(new k(fN, i10));
            }
            b bVarV = v(aVar, cVarY, true);
            b bVarV2 = v(aVar, cVarY, false);
            return new d((bVarV.b() * 1597) + bVarV2.b(), bVarV.a() + (bVarV2.a() * 4), cVarY);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] x(s3.a aVar, boolean z10) throws NotFoundException {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iN = aVar.n();
        int i10 = 0;
        boolean z11 = false;
        while (i10 < iN) {
            z11 = !aVar.j(i10);
            if (z10 == z11) {
                break;
            }
            i10++;
        }
        int i11 = i10;
        int i12 = 0;
        while (i10 < iN) {
            if (aVar.j(i10) != z11) {
                iArrJ[i12] = iArrJ[i12] + 1;
            } else {
                if (i12 != 3) {
                    i12++;
                } else {
                    if (a.p(iArrJ)) {
                        return new int[]{i11, i10};
                    }
                    i11 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i12--;
                }
                iArrJ[i12] = 1;
                z11 = !z11;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final c y(s3.a aVar, int i10, boolean z10, int[] iArr) throws NotFoundException {
        int i11;
        boolean zJ = aVar.j(iArr[0]);
        int i12 = iArr[0] - 1;
        while (i12 >= 0 && zJ != aVar.j(i12)) {
            i12--;
        }
        int i13 = i12 + 1;
        int i14 = iArr[0] - i13;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i14;
        int iQ = a.q(iArrJ, f13247o);
        int iN = iArr[1];
        if (z10) {
            int iN2 = (aVar.n() - 1) - i13;
            iN = (aVar.n() - 1) - iN;
            i11 = iN2;
        } else {
            i11 = i13;
        }
        return new c(iQ, new int[]{i13, iArr[1]}, i11, iN, i10);
    }
}
