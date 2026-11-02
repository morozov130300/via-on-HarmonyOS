package jb;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import hb.y7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v5 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w5 f7905r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7906s0;

    public static /* synthetic */ void g3(v5 v5Var, String str, View view, k.p pVar) {
        v5Var.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        String str2 = pVar.f13339c[0];
        v5Var.f7905r0.l(str, ja.c.l(-999, str2, str2));
    }

    public static /* synthetic */ void k3(v5 v5Var, List list, String str, AdapterView adapterView, View view, int i10, long j10) {
        v5Var.getClass();
        if (((ja.c) list.get(i10)).d() == -999) {
            v5Var.q3(str);
        } else {
            v5Var.f7905r0.l(str, (ja.c) list.get(i10));
        }
    }

    public static /* synthetic */ void l3(v5 v5Var, View view, k.p pVar) {
        v5Var.getClass();
        v5Var.r3(ba.c.f(pVar.f13339c[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3() {
        w5.k.l(I()).d0(x7.u.f14216x0).I(x7.u.D0).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: jb.p5
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                v5.l3(this.f7820a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    private void r3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ja.c cVarQ = this.f7905r0.q(str);
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(z8.b4.b(I()));
        arrayList.addAll(this.f7905r0.m());
        arrayList.add(ja.c.l(-999, Z0(x7.u.G0), null));
        int size = arrayList.size();
        String[] strArr = new String[size];
        int i10 = -1;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((ja.c) arrayList.get(i11)).g();
            if (cVarQ.d() == ((ja.c) arrayList.get(i11)).d()) {
                i10 = i11;
            }
        }
        w5.k.l(I()).e0(ba.c.e(str)).b0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: jb.q5
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                v5.k3(this.f7829a, arrayList, str, adapterView, view, i12, j10);
            }
        }).V(R.string.ok, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: jb.r5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7845a.f7905r0.u(str);
            }
        }).f0();
    }

    private void s3() {
        this.f7905r0.s().g(d1(), new androidx.lifecycle.m() { // from class: jb.s5
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                v5 v5Var = this.f7860a;
                v5Var.v3(v5Var.p3((ja.c) obj, v5Var.f7905r0.o()));
            }
        });
        this.f7905r0.p().g(d1(), new androidx.lifecycle.m() { // from class: jb.t5
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                v5 v5Var = this.f7870a;
                v5Var.v3(v5Var.p3(v5Var.f7905r0.n(), (List) obj));
            }
        });
    }

    private void t3() {
        this.f7905r0.t(z8.b4.b(I()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(View view, int i10, a6.q qVar) {
        if (qVar.c() != 1) {
            r3(qVar.a());
        } else {
            g6.i.g(this, y7.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7906s0.H(), list));
        this.f7906s0.M(list);
        eVarB.c(this.f7906s0);
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(boolean z10) {
        super.I1(z10);
        if (z10) {
            return;
        }
        t3();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7906s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.n5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7800a.u3(view2, i10, (a6.q) obj);
            }
        });
        this.f7906s0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: jb.o5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7811a.o3();
            }
        });
        this.f7906s0.K(a6.e.class, fVar);
        this.f7906s0.K(a6.l.class, new a6.m());
        this.f10459q0.setAdapter(this.f7906s0);
        s3();
        t3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.C0));
    }

    public final List p3(ja.c cVar, List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(1, Z0(x7.u.C0), cVar == null ? null : cVar.g()));
        arrayList.add(new a6.e(2, Z0(x7.u.f14216x0), lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        if (list != null && !list.isEmpty()) {
            arrayList.add(new a6.l(Z0(x7.u.I4)));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                kb.b bVar = (kb.b) it.next();
                arrayList.add(new a6.q(bVar.hashCode(), bVar.f(), bVar.d()));
            }
        }
        return arrayList;
    }

    public final void q3(final String str) {
        ja.c cVarR = this.f7905r0.r(str, null);
        w5.k.l(I()).d0(x7.u.G0).u(false).i(cVarR == null ? null : cVarR.a(), Z0(x7.u.C0), 3).V(R.string.ok, new k.m() { // from class: jb.u5
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                v5.g3(this.f7892a, str, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f7905r0 = (w5) new androidx.lifecycle.y(this, pa.r.n()).a(w5.class);
    }
}
