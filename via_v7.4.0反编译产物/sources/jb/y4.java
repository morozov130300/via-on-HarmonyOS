package jb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import hb.w6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y4 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f7938r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7939s0;

    private void n3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: jb.v4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f7904e.j3();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: jb.w4
            @Override // a7.e
            public final void accept(Object obj) {
                this.f7913e.p3((List) obj);
            }
        }, new x7.g0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3(View view, int i10, a6.q qVar) {
        switch (qVar.c()) {
            case 1:
                g6.i.g(this, w6.class);
                break;
            case 2:
                g6.i.g(this, n1.class);
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                g6.i.g(this, v5.class);
                break;
            case 4:
                g6.i.g(this, e0.class);
                break;
            case 5:
                g6.i.g(this, j2.class);
                break;
            case 6:
                g6.i.g(this, t.class);
                break;
            case 7:
                g6.i.g(this, u2.class);
                break;
            case 8:
                g6.i.g(this, y1.class);
                break;
            case 9:
                g6.i.g(this, i0.class);
                break;
            case 10:
                g6.i.g(this, u3.class);
                break;
            case 11:
                g6.i.g(this, f3.class);
                break;
            case 12:
                g6.i.g(this, i.class);
                break;
            case 13:
                g6.i.g(this, q3.class);
                break;
            case 14:
                g6.i.g(this, k5.class);
                break;
            case 15:
                g6.i.g(this, z5.class);
                break;
            case 16:
                g6.i.g(this, c1.class);
                break;
            case 17:
                g6.i.g(this, r0.class);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7939s0.H(), list));
        this.f7939s0.M(list);
        eVarB.c(this.f7939s0);
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(boolean z10) {
        super.I1(z10);
        if (z10) {
            return;
        }
        n3();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f7938r0 = pa.r.j();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7939s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.x4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7926a.o3(view2, i10, (a6.q) obj);
            }
        });
        this.f7939s0.K(a6.q.class, sVar);
        this.f7939s0.K(a6.l.class, new a6.m());
        this.f10459q0.setAdapter(this.f7939s0);
        n3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.Ic));
    }

    public final List j3() {
        String strG;
        w9.p pVarM2 = this.f7938r0.m2();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(1, Z0(x7.u.S0)));
        arrayList.add(new a6.l(Z0(x7.u.R1)));
        arrayList.add(new a6.q(14, Z0(x7.u.Pc), String.format(Locale.ROOT, "%d%%", Integer.valueOf(this.f7938r0.F0()))));
        List listE = z8.b4.e(I());
        int iL0 = this.f7938r0.l0();
        Iterator it = listE.iterator();
        while (true) {
            if (!it.hasNext()) {
                strG = null;
                break;
            }
            ja.c cVar = (ja.c) it.next();
            if (cVar.d() == iL0) {
                strG = cVar.g();
                break;
            }
        }
        arrayList.add(new a6.q(3, Z0(x7.u.C0), strG));
        arrayList.add(new a6.q(17, Z0(x7.u.T), Z0(pVarM2.l() ? x7.u.f13938c9 : x7.u.Y8)));
        String strL3 = l3(pVarM2.q());
        if (pVarM2.r()) {
            strL3 = Z0(x7.u.D6);
        }
        arrayList.add(new a6.q(2, Z0(x7.u.f14235y6), strL3));
        arrayList.add(new a6.q(8, Z0(x7.u.f14076m7), l3(pVarM2.t())));
        arrayList.add(new a6.q(9, Z0(x7.u.f14244z2), (!pVarM2.j() || pVarM2.C()) ? l3(pVarM2.j()) : Z0(x7.u.B2)));
        arrayList.add(new a6.q(10, Z0(x7.u.f14226xa), Z0(pVarM2.h() ? x7.u.f14000h1 : x7.u.Z0)));
        arrayList.add(new a6.l(Z0(x7.u.Q1)));
        arrayList.add(new a6.q(12, Z0(x7.u.f14165t1), Z0(pVarM2.g() ? x7.u.f13938c9 : x7.u.Y8)));
        arrayList.add(new a6.l(Z0(x7.u.S1)));
        arrayList.add(new a6.q(4, Z0(x7.u.f13987g2), m3(pVarM2.e())));
        arrayList.add(new a6.q(11, Z0(x7.u.f14036j9), m3(pVarM2.f())));
        arrayList.add(new a6.q(5, Z0(x7.u.G7), k3(pVarM2.u())));
        arrayList.add(new a6.q(6, Z0(x7.u.F1), k3(pVarM2.i())));
        arrayList.add(new a6.q(7, Z0(x7.u.f14105o8), k3(pVarM2.v())));
        arrayList.add(new a6.q(13, Z0(x7.u.X9), pVarM2.k() ? l3(true) : Z0(x7.u.f13939ca)));
        arrayList.add(new a6.q(15, Z0(x7.u.Gh), l3(pVarM2.E())));
        arrayList.add(new a6.l(Z0(x7.u.f14123pc)));
        arrayList.add(new a6.q(16, Z0(x7.u.Fa), Z0(pVarM2.p() ? x7.u.f13938c9 : x7.u.Y8)));
        return arrayList;
    }

    public final String k3(boolean z10) {
        return Z0(z10 ? x7.u.f14000h1 : x7.u.f14204w1);
    }

    public final String l3(boolean z10) {
        return Z0(z10 ? x7.u.Z0 : x7.u.f14204w1);
    }

    public final String m3(int i10) {
        if (i10 == 1 || i10 == 2) {
            return l3(i10 == 1);
        }
        return i10 != 3 ? "" : Z0(x7.u.f14000h1);
    }
}
