package d1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3898a;

    public f(long j10) {
        this.f3898a = j10;
    }

    @Override // d1.j
    public long c() {
        return this.f3898a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof j) && this.f3898a == ((j) obj).c();
    }

    public int hashCode() {
        long j10 = this.f3898a;
        return 1000003 ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f3898a + "}";
    }
}
