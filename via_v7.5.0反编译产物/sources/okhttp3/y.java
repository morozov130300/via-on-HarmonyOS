package okhttp3;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f11403c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Protocol f11404e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f11406n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p f11407o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q f11408p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final z f11409q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final y f11410r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final y f11411s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final y f11412t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f11413u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f11414v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile c f11415w;

    public y(a aVar) {
        this.f11403c = aVar.f11416a;
        this.f11404e = aVar.f11417b;
        this.f11405m = aVar.f11418c;
        this.f11406n = aVar.f11419d;
        this.f11407o = aVar.f11420e;
        this.f11408p = aVar.f11421f.d();
        this.f11409q = aVar.f11422g;
        this.f11410r = aVar.f11423h;
        this.f11411s = aVar.f11424i;
        this.f11412t = aVar.f11425j;
        this.f11413u = aVar.f11426k;
        this.f11414v = aVar.f11427l;
    }

    public z a() {
        return this.f11409q;
    }

    public c b() {
        c cVar = this.f11415w;
        if (cVar != null) {
            return cVar;
        }
        c cVarK = c.k(this.f11408p);
        this.f11415w = cVarK;
        return cVarK;
    }

    public int c() {
        return this.f11405m;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        z zVar = this.f11409q;
        if (zVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        zVar.close();
    }

    public p e() {
        return this.f11407o;
    }

    public String f(String str) {
        return g(str, null);
    }

    public String g(String str, String str2) {
        String strC = this.f11408p.c(str);
        return strC != null ? strC : str2;
    }

    public q h() {
        return this.f11408p;
    }

    public boolean j() {
        int i10 = this.f11405m;
        return i10 >= 200 && i10 < 300;
    }

    public String k() {
        return this.f11406n;
    }

    public a l() {
        return new a(this);
    }

    public y m() {
        return this.f11412t;
    }

    public long n() {
        return this.f11414v;
    }

    public w o() {
        return this.f11403c;
    }

    public long p() {
        return this.f11413u;
    }

    public String toString() {
        return "Response{protocol=" + this.f11404e + ", code=" + this.f11405m + ", message=" + this.f11406n + ", url=" + this.f11403c.h() + '}';
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w f11416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Protocol f11417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public p f11420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public q.a f11421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public z f11422g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public y f11423h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public y f11424i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public y f11425j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f11426k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f11427l;

        public a() {
            this.f11418c = -1;
            this.f11421f = new q.a();
        }

        public a a(String str, String str2) {
            this.f11421f.a(str, str2);
            return this;
        }

        public a b(z zVar) {
            this.f11422g = zVar;
            return this;
        }

        public y c() {
            if (this.f11416a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f11417b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f11418c >= 0) {
                if (this.f11419d != null) {
                    return new y(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f11418c);
        }

        public a d(y yVar) {
            if (yVar != null) {
                f("cacheResponse", yVar);
            }
            this.f11424i = yVar;
            return this;
        }

        public final void e(y yVar) {
            if (yVar.f11409q != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, y yVar) {
            if (yVar.f11409q != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (yVar.f11410r != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (yVar.f11411s != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (yVar.f11412t == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a g(int i10) {
            this.f11418c = i10;
            return this;
        }

        public a h(p pVar) {
            this.f11420e = pVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f11421f.f(str, str2);
            return this;
        }

        public a j(q qVar) {
            this.f11421f = qVar.g();
            return this;
        }

        public a k(String str) {
            this.f11419d = str;
            return this;
        }

        public a l(y yVar) {
            if (yVar != null) {
                f("networkResponse", yVar);
            }
            this.f11423h = yVar;
            return this;
        }

        public a m(y yVar) {
            if (yVar != null) {
                e(yVar);
            }
            this.f11425j = yVar;
            return this;
        }

        public a n(Protocol protocol) {
            this.f11417b = protocol;
            return this;
        }

        public a o(long j10) {
            this.f11427l = j10;
            return this;
        }

        public a p(w wVar) {
            this.f11416a = wVar;
            return this;
        }

        public a q(long j10) {
            this.f11426k = j10;
            return this;
        }

        public a(y yVar) {
            this.f11418c = -1;
            this.f11416a = yVar.f11403c;
            this.f11417b = yVar.f11404e;
            this.f11418c = yVar.f11405m;
            this.f11419d = yVar.f11406n;
            this.f11420e = yVar.f11407o;
            this.f11421f = yVar.f11408p.g();
            this.f11422g = yVar.f11409q;
            this.f11423h = yVar.f11410r;
            this.f11424i = yVar.f11411s;
            this.f11425j = yVar.f11412t;
            this.f11426k = yVar.f11413u;
            this.f11427l = yVar.f11414v;
        }
    }
}
