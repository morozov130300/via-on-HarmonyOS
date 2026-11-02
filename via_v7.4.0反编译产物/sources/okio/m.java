package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m implements e {

    /* renamed from: e, reason: collision with root package name */
    public final c f10855e = new c();

    /* renamed from: j, reason: collision with root package name */
    public final q f10856j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10857k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            m mVar = m.this;
            if (mVar.f10857k) {
                throw new IOException("closed");
            }
            return (int) Math.min(mVar.f10855e.f10832j, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            m mVar = m.this;
            if (mVar.f10857k) {
                throw new IOException("closed");
            }
            c cVar = mVar.f10855e;
            if (cVar.f10832j == 0 && mVar.f10856j.U(cVar, 8192L) == -1) {
                return -1;
            }
            return m.this.f10855e.readByte() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (m.this.f10857k) {
                throw new IOException("closed");
            }
            s.b(bArr.length, i10, i11);
            m mVar = m.this;
            c cVar = mVar.f10855e;
            if (cVar.f10832j == 0 && mVar.f10856j.U(cVar, 8192L) == -1) {
                return -1;
            }
            return m.this.f10855e.read(bArr, i10, i11);
        }

        public String toString() {
            return m.this + ".inputStream()";
        }
    }

    public m(q qVar) {
        if (qVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f10856j = qVar;
    }

    @Override // okio.e
    public ByteString A(long j10) throws EOFException {
        X(j10);
        return this.f10855e.A(j10);
    }

    @Override // okio.e
    public boolean C() {
        if (this.f10857k) {
            throw new IllegalStateException("closed");
        }
        return this.f10855e.C() && this.f10856j.U(this.f10855e, 8192L) == -1;
    }

    @Override // okio.e
    public String E(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jA = a((byte) 10, 0L, j11);
        if (jA != -1) {
            return this.f10855e.s(jA);
        }
        if (j11 < Long.MAX_VALUE && d(j11) && this.f10855e.j(j11 - 1) == 13 && d(1 + j11) && this.f10855e.j(j11) == 10) {
            return this.f10855e.s(j11);
        }
        c cVar = new c();
        c cVar2 = this.f10855e;
        cVar2.i(cVar, 0L, Math.min(32L, cVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f10855e.size(), j10) + " content=" + cVar.o().hex() + '\u2026');
    }

    @Override // okio.e
    public boolean G(long j10, ByteString byteString) {
        return b(j10, byteString, 0, byteString.size());
    }

    @Override // okio.e
    public String H(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f10855e.K(this.f10856j);
        return this.f10855e.H(charset);
    }

    @Override // okio.e
    public String N() {
        return E(Long.MAX_VALUE);
    }

    @Override // okio.e
    public int O() throws EOFException {
        X(4L);
        return this.f10855e.O();
    }

    @Override // okio.e
    public byte[] P(long j10) throws EOFException {
        X(j10);
        return this.f10855e.P(j10);
    }

    @Override // okio.e
    public short R() throws EOFException {
        X(2L);
        return this.f10855e.R();
    }

    @Override // okio.q
    public long U(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f10857k) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.f10855e;
        if (cVar2.f10832j == 0 && this.f10856j.U(cVar2, 8192L) == -1) {
            return -1L;
        }
        return this.f10855e.U(cVar, Math.min(j10, this.f10855e.f10832j));
    }

    @Override // okio.e
    public void X(long j10) throws EOFException {
        if (!d(j10)) {
            throw new EOFException();
        }
    }

    @Override // okio.e
    public long Y(byte b10) {
        return a(b10, 0L, Long.MAX_VALUE);
    }

    @Override // okio.e
    public long Z() throws EOFException {
        byte bJ;
        X(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!d(i11)) {
                break;
            }
            bJ = this.f10855e.j(i10);
            if ((bJ < 48 || bJ > 57) && ((bJ < 97 || bJ > 102) && (bJ < 65 || bJ > 70))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bJ)));
        }
        return this.f10855e.Z();
    }

    public long a(byte b10, long j10, long j11) {
        if (this.f10857k) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j10), Long.valueOf(j11)));
        }
        long jMax = j10;
        while (jMax < j11) {
            byte b11 = b10;
            long j12 = j11;
            long jL = this.f10855e.l(b11, jMax, j12);
            if (jL != -1) {
                return jL;
            }
            c cVar = this.f10855e;
            long j13 = cVar.f10832j;
            if (j13 >= j12 || this.f10856j.U(cVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j13);
            b10 = b11;
            j11 = j12;
        }
        return -1L;
    }

    @Override // okio.e
    public InputStream a0() {
        return new a();
    }

    public boolean b(long j10, ByteString byteString, int i10, int i11) {
        if (this.f10857k) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || i10 < 0 || i11 < 0 || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            long j11 = i12 + j10;
            if (!d(1 + j11) || this.f10855e.j(j11) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.e, okio.d
    public c c() {
        return this.f10855e;
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f10857k) {
            return;
        }
        this.f10857k = true;
        this.f10856j.close();
        this.f10855e.a();
    }

    public boolean d(long j10) {
        c cVar;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f10857k) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.f10855e;
            if (cVar.f10832j >= j10) {
                return true;
            }
        } while (this.f10856j.U(cVar, 8192L) != -1);
        return false;
    }

    @Override // okio.q
    public r e() {
        return this.f10856j.e();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f10857k;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        c cVar = this.f10855e;
        if (cVar.f10832j == 0 && this.f10856j.U(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f10855e.read(byteBuffer);
    }

    @Override // okio.e
    public byte readByte() throws EOFException {
        X(1L);
        return this.f10855e.readByte();
    }

    @Override // okio.e
    public void readFully(byte[] bArr) throws EOFException {
        try {
            X(bArr.length);
            this.f10855e.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (true) {
                c cVar = this.f10855e;
                long j10 = cVar.f10832j;
                if (j10 <= 0) {
                    throw e10;
                }
                int i11 = cVar.read(bArr, i10, (int) j10);
                if (i11 == -1) {
                    throw new AssertionError();
                }
                i10 += i11;
            }
        }
    }

    @Override // okio.e
    public int readInt() throws EOFException {
        X(4L);
        return this.f10855e.readInt();
    }

    @Override // okio.e
    public short readShort() throws EOFException {
        X(2L);
        return this.f10855e.readShort();
    }

    @Override // okio.e
    public void skip(long j10) throws EOFException {
        if (this.f10857k) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            c cVar = this.f10855e;
            if (cVar.f10832j == 0 && this.f10856j.U(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f10855e.size());
            this.f10855e.skip(jMin);
            j10 -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.f10856j + ")";
    }
}
