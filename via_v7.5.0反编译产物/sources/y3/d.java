package y3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.j;
import com.google.zxing.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w3.q;
import x3.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends x3.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f14835k = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f14836l = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f14837m = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[][] f14838n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[][] f14839o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[][] f14840p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f14841g = new ArrayList(11);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f14842h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f14843i = new int[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14844j;

    public static boolean A(x3.c cVar, boolean z10, boolean z11) {
        return (cVar.c() == 0 && z10 && z11) ? false : true;
    }

    public static boolean B(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                Iterator it3 = cVar.a().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (bVar.equals((b) it3.next())) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean C(List list) {
        for (int[] iArr : f14840p) {
            if (list.size() <= iArr.length) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (((b) list.get(i10)).a().c() == iArr[i10]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void E(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.a().size() != collection.size()) {
                Iterator it2 = cVar.a().iterator();
                do {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                } while (collection.contains((b) it2.next()));
            }
        }
    }

    public static void G(int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length / 2; i10++) {
            int i11 = iArr[i10];
            int i12 = (length - i10) - 1;
            iArr[i10] = iArr[i12];
            iArr[i12] = i11;
        }
    }

    public static j v(List list) {
        String strD = z3.j.a(a.a(list)).d();
        k[] kVarArrA = ((b) list.get(0)).a().a();
        k[] kVarArrA2 = ((b) list.get(list.size() - 1)).a().a();
        j jVar = new j(strD, null, new k[]{kVarArrA[0], kVarArrA[1], kVarArrA2[0], kVarArrA2[1]}, BarcodeFormat.RSS_EXPANDED);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return jVar;
    }

    public static int z(t3.a aVar, int i10) {
        return aVar.k(i10) ? aVar.l(aVar.m(i10)) : aVar.m(aVar.l(i10));
    }

    public final x3.c D(t3.a aVar, int i10, boolean z10) {
        int iM;
        int i11;
        int i12;
        if (z10) {
            int i13 = this.f14843i[0] - 1;
            while (i13 >= 0 && !aVar.k(i13)) {
                i13--;
            }
            int i14 = i13 + 1;
            int[] iArr = this.f14843i;
            i12 = iArr[0] - i14;
            iM = iArr[1];
            i11 = i14;
        } else {
            int[] iArr2 = this.f14843i;
            int i15 = iArr2[0];
            iM = aVar.m(iArr2[1] + 1);
            i11 = i15;
            i12 = iM - this.f14843i[1];
        }
        int i16 = iM;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i12;
        try {
            return new x3.c(x3.a.q(iArrJ, f14838n), new int[]{i11, i16}, i11, i16, i10);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public b F(t3.a aVar, List list, int i10) throws NotFoundException {
        x3.c cVarD;
        x3.b bVarW;
        boolean z10 = list.size() % 2 == 0;
        if (this.f14844j) {
            z10 = !z10;
        }
        int iZ = -1;
        boolean z11 = true;
        do {
            y(aVar, list, iZ);
            cVarD = D(aVar, i10, z10);
            if (cVarD == null) {
                iZ = z(aVar, this.f14843i[0]);
            } else {
                z11 = false;
            }
        } while (z11);
        x3.b bVarW2 = w(aVar, cVarD, z10, true);
        if (!list.isEmpty() && ((b) list.get(list.size() - 1)).d()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            bVarW = w(aVar, cVarD, z10, false);
        } catch (NotFoundException unused) {
            bVarW = null;
        }
        return new b(bVarW2, bVarW, cVarD);
    }

    public final void H(int i10) {
        boolean zC = false;
        int i11 = 0;
        boolean zC2 = false;
        while (i11 < this.f14842h.size()) {
            c cVar = (c) this.f14842h.get(i11);
            if (cVar.b() > i10) {
                zC = cVar.c(this.f14841g);
                break;
            } else {
                zC2 = cVar.c(this.f14841g);
                i11++;
            }
        }
        if (zC || zC2 || B(this.f14841g, this.f14842h)) {
            return;
        }
        this.f14842h.add(i11, new c(this.f14841g, i10));
        E(this.f14841g, this.f14842h);
    }

    @Override // w3.q
    public j c(int i10, t3.a aVar, Map map) {
        this.f14841g.clear();
        this.f14844j = false;
        try {
            return v(x(i10, aVar));
        } catch (NotFoundException unused) {
            this.f14841g.clear();
            this.f14844j = true;
            return v(x(i10, aVar));
        }
    }

    public final void r(int i10) throws NotFoundException {
        boolean z10;
        boolean z11;
        boolean z12;
        int iD = u3.a.d(m());
        int iD2 = u3.a.d(k());
        boolean z13 = true;
        if (iD > 13) {
            z13 = false;
            z10 = true;
        } else {
            z13 = iD < 4;
            z10 = false;
        }
        if (iD2 > 13) {
            z11 = false;
            z12 = true;
        } else {
            z11 = iD2 < 4;
            z12 = false;
        }
        int i11 = (iD + iD2) - i10;
        boolean z14 = (iD & 1) == 1;
        boolean z15 = (iD2 & 1) == 0;
        if (i11 != -1) {
            if (i11 != 0) {
                if (i11 != 1) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z14) {
                    if (z15) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z10 = true;
                } else {
                    if (!z15) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z13 = z13;
                    z12 = true;
                }
            } else if (z14) {
                if (!z15) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iD < iD2) {
                    z12 = true;
                } else {
                    z11 = true;
                    z10 = true;
                }
            } else {
                if (z15) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z13 = z13;
            }
        } else if (z14) {
            if (z15) {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            if (!z15) {
                throw NotFoundException.getNotFoundInstance();
            }
            z13 = z13;
            z11 = true;
        }
        if (z13) {
            if (z10) {
                throw NotFoundException.getNotFoundInstance();
            }
            x3.a.o(m(), n());
        }
        if (z10) {
            x3.a.h(m(), n());
        }
        if (z11) {
            if (z12) {
                throw NotFoundException.getNotFoundInstance();
            }
            x3.a.o(k(), n());
        }
        if (z12) {
            x3.a.h(k(), l());
        }
    }

    @Override // w3.q, com.google.zxing.i
    public void reset() {
        this.f14841g.clear();
        this.f14842h.clear();
    }

    public final boolean s() {
        b bVar = (b) this.f14841g.get(0);
        x3.b bVarB = bVar.b();
        x3.b bVarC = bVar.c();
        if (bVarC == null) {
            return false;
        }
        int iA = bVarC.a();
        int i10 = 2;
        for (int i11 = 1; i11 < this.f14841g.size(); i11++) {
            b bVar2 = (b) this.f14841g.get(i11);
            iA += bVar2.b().a();
            int i12 = i10 + 1;
            x3.b bVarC2 = bVar2.c();
            if (bVarC2 != null) {
                iA += bVarC2.a();
                i10 += 2;
            } else {
                i10 = i12;
            }
        }
        return ((i10 + (-4)) * 211) + (iA % 211) == bVarB.b();
    }

    public final List t(List list, int i10) throws NotFoundException {
        while (i10 < this.f14842h.size()) {
            c cVar = (c) this.f14842h.get(i10);
            this.f14841g.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f14841g.addAll(((c) it.next()).a());
            }
            this.f14841g.addAll(cVar.a());
            if (C(this.f14841g)) {
                if (s()) {
                    return this.f14841g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return t(arrayList, i10 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final List u(boolean z10) {
        List listT = null;
        if (this.f14842h.size() > 25) {
            this.f14842h.clear();
            return null;
        }
        this.f14841g.clear();
        if (z10) {
            Collections.reverse(this.f14842h);
        }
        try {
            listT = t(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z10) {
            Collections.reverse(this.f14842h);
        }
        return listT;
    }

    public x3.b w(t3.a aVar, x3.c cVar, boolean z10, boolean z11) throws NotFoundException {
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z11) {
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
        float fD = u3.a.d(iArrI) / 17;
        float f10 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fD - f10) / f10 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i12 = 0; i12 < iArrI.length; i12++) {
            float f11 = (iArrI[i12] * 1.0f) / fD;
            int i13 = (int) (0.5f + f11);
            if (i13 < 1) {
                if (f11 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i13 = 1;
            } else if (i13 > 8) {
                if (f11 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i13 = 8;
            }
            int i14 = i12 / 2;
            if ((i12 & 1) == 0) {
                iArrM[i14] = i13;
                fArrN[i14] = f11 - i13;
            } else {
                iArrK[i14] = i13;
                fArrL[i14] = f11 - i13;
            }
        }
        r(17);
        int iC = (((cVar.c() * 4) + (z10 ? 0 : 2)) + (!z11 ? 1 : 0)) - 1;
        int i15 = 0;
        int i16 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            if (A(cVar, z10, z11)) {
                i15 += iArrM[length2] * f14839o[iC][length2 * 2];
            }
            i16 += iArrM[length2];
        }
        int i17 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            if (A(cVar, z10, z11)) {
                i17 += iArrK[length3] * f14839o[iC][(length3 * 2) + 1];
            }
        }
        int i18 = i15 + i17;
        if ((i16 & 1) != 0 || i16 > 13 || i16 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i19 = (13 - i16) / 2;
        int i20 = f14835k[i19];
        return new x3.b((f.b(iArrM, i20, true) * f14836l[i19]) + f.b(iArrK, 9 - i20, false) + f14837m[i19], i18);
    }

    public List x(int i10, t3.a aVar) throws NotFoundException {
        boolean z10 = false;
        while (!z10) {
            try {
                List list = this.f14841g;
                list.add(F(aVar, list, i10));
            } catch (NotFoundException e10) {
                if (this.f14841g.isEmpty()) {
                    throw e10;
                }
                z10 = true;
            }
        }
        if (s()) {
            return this.f14841g;
        }
        boolean zIsEmpty = this.f14842h.isEmpty();
        H(i10);
        if (!zIsEmpty) {
            List listU = u(false);
            if (listU != null) {
                return listU;
            }
            List listU2 = u(true);
            if (listU2 != null) {
                return listU2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void y(t3.a aVar, List list, int i10) throws NotFoundException {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iN = aVar.n();
        if (i10 < 0) {
            i10 = list.isEmpty() ? 0 : ((b) list.get(list.size() - 1)).a().b()[1];
        }
        boolean z10 = list.size() % 2 != 0;
        if (this.f14844j) {
            z10 = !z10;
        }
        boolean z11 = false;
        while (i10 < iN) {
            boolean zK = aVar.k(i10);
            boolean z12 = !zK;
            if (zK) {
                z11 = z12;
                break;
            } else {
                i10++;
                z11 = z12;
            }
        }
        boolean z13 = z11;
        int i11 = 0;
        int i12 = i10;
        while (i10 < iN) {
            if (aVar.k(i10) != z13) {
                iArrJ[i11] = iArrJ[i11] + 1;
            } else {
                if (i11 == 3) {
                    if (z10) {
                        G(iArrJ);
                    }
                    if (x3.a.p(iArrJ)) {
                        int[] iArr = this.f14843i;
                        iArr[0] = i12;
                        iArr[1] = i10;
                        return;
                    }
                    if (z10) {
                        G(iArrJ);
                    }
                    i12 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArrJ[i11] = 1;
                z13 = !z13;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
