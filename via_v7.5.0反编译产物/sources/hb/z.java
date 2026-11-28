package hb;

import android.R;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final u9.l f6167u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final u9.p f6168v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final u9.a f6169w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public t5.f f6170x0;

    public z() {
        u9.l lVarJ = la.s.j();
        this.f6167u0 = lVarJ;
        this.f6168v0 = lVarJ.n2();
        this.f6169w0 = lVarJ.v();
    }

    public static /* synthetic */ void f3(z zVar, View view, q5.k.p pVar) {
        zVar.getClass();
        FragmentUtils.i(zVar, f4.class);
    }

    public static /* synthetic */ void h3(z zVar, View view, int i10, v5.q qVar) {
        zVar.getClass();
        if (qVar.c() == 6) {
            zVar.k3();
        }
    }

    public static List i3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, z.class, w7.u.Dc);
        hVar.b(4, w7.u.Kb, new String[0]);
        hVar.b(1, w7.u.Rc, new String[0]);
        hVar.b(3, w7.u.ti, new String[0]);
        if (x8.j3.h(context)) {
            hVar.b(8, w7.u.P3, new String[0]);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            hVar.b(7, w7.u.N3, new String[0]);
        }
        if (i10 >= 26) {
            hVar.b(5, w7.u.ig, new String[0]);
        }
        hVar.b(6, w7.u.og, new String[0]);
        return hVar.f();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        x8.r3.e(this.f7946t0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(4, X0(w7.u.Kb), X0(w7.u.Lb), this.f6168v0.z()));
        arrayList.add(new v5.n(1, X0(w7.u.Rc), this.f6167u0.G()));
        arrayList.add(new v5.n(3, X0(w7.u.ti), this.f6168v0.F()));
        if (x8.j3.h(G())) {
            arrayList.add(new v5.n(8, X0(w7.u.P3), !this.f6169w0.m()));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            arrayList.add(new v5.n(7, X0(w7.u.N3), X0(w7.u.O3), true ^ this.f6169w0.j()));
        }
        if (i10 >= 26) {
            arrayList.add(new v5.n(5, X0(w7.u.ig), X0(w7.u.jg), this.f6168v0.y()));
        }
        arrayList.add(new v5.q(6, X0(w7.u.og), X0(w7.u.qg)));
        this.f6170x0 = new t5.f(arrayList);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: hb.w
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                z.h3(this.f6114a, view2, i11, (v5.q) obj);
            }
        });
        this.f6170x0.K(v5.q.class, sVar);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: hb.x
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                this.f6136a.j3(view2, i11, (v5.n) obj);
            }
        });
        this.f6170x0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f6170x0);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        x8.v3.a(e0Var, w7.u.Dc);
    }

    public final void j3(View view, int i10, v5.n nVar) {
        int iC = nVar.c();
        if (iC == 4) {
            nVar.j(!nVar.i());
            this.f6168v0.d0(nVar.i());
            this.f6167u0.F1(this.f6168v0);
            u9.n.e().w(true);
        } else if (iC == 1) {
            nVar.j(!nVar.i());
            this.f6167u0.q2(nVar.i());
        } else if (iC == 2) {
            nVar.j(!nVar.i());
            this.f6168v0.R(nVar.i());
            this.f6167u0.F1(this.f6168v0);
            u9.n.e().w(true);
        } else if (iC == 3) {
            nVar.j(!nVar.i());
            this.f6168v0.j0(nVar.i());
            this.f6167u0.F1(this.f6168v0);
            u9.n.e().w(true);
            if (nVar.i()) {
                com.tuyafeng.support.utils.n.k(G(), w7.u.ti, w7.u.ui);
            }
        } else if (iC == 5) {
            nVar.j(!nVar.i());
            this.f6168v0.c0(nVar.i());
            this.f6167u0.F1(this.f6168v0);
            u9.n.e().w(true);
        } else if (iC == 6) {
            k3();
        } else if (iC == 7) {
            nVar.j(!nVar.i());
            l3(!nVar.i());
        } else if (iC == 8) {
            nVar.j(!nVar.i());
            this.f6169w0.E(!nVar.i());
            this.f6167u0.Z(this.f6169w0);
        }
        this.f6170x0.m(i10);
    }

    public final void k3() {
        if (this.f6167u0.K2() != 0) {
            FragmentUtils.i(this, f4.class);
        } else {
            q5.k.l(G()).f0(w7.u.og).J(w7.u.f14157n8).x(w7.u.pg, false).O(true).X(R.string.ok, new q5.k.m() { // from class: hb.y
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    z.f3(this.f6149a, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        }
    }

    public final void l3(boolean z10) {
        this.f6169w0.B(z10);
        this.f6167u0.Z(this.f6169w0);
    }
}
