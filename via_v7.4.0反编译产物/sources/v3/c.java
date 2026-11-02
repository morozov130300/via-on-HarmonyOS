package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends q {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f12974a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    public static int h(s3.a aVar, int[] iArr, int i10) throws NotFoundException {
        q.f(aVar, i10, iArr);
        float f10 = 0.25f;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[][] iArr2 = f12974a;
            if (i12 >= iArr2.length) {
                break;
            }
            float fE = q.e(iArr, iArr2[i12], 0.7f);
            if (fE < f10) {
                i11 = i12;
                f10 = fE;
            }
            i12++;
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] i(s3.a aVar) throws NotFoundException {
        int iN = aVar.n();
        int iL = aVar.l(0);
        int[] iArr = new int[6];
        int i10 = iL;
        boolean z10 = false;
        int i11 = 0;
        while (iL < iN) {
            if (aVar.j(iL) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == 5) {
                    int i12 = -1;
                    float f10 = 0.25f;
                    for (int i13 = 103; i13 <= 105; i13++) {
                        float fE = q.e(iArr, f12974a[i13], 0.7f);
                        if (fE < f10) {
                            i12 = i13;
                            f10 = fE;
                        }
                    }
                    if (i12 >= 0 && aVar.p(Math.max(0, i10 - ((iL - i10) / 2)), i10, false)) {
                        return new int[]{i10, iL, i12};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i14 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i14);
                    iArr[i14] = 0;
                    iArr[i11] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            iL++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2 A[FALL_THROUGH, PHI: r20 r21
  0x00c2: PHI (r20v14 boolean) = 
  (r20v5 boolean)
  (r20v5 boolean)
  (r20v5 boolean)
  (r20v5 boolean)
  (r20v15 boolean)
  (r20v15 boolean)
  (r20v15 boolean)
  (r20v15 boolean)
 binds: [B:77:0x012a, B:85:0x0140, B:89:0x014c, B:88:0x0148, B:43:0x00bf, B:51:0x00d6, B:55:0x00e2, B:54:0x00de] A[DONT_GENERATE, DONT_INLINE]
  0x00c2: PHI (r21v10 int) = (r21v1 int), (r21v6 int), (r21v6 int), (r21v6 int), (r21v1 int), (r21v12 int), (r21v12 int), (r21v12 int) binds: [B:77:0x012a, B:85:0x0140, B:89:0x014c, B:88:0x0148, B:43:0x00bf, B:51:0x00d6, B:55:0x00e2, B:54:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4 A[PHI: r20
  0x00f4: PHI (r20v11 boolean) = (r20v5 boolean), (r20v15 boolean) binds: [B:96:0x015d, B:60:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f8 A[PHI: r20
  0x00f8: PHI (r20v10 boolean) = (r20v5 boolean), (r20v5 boolean), (r20v15 boolean), (r20v15 boolean) binds: [B:95:0x015b, B:96:0x015d, B:59:0x00f0, B:60:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ff A[PHI: r20
  0x00ff: PHI (r20v9 boolean) = (r20v5 boolean), (r20v15 boolean) binds: [B:77:0x012a, B:43:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0105 A[PHI: r20
  0x0105: PHI (r20v8 boolean) = (r20v5 boolean), (r20v15 boolean) binds: [B:77:0x012a, B:43:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0109 A[PHI: r20
  0x0109: PHI (r20v7 boolean) = (r20v5 boolean), (r20v15 boolean) binds: [B:76:0x0128, B:42:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // v3.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.google.zxing.j c(int i10, s3.a aVar, Map map) throws NotFoundException, ChecksumException, FormatException {
        char c10;
        boolean z10;
        boolean z11;
        boolean z12 = false;
        boolean z13 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] iArrI = i(aVar);
        int i11 = iArrI[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i11));
        switch (i11) {
            case 103:
                c10 = 'e';
                break;
            case 104:
                c10 = 'd';
                break;
            case 105:
                c10 = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb2 = new StringBuilder(20);
        int i12 = 6;
        int[] iArr = new int[6];
        char c11 = c10;
        int i13 = iArrI[0];
        int i14 = iArrI[1];
        char c12 = c11;
        int i15 = 0;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        int i16 = 0;
        int i17 = 0;
        boolean z17 = true;
        int i18 = 0;
        while (!z15) {
            int iH = h(aVar, iArr, i14);
            arrayList.add(Byte.valueOf((byte) iH));
            if (iH != 106) {
                z17 = true;
            }
            if (iH != 106) {
                i17++;
                i11 += i17 * iH;
            }
            int i19 = i14;
            for (int i20 = 0; i20 < i12; i20++) {
                i19 += iArr[i20];
            }
            switch (iH) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c12) {
                        case 'c':
                            if (iH >= 100) {
                                if (iH != 106) {
                                    z17 = false;
                                }
                                if (iH != 106) {
                                    switch (iH) {
                                        case 100:
                                            z10 = false;
                                            c12 = 'd';
                                            break;
                                        case 101:
                                            z10 = false;
                                            c12 = 'e';
                                            break;
                                        case 102:
                                            if (sb2.length() == 0) {
                                                i18 = 1;
                                            } else if (sb2.length() == 1) {
                                                i18 = 2;
                                            }
                                            if (z13) {
                                                if (sb2.length() == 0) {
                                                    sb2.append("]C1");
                                                } else {
                                                    sb2.append((char) 29);
                                                }
                                            }
                                        default:
                                            z10 = false;
                                            break;
                                    }
                                } else {
                                    z10 = false;
                                    z15 = true;
                                    break;
                                }
                            } else {
                                if (iH < 10) {
                                    sb2.append('0');
                                }
                                sb2.append(iH);
                            }
                            z10 = false;
                        case 'd':
                            if (iH < 96) {
                                if (z12 == z14) {
                                    sb2.append((char) (iH + 32));
                                } else {
                                    sb2.append((char) (iH + 160));
                                }
                                z12 = false;
                                z10 = false;
                                break;
                            } else {
                                if (iH != 106) {
                                    z17 = false;
                                }
                                if (iH != 106) {
                                    switch (iH) {
                                        case 97:
                                            z11 = false;
                                            i18 = 4;
                                            break;
                                        case 98:
                                            z11 = true;
                                            c12 = 'e';
                                            break;
                                        case 99:
                                            z11 = false;
                                            c12 = 'c';
                                            break;
                                        case 100:
                                            if (z14 || !z12) {
                                                if (!z14 || !z12) {
                                                    z11 = false;
                                                    z12 = true;
                                                    break;
                                                } else {
                                                    z11 = false;
                                                    z12 = false;
                                                    z14 = false;
                                                    break;
                                                }
                                            }
                                            z11 = false;
                                            z12 = false;
                                            z14 = true;
                                            break;
                                        case 101:
                                            z11 = false;
                                            c12 = 'e';
                                            break;
                                        case 102:
                                            if (sb2.length() == 0) {
                                                i18 = 1;
                                            } else if (sb2.length() == 1) {
                                                i18 = 2;
                                            }
                                            if (z13) {
                                                if (sb2.length() == 0) {
                                                    sb2.append("]C1");
                                                } else {
                                                    sb2.append((char) 29);
                                                }
                                            }
                                        default:
                                            z11 = false;
                                            break;
                                    }
                                } else {
                                    z11 = false;
                                    z15 = true;
                                }
                                z10 = z11;
                                break;
                            }
                        case 'e':
                            if (iH >= 64) {
                                if (iH >= 96) {
                                    if (iH != 106) {
                                        z17 = false;
                                    }
                                    if (iH != 106) {
                                        switch (iH) {
                                            case 98:
                                                z11 = true;
                                                c12 = 'd';
                                                break;
                                            case 100:
                                                z11 = false;
                                                c12 = 'd';
                                                break;
                                            case 101:
                                                if (z14 || !z12) {
                                                    if (!z14 || !z12) {
                                                    }
                                                }
                                                z11 = false;
                                                z12 = false;
                                                z14 = true;
                                                break;
                                            case 102:
                                                if (sb2.length() == 0) {
                                                    i18 = 1;
                                                } else if (sb2.length() == 1) {
                                                    i18 = 2;
                                                }
                                                if (z13) {
                                                    if (sb2.length() == 0) {
                                                        sb2.append("]C1");
                                                    } else {
                                                        sb2.append((char) 29);
                                                    }
                                                }
                                        }
                                    }
                                    z10 = z11;
                                    break;
                                } else if (z12 == z14) {
                                    sb2.append((char) (iH - 64));
                                } else {
                                    sb2.append((char) (iH + 64));
                                }
                            } else if (z12 == z14) {
                                sb2.append((char) (iH + 32));
                            } else {
                                sb2.append((char) (iH + 160));
                            }
                            z12 = false;
                            z10 = false;
                            break;
                        default:
                            z10 = false;
                            break;
                    }
                    if (z16) {
                        c12 = c12 == 'e' ? 'd' : 'e';
                    }
                    int i21 = i16;
                    i16 = iH;
                    i15 = i21;
                    i13 = i14;
                    z16 = z10;
                    i14 = i19;
                    i12 = 6;
            }
            while (!z15) {
            }
        }
        int i22 = i14 - i13;
        int iM = aVar.m(i14);
        if (!aVar.p(iM, Math.min(aVar.n(), ((iM - i13) / 2) + iM), false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        if ((i11 - (i17 * i15)) % 103 != i15) {
            throw ChecksumException.getChecksumInstance();
        }
        int length = sb2.length();
        if (length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (length > 0 && z17) {
            if (c12 == 'c') {
                sb2.delete(length - 2, length);
            } else {
                sb2.delete(length - 1, length);
            }
        }
        float f10 = (iArrI[1] + iArrI[0]) / 2.0f;
        float f11 = i13 + (i22 / 2.0f);
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i23 = 0; i23 < size; i23++) {
            bArr[i23] = ((Byte) arrayList.get(i23)).byteValue();
        }
        float f12 = i10;
        com.google.zxing.j jVar = new com.google.zxing.j(sb2.toString(), bArr, new com.google.zxing.k[]{new com.google.zxing.k(f10, f12), new com.google.zxing.k(f11, f12)}, BarcodeFormat.CODE_128);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]C" + i18);
        return jVar;
    }
}
