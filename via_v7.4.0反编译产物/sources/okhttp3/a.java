package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final r f10524a;

    /* renamed from: b, reason: collision with root package name */
    public final n f10525b;

    /* renamed from: c, reason: collision with root package name */
    public final SocketFactory f10526c;

    /* renamed from: d, reason: collision with root package name */
    public final b f10527d;

    /* renamed from: e, reason: collision with root package name */
    public final List f10528e;

    /* renamed from: f, reason: collision with root package name */
    public final List f10529f;

    /* renamed from: g, reason: collision with root package name */
    public final ProxySelector f10530g;

    /* renamed from: h, reason: collision with root package name */
    public final Proxy f10531h;

    /* renamed from: i, reason: collision with root package name */
    public final SSLSocketFactory f10532i;

    /* renamed from: j, reason: collision with root package name */
    public final HostnameVerifier f10533j;

    /* renamed from: k, reason: collision with root package name */
    public final e f10534k;

    public a(String str, int i10, n nVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, e eVar, b bVar, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        this.f10524a = new r.a().p(sSLSocketFactory != null ? "https" : "http").e(str).k(i10).a();
        if (nVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f10525b = nVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f10526c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f10527d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f10528e = ub.c.t(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f10529f = ub.c.t(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f10530g = proxySelector;
        this.f10531h = proxy;
        this.f10532i = sSLSocketFactory;
        this.f10533j = hostnameVerifier;
        this.f10534k = eVar;
    }

    public e a() {
        return this.f10534k;
    }

    public List b() {
        return this.f10529f;
    }

    public n c() {
        return this.f10525b;
    }

    public boolean d(a aVar) {
        return this.f10525b.equals(aVar.f10525b) && this.f10527d.equals(aVar.f10527d) && this.f10528e.equals(aVar.f10528e) && this.f10529f.equals(aVar.f10529f) && this.f10530g.equals(aVar.f10530g) && ub.c.q(this.f10531h, aVar.f10531h) && ub.c.q(this.f10532i, aVar.f10532i) && ub.c.q(this.f10533j, aVar.f10533j) && ub.c.q(this.f10534k, aVar.f10534k) && l().w() == aVar.l().w();
    }

    public HostnameVerifier e() {
        return this.f10533j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f10524a.equals(aVar.f10524a) && d(aVar);
    }

    public List f() {
        return this.f10528e;
    }

    public Proxy g() {
        return this.f10531h;
    }

    public b h() {
        return this.f10527d;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f10524a.hashCode()) * 31) + this.f10525b.hashCode()) * 31) + this.f10527d.hashCode()) * 31) + this.f10528e.hashCode()) * 31) + this.f10529f.hashCode()) * 31) + this.f10530g.hashCode()) * 31;
        Proxy proxy = this.f10531h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f10532i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f10533j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        e eVar = this.f10534k;
        return iHashCode4 + (eVar != null ? eVar.hashCode() : 0);
    }

    public ProxySelector i() {
        return this.f10530g;
    }

    public SocketFactory j() {
        return this.f10526c;
    }

    public SSLSocketFactory k() {
        return this.f10532i;
    }

    public r l() {
        return this.f10524a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f10524a.l());
        sb2.append(":");
        sb2.append(this.f10524a.w());
        if (this.f10531h != null) {
            sb2.append(", proxy=");
            sb2.append(this.f10531h);
        } else {
            sb2.append(", proxySelector=");
            sb2.append(this.f10530g);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
