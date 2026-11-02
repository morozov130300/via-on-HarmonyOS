package zb;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.q;
import okhttp3.s;
import okhttp3.u;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import okio.ByteString;
import okio.p;
import okio.q;
import okio.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements xb.c {

    /* renamed from: f, reason: collision with root package name */
    public static final List f14843f = ub.c.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: g, reason: collision with root package name */
    public static final List f14844g = ub.c.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    public final s.a f14845a;

    /* renamed from: b, reason: collision with root package name */
    public final wb.f f14846b;

    /* renamed from: c, reason: collision with root package name */
    public final e f14847c;

    /* renamed from: d, reason: collision with root package name */
    public g f14848d;

    /* renamed from: e, reason: collision with root package name */
    public final Protocol f14849e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends okio.g {

        /* renamed from: j, reason: collision with root package name */
        public boolean f14850j;

        /* renamed from: k, reason: collision with root package name */
        public long f14851k;

        public a(q qVar) {
            super(qVar);
            this.f14850j = false;
            this.f14851k = 0L;
        }

        @Override // okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            try {
                long jU = a().U(cVar, j10);
                if (jU <= 0) {
                    return jU;
                }
                this.f14851k += jU;
                return jU;
            } catch (IOException e10) {
                b(e10);
                throw e10;
            }
        }

        public final void b(IOException iOException) throws IOException {
            if (this.f14850j) {
                return;
            }
            this.f14850j = true;
            d dVar = d.this;
            dVar.f14846b.r(false, dVar, this.f14851k, iOException);
        }

        @Override // okio.g, okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            b(null);
        }
    }

    public d(u uVar, s.a aVar, wb.f fVar, e eVar) {
        this.f14845a = aVar;
        this.f14846b = fVar;
        this.f14847c = eVar;
        List listY = uVar.y();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f14849e = listY.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    public static List g(w wVar) {
        okhttp3.q qVarD = wVar.d();
        ArrayList arrayList = new ArrayList(qVarD.j() + 4);
        arrayList.add(new zb.a(zb.a.f14812f, wVar.f()));
        arrayList.add(new zb.a(zb.a.f14813g, xb.i.c(wVar.h())));
        String strC = wVar.c("Host");
        if (strC != null) {
            arrayList.add(new zb.a(zb.a.f14815i, strC));
        }
        arrayList.add(new zb.a(zb.a.f14814h, wVar.h().A()));
        int iJ = qVarD.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(qVarD.e(i10).toLowerCase(Locale.US));
            if (!f14843f.contains(byteStringEncodeUtf8.utf8())) {
                arrayList.add(new zb.a(byteStringEncodeUtf8, qVarD.k(i10)));
            }
        }
        return arrayList;
    }

    public static y.a h(okhttp3.q qVar, Protocol protocol) throws ProtocolException, NumberFormatException {
        q.a aVar = new q.a();
        int iJ = qVar.j();
        xb.k kVarA = null;
        for (int i10 = 0; i10 < iJ; i10++) {
            String strE = qVar.e(i10);
            String strK = qVar.k(i10);
            if (strE.equals(":status")) {
                kVarA = xb.k.a("HTTP/1.1 " + strK);
            } else if (!f14844g.contains(strE)) {
                ub.a.f12933a.b(aVar, strE, strK);
            }
        }
        if (kVarA != null) {
            return new y.a().n(protocol).g(kVarA.f14348b).k(kVarA.f14349c).j(aVar.d());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // xb.c
    public void a() {
        this.f14848d.j().close();
    }

    @Override // xb.c
    public void b(w wVar) {
        if (this.f14848d != null) {
            return;
        }
        g gVarL = this.f14847c.l(g(wVar), wVar.a() != null);
        this.f14848d = gVarL;
        r rVarN = gVarL.n();
        long jA = this.f14845a.a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        rVarN.g(jA, timeUnit);
        this.f14848d.u().g(this.f14845a.b(), timeUnit);
    }

    @Override // xb.c
    public z c(y yVar) {
        wb.f fVar = this.f14846b;
        fVar.f13442f.q(fVar.f13441e);
        return new xb.h(yVar.g("Content-Type"), xb.e.b(yVar), okio.k.b(new a(this.f14848d.k())));
    }

    @Override // xb.c
    public void cancel() {
        g gVar = this.f14848d;
        if (gVar != null) {
            gVar.h(ErrorCode.CANCEL);
        }
    }

    @Override // xb.c
    public y.a d(boolean z10) throws ProtocolException, NumberFormatException {
        y.a aVarH = h(this.f14848d.s(), this.f14849e);
        if (z10 && ub.a.f12933a.d(aVarH) == 100) {
            return null;
        }
        return aVarH;
    }

    @Override // xb.c
    public void e() {
        this.f14847c.flush();
    }

    @Override // xb.c
    public p f(w wVar, long j10) {
        return this.f14848d.j();
    }
}
