package okio;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f11472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f11477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f11478g;

    public n() {
        this.f11472a = new byte[8192];
        this.f11476e = true;
        this.f11475d = false;
    }

    public final void a() {
        n nVar = this.f11478g;
        if (nVar == this) {
            throw new IllegalStateException();
        }
        if (nVar.f11476e) {
            int i10 = this.f11474c - this.f11473b;
            if (i10 > (8192 - nVar.f11474c) + (nVar.f11475d ? 0 : nVar.f11473b)) {
                return;
            }
            f(nVar, i10);
            b();
            o.a(this);
        }
    }

    public final n b() {
        n nVar = this.f11477f;
        n nVar2 = nVar != this ? nVar : null;
        n nVar3 = this.f11478g;
        nVar3.f11477f = nVar;
        this.f11477f.f11478g = nVar3;
        this.f11477f = null;
        this.f11478g = null;
        return nVar2;
    }

    public final n c(n nVar) {
        nVar.f11478g = this;
        nVar.f11477f = this.f11477f;
        this.f11477f.f11478g = nVar;
        this.f11477f = nVar;
        return nVar;
    }

    public final n d() {
        this.f11475d = true;
        return new n(this.f11472a, this.f11473b, this.f11474c, true, false);
    }

    public final n e(int i10) {
        n nVarB;
        if (i10 <= 0 || i10 > this.f11474c - this.f11473b) {
            throw new IllegalArgumentException();
        }
        if (i10 >= 1024) {
            nVarB = d();
        } else {
            nVarB = o.b();
            System.arraycopy(this.f11472a, this.f11473b, nVarB.f11472a, 0, i10);
        }
        nVarB.f11474c = nVarB.f11473b + i10;
        this.f11473b += i10;
        this.f11478g.c(nVarB);
        return nVarB;
    }

    public final void f(n nVar, int i10) {
        if (!nVar.f11476e) {
            throw new IllegalArgumentException();
        }
        int i11 = nVar.f11474c;
        if (i11 + i10 > 8192) {
            if (nVar.f11475d) {
                throw new IllegalArgumentException();
            }
            int i12 = nVar.f11473b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = nVar.f11472a;
            System.arraycopy(bArr, i12, bArr, 0, i11 - i12);
            nVar.f11474c -= nVar.f11473b;
            nVar.f11473b = 0;
        }
        System.arraycopy(this.f11472a, this.f11473b, nVar.f11472a, nVar.f11474c, i10);
        nVar.f11474c += i10;
        this.f11473b += i10;
    }

    public n(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        this.f11472a = bArr;
        this.f11473b = i10;
        this.f11474c = i11;
        this.f11475d = z10;
        this.f11476e = z11;
    }
}
