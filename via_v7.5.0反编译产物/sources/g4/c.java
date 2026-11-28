package g4;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static boolean a(byte[] bArr) {
        if (bArr.length != a.f5512a.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr2 = a.f5512a;
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
                byte[] bArr = a.f5512a;
                byte[] bArr2 = new byte[bArr.length];
                long length2 = length - ((long) bArr.length);
                randomAccessFile2.seek(length2);
                randomAccessFile2.readFully(bArr2);
                if (!a(bArr2)) {
                    throw new Exception("zip v1 magic not found");
                }
                long j10 = length2 - 2;
                randomAccessFile2.seek(j10);
                int iC = c(randomAccessFile2);
                if (iC <= 0) {
                    throw new Exception("zip channel info not found");
                }
                randomAccessFile2.seek(j10 - ((long) iC));
                byte[] bArr3 = new byte[iC];
                randomAccessFile2.readFully(bArr3);
                String str = new String(bArr3, "UTF-8");
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
