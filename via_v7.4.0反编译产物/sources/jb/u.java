package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7871f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7872g;

    /* renamed from: h, reason: collision with root package name */
    public kb.d f7873h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7874i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7875j = new androidx.lifecycle.l();

    public u(ca.d dVar, w9.l lVar) {
        this.f7871f = dVar;
        this.f7872g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7873h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        ba.a aVarI = this.f7871f.i(strA);
        aVarI.S(true);
        aVarI.N(i10);
        this.f7871f.g(strA, aVarI);
        this.f7875j.m(this.f7873h);
    }

    public int m(String str) {
        return str == null ? n() : this.f7873h.d(str, n());
    }

    public int n() {
        if (this.f7874i.e() != null) {
            return ((Integer) this.f7874i.e()).intValue();
        }
        u();
        return ((Integer) this.f7874i.e()).intValue();
    }

    public LiveData o() {
        return this.f7874i;
    }

    public kb.d p() {
        return this.f7873h;
    }

    public androidx.lifecycle.l q() {
        return this.f7875j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f7871f.j()) {
            ba.b bVarE = this.f7871f.e(str);
            int iA = bVarE == null ? 0 : bVarE.a();
            if (bVarE != null && bVarE.s() && iA != 0) {
                if (iA == 3) {
                    arrayList3.add(str);
                } else if (iA == 2) {
                    arrayList2.add(str);
                } else {
                    arrayList.add(str);
                }
            }
        }
        kb.d dVar = new kb.d();
        this.f7873h = dVar;
        dVar.b(arrayList, 1);
        this.f7873h.b(arrayList2, 2);
        this.f7873h.b(arrayList3, 3);
        this.f7875j.m(this.f7873h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7873h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f7875j.m(this.f7873h);
        ba.a aVarI = this.f7871f.i(strA);
        aVarI.O(0);
        if (aVarI.r()) {
            this.f7871f.b(strA);
        } else {
            this.f7871f.g(strA, aVarI);
        }
    }

    public void t(int i10) {
        w9.p pVarM2 = this.f7872g.m2();
        pVarM2.K(i10 == 3);
        this.f7872g.g0(pVarM2);
        u();
    }

    public final void u() {
        this.f7874i.m(Integer.valueOf(this.f7872g.m2().i() ? 3 : 2));
    }
}
