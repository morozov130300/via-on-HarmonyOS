package f4;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {
    public static boolean a(byte[] bArr) {
        if (bArr.length != a.f5896a.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr2 = a.f5896a;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    public static String b(File file) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                long length = randomAccessFile2.length();
                byte[] bArr = new byte[a.f5896a.length];
                long length2 = length - r6.length;
                randomAccessFile2.seek(length2);
                randomAccessFile2.readFully(bArr);
                if (!a(bArr)) {
                    throw new Exception("zip v1 magic not found");
                }
                long j10 = length2 - 2;
                randomAccessFile2.seek(j10);
                int iC = c(randomAccessFile2);
                if (iC <= 0) {
                    throw new Exception("zip channel info not found");
                }
                randomAccessFile2.seek(j10 - iC);
                byte[] bArr2 = new byte[iC];
                randomAccessFile2.readFully(bArr2);
                String str = new String(bArr2, "UTF-8");
                randomAccessFile2.close();
                return str;
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

    public static short c(DataInput dataInput) throws IOException {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }
}
