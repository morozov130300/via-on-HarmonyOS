package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v2 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f7008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f7009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.d f7010h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f7011i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f7012j = new androidx.lifecycle.n();

    public v2(z9.d dVar, u9.l lVar) {
        this.f7008f = dVar;
        this.f7009g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7010h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        y9.a aVarH = this.f7008f.h(strA);
        aVarH.S(true);
        aVarH.b0(i10);
        this.f7008f.k(strA, aVarH);
        this.f7012j.m(this.f7010h);
    }

    public int m() {
        if (this.f7011i.e() != null) {
            return ((Integer) this.f7011i.e()).intValue();
        }
        u();
        return ((Integer) this.f7011i.e()).intValue();
    }

    public LiveData n() {
        return this.f7011i;
    }

    public int o(String str) {
        return str == null ? m() : this.f7010h.d(str, m());
    }

    public kb.d p() {
        return this.f7010h;
    }

    public androidx.lifecycle.n q() {
        return this.f7012j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f7008f.i()) {
            y9.b bVarE = this.f7008f.e(str);
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
        this.f7010h = dVar;
        dVar.b(arrayList, 1);
        this.f7010h.b(arrayList2, 2);
        this.f7010h.b(arrayList3, 3);
        this.f7012j.m(this.f7010h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f7010h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f7012j.m(this.f7010h);
        y9.a aVarH = this.f7008f.h(strA);
        aVarH.O(0);
        if (aVarH.r()) {
            this.f7008f.b(strA);
        } else {
            this.f7008f.k(strA, aVarH);
        }
    }

    public void t(int i10) {
        u9.p pVarN2 = this.f7009g.n2();
        pVarN2.X(i10 == 3);
        this.f7009g.F1(pVarN2);
        u();
    }

    public final void u() {
        this.f7011i.m(Integer.valueOf(this.f7009g.n2().v() ? 3 : 2));
    }
}
