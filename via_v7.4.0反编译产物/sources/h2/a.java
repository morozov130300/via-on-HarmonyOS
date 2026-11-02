package h2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: a, reason: collision with root package name */
    public final long f6324a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6325b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6326c;

    public a(long j10, long j11, long j12) {
        this.f6324a = j10;
        this.f6325b = j11;
        this.f6326c = j12;
    }

    @Override // h2.l
    public long b() {
        return this.f6325b;
    }

    @Override // h2.l
    public long c() {
        return this.f6324a;
    }

    @Override // h2.l
    public long d() {
        return this.f6326c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f6324a == lVar.c() && this.f6325b == lVar.b() && this.f6326c == lVar.d()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f6324a;
        long j11 = this.f6325b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f6326c;
        return ((int) (j12 ^ (j12 >>> 32))) ^ i10;
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f6324a + ", elapsedRealtime=" + this.f6325b + ", uptimeMillis=" + this.f6326c + "}";
    }
}
