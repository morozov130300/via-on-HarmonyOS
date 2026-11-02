package kc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public t f8281a = null;

    /* renamed from: b, reason: collision with root package name */
    public t f8282b = null;

    /* renamed from: c, reason: collision with root package name */
    public t f8283c = null;

    /* renamed from: d, reason: collision with root package name */
    public t f8284d = null;

    /* renamed from: e, reason: collision with root package name */
    public t f8285e = null;

    public abstract void a(a0 a0Var);

    public void b(t tVar) {
        tVar.l();
        tVar.j(this);
        t tVar2 = this.f8283c;
        if (tVar2 == null) {
            this.f8282b = tVar;
            this.f8283c = tVar;
        } else {
            tVar2.f8285e = tVar;
            tVar.f8284d = tVar2;
            this.f8283c = tVar;
        }
    }

    public t c() {
        return this.f8282b;
    }

    public t d() {
        return this.f8283c;
    }

    public t e() {
        return this.f8285e;
    }

    public t f() {
        return this.f8281a;
    }

    public t g() {
        return this.f8284d;
    }

    public void h(t tVar) {
        tVar.l();
        t tVar2 = this.f8285e;
        tVar.f8285e = tVar2;
        if (tVar2 != null) {
            tVar2.f8284d = tVar;
        }
        tVar.f8284d = this;
        this.f8285e = tVar;
        t tVar3 = this.f8281a;
        tVar.f8281a = tVar3;
        if (tVar.f8285e == null) {
            tVar3.f8283c = tVar;
        }
    }

    public void i(t tVar) {
        tVar.l();
        t tVar2 = this.f8284d;
        tVar.f8284d = tVar2;
        if (tVar2 != null) {
            tVar2.f8285e = tVar;
        }
        tVar.f8285e = this;
        this.f8284d = tVar;
        t tVar3 = this.f8281a;
        tVar.f8281a = tVar3;
        if (tVar.f8284d == null) {
            tVar3.f8282b = tVar;
        }
    }

    public void j(t tVar) {
        this.f8281a = tVar;
    }

    public String k() {
        return "";
    }

    public void l() {
        t tVar = this.f8284d;
        if (tVar != null) {
            tVar.f8285e = this.f8285e;
        } else {
            t tVar2 = this.f8281a;
            if (tVar2 != null) {
                tVar2.f8282b = this.f8285e;
            }
        }
        t tVar3 = this.f8285e;
        if (tVar3 != null) {
            tVar3.f8284d = tVar;
        } else {
            t tVar4 = this.f8281a;
            if (tVar4 != null) {
                tVar4.f8283c = tVar;
            }
        }
        this.f8281a = null;
        this.f8285e = null;
        this.f8284d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + k() + "}";
    }
}
