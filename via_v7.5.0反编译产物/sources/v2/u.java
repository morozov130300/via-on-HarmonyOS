package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u extends b0.e.d.AbstractC0147d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13306a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.AbstractC0147d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13307a;

        @Override // v2.b0.e.d.AbstractC0147d.a
        public b0.e.d.AbstractC0147d a() {
            String str = "";
            if (this.f13307a == null) {
                str = " content";
            }
            if (str.isEmpty()) {
                return new u(this.f13307a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.AbstractC0147d.a
        public b0.e.d.AbstractC0147d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f13307a = str;
            return this;
        }
    }

    @Override // v2.b0.e.d.AbstractC0147d
    public String b() {
        return this.f13306a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.AbstractC0147d) {
            return this.f13306a.equals(((b0.e.d.AbstractC0147d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f13306a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f13306a + "}";
    }

    public u(String str) {
        this.f13306a = str;
    }
}
