package zb;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;
import zb.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    public static final Logger f14945o = Logger.getLogger(c.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public final okio.d f14946e;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f14947j;

    /* renamed from: k, reason: collision with root package name */
    public final okio.c f14948k;

    /* renamed from: l, reason: collision with root package name */
    public int f14949l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14950m;

    /* renamed from: n, reason: collision with root package name */
    public final b.C0162b f14951n;

    public h(okio.d dVar, boolean z10) {
        this.f14946e = dVar;
        this.f14947j = z10;
        okio.c cVar = new okio.c();
        this.f14948k = cVar;
        this.f14951n = new b.C0162b(cVar);
        this.f14949l = 16384;
    }

    public static void r(okio.d dVar, int i10) {
        dVar.writeByte((i10 >>> 16) & 255);
        dVar.writeByte((i10 >>> 8) & 255);
        dVar.writeByte(i10 & 255);
    }

    public synchronized void a(k kVar) {
        try {
            if (this.f14950m) {
                throw new IOException("closed");
            }
            this.f14949l = kVar.f(this.f14949l);
            if (kVar.c() != -1) {
                this.f14951n.e(kVar.c());
            }
            g(0, 0, (byte) 4, (byte) 1);
            this.f14946e.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        try {
            if (this.f14950m) {
                throw new IOException("closed");
            }
            if (this.f14947j) {
                Logger logger = f14945o;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(ub.c.r(">> CONNECTION %s", c.f14839a.hex()));
                }
                this.f14946e.write(c.f14839a.toByteArray());
                this.f14946e.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f14950m = true;
        this.f14946e.close();
    }

    public synchronized void d(boolean z10, int i10, okio.c cVar, int i11) {
        if (this.f14950m) {
            throw new IOException("closed");
        }
        f(i10, z10 ? (byte) 1 : (byte) 0, cVar, i11);
    }

    public void f(int i10, byte b10, okio.c cVar, int i11) {
        g(i10, i11, (byte) 0, b10);
        if (i11 > 0) {
            this.f14946e.I(cVar, i11);
        }
    }

    public synchronized void flush() {
        if (this.f14950m) {
            throw new IOException("closed");
        }
        this.f14946e.flush();
    }

    public void g(int i10, int i11, byte b10, byte b11) {
        Logger logger = f14945o;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.b(false, i10, i11, b10, b11));
        }
        int i12 = this.f14949l;
        if (i11 > i12) {
            throw c.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw c.c("reserved bit set: %s", Integer.valueOf(i10));
        }
        r(this.f14946e, i11);
        this.f14946e.writeByte(b10 & 255);
        this.f14946e.writeByte(b11 & 255);
        this.f14946e.writeInt(i10 & Integer.MAX_VALUE);
    }

    public synchronized void h(int i10, ErrorCode errorCode, byte[] bArr) {
        try {
            if (this.f14950m) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode == -1) {
                throw c.c("errorCode.httpCode == -1", new Object[0]);
            }
            g(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f14946e.writeInt(i10);
            this.f14946e.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f14946e.write(bArr);
            }
            this.f14946e.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void i(boolean z10, int i10, List list) throws IOException {
        if (this.f14950m) {
            throw new IOException("closed");
        }
        this.f14951n.g(list);
        long size = this.f14948k.size();
        int iMin = (int) Math.min(this.f14949l, size);
        long j10 = iMin;
        byte b10 = size == j10 ? (byte) 4 : (byte) 0;
        if (z10) {
            b10 = (byte) (b10 | 1);
        }
        g(i10, iMin, (byte) 1, b10);
        this.f14946e.I(this.f14948k, j10);
        if (size > j10) {
            q(i10, size - j10);
        }
    }

    public int j() {
        return this.f14949l;
    }

    public synchronized void k(boolean z10, int i10, int i11) {
        if (this.f14950m) {
            throw new IOException("closed");
        }
        g(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
        this.f14946e.writeInt(i10);
        this.f14946e.writeInt(i11);
        this.f14946e.flush();
    }

    public synchronized void l(int i10, int i11, List list) {
        if (this.f14950m) {
            throw new IOException("closed");
        }
        this.f14951n.g(list);
        long size = this.f14948k.size();
        int iMin = (int) Math.min(this.f14949l - 4, size);
        long j10 = iMin;
        g(i10, iMin + 4, (byte) 5, size == j10 ? (byte) 4 : (byte) 0);
        this.f14946e.writeInt(i11 & Integer.MAX_VALUE);
        this.f14946e.I(this.f14948k, j10);
        if (size > j10) {
            q(i10, size - j10);
        }
    }

    public synchronized void m(int i10, ErrorCode errorCode) {
        if (this.f14950m) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        g(i10, 4, (byte) 3, (byte) 0);
        this.f14946e.writeInt(errorCode.httpCode);
        this.f14946e.flush();
    }

    public synchronized void n(k kVar) {
        try {
            if (this.f14950m) {
                throw new IOException("closed");
            }
            int i10 = 0;
            g(0, kVar.j() * 6, (byte) 4, (byte) 0);
            while (i10 < 10) {
                if (kVar.g(i10)) {
                    this.f14946e.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                    this.f14946e.writeInt(kVar.b(i10));
                }
                i10++;
            }
            this.f14946e.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void o(boolean z10, int i10, int i11, List list) {
        if (this.f14950m) {
            throw new IOException("closed");
        }
        i(z10, i10, list);
    }

    public synchronized void p(int i10, long j10) {
        if (this.f14950m) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > 2147483647L) {
            throw c.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        }
        g(i10, 4, (byte) 8, (byte) 0);
        this.f14946e.writeInt((int) j10);
        this.f14946e.flush();
    }

    public final void q(int i10, long j10) {
        while (j10 > 0) {
            int iMin = (int) Math.min(this.f14949l, j10);
            long j11 = iMin;
            j10 -= j11;
            g(i10, iMin, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
            this.f14946e.I(this.f14948k, j11);
        }
    }
}
