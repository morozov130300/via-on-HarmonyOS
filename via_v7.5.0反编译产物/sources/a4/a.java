package a4;

import b4.c;
import b4.e;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.k;
import java.util.List;
import java.util.Map;
import t3.d;
import t3.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k[] f53b = new k[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f54a = new c();

    public static t3.b c(t3.b bVar) throws NotFoundException {
        int[] iArrL = bVar.l();
        int[] iArrJ = bVar.j();
        if (iArrL == null || iArrJ == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fD = d(iArrL, bVar);
        int i10 = iArrL[1];
        int i11 = iArrJ[1];
        int i12 = iArrL[0];
        int i13 = iArrJ[0];
        if (i12 >= i13 || i10 >= i11) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i14 = i11 - i10;
        if (i14 != i13 - i12 && (i13 = i12 + i14) >= bVar.m()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iRound = Math.round(((i13 - i12) + 1) / fD);
        int iRound2 = Math.round((i14 + 1) / fD);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = (int) (fD / 2.0f);
        int i16 = i10 + i15;
        int i17 = i12 + i15;
        int i18 = (((int) ((iRound - 1) * fD)) + i17) - i13;
        if (i18 > 0) {
            if (i18 > i15) {
                throw NotFoundException.getNotFoundInstance();
            }
            i17 -= i18;
        }
        int i19 = (((int) ((iRound2 - 1) * fD)) + i16) - i11;
        if (i19 > 0) {
            if (i19 > i15) {
                throw NotFoundException.getNotFoundInstance();
            }
            i16 -= i19;
        }
        t3.b bVar2 = new t3.b(iRound, iRound2);
        for (int i20 = 0; i20 < iRound2; i20++) {
            int i21 = ((int) (i20 * fD)) + i16;
            for (int i22 = 0; i22 < iRound; i22++) {
                if (bVar.i(((int) (i22 * fD)) + i17, i21)) {
                    bVar2.n(i22, i20);
                }
            }
        }
        return bVar2;
    }

    public static float d(int[] iArr, t3.b bVar) throws NotFoundException {
        int iK = bVar.k();
        int iM = bVar.m();
        int i10 = iArr[0];
        boolean z10 = true;
        int i11 = iArr[1];
        int i12 = 0;
        while (i10 < iM && i11 < iK) {
            if (z10 != bVar.i(i10, i11)) {
                i12++;
                if (i12 == 5) {
                    break;
                }
                z10 = !z10;
            }
            i10++;
            i11++;
        }
        if (i10 == iM || i11 == iK) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i10 - iArr[0]) / 7.0f;
    }

    @Override // com.google.zxing.i
    public final j a(com.google.zxing.b bVar, Map map) throws NotFoundException, ChecksumException, FormatException {
        k[] kVarArrB;
        d dVarC;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f fVarE = new c4.c(bVar.a()).e(map);
            d dVarC2 = this.f54a.c(fVarE.a(), map);
            kVarArrB = fVarE.b();
            dVarC = dVarC2;
        } else {
            dVarC = this.f54a.c(c(bVar.a()), map);
            kVarArrB = f53b;
        }
        if (dVarC.c() instanceof e) {
            ((e) dVarC.c()).a(kVarArrB);
        }
        j jVar = new j(dVarC.h(), dVarC.d(), kVarArrB, BarcodeFormat.QR_CODE);
        List listA = dVarC.a();
        if (listA != null) {
            jVar.h(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = dVarC.b();
        if (strB != null) {
            jVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        if (dVarC.i()) {
            jVar.h(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVarC.f()));
            jVar.h(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVarC.e()));
        }
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]Q" + dVarC.g());
        return jVar;
    }

    @Override // com.google.zxing.i
    public j b(com.google.zxing.b bVar) {
        return a(bVar, null);
    }

    @Override // com.google.zxing.i
    public void reset() {
    }
}
