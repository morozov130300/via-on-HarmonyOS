package hb;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import g8.j;
import ib.z;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o5 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f6692r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6693s0;

    public static /* synthetic */ void h3(o5 o5Var, FragmentManager fragmentManager, String str, Bundle bundle) {
        o5Var.getClass();
        String string = bundle.getString("text", null);
        if (string != null) {
            o5Var.f6692r0.k2(string);
            w9.n.e().x(true);
        }
        fragmentManager.x("edit_text_result");
    }

    public static /* synthetic */ void i3(o5 o5Var, int i10) {
        o5Var.f6692r0.p1(i10);
        w9.n.e().x(true);
    }

    public static /* synthetic */ void j3(o5 o5Var, View view, int i10, a6.n nVar) {
        o5Var.getClass();
        boolean z10 = !nVar.i();
        nVar.j(z10);
        o5Var.f6693s0.m(i10);
        w9.a aVarV = o5Var.f6692r0.v();
        aVarV.H(z10);
        o5Var.f6692r0.q0(aVarV);
    }

    public static /* synthetic */ void k3(o5 o5Var, int i10) {
        o5Var.f6692r0.W2(i10);
        w9.n.e().x(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        final FragmentManager fragmentManagerN0 = N0();
        fragmentManagerN0.y1("edit_text_result", this, new androidx.fragment.app.i0() { // from class: hb.n5
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                o5.h3(this.f6676a, fragmentManagerN0, str, bundle);
            }
        });
        g6.i.h(this, i1.class, i1.g3(Z0(x7.u.N2), this.f6692r0.y0(), Z0(x7.u.N2), true));
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6692r0 = pa.r.j();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.n(1, Z0(x7.u.Za), Z0(x7.u.f13926bb), Z0(x7.u.f13912ab), this.f6692r0.v().o()));
        arrayList.add(new a6.l(Z0(x7.u.f13972f1)));
        arrayList.add(new g8.g(this.f6692r0.b2()));
        arrayList.add(new ib.x(2, Z0(x7.u.Pc), "%dpx", z8.f.c(), this.f6692r0.Z1(), 10, 30, 1, 17));
        arrayList.add(new a6.q(3, Z0(x7.u.N2)));
        y5.f fVar = new y5.f(arrayList);
        this.f6693s0 = fVar;
        fVar.K(a6.l.class, new a6.m());
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: hb.j5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                o5.j3(this.f6616a, view2, i10, (a6.n) obj);
            }
        });
        this.f6693s0.K(a6.n.class, pVar);
        ib.z zVar = new ib.z();
        zVar.q(new z.b() { // from class: hb.k5
            @Override // ib.z.b
            public final void a(int i10) {
                o5.k3(this.f6628a, i10);
            }
        });
        this.f6693s0.K(ib.x.class, zVar);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: hb.l5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6643a.l3();
            }
        });
        this.f6693s0.K(a6.q.class, sVar);
        g8.j jVar = new g8.j();
        jVar.o(this.f6692r0.d());
        jVar.p(new j.a() { // from class: hb.m5
            @Override // g8.j.a
            public final void a(int i10) {
                o5.i3(this.f6659a, i10);
            }
        });
        this.f6693s0.K(g8.g.class, jVar);
        this.f10459q0.setAdapter(this.f6693s0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.Na);
    }
}
