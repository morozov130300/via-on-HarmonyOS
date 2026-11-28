package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d1 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.a f6781h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6782i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6783j = new androidx.lifecycle.n(null);

    public d1(z9.d dVar, u9.l lVar) {
        this.f6779f = dVar;
        this.f6780g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f6781h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        y9.a aVarH = this.f6779f.h(str);
        aVarH.S(true);
        aVarH.W(z10);
        this.f6779f.k(str, aVarH);
        this.f6783j.m(this.f6781h);
    }

    public boolean m() {
        return this.f6780g.n2().p();
    }

    public LiveData n() {
        return this.f6782i;
    }

    public kb.a o() {
        return this.f6781h;
    }

    public LiveData p() {
        return this.f6783j;
    }

    public boolean q(String str) {
        kb.a aVar = this.f6781h;
        return aVar == null ? m() : aVar.k(str, m());
    }

    public void r() {
        this.f6782i.m(Boolean.valueOf(m()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f6779f.i()) {
            y9.b bVarE = this.f6779f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.v(true) == bVarE.v(false)) {
                if (bVarE.v(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f6781h = aVar;
        this.f6783j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f6781h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f6783j.m(this.f6781h);
        y9.a aVarH = this.f6779f.h(str);
        aVarH.I();
        if (aVarH.r()) {
            this.f6779f.b(str);
        } else {
            this.f6779f.k(str, aVarH);
        }
    }

    public void t(boolean z10) {
        u9.p pVarN2 = this.f6780g.n2();
        pVarN2.R(z10);
        this.f6780g.F1(pVarN2);
        this.f6782i.m(Boolean.valueOf(z10));
    }
}
