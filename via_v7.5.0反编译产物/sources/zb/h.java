package zb;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Logger f15680q = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final okio.d f15681c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15682e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final okio.c f15683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b.C0167b f15686p;

    public h(okio.d dVar, boolean z10) {
        this.f15681c = dVar;
        this.f15682e = z10;
        okio.c cVar = new okio.c();
        this.f15683m = cVar;
        this.f15686p = new b.C0167b(cVar);
        this.f15684n = 16384;
    }

    public static void r(okio.d dVar, int i10) {
        dVar.writeByte((i10 >>> 16) & 255);
        dVar.writeByte((i10 >>> 8) & 255);
        dVar.writeByte(i10 & 255);
    }

    public synchronized void a(k kVar) {
        try {
            if (this.f15685o) {
                throw new IOException("closed");
            }
            this.f15684n = kVar.f(this.f15684n);
            if (kVar.c() != -1) {
                this.f15686p.e(kVar.c());
            }
            f(0, 0, (byte) 4, (byte) 1);
            this.f15681c.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        try {
            if (this.f15685o) {
                throw new IOException("closed");
            }
            if (this.f15682e) {
                Logger logger = f15680q;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(ub.c.r(">> CONNECTION %s", c.f15576a.hex()));
                }
                this.f15681c.write(c.f15576a.toByteArray());
                this.f15681c.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c(boolean z10, int i10, okio.c cVar, int i11) {
        if (this.f15685o) {
            throw new IOException("closed");
        }
        e(i10, z10 ? (byte) 1 : (byte) 0, cVar, i11);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f15685o = true;
        this.f15681c.close();
    }

    public void e(int i10, byte b10, okio.c cVar, int i11) {
        f(i10, i11, (byte) 0, b10);
        if (i11 > 0) {
            this.f15681c.L(cVar, i11);
        }
    }

    public void f(int i10, int i11, byte b10, byte b11) {
        Logger logger = f15680q;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.b(false, i10, i11, b10, b11));
        }
        int i12 = this.f15684n;
        if (i11 > i12) {
            throw c.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw c.c("reserved bit set: %s", Integer.valueOf(i10));
        }
        r(this.f15681c, i11);
        this.f15681c.writeByte(b10 & 255);
        this.f15681c.writeByte(b11 & 255);
        this.f15681c.writeInt(i10 & Integer.MAX_VALUE);
    }

    public synchronized void flush() {
        if (this.f15685o) {
            throw new IOException("closed");
        }
        this.f15681c.flush();
    }

    public synchronized void g(int i10, ErrorCode errorCode, byte[] bArr) {
        try {
            if (this.f15685o) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode == -1) {
                throw c.c("errorCode.httpCode == -1", new Object[0]);
            }
            f(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f15681c.writeInt(i10);
            this.f15681c.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f15681c.write(bArr);
            }
            this.f15681c.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void h(boolean z10, int i10, List list) throws IOException {
        if (this.f15685o) {
            throw new IOException("closed");
        }
        this.f15686p.g(list);
        long size = this.f15683m.size();
        int iMin = (int) Math.min(this.f15684n, size);
        long j10 = iMin;
        byte b10 = size == j10 ? (byte) 4 : (byte) 0;
        if (z10) {
            b10 = (byte) (b10 | 1);
        }
        f(i10, iMin, (byte) 1, b10);
        this.f15681c.L(this.f15683m, j10);
        if (size > j10) {
            q(i10, size - j10);
        }
    }

    public int j() {
        return this.f15684n;
    }

    public synchronized void k(boolean z10, int i10, int i11) {
        if (this.f15685o) {
            throw new IOException("closed");
        }
        f(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
        this.f15681c.writeInt(i10);
        this.f15681c.writeInt(i11);
        this.f15681c.flush();
    }

    public synchronized void l(int i10, int i11, List list) {
        if (this.f15685o) {
            throw new IOException("closed");
        }
        this.f15686p.g(list);
        long size = this.f15683m.size();
        int iMin = (int) Math.min(this.f15684n - 4, size);
        long j10 = iMin;
        f(i10, iMin + 4, (byte) 5, size == j10 ? (byte) 4 : (byte) 0);
        this.f15681c.writeInt(i11 & Integer.MAX_VALUE);
        this.f15681c.L(this.f15683m, j10);
        if (size > j10) {
            q(i10, size - j10);
        }
    }

    public synchronized void m(int i10, ErrorCode errorCode) {
        if (this.f15685o) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        f(i10, 4, (byte) 3, (byte) 0);
        this.f15681c.writeInt(errorCode.httpCode);
        this.f15681c.flush();
    }

    public synchronized void n(k kVar) {
        int i10;
        try {
            if (this.f15685o) {
                throw new IOException("closed");
            }
            int i11 = 0;
            f(0, kVar.j() * 6, (byte) 4, (byte) 0);
            while (i11 < 10) {
                if (kVar.g(i11)) {
                    if (i11 == 4) {
                        i10 = 3;
                    } else {
                        i10 = i11 == 7 ? 4 : i11;
                    }
                    this.f15681c.writeShort(i10);
                    this.f15681c.writeInt(kVar.b(i11));
                }
                i11++;
            }
            this.f15681c.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void o(boolean z10, int i10, int i11, List list) {
        if (this.f15685o) {
            throw new IOException("closed");
        }
        h(z10, i10, list);
    }

    public synchronized void p(int i10, long j10) {
        if (this.f15685o) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > 2147483647L) {
            throw c.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        }
        f(i10, 4, (byte) 8, (byte) 0);
        this.f15681c.writeInt((int) j10);
        this.f15681c.flush();
    }

    public final void q(int i10, long j10) {
        while (j10 > 0) {
            int iMin = (int) Math.min(this.f15684n, j10);
            long j11 = iMin;
            j10 -= j11;
            f(i10, iMin, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
            this.f15681c.L(this.f15683m, j11);
        }
    }
}
