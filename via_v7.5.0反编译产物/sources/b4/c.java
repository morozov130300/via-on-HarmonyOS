package b4;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v3.c f1733a = new v3.c(v3.a.f13340l);

    public final void a(byte[] bArr, int i10) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f1733a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public final t3.d b(com.google.zxing.qrcode.decoder.a aVar, Map map) throws ChecksumException, FormatException {
        f fVarE = aVar.e();
        ErrorCorrectionLevel errorCorrectionLevelD = aVar.d().d();
        a[] aVarArrB = a.b(aVar.c(), fVarE, errorCorrectionLevelD);
        int iC = 0;
        for (a aVar2 : aVarArrB) {
            iC += aVar2.c();
        }
        byte[] bArr = new byte[iC];
        int i10 = 0;
        for (a aVar3 : aVarArrB) {
            byte[] bArrA = aVar3.a();
            int iC2 = aVar3.c();
            a(bArrA, iC2);
            int i11 = 0;
            while (i11 < iC2) {
                bArr[i10] = bArrA[i11];
                i11++;
                i10++;
            }
        }
        return b.a(bArr, fVarE, errorCorrectionLevelD, map);
    }

    public t3.d c(t3.b bVar, Map map) throws ChecksumException, FormatException {
        ChecksumException e10;
        com.google.zxing.qrcode.decoder.a aVar = new com.google.zxing.qrcode.decoder.a(bVar);
        FormatException formatException = null;
        try {
            return b(aVar, map);
        } catch (ChecksumException e11) {
            e10 = e11;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                t3.d dVarB = b(aVar, map);
                dVarB.j(new e(true));
                return dVarB;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e10;
            }
        } catch (FormatException e12) {
            e10 = null;
            formatException = e12;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            t3.d dVarB2 = b(aVar, map);
            dVarB2.j(new e(true));
            return dVarB2;
        }
    }
}
