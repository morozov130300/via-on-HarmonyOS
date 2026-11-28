package m1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1.p f7799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e1.i f7800c;

    public b(long j10, e1.p pVar, e1.i iVar) {
        this.f7798a = j10;
        if (pVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f7799b = pVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f7800c = iVar;
    }

    @Override // m1.k
    public e1.i b() {
        return this.f7800c;
    }

    @Override // m1.k
    public long c() {
        return this.f7798a;
    }

    @Override // m1.k
    public e1.p d() {
        return this.f7799b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f7798a == kVar.c() && this.f7799b.equals(kVar.d()) && this.f7800c.equals(kVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f7798a;
        return this.f7800c.hashCode() ^ ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f7799b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f7798a + ", transportContext=" + this.f7799b + ", event=" + this.f7800c + "}";
    }
}
