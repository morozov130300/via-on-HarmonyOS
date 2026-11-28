package i2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6195c;

    public a(long j10, long j11, long j12) {
        this.f6193a = j10;
        this.f6194b = j11;
        this.f6195c = j12;
    }

    @Override // i2.l
    public long b() {
        return this.f6194b;
    }

    @Override // i2.l
    public long c() {
        return this.f6193a;
    }

    @Override // i2.l
    public long d() {
        return this.f6195c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f6193a == lVar.c() && this.f6194b == lVar.b() && this.f6195c == lVar.d()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f6193a;
        long j11 = this.f6194b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f6195c;
        return ((int) (j12 ^ (j12 >>> 32))) ^ i10;
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f6193a + ", elapsedRealtime=" + this.f6194b + ", uptimeMillis=" + this.f6195c + "}";
    }
}
