package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i extends b0.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13199f;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.a.AbstractC0135a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f13203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f13204e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f13205f;

        @Override // v2.b0.e.a.AbstractC0135a
        public b0.e.a a() {
            String str = "";
            if (this.f13200a == null) {
                str = " identifier";
            }
            if (this.f13201b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new i(this.f13200a, this.f13201b, this.f13202c, null, this.f13203d, this.f13204e, this.f13205f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.a.AbstractC0135a
        public b0.e.a.AbstractC0135a b(String str) {
            this.f13204e = str;
            return this;
        }

        @Override // v2.b0.e.a.AbstractC0135a
        public b0.e.a.AbstractC0135a c(String str) {
            this.f13205f = str;
            return this;
        }

        @Override // v2.b0.e.a.AbstractC0135a
        public b0.e.a.AbstractC0135a d(String str) {
            this.f13202c = str;
            return this;
        }

        @Override // v2.b0.e.a.AbstractC0135a
        public b0.e.a.AbstractC0135a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f13200a = str;
            return this;
        }

        @Override // v2.b0.e.a.AbstractC0135a
        public b0.e.a.AbstractC0135a f(String str) {
            this.f13203d = str;
            return this;
        }

        @Override // v2.b0.e.a.AbstractC0135a
        public b0.e.a.AbstractC0135a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f13201b = str;
            return this;
        }
    }

    @Override // v2.b0.e.a
    public String b() {
        return this.f13198e;
    }

    @Override // v2.b0.e.a
    public String c() {
        return this.f13199f;
    }

    @Override // v2.b0.e.a
    public String d() {
        return this.f13196c;
    }

    @Override // v2.b0.e.a
    public String e() {
        return this.f13194a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.a) {
            b0.e.a aVar = (b0.e.a) obj;
            if (this.f13194a.equals(aVar.e()) && this.f13195b.equals(aVar.h()) && ((str = this.f13196c) != null ? str.equals(aVar.d()) : aVar.d() == null)) {
                aVar.g();
                String str2 = this.f13197d;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f13198e;
                    if (str3 != null ? str3.equals(aVar.b()) : aVar.b() == null) {
                        String str4 = this.f13199f;
                        if (str4 != null ? str4.equals(aVar.c()) : aVar.c() == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // v2.b0.e.a
    public String f() {
        return this.f13197d;
    }

    @Override // v2.b0.e.a
    public b0.e.a.b g() {
        return null;
    }

    @Override // v2.b0.e.a
    public String h() {
        return this.f13195b;
    }

    public int hashCode() {
        int iHashCode = (((this.f13194a.hashCode() ^ 1000003) * 1000003) ^ this.f13195b.hashCode()) * 1000003;
        String str = this.f13196c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f13197d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f13198e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f13199f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f13194a + ", version=" + this.f13195b + ", displayVersion=" + this.f13196c + ", organization=" + ((Object) null) + ", installationUuid=" + this.f13197d + ", developmentPlatform=" + this.f13198e + ", developmentPlatformVersion=" + this.f13199f + "}";
    }

    public i(String str, String str2, String str3, b0.e.a.b bVar, String str4, String str5, String str6) {
        this.f13194a = str;
        this.f13195b = str2;
        this.f13196c = str3;
        this.f13197d = str4;
        this.f13198e = str5;
        this.f13199f = str6;
    }
}
