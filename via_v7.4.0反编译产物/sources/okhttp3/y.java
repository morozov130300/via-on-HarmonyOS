package okhttp3;

import java.io.Closeable;
import okhttp3.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    public final w f10790e;

    /* renamed from: j, reason: collision with root package name */
    public final Protocol f10791j;

    /* renamed from: k, reason: collision with root package name */
    public final int f10792k;

    /* renamed from: l, reason: collision with root package name */
    public final String f10793l;

    /* renamed from: m, reason: collision with root package name */
    public final p f10794m;

    /* renamed from: n, reason: collision with root package name */
    public final q f10795n;

    /* renamed from: o, reason: collision with root package name */
    public final z f10796o;

    /* renamed from: p, reason: collision with root package name */
    public final y f10797p;

    /* renamed from: q, reason: collision with root package name */
    public final y f10798q;

    /* renamed from: r, reason: collision with root package name */
    public final y f10799r;

    /* renamed from: s, reason: collision with root package name */
    public final long f10800s;

    /* renamed from: t, reason: collision with root package name */
    public final long f10801t;

    /* renamed from: u, reason: collision with root package name */
    public volatile c f10802u;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public w f10803a;

        /* renamed from: b, reason: collision with root package name */
        public Protocol f10804b;

        /* renamed from: c, reason: collision with root package name */
        public int f10805c;

        /* renamed from: d, reason: collision with root package name */
        public String f10806d;

        /* renamed from: e, reason: collision with root package name */
        public p f10807e;

        /* renamed from: f, reason: collision with root package name */
        public q.a f10808f;

        /* renamed from: g, reason: collision with root package name */
        public z f10809g;

        /* renamed from: h, reason: collision with root package name */
        public y f10810h;

        /* renamed from: i, reason: collision with root package name */
        public y f10811i;

        /* renamed from: j, reason: collision with root package name */
        public y f10812j;

        /* renamed from: k, reason: collision with root package name */
        public long f10813k;

        /* renamed from: l, reason: collision with root package name */
        public long f10814l;

        public a() {
            this.f10805c = -1;
            this.f10808f = new q.a();
        }

        public a(y yVar) {
            this.f10805c = -1;
            this.f10803a = yVar.f10790e;
            this.f10804b = yVar.f10791j;
            this.f10805c = yVar.f10792k;
            this.f10806d = yVar.f10793l;
            this.f10807e = yVar.f10794m;
            this.f10808f = yVar.f10795n.g();
            this.f10809g = yVar.f10796o;
            this.f10810h = yVar.f10797p;
            this.f10811i = yVar.f10798q;
            this.f10812j = yVar.f10799r;
            this.f10813k = yVar.f10800s;
            this.f10814l = yVar.f10801t;
        }

        public a a(String str, String str2) {
            this.f10808f.a(str, str2);
            return this;
        }

        public a b(z zVar) {
            this.f10809g = zVar;
            return this;
        }

        public y c() {
            if (this.f10803a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f10804b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f10805c >= 0) {
                if (this.f10806d != null) {
                    return new y(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f10805c);
        }

        public a d(y yVar) {
            if (yVar != null) {
                f("cacheResponse", yVar);
            }
            this.f10811i = yVar;
            return this;
        }

        public final void e(y yVar) {
            if (yVar.f10796o != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, y yVar) {
            if (yVar.f10796o != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (yVar.f10797p != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (yVar.f10798q != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (yVar.f10799r == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a g(int i10) {
            this.f10805c = i10;
            return this;
        }

        public a h(p pVar) {
            this.f10807e = pVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f10808f.f(str, str2);
            return this;
        }

        public a j(q qVar) {
            this.f10808f = qVar.g();
            return this;
        }

        public a k(String str) {
            this.f10806d = str;
            return this;
        }

        public a l(y yVar) {
            if (yVar != null) {
                f("networkResponse", yVar);
            }
            this.f10810h = yVar;
            return this;
        }

        public a m(y yVar) {
            if (yVar != null) {
                e(yVar);
            }
            this.f10812j = yVar;
            return this;
        }

        public a n(Protocol protocol) {
            this.f10804b = protocol;
            return this;
        }

        public a o(long j10) {
            this.f10814l = j10;
            return this;
        }

        public a p(w wVar) {
            this.f10803a = wVar;
            return this;
        }

        public a q(long j10) {
            this.f10813k = j10;
            return this;
        }
    }

    public y(a aVar) {
        this.f10790e = aVar.f10803a;
        this.f10791j = aVar.f10804b;
        this.f10792k = aVar.f10805c;
        this.f10793l = aVar.f10806d;
        this.f10794m = aVar.f10807e;
        this.f10795n = aVar.f10808f.d();
        this.f10796o = aVar.f10809g;
        this.f10797p = aVar.f10810h;
        this.f10798q = aVar.f10811i;
        this.f10799r = aVar.f10812j;
        this.f10800s = aVar.f10813k;
        this.f10801t = aVar.f10814l;
    }

    public z a() {
        return this.f10796o;
    }

    public c b() {
        c cVar = this.f10802u;
        if (cVar != null) {
            return cVar;
        }
        c cVarK = c.k(this.f10795n);
        this.f10802u = cVarK;
        return cVarK;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        z zVar = this.f10796o;
        if (zVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        zVar.close();
    }

    public int d() {
        return this.f10792k;
    }

    public p f() {
        return this.f10794m;
    }

    public String g(String str) {
        return h(str, null);
    }

    public String h(String str, String str2) {
        String strC = this.f10795n.c(str);
        return strC != null ? strC : str2;
    }

    public q i() {
        return this.f10795n;
    }

    public boolean j() {
        int i10 = this.f10792k;
        return i10 >= 200 && i10 < 300;
    }

    public String k() {
        return this.f10793l;
    }

    public a l() {
        return new a(this);
    }

    public y m() {
        return this.f10799r;
    }

    public long n() {
        return this.f10801t;
    }

    public w o() {
        return this.f10790e;
    }

    public long p() {
        return this.f10800s;
    }

    public String toString() {
        return "Response{protocol=" + this.f10791j + ", code=" + this.f10792k + ", message=" + this.f10793l + ", url=" + this.f10790e.h() + '}';
    }
}
