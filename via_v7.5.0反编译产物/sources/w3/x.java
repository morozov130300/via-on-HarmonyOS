package w3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class x extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f13628d = {1, 1, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f13629e = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f13630f = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[][] f13631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[][] f13632h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f13633a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f13634b = new w();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f13635c = new l();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f13631g = iArr;
        int[][] iArr2 = new int[20][];
        f13632h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i10 = 10; i10 < 20; i10++) {
            int[] iArr3 = f13631g[i10 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i11 = 0; i11 < iArr3.length; i11++) {
                iArr4[i11] = iArr3[(iArr3.length - i11) - 1];
            }
            f13632h[i10] = iArr4;
        }
    }

    public static boolean i(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i10 = length - 1;
        return r(charSequence.subSequence(0, i10)) == Character.digit(charSequence.charAt(i10), 10);
    }

    public static int j(t3.a aVar, int[] iArr, int i10, int[][] iArr2) throws NotFoundException {
        q.f(aVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.48f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float fE = q.e(iArr, iArr2[i12], 0.7f);
            if (fE < f10) {
                i11 = i12;
                f10 = fE;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] n(t3.a aVar, int i10, boolean z10, int[] iArr) {
        return o(aVar, i10, z10, iArr, new int[iArr.length]);
    }

    public static int[] o(t3.a aVar, int i10, boolean z10, int[] iArr, int[] iArr2) throws NotFoundException {
        int iN = aVar.n();
        int iM = z10 ? aVar.m(i10) : aVar.l(i10);
        int length = iArr.length;
        boolean z11 = z10;
        int i11 = 0;
        int i12 = iM;
        while (iM < iN) {
            if (aVar.k(iM) != z11) {
                iArr2[i11] = iArr2[i11] + 1;
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (q.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i12, iM};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i13 = i11 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i11] = 0;
                    i11--;
                }
                iArr2[i11] = 1;
                z11 = !z11;
            }
            iM++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] p(t3.a aVar) throws NotFoundException {
        int[] iArr = new int[f13628d.length];
        int[] iArrO = null;
        boolean zP = false;
        int i10 = 0;
        while (!zP) {
            int[] iArr2 = f13628d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrO = o(aVar, i10, false, iArr2, iArr);
            int i11 = iArrO[0];
            int i12 = iArrO[1];
            int i13 = i11 - (i12 - i11);
            if (i13 >= 0) {
                zP = aVar.p(i13, i11, false);
            }
            i10 = i12;
        }
        return iArrO;
    }

    public static int r(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
            int iCharAt = charSequence.charAt(i11) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i10 += iCharAt;
        }
        int i12 = i10 * 3;
        for (int i13 = length - 2; i13 >= 0; i13 -= 2) {
            int iCharAt2 = charSequence.charAt(i13) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i12 += iCharAt2;
        }
        return (1000 - i12) % 10;
    }

    @Override // w3.q
    public com.google.zxing.j c(int i10, t3.a aVar, Map map) {
        return m(i10, aVar, p(aVar), map);
    }

    public boolean h(String str) {
        return i(str);
    }

    public int[] k(t3.a aVar, int i10) {
        return n(aVar, i10, false, f13628d);
    }

    public abstract int l(t3.a aVar, int[] iArr, StringBuilder sb2);

    public com.google.zxing.j m(int i10, t3.a aVar, int[] iArr, Map map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        String strC;
        com.google.zxing.l lVar = map == null ? null : (com.google.zxing.l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, i10));
        }
        StringBuilder sb2 = this.f13633a;
        sb2.setLength(0);
        int iL = l(aVar, iArr, sb2);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k(iL, i10));
        }
        int[] iArrK = k(aVar, iL);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k((iArrK[0] + iArrK[1]) / 2.0f, i10));
        }
        int i11 = iArrK[1];
        int i12 = (i11 - iArrK[0]) + i11;
        if (i12 >= aVar.n() || !aVar.p(i11, i12, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String string = sb2.toString();
        if (string.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!h(string)) {
            throw ChecksumException.getChecksumInstance();
        }
        float f10 = (iArr[1] + iArr[0]) / 2.0f;
        float f11 = (iArrK[1] + iArrK[0]) / 2.0f;
        BarcodeFormat barcodeFormatQ = q();
        float f12 = i10;
        com.google.zxing.j jVar = new com.google.zxing.j(string, null, new com.google.zxing.k[]{new com.google.zxing.k(f10, f12), new com.google.zxing.k(f11, f12)}, barcodeFormatQ);
        try {
            com.google.zxing.j jVarA = this.f13634b.a(i10, aVar, iArrK[1]);
            jVar.h(ResultMetadataType.UPC_EAN_EXTENSION, jVarA.f());
            jVar.g(jVarA.d());
            jVar.a(jVarA.e());
            length = jVarA.f().length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (length == iArr2[i13]) {
                    break;
                }
                i13++;
            }
        }
        if ((barcodeFormatQ == BarcodeFormat.EAN_13 || barcodeFormatQ == BarcodeFormat.UPC_A) && (strC = this.f13635c.c(string)) != null) {
            jVar.h(ResultMetadataType.POSSIBLE_COUNTRY, strC);
        }
        int i14 = barcodeFormatQ == BarcodeFormat.EAN_8 ? 4 : 0;
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]E" + i14);
        return jVar;
    }

    public abstract BarcodeFormat q();
}
