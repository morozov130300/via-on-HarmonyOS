package oc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p extends t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11123g;

    public p(String str, String str2) {
        this.f11122f = str;
        this.f11123g = str2;
    }

    @Override // oc.t
    public void a(a0 a0Var) {
        a0Var.D(this);
    }

    @Override // oc.t
    public String k() {
        return "destination=" + this.f11122f + ", title=" + this.f11123g;
    }

    public String m() {
        return this.f11122f;
    }
}
