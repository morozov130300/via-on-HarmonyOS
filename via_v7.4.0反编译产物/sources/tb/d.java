package tb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f12361a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12362b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12363c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12364d;

    public d(String str, int i10, int i11, String str2) {
        this.f12361a = str;
        this.f12362b = i10;
        this.f12363c = i11;
        this.f12364d = str2;
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
        return this.f12362b;
    }

    public int d() {
        return this.f12363c;
    }

    public String e() {
        return this.f12361a;
    }

    public String f() {
        return this.f12364d;
    }

    public boolean g() {
        return this.f12363c == 1;
    }
}
