package jb;

import android.R;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u4 extends m8.f {
    public int A0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f6994u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public z9.d f6995v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t5.f f6996w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f6997x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f6998y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public y9.a f6999z0;

    public static /* synthetic */ void A3(u4 u4Var, View view) {
        u4Var.f6999z0.d0(0);
        u4Var.R3();
    }

    public static /* synthetic */ void B3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.N(0);
        } else if (i10 == 3) {
            u4Var.f6999z0.N(3);
        } else {
            u4Var.f6999z0.N(i10 != 2 ? 1 : 2);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void C3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.I();
        } else {
            u4Var.f6999z0.W(i10 == 1);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void D3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.L();
        } else {
            u4Var.f6999z0.Z(i10 == 1);
        }
        u4Var.R3();
    }

    private void R3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: jb.t4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                u4 u4Var = this.f6980c;
                return u4Var.F3(u4Var.f6999z0, u4Var.f6997x0);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: jb.w3
            @Override // u6.f
            public final void accept(Object obj) {
                this.f7022c.b4((List) obj);
            }
        }, new w7.e0());
    }

    public static Bundle U3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("domain", str);
        return bundle;
    }

    public static Bundle V3(String str, int i10) {
        Bundle bundle = new Bundle();
        bundle.putString("domain", str);
        bundle.putInt("flags", i10);
        return bundle;
    }

    private void W3() {
        int i10;
        Bundle bundle = new Bundle();
        y9.b bVarD = this.f6995v0.d(this.f6997x0, true);
        if ((bVarD != null || this.f6999z0.r()) && (bVarD == null || bVarD.equals(this.f6999z0))) {
            i10 = 0;
        } else {
            if (this.f6999z0.r()) {
                this.f6995v0.b(this.f6997x0);
            } else {
                this.f6995v0.k(this.f6997x0, this.f6999z0);
            }
            i10 = 1;
        }
        int i11 = (this.f6998y0 & 1) == 0 ? i10 : 1;
        if ((this.A0 & 2) != 0) {
            i11 |= 2;
        }
        if (i11 != 0) {
            bundle.putInt("changed", i11);
        }
        L0().y1("result", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X3(View view, int i10, v5.n nVar) {
        if (nVar.c() == 1) {
            this.f6999z0.S(true ^ nVar.i());
            R3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y3(View view, int i10, v5.q qVar) {
        switch (qVar.c()) {
            case 2:
                d4();
                break;
            case 3:
                J3();
                break;
            case 4:
                O3();
                break;
            case 5:
                E3();
                break;
            case 6:
                Q3();
                break;
            case 7:
                H3();
                break;
            case 8:
                P3();
                break;
            case 9:
                Z3();
                break;
            case 10:
                a4();
                break;
            case 11:
                T3();
                break;
            case 12:
                G3();
                break;
            case 13:
                S3();
                break;
            case 14:
                c4();
                break;
            case 15:
                N3();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b4(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f6996w0.H(), list));
        this.f6996w0.M(list);
        eVarB.c(this.f6996w0);
    }

    public static /* synthetic */ void f3(u4 u4Var, View view, q5.k.p pVar) {
        u4Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        u4Var.f6999z0.Q(pVar.f11819c[0].trim());
        u4Var.f6999z0.e0(-999);
        u4Var.R3();
    }

    public static /* synthetic */ void g3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.J();
        } else {
            u4Var.f6999z0.X(i10 != 2);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void i3(u4 u4Var, View view, q5.k.p pVar) {
        u4Var.getClass();
        x8.z.T();
        u4Var.f6999z0.E();
        u4Var.R3();
    }

    public static /* synthetic */ void j3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.K();
        } else {
            u4Var.f6999z0.Y(i10 == 1);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void k3(u4 u4Var, List list, AdapterView adapterView, View view, int i10, long j10) {
        u4Var.getClass();
        ga.c cVar = (ga.c) list.get(i10);
        if (cVar.d() == -999) {
            u4Var.I3();
            return;
        }
        if (cVar.d() == u4Var.f6999z0.j()) {
            return;
        }
        if (cVar.d() == -1000) {
            u4Var.f6999z0.e0(-1000);
            u4Var.R3();
        } else {
            u4Var.f6999z0.e0(cVar.d());
            u4Var.R3();
        }
    }

    public static /* synthetic */ void l3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.F();
        } else {
            u4Var.f6999z0.P(i10 == 1);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void n3(u4 u4Var, int i10, TextView textView, int i11, mark.via.common.widget.w0 w0Var) {
        u4Var.getClass();
        w0Var.setMax(30);
        x8.r3.h(w0Var);
        w0Var.setHighlightProgress((i10 - 50) / 5);
        w0Var.setMinimumHeight(com.tuyafeng.support.utils.x.h(u4Var.G(), 2.0f));
        w0Var.setOnSeekBarChangeListener(u4Var.new a(textView));
        w0Var.setProgress((i11 - 50) / 5);
    }

    public static /* synthetic */ void o3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.O(0);
        } else if (i10 == 3) {
            u4Var.f6999z0.O(3);
        } else {
            u4Var.f6999z0.O(i10 != 2 ? 1 : 2);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void q3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.c0(0);
        } else if (i10 == 3) {
            u4Var.f6999z0.c0(3);
        } else {
            u4Var.f6999z0.c0(i10 != 2 ? 1 : 2);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void s3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.a0(0);
        } else if (i10 == 3) {
            u4Var.f6999z0.a0(3);
        } else {
            u4Var.f6999z0.a0(i10 != 2 ? 1 : 2);
        }
        x8.z.T();
        u4Var.R3();
    }

    public static /* synthetic */ void t3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.b0(0);
        } else if (i10 == 3) {
            u4Var.f6999z0.b0(3);
        } else {
            u4Var.f6999z0.b0(i10 != 2 ? 1 : 2);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void u3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.G();
        } else {
            u4Var.f6999z0.R(i10 == 1);
        }
        u4Var.R3();
    }

    public static /* synthetic */ void v3(u4 u4Var, mark.via.common.widget.w0 w0Var, View view, q5.k.p pVar) {
        u4Var.getClass();
        u4Var.f6999z0.d0((w0Var.getProgress() * 5) + 50);
        u4Var.R3();
    }

    public static /* synthetic */ void y3(u4 u4Var, TextView textView) {
        u4Var.getClass();
        textView.setText(x8.f.c());
        textView.setGravity(17);
        textView.setTextSize(0, v8.h.r(u4Var.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(u4Var.G(), w7.k.f13732l));
    }

    public static /* synthetic */ void z3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f6999z0.D();
        } else {
            u4Var.f6999z0.M(i10 == 1);
        }
        u4Var.R3();
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        W3();
        super.B1();
    }

    public final void E3() {
        int i10;
        if (this.f6999z0.m()) {
            i10 = this.f6999z0.l(false) ? 1 : 2;
        } else {
            i10 = 0;
        }
        q5.k.l(G()).f0(w7.u.G1).d0(new String[]{M3(this.f6994u0.n2().g(), true), M3(true, false), M3(false, false)}, i10, new AdapterView.OnItemClickListener() { // from class: jb.r4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                u4.z3(this.f6955a, adapterView, view, i11, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final List F3(y9.b bVar, String str) {
        String strE4;
        String strL3;
        String strL4;
        String strL5;
        String strL6;
        u9.p pVarN2 = this.f6994u0.n2();
        ArrayList arrayList = new ArrayList();
        boolean zS = bVar.s();
        arrayList.add(new v5.n(1, Y0(w7.u.J4, str), zS));
        arrayList.add(new v5.l(X0(w7.u.f14025e2)));
        int i10 = bVar.i(this.f6994u0.H0());
        String strE5 = String.format(Locale.ROOT, "%d%%", Integer.valueOf(i10));
        if (i10 != bVar.i(0)) {
            strE5 = e4(strE5);
        }
        arrayList.add(new v5.q(14, X0(w7.u.ed), strE5, !zS));
        List<ga.c> listE = x8.c4.e(G());
        String strE6 = null;
        listE.add(ga.c.l(-999, bVar.c(null), null));
        int iO0 = bVar.j() == -1000 ? this.f6994u0.o0() : bVar.j();
        for (ga.c cVar : listE) {
            if (cVar.d() == iO0) {
                strE6 = cVar.g();
                break;
            }
        }
        if (bVar.j() == -1000 && strE6 != null) {
            strE6 = e4(strE6);
        }
        arrayList.add(new v5.q(2, X0(w7.u.F0), strE6, !zS));
        arrayList.add(new v5.q(3, X0(w7.u.U), M3(bVar.p(pVarN2.l()), !bVar.q()), !zS));
        if (bVar.y()) {
            strE4 = L3(bVar.x(false), false);
        } else {
            String strL7 = L3(pVarN2.q(), false);
            if (pVarN2.r()) {
                strL7 = X0(w7.u.P6);
            }
            strE4 = e4(strL7);
        }
        arrayList.add(new v5.q(4, X0(w7.u.K6), strE4, !zS));
        arrayList.add(new v5.q(6, X0(w7.u.f14306y7), L3(bVar.B(pVarN2.t()), !bVar.C()), !zS));
        arrayList.add(new v5.l(X0(w7.u.f14011d2)));
        arrayList.add(new v5.q(5, X0(w7.u.G1), M3(bVar.l(pVarN2.g()), !bVar.m()), !zS));
        arrayList.add(new v5.q(8, X0(w7.u.J), M3(bVar.z(pVarN2.s()), !bVar.A()), !zS));
        arrayList.add(new v5.l(X0(w7.u.f14039f2)));
        int iG = bVar.g();
        if (iG == 0) {
            char c10 = pVarN2.v() ? (char) 3 : (char) 2;
            String strL8 = L3(c10 != 2, false);
            if (c10 == 3) {
                strL8 = X0(w7.u.f14108k1);
            }
            strL3 = e4(strL8);
        } else if (iG == 3) {
            strL3 = X0(w7.u.f14108k1);
        } else {
            strL3 = L3(iG == 1, false);
        }
        arrayList.add(new v5.q(11, X0(w7.u.A8), strL3, !zS));
        int iA = bVar.a();
        if (iA == 0) {
            char c11 = pVarN2.i() ? (char) 3 : (char) 2;
            String strL9 = L3(c11 != 2, false);
            if (c11 == 3) {
                strL9 = X0(w7.u.f14108k1);
            }
            strL4 = e4(strL9);
        } else if (iA == 3) {
            strL4 = X0(w7.u.f14108k1);
        } else {
            strL4 = L3(iA == 1, false);
        }
        arrayList.add(new v5.q(12, X0(w7.u.S1), strL4, !zS));
        int iB = bVar.b();
        if (iB == 0) {
            int iE = pVarN2.e();
            String strL10 = L3(iE != 2, false);
            if (iE == 3) {
                strL10 = X0(w7.u.f14108k1);
            }
            strL5 = e4(strL10);
        } else if (iB == 3) {
            strL5 = X0(w7.u.f14108k1);
        } else {
            strL5 = L3(iB == 1, false);
        }
        arrayList.add(new v5.q(7, X0(w7.u.f14235t2), strL5, !zS));
        int iH = bVar.h();
        boolean z10 = iH == 0;
        if (z10) {
            iH = pVarN2.f();
        }
        String strL11 = L3(iH != 2, false);
        if (iH == 3) {
            strL11 = X0(w7.u.f14108k1);
        }
        if (z10) {
            strL11 = e4(strL11);
        }
        arrayList.add(new v5.q(9, X0(w7.u.f14256u9), strL11, !zS));
        boolean zO = bVar.o();
        String strL12 = bVar.n(pVarN2.k()) ? L3(true, false) : X0(w7.u.f14173oa);
        if (!zO) {
            strL12 = e4(strL12);
        }
        arrayList.add(new v5.q(10, X0(w7.u.f14103ja), strL12, !zS));
        int iF = bVar.f();
        if (iF == 0) {
            char c12 = pVarN2.u() ? (char) 3 : (char) 2;
            String strL13 = L3(c12 != 2, false);
            if (c12 == 3) {
                strL13 = X0(w7.u.f14108k1);
            }
            strL6 = e4(strL13);
        } else if (iF == 3) {
            strL6 = X0(w7.u.f14108k1);
        } else {
            strL6 = L3(iF == 1, false);
        }
        arrayList.add(new v5.q(13, X0(w7.u.S7), strL6, !zS));
        arrayList.add(new v5.l(X0(w7.u.Dc)));
        arrayList.add(new v5.q(15, X0(w7.u.Ra), M3(bVar.v(pVarN2.p()), !bVar.w()), !zS));
        return arrayList;
    }

    public final void G3() {
        char c10 = this.f6994u0.n2().i() ? (char) 3 : (char) 2;
        String strL3 = L3(c10 != 2, false);
        if (c10 == 3) {
            strL3 = X0(w7.u.f14108k1);
        }
        q5.k.l(G()).f0(w7.u.S1).d0(new String[]{e4(strL3), K3(true, false), K3(false, false), X0(w7.u.f14108k1)}, this.f6999z0.a(), new AdapterView.OnItemClickListener() { // from class: jb.k4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.B3(this.f6873a, adapterView, view, i10, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void H3() {
        int iE = this.f6994u0.n2().e();
        String strL3 = L3(iE != 2, false);
        if (iE == 3) {
            strL3 = X0(w7.u.f14108k1);
        }
        q5.k.l(G()).f0(w7.u.f14235t2).d0(new String[]{e4(strL3), K3(true, false), K3(false, false), X0(w7.u.f14108k1)}, this.f6999z0.b(), new AdapterView.OnItemClickListener() { // from class: jb.h4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.o3(this.f6832a, adapterView, view, i10, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void I3() {
        q5.k.l(G()).f0(w7.u.J0).v(false).i(this.f6999z0.c(null), X0(w7.u.F0), 3).X(R.string.ok, new q5.k.m() { // from class: jb.l4
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                u4.f3(this.f6886a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void J3() {
        int i10;
        if (this.f6999z0.q()) {
            i10 = this.f6999z0.p(false) ? 1 : 2;
        } else {
            i10 = 0;
        }
        q5.k.l(G()).f0(w7.u.U).d0(new String[]{M3(this.f6994u0.n2().l(), true), M3(true, false), M3(false, false)}, i10, new AdapterView.OnItemClickListener() { // from class: jb.n4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                u4.u3(this.f6910a, adapterView, view, i11, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final String K3(boolean z10, boolean z11) {
        if (z11) {
            return e4(L3(z10, false));
        }
        return z10 ? X0(w7.u.X0) : X0(w7.u.E1);
    }

    public final String L3(boolean z10, boolean z11) {
        if (z11) {
            return e4(L3(z10, false));
        }
        return z10 ? X0(w7.u.f13996c1) : X0(w7.u.J1);
    }

    public final String M3(boolean z10, boolean z11) {
        if (z11) {
            return e4(M3(z10, false));
        }
        return z10 ? X0(w7.u.f14158n9) : X0(w7.u.f14116k9);
    }

    public final void N3() {
        int i10;
        if (this.f6999z0.w()) {
            i10 = this.f6999z0.v(false) ? 1 : 2;
        } else {
            i10 = 0;
        }
        q5.k.l(G()).f0(w7.u.Ra).d0(new String[]{M3(this.f6994u0.n2().p(), true), M3(true, false), M3(false, false)}, i10, new AdapterView.OnItemClickListener() { // from class: jb.p4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                u4.C3(this.f6930a, adapterView, view, i11, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void O3() {
        int i10;
        if (this.f6999z0.y()) {
            i10 = this.f6999z0.x(false) ? 1 : 2;
        } else {
            i10 = 0;
        }
        u9.p pVarN2 = this.f6994u0.n2();
        String strL3 = L3(pVarN2.q(), false);
        if (pVarN2.r()) {
            strL3 = X0(w7.u.P6);
        }
        q5.k.l(G()).f0(w7.u.K6).d0(new String[]{e4(strL3), K3(true, false), K3(false, false)}, i10, new AdapterView.OnItemClickListener() { // from class: jb.z3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                u4.g3(this.f7060a, adapterView, view, i11, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void P3() {
        int i10;
        if (this.f6999z0.A()) {
            i10 = this.f6999z0.z(false) ? 1 : 2;
        } else {
            i10 = 0;
        }
        q5.k.l(G()).f0(w7.u.J).d0(new String[]{M3(this.f6994u0.n2().s(), true), M3(true, false), M3(false, false)}, i10, new AdapterView.OnItemClickListener() { // from class: jb.s4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                u4.j3(this.f6970a, adapterView, view, i11, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void Q3() {
        int i10;
        if (this.f6999z0.C()) {
            i10 = this.f6999z0.B(false) ? 1 : 2;
        } else {
            i10 = 0;
        }
        q5.k.l(G()).f0(w7.u.f14306y7).d0(new String[]{K3(this.f6994u0.n2().t(), true), K3(true, false), K3(false, false)}, i10, new AdapterView.OnItemClickListener() { // from class: jb.q4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                u4.D3(this.f6939a, adapterView, view, i11, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void S3() {
        char c10 = this.f6994u0.n2().u() ? (char) 3 : (char) 2;
        String strL3 = L3(c10 != 2, false);
        if (c10 == 3) {
            strL3 = X0(w7.u.f14108k1);
        }
        q5.k.l(G()).f0(w7.u.S7).d0(new String[]{e4(strL3), K3(true, false), K3(false, false), X0(w7.u.f14108k1)}, this.f6999z0.f(), new AdapterView.OnItemClickListener() { // from class: jb.i4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.s3(this.f6845a, adapterView, view, i10, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void T3() {
        char c10 = this.f6994u0.n2().v() ? (char) 3 : (char) 2;
        String strL3 = L3(c10 != 2, false);
        if (c10 == 3) {
            strL3 = X0(w7.u.f14108k1);
        }
        q5.k.l(G()).f0(w7.u.A8).d0(new String[]{e4(strL3), K3(true, false), K3(false, false), X0(w7.u.f14108k1)}, this.f6999z0.g(), new AdapterView.OnItemClickListener() { // from class: jb.o4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.t3(this.f6921a, adapterView, view, i10, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f6994u0 = la.s.j();
        this.f6995v0 = la.s.k();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        this.f6996w0 = fVar;
        fVar.K(v5.n.class, new v5.p(new t5.g() { // from class: jb.g4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6823a.X3(view2, i10, (v5.n) obj);
            }
        }));
        this.f6996w0.K(v5.q.class, new v5.s(new t5.g() { // from class: jb.m4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6900a.Y3(view2, i10, (v5.q) obj);
            }
        }));
        this.f6996w0.K(v5.l.class, new v5.m());
        this.f7946t0.setAdapter(this.f6996w0);
        this.f6997x0 = w0() != null ? w0().getString("domain", "www.example.com") : "www.example.com";
        this.f6998y0 = w0() != null ? w0().getInt("flags", 0) : 0;
        y9.a aVarH = this.f6995v0.h(this.f6997x0);
        this.f6999z0 = aVarH;
        if (aVarH.r() && (this.f6998y0 & 4) != 0) {
            this.f6999z0.S(true);
        }
        R3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.Xc);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(0, 0, null, X0(w7.u.Z)), new View.OnClickListener() { // from class: jb.v3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u4 u4Var = this.f7013a;
                q5.k.l(u4Var.G()).f0(w7.u.vg).K(u4Var.Y0(w7.u.f14255u8, u4Var.f6997x0)).X(w7.u.Z, new q5.k.m() { // from class: jb.x3
                    @Override // q5.k.m
                    public final void a(View view2, q5.k.p pVar) {
                        u4.i3(u4Var, view2, pVar);
                    }
                }).P(R.string.cancel, null).h0();
            }
        });
    }

    public final void Z3() {
        int iF = this.f6994u0.n2().f();
        String strL3 = L3(iF != 2, false);
        if (iF == 3) {
            strL3 = X0(w7.u.f14108k1);
        }
        q5.k.l(G()).f0(w7.u.f14256u9).d0(new String[]{e4(strL3), K3(true, false), K3(false, false), X0(w7.u.f14108k1)}, this.f6999z0.h(), new AdapterView.OnItemClickListener() { // from class: jb.j4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.q3(this.f6859a, adapterView, view, i10, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void a4() {
        int i10;
        if (this.f6999z0.o()) {
            i10 = this.f6999z0.n(true) ? 1 : 2;
        } else {
            i10 = 0;
        }
        q5.k.l(G()).f0(w7.u.f14103ja).d0(new String[]{e4(this.f6994u0.n2().k() ? L3(true, false) : X0(w7.u.f14173oa)), L3(true, false), X0(w7.u.f14173oa)}, i10, new AdapterView.OnItemClickListener() { // from class: jb.f4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                u4.l3(this.f6812a, adapterView, view, i11, j10);
            }
        }).X(R.string.ok, null).h0();
    }

    public final void c4() {
        if ((this.f6998y0 & 2) != 0) {
            this.A0 |= 2;
            i0().onBackPressed();
            return;
        }
        final int iH0 = this.f6994u0.H0();
        final int i10 = this.f6999z0.i(iH0);
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: jb.a4
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        final TextView textView = (TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(-1, -2)).r(1, 12, 16, 12, 16).n(1, 76).V(new b6.a.InterfaceC0033a() { // from class: jb.b4
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u4.y3(this.f6761a, (TextView) obj);
            }
        }).l();
        final mark.via.common.widget.w0 w0Var = (mark.via.common.widget.w0) new b6.a(new mark.via.common.widget.w0(new ContextThemeWrapper(i0(), w7.v.f14329f)), new LinearLayout.LayoutParams(-1, -2)).H(1, 16, 0, 16, 0).t(1, 16).V(new b6.a.InterfaceC0033a() { // from class: jb.c4
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u4.n3(this.f6770a, iH0, textView, i10, (mark.via.common.widget.w0) obj);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(w0Var);
        q5.k kVarP = q5.k.l(G()).z(linearLayout).X(R.string.ok, new q5.k.m() { // from class: jb.d4
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                u4.v3(this.f6787a, w0Var, view, pVar);
            }
        }).P(R.string.cancel, null);
        if (i10 == this.f6999z0.i(0)) {
            kVarP.T(w7.u.Z, new View.OnClickListener() { // from class: jb.e4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u4.A3(this.f6799a, view);
                }
            });
        }
        kVarP.h0();
    }

    public final void d4() {
        String strG;
        final List listE = x8.c4.e(G());
        int iO0 = this.f6994u0.o0();
        Iterator it = listE.iterator();
        while (true) {
            if (!it.hasNext()) {
                strG = "";
                break;
            }
            ga.c cVar = (ga.c) it.next();
            if (cVar.d() == iO0) {
                strG = cVar.g();
                break;
            }
        }
        listE.add(0, ga.c.l(-1000, e4(strG), null));
        listE.add(ga.c.l(-999, X0(w7.u.J0), this.f6999z0.c(null)));
        int size = listE.size();
        String[] strArr = new String[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((ga.c) listE.get(i11)).g();
            if (((ga.c) listE.get(i11)).d() == this.f6999z0.j()) {
                i10 = i11;
            }
        }
        q5.k.l(G()).f0(w7.u.F0).d0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: jb.y3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                u4.k3(this.f7046a, listE, adapterView, view, i12, j10);
            }
        }).h0();
    }

    public final String e4(String str) {
        return Y0(w7.u.f14096j3, str);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f7000a;

        public a(TextView textView) {
            this.f7000a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            double dZ = com.tuyafeng.support.utils.x.Z(seekBar.getContext(), 14.0f);
            double d10 = (i10 * 5) + 50;
            Double.isNaN(dZ);
            Double.isNaN(d10);
            this.f7000a.setTextSize(0, (int) ((dZ * d10) / 100.0d));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
