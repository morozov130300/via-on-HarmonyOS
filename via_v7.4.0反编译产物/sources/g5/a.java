package g5;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public long f6190a;

    /* renamed from: b, reason: collision with root package name */
    public long f6191b;

    /* renamed from: c, reason: collision with root package name */
    public long f6192c;

    /* renamed from: d, reason: collision with root package name */
    public long f6193d;

    /* renamed from: e, reason: collision with root package name */
    public long f6194e;

    /* renamed from: f, reason: collision with root package name */
    public long f6195f;

    public long a() {
        return this.f6192c + this.f6194e;
    }

    public long b() {
        return this.f6194e;
    }

    public long c() {
        return (this.f6192c + this.f6193d) - 1;
    }

    public long d() {
        return this.f6190a;
    }

    public long e() {
        return this.f6193d;
    }

    public long f() {
        return this.f6192c;
    }

    public long g() {
        return this.f6195f;
    }

    public long h() {
        return this.f6191b;
    }

    public void i(long j10) {
        this.f6194e = j10;
    }

    public void j(long j10) {
        this.f6190a = j10;
    }

    public void k(long j10) {
        this.f6193d = j10;
    }

    public void l(long j10) {
        this.f6192c = j10;
    }

    public void m(long j10) {
        this.f6195f = j10;
    }

    public void n(long j10) {
        this.f6191b = j10;
    }

    public String toString() {
        return "Chunk{id=" + this.f6190a + ", taskId=" + this.f6191b + ", offset=" + this.f6192c + ", length=" + this.f6193d + ", begin=" + a() + ", end=" + c() + ", downloaded=" + this.f6194e + '}';
    }
}
