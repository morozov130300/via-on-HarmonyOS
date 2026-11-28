package w3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f13620a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f13621b = new StringBuilder();

    public static Map c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    public final int a(t3.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f13620a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iN = aVar.n();
        int iM = iArr[1];
        int i10 = 0;
        for (int i11 = 0; i11 < 2 && iM < iN; i11++) {
            int iJ = x.j(aVar, iArr2, iM, x.f13632h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i12 : iArr2) {
                iM += i12;
            }
            if (iJ >= 10) {
                i10 |= 1 << (1 - i11);
            }
            if (i11 != 1) {
                iM = aVar.m(aVar.l(iM));
            }
        }
        if (sb2.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb2.toString()) % 4 == i10) {
            return iM;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public com.google.zxing.j b(int i10, t3.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.f13621b;
        sb2.setLength(0);
        int iA = a(aVar, iArr, sb2);
        String string = sb2.toString();
        Map mapC = c(string);
        float f10 = i10;
        com.google.zxing.j jVar = new com.google.zxing.j(string, null, new com.google.zxing.k[]{new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, f10), new com.google.zxing.k(iA, f10)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapC != null) {
            jVar.g(mapC);
        }
        return jVar;
    }
}
