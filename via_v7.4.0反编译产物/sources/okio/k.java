package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f10846a = Logger.getLogger(k.class.getName());

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements p {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ r f10847e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ OutputStream f10848j;

        public a(r rVar, OutputStream outputStream) {
            this.f10847e = rVar;
            this.f10848j = outputStream;
        }

        @Override // okio.p
        public void I(okio.c cVar, long j10) throws IOException {
            s.b(cVar.f10832j, 0L, j10);
            while (j10 > 0) {
                this.f10847e.f();
                n nVar = cVar.f10831e;
                int iMin = (int) Math.min(j10, nVar.f10861c - nVar.f10860b);
                this.f10848j.write(nVar.f10859a, nVar.f10860b, iMin);
                int i10 = nVar.f10860b + iMin;
                nVar.f10860b = i10;
                long j11 = iMin;
                j10 -= j11;
                cVar.f10832j -= j11;
                if (i10 == nVar.f10861c) {
                    cVar.f10831e = nVar.b();
                    o.a(nVar);
                }
            }
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f10848j.close();
        }

        @Override // okio.p
        public r e() {
            return this.f10847e;
        }

        @Override // okio.p, java.io.Flushable
        public void flush() throws IOException {
            this.f10848j.flush();
        }

        public String toString() {
            return "sink(" + this.f10848j + ")";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements q {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ r f10849e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ InputStream f10850j;

        public b(r rVar, InputStream inputStream) {
            this.f10849e = rVar;
            this.f10850j = inputStream;
        }

        @Override // okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (j10 == 0) {
                return 0L;
            }
            try {
                this.f10849e.f();
                n nVarV = cVar.v(1);
                int i10 = this.f10850j.read(nVarV.f10859a, nVarV.f10861c, (int) Math.min(j10, 8192 - nVarV.f10861c));
                if (i10 == -1) {
                    return -1L;
                }
                nVarV.f10861c += i10;
                long j11 = i10;
                cVar.f10832j += j11;
                return j11;
            } catch (AssertionError e10) {
                if (k.c(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f10850j.close();
        }

        @Override // okio.q
        public r e() {
            return this.f10849e;
        }

        public String toString() {
            return "source(" + this.f10850j + ")";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends okio.a {

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Socket f10851k;

        public c(Socket socket) {
            this.f10851k = socket;
        }

        @Override // okio.a
        public IOException o(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.a
        public void t() throws IOException {
            try {
                this.f10851k.close();
            } catch (AssertionError e10) {
                if (!k.c(e10)) {
                    throw e10;
                }
                k.f10846a.log(Level.WARNING, "Failed to close timed out socket " + this.f10851k, (Throwable) e10);
            } catch (Exception e11) {
                k.f10846a.log(Level.WARNING, "Failed to close timed out socket " + this.f10851k, (Throwable) e11);
            }
        }
    }

    public static d a(p pVar) {
        return new l(pVar);
    }

    public static e b(q qVar) {
        return new m(qVar);
    }

    public static boolean c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static p d(OutputStream outputStream, r rVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (rVar != null) {
            return new a(rVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static p e(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        okio.a aVarJ = j(socket);
        return aVarJ.r(d(socket.getOutputStream(), aVarJ));
    }

    public static q f(File file) {
        if (file != null) {
            return g(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static q g(InputStream inputStream) {
        return h(inputStream, new r());
    }

    public static q h(InputStream inputStream, r rVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (rVar != null) {
            return new b(rVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static q i(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        okio.a aVarJ = j(socket);
        return aVarJ.s(h(socket.getInputStream(), aVarJ));
    }

    public static okio.a j(Socket socket) {
        return new c(socket);
    }
}
