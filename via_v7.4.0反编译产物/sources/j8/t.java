package j8;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public final String f7622a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7623b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7624c;

    /* renamed from: d, reason: collision with root package name */
    public final List f7625d;

    /* renamed from: e, reason: collision with root package name */
    public int f7626e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7627f = false;

    public t(String str, String str2, String str3, List list, int i10) {
        this.f7622a = str;
        this.f7623b = str2;
        this.f7624c = str3;
        this.f7625d = list;
        this.f7626e = i10;
    }

    public int a() {
        return this.f7626e;
    }

    public String b() {
        return this.f7622a;
    }

    public String c(int i10) {
        List list = this.f7625d;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return (String) this.f7625d.get(i10);
    }

    public List d() {
        return this.f7625d;
    }

    public String e() {
        return this.f7624c;
    }

    public String f() {
        return this.f7623b;
    }

    public boolean g() {
        int i10;
        List list = this.f7625d;
        return list == null || (i10 = this.f7626e) < 0 || i10 >= list.size();
    }

    public boolean h() {
        return this.f7627f;
    }

    public void i(int i10) {
        this.f7626e = i10;
    }

    public void j(boolean z10) {
        this.f7627f = z10;
    }

    public String toString() {
        return "ReadAloudTask{id='" + this.f7622a + "', url='" + this.f7623b + "', title='" + this.f7624c + "', sentences=" + this.f7625d.size() + ", currentIndex=" + this.f7626e + ", isPlaying=" + this.f7627f + '}';
    }
}
