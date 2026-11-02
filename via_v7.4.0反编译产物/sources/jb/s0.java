package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s0 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7849f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7850g;

    /* renamed from: h, reason: collision with root package name */
    public kb.a f7851h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7852i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7853j = new androidx.lifecycle.l(null);

    public s0(ca.d dVar, w9.l lVar) {
        this.f7849f = dVar;
        this.f7850g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f7851h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        ba.a aVarI = this.f7849f.i(str);
        aVarI.S(true);
        aVarI.R(z10);
        this.f7849f.g(str, aVarI);
        this.f7853j.m(this.f7851h);
    }

    public boolean m() {
        return this.f7850g.m2().l();
    }

    public LiveData n() {
        return this.f7852i;
    }

    public kb.a o() {
        return this.f7851h;
    }

    public LiveData p() {
        return this.f7853j;
    }

    public boolean q(String str) {
        kb.a aVar = this.f7851h;
        return aVar == null ? m() : aVar.k(str, m());
    }

    public void r() {
        this.f7852i.m(Boolean.valueOf(m()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7849f.j()) {
            ba.b bVarE = this.f7849f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.q()) {
                if (bVarE.p(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f7851h = aVar;
        this.f7853j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f7851h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f7853j.m(this.f7851h);
        ba.a aVarI = this.f7849f.i(str);
        aVarI.G();
        if (aVarI.r()) {
            this.f7849f.b(str);
        } else {
            this.f7849f.g(str, aVarI);
        }
    }

    public void t(boolean z10) {
        w9.p pVarM2 = this.f7850g.m2();
        pVarM2.O(z10);
        this.f7850g.g0(pVarM2);
        w9.n.e().y(true);
        this.f7852i.m(Boolean.valueOf(z10));
    }
}
