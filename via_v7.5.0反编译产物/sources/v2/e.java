package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e extends b0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13161b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13163b;

        @Override // v2.b0.c.a
        public b0.c a() {
            String str = "";
            if (this.f13162a == null) {
                str = " key";
            }
            if (this.f13163b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new e(this.f13162a, this.f13163b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.c.a
        public b0.c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f13162a = str;
            return this;
        }

        @Override // v2.b0.c.a
        public b0.c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f13163b = str;
            return this;
        }
    }

    @Override // v2.b0.c
    public String b() {
        return this.f13160a;
    }

    @Override // v2.b0.c
    public String c() {
        return this.f13161b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.c) {
            b0.c cVar = (b0.c) obj;
            if (this.f13160a.equals(cVar.b()) && this.f13161b.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f13160a.hashCode() ^ 1000003) * 1000003) ^ this.f13161b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f13160a + ", value=" + this.f13161b + "}";
    }

    public e(String str, String str2) {
        this.f13160a = str;
        this.f13161b = str2;
    }
}
