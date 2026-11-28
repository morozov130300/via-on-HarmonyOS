package ua;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e extends Reader {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStreamReader f12941c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12942e;

    public e(InputStream inputStream, String str) throws IOException {
        String str2;
        int i10;
        this.f12942e = str;
        byte[] bArr = new byte[4];
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 4);
        int i11 = pushbackInputStream.read(bArr, 0, 4);
        byte b10 = bArr[0];
        if (b10 == -17 && bArr[1] == -69 && bArr[2] == -65) {
            i10 = i11 - 3;
            str2 = "UTF-8";
        } else if (b10 == -2 && bArr[1] == -1) {
            i10 = i11 - 2;
            str2 = "UTF-16BE";
        } else if (b10 == -1 && bArr[1] == -2) {
            i10 = i11 - 2;
            str2 = "UTF-16LE";
        } else if (b10 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) {
            i10 = i11 - 4;
            str2 = "UTF-32BE";
        } else if (b10 == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0) {
            i10 = i11 - 4;
            str2 = "UTF-32LE";
        } else {
            str2 = str;
            i10 = i11;
        }
        if (i10 > 0) {
            pushbackInputStream.unread(bArr, i11 - i10, i10);
        } else if (i10 < -1) {
            pushbackInputStream.unread(bArr, 0, 0);
        }
        if (str2 == null) {
            this.f12941c = new InputStreamReader(pushbackInputStream);
        } else {
            this.f12941c = new InputStreamReader(pushbackInputStream, str2);
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12941c.close();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) {
        return this.f12941c.read(cArr, i10, i11);
    }
}
