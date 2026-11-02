package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k2 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7756f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7757g;

    /* renamed from: h, reason: collision with root package name */
    public kb.d f7758h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7759i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7760j = new androidx.lifecycle.l();

    public k2(ca.d dVar, w9.l lVar) {
        this.f7756f = dVar;
        this.f7757g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7758h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        ba.a aVarI = this.f7756f.i(strA);
        aVarI.S(true);
        aVarI.a0(i10);
        this.f7756f.g(strA, aVarI);
        this.f7760j.m(this.f7758h);
    }

    public int m() {
        if (this.f7759i.e() != null) {
            return ((Integer) this.f7759i.e()).intValue();
        }
        u();
        return ((Integer) this.f7759i.e()).intValue();
    }

    public LiveData n() {
        return this.f7759i;
    }

    public int o(String str) {
        return str == null ? m() : this.f7758h.d(str, m());
    }

    public kb.d p() {
        return this.f7758h;
    }

    public androidx.lifecycle.l q() {
        return this.f7760j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f7756f.j()) {
            ba.b bVarE = this.f7756f.e(str);
            int iF = bVarE == null ? 0 : bVarE.f();
            if (bVarE != null && bVarE.s() && iF != 0) {
                if (iF == 3) {
                    arrayList3.add(str);
                } else if (iF == 2) {
                    arrayList2.add(str);
                } else {
                    arrayList.add(str);
                }
            }
        }
        kb.d dVar = new kb.d();
        this.f7758h = dVar;
        dVar.b(arrayList, 1);
        this.f7758h.b(arrayList2, 2);
        this.f7758h.b(arrayList3, 3);
        this.f7760j.m(this.f7758h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7758h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f7760j.m(this.f7758h);
        ba.a aVarI = this.f7756f.i(strA);
        aVarI.a0(0);
        if (aVarI.r()) {
            this.f7756f.b(strA);
        } else {
            this.f7756f.g(strA, aVarI);
        }
    }

    public void t(int i10) {
        w9.p pVarM2 = this.f7757g.m2();
        pVarM2.X(i10 == 3);
        this.f7757g.g0(pVarM2);
        u();
    }

    public final void u() {
        this.f7759i.m(Integer.valueOf(this.f7757g.m2().u() ? 3 : 2));
    }
}
