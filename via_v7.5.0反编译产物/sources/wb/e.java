package wb;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.a0;
import okhttp3.o;
import okhttp3.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.a f14430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f14431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final okhttp3.d f14432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f14433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f14434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f14436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f14437h;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f14438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14439b = 0;

        public a(List list) {
            this.f14438a = list;
        }

        public List a() {
            return new ArrayList(this.f14438a);
        }

        public boolean b() {
            return this.f14439b < this.f14438a.size();
        }

        public a0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List list = this.f14438a;
            int i10 = this.f14439b;
            this.f14439b = i10 + 1;
            return (a0) list.get(i10);
        }
    }

    public e(okhttp3.a aVar, d dVar, okhttp3.d dVar2, o oVar) {
        List list = Collections.EMPTY_LIST;
        this.f14434e = list;
        this.f14436g = list;
        this.f14437h = new ArrayList();
        this.f14430a = aVar;
        this.f14431b = dVar;
        this.f14432c = dVar2;
        this.f14433d = oVar;
        h(aVar.l(), aVar.g());
    }

    public static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    public void a(a0 a0Var, IOException iOException) {
        if (a0Var.b().type() != Proxy.Type.DIRECT && this.f14430a.i() != null) {
            this.f14430a.i().connectFailed(this.f14430a.l().D(), a0Var.b().address(), iOException);
        }
        this.f14431b.b(a0Var);
    }

    public boolean c() {
        return d() || !this.f14437h.isEmpty();
    }

    public final boolean d() {
        return this.f14435f < this.f14434e.size();
    }

    public a e() throws SocketException, UnknownHostException {
        if (!c()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (d()) {
            Proxy proxyF = f();
            int size = this.f14436g.size();
            for (int i10 = 0; i10 < size; i10++) {
                a0 a0Var = new a0(this.f14430a, proxyF, (InetSocketAddress) this.f14436g.get(i10));
                if (this.f14431b.c(a0Var)) {
                    this.f14437h.add(a0Var);
                } else {
                    arrayList.add(a0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f14437h);
            this.f14437h.clear();
        }
        return new a(arrayList);
    }

    public final Proxy f() throws SocketException, UnknownHostException {
        if (d()) {
            List list = this.f14434e;
            int i10 = this.f14435f;
            this.f14435f = i10 + 1;
            Proxy proxy = (Proxy) list.get(i10);
            g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f14430a.l().l() + "; exhausted proxy configurations: " + this.f14434e);
    }

    public final void g(Proxy proxy) throws SocketException, UnknownHostException {
        String strL;
        int iX;
        this.f14436g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strL = this.f14430a.l().l();
            iX = this.f14430a.l().x();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strL = b(inetSocketAddress);
            iX = inetSocketAddress.getPort();
        }
        if (iX < 1 || iX > 65535) {
            throw new SocketException("No route to " + strL + ":" + iX + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f14436g.add(InetSocketAddress.createUnresolved(strL, iX));
            return;
        }
        this.f14433d.j(this.f14432c, strL);
        List listA = this.f14430a.c().a(strL);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.f14430a.c() + " returned no addresses for " + strL);
        }
        this.f14433d.i(this.f14432c, strL, listA);
        int size = listA.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f14436g.add(new InetSocketAddress((InetAddress) listA.get(i10), iX));
        }
    }

    public final void h(r rVar, Proxy proxy) {
        if (proxy != null) {
            this.f14434e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f14430a.i().select(rVar.D());
            this.f14434e = (listSelect == null || listSelect.isEmpty()) ? ub.c.u(Proxy.NO_PROXY) : ub.c.t(listSelect);
        }
        this.f14435f = 0;
    }
}
