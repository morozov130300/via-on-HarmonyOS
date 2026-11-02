package hb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c8.lc;
import h6.a;
import hb.c8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import w5.k;
import z8.a4;
import z8.u0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public RecyclerView f6766m0;

    /* renamed from: n0, reason: collision with root package name */
    public u4.a f6767n0;

    /* renamed from: o0, reason: collision with root package name */
    public w9.l f6768o0;

    /* renamed from: p0, reason: collision with root package name */
    public aa.c f6769p0;

    /* renamed from: q0, reason: collision with root package name */
    public y5.f f6770q0;

    /* renamed from: r0, reason: collision with root package name */
    public List f6771r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f6772s0;

    public static /* synthetic */ void Y2(u uVar, View view, k.p pVar) {
        uVar.getClass();
        String str = pVar.f13339c[0];
        if (str.isEmpty()) {
            g6.n.q(uVar.I(), x7.u.f14129q4);
        } else {
            if (!z8.v0.g(str).equals(uVar.f6768o0.V1())) {
                g6.n.q(uVar.I(), x7.u.Uh);
                return;
            }
            uVar.l3();
            uVar.f6768o0.w(false);
            uVar.m3();
        }
    }

    public static /* synthetic */ void a3(u uVar, View view, k.p pVar) {
        uVar.f6768o0.w(false);
        uVar.m3();
    }

    public static /* synthetic */ void c3(u uVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i10 == i11) {
            uVar.getClass();
            return;
        }
        uVar.f6768o0.w(false);
        uVar.f6768o0.t1(i11);
        uVar.f6769p0 = uVar.f6768o0.y();
        uVar.m3();
    }

    public static /* synthetic */ void d3(u uVar, FragmentManager fragmentManager, Fragment fragment) {
        if (fragment instanceof c8) {
            uVar.q3((c8) fragment);
        } else {
            uVar.getClass();
        }
    }

    public static /* synthetic */ void e3(final u uVar, View view, k.p pVar) {
        final Map mapA = l9.d.a(uVar.f6768o0, pa.r.f(), pa.r.k(), uVar.f6767n0, lc.c().d(), pa.r.d(), true);
        mapA.put("name", uVar.f6768o0.R());
        mapA.put("psw", uVar.f6768o0.V1());
        if (!mapA.containsKey("bookmark") || ((String) mapA.get("bookmark")).length() <= 48000) {
            uVar.v3(mapA);
        } else {
            mapA.put("bookmark", null);
            g6.n.e(uVar.I(), x7.u.wh, x7.u.B1, new k.m() { // from class: hb.i
                @Override // w5.k.m
                public final void a(View view2, k.p pVar2) {
                    this.f6573a.v3(mapA);
                }
            });
        }
    }

    public static /* synthetic */ void f3(final u uVar, View view, k.p pVar) {
        String str = uVar.f6769p0.c() + "name=" + uVar.f6768o0.R() + "&psw=" + uVar.f6768o0.V1();
        z8.u0 u0Var = new z8.u0(uVar.I());
        u0Var.q(new u0.b() { // from class: hb.h
            @Override // z8.u0.b
            public final void a(String str2) {
                this.f6564a.s3(str2);
            }
        });
        u0Var.n(str);
    }

    public static /* synthetic */ void g3(mark.via.common.widget.v0 v0Var) {
        z8.r3.d(v0Var);
        z8.r3.h(v0Var);
    }

    public static /* synthetic */ void h3(u uVar, String str) {
        if (l9.d.b(uVar.f6768o0, pa.r.f(), pa.r.k(), uVar.f6767n0, lc.c().d(), pa.r.d(), str)) {
            lc.c().d().I();
        }
        uVar.t3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3(View view, int i10, a6.q qVar) {
        int iC = qVar.c();
        if ((iC == 2) || (iC == 1)) {
            o3();
            return;
        }
        if (iC == 4) {
            r3();
            return;
        }
        if (iC == 5) {
            u3();
            return;
        }
        if (iC == 6) {
            w5.k.l(I()).d0(x7.u.Z2).I(x7.u.f13918b3).h("", x7.u.f14033j6, 1).V(x7.u.f14166t2, new k.m() { // from class: hb.o
                @Override // w5.k.m
                public final void a(View view2, k.p pVar) {
                    u.Y2(this.f6684a, view2, pVar);
                }
            }).R(R.string.cancel, null).f0();
        } else if (iC == 3) {
            final int iE1 = this.f6768o0.e1();
            w5.k.l(I()).d0(x7.u.f14099o2).A(x7.u.f14053kc).Z(x7.j.f13644a, iE1, new AdapterView.OnItemClickListener() { // from class: hb.p
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                    u.c3(this.f6699a, iE1, adapterView, view2, i11, j10);
                }
            }).f0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) new h6.a(new mark.via.common.widget.v0(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: hb.n
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                u.g3((mark.via.common.widget.v0) obj);
            }
        }).l();
        this.f6766m0 = recyclerView;
        return recyclerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6769p0 = this.f6768o0.y();
        this.f6771r0 = new ArrayList();
        y5.f fVar = new y5.f(this.f6771r0);
        this.f6770q0 = fVar;
        fVar.K(a6.q.class, new a6.s(new y5.g() { // from class: hb.e
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6528a.p3(view2, i10, (a6.q) obj);
            }
        }));
        this.f6766m0.setLayoutManager(new LinearLayoutManager(I()));
        this.f6766m0.setItemAnimator(null);
        this.f6766m0.setAdapter(this.f6770q0);
        z8.h.b(new Runnable() { // from class: hb.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f6631e.t3();
            }
        });
        m3();
    }

    public final void k3(String str) {
        if (str.equalsIgnoreCase("0")) {
            this.f6768o0.w(true);
        } else if (str.equalsIgnoreCase("1")) {
            g6.n.q(I(), x7.u.Uh);
            this.f6768o0.w(false);
        } else if (str.equalsIgnoreCase("2")) {
            g6.n.q(I(), x7.u.Fc);
            this.f6768o0.w(true);
        } else {
            g6.n.q(I(), x7.u.f14113p2);
            this.f6768o0.w(false);
        }
        m3();
    }

    public final void l3() {
        HashMap map = new HashMap();
        map.put("name", this.f6768o0.R());
        map.put("psw", this.f6768o0.V1());
        map.put("op", "delete");
        z8.a4 a4Var = new z8.a4(I());
        a4Var.l(new a4.b() { // from class: hb.t
            @Override // z8.a4.b
            public final void a() {
                u uVar = this.f6751a;
                g6.n.m(uVar.l0(), uVar.I().getResources().getString(x7.u.Z2), uVar.I().getResources().getString(x7.u.f13932c3));
            }
        });
        a4Var.o(this.f6769p0.a(), map);
    }

    public final void m3() {
        this.f6771r0.clear();
        if (this.f6768o0.A()) {
            this.f6771r0.add(new a6.q(2, this.f6768o0.R()));
            this.f6771r0.add(new a6.q(4, Z0(x7.u.vh)));
            this.f6771r0.add(new a6.q(5, Z0(x7.u.wh)));
            this.f6771r0.add(new a6.q(6, Z0(x7.u.Z2), Z0(x7.u.f13904a3)));
        } else {
            this.f6771r0.add(new a6.q(1, Z0(x7.u.qh)));
        }
        this.f6771r0.add(new a6.q(3, Z0(x7.u.f14099o2), g6.e.c(I(), x7.j.f13644a, this.f6768o0.e1())));
        this.f6770q0.M(this.f6771r0);
        this.f6770q0.l();
    }

    public final void n3(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g6.n.q(I(), x7.u.f14142r4);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            g6.n.q(I(), x7.u.f14129q4);
            return;
        }
        this.f6768o0.L0(str);
        this.f6768o0.v2(str2);
        String str3 = this.f6769p0.d() + "name=" + str + "&psw=" + z8.v0.g(str2);
        z8.u0 u0Var = new z8.u0(I());
        u0Var.p(true);
        u0Var.q(new u0.b() { // from class: hb.f
            @Override // z8.u0.b
            public final void a(String str4) {
                this.f6539a.k3(str4);
            }
        });
        u0Var.n(str3);
    }

    public final void o3() {
        if (this.f6768o0.A()) {
            g6.n.g(I(), this.f6768o0.R(), T0().getString(x7.u.L7), new k.m() { // from class: hb.s
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    u.a3(this.f6737a, view, pVar);
                }
            });
        } else {
            c8.n3().h3(z0(), null);
        }
    }

    public final void q3(c8 c8Var) {
        c8Var.o3(new c8.c() { // from class: hb.q
            @Override // hb.c8.c
            public final void a(String str, String str2) {
                this.f6714a.n3(str, str2);
            }
        });
    }

    public final void r3() {
        g6.n.e(I(), x7.u.vh, x7.u.Cd, new k.m() { // from class: hb.g
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                u.f3(this.f6552a, view, pVar);
            }
        });
    }

    public final void s3(final String str) {
        if (str.isEmpty()) {
            g6.n.m(l0(), T0().getString(x7.u.vh), T0().getString(x7.u.f14113p2));
        } else {
            g6.n.m(l0(), Z0(x7.u.vh), T0().getString(x7.u.Kd));
            z8.h.b(new Runnable() { // from class: hb.k
                @Override // java.lang.Runnable
                public final void run() {
                    u.h3(this.f6619e, str);
                }
            });
        }
    }

    public final void t3() {
        Integer num = (Integer) pa.r.d().y("").get("");
        this.f6772s0 = num == null || num.intValue() <= 0;
    }

    public final void u3() {
        g6.n.e(I(), x7.u.wh, x7.u.mh, new k.m() { // from class: hb.r
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                u.e3(this.f6726a, view, pVar);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        pa.r.b(context).q(this);
        z0().l(new androidx.fragment.app.h0() { // from class: hb.m
            @Override // androidx.fragment.app.h0
            public final void k(FragmentManager fragmentManager, Fragment fragment) {
                u.d3(this.f6651e, fragmentManager, fragment);
            }
        });
    }

    public final void v3(Map map) {
        z8.a4 a4Var = new z8.a4(I());
        a4Var.l(new a4.b() { // from class: hb.j
            @Override // z8.a4.b
            public final void a() {
                u uVar = this.f6600a;
                g6.n.m(uVar.l0(), uVar.I().getResources().getString(x7.u.f14193v3), uVar.I().getResources().getString(x7.u.nh));
            }
        });
        a4Var.o(this.f6769p0.a(), map);
    }
}
