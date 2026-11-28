package e4;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStream f4202c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Charset f4203e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f4204m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4205n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4206o;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, b.this.f4203e.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void b() throws IOException {
        InputStream inputStream = this.f4202c;
        byte[] bArr = this.f4204m;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 == -1) {
            throw new EOFException();
        }
        this.f4205n = 0;
        this.f4206o = i10;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public String c() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f4202c) {
            try {
                if (this.f4204m == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f4205n >= this.f4206o) {
                    b();
                }
                for (int i12 = this.f4205n; i12 != this.f4206o; i12++) {
                    byte[] bArr2 = this.f4204m;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f4205n;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] != 13) {
                                i11 = i12;
                            }
                        } else {
                            i11 = i12;
                        }
                        String str = new String(bArr2, i13, i11 - i13, this.f4203e.name());
                        this.f4205n = i12 + 1;
                        return str;
                    }
                }
                a aVar = new a((this.f4206o - this.f4205n) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f4204m;
                    int i14 = this.f4205n;
                    aVar.write(bArr3, i14, this.f4206o - i14);
                    this.f4206o = -1;
                    b();
                    i10 = this.f4205n;
                    while (i10 != this.f4206o) {
                        bArr = this.f4204m;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f4205n;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f4205n = i10 + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f4202c) {
            try {
                if (this.f4204m != null) {
                    this.f4204m = null;
                    this.f4202c.close();
                }
            } catch (Throwable th) {
                throw th;
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
        if (!charset.equals(c.f4208a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f4202c = inputStream;
        this.f4203e = charset;
        this.f4204m = new byte[i10];
    }
}
