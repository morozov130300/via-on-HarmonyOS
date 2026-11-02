package c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f extends j {

    /* renamed from: a, reason: collision with root package name */
    public final long f2271a;

    public f(long j10) {
        this.f2271a = j10;
    }

    @Override // c1.j
    public long c() {
        return this.f2271a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof j) && this.f2271a == ((j) obj).c();
    }

    public int hashCode() {
        long j10 = this.f2271a;
        return 1000003 ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f2271a + "}";
    }
}
