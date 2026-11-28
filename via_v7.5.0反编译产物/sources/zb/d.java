package zb;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.s;
import okhttp3.u;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import okio.ByteString;
import okio.p;
import okio.q;
import okio.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements xb.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f15580f = ub.c.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f15581g = ub.c.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s.a f15582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wb.f f15583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f15584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f15585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Protocol f15586e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends okio.g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15587e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f15588m;

        public a(q qVar) {
            super(qVar);
            this.f15587e = false;
            this.f15588m = 0L;
        }

        @Override // okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            try {
                long jU = a().U(cVar, j10);
                if (jU <= 0) {
                    return jU;
                }
                this.f15588m += jU;
                return jU;
            } catch (IOException e10) {
                b(e10);
                throw e10;
            }
        }

        public final void b(IOException iOException) {
            if (this.f15587e) {
                return;
            }
            this.f15587e = true;
            d dVar = d.this;
            dVar.f15583b.r(false, dVar, this.f15588m, iOException);
        }

        @Override // okio.g, okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            b(null);
        }
    }

    public d(u uVar, s.a aVar, wb.f fVar, e eVar) {
        this.f15582a = aVar;
        this.f15583b = fVar;
        this.f15584c = eVar;
        List listY = uVar.y();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f15586e = listY.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    public static List g(w wVar) {
        okhttp3.q qVarD = wVar.d();
        ArrayList arrayList = new ArrayList(qVarD.j() + 4);
        arrayList.add(new zb.a(zb.a.f15549f, wVar.f()));
        arrayList.add(new zb.a(zb.a.f15550g, xb.i.c(wVar.h())));
        String strC = wVar.c("Host");
        if (strC != null) {
            arrayList.add(new zb.a(zb.a.f15552i, strC));
        }
        arrayList.add(new zb.a(zb.a.f15551h, wVar.h().B()));
        int iJ = qVarD.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(qVarD.e(i10).toLowerCase(Locale.US));
            if (!f15580f.contains(byteStringEncodeUtf8.utf8())) {
                arrayList.add(new zb.a(byteStringEncodeUtf8, qVarD.k(i10)));
            }
        }
        return arrayList;
    }

    public static y.a h(okhttp3.q qVar, Protocol protocol) throws ProtocolException {
        okhttp3.q.a aVar = new okhttp3.q.a();
        int iJ = qVar.j();
        xb.k kVarA = null;
        for (int i10 = 0; i10 < iJ; i10++) {
            String strE = qVar.e(i10);
            String strK = qVar.k(i10);
            if (strE.equals(":status")) {
                kVarA = xb.k.a("HTTP/1.1 " + strK);
            } else if (!f15581g.contains(strE)) {
                ub.a.f12943a.b(aVar, strE, strK);
            }
        }
        if (kVarA != null) {
            return new y.a().n(protocol).g(kVarA.f14694b).k(kVarA.f14695c).j(aVar.d());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // xb.c
    public void a() {
        this.f15585d.j().close();
    }

    @Override // xb.c
    public void b(w wVar) {
        if (this.f15585d != null) {
            return;
        }
        g gVarL = this.f15584c.l(g(wVar), wVar.a() != null);
        this.f15585d = gVarL;
        r rVarN = gVarL.n();
        long jA = this.f15582a.a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        rVarN.g(jA, timeUnit);
        this.f15585d.u().g(this.f15582a.b(), timeUnit);
    }

    @Override // xb.c
    public z c(y yVar) {
        wb.f fVar = this.f15583b;
        fVar.f14445f.q(fVar.f14444e);
        return new xb.h(yVar.f("Content-Type"), xb.e.b(yVar), okio.k.b(new a(this.f15585d.k())));
    }

    @Override // xb.c
    public void cancel() {
        g gVar = this.f15585d;
        if (gVar != null) {
            gVar.h(ErrorCode.CANCEL);
        }
    }

    @Override // xb.c
    public y.a d(boolean z10) throws ProtocolException {
        y.a aVarH = h(this.f15585d.s(), this.f15586e);
        if (z10 && ub.a.f12943a.d(aVarH) == 100) {
            return null;
        }
        return aVarH;
    }

    @Override // xb.c
    public void e() {
        this.f15584c.flush();
    }

    @Override // xb.c
    public p f(w wVar, long j10) {
        return this.f15585d.j();
    }
}
