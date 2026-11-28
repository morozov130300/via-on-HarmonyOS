package hb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o5 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f6005u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6006v0;

    public static /* synthetic */ void g3(o5 o5Var, FragmentManager fragmentManager, String str, Bundle bundle) {
        o5Var.getClass();
        String string = bundle.getString("text", null);
        if (string != null) {
            o5Var.f6005u0.l2(string);
            u9.n.e().v(true);
        }
        fragmentManager.x("edit_text_result");
    }

    public static /* synthetic */ void h3(o5 o5Var, int i10) {
        o5Var.f6005u0.q1(i10);
        u9.n.e().v(true);
    }

    public static /* synthetic */ void i3(o5 o5Var, View view, int i10, v5.n nVar) {
        o5Var.getClass();
        boolean z10 = !nVar.i();
        nVar.j(z10);
        o5Var.f6006v0.m(i10);
        u9.a aVarV = o5Var.f6005u0.v();
        aVarV.G(z10);
        o5Var.f6005u0.Z(aVarV);
    }

    public static /* synthetic */ void j3(o5 o5Var, int i10) {
        o5Var.f6005u0.Z2(i10);
        u9.n.e().v(true);
    }

    public static List l3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, o5.class, w7.u.Fc, w7.u.Za);
        hVar.b(1, w7.u.f14132lb, new String[0]);
        hVar.b(2, w7.u.ed, "字号", "font size");
        hVar.b(3, w7.u.Z2, new String[0]);
        hVar.b(-10003, w7.u.f14080i1, new String[0]);
        return hVar.f();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f6005u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(1, X0(w7.u.f14132lb), X0(w7.u.f14160nb), X0(w7.u.f14146mb), this.f6005u0.v().o()));
        arrayList.add(new v5.l(X0(w7.u.f14080i1)));
        arrayList.add(new e8.g(this.f6005u0.c2()));
        arrayList.add(new ib.x(2, X0(w7.u.ed), "%dpx", x8.f.c(), this.f6005u0.a2(), 10, 30, 1, 17));
        arrayList.add(new v5.q(3, X0(w7.u.Z2)));
        t5.f fVar = new t5.f(arrayList);
        this.f6006v0 = fVar;
        fVar.K(v5.l.class, new v5.m());
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: hb.j5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                o5.i3(this.f5923a, view2, i10, (v5.n) obj);
            }
        });
        this.f6006v0.K(v5.n.class, pVar);
        ib.z zVar = new ib.z();
        zVar.q(new ib.z.b() { // from class: hb.k5
            @Override // ib.z.b
            public final void a(int i10) {
                o5.j3(this.f5939a, i10);
            }
        });
        this.f6006v0.K(ib.x.class, zVar);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: hb.l5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5952a.k3();
            }
        });
        this.f6006v0.K(v5.q.class, sVar);
        e8.j jVar = new e8.j();
        jVar.o(this.f6005u0.e());
        jVar.p(new e8.j.a() { // from class: hb.m5
            @Override // e8.j.a
            public final void a(int i10) {
                o5.h3(this.f5973a, i10);
            }
        });
        this.f6006v0.K(e8.g.class, jVar);
        this.f7946t0.setAdapter(this.f6006v0);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.Za);
    }

    public final void k3() {
        final FragmentManager fragmentManagerL0 = L0();
        fragmentManagerL0.z1("edit_text_result", this, new androidx.fragment.app.i0() { // from class: hb.n5
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                o5.g3(this.f5991a, fragmentManagerL0, str, bundle);
            }
        });
        FragmentUtils.j(this, k1.class, k1.g3(X0(w7.u.Z2), this.f6005u0.A0(), X0(w7.u.Z2), true));
    }
}
