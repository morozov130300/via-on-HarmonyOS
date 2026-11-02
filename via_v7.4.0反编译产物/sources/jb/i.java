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
public class i extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public j f7726r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7727s0;

    public static /* synthetic */ void g3(i iVar, View view, int i10, a6.q qVar) {
        iVar.getClass();
        iVar.q3(qVar.a());
    }

    public static /* synthetic */ void h3(i iVar, Boolean bool) {
        iVar.getClass();
        iVar.s3(iVar.p3(bool.booleanValue(), iVar.f7726r0.n()));
    }

    public static /* synthetic */ void j3(i iVar, boolean z10, View view, k.p pVar) {
        iVar.getClass();
        iVar.f7726r0.l(ba.c.f(pVar.f13339c[0]), !z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7727s0.H(), list));
        this.f7727s0.M(list);
        eVarB.c(this.f7727s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7727s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.a
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                i.g3(this.f7638a, view2, i10, (a6.q) obj);
            }
        });
        this.f7727s0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: jb.b
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7645a.o3();
            }
        });
        this.f7727s0.K(a6.e.class, fVar);
        this.f7727s0.K(a6.l.class, new a6.m());
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: jb.c
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                a6.n nVar = (a6.n) obj;
                this.f7652a.f7726r0.t(!nVar.i());
            }
        });
        this.f7727s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f7727s0);
        r3();
        this.f7726r0.r();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.f14165t1));
    }

    public final void o3() {
        final boolean zP = this.f7726r0.p();
        w5.k.l(I()).d0(x7.u.f14216x0).J(zP ? Z0(x7.u.f14097o0) : Z0(x7.u.f14111p0)).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: jb.f
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                i.j3(this.f7690a, zP, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final List p3(boolean z10, kb.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.n(1, Z0(x7.u.f14165t1), z10));
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

    public final void q3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        w5.k.l(I()).e0(ba.c.e(str)).b0(new String[]{Z0(x7.u.f13938c9), Z0(x7.u.Y8)}, !this.f7726r0.q(str) ? 1 : 0, new AdapterView.OnItemClickListener() { // from class: jb.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f7664a.f7726r0.l(str, i10 == 0);
            }
        }).V(R.string.ok, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: jb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7679a.f7726r0.s(str);
            }
        }).f0();
    }

    public final void r3() {
        this.f7726r0.m().g(d1(), new androidx.lifecycle.m() { // from class: jb.g
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                i.h3(this.f7702a, (Boolean) obj);
            }
        });
        this.f7726r0.o().g(d1(), new androidx.lifecycle.m() { // from class: jb.h
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                i iVar = this.f7714a;
                iVar.s3(iVar.p3(iVar.f7726r0.p(), (kb.a) obj));
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f7726r0 = (j) new androidx.lifecycle.y(this, pa.r.n()).a(j.class);
    }
}
