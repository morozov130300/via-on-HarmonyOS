package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f11151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f11152c;

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
        this.f11150a = aVar;
        this.f11151b = proxy;
        this.f11152c = inetSocketAddress;
    }

    public a a() {
        return this.f11150a;
    }

    public Proxy b() {
        return this.f11151b;
    }

    public boolean c() {
        return this.f11150a.f11147i != null && this.f11151b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f11152c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return a0Var.f11150a.equals(this.f11150a) && a0Var.f11151b.equals(this.f11151b) && a0Var.f11152c.equals(this.f11152c);
    }

    public int hashCode() {
        return ((((527 + this.f11150a.hashCode()) * 31) + this.f11151b.hashCode()) * 31) + this.f11152c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f11152c + "}";
    }
}
