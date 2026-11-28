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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f11459a = Logger.getLogger(k.class.getName());

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f11460c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ OutputStream f11461e;

        public a(r rVar, OutputStream outputStream) {
            this.f11460c = rVar;
            this.f11461e = outputStream;
        }

        @Override // okio.p
        public void L(okio.c cVar, long j10) throws IOException {
            s.b(cVar.f11445e, 0L, j10);
            while (j10 > 0) {
                this.f11460c.f();
                n nVar = cVar.f11444c;
                int iMin = (int) Math.min(j10, nVar.f11474c - nVar.f11473b);
                this.f11461e.write(nVar.f11472a, nVar.f11473b, iMin);
                int i10 = nVar.f11473b + iMin;
                nVar.f11473b = i10;
                long j11 = iMin;
                j10 -= j11;
                cVar.f11445e -= j11;
                if (i10 == nVar.f11474c) {
                    cVar.f11444c = nVar.b();
                    o.a(nVar);
                }
            }
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f11461e.close();
        }

        @Override // okio.p, java.io.Flushable
        public void flush() throws IOException {
            this.f11461e.flush();
        }

        @Override // okio.p
        public r i() {
            return this.f11460c;
        }

        public String toString() {
            return "sink(" + this.f11461e + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements q {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f11462c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InputStream f11463e;

        public b(r rVar, InputStream inputStream) {
            this.f11462c = rVar;
            this.f11463e = inputStream;
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
                this.f11462c.f();
                n nVarV = cVar.v(1);
                int i10 = this.f11463e.read(nVarV.f11472a, nVarV.f11474c, (int) Math.min(j10, 8192 - nVarV.f11474c));
                if (i10 == -1) {
                    return -1L;
                }
                nVarV.f11474c += i10;
                long j11 = i10;
                cVar.f11445e += j11;
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
            this.f11463e.close();
        }

        @Override // okio.q
        public r i() {
            return this.f11462c;
        }

        public String toString() {
            return "source(" + this.f11463e + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends okio.a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Socket f11464k;

        public c(Socket socket) {
            this.f11464k = socket;
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
        public void t() {
            try {
                this.f11464k.close();
            } catch (AssertionError e10) {
                if (!k.c(e10)) {
                    throw e10;
                }
                k.f11459a.log(Level.WARNING, "Failed to close timed out socket " + this.f11464k, (Throwable) e10);
            } catch (Exception e11) {
                k.f11459a.log(Level.WARNING, "Failed to close timed out socket " + this.f11464k, (Throwable) e11);
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
