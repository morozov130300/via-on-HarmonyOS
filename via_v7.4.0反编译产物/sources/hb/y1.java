package hb;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y1 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f6835r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6836s0;

    private List i3() {
        w9.d dVarS = this.f6835r0.s();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(2, Z0(x7.u.Tc)));
        if (Build.VERSION.SDK_INT >= 31) {
            arrayList.add(new a6.n(1, Z0(x7.u.f14217x1), Z0(x7.u.f14230y1), dVarS.e()));
        }
        if (z8.l3.f14720a) {
            arrayList.add(new a6.n(3, Z0(x7.u.yc), dVarS.g()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(a6.n nVar, int i10) {
        int iC = nVar.c();
        if (iC == 1) {
            w9.d dVarS = this.f6835r0.s();
            dVarS.h(true ^ nVar.i());
            this.f6835r0.u(dVarS);
            nVar.j(dVarS.e());
            this.f6836s0.m(i10);
            return;
        }
        if (iC == 3) {
            w9.d dVarS2 = this.f6835r0.s();
            dVarS2.j(true ^ nVar.i());
            this.f6835r0.u(dVarS2);
            nVar.j(dVarS2.g());
            this.f6836s0.m(i10);
            g6.n.q(I(), x7.u.zc);
        }
    }

    private void l3(List list) {
        y5.f fVar = this.f6836s0;
        if (fVar == null) {
            return;
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(fVar.H(), list));
        this.f6836s0.M(list);
        eVarB.c(this.f6836s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6835r0 = pa.r.j();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6836s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: hb.w1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6804a.k3((a6.q) obj);
            }
        });
        this.f6836s0.K(a6.q.class, sVar);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: hb.x1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6824a.j3((a6.n) obj, i10);
            }
        });
        this.f6836s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f6836s0);
        l3(i3());
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.R4));
    }

    public final void k3(a6.q qVar) {
        if (qVar.c() == 2) {
            g6.i.g(this, lb.k.class);
        }
    }
}
