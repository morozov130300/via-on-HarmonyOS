package r9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f11590a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11591b;

    /* renamed from: c, reason: collision with root package name */
    public String f11592c;

    /* renamed from: d, reason: collision with root package name */
    public String f11593d;

    public c(String str) {
        this(str, false);
    }

    public c(String str, boolean z10) {
        this(str, z10, null, null);
    }

    public c(String str, boolean z10, String str2, String str3) {
        this.f11590a = str;
        this.f11591b = z10;
        this.f11592c = str2;
        this.f11593d = str3;
    }

    public String a() {
        return this.f11590a;
    }

    public String b() {
        return this.f11593d;
    }

    public String c() {
        return this.f11592c;
    }

    public boolean d() {
        return this.f11591b;
    }

    public void e(boolean z10) {
        this.f11591b = z10;
    }

    public void f(String str) {
        this.f11593d = str;
    }

    public void g(String str) {
        this.f11592c = str;
    }

    public String toString() {
        return "FeatureToggle{name='" + this.f11590a + "', enabled=" + this.f11591b + ", variant='" + this.f11592c + "', payload='" + this.f11593d + "'}";
    }
}
