package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v2 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7898f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7899g;

    /* renamed from: h, reason: collision with root package name */
    public kb.d f7900h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7901i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7902j = new androidx.lifecycle.l();

    public v2(ca.d dVar, w9.l lVar) {
        this.f7898f = dVar;
        this.f7899g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7900h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        ba.a aVarI = this.f7898f.i(strA);
        aVarI.S(true);
        aVarI.b0(i10);
        this.f7898f.g(strA, aVarI);
        this.f7902j.m(this.f7900h);
    }

    public int m() {
        if (this.f7901i.e() != null) {
            return ((Integer) this.f7901i.e()).intValue();
        }
        u();
        return ((Integer) this.f7901i.e()).intValue();
    }

    public LiveData n() {
        return this.f7901i;
    }

    public int o(String str) {
        return str == null ? m() : this.f7900h.d(str, m());
    }

    public kb.d p() {
        return this.f7900h;
    }

    public androidx.lifecycle.l q() {
        return this.f7902j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f7898f.j()) {
            ba.b bVarE = this.f7898f.e(str);
            int iG = bVarE == null ? 0 : bVarE.g();
            if (bVarE != null && bVarE.s() && iG != 0) {
                if (iG == 3) {
                    arrayList3.add(str);
                } else if (iG == 2) {
                    arrayList2.add(str);
                } else {
                    arrayList.add(str);
                }
            }
        }
        kb.d dVar = new kb.d();
        this.f7900h = dVar;
        dVar.b(arrayList, 1);
        this.f7900h.b(arrayList2, 2);
        this.f7900h.b(arrayList3, 3);
        this.f7902j.m(this.f7900h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7900h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f7902j.m(this.f7900h);
        ba.a aVarI = this.f7898f.i(strA);
        aVarI.O(0);
        if (aVarI.r()) {
            this.f7898f.b(strA);
        } else {
            this.f7898f.g(strA, aVarI);
        }
    }

    public void t(int i10) {
        w9.p pVarM2 = this.f7899g.m2();
        pVarM2.Y(i10 == 3);
        this.f7899g.g0(pVarM2);
        u();
    }

    public final void u() {
        this.f7901i.m(Integer.valueOf(this.f7899g.m2().v() ? 3 : 2));
    }
}
