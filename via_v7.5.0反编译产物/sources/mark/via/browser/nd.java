package mark.via.browser;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class nd extends com.tuyafeng.support.widget.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final r8 f9380r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final u9.l f9381s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public mark.via.common.widget.p1 f9382t;

    public nd(final r8 r8Var, u9.l lVar, final x.a aVar) {
        super(r8Var.G());
        this.f9380r = r8Var;
        this.f9381s = lVar;
        setDragDistance(com.tuyafeng.support.utils.x.h(getContext(), 84.0f));
        setDragListener(new com.tuyafeng.support.widget.a.b() { // from class: mark.via.browser.md
            @Override // com.tuyafeng.support.widget.a.b
            public final void a(float f10, boolean z10) {
                nd.j(this.f9358a, aVar, r8Var, f10, z10);
            }
        });
    }

    public static /* synthetic */ void j(nd ndVar, x.a aVar, r8 r8Var, float f10, boolean z10) {
        mark.via.common.widget.p1 p1Var;
        ndVar.getClass();
        int iK = ndVar.k(f10 > 0.0f);
        int iM = m(iK);
        if (!z10) {
            if ((f10 == 0.0f || iM == 0) && ((p1Var = ndVar.f9382t) == null || !p1Var.j())) {
                return;
            }
            if (ndVar.f9382t == null) {
                ndVar.f9382t = new mark.via.common.widget.p1(ndVar.getContext());
            }
            if (ndVar.f9382t.l(ndVar, r8Var.c(), r8Var.k(), iM, f10)) {
                ndVar.performHapticFeedback(3);
                return;
            }
            return;
        }
        boolean z11 = Math.abs(f10) > 1.0f;
        if (z11) {
            aVar.accept(Integer.valueOf(iK));
        }
        mark.via.common.widget.p1 p1Var2 = ndVar.f9382t;
        if (p1Var2 == null || !p1Var2.j() || (iM == 0 && z11)) {
            ndVar.l();
        } else {
            ndVar.f9382t.h(ndVar, r8Var.c(), r8Var.k());
        }
    }

    public static int m(int i10) {
        if (i10 == 10) {
            return -1;
        }
        return i10 == 11 ? 1 : 0;
    }

    @Override // com.tuyafeng.support.widget.a
    public boolean g(boolean z10) {
        int i10 = this.f9380r.i();
        if (i10 <= 1) {
            return false;
        }
        int iM = m(k(z10));
        return (iM < 0 && this.f9380r.k() == 0) || (iM > 0 && this.f9380r.k() == i10 - 1);
    }

    public final int k(boolean z10) {
        return z10 ? this.f9381s.h2() : this.f9381s.n1();
    }

    public void l() {
        mark.via.common.widget.p1 p1Var = this.f9382t;
        if (p1Var != null) {
            p1Var.f();
            this.f9382t = null;
        }
    }
}
