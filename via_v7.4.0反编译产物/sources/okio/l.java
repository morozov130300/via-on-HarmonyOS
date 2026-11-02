package okio;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l implements d {

    /* renamed from: e, reason: collision with root package name */
    public final c f10852e = new c();

    /* renamed from: j, reason: collision with root package name */
    public final p f10853j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10854k;

    public l(p pVar) {
        if (pVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f10853j = pVar;
    }

    @Override // okio.d
    public d F(String str) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        this.f10852e.F(str);
        return a();
    }

    @Override // okio.p
    public void I(c cVar, long j10) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        this.f10852e.I(cVar, j10);
        a();
    }

    @Override // okio.d
    public long K(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long jU = qVar.U(this.f10852e, 8192L);
            if (jU == -1) {
                return j10;
            }
            j10 += jU;
            a();
        }
    }

    @Override // okio.d
    public d L(long j10) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        this.f10852e.L(j10);
        return a();
    }

    public d a() {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        long jD = this.f10852e.d();
        if (jD > 0) {
            this.f10853j.I(this.f10852e, jD);
        }
        return this;
    }

    @Override // okio.d
    public c c() {
        return this.f10852e;
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f10854k) {
            return;
        }
        try {
            c cVar = this.f10852e;
            long j10 = cVar.f10832j;
            if (j10 > 0) {
                this.f10853j.I(cVar, j10);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f10853j.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f10854k = true;
        if (th != null) {
            s.e(th);
        }
    }

    @Override // okio.p
    public r e() {
        return this.f10853j.e();
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f10852e;
        long j10 = cVar.f10832j;
        if (j10 > 0) {
            this.f10853j.I(cVar, j10);
        }
        this.f10853j.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f10854k;
    }

    public String toString() {
        return "buffer(" + this.f10853j + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f10852e.write(byteBuffer);
        a();
        return iWrite;
    }

    @Override // okio.d
    public d write(byte[] bArr) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        this.f10852e.write(bArr);
        return a();
    }

    @Override // okio.d
    public d write(byte[] bArr, int i10, int i11) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        this.f10852e.write(bArr, i10, i11);
        return a();
    }

    @Override // okio.d
    public d writeByte(int i10) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        this.f10852e.writeByte(i10);
        return a();
    }

    @Override // okio.d
    public d writeInt(int i10) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        this.f10852e.writeInt(i10);
        return a();
    }

    @Override // okio.d
    public d writeShort(int i10) {
        if (this.f10854k) {
            throw new IllegalStateException("closed");
        }
        this.f10852e.writeShort(i10);
        return a();
    }
}
