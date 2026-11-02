package d4;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    public final InputStream f4570e;

    /* renamed from: j, reason: collision with root package name */
    public final Charset f4571j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f4572k;

    /* renamed from: l, reason: collision with root package name */
    public int f4573l;

    /* renamed from: m, reason: collision with root package name */
    public int f4574m;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends ByteArrayOutputStream {
        public a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, b.this.f4571j.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public b(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f4576a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f4570e = inputStream;
        this.f4571j = charset;
        this.f4572k = new byte[i10];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void b() throws IOException {
        InputStream inputStream = this.f4570e;
        byte[] bArr = this.f4572k;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 == -1) {
            throw new EOFException();
        }
        this.f4573l = 0;
        this.f4574m = i10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f4570e) {
            try {
                if (this.f4572k != null) {
                    this.f4572k = null;
                    this.f4570e.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f4570e) {
            try {
                if (this.f4572k == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f4573l >= this.f4574m) {
                    b();
                }
                for (int i12 = this.f4573l; i12 != this.f4574m; i12++) {
                    byte[] bArr2 = this.f4572k;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f4573l;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] != 13) {
                                i11 = i12;
                            }
                        }
                        String str = new String(bArr2, i13, i11 - i13, this.f4571j.name());
                        this.f4573l = i12 + 1;
                        return str;
                    }
                }
                a aVar = new a((this.f4574m - this.f4573l) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f4572k;
                    int i14 = this.f4573l;
                    aVar.write(bArr3, i14, this.f4574m - i14);
                    this.f4574m = -1;
                    b();
                    i10 = this.f4573l;
                    while (i10 != this.f4574m) {
                        bArr = this.f4572k;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f4573l;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f4573l = i10 + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
