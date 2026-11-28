package a9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f285c;

    public z() {
    }

    @Override // a9.a
    public String a() {
        return this.f284b;
    }

    public String b() {
        return this.f285c;
    }

    public String c() {
        return this.f284b;
    }

    public void d(String str) {
        this.f285c = str;
    }

    public void e(String str) {
        this.f283a = str;
    }

    public void f(String str) {
        this.f284b = str;
    }

    @Override // a9.a
    public String getTitle() {
        return this.f283a;
    }

    public z(String str, String str2, String str3) {
        this.f283a = str2;
        this.f284b = str;
        this.f285c = str3;
    }
}
