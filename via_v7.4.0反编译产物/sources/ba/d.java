package ba;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public b f2105a;

    /* renamed from: b, reason: collision with root package name */
    public long f2106b;

    /* renamed from: c, reason: collision with root package name */
    public int f2107c;

    public d(b bVar) {
        this(bVar, 0L, 0);
    }

    public d(b bVar, long j10, int i10) {
        this.f2105a = bVar;
        this.f2106b = j10;
        this.f2107c = i10;
    }

    public int a() {
        return this.f2107c;
    }

    public b b() {
        return this.f2105a;
    }

    public boolean c() {
        return this.f2106b > 0 && System.currentTimeMillis() > this.f2106b;
    }
}
