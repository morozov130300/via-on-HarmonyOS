package d1;

import d1.o;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends o {

    /* renamed from: a, reason: collision with root package name */
    public final p f4479a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4480b;

    /* renamed from: c, reason: collision with root package name */
    public final a1.c f4481c;

    /* renamed from: d, reason: collision with root package name */
    public final a1.d f4482d;

    /* renamed from: e, reason: collision with root package name */
    public final a1.b f4483e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends o.a {

        /* renamed from: a, reason: collision with root package name */
        public p f4484a;

        /* renamed from: b, reason: collision with root package name */
        public String f4485b;

        /* renamed from: c, reason: collision with root package name */
        public a1.c f4486c;

        /* renamed from: d, reason: collision with root package name */
        public a1.d f4487d;

        /* renamed from: e, reason: collision with root package name */
        public a1.b f4488e;

        @Override // d1.o.a
        public o a() {
            String str = "";
            if (this.f4484a == null) {
                str = " transportContext";
            }
            if (this.f4485b == null) {
                str = str + " transportName";
            }
            if (this.f4486c == null) {
                str = str + " event";
            }
            if (this.f4487d == null) {
                str = str + " transformer";
            }
            if (this.f4488e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f4484a, this.f4485b, this.f4486c, this.f4487d, this.f4488e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d1.o.a
        public o.a b(a1.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f4488e = bVar;
            return this;
        }

        @Override // d1.o.a
        public o.a c(a1.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f4486c = cVar;
            return this;
        }

        @Override // d1.o.a
        public o.a d(a1.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f4487d = dVar;
            return this;
        }

        @Override // d1.o.a
        public o.a e(p pVar) {
            if (pVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f4484a = pVar;
            return this;
        }

        @Override // d1.o.a
        public o.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f4485b = str;
            return this;
        }
    }

    public c(p pVar, String str, a1.c cVar, a1.d dVar, a1.b bVar) {
        this.f4479a = pVar;
        this.f4480b = str;
        this.f4481c = cVar;
        this.f4482d = dVar;
        this.f4483e = bVar;
    }

    @Override // d1.o
    public a1.b b() {
        return this.f4483e;
    }

    @Override // d1.o
    public a1.c c() {
        return this.f4481c;
    }

    @Override // d1.o
    public a1.d e() {
        return this.f4482d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f4479a.equals(oVar.f()) && this.f4480b.equals(oVar.g()) && this.f4481c.equals(oVar.c()) && this.f4482d.equals(oVar.e()) && this.f4483e.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // d1.o
    public p f() {
        return this.f4479a;
    }

    @Override // d1.o
    public String g() {
        return this.f4480b;
    }

    public int hashCode() {
        return ((((((((this.f4479a.hashCode() ^ 1000003) * 1000003) ^ this.f4480b.hashCode()) * 1000003) ^ this.f4481c.hashCode()) * 1000003) ^ this.f4482d.hashCode()) * 1000003) ^ this.f4483e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f4479a + ", transportName=" + this.f4480b + ", event=" + this.f4481c + ", transformer=" + this.f4482d + ", encoding=" + this.f4483e + "}";
    }
}
