package m5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f7935b;

    public j(int i10) {
        this(i10, null);
    }

    public static j c(h hVar) {
        return new j(2, hVar);
    }

    public static j d() {
        return new j(1);
    }

    public h a() {
        return this.f7935b;
    }

    public boolean b() {
        return this.f7934a == 1;
    }

    public String toString() {
        return "DownloadResult{code=" + this.f7934a + ", error=" + this.f7935b + '}';
    }

    public j(int i10, h hVar) {
        this.f7934a = i10;
        this.f7935b = hVar;
    }
}
