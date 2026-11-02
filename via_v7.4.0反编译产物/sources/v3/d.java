package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f12975e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12976a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12977b;

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f12978c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f12979d;

    public d() {
        this(false);
    }

    public d(boolean z10) {
        this(z10, false);
    }

    public d(boolean z10, boolean z11) {
        this.f12976a = z10;
        this.f12977b = z11;
        this.f12978c = new StringBuilder(20);
        this.f12979d = new int[9];
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(CharSequence charSequence) throws FormatException {
        int i10;
        char c10;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i11++;
                char cCharAt2 = charSequence.charAt(i11);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c10 = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i10 = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c10 = ':';
                            }
                            sb2.append(c10);
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i10 = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i10 = cCharAt2 - '&';
                    } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                        i10 = cCharAt2 - 11;
                    } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                        i10 = cCharAt2 + 16;
                    } else if (cCharAt2 < 'P' || cCharAt2 > 'T') {
                        if (cCharAt2 != 'U') {
                            if (cCharAt2 == 'V') {
                                c10 = '@';
                            } else if (cCharAt2 == 'W') {
                                c10 = '`';
                            } else {
                                if (cCharAt2 != 'X' && cCharAt2 != 'Y' && cCharAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c10 = '\u007f';
                            }
                        }
                        sb2.append(c10);
                    } else {
                        i10 = cCharAt2 + '+';
                    }
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i10 = cCharAt2 - '@';
                }
                c10 = (char) i10;
                sb2.append(c10);
            } else {
                sb2.append(cCharAt);
            }
            i11++;
        }
        return sb2.toString();
    }

    public static int[] i(s3.a aVar, int[] iArr) throws NotFoundException {
        int iN = aVar.n();
        int iL = aVar.l(0);
        int length = iArr.length;
        int i10 = iL;
        boolean z10 = false;
        int i11 = 0;
        while (iL < iN) {
            if (aVar.j(iL) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (k(iArr) == 148 && aVar.p(Math.max(0, i10 - ((iL - i10) / 2)), i10, false)) {
                        return new int[]{i10, iL};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i12 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i12);
                    iArr[i12] = 0;
                    iArr[i11] = 0;
                    i11--;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            iL++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static char j(int i10) throws NotFoundException {
        int i11 = 0;
        while (true) {
            int[] iArr = f12975e;
            if (i11 >= iArr.length) {
                if (i10 == 148) {
                    return '*';
                }
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i11] == i10) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i11);
            }
            i11++;
        }
    }

    public static int k(int[] iArr) {
        int length = iArr.length;
        int i10 = 0;
        while (true) {
            int i11 = Integer.MAX_VALUE;
            for (int i12 : iArr) {
                if (i12 < i11 && i12 > i10) {
                    i11 = i12;
                }
            }
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = iArr[i16];
                if (i17 > i11) {
                    i14 |= 1 << ((length - 1) - i16);
                    i13++;
                    i15 += i17;
                }
            }
            if (i13 == 3) {
                for (int i18 = 0; i18 < length && i13 > 0; i18++) {
                    int i19 = iArr[i18];
                    if (i19 > i11) {
                        i13--;
                        if (i19 * 2 >= i15) {
                            return -1;
                        }
                    }
                }
                return i14;
            }
            if (i13 <= 3) {
                return -1;
            }
            i10 = i11;
        }
    }

    @Override // v3.q
    public com.google.zxing.j c(int i10, s3.a aVar, Map map) throws NotFoundException, ChecksumException {
        int[] iArr = this.f12979d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f12978c;
        sb2.setLength(0);
        int iL = aVar.l(i(aVar, iArr)[1]);
        int iN = aVar.n();
        while (true) {
            q.f(aVar, iL, iArr);
            int iK = k(iArr);
            if (iK < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cJ = j(iK);
            sb2.append(cJ);
            int i11 = iL;
            for (int i12 : iArr) {
                i11 += i12;
            }
            int iL2 = aVar.l(i11);
            if (cJ == '*') {
                sb2.setLength(sb2.length() - 1);
                int i13 = 0;
                for (int i14 : iArr) {
                    i13 += i14;
                }
                int i15 = (iL2 - iL) - i13;
                if (iL2 != iN && i15 * 2 < i13) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.f12976a) {
                    int length = sb2.length() - 1;
                    int iIndexOf = 0;
                    for (int i16 = 0; i16 < length; i16++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f12978c.charAt(i16));
                    }
                    if (sb2.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb2.setLength(length);
                }
                if (sb2.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f10 = i10;
                com.google.zxing.j jVar = new com.google.zxing.j(this.f12977b ? h(sb2) : sb2.toString(), null, new com.google.zxing.k[]{new com.google.zxing.k((r2[1] + r2[0]) / 2.0f, f10), new com.google.zxing.k(iL + (i13 / 2.0f), f10)}, BarcodeFormat.CODE_39);
                jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]A0");
                return jVar;
            }
            iL = iL2;
        }
    }
}
