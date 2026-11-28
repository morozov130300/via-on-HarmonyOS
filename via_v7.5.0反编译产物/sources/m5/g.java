package m5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g5.a f7918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f7919c;

    public g(g5.a aVar, int i10) {
        this(aVar, i10, null);
    }

    public static g d(g5.a aVar, h hVar) {
        return new g(aVar, 2, hVar);
    }

    public static g e(g5.a aVar) {
        return new g(aVar, 1);
    }

    public g5.a a() {
        return this.f7918b;
    }

    public h b() {
        return this.f7919c;
    }

    public boolean c() {
        return this.f7917a == 2;
    }

    public String toString() {
        return "DownloadChunkResult{code=" + this.f7917a + ", error=" + this.f7919c + '}';
    }

    public g(g5.a aVar, int i10, h hVar) {
        this.f7918b = aVar;
        this.f7917a = i10;
        this.f7919c = hVar;
    }
}
