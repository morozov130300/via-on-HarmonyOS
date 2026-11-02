package zb;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;
import okio.q;
import okio.r;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import zb.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f implements Closeable {

    /* renamed from: m, reason: collision with root package name */
    public static final Logger f14912m = Logger.getLogger(c.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public final okio.e f14913e;

    /* renamed from: j, reason: collision with root package name */
    public final a f14914j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f14915k;

    /* renamed from: l, reason: collision with root package name */
    public final b.a f14916l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements q {

        /* renamed from: e, reason: collision with root package name */
        public final okio.e f14917e;

        /* renamed from: j, reason: collision with root package name */
        public int f14918j;

        /* renamed from: k, reason: collision with root package name */
        public byte f14919k;

        /* renamed from: l, reason: collision with root package name */
        public int f14920l;

        /* renamed from: m, reason: collision with root package name */
        public int f14921m;

        /* renamed from: n, reason: collision with root package name */
        public short f14922n;

        public a(okio.e eVar) {
            this.f14917e = eVar;
        }

        @Override // okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            while (true) {
                int i10 = this.f14921m;
                if (i10 != 0) {
                    long jU = this.f14917e.U(cVar, Math.min(j10, i10));
                    if (jU == -1) {
                        return -1L;
                    }
                    this.f14921m = (int) (this.f14921m - jU);
                    return jU;
                }
                this.f14917e.skip(this.f14922n);
                this.f14922n = (short) 0;
                if ((this.f14919k & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        public final void a() throws IOException {
            int i10 = this.f14920l;
            int iJ = f.j(this.f14917e);
            this.f14921m = iJ;
            this.f14918j = iJ;
            byte b10 = (byte) (this.f14917e.readByte() & 255);
            this.f14919k = (byte) (this.f14917e.readByte() & 255);
            Logger logger = f.f14912m;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(c.b(true, this.f14920l, this.f14918j, b10, this.f14919k));
            }
            int i11 = this.f14917e.readInt() & Integer.MAX_VALUE;
            this.f14920l = i11;
            if (b10 != 9) {
                throw c.d("%s != TYPE_CONTINUATION", Byte.valueOf(b10));
            }
            if (i11 != i10) {
                throw c.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // okio.q
        public r e() {
            return this.f14917e.e();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(boolean z10, k kVar);

        void b();

        void c(boolean z10, int i10, int i11, List list);

        void d(int i10, long j10);

        void e(boolean z10, int i10, okio.e eVar, int i11);

        void f(boolean z10, int i10, int i11);

        void g(int i10, int i11, int i12, boolean z10);

        void h(int i10, ErrorCode errorCode);

        void i(int i10, int i11, List list);

        void j(int i10, ErrorCode errorCode, ByteString byteString);
    }

    public f(okio.e eVar, boolean z10) {
        this.f14913e = eVar;
        this.f14915k = z10;
        a aVar = new a(eVar);
        this.f14914j = aVar;
        this.f14916l = new b.a(4096, aVar);
    }

    public static int a(int i10, byte b10, short s10) throws IOException {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw c.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    public static int j(okio.e eVar) {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    public boolean b(boolean z10, b bVar) throws IOException {
        try {
            this.f14913e.X(9L);
            int iJ = j(this.f14913e);
            if (iJ < 0 || iJ > 16384) {
                throw c.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(iJ));
            }
            byte b10 = (byte) (this.f14913e.readByte() & 255);
            if (z10 && b10 != 4) {
                throw c.d("Expected a SETTINGS frame but was %s", Byte.valueOf(b10));
            }
            byte b11 = (byte) (this.f14913e.readByte() & 255);
            int i10 = this.f14913e.readInt() & Integer.MAX_VALUE;
            Logger logger = f14912m;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(c.b(true, i10, iJ, b10, b11));
            }
            switch (b10) {
                case 0:
                    f(bVar, iJ, b11, i10);
                    return true;
                case 1:
                    i(bVar, iJ, b11, i10);
                    return true;
                case 2:
                    m(bVar, iJ, b11, i10);
                    return true;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    o(bVar, iJ, b11, i10);
                    return true;
                case 4:
                    p(bVar, iJ, b11, i10);
                    return true;
                case 5:
                    n(bVar, iJ, b11, i10);
                    return true;
                case 6:
                    k(bVar, iJ, b11, i10);
                    return true;
                case 7:
                    g(bVar, iJ, b11, i10);
                    return true;
                case 8:
                    q(bVar, iJ, b11, i10);
                    return true;
                default:
                    this.f14913e.skip(iJ);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f14913e.close();
    }

    public void d(b bVar) throws IOException {
        if (this.f14915k) {
            if (!b(true, bVar)) {
                throw c.d("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        okio.e eVar = this.f14913e;
        ByteString byteString = c.f14839a;
        ByteString byteStringA = eVar.A(byteString.size());
        Logger logger = f14912m;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(ub.c.r("<< CONNECTION %s", byteStringA.hex()));
        }
        if (!byteString.equals(byteStringA)) {
            throw c.d("Expected a connection header but was %s", byteStringA.utf8());
        }
    }

    public final void f(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw c.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z10 = (b10 & 1) != 0;
        if ((b10 & 32) != 0) {
            throw c.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s10 = (b10 & 8) != 0 ? (short) (this.f14913e.readByte() & 255) : (short) 0;
        bVar.e(z10, i11, this.f14913e, a(i10, b10, s10));
        this.f14913e.skip(s10);
    }

    public final void g(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 < 8) {
            throw c.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw c.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i12 = this.f14913e.readInt();
        int i13 = this.f14913e.readInt();
        int i14 = i10 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i13);
        if (errorCodeFromHttp2 == null) {
            throw c.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i13));
        }
        ByteString byteStringA = ByteString.EMPTY;
        if (i14 > 0) {
            byteStringA = this.f14913e.A(i14);
        }
        bVar.j(i12, errorCodeFromHttp2, byteStringA);
    }

    public final List h(int i10, short s10, byte b10, int i11) throws IOException {
        a aVar = this.f14914j;
        aVar.f14921m = i10;
        aVar.f14918j = i10;
        aVar.f14922n = s10;
        aVar.f14919k = b10;
        aVar.f14920l = i11;
        this.f14916l.k();
        return this.f14916l.e();
    }

    public final void i(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw c.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z10 = (b10 & 1) != 0;
        short s10 = (b10 & 8) != 0 ? (short) (this.f14913e.readByte() & 255) : (short) 0;
        if ((b10 & 32) != 0) {
            l(bVar, i11);
            i10 -= 5;
        }
        bVar.c(z10, i11, -1, h(a(i10, b10, s10), s10, b10, i11));
    }

    public final void k(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 8) {
            throw c.d("TYPE_PING length != 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw c.d("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.f((b10 & 1) != 0, this.f14913e.readInt(), this.f14913e.readInt());
    }

    public final void l(b bVar, int i10) {
        int i11 = this.f14913e.readInt();
        bVar.g(i10, i11 & Integer.MAX_VALUE, (this.f14913e.readByte() & 255) + 1, (Integer.MIN_VALUE & i11) != 0);
    }

    public final void m(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 5) {
            throw c.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw c.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        l(bVar, i11);
    }

    public final void n(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw c.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s10 = (b10 & 8) != 0 ? (short) (this.f14913e.readByte() & 255) : (short) 0;
        bVar.i(i11, this.f14913e.readInt() & Integer.MAX_VALUE, h(a(i10 - 4, b10, s10), s10, b10, i11));
    }

    public final void o(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw c.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw c.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i12 = this.f14913e.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i12);
        if (errorCodeFromHttp2 == null) {
            throw c.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i12));
        }
        bVar.h(i11, errorCodeFromHttp2);
    }

    public final void p(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 != 0) {
            throw c.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b10 & 1) != 0) {
            if (i10 != 0) {
                throw c.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.b();
            return;
        }
        if (i10 % 6 != 0) {
            throw c.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
        }
        k kVar = new k();
        for (int i12 = 0; i12 < i10; i12 += 6) {
            int i13 = this.f14913e.readShort() & 65535;
            int i14 = this.f14913e.readInt();
            if (i13 == 2) {
                if (i14 != 0 && i14 != 1) {
                    throw c.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i13 == 3) {
                i13 = 4;
            } else if (i13 != 4) {
                if (i13 == 5 && (i14 < 16384 || i14 > 16777215)) {
                    throw c.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i14));
                }
            } else {
                if (i14 < 0) {
                    throw c.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i13 = 7;
            }
            kVar.i(i13, i14);
        }
        bVar.a(false, kVar);
    }

    public final void q(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw c.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
        long j10 = this.f14913e.readInt() & 2147483647L;
        if (j10 == 0) {
            throw c.d("windowSizeIncrement was 0", Long.valueOf(j10));
        }
        bVar.d(i11, j10);
    }
}
