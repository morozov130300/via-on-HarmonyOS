package ha;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5763e;

    public a(int i10, String str, String str2, int i11) {
        this.f5759a = i10;
        this.f5760b = str;
        this.f5761c = str2;
        this.f5762d = i11;
    }

    public static a f(String str, String str2, int i10) {
        return new a(0, str2, str, i10);
    }

    public static a g(String str) {
        return new a(0, str, null, 16);
    }

    public static a i(int i10, String str, String str2) {
        return new a(i10, str2, str, 4);
    }

    public int a() {
        return this.f5759a;
    }

    public String b() {
        String str = this.f5763e;
        if (str != null) {
            return str;
        }
        String str2 = this.f5761c;
        return (str2 == null || str2.isEmpty()) ? this.f5760b : this.f5761c;
    }

    public String c() {
        return this.f5760b;
    }

    public int d() {
        return this.f5762d;
    }

    public String e() {
        return this.f5761c;
    }

    public void h(String str) {
        this.f5763e = str;
    }

    public String toString() {
        return "SearchSuggestion{title='" + this.f5760b + "', url='" + this.f5761c + "', type=" + this.f5762d + '}';
    }
}
