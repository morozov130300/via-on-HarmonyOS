package a4;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final u3.c f66a = new u3.c(u3.a.f12801l);

    public final void a(byte[] bArr, int i10) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f66a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public final s3.d b(com.google.zxing.qrcode.decoder.a aVar, Map map) throws ChecksumException, FormatException {
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

    public s3.d c(s3.b bVar, Map map) throws ChecksumException, FormatException {
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
                s3.d dVarB = b(aVar, map);
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
            s3.d dVarB2 = b(aVar, map);
            dVarB2.j(new e(true));
            return dVarB2;
        }
    }
}
