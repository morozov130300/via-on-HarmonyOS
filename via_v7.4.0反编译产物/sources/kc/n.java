package kc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends t {

    /* renamed from: f, reason: collision with root package name */
    public String f8272f;

    /* renamed from: g, reason: collision with root package name */
    public String f8273g;

    public n(String str, String str2) {
        this.f8272f = str;
        this.f8273g = str2;
    }

    @Override // kc.t
    public void a(a0 a0Var) {
        a0Var.l(this);
    }

    @Override // kc.t
    public String k() {
        return "destination=" + this.f8272f + ", title=" + this.f8273g;
    }

    public String m() {
        return this.f8272f;
    }
}
