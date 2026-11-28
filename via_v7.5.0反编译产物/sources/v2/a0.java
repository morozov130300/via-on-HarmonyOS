package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends d0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13115c;

    public a0(String str, String str2, boolean z10) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f13113a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f13114b = str2;
        this.f13115c = z10;
    }

    @Override // v2.d0.c
    public boolean b() {
        return this.f13115c;
    }

    @Override // v2.d0.c
    public String c() {
        return this.f13114b;
    }

    @Override // v2.d0.c
    public String d() {
        return this.f13113a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0.c) {
            d0.c cVar = (d0.c) obj;
            if (this.f13113a.equals(cVar.d()) && this.f13114b.equals(cVar.c()) && this.f13115c == cVar.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f13113a.hashCode() ^ 1000003) * 1000003) ^ this.f13114b.hashCode()) * 1000003) ^ (this.f13115c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f13113a + ", osCodeName=" + this.f13114b + ", isRooted=" + this.f13115c + "}";
    }
}
