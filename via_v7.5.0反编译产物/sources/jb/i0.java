package jb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i0 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f6839u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6840v0;

    public static /* synthetic */ void f3(i0 i0Var, View view, int i10, v5.n nVar) {
        i0Var.getClass();
        int iC = nVar.c();
        if (iC == 1) {
            i0Var.l3(!nVar.i());
            i0Var.k3();
        } else {
            if (iC != 2) {
                return;
            }
            nVar.j(!nVar.i());
            i0Var.f6840v0.m(i10);
            i0Var.m3(nVar.i());
        }
    }

    public static List h3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, i0.class, w7.u.Fc, w7.u.Xc, w7.u.L2);
        hVar.b(1, w7.u.L2, new String[0]);
        hVar.b(2, w7.u.F1, new String[0]);
        return hVar.f();
    }

    private void k3() {
        ArrayList arrayList = new ArrayList();
        boolean zI3 = i3();
        arrayList.add(new v5.n(1, X0(w7.u.L2), g3(zI3), zI3));
        arrayList.add(new v5.n(2, X0(w7.u.F1), (String) null, j3(), !zI3));
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f6840v0.H(), arrayList));
        this.f6840v0.M(arrayList);
        eVarB.c(this.f6840v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f6839u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6840v0 = new t5.f(Collections.EMPTY_LIST);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: jb.h0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                i0.f3(this.f6826a, view2, i10, (v5.n) obj);
            }
        });
        this.f6840v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f6840v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        k3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.L2));
    }

    public final String g3(boolean z10) {
        return X0(z10 ? w7.u.M2 : w7.u.J1);
    }

    public final boolean i3() {
        return this.f6839u0.n2().j();
    }

    public final boolean j3() {
        return !this.f6839u0.n2().B();
    }

    public final void l3(boolean z10) {
        u9.p pVarN2 = this.f6839u0.n2();
        pVarN2.L(z10);
        this.f6839u0.F1(pVarN2);
        u9.n.e().w(true);
    }

    public final void m3(boolean z10) {
        u9.p pVarN2 = this.f6839u0.n2();
        pVarN2.f0(!z10);
        this.f6839u0.F1(pVarN2);
        u9.n.e().w(true);
    }
}
