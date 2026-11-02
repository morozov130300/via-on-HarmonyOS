package ka;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f8233a;

    /* renamed from: b, reason: collision with root package name */
    public String f8234b;

    /* renamed from: c, reason: collision with root package name */
    public String f8235c;

    /* renamed from: d, reason: collision with root package name */
    public int f8236d;

    /* renamed from: e, reason: collision with root package name */
    public String f8237e;

    public a(int i10, String str, String str2, int i11) {
        this.f8233a = i10;
        this.f8234b = str;
        this.f8235c = str2;
        this.f8236d = i11;
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
        return this.f8233a;
    }

    public String b() {
        String str = this.f8237e;
        if (str != null) {
            return str;
        }
        String str2 = this.f8235c;
        return (str2 == null || str2.isEmpty()) ? this.f8234b : this.f8235c;
    }

    public String c() {
        return this.f8234b;
    }

    public int d() {
        return this.f8236d;
    }

    public String e() {
        return this.f8235c;
    }

    public void h(String str) {
        this.f8237e = str;
    }

    public String toString() {
        return "SearchSuggestion{title='" + this.f8234b + "', url='" + this.f8235c + "', type=" + this.f8236d + '}';
    }
}
