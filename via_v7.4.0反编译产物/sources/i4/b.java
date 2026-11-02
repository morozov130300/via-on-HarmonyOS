package i4;

import com.leon.channel.common.verify.ApkSignatureSchemeV2Verifier;
import f4.d;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {
    public static Map a(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try {
                return d.a(d.b(file));
            } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException unused) {
                System.out.println("APK : " + file.getAbsolutePath() + " not have apk signature block");
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static ByteBuffer b(File file, int i10) {
        if (file != null && file.exists() && file.isFile()) {
            Map mapA = a(file);
            System.out.println("getByteBufferValueById , destApk " + file.getAbsolutePath() + " IdValueMap = " + mapA);
            if (mapA != null) {
                return (ByteBuffer) mapA.get(Integer.valueOf(i10));
            }
        }
        return null;
    }

    public static byte[] c(File file, int i10) {
        if (file != null && file.exists() && file.isFile()) {
            ByteBuffer byteBufferB = b(file, i10);
            System.out.println("getByteValueById , id = " + i10 + " , value = " + byteBufferB);
            if (byteBufferB != null) {
                return Arrays.copyOfRange(byteBufferB.array(), byteBufferB.arrayOffset() + byteBufferB.position(), byteBufferB.arrayOffset() + byteBufferB.limit());
            }
        }
        return null;
    }

    public static String d(File file, int i10) {
        byte[] bArrC;
        if (file != null && file.exists() && file.isFile() && (bArrC = c(file, i10)) != null) {
            try {
                if (bArrC.length > 0) {
                    return new String(bArrC, "UTF-8");
                }
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }
}
