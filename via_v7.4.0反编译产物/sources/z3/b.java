package z3;

import c4.e;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.m;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements m {
    public static s3.b b(e eVar, int i10, int i11, int i12) {
        c4.b bVarA = eVar.a();
        if (bVarA == null) {
            throw new IllegalStateException();
        }
        int iE = bVarA.e();
        int iD = bVarA.d();
        int i13 = i12 * 2;
        int i14 = iE + i13;
        int i15 = i13 + iD;
        int iMax = Math.max(i10, i14);
        int iMax2 = Math.max(i11, i15);
        int iMin = Math.min(iMax / i14, iMax2 / i15);
        int i16 = (iMax - (iE * iMin)) / 2;
        int i17 = (iMax2 - (iD * iMin)) / 2;
        s3.b bVar = new s3.b(iMax, iMax2);
        int i18 = 0;
        while (i18 < iD) {
            int i19 = i16;
            int i20 = 0;
            while (i20 < iE) {
                if (bVarA.b(i20, i18) == 1) {
                    bVar.o(i19, i17, iMin, iMin);
                }
                i20++;
                i19 += iMin;
            }
            i18++;
            i17 += iMin;
        }
        return bVar;
    }

    @Override // com.google.zxing.m
    public s3.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map map) throws NumberFormatException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + 'x' + i11);
        }
        ErrorCorrectionLevel errorCorrectionLevelValueOf = ErrorCorrectionLevel.L;
        int i12 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevelValueOf = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i12 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return b(com.google.zxing.qrcode.encoder.a.n(str, errorCorrectionLevelValueOf, map), i10, i11, i12);
    }
}
