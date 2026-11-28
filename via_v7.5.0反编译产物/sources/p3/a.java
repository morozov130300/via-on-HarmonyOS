package p3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11565b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f11564a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f11565b = str2;
    }

    @Override // p3.f
    public String b() {
        return this.f11564a;
    }

    @Override // p3.f
    public String c() {
        return this.f11565b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f11564a.equals(fVar.b()) && this.f11565b.equals(fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f11564a.hashCode() ^ 1000003) * 1000003) ^ this.f11565b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f11564a + ", version=" + this.f11565b + "}";
    }
}
