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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14412b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14414d;

    public b(List list) {
        this.f14411a = list;
    }

    public i a(SSLSocket sSLSocket) throws UnknownServiceException {
        i iVar;
        int i10 = this.f14412b;
        int size = this.f14411a.size();
        while (true) {
            if (i10 >= size) {
                iVar = null;
                break;
            }
            iVar = (i) this.f14411a.get(i10);
            if (iVar.c(sSLSocket)) {
                this.f14412b = i10 + 1;
                break;
            }
            i10++;
        }
        if (iVar != null) {
            this.f14413c = c(sSLSocket);
            ub.a.f12943a.c(iVar, sSLSocket, this.f14414d);
            return iVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f14414d + ", modes=" + this.f14411a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f14414d = true;
        if (!this.f14413c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z10 = iOException instanceof SSLHandshakeException;
        if ((z10 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z10 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }

    public final boolean c(SSLSocket sSLSocket) {
        for (int i10 = this.f14412b; i10 < this.f14411a.size(); i10++) {
            if (((i) this.f14411a.get(i10)).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
