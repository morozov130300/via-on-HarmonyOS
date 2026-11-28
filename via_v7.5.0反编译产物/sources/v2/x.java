package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0.a f13318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.c f13319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0.b f13320c;

    public x(d0.a aVar, d0.c cVar, d0.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.f13318a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f13319b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f13320c = bVar;
    }

    @Override // v2.d0
    public d0.a a() {
        return this.f13318a;
    }

    @Override // v2.d0
    public d0.b c() {
        return this.f13320c;
    }

    @Override // v2.d0
    public d0.c d() {
        return this.f13319b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            if (this.f13318a.equals(d0Var.a()) && this.f13319b.equals(d0Var.d()) && this.f13320c.equals(d0Var.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f13318a.hashCode() ^ 1000003) * 1000003) ^ this.f13319b.hashCode()) * 1000003) ^ this.f13320c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f13318a + ", osData=" + this.f13319b + ", deviceData=" + this.f13320c + "}";
    }
}
