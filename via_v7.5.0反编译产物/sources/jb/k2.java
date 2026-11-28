package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k2 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.d f6869h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6870i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6871j = new androidx.lifecycle.n();

    public k2(z9.d dVar, u9.l lVar) {
        this.f6867f = dVar;
        this.f6868g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f6869h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        y9.a aVarH = this.f6867f.h(strA);
        aVarH.S(true);
        aVarH.a0(i10);
        this.f6867f.k(strA, aVarH);
        this.f6871j.m(this.f6869h);
    }

    public int m() {
        if (this.f6870i.e() != null) {
            return ((Integer) this.f6870i.e()).intValue();
        }
        u();
        return ((Integer) this.f6870i.e()).intValue();
    }

    public LiveData n() {
        return this.f6870i;
    }

    public int o(String str) {
        return str == null ? m() : this.f6869h.d(str, m());
    }

    public kb.d p() {
        return this.f6869h;
    }

    public androidx.lifecycle.n q() {
        return this.f6871j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f6867f.i()) {
            y9.b bVarE = this.f6867f.e(str);
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
        this.f6869h = dVar;
        dVar.b(arrayList, 1);
        this.f6869h.b(arrayList2, 2);
        this.f6869h.b(arrayList3, 3);
        this.f6871j.m(this.f6869h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f6869h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f6871j.m(this.f6869h);
        y9.a aVarH = this.f6867f.h(strA);
        aVarH.a0(0);
        if (aVarH.r()) {
            this.f6867f.b(strA);
        } else {
            this.f6867f.k(strA, aVarH);
        }
    }

    public void t(int i10) {
        u9.p pVarN2 = this.f6868g.n2();
        pVarN2.W(i10 == 3);
        this.f6868g.F1(pVarN2);
        u();
    }

    public final void u() {
        this.f6870i.m(Integer.valueOf(this.f6868g.n2().u() ? 3 : 2));
    }
}
