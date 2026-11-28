package oc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f11128a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f11129b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f11130c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f11131d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f11132e = null;

    public abstract void a(a0 a0Var);

    public void b(t tVar) {
        tVar.l();
        tVar.j(this);
        t tVar2 = this.f11130c;
        if (tVar2 == null) {
            this.f11129b = tVar;
            this.f11130c = tVar;
        } else {
            tVar2.f11132e = tVar;
            tVar.f11131d = tVar2;
            this.f11130c = tVar;
        }
    }

    public t c() {
        return this.f11129b;
    }

    public t d() {
        return this.f11130c;
    }

    public t e() {
        return this.f11132e;
    }

    public t f() {
        return this.f11128a;
    }

    public t g() {
        return this.f11131d;
    }

    public void h(t tVar) {
        tVar.l();
        t tVar2 = this.f11132e;
        tVar.f11132e = tVar2;
        if (tVar2 != null) {
            tVar2.f11131d = tVar;
        }
        tVar.f11131d = this;
        this.f11132e = tVar;
        t tVar3 = this.f11128a;
        tVar.f11128a = tVar3;
        if (tVar.f11132e == null) {
            tVar3.f11130c = tVar;
        }
    }

    public void i(t tVar) {
        tVar.l();
        t tVar2 = this.f11131d;
        tVar.f11131d = tVar2;
        if (tVar2 != null) {
            tVar2.f11132e = tVar;
        }
        tVar.f11132e = this;
        this.f11131d = tVar;
        t tVar3 = this.f11128a;
        tVar.f11128a = tVar3;
        if (tVar.f11131d == null) {
            tVar3.f11129b = tVar;
        }
    }

    public void j(t tVar) {
        this.f11128a = tVar;
    }

    public String k() {
        return "";
    }

    public void l() {
        t tVar = this.f11131d;
        if (tVar != null) {
            tVar.f11132e = this.f11132e;
        } else {
            t tVar2 = this.f11128a;
            if (tVar2 != null) {
                tVar2.f11129b = this.f11132e;
            }
        }
        t tVar3 = this.f11132e;
        if (tVar3 != null) {
            tVar3.f11131d = tVar;
        } else {
            t tVar4 = this.f11128a;
            if (tVar4 != null) {
                tVar4.f11130c = tVar;
            }
        }
        this.f11128a = null;
        this.f11132e = null;
        this.f11131d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + k() + "}";
    }
}
