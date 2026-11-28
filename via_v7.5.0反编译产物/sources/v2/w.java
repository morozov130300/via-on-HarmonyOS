package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w extends b0.e.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13316a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13317a;

        @Override // v2.b0.e.f.a
        public b0.e.f a() {
            String str = "";
            if (this.f13317a == null) {
                str = " identifier";
            }
            if (str.isEmpty()) {
                return new w(this.f13317a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.f.a
        public b0.e.f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f13317a = str;
            return this;
        }
    }

    @Override // v2.b0.e.f
    public String b() {
        return this.f13316a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.f) {
            return this.f13316a.equals(((b0.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f13316a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f13316a + "}";
    }

    public w(String str) {
        this.f13316a = str;
    }
}
