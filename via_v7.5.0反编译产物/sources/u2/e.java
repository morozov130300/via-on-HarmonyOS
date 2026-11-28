package u2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements Closeable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Logger f12823q = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RandomAccessFile f12824c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12825e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12826m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f12827n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f12828o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final byte[] f12829p = new byte[16];

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12830a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f12831b;

        public a(StringBuilder sb2) {
            this.f12831b = sb2;
        }

        @Override // u2.e.d
        public void a(InputStream inputStream, int i10) {
            if (this.f12830a) {
                this.f12830a = false;
            } else {
                this.f12831b.append(", ");
            }
            this.f12831b.append(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12833c = new b(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12835b;

        public b(int i10, int i11) {
            this.f12834a = i10;
            this.f12835b = i11;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f12834a + ", length = " + this.f12835b + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class c extends InputStream {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12836c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12837e;

        public /* synthetic */ c(e eVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            e.n(bArr, "buffer");
            if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i12 = this.f12837e;
            if (i12 <= 0) {
                return -1;
            }
            if (i11 > i12) {
                i11 = i12;
            }
            e.this.u(this.f12836c, bArr, i10, i11);
            this.f12836c = e.this.J(this.f12836c + i11);
            this.f12837e -= i11;
            return i11;
        }

        public c(b bVar) {
            this.f12836c = e.this.J(bVar.f12834a + 4);
            this.f12837e = bVar.f12835b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f12837e == 0) {
                return -1;
            }
            e.this.f12824c.seek(this.f12836c);
            int i10 = e.this.f12824c.read();
            this.f12836c = e.this.J(this.f12836c + 1);
            this.f12837e--;
            return i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface d {
        void a(InputStream inputStream, int i10);
    }

    public e(File file) throws IOException {
        if (!file.exists()) {
            l(file);
        }
        this.f12824c = o(file);
        q();
    }

    public static void b0(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >> 24);
        bArr[i10 + 1] = (byte) (i11 >> 16);
        bArr[i10 + 2] = (byte) (i11 >> 8);
        bArr[i10 + 3] = (byte) i11;
    }

    public static void c0(byte[] bArr, int... iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            b0(bArr, i10, i11);
            i10 += 4;
        }
    }

    public static void l(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileO = o(file2);
        try {
            randomAccessFileO.setLength(4096L);
            randomAccessFileO.seek(0L);
            byte[] bArr = new byte[16];
            c0(bArr, 4096, 0, 0, 0);
            randomAccessFileO.write(bArr);
            randomAccessFileO.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileO.close();
            throw th;
        }
    }

    public static Object n(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static RandomAccessFile o(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    public static int r(byte[] bArr, int i10) {
        return ((bArr[i10] & 255) << 24) + ((bArr[i10 + 1] & 255) << 16) + ((bArr[i10 + 2] & 255) << 8) + (bArr[i10 + 3] & 255);
    }

    public final int J(int i10) {
        int i11 = this.f12825e;
        return i10 < i11 ? i10 : (i10 + 16) - i11;
    }

    public final void W(int i10, int i11, int i12, int i13) throws IOException {
        c0(this.f12829p, i10, i11, i12, i13);
        this.f12824c.seek(0L);
        this.f12824c.write(this.f12829p);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f12824c.close();
    }

    public void f(byte[] bArr) {
        g(bArr, 0, bArr.length);
    }

    public synchronized void g(byte[] bArr, int i10, int i11) {
        int iJ;
        try {
            n(bArr, "buffer");
            if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
                throw new IndexOutOfBoundsException();
            }
            j(i11);
            boolean zM = m();
            if (zM) {
                iJ = 16;
            } else {
                b bVar = this.f12828o;
                iJ = J(bVar.f12834a + 4 + bVar.f12835b);
            }
            b bVar2 = new b(iJ, i11);
            b0(this.f12829p, 0, i11);
            v(bVar2.f12834a, this.f12829p, 0, 4);
            v(bVar2.f12834a + 4, bArr, i10, i11);
            W(this.f12825e, this.f12826m + 1, zM ? bVar2.f12834a : this.f12827n.f12834a, bVar2.f12834a);
            this.f12828o = bVar2;
            this.f12826m++;
            if (zM) {
                this.f12827n = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void h() {
        try {
            W(4096, 0, 0, 0);
            this.f12826m = 0;
            b bVar = b.f12833c;
            this.f12827n = bVar;
            this.f12828o = bVar;
            if (this.f12825e > 4096) {
                w(4096);
            }
            this.f12825e = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void j(int i10) throws IOException {
        int i11 = i10 + 4;
        int iS = s();
        if (iS >= i11) {
            return;
        }
        int i12 = this.f12825e;
        do {
            iS += i12;
            i12 <<= 1;
        } while (iS < i11);
        w(i12);
        b bVar = this.f12828o;
        int iJ = J(bVar.f12834a + 4 + bVar.f12835b);
        if (iJ < this.f12827n.f12834a) {
            FileChannel channel = this.f12824c.getChannel();
            channel.position(this.f12825e);
            long j10 = iJ - 4;
            if (channel.transferTo(16L, j10, channel) != j10) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i13 = this.f12828o.f12834a;
        int i14 = this.f12827n.f12834a;
        if (i13 < i14) {
            int i15 = (this.f12825e + i13) - 16;
            W(i12, this.f12826m, i14, i15);
            this.f12828o = new b(i15, this.f12828o.f12835b);
        } else {
            W(i12, this.f12826m, i14, i13);
        }
        this.f12825e = i12;
    }

    public synchronized void k(d dVar) {
        int iJ = this.f12827n.f12834a;
        for (int i10 = 0; i10 < this.f12826m; i10++) {
            b bVarP = p(iJ);
            dVar.a(new c(this, bVarP, null), bVarP.f12835b);
            iJ = J(bVarP.f12834a + 4 + bVarP.f12835b);
        }
    }

    public synchronized boolean m() {
        return this.f12826m == 0;
    }

    public final b p(int i10) throws IOException {
        if (i10 == 0) {
            return b.f12833c;
        }
        this.f12824c.seek(i10);
        return new b(i10, this.f12824c.readInt());
    }

    public final void q() throws IOException {
        this.f12824c.seek(0L);
        this.f12824c.readFully(this.f12829p);
        int iR = r(this.f12829p, 0);
        this.f12825e = iR;
        if (iR <= this.f12824c.length()) {
            this.f12826m = r(this.f12829p, 4);
            int iR2 = r(this.f12829p, 8);
            int iR3 = r(this.f12829p, 12);
            this.f12827n = p(iR2);
            this.f12828o = p(iR3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f12825e + ", Actual length: " + this.f12824c.length());
    }

    public final int s() {
        return this.f12825e - x();
    }

    public synchronized void t() {
        try {
            if (m()) {
                throw new NoSuchElementException();
            }
            if (this.f12826m == 1) {
                h();
            } else {
                b bVar = this.f12827n;
                int iJ = J(bVar.f12834a + 4 + bVar.f12835b);
                u(iJ, this.f12829p, 0, 4);
                int iR = r(this.f12829p, 0);
                W(this.f12825e, this.f12826m - 1, iJ, this.f12828o.f12834a);
                this.f12826m--;
                this.f12827n = new b(iJ, iR);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        sb2.append("fileLength=");
        sb2.append(this.f12825e);
        sb2.append(", size=");
        sb2.append(this.f12826m);
        sb2.append(", first=");
        sb2.append(this.f12827n);
        sb2.append(", last=");
        sb2.append(this.f12828o);
        sb2.append(", element lengths=[");
        try {
            k(new a(sb2));
        } catch (IOException e10) {
            f12823q.log(Level.WARNING, "read error", (Throwable) e10);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public final void u(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iJ = J(i10);
        int i13 = iJ + i12;
        int i14 = this.f12825e;
        if (i13 <= i14) {
            this.f12824c.seek(iJ);
            this.f12824c.readFully(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iJ;
        this.f12824c.seek(iJ);
        this.f12824c.readFully(bArr, i11, i15);
        this.f12824c.seek(16L);
        this.f12824c.readFully(bArr, i11 + i15, i12 - i15);
    }

    public final void v(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iJ = J(i10);
        int i13 = iJ + i12;
        int i14 = this.f12825e;
        if (i13 <= i14) {
            this.f12824c.seek(iJ);
            this.f12824c.write(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iJ;
        this.f12824c.seek(iJ);
        this.f12824c.write(bArr, i11, i15);
        this.f12824c.seek(16L);
        this.f12824c.write(bArr, i11 + i15, i12 - i15);
    }

    public final void w(int i10) throws IOException {
        this.f12824c.setLength(i10);
        this.f12824c.getChannel().force(true);
    }

    public int x() {
        if (this.f12826m == 0) {
            return 16;
        }
        b bVar = this.f12828o;
        int i10 = bVar.f12834a;
        int i11 = this.f12827n.f12834a;
        return i10 >= i11 ? (i10 - i11) + 4 + bVar.f12835b + 16 : (((i10 + 4) + bVar.f12835b) + this.f12825e) - i11;
    }
}
