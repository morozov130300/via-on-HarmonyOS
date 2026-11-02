package wb;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final List f13408a;

    /* renamed from: b, reason: collision with root package name */
    public int f13409b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13410c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13411d;

    public b(List list) {
        this.f13408a = list;
    }

    public i a(SSLSocket sSLSocket) throws UnknownServiceException {
        i iVar;
        int i10 = this.f13409b;
        int size = this.f13408a.size();
        while (true) {
            if (i10 >= size) {
                iVar = null;
                break;
            }
            iVar = (i) this.f13408a.get(i10);
            if (iVar.c(sSLSocket)) {
                this.f13409b = i10 + 1;
                break;
            }
            i10++;
        }
        if (iVar != null) {
            this.f13410c = c(sSLSocket);
            ub.a.f12933a.c(iVar, sSLSocket, this.f13411d);
            return iVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f13411d + ", modes=" + this.f13408a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f13411d = true;
        if (!this.f13410c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z10 = iOException instanceof SSLHandshakeException;
        if ((z10 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z10 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }

    public final boolean c(SSLSocket sSLSocket) {
        for (int i10 = this.f13409b; i10 < this.f13408a.size(); i10++) {
            if (((i) this.f13408a.get(i10)).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
