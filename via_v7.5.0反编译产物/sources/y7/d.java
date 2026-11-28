package y7;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f14869u0 = false;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f14870v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public u4.a f14871w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public u9.l f14872x0;

    public static boolean i3() {
        return (x8.a0.f() || x8.f.h()) && p9.a.a().o();
    }

    public static List j3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, d.class, w7.u.Fc, w7.u.G1);
        hVar.b(1, w7.u.G1, new String[0]);
        hVar.b(2, w7.u.F4, new String[0]);
        hVar.b(3, w7.u.X2, new String[0]);
        hVar.b(4, w7.u.O5, new String[0]);
        if (i3()) {
            hVar.b(5, w7.u.f14000c5, new String[0]);
        }
        return hVar.f();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        if (this.f14869u0) {
            x8.h.b(new Runnable() { // from class: y7.a
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar = this.f14860c;
                    dVar.f14871w0.r(dVar.f14872x0.F0());
                }
            });
        }
        super.M1();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        ArrayList arrayList = new ArrayList();
        boolean zG = this.f14872x0.n2().g();
        boolean z10 = false;
        arrayList.add(new v5.n(1, X0(w7.u.G1), !zG ? X0(w7.u.M3) : Y0(w7.u.f14219s0, Integer.valueOf(this.f14872x0.H()), x8.z.w(G(), this.f14872x0.C2())), zG));
        arrayList.add(new v5.n(2, X0(w7.u.F4), X0(w7.u.G4), this.f14872x0.F0()));
        arrayList.add(new v5.q(3, X0(w7.u.X2), X0(w7.u.Y2)));
        arrayList.add(new v5.q(4, X0(w7.u.O5), X0(w7.u.P5)));
        boolean zO = p9.a.a().o();
        if (i3()) {
            String strX0 = X0(w7.u.f14000c5);
            String strX1 = X0(w7.u.f14014d5);
            if (zO && x8.j0.b()) {
                z10 = true;
            }
            v5.n nVar = new v5.n(5, strX0, strX1, z10);
            nVar.g(!zO);
            arrayList.add(nVar);
        }
        t5.f fVar = new t5.f(arrayList);
        this.f14870v0 = fVar;
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: y7.b
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f14862a.l3(view2, i10, (v5.q) obj);
            }
        }));
        this.f14870v0.K(v5.n.class, new v5.p(new t5.g() { // from class: y7.c
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f14865a.k3(view2, i10, (v5.n) obj);
            }
        }));
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(null);
        this.f7946t0.setAdapter(this.f14870v0);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.G1);
    }

    public final void k3(View view, int i10, v5.n nVar) {
        int iC = nVar.c();
        if (iC == 1) {
            u9.p pVarN2 = this.f14872x0.n2();
            nVar.j(!nVar.i());
            pVarN2.H(nVar.i());
            this.f14872x0.F1(pVarN2);
            u9.n.e().w(true);
            if (nVar.i()) {
                nVar.h(Y0(w7.u.f14219s0, Integer.valueOf(this.f14872x0.H()), x8.z.w(G(), this.f14872x0.C2())));
            } else {
                nVar.h(X0(w7.u.M3));
            }
            this.f14870v0.m(i10);
            return;
        }
        if (iC == 2) {
            this.f14869u0 = true;
            nVar.j(!nVar.i());
            this.f14872x0.m0(nVar.i());
            this.f14870v0.m(i10);
            return;
        }
        if (iC != 5) {
            return;
        }
        u9.a aVarV = this.f14872x0.v();
        nVar.j(!nVar.i());
        aVarV.w(nVar.i());
        this.f14872x0.Z(aVarV);
        x8.j0.c(aVarV.e(), false);
        this.f14870v0.m(i10);
    }

    public final void l3(View view, int i10, v5.q qVar) {
        int iC = qVar.c();
        if (iC == 3) {
            FragmentUtils.i(this, u.class);
        } else {
            if (iC != 4) {
                return;
            }
            FragmentUtils.i(this, t0.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).r(this);
    }
}
