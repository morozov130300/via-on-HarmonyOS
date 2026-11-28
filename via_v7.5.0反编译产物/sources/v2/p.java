package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p extends b0.e.d.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f13264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0.e.d.a.b.c f13265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13266e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.a.b.c.AbstractC0140a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c0 f13269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b0.e.d.a.b.c f13270d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f13271e;

        @Override // v2.b0.e.d.a.b.c.AbstractC0140a
        public b0.e.d.a.b.c a() {
            String str = "";
            if (this.f13267a == null) {
                str = " type";
            }
            if (this.f13269c == null) {
                str = str + " frames";
            }
            if (this.f13271e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new p(this.f13267a, this.f13268b, this.f13269c, this.f13270d, this.f13271e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.a.b.c.AbstractC0140a
        public b0.e.d.a.b.c.AbstractC0140a b(b0.e.d.a.b.c cVar) {
            this.f13270d = cVar;
            return this;
        }

        @Override // v2.b0.e.d.a.b.c.AbstractC0140a
        public b0.e.d.a.b.c.AbstractC0140a c(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("Null frames");
            }
            this.f13269c = c0Var;
            return this;
        }

        @Override // v2.b0.e.d.a.b.c.AbstractC0140a
        public b0.e.d.a.b.c.AbstractC0140a d(int i10) {
            this.f13271e = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.d.a.b.c.AbstractC0140a
        public b0.e.d.a.b.c.AbstractC0140a e(String str) {
            this.f13268b = str;
            return this;
        }

        @Override // v2.b0.e.d.a.b.c.AbstractC0140a
        public b0.e.d.a.b.c.AbstractC0140a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f13267a = str;
            return this;
        }
    }

    @Override // v2.b0.e.d.a.b.c
    public b0.e.d.a.b.c b() {
        return this.f13265d;
    }

    @Override // v2.b0.e.d.a.b.c
    public c0 c() {
        return this.f13264c;
    }

    @Override // v2.b0.e.d.a.b.c
    public int d() {
        return this.f13266e;
    }

    @Override // v2.b0.e.d.a.b.c
    public String e() {
        return this.f13263b;
    }

    public boolean equals(Object obj) {
        String str;
        b0.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.c) {
            b0.e.d.a.b.c cVar2 = (b0.e.d.a.b.c) obj;
            if (this.f13262a.equals(cVar2.f()) && ((str = this.f13263b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f13264c.equals(cVar2.c()) && ((cVar = this.f13265d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f13266e == cVar2.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.b0.e.d.a.b.c
    public String f() {
        return this.f13262a;
    }

    public int hashCode() {
        int iHashCode = (this.f13262a.hashCode() ^ 1000003) * 1000003;
        String str = this.f13263b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f13264c.hashCode()) * 1000003;
        b0.e.d.a.b.c cVar = this.f13265d;
        return ((iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f13266e;
    }

    public String toString() {
        return "Exception{type=" + this.f13262a + ", reason=" + this.f13263b + ", frames=" + this.f13264c + ", causedBy=" + this.f13265d + ", overflowCount=" + this.f13266e + "}";
    }

    public p(String str, String str2, c0 c0Var, b0.e.d.a.b.c cVar, int i10) {
        this.f13262a = str;
        this.f13263b = str2;
        this.f13264c = c0Var;
        this.f13265d = cVar;
        this.f13266e = i10;
    }
}
