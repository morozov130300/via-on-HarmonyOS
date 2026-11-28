package tb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12663d;

    public d(String str, int i10, int i11, String str2) {
        this.f12660a = str;
        this.f12661b = i10;
        this.f12662c = i11;
        this.f12663d = str2;
    }

    public static d a(String str, String str2) {
        return new d(str, 0, 2, str2);
    }

    public static d b(String str, int i10) {
        return new d(str, i10, 1, str);
    }

    public static d h(String str) {
        return new d(str, 0, 0, str);
    }

    public int c() {
        return this.f12661b;
    }

    public int d() {
        return this.f12662c;
    }

    public String e() {
        return this.f12660a;
    }

    public String f() {
        return this.f12663d;
    }

    public boolean g() {
        return this.f12662c == 1;
    }
}
