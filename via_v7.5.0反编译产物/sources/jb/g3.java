package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g3 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.d f6820h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6821i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6822j = new androidx.lifecycle.n();

    public g3(z9.d dVar, u9.l lVar) {
        this.f6818f = dVar;
        this.f6819g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f6820h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        y9.a aVarH = this.f6818f.h(strA);
        aVarH.S(true);
        aVarH.c0(i10);
        this.f6818f.k(strA, aVarH);
        this.f6822j.m(this.f6820h);
    }

    public int m() {
        if (this.f6821i.e() != null) {
            return ((Integer) this.f6821i.e()).intValue();
        }
        u();
        return ((Integer) this.f6821i.e()).intValue();
    }

    public LiveData n() {
        return this.f6821i;
    }

    public int o(String str) {
        return str == null ? m() : this.f6820h.d(str, m());
    }

    public kb.d p() {
        return this.f6820h;
    }

    public androidx.lifecycle.n q() {
        return this.f6822j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f6818f.i()) {
            y9.b bVarE = this.f6818f.e(str);
            int iH = bVarE == null ? 0 : bVarE.h();
            if (bVarE != null && bVarE.s() && iH != 0) {
                if (iH == 3) {
                    arrayList3.add(str);
                } else if (iH == 2) {
                    arrayList2.add(str);
                } else {
                    arrayList.add(str);
                }
            }
        }
        kb.d dVar = new kb.d();
        this.f6820h = dVar;
        dVar.b(arrayList, 1);
        this.f6820h.b(arrayList2, 2);
        this.f6820h.b(arrayList3, 3);
        this.f6822j.m(this.f6820h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f6820h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f6822j.m(this.f6820h);
        y9.a aVarH = this.f6818f.h(strA);
        aVarH.O(0);
        if (aVarH.r()) {
            this.f6818f.b(strA);
        } else {
            this.f6818f.k(strA, aVarH);
        }
    }

    public void t(int i10) {
        u9.p pVarN2 = this.f6819g.n2();
        pVarN2.a0(i10);
        this.f6819g.F1(pVarN2);
        u();
    }

    public final void u() {
        this.f6821i.m(Integer.valueOf(this.f6819g.n2().f()));
    }
}
