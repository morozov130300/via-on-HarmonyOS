package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n extends b0.e.d.a.b {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f12705a;

    /* renamed from: b, reason: collision with root package name */
    public final b0.e.d.a.b.c f12706b;

    /* renamed from: c, reason: collision with root package name */
    public final b0.a f12707c;

    /* renamed from: d, reason: collision with root package name */
    public final b0.e.d.a.b.AbstractC0136d f12708d;

    /* renamed from: e, reason: collision with root package name */
    public final c0 f12709e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.a.b.AbstractC0134b {

        /* renamed from: a, reason: collision with root package name */
        public c0 f12710a;

        /* renamed from: b, reason: collision with root package name */
        public b0.e.d.a.b.c f12711b;

        /* renamed from: c, reason: collision with root package name */
        public b0.a f12712c;

        /* renamed from: d, reason: collision with root package name */
        public b0.e.d.a.b.AbstractC0136d f12713d;

        /* renamed from: e, reason: collision with root package name */
        public c0 f12714e;

        @Override // u2.b0.e.d.a.b.AbstractC0134b
        public b0.e.d.a.b a() {
            String str = "";
            if (this.f12713d == null) {
                str = " signal";
            }
            if (this.f12714e == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new n(this.f12710a, this.f12711b, this.f12712c, this.f12713d, this.f12714e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.a.b.AbstractC0134b
        public b0.e.d.a.b.AbstractC0134b b(b0.a aVar) {
            this.f12712c = aVar;
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0134b
        public b0.e.d.a.b.AbstractC0134b c(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f12714e = c0Var;
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0134b
        public b0.e.d.a.b.AbstractC0134b d(b0.e.d.a.b.c cVar) {
            this.f12711b = cVar;
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0134b
        public b0.e.d.a.b.AbstractC0134b e(b0.e.d.a.b.AbstractC0136d abstractC0136d) {
            if (abstractC0136d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f12713d = abstractC0136d;
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0134b
        public b0.e.d.a.b.AbstractC0134b f(c0 c0Var) {
            this.f12710a = c0Var;
            return this;
        }
    }

    public n(c0 c0Var, b0.e.d.a.b.c cVar, b0.a aVar, b0.e.d.a.b.AbstractC0136d abstractC0136d, c0 c0Var2) {
        this.f12705a = c0Var;
        this.f12706b = cVar;
        this.f12707c = aVar;
        this.f12708d = abstractC0136d;
        this.f12709e = c0Var2;
    }

    @Override // u2.b0.e.d.a.b
    public b0.a b() {
        return this.f12707c;
    }

    @Override // u2.b0.e.d.a.b
    public c0 c() {
        return this.f12709e;
    }

    @Override // u2.b0.e.d.a.b
    public b0.e.d.a.b.c d() {
        return this.f12706b;
    }

    @Override // u2.b0.e.d.a.b
    public b0.e.d.a.b.AbstractC0136d e() {
        return this.f12708d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b) {
            b0.e.d.a.b bVar = (b0.e.d.a.b) obj;
            c0 c0Var = this.f12705a;
            if (c0Var != null ? c0Var.equals(bVar.f()) : bVar.f() == null) {
                b0.e.d.a.b.c cVar = this.f12706b;
                if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                    b0.a aVar = this.f12707c;
                    if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                        if (this.f12708d.equals(bVar.e()) && this.f12709e.equals(bVar.c())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // u2.b0.e.d.a.b
    public c0 f() {
        return this.f12705a;
    }

    public int hashCode() {
        c0 c0Var = this.f12705a;
        int iHashCode = ((c0Var == null ? 0 : c0Var.hashCode()) ^ 1000003) * 1000003;
        b0.e.d.a.b.c cVar = this.f12706b;
        int iHashCode2 = (iHashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        b0.a aVar = this.f12707c;
        return ((((iHashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.f12708d.hashCode()) * 1000003) ^ this.f12709e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f12705a + ", exception=" + this.f12706b + ", appExitInfo=" + this.f12707c + ", signal=" + this.f12708d + ", binaries=" + this.f12709e + "}";
    }
}
