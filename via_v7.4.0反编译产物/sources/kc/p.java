package kc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p extends t {

    /* renamed from: f, reason: collision with root package name */
    public String f8275f;

    /* renamed from: g, reason: collision with root package name */
    public String f8276g;

    public p(String str, String str2) {
        this.f8275f = str;
        this.f8276g = str2;
    }

    @Override // kc.t
    public void a(a0 a0Var) {
        a0Var.o(this);
    }

    @Override // kc.t
    public String k() {
        return "destination=" + this.f8275f + ", title=" + this.f8276g;
    }

    public String m() {
        return this.f8275f;
    }
}
