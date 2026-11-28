package oc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11120g;

    public n(String str, String str2) {
        this.f11119f = str;
        this.f11120g = str2;
    }

    @Override // oc.t
    public void a(a0 a0Var) {
        a0Var.k(this);
    }

    @Override // oc.t
    public String k() {
        return "destination=" + this.f11119f + ", title=" + this.f11120g;
    }

    public String m() {
        return this.f11119f;
    }
}
