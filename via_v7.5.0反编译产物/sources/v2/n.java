package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n extends b0.e.d.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f13244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0.e.d.a.b.c f13245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0.a f13246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0.e.d.a.b.AbstractC0141d f13247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f13248e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.a.b.AbstractC0139b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f13249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b0.e.d.a.b.c f13250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b0.a f13251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b0.e.d.a.b.AbstractC0141d f13252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c0 f13253e;

        @Override // v2.b0.e.d.a.b.AbstractC0139b
        public b0.e.d.a.b a() {
            String str = "";
            if (this.f13252d == null) {
                str = " signal";
            }
            if (this.f13253e == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new n(this.f13249a, this.f13250b, this.f13251c, this.f13252d, this.f13253e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.a.b.AbstractC0139b
        public b0.e.d.a.b.AbstractC0139b b(b0.a aVar) {
            this.f13251c = aVar;
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0139b
        public b0.e.d.a.b.AbstractC0139b c(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f13253e = c0Var;
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0139b
        public b0.e.d.a.b.AbstractC0139b d(b0.e.d.a.b.c cVar) {
            this.f13250b = cVar;
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0139b
        public b0.e.d.a.b.AbstractC0139b e(b0.e.d.a.b.AbstractC0141d abstractC0141d) {
            if (abstractC0141d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f13252d = abstractC0141d;
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0139b
        public b0.e.d.a.b.AbstractC0139b f(c0 c0Var) {
            this.f13249a = c0Var;
            return this;
        }
    }

    @Override // v2.b0.e.d.a.b
    public b0.a b() {
        return this.f13246c;
    }

    @Override // v2.b0.e.d.a.b
    public c0 c() {
        return this.f13248e;
    }

    @Override // v2.b0.e.d.a.b
    public b0.e.d.a.b.c d() {
        return this.f13245b;
    }

    @Override // v2.b0.e.d.a.b
    public b0.e.d.a.b.AbstractC0141d e() {
        return this.f13247d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b) {
            b0.e.d.a.b bVar = (b0.e.d.a.b) obj;
            c0 c0Var = this.f13244a;
            if (c0Var != null ? c0Var.equals(bVar.f()) : bVar.f() == null) {
                b0.e.d.a.b.c cVar = this.f13245b;
                if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                    b0.a aVar = this.f13246c;
                    if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                        if (this.f13247d.equals(bVar.e()) && this.f13248e.equals(bVar.c())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // v2.b0.e.d.a.b
    public c0 f() {
        return this.f13244a;
    }

    public int hashCode() {
        c0 c0Var = this.f13244a;
        int iHashCode = ((c0Var == null ? 0 : c0Var.hashCode()) ^ 1000003) * 1000003;
        b0.e.d.a.b.c cVar = this.f13245b;
        int iHashCode2 = (iHashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        b0.a aVar = this.f13246c;
        return ((((iHashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.f13247d.hashCode()) * 1000003) ^ this.f13248e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f13244a + ", exception=" + this.f13245b + ", appExitInfo=" + this.f13246c + ", signal=" + this.f13247d + ", binaries=" + this.f13248e + "}";
    }

    public n(c0 c0Var, b0.e.d.a.b.c cVar, b0.a aVar, b0.e.d.a.b.AbstractC0141d abstractC0141d, c0 c0Var2) {
        this.f13244a = c0Var;
        this.f13245b = cVar;
        this.f13246c = aVar;
        this.f13247d = abstractC0141d;
        this.f13248e = c0Var2;
    }
}
