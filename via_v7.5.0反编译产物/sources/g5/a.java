package g5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5520f;

    public long a() {
        return this.f5517c + this.f5519e;
    }

    public long b() {
        return this.f5519e;
    }

    public long c() {
        return (this.f5517c + this.f5518d) - 1;
    }

    public long d() {
        return this.f5515a;
    }

    public long e() {
        return this.f5518d;
    }

    public long f() {
        return this.f5517c;
    }

    public long g() {
        return this.f5520f;
    }

    public long h() {
        return this.f5516b;
    }

    public void i(long j10) {
        this.f5519e = j10;
    }

    public void j(long j10) {
        this.f5515a = j10;
    }

    public void k(long j10) {
        this.f5518d = j10;
    }

    public void l(long j10) {
        this.f5517c = j10;
    }

    public void m(long j10) {
        this.f5520f = j10;
    }

    public void n(long j10) {
        this.f5516b = j10;
    }

    public String toString() {
        return "Chunk{id=" + this.f5515a + ", taskId=" + this.f5516b + ", offset=" + this.f5517c + ", length=" + this.f5518d + ", begin=" + a() + ", end=" + c() + ", downloaded=" + this.f5519e + '}';
    }
}
