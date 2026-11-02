package jb;

import androidx.lifecycle.LiveData;
import java.util.HashMap;
import java.util.Map;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l5 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f7776f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f7777g;

    /* renamed from: h, reason: collision with root package name */
    public int f7778h = 100;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f7779i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7780j = new androidx.lifecycle.l();

    public l5(ca.d dVar, w9.l lVar) {
        this.f7776f = dVar;
        this.f7777g = lVar;
    }

    public void l(String str, int i10) {
        String strA = kb.c.a(str);
        if (strA == null || strA.isEmpty()) {
            return;
        }
        ba.a aVarI = this.f7776f.i(strA);
        aVarI.S(true);
        aVarI.d0(i10);
        this.f7776f.g(strA, aVarI);
        w9.n.e().y(true);
        this.f7779i.put(strA, Integer.valueOf(i10));
        this.f7780j.m(this.f7779i);
    }

    public int m() {
        return this.f7777g.F0();
    }

    public Map n() {
        return this.f7779i;
    }

    public LiveData o() {
        return this.f7780j;
    }

    public boolean p() {
        return this.f7777g.m2().n();
    }

    public void q() {
        for (String str : this.f7776f.j()) {
            ba.b bVarE = this.f7776f.e(str);
            int i10 = bVarE != null ? bVarE.i(0) : 0;
            if (bVarE != null && bVarE.s() && i10 > 0) {
                this.f7779i.put(str, Integer.valueOf(i10));
            }
        }
        this.f7780j.m(this.f7779i);
    }

    public void r(String str) {
        String strA = kb.c.a(str);
        if (strA == null || strA.isEmpty() || !this.f7779i.containsKey(strA)) {
            return;
        }
        ba.a aVarI = this.f7776f.i(strA);
        aVarI.d0(0);
        if (aVarI.r()) {
            this.f7776f.b(strA);
        } else {
            this.f7776f.g(strA, aVarI);
        }
        w9.n.e().y(true);
        this.f7779i.remove(strA);
        this.f7780j.m(this.f7779i);
    }

    public void s(int i10) {
        if (i10 <= 0) {
            return;
        }
        this.f7777g.J(i10);
        w9.n.e().y(true);
    }

    public void t(boolean z10) {
        w9.p pVarM2 = this.f7777g.m2();
        pVarM2.Q(z10);
        this.f7777g.g0(pVarM2);
    }
}
