package okio;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f10859a;

    /* renamed from: b, reason: collision with root package name */
    public int f10860b;

    /* renamed from: c, reason: collision with root package name */
    public int f10861c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10862d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10863e;

    /* renamed from: f, reason: collision with root package name */
    public n f10864f;

    /* renamed from: g, reason: collision with root package name */
    public n f10865g;

    public n() {
        this.f10859a = new byte[8192];
        this.f10863e = true;
        this.f10862d = false;
    }

    public n(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        this.f10859a = bArr;
        this.f10860b = i10;
        this.f10861c = i11;
        this.f10862d = z10;
        this.f10863e = z11;
    }

    public final void a() {
        n nVar = this.f10865g;
        if (nVar == this) {
            throw new IllegalStateException();
        }
        if (nVar.f10863e) {
            int i10 = this.f10861c - this.f10860b;
            if (i10 > (8192 - nVar.f10861c) + (nVar.f10862d ? 0 : nVar.f10860b)) {
                return;
            }
            f(nVar, i10);
            b();
            o.a(this);
        }
    }

    public final n b() {
        n nVar = this.f10864f;
        n nVar2 = nVar != this ? nVar : null;
        n nVar3 = this.f10865g;
        nVar3.f10864f = nVar;
        this.f10864f.f10865g = nVar3;
        this.f10864f = null;
        this.f10865g = null;
        return nVar2;
    }

    public final n c(n nVar) {
        nVar.f10865g = this;
        nVar.f10864f = this.f10864f;
        this.f10864f.f10865g = nVar;
        this.f10864f = nVar;
        return nVar;
    }

    public final n d() {
        this.f10862d = true;
        return new n(this.f10859a, this.f10860b, this.f10861c, true, false);
    }

    public final n e(int i10) {
        n nVarB;
        if (i10 <= 0 || i10 > this.f10861c - this.f10860b) {
            throw new IllegalArgumentException();
        }
        if (i10 >= 1024) {
            nVarB = d();
        } else {
            nVarB = o.b();
            System.arraycopy(this.f10859a, this.f10860b, nVarB.f10859a, 0, i10);
        }
        nVarB.f10861c = nVarB.f10860b + i10;
        this.f10860b += i10;
        this.f10865g.c(nVarB);
        return nVarB;
    }

    public final void f(n nVar, int i10) {
        if (!nVar.f10863e) {
            throw new IllegalArgumentException();
        }
        int i11 = nVar.f10861c;
        if (i11 + i10 > 8192) {
            if (nVar.f10862d) {
                throw new IllegalArgumentException();
            }
            int i12 = nVar.f10860b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = nVar.f10859a;
            System.arraycopy(bArr, i12, bArr, 0, i11 - i12);
            nVar.f10861c -= nVar.f10860b;
            nVar.f10860b = 0;
        }
        System.arraycopy(this.f10859a, this.f10860b, nVar.f10859a, nVar.f10861c, i10);
        nVar.f10861c += i10;
        this.f10860b += i10;
    }
}
