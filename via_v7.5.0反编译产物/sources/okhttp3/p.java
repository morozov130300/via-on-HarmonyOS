package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TlsVersion f11306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f11307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f11308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11309d;

    public p(TlsVersion tlsVersion, f fVar, List list, List list2) {
        this.f11306a = tlsVersion;
        this.f11307b = fVar;
        this.f11308c = list;
        this.f11309d = list2;
    }

    public static p b(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        f fVarA = f.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion tlsVersionForJavaName = TlsVersion.forJavaName(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listU = peerCertificates != null ? ub.c.u(peerCertificates) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new p(tlsVersionForJavaName, fVarA, listU, localCertificates != null ? ub.c.u(localCertificates) : Collections.EMPTY_LIST);
    }

    public f a() {
        return this.f11307b;
    }

    public List c() {
        return this.f11308c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f11306a.equals(pVar.f11306a) && this.f11307b.equals(pVar.f11307b) && this.f11308c.equals(pVar.f11308c) && this.f11309d.equals(pVar.f11309d);
    }

    public int hashCode() {
        return ((((((527 + this.f11306a.hashCode()) * 31) + this.f11307b.hashCode()) * 31) + this.f11308c.hashCode()) * 31) + this.f11309d.hashCode();
    }
}
