package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f extends b0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f13164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13165b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f13166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13167b;

        @Override // v2.b0.d.a
        public b0.d a() {
            String str = "";
            if (this.f13166a == null) {
                str = " files";
            }
            if (str.isEmpty()) {
                return new f(this.f13166a, this.f13167b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.d.a
        public b0.d.a b(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("Null files");
            }
            this.f13166a = c0Var;
            return this;
        }

        @Override // v2.b0.d.a
        public b0.d.a c(String str) {
            this.f13167b = str;
            return this;
        }
    }

    @Override // v2.b0.d
    public c0 b() {
        return this.f13164a;
    }

    @Override // v2.b0.d
    public String c() {
        return this.f13165b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.d) {
            b0.d dVar = (b0.d) obj;
            if (this.f13164a.equals(dVar.b()) && ((str = this.f13165b) != null ? str.equals(dVar.c()) : dVar.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f13164a.hashCode() ^ 1000003) * 1000003;
        String str = this.f13165b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f13164a + ", orgId=" + this.f13165b + "}";
    }

    public f(c0 c0Var, String str) {
        this.f13164a = c0Var;
        this.f13165b = str;
    }
}
