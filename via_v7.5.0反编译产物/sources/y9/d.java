package y9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f15049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15051c;

    public d(b bVar) {
        this(bVar, 0L, 0);
    }

    public int a() {
        return this.f15051c;
    }

    public b b() {
        return this.f15049a;
    }

    public boolean c() {
        return this.f15050b > 0 && System.currentTimeMillis() > this.f15050b;
    }

    public d(b bVar, long j10, int i10) {
        this.f15049a = bVar;
        this.f15050b = j10;
        this.f15051c = i10;
    }
}
