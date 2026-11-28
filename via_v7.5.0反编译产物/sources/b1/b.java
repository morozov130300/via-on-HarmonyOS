package b1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1715a;

    public b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f1715a = str;
    }

    public static b b(String str) {
        return new b(str);
    }

    public String a() {
        return this.f1715a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f1715a.equals(((b) obj).f1715a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1715a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f1715a + "\"}";
    }
}
