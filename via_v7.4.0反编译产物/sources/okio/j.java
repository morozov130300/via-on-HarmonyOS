package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j implements q {

    /* renamed from: e, reason: collision with root package name */
    public final e f10842e;

    /* renamed from: j, reason: collision with root package name */
    public final Inflater f10843j;

    /* renamed from: k, reason: collision with root package name */
    public int f10844k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10845l;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f10842e = eVar;
        this.f10843j = inflater;
    }

    @Override // okio.q
    public long U(c cVar, long j10) throws DataFormatException, IOException {
        boolean zA;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f10845l) {
            throw new IllegalStateException("closed");
        }
        if (j10 == 0) {
            return 0L;
        }
        do {
            zA = a();
            try {
                n nVarV = cVar.v(1);
                int iInflate = this.f10843j.inflate(nVarV.f10859a, nVarV.f10861c, (int) Math.min(j10, 8192 - nVarV.f10861c));
                if (iInflate > 0) {
                    nVarV.f10861c += iInflate;
                    long j11 = iInflate;
                    cVar.f10832j += j11;
                    return j11;
                }
                if (!this.f10843j.finished() && !this.f10843j.needsDictionary()) {
                }
                b();
                if (nVarV.f10860b != nVarV.f10861c) {
                    return -1L;
                }
                cVar.f10831e = nVarV.b();
                o.a(nVarV);
                return -1L;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        } while (!zA);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean a() {
        if (!this.f10843j.needsInput()) {
            return false;
        }
        b();
        if (this.f10843j.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f10842e.C()) {
            return true;
        }
        n nVar = this.f10842e.c().f10831e;
        int i10 = nVar.f10861c;
        int i11 = nVar.f10860b;
        int i12 = i10 - i11;
        this.f10844k = i12;
        this.f10843j.setInput(nVar.f10859a, i11, i12);
        return false;
    }

    public final void b() {
        int i10 = this.f10844k;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f10843j.getRemaining();
        this.f10844k -= remaining;
        this.f10842e.skip(remaining);
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f10845l) {
            return;
        }
        this.f10843j.end();
        this.f10845l = true;
        this.f10842e.close();
    }

    @Override // okio.q
    public r e() {
        return this.f10842e.e();
    }
}
