package jb;

import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f0 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7692f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7693g;

    /* renamed from: h, reason: collision with root package name */
    public kb.d f7694h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7695i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7696j = new androidx.lifecycle.l(null);

    public f0(ca.d dVar, w9.l lVar) {
        this.f7692f = dVar;
        this.f7693g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7694h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        ba.a aVarI = this.f7692f.i(strA);
        aVarI.S(true);
        aVarI.O(i10);
        this.f7692f.g(strA, aVarI);
        this.f7696j.m(this.f7694h);
    }

    public int m(String str) {
        kb.d dVar = this.f7694h;
        return dVar == null ? o() : dVar.d(str, o());
    }

    public androidx.lifecycle.l n() {
        return this.f7695i;
    }

    public int o() {
        if (this.f7695i.e() != null) {
            return ((Integer) this.f7695i.e()).intValue();
        }
        u();
        return ((Integer) this.f7695i.e()).intValue();
    }

    public kb.d p() {
        return this.f7694h;
    }

    public androidx.lifecycle.l q() {
        return this.f7696j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f7692f.j()) {
            ba.b bVarE = this.f7692f.e(str);
            int iB = bVarE == null ? 0 : bVarE.b();
            if (bVarE != null && bVarE.s() && iB != 0) {
                if (iB == 3) {
                    arrayList3.add(str);
                } else if (iB == 2) {
                    arrayList2.add(str);
                } else {
                    arrayList.add(str);
                }
            }
        }
        kb.d dVar = new kb.d();
        this.f7694h = dVar;
        dVar.b(arrayList, 1);
        this.f7694h.b(arrayList2, 2);
        this.f7694h.b(arrayList3, 3);
        this.f7696j.m(this.f7694h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7694h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f7696j.m(this.f7694h);
        ba.a aVarI = this.f7692f.i(strA);
        aVarI.O(0);
        if (aVarI.r()) {
            this.f7692f.b(strA);
        } else {
            this.f7692f.g(strA, aVarI);
        }
    }

    public void t(int i10) {
        w9.p pVarM2 = this.f7693g.m2();
        pVarM2.L(i10);
        this.f7693g.g0(pVarM2);
        u();
    }

    public final void u() {
        this.f7695i.m(Integer.valueOf(this.f7693g.m2().e()));
    }
}
