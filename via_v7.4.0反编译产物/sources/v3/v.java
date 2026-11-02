package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f13007c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a, reason: collision with root package name */
    public final int[] f13008a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f13009b = new StringBuilder();

    public static int c(int i10) throws NotFoundException {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f13007c[i11]) {
                return i11;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i10 = length - 2; i10 >= 0; i10 -= 2) {
            iCharAt += charSequence.charAt(i10) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
            iCharAt2 += charSequence.charAt(i11) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(String str) throws NumberFormatException {
        String str2;
        String strValueOf;
        char c10 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            str2 = "\u00a3";
        } else if (cCharAt != '5') {
            str2 = "";
            if (cCharAt == '9') {
                switch (str.hashCode()) {
                    case 54118329:
                        if (!str.equals("90000")) {
                            c10 = '\uffff';
                            break;
                        }
                        break;
                    case 54395376:
                        if (str.equals("99990")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 54395377:
                        if (str.equals("99991")) {
                            c10 = 2;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        return null;
                    case 1:
                        return "Used";
                    case 2:
                        return "0.00";
                }
            }
        } else {
            str2 = "$";
        }
        int i10 = Integer.parseInt(str.substring(1));
        String strValueOf2 = String.valueOf(i10 / 100);
        int i11 = i10 % 100;
        if (i11 < 10) {
            strValueOf = "0" + i11;
        } else {
            strValueOf = String.valueOf(i11);
        }
        return str2 + strValueOf2 + '.' + strValueOf;
    }

    public static Map f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) strE);
        return enumMap;
    }

    public final int a(s3.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f13008a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iN = aVar.n();
        int iM = iArr[1];
        int i10 = 0;
        for (int i11 = 0; i11 < 5 && iM < iN; i11++) {
            int iJ = x.j(aVar, iArr2, iM, x.f13017h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i12 : iArr2) {
                iM += i12;
            }
            if (iJ >= 10) {
                i10 |= 1 << (4 - i11);
            }
            if (i11 != 4) {
                iM = aVar.m(aVar.l(iM));
            }
        }
        if (sb2.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (d(sb2.toString()) == c(i10)) {
            return iM;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public com.google.zxing.j b(int i10, s3.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.f13009b;
        sb2.setLength(0);
        int iA = a(aVar, iArr, sb2);
        String string = sb2.toString();
        Map mapF = f(string);
        float f10 = i10;
        com.google.zxing.j jVar = new com.google.zxing.j(string, null, new com.google.zxing.k[]{new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, f10), new com.google.zxing.k(iA, f10)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapF != null) {
            jVar.g(mapF);
        }
        return jVar;
    }
}
