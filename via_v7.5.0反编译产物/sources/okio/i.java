package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i implements q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f11451e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Inflater f11452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f11453n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11450c = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CRC32 f11454o = new CRC32();

    public i(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f11452m = inflater;
        e eVarB = k.b(qVar);
        this.f11451e = eVarB;
        this.f11453n = new j(eVarB, inflater);
    }

    @Override // okio.q
    public long U(c cVar, long j10) throws IOException {
        i iVar;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f11450c == 0) {
            b();
            this.f11450c = 1;
        }
        if (this.f11450c == 1) {
            long j11 = cVar.f11445e;
            long jU = this.f11453n.U(cVar, j10);
            if (jU != -1) {
                e(cVar, j11, jU);
                return jU;
            }
            iVar = this;
            iVar.f11450c = 2;
        } else {
            iVar = this;
        }
        if (iVar.f11450c == 2) {
            c();
            iVar.f11450c = 3;
            if (!iVar.f11451e.C()) {
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
        this.f11451e.X(10L);
        byte bK = this.f11451e.d().k(3L);
        boolean z10 = ((bK >> 1) & 1) == 1;
        if (z10) {
            e(this.f11451e.d(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f11451e.readShort());
        this.f11451e.skip(8L);
        if (((bK >> 2) & 1) == 1) {
            this.f11451e.X(2L);
            if (z10) {
                e(this.f11451e.d(), 0L, 2L);
            }
            long jT = this.f11451e.d().T();
            this.f11451e.X(jT);
            if (z10) {
                e(this.f11451e.d(), 0L, jT);
            }
            this.f11451e.skip(jT);
        }
        if (((bK >> 3) & 1) == 1) {
            long jY = this.f11451e.Y((byte) 0);
            if (jY == -1) {
                throw new EOFException();
            }
            if (z10) {
                e(this.f11451e.d(), 0L, jY + 1);
            }
            this.f11451e.skip(jY + 1);
        }
        if (((bK >> 4) & 1) == 1) {
            long jY2 = this.f11451e.Y((byte) 0);
            if (jY2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                e(this.f11451e.d(), 0L, jY2 + 1);
            }
            this.f11451e.skip(jY2 + 1);
        }
        if (z10) {
            a("FHCRC", this.f11451e.T(), (short) this.f11454o.getValue());
            this.f11454o.reset();
        }
    }

    public final void c() throws IOException {
        a("CRC", this.f11451e.R(), (int) this.f11454o.getValue());
        a("ISIZE", this.f11451e.R(), (int) this.f11452m.getBytesWritten());
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11453n.close();
    }

    public final void e(c cVar, long j10, long j11) {
        n nVar = cVar.f11444c;
        while (true) {
            int i10 = nVar.f11474c;
            int i11 = nVar.f11473b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= (long) (i10 - i11);
            nVar = nVar.f11477f;
        }
        while (j11 > 0) {
            int i12 = (int) (((long) nVar.f11473b) + j10);
            int iMin = (int) Math.min(nVar.f11474c - i12, j11);
            this.f11454o.update(nVar.f11472a, i12, iMin);
            j11 -= (long) iMin;
            nVar = nVar.f11477f;
            j10 = 0;
        }
    }

    @Override // okio.q
    public r i() {
        return this.f11451e.i();
    }
}
