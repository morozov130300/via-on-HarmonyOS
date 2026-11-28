package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b0.a.AbstractC0133a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13156c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.a.AbstractC0133a.AbstractC0134a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13159c;

        @Override // v2.b0.a.AbstractC0133a.AbstractC0134a
        public b0.a.AbstractC0133a a() {
            String str = "";
            if (this.f13157a == null) {
                str = " arch";
            }
            if (this.f13158b == null) {
                str = str + " libraryName";
            }
            if (this.f13159c == null) {
                str = str + " buildId";
            }
            if (str.isEmpty()) {
                return new d(this.f13157a, this.f13158b, this.f13159c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.a.AbstractC0133a.AbstractC0134a
        public b0.a.AbstractC0133a.AbstractC0134a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f13157a = str;
            return this;
        }

        @Override // v2.b0.a.AbstractC0133a.AbstractC0134a
        public b0.a.AbstractC0133a.AbstractC0134a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f13159c = str;
            return this;
        }

        @Override // v2.b0.a.AbstractC0133a.AbstractC0134a
        public b0.a.AbstractC0133a.AbstractC0134a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f13158b = str;
            return this;
        }
    }

    @Override // v2.b0.a.AbstractC0133a
    public String b() {
        return this.f13154a;
    }

    @Override // v2.b0.a.AbstractC0133a
    public String c() {
        return this.f13156c;
    }

    @Override // v2.b0.a.AbstractC0133a
    public String d() {
        return this.f13155b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.a.AbstractC0133a) {
            b0.a.AbstractC0133a abstractC0133a = (b0.a.AbstractC0133a) obj;
            if (this.f13154a.equals(abstractC0133a.b()) && this.f13155b.equals(abstractC0133a.d()) && this.f13156c.equals(abstractC0133a.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f13154a.hashCode() ^ 1000003) * 1000003) ^ this.f13155b.hashCode()) * 1000003) ^ this.f13156c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f13154a + ", libraryName=" + this.f13155b + ", buildId=" + this.f13156c + "}";
    }

    public d(String str, String str2, String str3) {
        this.f13154a = str;
        this.f13155b = str2;
        this.f13156c = str3;
    }
}
