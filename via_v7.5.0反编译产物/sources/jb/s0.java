package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s0 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.a f6962h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6963i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6964j = new androidx.lifecycle.n(null);

    public s0(z9.d dVar, u9.l lVar) {
        this.f6960f = dVar;
        this.f6961g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f6962h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        y9.a aVarH = this.f6960f.h(str);
        aVarH.S(true);
        aVarH.R(z10);
        this.f6960f.k(str, aVarH);
        this.f6964j.m(this.f6962h);
    }

    public boolean m() {
        return this.f6961g.n2().l();
    }

    public LiveData n() {
        return this.f6963i;
    }

    public kb.a o() {
        return this.f6962h;
    }

    public LiveData p() {
        return this.f6964j;
    }

    public boolean q(String str) {
        kb.a aVar = this.f6962h;
        return aVar == null ? m() : aVar.k(str, m());
    }

    public void r() {
        this.f6963i.m(Boolean.valueOf(m()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f6960f.i()) {
            y9.b bVarE = this.f6960f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.q()) {
                if (bVarE.p(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f6962h = aVar;
        this.f6964j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f6962h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f6964j.m(this.f6962h);
        y9.a aVarH = this.f6960f.h(str);
        aVarH.G();
        if (aVarH.r()) {
            this.f6960f.b(str);
        } else {
            this.f6960f.k(str, aVarH);
        }
    }

    public void t(boolean z10) {
        u9.p pVarN2 = this.f6961g.n2();
        pVarN2.N(z10);
        this.f6961g.F1(pVarN2);
        u9.n.e().w(true);
        this.f6963i.m(Boolean.valueOf(z10));
    }
}
