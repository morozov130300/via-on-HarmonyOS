package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f11468c = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f11469e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11470m;

    public m(q qVar) {
        if (qVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f11469e = qVar;
    }

    @Override // okio.e
    public ByteString B(long j10) throws EOFException {
        X(j10);
        return this.f11468c.B(j10);
    }

    @Override // okio.e
    public boolean C() {
        if (this.f11470m) {
            throw new IllegalStateException("closed");
        }
        return this.f11468c.C() && this.f11469e.U(this.f11468c, 8192L) == -1;
    }

    @Override // okio.e
    public String F(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jA = a((byte) 10, 0L, j11);
        if (jA != -1) {
            return this.f11468c.s(jA);
        }
        if (j11 < Long.MAX_VALUE && c(j11) && this.f11468c.k(j11 - 1) == 13 && c(1 + j11) && this.f11468c.k(j11) == 10) {
            return this.f11468c.s(j11);
        }
        c cVar = new c();
        c cVar2 = this.f11468c;
        cVar2.j(cVar, 0L, Math.min(32L, cVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f11468c.size(), j10) + " content=" + cVar.o().hex() + (char) 8230);
    }

    @Override // okio.e
    public boolean I(long j10, ByteString byteString) {
        return b(j10, byteString, 0, byteString.size());
    }

    @Override // okio.e
    public String K(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f11468c.M(this.f11469e);
        return this.f11468c.K(charset);
    }

    @Override // okio.e
    public String O() {
        return F(Long.MAX_VALUE);
    }

    @Override // okio.e
    public int R() throws EOFException {
        X(4L);
        return this.f11468c.R();
    }

    @Override // okio.e
    public byte[] S(long j10) throws EOFException {
        X(j10);
        return this.f11468c.S(j10);
    }

    @Override // okio.e
    public short T() throws EOFException {
        X(2L);
        return this.f11468c.T();
    }

    @Override // okio.q
    public long U(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f11470m) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.f11468c;
        if (cVar2.f11445e == 0 && this.f11469e.U(cVar2, 8192L) == -1) {
            return -1L;
        }
        return this.f11468c.U(cVar, Math.min(j10, this.f11468c.f11445e));
    }

    @Override // okio.e
    public void X(long j10) throws EOFException {
        if (!c(j10)) {
            throw new EOFException();
        }
    }

    @Override // okio.e
    public long Y(byte b10) {
        return a(b10, 0L, Long.MAX_VALUE);
    }

    @Override // okio.e
    public long Z() throws EOFException {
        X(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!c(i11)) {
                break;
            }
            byte bK = this.f11468c.k(i10);
            if ((bK < 48 || bK > 57) && ((bK < 97 || bK > 102) && (bK < 65 || bK > 70))) {
                if (i10 != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bK)));
            }
            i10 = i11;
        }
        return this.f11468c.Z();
    }

    public long a(byte b10, long j10, long j11) {
        if (this.f11470m) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j10), Long.valueOf(j11)));
        }
        long jMax = j10;
        while (jMax < j11) {
            byte b11 = b10;
            long j12 = j11;
            long jL = this.f11468c.l(b11, jMax, j12);
            if (jL != -1) {
                return jL;
            }
            c cVar = this.f11468c;
            long j13 = cVar.f11445e;
            if (j13 >= j12 || this.f11469e.U(cVar, 8192L) == -1) {
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
        if (this.f11470m) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || i10 < 0 || i11 < 0 || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            long j11 = ((long) i12) + j10;
            if (!c(1 + j11) || this.f11468c.k(j11) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public boolean c(long j10) {
        c cVar;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f11470m) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.f11468c;
            if (cVar.f11445e >= j10) {
                return true;
            }
        } while (this.f11469e.U(cVar, 8192L) != -1);
        return false;
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f11470m) {
            return;
        }
        this.f11470m = true;
        this.f11469e.close();
        this.f11468c.a();
    }

    @Override // okio.e, okio.d
    public c d() {
        return this.f11468c;
    }

    @Override // okio.q
    public r i() {
        return this.f11469e.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f11470m;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        c cVar = this.f11468c;
        if (cVar.f11445e == 0 && this.f11469e.U(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f11468c.read(byteBuffer);
    }

    @Override // okio.e
    public byte readByte() throws EOFException {
        X(1L);
        return this.f11468c.readByte();
    }

    @Override // okio.e
    public void readFully(byte[] bArr) throws EOFException {
        try {
            X(bArr.length);
            this.f11468c.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (true) {
                c cVar = this.f11468c;
                long j10 = cVar.f11445e;
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
        return this.f11468c.readInt();
    }

    @Override // okio.e
    public short readShort() throws EOFException {
        X(2L);
        return this.f11468c.readShort();
    }

    @Override // okio.e
    public void skip(long j10) throws EOFException {
        if (this.f11470m) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            c cVar = this.f11468c;
            if (cVar.f11445e == 0 && this.f11469e.U(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f11468c.size());
            this.f11468c.skip(jMin);
            j10 -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.f11469e + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            m mVar = m.this;
            if (mVar.f11470m) {
                throw new IOException("closed");
            }
            return (int) Math.min(mVar.f11468c.f11445e, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            m mVar = m.this;
            if (mVar.f11470m) {
                throw new IOException("closed");
            }
            c cVar = mVar.f11468c;
            if (cVar.f11445e == 0 && mVar.f11469e.U(cVar, 8192L) == -1) {
                return -1;
            }
            return m.this.f11468c.readByte() & 255;
        }

        public String toString() {
            return m.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (!m.this.f11470m) {
                s.b(bArr.length, i10, i11);
                m mVar = m.this;
                c cVar = mVar.f11468c;
                if (cVar.f11445e == 0 && mVar.f11469e.U(cVar, 8192L) == -1) {
                    return -1;
                }
                return m.this.f11468c.read(bArr, i10, i11);
            }
            throw new IOException("closed");
        }
    }
}
