package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.a f6851h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f6852i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6853j = new androidx.lifecycle.n(null);

    public j(z9.d dVar, u9.l lVar) {
        this.f6849f = dVar;
        this.f6850g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f6851h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        y9.a aVarH = this.f6849f.h(str);
        aVarH.S(true);
        aVarH.M(z10);
        this.f6849f.k(str, aVarH);
        this.f6853j.m(this.f6851h);
    }

    public LiveData m() {
        return this.f6852i;
    }

    public kb.a n() {
        return this.f6851h;
    }

    public LiveData o() {
        return this.f6853j;
    }

    public boolean p() {
        return this.f6852i.e() != null && ((Boolean) this.f6852i.e()).booleanValue();
    }

    public boolean q(String str) {
        kb.a aVar = this.f6851h;
        return aVar == null ? p() : aVar.k(str, p());
    }

    public void r() {
        this.f6852i.m(Boolean.valueOf(this.f6850g.n2().g()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f6849f.i()) {
            y9.b bVarE = this.f6849f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.l(true) == bVarE.l(false)) {
                if (bVarE.l(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f6851h = aVar;
        this.f6853j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f6851h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f6853j.m(this.f6851h);
        y9.a aVarH = this.f6849f.h(str);
        aVarH.D();
        if (aVarH.r()) {
            this.f6849f.b(str);
        } else {
            this.f6849f.k(str, aVarH);
        }
    }

    public void t(boolean z10) {
        u9.p pVarN2 = this.f6850g.n2();
        pVarN2.H(z10);
        this.f6850g.F1(pVarN2);
        u9.n.e().w(true);
        this.f6852i.m(Boolean.valueOf(z10));
    }
}
