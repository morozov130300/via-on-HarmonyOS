package z3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15167d;

    public n(int i10, String str) {
        super(i10);
        this.f15165b = str;
        this.f15167d = false;
        this.f15166c = 0;
    }

    public String b() {
        return this.f15165b;
    }

    public int c() {
        return this.f15166c;
    }

    public boolean d() {
        return this.f15167d;
    }

    public n(int i10, String str, int i11) {
        super(i10);
        this.f15167d = true;
        this.f15166c = i11;
        this.f15165b = str;
    }
}
