package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    public SegmentedByteString(c cVar, int i10) {
        super(null);
        s.b(cVar.f10832j, 0L, i10);
        n nVar = cVar.f10831e;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = nVar.f10861c;
            int i15 = nVar.f10860b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            nVar = nVar.f10864f;
        }
        this.segments = new byte[i13][];
        this.directory = new int[i13 * 2];
        n nVar2 = cVar.f10831e;
        int i16 = 0;
        while (i11 < i10) {
            byte[][] bArr = this.segments;
            bArr[i16] = nVar2.f10859a;
            int i17 = nVar2.f10861c;
            int i18 = nVar2.f10860b;
            i11 += i17 - i18;
            if (i11 > i10) {
                i11 = i10;
            }
            int[] iArr = this.directory;
            iArr[i16] = i11;
            iArr[bArr.length + i16] = i18;
            nVar2.f10862d = true;
            i16++;
            nVar2 = nVar2.f10864f;
        }
    }

    private Object writeReplace() {
        return e();
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public String base64() {
        return e().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return e().base64Url();
    }

    public final int d(int i10) {
        int iBinarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i10 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : iBinarySearch ^ (-1);
    }

    public final ByteString e() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public byte getByte(int i10) {
        s.b(this.directory[this.segments.length - 1], i10, 1L);
        int iD = d(i10);
        int i11 = iD == 0 ? 0 : this.directory[iD - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[iD][(i10 - i11) + iArr[bArr.length + iD]];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int length = this.segments.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (i11 < length) {
            byte[] bArr = this.segments[i11];
            int[] iArr = this.directory;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            int i16 = (i15 - i12) + i14;
            while (i14 < i16) {
                i13 = (i13 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i12 = i15;
        }
        this.hashCode = i13;
        return i13;
    }

    @Override // okio.ByteString
    public String hex() {
        return e().hex();
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return e().hmacSha1(byteString);
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return e().hmacSha256(byteString);
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i10) {
        return e().indexOf(bArr, i10);
    }

    @Override // okio.ByteString
    public byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i10) {
        return e().lastIndexOf(bArr, i10);
    }

    @Override // okio.ByteString
    public ByteString md5() {
        return e().md5();
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        if (i10 < 0 || i10 > size() - i12) {
            return false;
        }
        int iD = d(i10);
        while (i12 > 0) {
            int i13 = iD == 0 ? 0 : this.directory[iD - 1];
            int iMin = Math.min(i12, ((this.directory[iD] - i13) + i13) - i10);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i11, bArr[iD], (i10 - i13) + iArr[bArr.length + iD], iMin)) {
                return false;
            }
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            iD++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        if (i10 < 0 || i10 > size() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int iD = d(i10);
        while (i12 > 0) {
            int i13 = iD == 0 ? 0 : this.directory[iD - 1];
            int iMin = Math.min(i12, ((this.directory[iD] - i13) + i13) - i10);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!s.a(bArr2[iD], (i10 - i13) + iArr[bArr2.length + iD], bArr, i11, iMin)) {
                return false;
            }
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            iD++;
        }
        return true;
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        return e().sha1();
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        return e().sha256();
    }

    @Override // okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        return e().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i10) {
        return e().substring(i10);
    }

    @Override // okio.ByteString
    public ByteString substring(int i10, int i11) {
        return e().substring(i10, i11);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return e().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return e().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr2 = this.directory;
            int i12 = iArr2[length + i10];
            int i13 = iArr2[i10];
            System.arraycopy(this.segments[i10], i12, bArr2, i11, i13 - i11);
            i10++;
            i11 = i13;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public String toString() {
        return e().toString();
    }

    @Override // okio.ByteString
    public String utf8() {
        return e().utf8();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.directory;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            outputStream.write(this.segments[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
    }

    @Override // okio.ByteString
    public void write(c cVar) {
        int length = this.segments.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.directory;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            n nVar = new n(this.segments[i10], i12, (i12 + i13) - i11, true, false);
            n nVar2 = cVar.f10831e;
            if (nVar2 == null) {
                nVar.f10865g = nVar;
                nVar.f10864f = nVar;
                cVar.f10831e = nVar;
            } else {
                nVar2.f10865g.c(nVar);
            }
            i10++;
            i11 = i13;
        }
        cVar.f10832j += i11;
    }
}
