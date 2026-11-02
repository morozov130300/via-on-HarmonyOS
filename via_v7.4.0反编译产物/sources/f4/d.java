package f4;

import com.leon.channel.common.verify.ApkSignatureSchemeV2Verifier;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static Map a(ByteBuffer byteBuffer) throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        ApkSignatureSchemeV2Verifier.a(byteBuffer);
        ByteBuffer byteBufferF = ApkSignatureSchemeV2Verifier.f(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 0;
        while (byteBufferF.hasRemaining()) {
            i10++;
            if (byteBufferF.remaining() < 8) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i10);
            }
            long j10 = byteBufferF.getLong();
            if (j10 < 4 || j10 > 2147483647L) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i10 + " size out of range: " + j10);
            }
            int i11 = (int) j10;
            int iPosition = byteBufferF.position() + i11;
            if (i11 > byteBufferF.remaining()) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i10 + " size out of range: " + i11 + ", available: " + byteBufferF.remaining());
            }
            int i12 = byteBufferF.getInt();
            linkedHashMap.put(Integer.valueOf(i12), ApkSignatureSchemeV2Verifier.c(byteBufferF, i11 - 4));
            if (i12 == 1896449818) {
                System.out.println("find V2 signature block Id : 1896449818");
            }
            byteBufferF.position(iPosition);
        }
        if (!linkedHashMap.isEmpty()) {
            return linkedHashMap;
        }
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("not have Id-Value Pair in APK Signing Block entry #" + i10);
    }

    public static ByteBuffer b(File file) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                b bVarE = ApkSignatureSchemeV2Verifier.e(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) bVarE.b();
                long jLongValue = ((Long) bVarE.c()).longValue();
                if (g4.a.i(randomAccessFile2, jLongValue)) {
                    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
                }
                ByteBuffer byteBuffer2 = (ByteBuffer) ApkSignatureSchemeV2Verifier.b(randomAccessFile2, ApkSignatureSchemeV2Verifier.d(byteBuffer, jLongValue)).b();
                randomAccessFile2.close();
                return byteBuffer2;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
