package m5;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f8659a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.a f8660b;

    /* renamed from: c, reason: collision with root package name */
    public final h f8661c;

    public g(g5.a aVar, int i10) {
        this(aVar, i10, null);
    }

    public g(g5.a aVar, int i10, h hVar) {
        this.f8660b = aVar;
        this.f8659a = i10;
        this.f8661c = hVar;
    }

    public static g d(g5.a aVar, h hVar) {
        return new g(aVar, 2, hVar);
    }

    public static g e(g5.a aVar) {
        return new g(aVar, 1);
    }

    public g5.a a() {
        return this.f8660b;
    }

    public h b() {
        return this.f8661c;
    }

    public boolean c() {
        return this.f8659a == 2;
    }

    public String toString() {
        return "DownloadChunkResult{code=" + this.f8659a + ", error=" + this.f8661c + '}';
    }
}
