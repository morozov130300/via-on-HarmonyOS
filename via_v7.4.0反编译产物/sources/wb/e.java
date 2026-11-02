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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.a f13427a;

    /* renamed from: b, reason: collision with root package name */
    public final d f13428b;

    /* renamed from: c, reason: collision with root package name */
    public final okhttp3.d f13429c;

    /* renamed from: d, reason: collision with root package name */
    public final o f13430d;

    /* renamed from: e, reason: collision with root package name */
    public List f13431e;

    /* renamed from: f, reason: collision with root package name */
    public int f13432f;

    /* renamed from: g, reason: collision with root package name */
    public List f13433g;

    /* renamed from: h, reason: collision with root package name */
    public final List f13434h;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f13435a;

        /* renamed from: b, reason: collision with root package name */
        public int f13436b = 0;

        public a(List list) {
            this.f13435a = list;
        }

        public List a() {
            return new ArrayList(this.f13435a);
        }

        public boolean b() {
            return this.f13436b < this.f13435a.size();
        }

        public a0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List list = this.f13435a;
            int i10 = this.f13436b;
            this.f13436b = i10 + 1;
            return (a0) list.get(i10);
        }
    }

    public e(okhttp3.a aVar, d dVar, okhttp3.d dVar2, o oVar) {
        List list = Collections.EMPTY_LIST;
        this.f13431e = list;
        this.f13433g = list;
        this.f13434h = new ArrayList();
        this.f13427a = aVar;
        this.f13428b = dVar;
        this.f13429c = dVar2;
        this.f13430d = oVar;
        h(aVar.l(), aVar.g());
    }

    public static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    public void a(a0 a0Var, IOException iOException) {
        if (a0Var.b().type() != Proxy.Type.DIRECT && this.f13427a.i() != null) {
            this.f13427a.i().connectFailed(this.f13427a.l().C(), a0Var.b().address(), iOException);
        }
        this.f13428b.b(a0Var);
    }

    public boolean c() {
        return d() || !this.f13434h.isEmpty();
    }

    public final boolean d() {
        return this.f13432f < this.f13431e.size();
    }

    public a e() throws SocketException, UnknownHostException {
        if (!c()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (d()) {
            Proxy proxyF = f();
            int size = this.f13433g.size();
            for (int i10 = 0; i10 < size; i10++) {
                a0 a0Var = new a0(this.f13427a, proxyF, (InetSocketAddress) this.f13433g.get(i10));
                if (this.f13428b.c(a0Var)) {
                    this.f13434h.add(a0Var);
                } else {
                    arrayList.add(a0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f13434h);
            this.f13434h.clear();
        }
        return new a(arrayList);
    }

    public final Proxy f() throws SocketException, UnknownHostException {
        if (d()) {
            List list = this.f13431e;
            int i10 = this.f13432f;
            this.f13432f = i10 + 1;
            Proxy proxy = (Proxy) list.get(i10);
            g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f13427a.l().l() + "; exhausted proxy configurations: " + this.f13431e);
    }

    public final void g(Proxy proxy) throws SocketException, UnknownHostException {
        String strL;
        int iW;
        this.f13433g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strL = this.f13427a.l().l();
            iW = this.f13427a.l().w();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strL = b(inetSocketAddress);
            iW = inetSocketAddress.getPort();
        }
        if (iW < 1 || iW > 65535) {
            throw new SocketException("No route to " + strL + ":" + iW + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f13433g.add(InetSocketAddress.createUnresolved(strL, iW));
            return;
        }
        this.f13430d.j(this.f13429c, strL);
        List listA = this.f13427a.c().a(strL);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.f13427a.c() + " returned no addresses for " + strL);
        }
        this.f13430d.i(this.f13429c, strL, listA);
        int size = listA.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f13433g.add(new InetSocketAddress((InetAddress) listA.get(i10), iW));
        }
    }

    public final void h(r rVar, Proxy proxy) {
        if (proxy != null) {
            this.f13431e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f13427a.i().select(rVar.C());
            this.f13431e = (listSelect == null || listSelect.isEmpty()) ? ub.c.u(Proxy.NO_PROXY) : ub.c.t(listSelect);
        }
        this.f13432f = 0;
    }
}
