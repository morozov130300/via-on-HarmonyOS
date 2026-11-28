package jb;

import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f0 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.d f6805h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6806i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6807j = new androidx.lifecycle.n(null);

    public f0(z9.d dVar, u9.l lVar) {
        this.f6803f = dVar;
        this.f6804g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f6805h;
        if (dVar == null || !dVar.a(strA, i10)) {
            return;
        }
        y9.a aVarH = this.f6803f.h(strA);
        aVarH.S(true);
        aVarH.O(i10);
        this.f6803f.k(strA, aVarH);
        this.f6807j.m(this.f6805h);
    }

    public int m(String str) {
        kb.d dVar = this.f6805h;
        return dVar == null ? o() : dVar.d(str, o());
    }

    public androidx.lifecycle.n n() {
        return this.f6806i;
    }

    public int o() {
        if (this.f6806i.e() != null) {
            return ((Integer) this.f6806i.e()).intValue();
        }
        u();
        return ((Integer) this.f6806i.e()).intValue();
    }

    public kb.d p() {
        return this.f6805h;
    }

    public androidx.lifecycle.n q() {
        return this.f6807j;
    }

    public void r() {
        u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : this.f6803f.i()) {
            y9.b bVarE = this.f6803f.e(str);
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
        this.f6805h = dVar;
        dVar.b(arrayList, 1);
        this.f6805h.b(arrayList2, 2);
        this.f6805h.b(arrayList3, 3);
        this.f6807j.m(this.f6805h);
    }

    public void s(String str) {
        String strA = kb.c.a(str);
        kb.d dVar = this.f6805h;
        if (dVar == null || !dVar.f(strA)) {
            return;
        }
        this.f6807j.m(this.f6805h);
        y9.a aVarH = this.f6803f.h(strA);
        aVarH.O(0);
        if (aVarH.r()) {
            this.f6803f.b(strA);
        } else {
            this.f6803f.k(strA, aVarH);
        }
    }

    public void t(int i10) {
        u9.p pVarN2 = this.f6804g.n2();
        pVarN2.K(i10);
        this.f6804g.F1(pVarN2);
        u();
    }

    public final void u() {
        this.f6806i.m(Integer.valueOf(this.f6804g.n2().e()));
    }
}
