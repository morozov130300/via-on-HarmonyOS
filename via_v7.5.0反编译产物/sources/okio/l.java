package okio;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f11465c = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f11466e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11467m;

    public l(p pVar) {
        if (pVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f11466e = pVar;
    }

    @Override // okio.d
    public d H(String str) {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        this.f11465c.H(str);
        return a();
    }

    @Override // okio.p
    public void L(c cVar, long j10) {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        this.f11465c.L(cVar, j10);
        a();
    }

    @Override // okio.d
    public long M(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long jU = qVar.U(this.f11465c, 8192L);
            if (jU == -1) {
                return j10;
            }
            j10 += jU;
            a();
        }
    }

    @Override // okio.d
    public d N(long j10) {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        this.f11465c.N(j10);
        return a();
    }

    public d a() {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        long jE = this.f11465c.e();
        if (jE > 0) {
            this.f11466e.L(this.f11465c, jE);
        }
        return this;
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f11467m) {
            return;
        }
        c cVar = this.f11465c;
        long j10 = cVar.f11445e;
        if (j10 > 0) {
            this.f11466e.L(cVar, j10);
        }
        th = null;
        try {
            this.f11466e.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.f11467m = true;
        if (th != null) {
            s.e(th);
        }
    }

    @Override // okio.d
    public c d() {
        return this.f11465c;
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f11465c;
        long j10 = cVar.f11445e;
        if (j10 > 0) {
            this.f11466e.L(cVar, j10);
        }
        this.f11466e.flush();
    }

    @Override // okio.p
    public r i() {
        return this.f11466e.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f11467m;
    }

    public String toString() {
        return "buffer(" + this.f11466e + ")";
    }

    @Override // okio.d
    public d write(byte[] bArr) {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        this.f11465c.write(bArr);
        return a();
    }

    @Override // okio.d
    public d writeByte(int i10) {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        this.f11465c.writeByte(i10);
        return a();
    }

    @Override // okio.d
    public d writeInt(int i10) {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        this.f11465c.writeInt(i10);
        return a();
    }

    @Override // okio.d
    public d writeShort(int i10) {
        if (this.f11467m) {
            throw new IllegalStateException("closed");
        }
        this.f11465c.writeShort(i10);
        return a();
    }

    @Override // okio.d
    public d write(byte[] bArr, int i10, int i11) {
        if (!this.f11467m) {
            this.f11465c.write(bArr, i10, i11);
            return a();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (!this.f11467m) {
            int iWrite = this.f11465c.write(byteBuffer);
            a();
            return iWrite;
        }
        throw new IllegalStateException("closed");
    }
}
