package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d1 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7668f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7669g;

    /* renamed from: h, reason: collision with root package name */
    public kb.a f7670h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7671i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7672j = new androidx.lifecycle.l(null);

    public d1(ca.d dVar, w9.l lVar) {
        this.f7668f = dVar;
        this.f7669g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f7670h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        ba.a aVarI = this.f7668f.i(str);
        aVarI.S(true);
        aVarI.W(z10);
        this.f7668f.g(str, aVarI);
        this.f7672j.m(this.f7670h);
    }

    public boolean m() {
        return this.f7669g.m2().p();
    }

    public LiveData n() {
        return this.f7671i;
    }

    public kb.a o() {
        return this.f7670h;
    }

    public LiveData p() {
        return this.f7672j;
    }

    public boolean q(String str) {
        kb.a aVar = this.f7670h;
        return aVar == null ? m() : aVar.k(str, m());
    }

    public void r() {
        this.f7671i.m(Boolean.valueOf(m()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7668f.j()) {
            ba.b bVarE = this.f7668f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.v(true) == bVarE.v(false)) {
                if (bVarE.v(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f7670h = aVar;
        this.f7672j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f7670h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f7672j.m(this.f7670h);
        ba.a aVarI = this.f7668f.i(str);
        aVarI.I();
        if (aVarI.r()) {
            this.f7668f.b(str);
        } else {
            this.f7668f.g(str, aVarI);
        }
    }

    public void t(boolean z10) {
        w9.p pVarM2 = this.f7669g.m2();
        pVarM2.S(z10);
        this.f7669g.g0(pVarM2);
        this.f7671i.m(Boolean.valueOf(z10));
    }
}
