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
public class r0 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public s0 f7834r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7835s0;

    public static /* synthetic */ void j3(r0 r0Var, View view, int i10, a6.q qVar) {
        r0Var.getClass();
        r0Var.q3(qVar.a());
    }

    public static /* synthetic */ void m3(r0 r0Var, boolean z10, View view, k.p pVar) {
        r0Var.getClass();
        r0Var.f7834r0.l(ba.c.f(pVar.f13339c[0]), !z10);
    }

    public static /* synthetic */ void n3(r0 r0Var, Boolean bool) {
        r0Var.getClass();
        r0Var.s3(r0Var.p3(bool.booleanValue(), r0Var.f7834r0.o()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3() {
        final boolean zM = this.f7834r0.m();
        w5.k.l(I()).d0(x7.u.f14216x0).J(zM ? Z0(x7.u.f14141r3) : Z0(x7.u.f14154s3)).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: jb.m0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                r0.m3(this.f7782a, zM, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    private List p3(boolean z10, kb.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.n(1, Z0(x7.u.T), z10));
        arrayList.add(new a6.e(2, Z0(x7.u.f14216x0), lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        if (aVar != null) {
            if (aVar.i() != null && !aVar.i().isEmpty()) {
                arrayList.add(new a6.l(Z0(x7.u.Y8)));
                for (String str : aVar.i()) {
                    arrayList.add(new a6.q(str.hashCode(), str));
                }
            }
            if (aVar.j() != null && !aVar.j().isEmpty()) {
                arrayList.add(new a6.l(Z0(z10 ? x7.u.f13938c9 : x7.u.I4)));
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
        w5.k.l(I()).e0(ba.c.e(str)).b0(new String[]{Z0(x7.u.f13938c9), Z0(x7.u.Y8)}, !this.f7834r0.q(str) ? 1 : 0, new AdapterView.OnItemClickListener() { // from class: jb.p0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f7813a.f7834r0.l(str, i10 == 0);
            }
        }).V(R.string.ok, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: jb.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7822a.f7834r0.s(str);
            }
        }).f0();
    }

    private void r3() {
        this.f7834r0.n().g(d1(), new androidx.lifecycle.m() { // from class: jb.n0
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                r0.n3(this.f7793a, (Boolean) obj);
            }
        });
        this.f7834r0.p().g(d1(), new androidx.lifecycle.m() { // from class: jb.o0
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                r0 r0Var = this.f7802a;
                r0Var.s3(r0Var.p3(r0Var.f7834r0.m(), (kb.a) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7835s0.H(), list));
        this.f7835s0.M(list);
        eVarB.c(this.f7835s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7835s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.j0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                r0.j3(this.f7743a, view2, i10, (a6.q) obj);
            }
        });
        this.f7835s0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: jb.k0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7753a.o3();
            }
        });
        this.f7835s0.K(a6.e.class, fVar);
        this.f7835s0.K(a6.l.class, new a6.m());
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: jb.l0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                a6.n nVar = (a6.n) obj;
                this.f7768a.f7834r0.t(!nVar.i());
            }
        });
        this.f7835s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f7835s0);
        r3();
        this.f7834r0.r();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.T));
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f7834r0 = (s0) new androidx.lifecycle.y(this, pa.r.n()).a(s0.class);
    }
}
