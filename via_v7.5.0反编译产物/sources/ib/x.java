package ib;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class x extends v5.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6413k;

    public x(int i10, String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15) {
        super(i10, str, str2);
        this.f6408f = str3;
        this.f6411i = i11;
        this.f6409g = i12;
        this.f6410h = i13;
        this.f6412j = i14;
        this.f6413k = i15;
    }

    public int i() {
        return this.f6413k;
    }

    public String j() {
        return d();
    }

    public int k() {
        return this.f6409g;
    }

    public String l() {
        return this.f6408f;
    }

    public int m() {
        return (this.f6410h - this.f6409g) / this.f6412j;
    }

    public int n() {
        return (this.f6411i - this.f6409g) / this.f6412j;
    }

    public int o() {
        return this.f6412j;
    }
}
