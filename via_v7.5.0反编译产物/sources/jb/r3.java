package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r3 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.a f6952h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6953i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6954j = new androidx.lifecycle.n(null);

    public r3(z9.d dVar, u9.l lVar) {
        this.f6950f = dVar;
        this.f6951g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f6952h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        y9.a aVarH = this.f6950f.h(str);
        aVarH.S(true);
        aVarH.P(z10);
        this.f6950f.k(str, aVarH);
        this.f6954j.m(this.f6952h);
    }

    public LiveData m() {
        return this.f6953i;
    }

    public kb.a n() {
        return this.f6952h;
    }

    public LiveData o() {
        return this.f6954j;
    }

    public boolean p() {
        return this.f6951g.n2().k();
    }

    public boolean q(String str) {
        kb.a aVar = this.f6952h;
        return aVar == null ? p() : aVar.k(str, p());
    }

    public void r() {
        this.f6953i.m(Boolean.valueOf(p()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f6950f.i()) {
            y9.b bVarE = this.f6950f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.n(true) == bVarE.n(false)) {
                if (bVarE.n(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f6952h = aVar;
        this.f6954j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f6952h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f6954j.m(this.f6952h);
        y9.a aVarH = this.f6950f.h(str);
        aVarH.F();
        if (aVarH.r()) {
            this.f6950f.b(str);
        } else {
            this.f6950f.k(str, aVarH);
        }
    }

    public void t(boolean z10) {
        u9.p pVarN2 = this.f6951g.n2();
        pVarN2.M(z10);
        this.f6951g.F1(pVarN2);
        this.f6953i.m(Boolean.valueOf(z10));
    }
}
