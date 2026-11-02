package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7738f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7739g;

    /* renamed from: h, reason: collision with root package name */
    public kb.a f7740h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7741i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7742j = new androidx.lifecycle.l(null);

    public j(ca.d dVar, w9.l lVar) {
        this.f7738f = dVar;
        this.f7739g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f7740h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        ba.a aVarI = this.f7738f.i(str);
        aVarI.S(true);
        aVarI.M(z10);
        this.f7738f.g(str, aVarI);
        this.f7742j.m(this.f7740h);
    }

    public LiveData m() {
        return this.f7741i;
    }

    public kb.a n() {
        return this.f7740h;
    }

    public LiveData o() {
        return this.f7742j;
    }

    public boolean p() {
        return this.f7741i.e() != null && ((Boolean) this.f7741i.e()).booleanValue();
    }

    public boolean q(String str) {
        kb.a aVar = this.f7740h;
        return aVar == null ? p() : aVar.k(str, p());
    }

    public void r() {
        this.f7741i.m(Boolean.valueOf(this.f7739g.m2().g()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7738f.j()) {
            ba.b bVarE = this.f7738f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.l(true) == bVarE.l(false)) {
                if (bVarE.l(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f7740h = aVar;
        this.f7742j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f7740h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f7742j.m(this.f7740h);
        ba.a aVarI = this.f7738f.i(str);
        aVarI.D();
        if (aVarI.r()) {
            this.f7738f.b(str);
        } else {
            this.f7738f.g(str, aVarI);
        }
    }

    public void t(boolean z10) {
        w9.p pVarM2 = this.f7739g.m2();
        pVarM2.I(z10);
        this.f7739g.g0(pVarM2);
        w9.n.e().y(true);
        this.f7741i.m(Boolean.valueOf(z10));
    }
}
