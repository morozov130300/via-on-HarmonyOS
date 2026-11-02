package jb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z5 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f7952r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7953s0;

    public static /* synthetic */ void g3(z5 z5Var, View view, int i10, a6.n nVar) {
        z5Var.getClass();
        nVar.j(!nVar.i());
        nVar.h(z5Var.h3(nVar.i()));
        z5Var.f7953s0.m(i10);
        z5Var.j3(nVar.i());
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f7952r0 = pa.r.j();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        ArrayList arrayList = new ArrayList();
        boolean zI3 = i3();
        arrayList.add(new a6.n(1, Z0(x7.u.Gh), h3(zI3), zI3));
        this.f7953s0 = new y5.f(arrayList);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: jb.y5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                z5.g3(this.f7940a, view2, i10, (a6.n) obj);
            }
        });
        this.f7953s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f7953s0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.Gh));
    }

    public final String h3(boolean z10) {
        return Z0(z10 ? x7.u.Hh : x7.u.E3);
    }

    public final boolean i3() {
        return this.f7952r0.m2().E();
    }

    public final void j3(boolean z10) {
        w9.p pVarM2 = this.f7952r0.m2();
        pVarM2.j0(z10);
        this.f7952r0.g0(pVarM2);
    }
}
