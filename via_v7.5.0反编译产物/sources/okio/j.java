package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j implements q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f11455c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Inflater f11456e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11458n;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f11455c = eVar;
        this.f11456e = inflater;
    }

    @Override // okio.q
    public long U(c cVar, long j10) throws IOException {
        boolean zA;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f11458n) {
            throw new IllegalStateException("closed");
        }
        if (j10 == 0) {
            return 0L;
        }
        do {
            zA = a();
            try {
                n nVarV = cVar.v(1);
                int iInflate = this.f11456e.inflate(nVarV.f11472a, nVarV.f11474c, (int) Math.min(j10, 8192 - nVarV.f11474c));
                if (iInflate > 0) {
                    nVarV.f11474c += iInflate;
                    long j11 = iInflate;
                    cVar.f11445e += j11;
                    return j11;
                }
                if (!this.f11456e.finished() && !this.f11456e.needsDictionary()) {
                }
                b();
                if (nVarV.f11473b != nVarV.f11474c) {
                    return -1L;
                }
                cVar.f11444c = nVarV.b();
                o.a(nVarV);
                return -1L;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        } while (!zA);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean a() {
        if (!this.f11456e.needsInput()) {
            return false;
        }
        b();
        if (this.f11456e.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f11455c.C()) {
            return true;
        }
        n nVar = this.f11455c.d().f11444c;
        int i10 = nVar.f11474c;
        int i11 = nVar.f11473b;
        int i12 = i10 - i11;
        this.f11457m = i12;
        this.f11456e.setInput(nVar.f11472a, i11, i12);
        return false;
    }

    public final void b() {
        int i10 = this.f11457m;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f11456e.getRemaining();
        this.f11457m -= remaining;
        this.f11455c.skip(remaining);
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f11458n) {
            return;
        }
        this.f11456e.end();
        this.f11458n = true;
        this.f11455c.close();
    }

    @Override // okio.q
    public r i() {
        return this.f11455c.i();
    }
}
