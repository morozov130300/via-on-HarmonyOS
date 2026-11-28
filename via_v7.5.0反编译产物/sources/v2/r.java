package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r extends b0.e.d.a.b.AbstractC0143e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f13280c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.a.b.AbstractC0143e.AbstractC0144a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f13282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c0 f13283c;

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0144a
        public b0.e.d.a.b.AbstractC0143e a() {
            String str = "";
            if (this.f13281a == null) {
                str = " name";
            }
            if (this.f13282b == null) {
                str = str + " importance";
            }
            if (this.f13283c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new r(this.f13281a, this.f13282b.intValue(), this.f13283c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0144a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0144a b(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("Null frames");
            }
            this.f13283c = c0Var;
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0144a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0144a c(int i10) {
            this.f13282b = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.d.a.b.AbstractC0143e.AbstractC0144a
        public b0.e.d.a.b.AbstractC0143e.AbstractC0144a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f13281a = str;
            return this;
        }
    }

    @Override // v2.b0.e.d.a.b.AbstractC0143e
    public c0 b() {
        return this.f13280c;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0143e
    public int c() {
        return this.f13279b;
    }

    @Override // v2.b0.e.d.a.b.AbstractC0143e
    public String d() {
        return this.f13278a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.AbstractC0143e) {
            b0.e.d.a.b.AbstractC0143e abstractC0143e = (b0.e.d.a.b.AbstractC0143e) obj;
            if (this.f13278a.equals(abstractC0143e.d()) && this.f13279b == abstractC0143e.c() && this.f13280c.equals(abstractC0143e.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f13278a.hashCode() ^ 1000003) * 1000003) ^ this.f13279b) * 1000003) ^ this.f13280c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f13278a + ", importance=" + this.f13279b + ", frames=" + this.f13280c + "}";
    }

    public r(String str, int i10, c0 c0Var) {
        this.f13278a = str;
        this.f13279b = i10;
        this.f13280c = c0Var;
    }
}
