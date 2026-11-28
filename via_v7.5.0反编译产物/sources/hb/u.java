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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mark.via.browser.kd;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public RecyclerView f6079o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public u4.a f6080p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public u9.l f6081q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public x9.c f6082r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public t5.f f6083s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public List f6084t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f6085u0;

    public static /* synthetic */ void W2(u uVar, View view, q5.k.p pVar) {
        uVar.getClass();
        String str = pVar.f11819c[0];
        if (str.isEmpty()) {
            com.tuyafeng.support.utils.n.q(uVar.G(), w7.u.D4);
        } else {
            if (!x8.v0.g(str).equals(uVar.f6081q0.W1())) {
                com.tuyafeng.support.utils.n.q(uVar.G(), w7.u.zi);
                return;
            }
            uVar.j3();
            uVar.f6081q0.w(false);
            uVar.l3();
        }
    }

    public static /* synthetic */ void Y2(u uVar, View view, q5.k.p pVar) {
        uVar.f6081q0.w(false);
        uVar.l3();
    }

    public static /* synthetic */ void a3(u uVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i10 == i11) {
            uVar.getClass();
            return;
        }
        uVar.f6081q0.w(false);
        uVar.f6081q0.u1(i11);
        uVar.f6082r0 = uVar.f6081q0.z();
        uVar.l3();
    }

    public static /* synthetic */ void b3(u uVar, FragmentManager fragmentManager, Fragment fragment) {
        if (fragment instanceof a8) {
            uVar.p3((a8) fragment);
        } else {
            uVar.getClass();
        }
    }

    public static /* synthetic */ void c3(final u uVar, View view, q5.k.p pVar) {
        final Map mapA = j9.d.a(uVar.f6081q0, la.s.f(), la.s.k(), uVar.f6080p0, kd.c().f(), la.s.d(), true);
        mapA.put("name", uVar.f6081q0.S());
        mapA.put("psw", uVar.f6081q0.W1());
        if (!mapA.containsKey("bookmark") || ((String) mapA.get("bookmark")).length() <= 48000) {
            uVar.u3(mapA);
        } else {
            mapA.put("bookmark", null);
            com.tuyafeng.support.utils.n.e(uVar.G(), w7.u.Wh, w7.u.O1, new q5.k.m() { // from class: hb.i
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar2) {
                    this.f5894a.u3(mapA);
                }
            });
        }
    }

    public static /* synthetic */ void d3(final u uVar, View view, q5.k.p pVar) {
        String str = uVar.f6082r0.c() + "name=" + uVar.f6081q0.S() + "&psw=" + uVar.f6081q0.W1();
        x8.u0 u0Var = new x8.u0(uVar.G());
        u0Var.q(new x8.u0.b() { // from class: hb.h
            @Override // x8.u0.b
            public final void a(String str2) {
                this.f5884a.r3(str2);
            }
        });
        u0Var.n(str);
    }

    public static /* synthetic */ void e3(mark.via.common.widget.v0 v0Var) {
        x8.r3.e(v0Var);
        x8.r3.i(v0Var);
    }

    public static /* synthetic */ void f3(u uVar, String str) {
        if (j9.d.b(uVar.f6081q0, la.s.f(), la.s.k(), uVar.f6080p0, kd.c().f(), la.s.d(), str)) {
            kd.c().f().I();
        }
        uVar.s3();
    }

    public static List k3(Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("settings_search_sync_mode", 0);
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, a7.class, bundle, w7.u.Fc, w7.u.Id, w7.u.Ec);
        if (la.s.j().B()) {
            hVar.c("mark.via.settings.AccountFragment.4", 4, w7.u.Vh, new String[0]);
            hVar.c("mark.via.settings.AccountFragment.5", 5, w7.u.Wh, new String[0]);
            hVar.c("mark.via.settings.AccountFragment.6", 6, w7.u.f14124l3, new String[0]);
        } else {
            hVar.c("mark.via.settings.AccountFragment.1", 1, w7.u.Ph, new String[0]);
        }
        hVar.c("mark.via.settings.AccountFragment.3", 3, w7.u.B2, new String[0]);
        return hVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3(View view, int i10, v5.q qVar) {
        int iC = qVar.c();
        if ((iC == 2) || (iC == 1)) {
            n3();
            return;
        }
        if (iC == 4) {
            q3();
            return;
        }
        if (iC == 5) {
            t3();
            return;
        }
        if (iC == 6) {
            q5.k.l(G()).f0(w7.u.f14124l3).J(w7.u.f14152n3).h("", w7.u.f14266v6, 1).X(w7.u.G2, new q5.k.m() { // from class: hb.n
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar) {
                    u.W2(this.f5976a, view2, pVar);
                }
            }).T(R.string.cancel, null).h0();
        } else if (iC == 3) {
            final int iG1 = this.f6081q0.g1();
            q5.k.l(G()).f0(w7.u.B2).B(w7.u.yc).b0(w7.j.f13710a, iG1, new AdapterView.OnItemClickListener() { // from class: hb.o
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                    u.a3(this.f5995a, iG1, adapterView, view2, i11, j10);
                }
            }).h0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) new b6.a(new mark.via.common.widget.v0(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: hb.q
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u.e3((mark.via.common.widget.v0) obj);
            }
        }).l();
        this.f6079o0 = recyclerView;
        return recyclerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f6082r0 = this.f6081q0.z();
        this.f6084t0 = new ArrayList();
        t5.f fVar = new t5.f(this.f6084t0);
        this.f6083s0 = fVar;
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: hb.e
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5848a.o3(view2, i10, (v5.q) obj);
            }
        }));
        this.f6079o0.setLayoutManager(new LinearLayoutManager(G()));
        this.f6079o0.setItemAnimator(null);
        this.f6079o0.setAdapter(this.f6083s0);
        SettingsSearchLocator.b(this, this.f6079o0);
        x8.h.b(new Runnable() { // from class: hb.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f5943c.s3();
            }
        });
        l3();
    }

    public final void i3(String str) {
        if (str.equalsIgnoreCase("0")) {
            this.f6081q0.w(true);
        } else if (str.equalsIgnoreCase("1")) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.zi);
            this.f6081q0.w(false);
        } else if (str.equalsIgnoreCase("2")) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.Uc);
            this.f6081q0.w(true);
        } else {
            com.tuyafeng.support.utils.n.q(G(), w7.u.C2);
            this.f6081q0.w(false);
        }
        l3();
    }

    public final void j3() {
        HashMap map = new HashMap();
        map.put("name", this.f6081q0.S());
        map.put("psw", this.f6081q0.W1());
        map.put("op", "delete");
        x8.b4 b4Var = new x8.b4(G());
        b4Var.l(new x8.b4.b() { // from class: hb.t
            @Override // x8.b4.b
            public final void a() {
                u uVar = this.f6067a;
                com.tuyafeng.support.utils.n.m(uVar.i0(), uVar.G().getResources().getString(w7.u.f14124l3), uVar.G().getResources().getString(w7.u.f14166o3));
            }
        });
        b4Var.o(this.f6082r0.a(), map);
    }

    public final void l3() {
        this.f6084t0.clear();
        if (this.f6081q0.B()) {
            this.f6084t0.add(new v5.q(2, this.f6081q0.S()));
            this.f6084t0.add(new v5.q(4, X0(w7.u.Vh)));
            this.f6084t0.add(new v5.q(5, X0(w7.u.Wh)));
            this.f6084t0.add(new v5.q(6, X0(w7.u.f14124l3), X0(w7.u.f14138m3)));
        } else {
            this.f6084t0.add(new v5.q(1, X0(w7.u.Ph)));
        }
        this.f6084t0.add(new v5.q(3, X0(w7.u.B2), com.tuyafeng.support.utils.e.c(G(), w7.j.f13710a, this.f6081q0.g1())));
        this.f6083s0.M(this.f6084t0);
        this.f6083s0.l();
    }

    public final void m3(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.E4);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.D4);
            return;
        }
        this.f6081q0.N0(str);
        this.f6081q0.w2(str2);
        String str3 = this.f6082r0.d() + "name=" + str + "&psw=" + x8.v0.g(str2);
        x8.u0 u0Var = new x8.u0(G());
        u0Var.p(true);
        u0Var.q(new x8.u0.b() { // from class: hb.f
            @Override // x8.u0.b
            public final void a(String str4) {
                this.f5860a.i3(str4);
            }
        });
        u0Var.n(str3);
    }

    public final void n3() {
        if (this.f6081q0.B()) {
            com.tuyafeng.support.utils.n.g(G(), this.f6081q0.S(), R0().getString(w7.u.X7), new q5.k.m() { // from class: hb.s
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    u.Y2(this.f6057a, view, pVar);
                }
            });
        } else {
            a8.n3().g3(x0(), null);
        }
    }

    public final void p3(a8 a8Var) {
        a8Var.o3(new a8.c() { // from class: hb.p
            @Override // hb.a8.c
            public final void a(String str, String str2) {
                this.f6017a.m3(str, str2);
            }
        });
    }

    public final void q3() {
        com.tuyafeng.support.utils.n.e(G(), w7.u.Vh, w7.u.Sd, new q5.k.m() { // from class: hb.g
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                u.d3(this.f5875a, view, pVar);
            }
        });
    }

    public final void r3(final String str) {
        if (str.isEmpty()) {
            com.tuyafeng.support.utils.n.m(i0(), R0().getString(w7.u.Vh), R0().getString(w7.u.C2));
        } else {
            com.tuyafeng.support.utils.n.m(i0(), X0(w7.u.Vh), R0().getString(w7.u.ae));
            x8.h.b(new Runnable() { // from class: hb.k
                @Override // java.lang.Runnable
                public final void run() {
                    u.f3(this.f5926c, str);
                }
            });
        }
    }

    public final void s3() {
        Integer num = (Integer) la.s.d().y("").get("");
        this.f6085u0 = num == null || num.intValue() <= 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).q(this);
        x0().l(new androidx.fragment.app.h0() { // from class: hb.m
            @Override // androidx.fragment.app.h0
            public final void V(FragmentManager fragmentManager, Fragment fragment) {
                u.b3(this.f5961c, fragmentManager, fragment);
            }
        });
    }

    public final void t3() {
        com.tuyafeng.support.utils.n.e(G(), w7.u.Wh, w7.u.Lh, new q5.k.m() { // from class: hb.r
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                u.c3(this.f6044a, view, pVar);
            }
        });
    }

    public final void u3(Map map) {
        x8.b4 b4Var = new x8.b4(G());
        b4Var.l(new x8.b4.b() { // from class: hb.j
            @Override // x8.b4.b
            public final void a() {
                u uVar = this.f5913a;
                com.tuyafeng.support.utils.n.m(uVar.i0(), uVar.G().getResources().getString(w7.u.I3), uVar.G().getResources().getString(w7.u.Mh));
            }
        });
        b4Var.o(this.f6082r0.a(), map);
    }
}
