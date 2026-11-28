package lc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends qc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qc.d[] f7652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7653b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7654c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7655d = false;

    public d(qc.d... dVarArr) {
        this.f7652a = dVarArr;
    }

    @Override // qc.f
    public qc.f a(int i10) {
        this.f7654c = i10;
        return this;
    }

    @Override // qc.f
    public qc.f b(int i10) {
        this.f7653b = i10;
        return this;
    }

    @Override // qc.f
    public qc.f e() {
        this.f7655d = true;
        return this;
    }

    public qc.d[] f() {
        return this.f7652a;
    }

    public int g() {
        return this.f7654c;
    }

    public int h() {
        return this.f7653b;
    }

    public boolean i() {
        return this.f7655d;
    }
}
