package jb;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y1 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public z1 f7933r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7934s0;

    public static /* synthetic */ void h3(y1 y1Var, View view, int i10, a6.q qVar) {
        y1Var.getClass();
        y1Var.q3(qVar.a());
    }

    public static /* synthetic */ void i3(y1 y1Var, Boolean bool) {
        y1Var.getClass();
        y1Var.s3(y1Var.p3(bool.booleanValue(), y1Var.f7933r0.n()));
    }

    public static /* synthetic */ void k3(y1 y1Var, boolean z10, View view, k.p pVar) {
        y1Var.getClass();
        y1Var.f7933r0.l(ba.c.f(pVar.f13339c[0]), !z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3() {
        final boolean zP = this.f7933r0.p();
        w5.k.l(I()).d0(x7.u.f14216x0).J(zP ? Z0(x7.u.f14104o7) : Z0(x7.u.f14090n7)).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: jb.x1
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                y1.k3(this.f7922a, zP, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    private List p3(boolean z10, kb.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.n(1, Z0(x7.u.f14076m7), Z0(z10 ? x7.u.f14118p7 : x7.u.f14204w1), z10));
        arrayList.add(new a6.e(2, Z0(x7.u.f14216x0), lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        if (aVar != null) {
            if (aVar.i() != null && !aVar.i().isEmpty()) {
                arrayList.add(new a6.l(Z0(x7.u.f14204w1)));
                for (String str : aVar.i()) {
                    arrayList.add(new a6.q(str.hashCode(), str));
                }
            }
            if (aVar.j() != null && !aVar.j().isEmpty()) {
                arrayList.add(new a6.l(Z0(z10 ? x7.u.Z0 : x7.u.I4)));
                for (String str2 : aVar.j()) {
                    arrayList.add(new a6.q(str2.hashCode(), str2));
                }
            }
        }
        return arrayList;
    }

    private void q3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        w5.k.l(I()).e0(ba.c.e(str)).b0(new String[]{Z0(x7.u.U0), Z0(x7.u.f14139r1)}, !this.f7933r0.q(str) ? 1 : 0, new AdapterView.OnItemClickListener() { // from class: jb.t1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f7865a.f7933r0.l(str, i10 == 0);
            }
        }).V(R.string.ok, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: jb.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7877a.f7933r0.s(str);
            }
        }).f0();
    }

    private void r3() {
        this.f7933r0.m().g(d1(), new androidx.lifecycle.m() { // from class: jb.v1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                y1.i3(this.f7897a, (Boolean) obj);
            }
        });
        this.f7933r0.o().g(d1(), new androidx.lifecycle.m() { // from class: jb.w1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                y1 y1Var = this.f7909a;
                y1Var.s3(y1Var.p3(y1Var.f7933r0.p(), (kb.a) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7934s0.H(), list));
        this.f7934s0.M(list);
        eVarB.c(this.f7934s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7934s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.q1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                y1.h3(this.f7824a, view2, i10, (a6.q) obj);
            }
        });
        this.f7934s0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: jb.r1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7836a.o3();
            }
        });
        this.f7934s0.K(a6.e.class, fVar);
        this.f7934s0.K(a6.l.class, new a6.m());
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: jb.s1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                a6.n nVar = (a6.n) obj;
                this.f7854a.f7933r0.t(!nVar.i());
            }
        });
        this.f7934s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f7934s0);
        r3();
        this.f7933r0.r();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.f14076m7));
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f7933r0 = (z1) new androidx.lifecycle.y(this, pa.r.n()).a(z1.class);
    }
}
