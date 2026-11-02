package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f10830k = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: e, reason: collision with root package name */
    public n f10831e;

    /* renamed from: j, reason: collision with root package name */
    public long f10832j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f10832j, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f10832j > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            return c.this.read(bArr, i10, i11);
        }

        public String toString() {
            return c.this + ".inputStream()";
        }
    }

    @Override // okio.e
    public ByteString A(long j10) {
        return new ByteString(P(j10));
    }

    @Override // okio.e
    public boolean C() {
        return this.f10832j == 0;
    }

    @Override // okio.e
    public String E(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jL = l((byte) 10, 0L, j11);
        if (jL != -1) {
            return s(jL);
        }
        if (j11 < size() && j(j11 - 1) == 13 && j(j11) == 10) {
            return s(j11);
        }
        c cVar = new c();
        i(cVar, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + cVar.o().hex() + '\u2026');
    }

    @Override // okio.e
    public boolean G(long j10, ByteString byteString) {
        return m(j10, byteString, 0, byteString.size());
    }

    @Override // okio.e
    public String H(Charset charset) {
        try {
            return p(this.f10832j, charset);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // okio.p
    public void I(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        s.b(cVar.f10832j, 0L, j10);
        while (j10 > 0) {
            n nVar = cVar.f10831e;
            if (j10 < nVar.f10861c - nVar.f10860b) {
                n nVar2 = this.f10831e;
                n nVar3 = nVar2 != null ? nVar2.f10865g : null;
                if (nVar3 != null && nVar3.f10863e) {
                    if ((nVar3.f10861c + j10) - (nVar3.f10862d ? 0 : nVar3.f10860b) <= 8192) {
                        nVar.f(nVar3, (int) j10);
                        cVar.f10832j -= j10;
                        this.f10832j += j10;
                        return;
                    }
                }
                cVar.f10831e = nVar.e((int) j10);
            }
            n nVar4 = cVar.f10831e;
            long j11 = nVar4.f10861c - nVar4.f10860b;
            cVar.f10831e = nVar4.b();
            n nVar5 = this.f10831e;
            if (nVar5 == null) {
                this.f10831e = nVar4;
                nVar4.f10865g = nVar4;
                nVar4.f10864f = nVar4;
            } else {
                nVar5.f10865g.c(nVar4).a();
            }
            cVar.f10832j -= j11;
            this.f10832j += j11;
            j10 -= j11;
        }
    }

    @Override // okio.d
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public c write(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = i11;
        s.b(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            n nVarV = v(1);
            int iMin = Math.min(i12 - i10, 8192 - nVarV.f10861c);
            System.arraycopy(bArr, i10, nVarV.f10859a, nVarV.f10861c, iMin);
            i10 += iMin;
            nVarV.f10861c += iMin;
        }
        this.f10832j += j10;
        return this;
    }

    @Override // okio.d
    public long K(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long jU = qVar.U(this, 8192L);
            if (jU == -1) {
                return j10;
            }
            j10 += jU;
        }
    }

    @Override // okio.e
    public String N() {
        return E(Long.MAX_VALUE);
    }

    @Override // okio.e
    public int O() {
        return s.c(readInt());
    }

    @Override // okio.e
    public byte[] P(long j10) throws EOFException {
        s.b(this.f10832j, 0L, j10);
        if (j10 <= 2147483647L) {
            byte[] bArr = new byte[(int) j10];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
    }

    @Override // okio.e
    public short R() {
        return s.d(readShort());
    }

    @Override // okio.q
    public long U(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        long j11 = this.f10832j;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        cVar.I(this, j10);
        return j10;
    }

    @Override // okio.d
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public c writeByte(int i10) {
        n nVarV = v(1);
        byte[] bArr = nVarV.f10859a;
        int i11 = nVarV.f10861c;
        nVarV.f10861c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.f10832j++;
        return this;
    }

    @Override // okio.e
    public void X(long j10) throws EOFException {
        if (this.f10832j < j10) {
            throw new EOFException();
        }
    }

    @Override // okio.e
    public long Y(byte b10) {
        return l(b10, 0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:37:0x00a2 BREAK  A[LOOP:0: B:5:0x000b->B:46:?], SYNTHETIC] */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Z() {
        int i10;
        if (this.f10832j == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i11 = 0;
        long j10 = 0;
        boolean z10 = false;
        do {
            n nVar = this.f10831e;
            byte[] bArr = nVar.f10859a;
            int i12 = nVar.f10860b;
            int i13 = nVar.f10861c;
            while (i12 < i13) {
                byte b10 = bArr[i12];
                if (b10 >= 48 && b10 <= 57) {
                    i10 = b10 - 48;
                } else if (b10 >= 97 && b10 <= 102) {
                    i10 = b10 - 87;
                } else if (b10 >= 65 && b10 <= 70) {
                    i10 = b10 - 55;
                } else {
                    if (i11 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b10));
                    }
                    z10 = true;
                    if (i12 != i13) {
                        this.f10831e = nVar.b();
                        o.a(nVar);
                    } else {
                        nVar.f10860b = i12;
                    }
                    if (!z10) {
                        break;
                    }
                }
                if (((-1152921504606846976L) & j10) != 0) {
                    throw new NumberFormatException("Number too large: " + new c().L(j10).writeByte(b10).q());
                }
                j10 = (j10 << 4) | i10;
                i12++;
                i11++;
            }
            if (i12 != i13) {
            }
            if (!z10) {
            }
        } while (this.f10831e != null);
        this.f10832j -= i11;
        return j10;
    }

    public final void a() {
        try {
            skip(this.f10832j);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // okio.e
    public InputStream a0() {
        return new a();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.f10832j == 0) {
            return cVar;
        }
        n nVarD = this.f10831e.d();
        cVar.f10831e = nVarD;
        nVarD.f10865g = nVarD;
        nVarD.f10864f = nVarD;
        n nVar = this.f10831e;
        while (true) {
            nVar = nVar.f10864f;
            if (nVar == this.f10831e) {
                cVar.f10832j = this.f10832j;
                return cVar;
            }
            cVar.f10831e.f10865g.c(nVar.d());
        }
    }

    @Override // okio.d
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public c L(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        n nVarV = v(iNumberOfTrailingZeros);
        byte[] bArr = nVarV.f10859a;
        int i10 = nVarV.f10861c;
        for (int i11 = (i10 + iNumberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = f10830k[(int) (15 & j10)];
            j10 >>>= 4;
        }
        nVarV.f10861c += iNumberOfTrailingZeros;
        this.f10832j += iNumberOfTrailingZeros;
        return this;
    }

    @Override // okio.e, okio.d
    public c c() {
        return this;
    }

    @Override // okio.d
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public c writeInt(int i10) {
        n nVarV = v(4);
        byte[] bArr = nVarV.f10859a;
        int i11 = nVarV.f10861c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        nVarV.f10861c = i11 + 4;
        this.f10832j += 4;
        return this;
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long d() {
        long j10 = this.f10832j;
        if (j10 == 0) {
            return 0L;
        }
        n nVar = this.f10831e.f10865g;
        return (nVar.f10861c >= 8192 || !nVar.f10863e) ? j10 : j10 - (r3 - nVar.f10860b);
    }

    @Override // okio.d
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public c writeShort(int i10) {
        n nVarV = v(2);
        byte[] bArr = nVarV.f10859a;
        int i11 = nVarV.f10861c;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        nVarV.f10861c = i11 + 2;
        this.f10832j += 2;
        return this;
    }

    @Override // okio.q
    public r e() {
        return r.f10868d;
    }

    public c e0(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(s.f10872a)) {
                return g0(str, i10, i11);
            }
            byte[] bytes = str.substring(i10, i11).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j10 = this.f10832j;
        if (j10 != cVar.f10832j) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        n nVar = this.f10831e;
        n nVar2 = cVar.f10831e;
        int i10 = nVar.f10860b;
        int i11 = nVar2.f10860b;
        while (j11 < this.f10832j) {
            long jMin = Math.min(nVar.f10861c - i10, nVar2.f10861c - i11);
            int i12 = 0;
            while (i12 < jMin) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (nVar.f10859a[i10] != nVar2.f10859a[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == nVar.f10861c) {
                nVar = nVar.f10864f;
                i10 = nVar.f10860b;
            }
            if (i11 == nVar2.f10861c) {
                nVar2 = nVar2.f10864f;
                i11 = nVar2.f10860b;
            }
            j11 += jMin;
        }
        return true;
    }

    @Override // okio.d
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public c F(String str) {
        return g0(str, 0, str.length());
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() {
    }

    public c g0(String str, int i10, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < '\u0080') {
                n nVarV = v(1);
                byte[] bArr = nVarV.f10859a;
                int i12 = nVarV.f10861c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt;
                while (i13 < iMin) {
                    char cCharAt2 = str.charAt(i13);
                    if (cCharAt2 >= '\u0080') {
                        break;
                    }
                    bArr[i13 + i12] = (byte) cCharAt2;
                    i13++;
                }
                int i14 = nVarV.f10861c;
                int i15 = (i12 + i13) - i14;
                nVarV.f10861c = i14 + i15;
                this.f10832j += i15;
                i10 = i13;
            } else {
                if (cCharAt < '\u0800') {
                    writeByte((cCharAt >> 6) | 192);
                    writeByte((cCharAt & '?') | 128);
                } else if (cCharAt < '\ud800' || cCharAt > '\udfff') {
                    writeByte((cCharAt >> '\f') | 224);
                    writeByte(((cCharAt >> 6) & 63) | 128);
                    writeByte((cCharAt & '?') | 128);
                } else {
                    int i16 = i10 + 1;
                    char cCharAt3 = i16 < i11 ? str.charAt(i16) : (char) 0;
                    if (cCharAt > '\udbff' || cCharAt3 < '\udc00' || cCharAt3 > '\udfff') {
                        writeByte(63);
                        i10 = i16;
                    } else {
                        int i17 = (((cCharAt & '\u27ff') << 10) | ('\u23ff' & cCharAt3)) + 65536;
                        writeByte((i17 >> 18) | 240);
                        writeByte(((i17 >> 12) & 63) | 128);
                        writeByte(((i17 >> 6) & 63) | 128);
                        writeByte((i17 & 63) | 128);
                        i10 += 2;
                    }
                }
                i10++;
            }
        }
        return this;
    }

    public c h0(int i10) {
        if (i10 < 128) {
            writeByte(i10);
            return this;
        }
        if (i10 < 2048) {
            writeByte((i10 >> 6) | 192);
            writeByte((i10 & 63) | 128);
            return this;
        }
        if (i10 < 65536) {
            if (i10 >= 55296 && i10 <= 57343) {
                writeByte(63);
                return this;
            }
            writeByte((i10 >> 12) | 224);
            writeByte(((i10 >> 6) & 63) | 128);
            writeByte((i10 & 63) | 128);
            return this;
        }
        if (i10 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
        }
        writeByte((i10 >> 18) | 240);
        writeByte(((i10 >> 12) & 63) | 128);
        writeByte(((i10 >> 6) & 63) | 128);
        writeByte((i10 & 63) | 128);
        return this;
    }

    public int hashCode() {
        n nVar = this.f10831e;
        if (nVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = nVar.f10861c;
            for (int i12 = nVar.f10860b; i12 < i11; i12++) {
                i10 = (i10 * 31) + nVar.f10859a[i12];
            }
            nVar = nVar.f10864f;
        } while (nVar != this.f10831e);
        return i10;
    }

    public final c i(c cVar, long j10, long j11) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        long j12 = j10;
        s.b(this.f10832j, j12, j11);
        if (j11 != 0) {
            cVar.f10832j += j11;
            n nVar = this.f10831e;
            while (true) {
                int i10 = nVar.f10861c;
                int i11 = nVar.f10860b;
                if (j12 < i10 - i11) {
                    break;
                }
                j12 -= i10 - i11;
                nVar = nVar.f10864f;
            }
            n nVar2 = nVar;
            long j13 = j11;
            while (j13 > 0) {
                n nVarD = nVar2.d();
                int i12 = (int) (nVarD.f10860b + j12);
                nVarD.f10860b = i12;
                nVarD.f10861c = Math.min(i12 + ((int) j13), nVarD.f10861c);
                n nVar3 = cVar.f10831e;
                if (nVar3 == null) {
                    nVarD.f10865g = nVarD;
                    nVarD.f10864f = nVarD;
                    cVar.f10831e = nVarD;
                } else {
                    nVar3.f10865g.c(nVarD);
                }
                j13 -= nVarD.f10861c - nVarD.f10860b;
                nVar2 = nVar2.f10864f;
                j12 = 0;
            }
        }
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final byte j(long j10) {
        int i10;
        long j11 = j10;
        s.b(this.f10832j, j11, 1L);
        long j12 = this.f10832j;
        if (j12 - j11 <= j11) {
            long j13 = j11 - j12;
            n nVar = this.f10831e;
            do {
                nVar = nVar.f10865g;
                int i11 = nVar.f10861c;
                i10 = nVar.f10860b;
                j13 += i11 - i10;
            } while (j13 < 0);
            return nVar.f10859a[i10 + ((int) j13)];
        }
        n nVar2 = this.f10831e;
        while (true) {
            int i12 = nVar2.f10861c;
            int i13 = nVar2.f10860b;
            long j14 = i12 - i13;
            if (j11 < j14) {
                return nVar2.f10859a[i13 + ((int) j11)];
            }
            j11 -= j14;
            nVar2 = nVar2.f10864f;
        }
    }

    public long l(byte b10, long j10, long j11) {
        n nVar;
        long j12 = 0;
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f10832j), Long.valueOf(j10), Long.valueOf(j11)));
        }
        long j13 = this.f10832j;
        long j14 = j11 > j13 ? j13 : j11;
        if (j10 == j14 || (nVar = this.f10831e) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                nVar = nVar.f10865g;
                j13 -= nVar.f10861c - nVar.f10860b;
            }
        } else {
            while (true) {
                long j15 = (nVar.f10861c - nVar.f10860b) + j12;
                if (j15 >= j10) {
                    break;
                }
                nVar = nVar.f10864f;
                j12 = j15;
            }
            j13 = j12;
        }
        long j16 = j10;
        while (j13 < j14) {
            byte[] bArr = nVar.f10859a;
            int iMin = (int) Math.min(nVar.f10861c, (nVar.f10860b + j14) - j13);
            for (int i10 = (int) ((nVar.f10860b + j16) - j13); i10 < iMin; i10++) {
                if (bArr[i10] == b10) {
                    return (i10 - nVar.f10860b) + j13;
                }
            }
            j13 += nVar.f10861c - nVar.f10860b;
            nVar = nVar.f10864f;
            j16 = j13;
        }
        return -1L;
    }

    public boolean m(long j10, ByteString byteString, int i10, int i11) {
        if (j10 < 0 || i10 < 0 || i11 < 0 || this.f10832j - j10 < i11 || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (j(i12 + j10) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public byte[] n() {
        try {
            return P(this.f10832j);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public ByteString o() {
        return new ByteString(n());
    }

    public String p(long j10, Charset charset) {
        s.b(this.f10832j, 0L, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j10 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        }
        if (j10 == 0) {
            return "";
        }
        n nVar = this.f10831e;
        int i10 = nVar.f10860b;
        if (i10 + j10 > nVar.f10861c) {
            return new String(P(j10), charset);
        }
        String str = new String(nVar.f10859a, i10, (int) j10, charset);
        int i11 = (int) (nVar.f10860b + j10);
        nVar.f10860b = i11;
        this.f10832j -= j10;
        if (i11 == nVar.f10861c) {
            this.f10831e = nVar.b();
            o.a(nVar);
        }
        return str;
    }

    public String q() {
        try {
            return p(this.f10832j, s.f10872a);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public String r(long j10) {
        return p(j10, s.f10872a);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        n nVar = this.f10831e;
        if (nVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), nVar.f10861c - nVar.f10860b);
        byteBuffer.put(nVar.f10859a, nVar.f10860b, iMin);
        int i10 = nVar.f10860b + iMin;
        nVar.f10860b = i10;
        this.f10832j -= iMin;
        if (i10 == nVar.f10861c) {
            this.f10831e = nVar.b();
            o.a(nVar);
        }
        return iMin;
    }

    public int read(byte[] bArr, int i10, int i11) {
        s.b(bArr.length, i10, i11);
        n nVar = this.f10831e;
        if (nVar == null) {
            return -1;
        }
        int iMin = Math.min(i11, nVar.f10861c - nVar.f10860b);
        System.arraycopy(nVar.f10859a, nVar.f10860b, bArr, i10, iMin);
        int i12 = nVar.f10860b + iMin;
        nVar.f10860b = i12;
        this.f10832j -= iMin;
        if (i12 == nVar.f10861c) {
            this.f10831e = nVar.b();
            o.a(nVar);
        }
        return iMin;
    }

    @Override // okio.e
    public byte readByte() {
        long j10 = this.f10832j;
        if (j10 == 0) {
            throw new IllegalStateException("size == 0");
        }
        n nVar = this.f10831e;
        int i10 = nVar.f10860b;
        int i11 = nVar.f10861c;
        int i12 = i10 + 1;
        byte b10 = nVar.f10859a[i10];
        this.f10832j = j10 - 1;
        if (i12 != i11) {
            nVar.f10860b = i12;
            return b10;
        }
        this.f10831e = nVar.b();
        o.a(nVar);
        return b10;
    }

    @Override // okio.e
    public void readFully(byte[] bArr) throws EOFException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = read(bArr, i10, bArr.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    @Override // okio.e
    public int readInt() {
        long j10 = this.f10832j;
        if (j10 < 4) {
            throw new IllegalStateException("size < 4: " + this.f10832j);
        }
        n nVar = this.f10831e;
        int i10 = nVar.f10860b;
        int i11 = nVar.f10861c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = nVar.f10859a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        this.f10832j = j10 - 4;
        if (i14 != i11) {
            nVar.f10860b = i14;
            return i15;
        }
        this.f10831e = nVar.b();
        o.a(nVar);
        return i15;
    }

    @Override // okio.e
    public short readShort() {
        long j10 = this.f10832j;
        if (j10 < 2) {
            throw new IllegalStateException("size < 2: " + this.f10832j);
        }
        n nVar = this.f10831e;
        int i10 = nVar.f10860b;
        int i11 = nVar.f10861c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = nVar.f10859a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        this.f10832j = j10 - 2;
        if (i14 == i11) {
            this.f10831e = nVar.b();
            o.a(nVar);
        } else {
            nVar.f10860b = i14;
        }
        return (short) i15;
    }

    public String s(long j10) throws EOFException {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (j(j11) == 13) {
                String strR = r(j11);
                skip(2L);
                return strR;
            }
        }
        String strR2 = r(j10);
        skip(1L);
        return strR2;
    }

    public final long size() {
        return this.f10832j;
    }

    @Override // okio.e
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            if (this.f10831e == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, r0.f10861c - r0.f10860b);
            long j11 = iMin;
            this.f10832j -= j11;
            j10 -= j11;
            n nVar = this.f10831e;
            int i10 = nVar.f10860b + iMin;
            nVar.f10860b = i10;
            if (i10 == nVar.f10861c) {
                this.f10831e = nVar.b();
                o.a(nVar);
            }
        }
    }

    public final ByteString t() {
        long j10 = this.f10832j;
        if (j10 <= 2147483647L) {
            return u((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f10832j);
    }

    public String toString() {
        return t().toString();
    }

    public final ByteString u(int i10) {
        return i10 == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i10);
    }

    public n v(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        n nVar = this.f10831e;
        if (nVar != null) {
            n nVar2 = nVar.f10865g;
            return (nVar2.f10861c + i10 > 8192 || !nVar2.f10863e) ? nVar2.c(o.b()) : nVar2;
        }
        n nVarB = o.b();
        this.f10831e = nVarB;
        nVarB.f10865g = nVarB;
        nVarB.f10864f = nVarB;
        return nVarB;
    }

    public c w(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            n nVarV = v(1);
            int iMin = Math.min(i10, 8192 - nVarV.f10861c);
            byteBuffer.get(nVarV.f10859a, nVarV.f10861c, iMin);
            i10 -= iMin;
            nVarV.f10861c += iMin;
        }
        this.f10832j += iRemaining;
        return iRemaining;
    }

    @Override // okio.d
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }
}
