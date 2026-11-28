package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y extends d0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q2.e f13326f;

    public y(String str, String str2, String str3, String str4, int i10, q2.e eVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f13321a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f13322b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f13323c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f13324d = str4;
        this.f13325e = i10;
        if (eVar == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f13326f = eVar;
    }

    @Override // v2.d0.a
    public String a() {
        return this.f13321a;
    }

    @Override // v2.d0.a
    public int c() {
        return this.f13325e;
    }

    @Override // v2.d0.a
    public q2.e d() {
        return this.f13326f;
    }

    @Override // v2.d0.a
    public String e() {
        return this.f13324d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0.a) {
            d0.a aVar = (d0.a) obj;
            if (this.f13321a.equals(aVar.a()) && this.f13322b.equals(aVar.f()) && this.f13323c.equals(aVar.g()) && this.f13324d.equals(aVar.e()) && this.f13325e == aVar.c() && this.f13326f.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.d0.a
    public String f() {
        return this.f13322b;
    }

    @Override // v2.d0.a
    public String g() {
        return this.f13323c;
    }

    public int hashCode() {
        return ((((((((((this.f13321a.hashCode() ^ 1000003) * 1000003) ^ this.f13322b.hashCode()) * 1000003) ^ this.f13323c.hashCode()) * 1000003) ^ this.f13324d.hashCode()) * 1000003) ^ this.f13325e) * 1000003) ^ this.f13326f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f13321a + ", versionCode=" + this.f13322b + ", versionName=" + this.f13323c + ", installUuid=" + this.f13324d + ", deliveryMechanism=" + this.f13325e + ", developmentPlatformProvider=" + this.f13326f + "}";
    }
}
