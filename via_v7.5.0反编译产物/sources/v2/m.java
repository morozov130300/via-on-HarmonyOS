package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m extends b0.e.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0.e.d.a.b f13234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f13235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f13236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f13237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13238e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.a.AbstractC0136a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b0.e.d.a.b f13239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c0 f13240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c0 f13241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f13242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f13243e;

        @Override // v2.b0.e.d.a.AbstractC0136a
        public b0.e.d.a a() {
            String str = "";
            if (this.f13239a == null) {
                str = " execution";
            }
            if (this.f13243e == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new m(this.f13239a, this.f13240b, this.f13241c, this.f13242d, this.f13243e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.a.AbstractC0136a
        public b0.e.d.a.AbstractC0136a b(Boolean bool) {
            this.f13242d = bool;
            return this;
        }

        @Override // v2.b0.e.d.a.AbstractC0136a
        public b0.e.d.a.AbstractC0136a c(c0 c0Var) {
            this.f13240b = c0Var;
            return this;
        }

        @Override // v2.b0.e.d.a.AbstractC0136a
        public b0.e.d.a.AbstractC0136a d(b0.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.f13239a = bVar;
            return this;
        }

        @Override // v2.b0.e.d.a.AbstractC0136a
        public b0.e.d.a.AbstractC0136a e(c0 c0Var) {
            this.f13241c = c0Var;
            return this;
        }

        @Override // v2.b0.e.d.a.AbstractC0136a
        public b0.e.d.a.AbstractC0136a f(int i10) {
            this.f13243e = Integer.valueOf(i10);
            return this;
        }

        public b() {
        }

        public b(b0.e.d.a aVar) {
            this.f13239a = aVar.d();
            this.f13240b = aVar.c();
            this.f13241c = aVar.e();
            this.f13242d = aVar.b();
            this.f13243e = Integer.valueOf(aVar.f());
        }
    }

    @Override // v2.b0.e.d.a
    public Boolean b() {
        return this.f13237d;
    }

    @Override // v2.b0.e.d.a
    public c0 c() {
        return this.f13235b;
    }

    @Override // v2.b0.e.d.a
    public b0.e.d.a.b d() {
        return this.f13234a;
    }

    @Override // v2.b0.e.d.a
    public c0 e() {
        return this.f13236c;
    }

    public boolean equals(Object obj) {
        c0 c0Var;
        c0 c0Var2;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a) {
            b0.e.d.a aVar = (b0.e.d.a) obj;
            if (this.f13234a.equals(aVar.d()) && ((c0Var = this.f13235b) != null ? c0Var.equals(aVar.c()) : aVar.c() == null) && ((c0Var2 = this.f13236c) != null ? c0Var2.equals(aVar.e()) : aVar.e() == null) && ((bool = this.f13237d) != null ? bool.equals(aVar.b()) : aVar.b() == null) && this.f13238e == aVar.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.b0.e.d.a
    public int f() {
        return this.f13238e;
    }

    @Override // v2.b0.e.d.a
    public b0.e.d.a.AbstractC0136a g() {
        return new b(this);
    }

    public int hashCode() {
        int iHashCode = (this.f13234a.hashCode() ^ 1000003) * 1000003;
        c0 c0Var = this.f13235b;
        int iHashCode2 = (iHashCode ^ (c0Var == null ? 0 : c0Var.hashCode())) * 1000003;
        c0 c0Var2 = this.f13236c;
        int iHashCode3 = (iHashCode2 ^ (c0Var2 == null ? 0 : c0Var2.hashCode())) * 1000003;
        Boolean bool = this.f13237d;
        return ((iHashCode3 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.f13238e;
    }

    public String toString() {
        return "Application{execution=" + this.f13234a + ", customAttributes=" + this.f13235b + ", internalKeys=" + this.f13236c + ", background=" + this.f13237d + ", uiOrientation=" + this.f13238e + "}";
    }

    public m(b0.e.d.a.b bVar, c0 c0Var, c0 c0Var2, Boolean bool, int i10) {
        this.f13234a = bVar;
        this.f13235b = c0Var;
        this.f13236c = c0Var2;
        this.f13237d = bool;
        this.f13238e = i10;
    }
}
