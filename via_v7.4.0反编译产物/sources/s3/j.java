package s3;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: e, reason: collision with root package name */
    public b f11836e;

    public j(com.google.zxing.d dVar) {
        super(dVar);
    }

    public static int[][] i(byte[] bArr, int i10, int i11, int i12, int i13) {
        int i14 = 8;
        int i15 = i13 - 8;
        int i16 = i12 - 8;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i11, i10);
        int i17 = 0;
        while (i17 < i11) {
            int i18 = i17 << 3;
            if (i18 > i15) {
                i18 = i15;
            }
            int i19 = 0;
            while (i19 < i10) {
                int i20 = i19 << 3;
                if (i20 > i16) {
                    i20 = i16;
                }
                int i21 = (i18 * i12) + i20;
                int i22 = 255;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                while (i23 < i14) {
                    int i26 = i25;
                    int i27 = 0;
                    while (i27 < i14) {
                        int i28 = bArr[i21 + i27] & 255;
                        i24 += i28;
                        if (i28 < i22) {
                            i22 = i28;
                        }
                        if (i28 > i26) {
                            i26 = i28;
                        }
                        i27++;
                        i14 = 8;
                    }
                    if (i26 - i22 > 24) {
                        while (true) {
                            i23++;
                            i21 += i12;
                            if (i23 < 8) {
                                int i29 = 0;
                                for (int i30 = 8; i29 < i30; i30 = 8) {
                                    i24 += bArr[i21 + i29] & 255;
                                    i29++;
                                }
                            }
                        }
                    }
                    i23++;
                    i21 += i12;
                    i25 = i26;
                    i14 = 8;
                }
                int i31 = i24 >> 6;
                if (i25 - i22 <= 24) {
                    i31 = i22 / 2;
                    if (i17 > 0 && i19 > 0) {
                        int[] iArr2 = iArr[i17 - 1];
                        int i32 = i19 - 1;
                        int i33 = ((iArr2[i19] + (iArr[i17][i32] * 2)) + iArr2[i32]) / 4;
                        if (i22 < i33) {
                            i31 = i33;
                        }
                    }
                }
                iArr[i17][i19] = i31;
                i19++;
                i14 = 8;
            }
            i17++;
            i14 = 8;
        }
        return iArr;
    }

    public static void j(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr, b bVar) {
        int i14 = i13 - 8;
        int i15 = i12 - 8;
        for (int i16 = 0; i16 < i11; i16++) {
            int i17 = i16 << 3;
            int i18 = i17 > i14 ? i14 : i17;
            int iK = k(i16, i11 - 3);
            for (int i19 = 0; i19 < i10; i19++) {
                int i20 = i19 << 3;
                int i21 = i20 > i15 ? i15 : i20;
                int iK2 = k(i19, i10 - 3);
                int i22 = 0;
                for (int i23 = -2; i23 <= 2; i23++) {
                    int[] iArr2 = iArr[iK + i23];
                    i22 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[2 + iK2];
                }
                l(bArr, i21, i18, i22 / 25, i12, bVar);
            }
        }
    }

    public static int k(int i10, int i11) {
        if (i10 < 2) {
            return 2;
        }
        return Math.min(i10, i11);
    }

    public static void l(byte[] bArr, int i10, int i11, int i12, int i13, b bVar) {
        int i14 = (i11 * i13) + i10;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                if ((bArr[i14 + i16] & 255) <= i12) {
                    bVar.n(i10 + i16, i11 + i15);
                }
            }
            i15++;
            i14 += i13;
        }
    }

    @Override // com.google.zxing.a
    public com.google.zxing.a a(com.google.zxing.d dVar) {
        return new j(dVar);
    }

    @Override // s3.h, com.google.zxing.a
    public b b() {
        b bVar = this.f11836e;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.d dVarE = e();
        int iD = dVarE.d();
        int iA = dVarE.a();
        if (iD < 40 || iA < 40) {
            this.f11836e = super.b();
        } else {
            byte[] bArrB = dVarE.b();
            int i10 = iD >> 3;
            if ((iD & 7) != 0) {
                i10++;
            }
            int i11 = i10;
            int i12 = iA >> 3;
            if ((iA & 7) != 0) {
                i12++;
            }
            int i13 = i12;
            int[][] iArrI = i(bArrB, i11, i13, iD, iA);
            b bVar2 = new b(iD, iA);
            j(bArrB, i11, i13, iD, iA, iArrI, bVar2);
            this.f11836e = bVar2;
        }
        return this.f11836e;
    }
}
