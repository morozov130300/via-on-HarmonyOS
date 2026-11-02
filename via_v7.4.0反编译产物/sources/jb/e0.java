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
public class e0 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public f0 f7681r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7682s0;

    public static /* synthetic */ void h3(e0 e0Var, Integer num) {
        e0Var.getClass();
        e0Var.v3(e0Var.p3(num.intValue(), e0Var.f7681r0.p()));
    }

    public static /* synthetic */ void i3(e0 e0Var, View view, k.p pVar) {
        e0Var.getClass();
        e0Var.f7681r0.l(ba.c.f(pVar.f13339c[0]), pVar.f13338b ? 3 : e0Var.f7681r0.o() == 2 ? 1 : 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3() {
        w5.k kVarN = w5.k.l(I()).e0(Z0(x7.u.f14216x0)).J(Z0(this.f7681r0.o() != 2 ? x7.u.f14015i2 : x7.u.f14001h2)).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: jb.y
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                e0.i3(this.f7930a, view, pVar);
            }
        }).N(R.string.cancel, null);
        if (this.f7681r0.o() == 2) {
            kVarN.w(x7.u.f14000h1, false);
        }
        kVarN.f0();
    }

    private List p3(int i10, kb.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(1, Z0(x7.u.f13987g2), i10 == 3 ? Z0(x7.u.f14043k2) : Z0(i10 == 2 ? x7.u.f14057l2 : x7.u.f14029j2)));
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
                arrayList.add(new a6.l(Z0(this.f7681r0.o() != 2 ? x7.u.Z0 : x7.u.I4)));
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
        w5.k.l(I()).e0(ba.c.e(str)).b0(new String[]{Z0(x7.u.U0), Z0(x7.u.f14139r1), Z0(x7.u.f14000h1)}, t3(this.f7681r0.m(str)), new AdapterView.OnItemClickListener() { // from class: jb.c0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                e0 e0Var = this.f7653a;
                e0Var.f7681r0.l(str, e0Var.s3(i10));
            }
        }).V(R.string.ok, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: jb.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7666a.f7681r0.s(str);
            }
        }).f0();
    }

    private void r3() {
        this.f7681r0.n().g(d1(), new androidx.lifecycle.m() { // from class: jb.z
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                e0.h3(this.f7941a, (Integer) obj);
            }
        });
        this.f7681r0.q().g(d1(), new androidx.lifecycle.m() { // from class: jb.a0
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                e0 e0Var = this.f7639a;
                e0Var.v3(e0Var.p3(e0Var.f7681r0.o(), (kb.d) obj));
            }
        });
    }

    private int t3(int i10) {
        if (i10 != 2) {
            return i10 != 3 ? 0 : 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(View view, int i10, a6.q qVar) {
        if (qVar.c() != 1) {
            q3(qVar.a());
        } else {
            w5.k.l(I()).d0(x7.u.f13987g2).b0(new String[]{Z0(x7.u.U0), Z0(x7.u.f14139r1), Z0(x7.u.f14000h1)}, t3(this.f7681r0.o()), new AdapterView.OnItemClickListener() { // from class: jb.b0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                    e0 e0Var = this.f7646a;
                    e0Var.f7681r0.t(e0Var.s3(i11));
                }
            }).f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7682s0.H(), list));
        this.f7682s0.M(list);
        eVarB.c(this.f7682s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7682s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.w
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7907a.u3(view2, i10, (a6.q) obj);
            }
        });
        this.f7682s0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: jb.x
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7919a.o3();
            }
        });
        this.f7682s0.K(a6.e.class, fVar);
        this.f7682s0.K(a6.l.class, new a6.m());
        this.f10459q0.setAdapter(this.f7682s0);
        r3();
        this.f7681r0.r();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.f13987g2));
    }

    public final int s3(int i10) {
        if (i10 == 2) {
            return 3;
        }
        return i10 == 1 ? 2 : 1;
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f7681r0 = (f0) new androidx.lifecycle.y(this, pa.r.n()).a(f0.class);
    }
}
