package c9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z implements a {

    /* renamed from: a, reason: collision with root package name */
    public String f3054a;

    /* renamed from: b, reason: collision with root package name */
    public String f3055b;

    /* renamed from: c, reason: collision with root package name */
    public String f3056c;

    public z() {
    }

    public z(String str, String str2, String str3) {
        this.f3054a = str2;
        this.f3055b = str;
        this.f3056c = str3;
    }

    @Override // c9.a
    public String a() {
        return this.f3055b;
    }

    public String b() {
        return this.f3056c;
    }

    public String c() {
        return this.f3055b;
    }

    public void d(String str) {
        this.f3056c = str;
    }

    public void e(String str) {
        this.f3054a = str;
    }

    public void f(String str) {
        this.f3055b = str;
    }

    @Override // c9.a
    public String getTitle() {
        return this.f3054a;
    }
}
