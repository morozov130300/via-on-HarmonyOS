package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v extends b0.e.AbstractC0148e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13311d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.AbstractC0148e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f13312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f13315d;

        @Override // v2.b0.e.AbstractC0148e.a
        public b0.e.AbstractC0148e a() {
            String str = "";
            if (this.f13312a == null) {
                str = " platform";
            }
            if (this.f13313b == null) {
                str = str + " version";
            }
            if (this.f13314c == null) {
                str = str + " buildVersion";
            }
            if (this.f13315d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new v(this.f13312a.intValue(), this.f13313b, this.f13314c, this.f13315d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.AbstractC0148e.a
        public b0.e.AbstractC0148e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f13314c = str;
            return this;
        }

        @Override // v2.b0.e.AbstractC0148e.a
        public b0.e.AbstractC0148e.a c(boolean z10) {
            this.f13315d = Boolean.valueOf(z10);
            return this;
        }

        @Override // v2.b0.e.AbstractC0148e.a
        public b0.e.AbstractC0148e.a d(int i10) {
            this.f13312a = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.AbstractC0148e.a
        public b0.e.AbstractC0148e.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f13313b = str;
            return this;
        }
    }

    @Override // v2.b0.e.AbstractC0148e
    public String b() {
        return this.f13310c;
    }

    @Override // v2.b0.e.AbstractC0148e
    public int c() {
        return this.f13308a;
    }

    @Override // v2.b0.e.AbstractC0148e
    public String d() {
        return this.f13309b;
    }

    @Override // v2.b0.e.AbstractC0148e
    public boolean e() {
        return this.f13311d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.AbstractC0148e) {
            b0.e.AbstractC0148e abstractC0148e = (b0.e.AbstractC0148e) obj;
            if (this.f13308a == abstractC0148e.c() && this.f13309b.equals(abstractC0148e.d()) && this.f13310c.equals(abstractC0148e.b()) && this.f13311d == abstractC0148e.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f13308a ^ 1000003) * 1000003) ^ this.f13309b.hashCode()) * 1000003) ^ this.f13310c.hashCode()) * 1000003) ^ (this.f13311d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f13308a + ", version=" + this.f13309b + ", buildVersion=" + this.f13310c + ", jailbroken=" + this.f13311d + "}";
    }

    public v(int i10, String str, String str2, boolean z10) {
        this.f13308a = i10;
        this.f13309b = str;
        this.f13310c = str2;
        this.f13311d = z10;
    }
}
