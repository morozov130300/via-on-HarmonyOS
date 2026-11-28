package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.d f6984h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6985i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6986j = new androidx.lifecycle.n();

    public u(z9.d dVar, u9.l lVar) {
        this.f6982f = dVar;
        this.f6983g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f6984h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        y9.a aVarH = this.f6982f.h(strA);
        aVarH.S(true);
        aVarH.N(i10);
        this.f6982f.k(strA, aVarH);
        this.f6986j.m(this.f6984h);
    }

    public int m(String str) {
        return str == null ? n() : this.f6984h.d(str, n());
    }

    public int n() {
        if (this.f6985i.e() != null) {
            return ((Integer) this.f6985i.e()).intValue();
        }
        u();
        return ((Integer) this.f6985i.e()).intValue();
    }

    public LiveData o() {
        return this.f6985i;
    }

    public kb.d p() {
        return this.f6984h;
    }

    public androidx.lifecycle.n q() {
        return this.f6986j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f6982f.i()) {
            y9.b bVarE = this.f6982f.e(str);
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
        this.f6984h = dVar;
        dVar.b(arrayList, 1);
        this.f6984h.b(arrayList2, 2);
        this.f6984h.b(arrayList3, 3);
        this.f6986j.m(this.f6984h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f6984h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f6986j.m(this.f6984h);
        y9.a aVarH = this.f6982f.h(strA);
        aVarH.O(0);
        if (aVarH.r()) {
            this.f6982f.b(strA);
        } else {
            this.f6982f.k(strA, aVarH);
        }
    }

    public void t(int i10) {
        u9.p pVarN2 = this.f6983g.n2();
        pVarN2.J(i10 == 3);
        this.f6983g.F1(pVarN2);
        u();
    }

    public final void u() {
        this.f6985i.m(Integer.valueOf(this.f6983g.n2().i() ? 3 : 2));
    }
}
