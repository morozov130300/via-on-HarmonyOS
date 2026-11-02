package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final TlsVersion f10691a;

    /* renamed from: b, reason: collision with root package name */
    public final f f10692b;

    /* renamed from: c, reason: collision with root package name */
    public final List f10693c;

    /* renamed from: d, reason: collision with root package name */
    public final List f10694d;

    public p(TlsVersion tlsVersion, f fVar, List list, List list2) {
        this.f10691a = tlsVersion;
        this.f10692b = fVar;
        this.f10693c = list;
        this.f10694d = list2;
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
        return this.f10692b;
    }

    public List c() {
        return this.f10693c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f10691a.equals(pVar.f10691a) && this.f10692b.equals(pVar.f10692b) && this.f10693c.equals(pVar.f10693c) && this.f10694d.equals(pVar.f10694d);
    }

    public int hashCode() {
        return ((((((527 + this.f10691a.hashCode()) * 31) + this.f10692b.hashCode()) * 31) + this.f10693c.hashCode()) * 31) + this.f10694d.hashCode();
    }
}
