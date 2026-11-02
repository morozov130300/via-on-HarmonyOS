package t2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    public static final Logger f12090o = Logger.getLogger(e.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public final RandomAccessFile f12091e;

    /* renamed from: j, reason: collision with root package name */
    public int f12092j;

    /* renamed from: k, reason: collision with root package name */
    public int f12093k;

    /* renamed from: l, reason: collision with root package name */
    public b f12094l;

    /* renamed from: m, reason: collision with root package name */
    public b f12095m;

    /* renamed from: n, reason: collision with root package name */
    public final byte[] f12096n = new byte[16];

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12097a = true;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f12098b;

        public a(StringBuilder sb2) {
            this.f12098b = sb2;
        }

        @Override // t2.e.d
        public void a(InputStream inputStream, int i10) {
            if (this.f12097a) {
                this.f12097a = false;
            } else {
                this.f12098b.append(", ");
            }
            this.f12098b.append(i10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f12100c = new b(0, 0);

        /* renamed from: a, reason: collision with root package name */
        public final int f12101a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12102b;

        public b(int i10, int i11) {
            this.f12101a = i10;
            this.f12102b = i11;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f12101a + ", length = " + this.f12102b + "]";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class c extends InputStream {

        /* renamed from: e, reason: collision with root package name */
        public int f12103e;

        /* renamed from: j, reason: collision with root package name */
        public int f12104j;

        public c(b bVar) {
            this.f12103e = e.this.J(bVar.f12101a + 4);
            this.f12104j = bVar.f12102b;
        }

        public /* synthetic */ c(e eVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f12104j == 0) {
                return -1;
            }
            e.this.f12091e.seek(this.f12103e);
            int i10 = e.this.f12091e.read();
            this.f12103e = e.this.J(this.f12103e + 1);
            this.f12104j--;
            return i10;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            e.n(bArr, "buffer");
            if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i12 = this.f12104j;
            if (i12 <= 0) {
                return -1;
            }
            if (i11 > i12) {
                i11 = i12;
            }
            e.this.u(this.f12103e, bArr, i10, i11);
            this.f12103e = e.this.J(this.f12103e + i11);
            this.f12104j -= i11;
            return i11;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface d {
        void a(InputStream inputStream, int i10);
    }

    public e(File file) throws IOException {
        if (!file.exists()) {
            l(file);
        }
        this.f12091e = o(file);
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
        int i11 = this.f12092j;
        return i10 < i11 ? i10 : (i10 + 16) - i11;
    }

    public final void W(int i10, int i11, int i12, int i13) throws IOException {
        c0(this.f12096n, i10, i11, i12, i13);
        this.f12091e.seek(0L);
        this.f12091e.write(this.f12096n);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f12091e.close();
    }

    public void g(byte[] bArr) {
        h(bArr, 0, bArr.length);
    }

    public synchronized void h(byte[] bArr, int i10, int i11) {
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
                b bVar = this.f12095m;
                iJ = J(bVar.f12101a + 4 + bVar.f12102b);
            }
            b bVar2 = new b(iJ, i11);
            b0(this.f12096n, 0, i11);
            v(bVar2.f12101a, this.f12096n, 0, 4);
            v(bVar2.f12101a + 4, bArr, i10, i11);
            W(this.f12092j, this.f12093k + 1, zM ? bVar2.f12101a : this.f12094l.f12101a, bVar2.f12101a);
            this.f12095m = bVar2;
            this.f12093k++;
            if (zM) {
                this.f12094l = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i() {
        try {
            W(4096, 0, 0, 0);
            this.f12093k = 0;
            b bVar = b.f12100c;
            this.f12094l = bVar;
            this.f12095m = bVar;
            if (this.f12092j > 4096) {
                w(4096);
            }
            this.f12092j = 4096;
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
        int i12 = this.f12092j;
        do {
            iS += i12;
            i12 <<= 1;
        } while (iS < i11);
        w(i12);
        b bVar = this.f12095m;
        int iJ = J(bVar.f12101a + 4 + bVar.f12102b);
        if (iJ < this.f12094l.f12101a) {
            FileChannel channel = this.f12091e.getChannel();
            channel.position(this.f12092j);
            long j10 = iJ - 4;
            if (channel.transferTo(16L, j10, channel) != j10) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i13 = this.f12095m.f12101a;
        int i14 = this.f12094l.f12101a;
        if (i13 < i14) {
            int i15 = (this.f12092j + i13) - 16;
            W(i12, this.f12093k, i14, i15);
            this.f12095m = new b(i15, this.f12095m.f12102b);
        } else {
            W(i12, this.f12093k, i14, i13);
        }
        this.f12092j = i12;
    }

    public synchronized void k(d dVar) {
        int iJ = this.f12094l.f12101a;
        for (int i10 = 0; i10 < this.f12093k; i10++) {
            b bVarP = p(iJ);
            dVar.a(new c(this, bVarP, null), bVarP.f12102b);
            iJ = J(bVarP.f12101a + 4 + bVarP.f12102b);
        }
    }

    public synchronized boolean m() {
        return this.f12093k == 0;
    }

    public final b p(int i10) throws IOException {
        if (i10 == 0) {
            return b.f12100c;
        }
        this.f12091e.seek(i10);
        return new b(i10, this.f12091e.readInt());
    }

    public final void q() throws IOException {
        this.f12091e.seek(0L);
        this.f12091e.readFully(this.f12096n);
        int iR = r(this.f12096n, 0);
        this.f12092j = iR;
        if (iR <= this.f12091e.length()) {
            this.f12093k = r(this.f12096n, 4);
            int iR2 = r(this.f12096n, 8);
            int iR3 = r(this.f12096n, 12);
            this.f12094l = p(iR2);
            this.f12095m = p(iR3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f12092j + ", Actual length: " + this.f12091e.length());
    }

    public final int s() {
        return this.f12092j - x();
    }

    public synchronized void t() {
        try {
            if (m()) {
                throw new NoSuchElementException();
            }
            if (this.f12093k == 1) {
                i();
            } else {
                b bVar = this.f12094l;
                int iJ = J(bVar.f12101a + 4 + bVar.f12102b);
                u(iJ, this.f12096n, 0, 4);
                int iR = r(this.f12096n, 0);
                W(this.f12092j, this.f12093k - 1, iJ, this.f12095m.f12101a);
                this.f12093k--;
                this.f12094l = new b(iJ, iR);
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
        sb2.append(this.f12092j);
        sb2.append(", size=");
        sb2.append(this.f12093k);
        sb2.append(", first=");
        sb2.append(this.f12094l);
        sb2.append(", last=");
        sb2.append(this.f12095m);
        sb2.append(", element lengths=[");
        try {
            k(new a(sb2));
        } catch (IOException e10) {
            f12090o.log(Level.WARNING, "read error", (Throwable) e10);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public final void u(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iJ = J(i10);
        int i13 = iJ + i12;
        int i14 = this.f12092j;
        if (i13 <= i14) {
            this.f12091e.seek(iJ);
            this.f12091e.readFully(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iJ;
        this.f12091e.seek(iJ);
        this.f12091e.readFully(bArr, i11, i15);
        this.f12091e.seek(16L);
        this.f12091e.readFully(bArr, i11 + i15, i12 - i15);
    }

    public final void v(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iJ = J(i10);
        int i13 = iJ + i12;
        int i14 = this.f12092j;
        if (i13 <= i14) {
            this.f12091e.seek(iJ);
            this.f12091e.write(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iJ;
        this.f12091e.seek(iJ);
        this.f12091e.write(bArr, i11, i15);
        this.f12091e.seek(16L);
        this.f12091e.write(bArr, i11 + i15, i12 - i15);
    }

    public final void w(int i10) throws IOException {
        this.f12091e.setLength(i10);
        this.f12091e.getChannel().force(true);
    }

    public int x() {
        if (this.f12093k == 0) {
            return 16;
        }
        b bVar = this.f12095m;
        int i10 = bVar.f12101a;
        int i11 = this.f12094l.f12101a;
        return i10 >= i11 ? (i10 - i11) + 4 + bVar.f12102b + 16 : (((i10 + 4) + bVar.f12102b) + this.f12092j) - i11;
    }
}
