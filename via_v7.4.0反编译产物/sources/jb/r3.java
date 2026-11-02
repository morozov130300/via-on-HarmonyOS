package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r3 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7839f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7840g;

    /* renamed from: h, reason: collision with root package name */
    public kb.a f7841h = null;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7842i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7843j = new androidx.lifecycle.l(null);

    public r3(ca.d dVar, w9.l lVar) {
        this.f7839f = dVar;
        this.f7840g = lVar;
    }

    public void l(String str, boolean z10) {
        kb.a aVar = this.f7841h;
        if (aVar == null || !aVar.h(str, z10)) {
            return;
        }
        ba.a aVarI = this.f7839f.i(str);
        aVarI.S(true);
        aVarI.P(z10);
        this.f7839f.g(str, aVarI);
        this.f7843j.m(this.f7841h);
    }

    public LiveData m() {
        return this.f7842i;
    }

    public kb.a n() {
        return this.f7841h;
    }

    public LiveData o() {
        return this.f7843j;
    }

    public boolean p() {
        return this.f7840g.m2().k();
    }

    public boolean q(String str) {
        kb.a aVar = this.f7841h;
        return aVar == null ? p() : aVar.k(str, p());
    }

    public void r() {
        this.f7842i.m(Boolean.valueOf(p()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7839f.j()) {
            ba.b bVarE = this.f7839f.e(str);
            if (bVarE != null && bVarE.s() && bVarE.n(true) == bVarE.n(false)) {
                if (bVarE.n(false)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        kb.a aVar = new kb.a(arrayList2, arrayList);
        this.f7841h = aVar;
        this.f7843j.m(aVar);
    }

    public void s(String str) {
        kb.a aVar = this.f7841h;
        if (aVar == null || !aVar.f(str)) {
            return;
        }
        this.f7843j.m(this.f7841h);
        ba.a aVarI = this.f7839f.i(str);
        aVarI.F();
        if (aVarI.r()) {
            this.f7839f.b(str);
        } else {
            this.f7839f.g(str, aVarI);
        }
    }

    public void t(boolean z10) {
        w9.p pVarM2 = this.f7840g.m2();
        pVarM2.N(z10);
        this.f7840g.g0(pVarM2);
        this.f7842i.m(Boolean.valueOf(z10));
    }
}
