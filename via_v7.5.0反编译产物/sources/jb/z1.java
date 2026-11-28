package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z1 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f7054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f7055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.a f7056h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f7057i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f7058j = new androidx.lifecycle.n(null);

    public z1(z9.d dVar, u9.l lVar) {
        this.f7054f = dVar;
        this.f7055g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f7056h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        y9.a aVarH = this.f7054f.h(str);
        aVarH.S(true);
        aVarH.Z(z10);
        this.f7054f.k(str, aVarH);
        this.f7058j.m(this.f7056h);
    }

    public LiveData m() {
        return this.f7057i;
    }

    public kb.a n() {
        return this.f7056h;
    }

    public LiveData o() {
        return this.f7058j;
    }

    public boolean p() {
        return this.f7055g.n2().t();
    }

    public boolean q(String str) {
        kb.a aVar = this.f7056h;
        return aVar == null ? p() : aVar.k(str, p());
    }

    public void r() {
        this.f7057i.m(Boolean.valueOf(p()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7054f.i()) {
            y9.b bVarE = this.f7054f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.B(true) == bVarE.B(false)) {
                if (bVarE.B(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f7056h = aVar;
        this.f7058j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f7056h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f7058j.m(this.f7056h);
        y9.a aVarH = this.f7054f.h(str);
        aVarH.L();
        if (aVarH.r()) {
            this.f7054f.b(str);
        } else {
            this.f7054f.k(str, aVarH);
        }
    }

    public void t(boolean z10) {
        u9.p pVarN2 = this.f7055g.n2();
        pVarN2.V(z10);
        this.f7055g.F1(pVarN2);
        u9.n.e().w(true);
        this.f7057i.m(Boolean.valueOf(z10));
    }
}
