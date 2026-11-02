package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z1 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7944f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7945g;

    /* renamed from: h, reason: collision with root package name */
    public kb.a f7946h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7947i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7948j = new androidx.lifecycle.l(null);

    public z1(ca.d dVar, w9.l lVar) {
        this.f7944f = dVar;
        this.f7945g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f7946h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        ba.a aVarI = this.f7944f.i(str);
        aVarI.S(true);
        aVarI.Z(z10);
        this.f7944f.g(str, aVarI);
        this.f7948j.m(this.f7946h);
    }

    public LiveData m() {
        return this.f7947i;
    }

    public kb.a n() {
        return this.f7946h;
    }

    public LiveData o() {
        return this.f7948j;
    }

    public boolean p() {
        return this.f7945g.m2().t();
    }

    public boolean q(String str) {
        kb.a aVar = this.f7946h;
        return aVar == null ? p() : aVar.k(str, p());
    }

    public void r() {
        this.f7947i.m(Boolean.valueOf(p()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7944f.j()) {
            ba.b bVarE = this.f7944f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.B(true) == bVarE.B(false)) {
                if (bVarE.B(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f7946h = aVar;
        this.f7948j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f7946h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f7948j.m(this.f7946h);
        ba.a aVarI = this.f7944f.i(str);
        aVarI.L();
        if (aVarI.r()) {
            this.f7944f.b(str);
        } else {
            this.f7944f.g(str, aVarI);
        }
    }

    public void t(boolean z10) {
        w9.p pVarM2 = this.f7945g.m2();
        pVarM2.W(z10);
        this.f7945g.g0(pVarM2);
        w9.n.e().y(true);
        this.f7947i.m(Boolean.valueOf(z10));
    }
}
