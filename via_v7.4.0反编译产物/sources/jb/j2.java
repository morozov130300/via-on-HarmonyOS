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
public class j2 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public k2 f7745r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7746s0;

    public static /* synthetic */ void h3(j2 j2Var, Integer num) {
        j2Var.getClass();
        j2Var.v3(j2Var.p3(num.intValue(), j2Var.f7745r0.p()));
    }

    public static /* synthetic */ void m3(j2 j2Var, View view, k.p pVar) {
        j2Var.getClass();
        j2Var.f7745r0.l(ba.c.f(pVar.f13339c[0]), pVar.f13338b ? 3 : j2Var.f7745r0.m() == 2 ? 1 : 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3() {
        w5.k kVarN = w5.k.l(I()).e0(Z0(x7.u.f14216x0)).J(Z0(this.f7745r0.m() != 2 ? x7.u.I7 : x7.u.H7)).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: jb.e2
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                j2.m3(this.f7685a, view, pVar);
            }
        }).N(R.string.cancel, null);
        if (this.f7745r0.m() == 2) {
            kVarN.w(x7.u.f14000h1, false);
        }
        kVarN.f0();
    }

    private List p3(int i10, kb.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.g(1, Z0(x7.u.G7), i10 == 3 ? Z0(x7.u.J7) : Z0(x7.u.f14204w1), i10 == 3));
        arrayList.add(new a6.e(2, Z0(x7.u.f14216x0), lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        if (dVar != null) {
            List<String> listE = dVar.e(2);
            if (!listE.isEmpty()) {
                arrayList.add(new a6.l(Z0(x7.u.f14204w1)));
                for (String str : listE) {
                    arrayList.add(new a6.q(str.hashCode(), str));
                }
            }
            List<String> listE2 = dVar.e(3);
            List<String> listE3 = dVar.e(1);
            if (!listE2.isEmpty() || !listE3.isEmpty()) {
                arrayList.add(new a6.l(Z0(this.f7745r0.m() != 2 ? x7.u.Z0 : x7.u.I4)));
                for (String str2 : listE2) {
                    arrayList.add(new a6.q(str2.hashCode(), str2, Z0(x7.u.f14000h1)));
                }
                for (String str3 : listE3) {
                    arrayList.add(new a6.q(str3.hashCode(), str3));
                }
            }
        }
        return arrayList;
    }

    private void q3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        w5.k.l(I()).e0(ba.c.e(str)).b0(new String[]{Z0(x7.u.U0), Z0(x7.u.f14139r1), Z0(x7.u.f14000h1)}, t3(this.f7745r0.o(str)), new AdapterView.OnItemClickListener() { // from class: jb.h2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                j2 j2Var = this.f7717a;
                j2Var.f7745r0.l(str, j2Var.s3(i10));
            }
        }).V(R.string.ok, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: jb.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7731a.f7745r0.s(str);
            }
        }).f0();
    }

    private void r3() {
        this.f7745r0.n().g(d1(), new androidx.lifecycle.m() { // from class: jb.f2
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                j2.h3(this.f7698a, (Integer) obj);
            }
        });
        this.f7745r0.q().g(d1(), new androidx.lifecycle.m() { // from class: jb.g2
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                j2 j2Var = this.f7706a;
                j2Var.v3(j2Var.p3(j2Var.f7745r0.m(), (kb.d) obj));
            }
        });
    }

    private int s3(int i10) {
        if (i10 == 2) {
            return 3;
        }
        return i10 == 1 ? 2 : 1;
    }

    private int t3(int i10) {
        if (i10 != 2) {
            return i10 != 3 ? 0 : 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(View view, int i10, a6.q qVar) {
        q3(qVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7746s0.H(), list));
        this.f7746s0.M(list);
        eVarB.c(this.f7746s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        z8.b0.U();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7746s0 = new y5.f(Collections.EMPTY_LIST);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: jb.b2
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7648a.f7745r0.t(((a6.n) obj).i() ? 2 : 3);
            }
        });
        this.f7746s0.K(a6.n.class, pVar);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.c2
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7657a.u3(view2, i10, (a6.q) obj);
            }
        });
        this.f7746s0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: jb.d2
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7673a.o3();
            }
        });
        this.f7746s0.K(a6.e.class, fVar);
        this.f7746s0.K(a6.l.class, new a6.m());
        this.f10459q0.setAdapter(this.f7746s0);
        r3();
        this.f7745r0.r();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.G7));
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f7745r0 = (k2) new androidx.lifecycle.y(this, pa.r.n()).a(k2.class);
    }
}
