package jb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i0 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f7728r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7729s0;

    public static /* synthetic */ void g3(i0 i0Var, View view, int i10, a6.n nVar) {
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
            i0Var.f7729s0.m(i10);
            i0Var.m3(nVar.i());
        }
    }

    private void k3() {
        ArrayList arrayList = new ArrayList();
        boolean zI3 = i3();
        arrayList.add(new a6.n(1, Z0(x7.u.f14244z2), h3(zI3), zI3));
        arrayList.add(new a6.n(2, Z0(x7.u.f14152s1), (String) null, j3(), !zI3));
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7729s0.H(), arrayList));
        this.f7729s0.M(arrayList);
        eVarB.c(this.f7729s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f7728r0 = pa.r.j();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7729s0 = new y5.f(Collections.EMPTY_LIST);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: jb.h0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                i0.g3(this.f7715a, view2, i10, (a6.n) obj);
            }
        });
        this.f7729s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f7729s0);
        k3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.f14244z2));
    }

    public final String h3(boolean z10) {
        return Z0(z10 ? x7.u.A2 : x7.u.f14204w1);
    }

    public final boolean i3() {
        return this.f7728r0.m2().j();
    }

    public final boolean j3() {
        return !this.f7728r0.m2().C();
    }

    public final void l3(boolean z10) {
        w9.p pVarM2 = this.f7728r0.m2();
        pVarM2.M(z10);
        this.f7728r0.g0(pVarM2);
        w9.n.e().y(true);
    }

    public final void m3(boolean z10) {
        w9.p pVarM2 = this.f7728r0.m2();
        pVarM2.h0(!z10);
        this.f7728r0.g0(pVarM2);
        w9.n.e().y(true);
    }
}
