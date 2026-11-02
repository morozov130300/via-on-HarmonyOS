package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f10535a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f10536b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f10537c;

    public a0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f10535a = aVar;
        this.f10536b = proxy;
        this.f10537c = inetSocketAddress;
    }

    public a a() {
        return this.f10535a;
    }

    public Proxy b() {
        return this.f10536b;
    }

    public boolean c() {
        return this.f10535a.f10532i != null && this.f10536b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f10537c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return a0Var.f10535a.equals(this.f10535a) && a0Var.f10536b.equals(this.f10536b) && a0Var.f10537c.equals(this.f10537c);
    }

    public int hashCode() {
        return ((((527 + this.f10535a.hashCode()) * 31) + this.f10536b.hashCode()) * 31) + this.f10537c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f10537c + "}";
    }
}
