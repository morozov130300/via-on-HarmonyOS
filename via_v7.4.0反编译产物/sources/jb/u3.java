package jb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u3 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f7881r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7882s0;

    public static /* synthetic */ void g3(u3 u3Var, View view, int i10, a6.n nVar) {
        u3Var.getClass();
        nVar.j(!nVar.i());
        nVar.h(u3Var.h3(nVar.i()));
        u3Var.f7882s0.m(i10);
        u3Var.j3(nVar.i());
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f7881r0 = pa.r.j();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        ArrayList arrayList = new ArrayList();
        boolean zI3 = i3();
        arrayList.add(new a6.n(1, Z0(x7.u.f14226xa), h3(zI3), zI3));
        this.f7882s0 = new y5.f(arrayList);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: jb.t3
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                u3.g3(this.f7868a, view2, i10, (a6.n) obj);
            }
        });
        this.f7882s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f7882s0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.f14226xa));
    }

    public final String h3(boolean z10) {
        return Z0(z10 ? x7.u.Z0 : x7.u.f14239ya);
    }

    public final boolean i3() {
        return !this.f7881r0.m2().h();
    }

    public final void j3(boolean z10) {
        w9.p pVarM2 = this.f7881r0.m2();
        pVarM2.J(!z10);
        this.f7881r0.g0(pVarM2);
    }
}
