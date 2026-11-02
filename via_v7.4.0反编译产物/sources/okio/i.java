package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i implements q {

    /* renamed from: j, reason: collision with root package name */
    public final e f10838j;

    /* renamed from: k, reason: collision with root package name */
    public final Inflater f10839k;

    /* renamed from: l, reason: collision with root package name */
    public final j f10840l;

    /* renamed from: e, reason: collision with root package name */
    public int f10837e = 0;

    /* renamed from: m, reason: collision with root package name */
    public final CRC32 f10841m = new CRC32();

    public i(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f10839k = inflater;
        e eVarB = k.b(qVar);
        this.f10838j = eVarB;
        this.f10840l = new j(eVarB, inflater);
    }

    @Override // okio.q
    public long U(c cVar, long j10) throws DataFormatException, IOException {
        i iVar;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f10837e == 0) {
            b();
            this.f10837e = 1;
        }
        if (this.f10837e == 1) {
            long j11 = cVar.f10832j;
            long jU = this.f10840l.U(cVar, j10);
            if (jU != -1) {
                f(cVar, j11, jU);
                return jU;
            }
            iVar = this;
            iVar.f10837e = 2;
        } else {
            iVar = this;
        }
        if (iVar.f10837e == 2) {
            d();
            iVar.f10837e = 3;
            if (!iVar.f10838j.C()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    public final void a(String str, int i10, int i11) throws IOException {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public final void b() throws IOException {
        this.f10838j.X(10L);
        byte bJ = this.f10838j.c().j(3L);
        boolean z10 = ((bJ >> 1) & 1) == 1;
        if (z10) {
            f(this.f10838j.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f10838j.readShort());
        this.f10838j.skip(8L);
        if (((bJ >> 2) & 1) == 1) {
            this.f10838j.X(2L);
            if (z10) {
                f(this.f10838j.c(), 0L, 2L);
            }
            long jR = this.f10838j.c().R();
            this.f10838j.X(jR);
            if (z10) {
                f(this.f10838j.c(), 0L, jR);
            }
            this.f10838j.skip(jR);
        }
        if (((bJ >> 3) & 1) == 1) {
            long jY = this.f10838j.Y((byte) 0);
            if (jY == -1) {
                throw new EOFException();
            }
            if (z10) {
                f(this.f10838j.c(), 0L, jY + 1);
            }
            this.f10838j.skip(jY + 1);
        }
        if (((bJ >> 4) & 1) == 1) {
            long jY2 = this.f10838j.Y((byte) 0);
            if (jY2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                f(this.f10838j.c(), 0L, jY2 + 1);
            }
            this.f10838j.skip(jY2 + 1);
        }
        if (z10) {
            a("FHCRC", this.f10838j.R(), (short) this.f10841m.getValue());
            this.f10841m.reset();
        }
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10840l.close();
    }

    public final void d() throws IOException {
        a("CRC", this.f10838j.O(), (int) this.f10841m.getValue());
        a("ISIZE", this.f10838j.O(), (int) this.f10839k.getBytesWritten());
    }

    @Override // okio.q
    public r e() {
        return this.f10838j.e();
    }

    public final void f(c cVar, long j10, long j11) {
        n nVar = cVar.f10831e;
        while (true) {
            int i10 = nVar.f10861c;
            int i11 = nVar.f10860b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            nVar = nVar.f10864f;
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(nVar.f10861c - r7, j11);
            this.f10841m.update(nVar.f10859a, (int) (nVar.f10860b + j10), iMin);
            j11 -= iMin;
            nVar = nVar.f10864f;
            j10 = 0;
        }
    }
}
