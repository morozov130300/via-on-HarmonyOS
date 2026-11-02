package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o1 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7803f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7804g;

    /* renamed from: h, reason: collision with root package name */
    public kb.a f7805h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7806i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7807j = new androidx.lifecycle.l(null);

    public o1(ca.d dVar, w9.l lVar) {
        this.f7803f = dVar;
        this.f7804g = lVar;
    }

    public void l(String str, boolean z10) {
        String strA = kb.c.a(str);
        kb.a aVar = this.f7805h;
        if (aVar == null || !aVar.h(strA, z10)) {
            return;
        }
        ba.a aVarI = this.f7803f.i(strA);
        aVarI.S(true);
        aVarI.X(z10);
        this.f7803f.g(strA, aVarI);
        this.f7807j.m(this.f7805h);
    }

    public kb.a m() {
        return this.f7805h;
    }

    public LiveData n() {
        return this.f7807j;
    }

    public w9.p o() {
        return (w9.p) this.f7806i.e();
    }

    public LiveData p() {
        return this.f7806i;
    }

    public boolean q() {
        w9.p pVarO = o();
        if (pVarO == null) {
            pVarO = this.f7804g.m2();
            this.f7806i.m(pVarO);
        }
        return pVarO.q();
    }

    public boolean r(String str) {
        kb.a aVar = this.f7805h;
        return aVar == null ? q() : aVar.k(str, q());
    }

    public void s() {
        this.f7806i.m(this.f7804g.m2());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7803f.j()) {
            ba.b bVarE = this.f7803f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.y()) {
                if (bVarE.x(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f7805h = aVar;
        this.f7807j.m(aVar);
    }

    public void t(String str) {
        String strA = kb.c.a(str);
        kb.a aVar = this.f7805h;
        if (aVar == null || !aVar.f(strA)) {
            return;
        }
        this.f7807j.m(this.f7805h);
        ba.a aVarI = this.f7803f.i(strA);
        aVarI.J();
        if (aVarI.r()) {
            this.f7803f.b(strA);
        } else {
            this.f7803f.g(strA, aVarI);
        }
    }

    public void u(boolean z10, boolean z11) {
        w9.p pVarM2 = this.f7804g.m2();
        pVarM2.U(z10);
        pVarM2.T(z11);
        this.f7804g.g0(pVarM2);
        w9.n.e().y(true);
        this.f7806i.m(pVarM2);
    }
}
