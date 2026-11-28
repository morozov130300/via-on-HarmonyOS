package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f11386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f11388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f11389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f11390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile c f11391f;

    public w(a aVar) {
        this.f11386a = aVar.f11392a;
        this.f11387b = aVar.f11393b;
        this.f11388c = aVar.f11394c.d();
        this.f11389d = aVar.f11395d;
        this.f11390e = ub.c.v(aVar.f11396e);
    }

    public x a() {
        return this.f11389d;
    }

    public c b() {
        c cVar = this.f11391f;
        if (cVar != null) {
            return cVar;
        }
        c cVarK = c.k(this.f11388c);
        this.f11391f = cVarK;
        return cVarK;
    }

    public String c(String str) {
        return this.f11388c.c(str);
    }

    public q d() {
        return this.f11388c;
    }

    public boolean e() {
        return this.f11386a.m();
    }

    public String f() {
        return this.f11387b;
    }

    public a g() {
        return new a(this);
    }

    public r h() {
        return this.f11386a;
    }

    public String toString() {
        return "Request{method=" + this.f11387b + ", url=" + this.f11386a + ", tags=" + this.f11390e + '}';
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r f11392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public q.a f11394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public x f11395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map f11396e;

        public a() {
            this.f11396e = Collections.EMPTY_MAP;
            this.f11393b = "GET";
            this.f11394c = new q.a();
        }

        public a a(String str, String str2) {
            this.f11394c.a(str, str2);
            return this;
        }

        public w b() {
            if (this.f11392a != null) {
                return new w(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a c() {
            return f("GET", null);
        }

        public a d(String str, String str2) {
            this.f11394c.f(str, str2);
            return this;
        }

        public a e(q qVar) {
            this.f11394c = qVar.g();
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
                this.f11393b = str;
                this.f11395d = xVar;
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
            this.f11394c.e(str);
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
            this.f11392a = rVar;
            return this;
        }

        public a(w wVar) {
            Map map = Collections.EMPTY_MAP;
            this.f11396e = map;
            this.f11392a = wVar.f11386a;
            this.f11393b = wVar.f11387b;
            this.f11395d = wVar.f11389d;
            this.f11396e = wVar.f11390e.isEmpty() ? map : new LinkedHashMap(wVar.f11390e);
            this.f11394c = wVar.f11388c.g();
        }
    }
}
