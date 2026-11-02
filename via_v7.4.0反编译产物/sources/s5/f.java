package s5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f extends Reader {

    /* renamed from: e, reason: collision with root package name */
    public final InputStreamReader f11854e;

    /* renamed from: j, reason: collision with root package name */
    public final String f11855j;

    public f(InputStream inputStream, String str) throws IOException {
        String str2;
        int i10;
        this.f11855j = str;
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
            this.f11854e = new InputStreamReader(pushbackInputStream);
        } else {
            this.f11854e = new InputStreamReader(pushbackInputStream, str2);
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f11854e.close();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) {
        return this.f11854e.read(cArr, i10, i11);
    }
}
