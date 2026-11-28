package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f11139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f11140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SocketFactory f11141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f11142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f11143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f11144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f11145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Proxy f11146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SSLSocketFactory f11147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HostnameVerifier f11148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f11149k;

    public a(String str, int i10, n nVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, e eVar, b bVar, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        this.f11139a = new r.a().t(sSLSocketFactory != null ? "https" : "http").g(str).m(i10).b();
        if (nVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f11140b = nVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f11141c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f11142d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f11143e = ub.c.t(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f11144f = ub.c.t(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f11145g = proxySelector;
        this.f11146h = proxy;
        this.f11147i = sSLSocketFactory;
        this.f11148j = hostnameVerifier;
        this.f11149k = eVar;
    }

    public e a() {
        return this.f11149k;
    }

    public List b() {
        return this.f11144f;
    }

    public n c() {
        return this.f11140b;
    }

    public boolean d(a aVar) {
        return this.f11140b.equals(aVar.f11140b) && this.f11142d.equals(aVar.f11142d) && this.f11143e.equals(aVar.f11143e) && this.f11144f.equals(aVar.f11144f) && this.f11145g.equals(aVar.f11145g) && ub.c.q(this.f11146h, aVar.f11146h) && ub.c.q(this.f11147i, aVar.f11147i) && ub.c.q(this.f11148j, aVar.f11148j) && ub.c.q(this.f11149k, aVar.f11149k) && l().x() == aVar.l().x();
    }

    public HostnameVerifier e() {
        return this.f11148j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11139a.equals(aVar.f11139a) && d(aVar);
    }

    public List f() {
        return this.f11143e;
    }

    public Proxy g() {
        return this.f11146h;
    }

    public b h() {
        return this.f11142d;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f11139a.hashCode()) * 31) + this.f11140b.hashCode()) * 31) + this.f11142d.hashCode()) * 31) + this.f11143e.hashCode()) * 31) + this.f11144f.hashCode()) * 31) + this.f11145g.hashCode()) * 31;
        Proxy proxy = this.f11146h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f11147i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f11148j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        e eVar = this.f11149k;
        return iHashCode4 + (eVar != null ? eVar.hashCode() : 0);
    }

    public ProxySelector i() {
        return this.f11145g;
    }

    public SocketFactory j() {
        return this.f11141c;
    }

    public SSLSocketFactory k() {
        return this.f11147i;
    }

    public r l() {
        return this.f11139a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f11139a.l());
        sb2.append(":");
        sb2.append(this.f11139a.x());
        if (this.f11146h != null) {
            sb2.append(", proxy=");
            sb2.append(this.f11146h);
        } else {
            sb2.append(", proxySelector=");
            sb2.append(this.f11145g);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
