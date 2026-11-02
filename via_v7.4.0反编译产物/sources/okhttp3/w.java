package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final r f10773a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10774b;

    /* renamed from: c, reason: collision with root package name */
    public final q f10775c;

    /* renamed from: d, reason: collision with root package name */
    public final x f10776d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f10777e;

    /* renamed from: f, reason: collision with root package name */
    public volatile c f10778f;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public r f10779a;

        /* renamed from: b, reason: collision with root package name */
        public String f10780b;

        /* renamed from: c, reason: collision with root package name */
        public q.a f10781c;

        /* renamed from: d, reason: collision with root package name */
        public x f10782d;

        /* renamed from: e, reason: collision with root package name */
        public Map f10783e;

        public a() {
            this.f10783e = Collections.EMPTY_MAP;
            this.f10780b = "GET";
            this.f10781c = new q.a();
        }

        public a(w wVar) {
            Map map = Collections.EMPTY_MAP;
            this.f10783e = map;
            this.f10779a = wVar.f10773a;
            this.f10780b = wVar.f10774b;
            this.f10782d = wVar.f10776d;
            this.f10783e = wVar.f10777e.isEmpty() ? map : new LinkedHashMap(wVar.f10777e);
            this.f10781c = wVar.f10775c.g();
        }

        public a a(String str, String str2) {
            this.f10781c.a(str, str2);
            return this;
        }

        public w b() {
            if (this.f10779a != null) {
                return new w(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a c() {
            return f("GET", null);
        }

        public a d(String str, String str2) {
            this.f10781c.f(str, str2);
            return this;
        }

        public a e(q qVar) {
            this.f10781c = qVar.g();
            return this;
        }

        public a f(String str, x xVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (xVar != null && !xb.f.a(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (xVar != null || !xb.f.d(str)) {
                this.f10780b = str;
                this.f10782d = xVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a g(x xVar) {
            return f("POST", xVar);
        }

        public a h(x xVar) {
            return f("PUT", xVar);
        }

        public a i(String str) {
            this.f10781c.e(str);
            return this;
        }

        public a j(String str) {
            String str2;
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str2 = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str2 = "https:" + str.substring(4);
            } else {
                str2 = str;
            }
            return k(r.k(str2));
        }

        public a k(r rVar) {
            if (rVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f10779a = rVar;
            return this;
        }
    }

    public w(a aVar) {
        this.f10773a = aVar.f10779a;
        this.f10774b = aVar.f10780b;
        this.f10775c = aVar.f10781c.d();
        this.f10776d = aVar.f10782d;
        this.f10777e = ub.c.v(aVar.f10783e);
    }

    public x a() {
        return this.f10776d;
    }

    public c b() {
        c cVar = this.f10778f;
        if (cVar != null) {
            return cVar;
        }
        c cVarK = c.k(this.f10775c);
        this.f10778f = cVarK;
        return cVarK;
    }

    public String c(String str) {
        return this.f10775c.c(str);
    }

    public q d() {
        return this.f10775c;
    }

    public boolean e() {
        return this.f10773a.m();
    }

    public String f() {
        return this.f10774b;
    }

    public a g() {
        return new a(this);
    }

    public r h() {
        return this.f10773a;
    }

    public String toString() {
        return "Request{method=" + this.f10774b + ", url=" + this.f10773a + ", tags=" + this.f10777e + '}';
    }
}
