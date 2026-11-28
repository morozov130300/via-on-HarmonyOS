package jb;

import androidx.lifecycle.LiveData;
import java.util.HashMap;
import java.util.Map;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l5 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f6887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f6888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6889h = 100;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap f6890i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f6891j = new androidx.lifecycle.n();

    public l5(z9.d dVar, u9.l lVar) {
        this.f6887f = dVar;
        this.f6888g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        if (strA == null || strA.isEmpty()) {
            return;
        }
        y9.a aVarH = this.f6887f.h(strA);
        aVarH.S(true);
        aVarH.d0(i10);
        this.f6887f.k(strA, aVarH);
        u9.n.e().w(true);
        this.f6890i.put(strA, Integer.valueOf(i10));
        this.f6891j.m(this.f6890i);
    }

    public int m() {
        return this.f6888g.H0();
    }

    public Map n() {
        return this.f6890i;
    }

    public LiveData o() {
        return this.f6891j;
    }

    public boolean p() {
        return this.f6888g.n2().n();
    }

    public void q() {
        for (String str : this.f6887f.i()) {
            y9.b bVarE = this.f6887f.e(str);
            int i10 = bVarE != null ? bVarE.i(0) : 0;
            if (bVarE != null && bVarE.s() && i10 > 0) {
                this.f6890i.put(str, Integer.valueOf(i10));
            }
        }
        this.f6891j.m(this.f6890i);
    }

    public void r(String str) {
        String strA = kb.c.a(str);
        if (strA == null || strA.isEmpty() || !this.f6890i.containsKey(strA)) {
            return;
        }
        y9.a aVarH = this.f6887f.h(strA);
        aVarH.d0(0);
        if (aVarH.r()) {
            this.f6887f.b(strA);
        } else {
            this.f6887f.k(strA, aVarH);
        }
        u9.n.e().w(true);
        this.f6890i.remove(strA);
        this.f6891j.m(this.f6890i);
    }

    public void s(int i10) {
        if (i10 <= 0) {
            return;
        }
        this.f6888g.K(i10);
        u9.n.e().w(true);
    }

    public void t(boolean z10) {
        u9.p pVarN2 = this.f6888g.n2();
        pVarN2.P(z10);
        this.f6888g.F1(pVarN2);
    }
}
