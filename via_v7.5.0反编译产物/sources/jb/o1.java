package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o1 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.a f6916h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6917i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6918j = new androidx.lifecycle.n(null);

    public o1(z9.d dVar, u9.l lVar) {
        this.f6914f = dVar;
        this.f6915g = lVar;
    }

    public void l(String str, boolean z10) {
        String strA = kb.c.a(str);
        kb.a aVar = this.f6916h;
        if (aVar == null || !aVar.h(strA, z10)) {
            return;
        }
        y9.a aVarH = this.f6914f.h(strA);
        aVarH.S(true);
        aVarH.X(z10);
        this.f6914f.k(strA, aVarH);
        this.f6918j.m(this.f6916h);
    }

    public kb.a m() {
        return this.f6916h;
    }

    public LiveData n() {
        return this.f6918j;
    }

    public u9.p o() {
        return (u9.p) this.f6917i.e();
    }

    public LiveData p() {
        return this.f6917i;
    }

    public boolean q() {
        u9.p pVarO = o();
        if (pVarO == null) {
            pVarO = this.f6915g.n2();
            this.f6917i.m(pVarO);
        }
        return pVarO.q();
    }

    public boolean r(String str) {
        kb.a aVar = this.f6916h;
        return aVar == null ? q() : aVar.k(str, q());
    }

    public void s() {
        this.f6917i.m(this.f6915g.n2());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f6914f.i()) {
            y9.b bVarE = this.f6914f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.y()) {
                if (bVarE.x(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f6916h = aVar;
        this.f6918j.m(aVar);
    }

    public void t(String str) {
        String strA = kb.c.a(str);
        kb.a aVar = this.f6916h;
        if (aVar == null || !aVar.f(strA)) {
            return;
        }
        this.f6918j.m(this.f6916h);
        y9.a aVarH = this.f6914f.h(strA);
        aVarH.J();
        if (aVarH.r()) {
            this.f6914f.b(strA);
        } else {
            this.f6914f.k(strA, aVarH);
        }
    }

    public void u(boolean z10, boolean z11) {
        u9.p pVarN2 = this.f6915g.n2();
        pVarN2.T(z10);
        pVarN2.S(z11);
        this.f6915g.F1(pVarN2);
        u9.n.e().w(true);
        this.f6917i.m(pVarN2);
    }
}
