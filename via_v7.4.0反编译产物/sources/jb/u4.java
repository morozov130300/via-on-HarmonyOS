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
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import h6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u4 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f7883r0;

    /* renamed from: s0, reason: collision with root package name */
    public ca.d f7884s0;

    /* renamed from: t0, reason: collision with root package name */
    public y5.f f7885t0;

    /* renamed from: u0, reason: collision with root package name */
    public String f7886u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f7887v0;

    /* renamed from: w0, reason: collision with root package name */
    public ba.a f7888w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f7889x0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f7890a;

        public a(TextView textView) {
            this.f7890a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            double dZ = g6.y.Z(seekBar.getContext(), 14.0f);
            Double.isNaN(dZ);
            Double.isNaN((i10 * 5) + 50);
            this.f7890a.setTextSize(0, (int) ((dZ * r3) / 100.0d));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public static /* synthetic */ void A3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.D();
        } else {
            u4Var.f7888w0.M(i10 == 1);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void B3(u4 u4Var, View view) {
        u4Var.f7888w0.d0(0);
        u4Var.S3();
    }

    public static /* synthetic */ void C3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.N(0);
        } else if (i10 == 3) {
            u4Var.f7888w0.N(3);
        } else {
            u4Var.f7888w0.N(i10 != 2 ? 1 : 2);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void D3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.I();
        } else {
            u4Var.f7888w0.W(i10 == 1);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void E3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.L();
        } else {
            u4Var.f7888w0.Z(i10 == 1);
        }
        u4Var.S3();
    }

    private void S3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: jb.t4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                u4 u4Var = this.f7869e;
                return u4Var.G3(u4Var.f7888w0, u4Var.f7886u0);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: jb.w3
            @Override // a7.e
            public final void accept(Object obj) {
                this.f7912e.c4((List) obj);
            }
        }, new x7.g0());
    }

    public static Bundle V3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("domain", str);
        return bundle;
    }

    public static Bundle W3(String str, int i10) {
        Bundle bundle = new Bundle();
        bundle.putString("domain", str);
        bundle.putInt("flags", i10);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y3(View view, int i10, a6.n nVar) {
        if (nVar.c() == 1) {
            this.f7888w0.S(true ^ nVar.i());
            S3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z3(View view, int i10, a6.q qVar) {
        switch (qVar.c()) {
            case 2:
                e4();
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                K3();
                break;
            case 4:
                P3();
                break;
            case 5:
                F3();
                break;
            case 6:
                R3();
                break;
            case 7:
                I3();
                break;
            case 8:
                Q3();
                break;
            case 9:
                a4();
                break;
            case 10:
                b4();
                break;
            case 11:
                U3();
                break;
            case 12:
                H3();
                break;
            case 13:
                T3();
                break;
            case 14:
                d4();
                break;
            case 15:
                O3();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c4(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7885t0.H(), list));
        this.f7885t0.M(list);
        eVarB.c(this.f7885t0);
    }

    public static /* synthetic */ void g3(u4 u4Var, View view, k.p pVar) {
        u4Var.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        u4Var.f7888w0.Q(pVar.f13339c[0].trim());
        u4Var.f7888w0.e0(-999);
        u4Var.S3();
    }

    public static /* synthetic */ void h3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.J();
        } else {
            u4Var.f7888w0.X(i10 != 2);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void j3(u4 u4Var, View view, k.p pVar) {
        u4Var.getClass();
        z8.b0.U();
        u4Var.f7888w0.E();
        u4Var.S3();
    }

    public static /* synthetic */ void k3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.K();
        } else {
            u4Var.f7888w0.Y(i10 == 1);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void l3(u4 u4Var, List list, AdapterView adapterView, View view, int i10, long j10) {
        u4Var.getClass();
        ja.c cVar = (ja.c) list.get(i10);
        if (cVar.d() == -999) {
            u4Var.J3();
            return;
        }
        if (cVar.d() == u4Var.f7888w0.j()) {
            return;
        }
        if (cVar.d() == -1000) {
            u4Var.f7888w0.e0(-1000);
            u4Var.S3();
        } else {
            u4Var.f7888w0.e0(cVar.d());
            u4Var.S3();
        }
    }

    public static /* synthetic */ void m3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.F();
        } else {
            u4Var.f7888w0.P(i10 == 1);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void o3(u4 u4Var, int i10, TextView textView, int i11, mark.via.common.widget.w0 w0Var) {
        u4Var.getClass();
        w0Var.setMax(30);
        z8.r3.g(w0Var);
        w0Var.setHighlightProgress((i10 - 50) / 5);
        w0Var.setMinimumHeight(g6.y.h(u4Var.I(), 2.0f));
        w0Var.setOnSeekBarChangeListener(u4Var.new a(textView));
        w0Var.setProgress((i11 - 50) / 5);
    }

    public static /* synthetic */ void p3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.O(0);
        } else if (i10 == 3) {
            u4Var.f7888w0.O(3);
        } else {
            u4Var.f7888w0.O(i10 != 2 ? 1 : 2);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void r3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.c0(0);
        } else if (i10 == 3) {
            u4Var.f7888w0.c0(3);
        } else {
            u4Var.f7888w0.c0(i10 != 2 ? 1 : 2);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void t3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.a0(0);
        } else if (i10 == 3) {
            u4Var.f7888w0.a0(3);
        } else {
            u4Var.f7888w0.a0(i10 != 2 ? 1 : 2);
        }
        z8.b0.U();
        u4Var.S3();
    }

    public static /* synthetic */ void u3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.b0(0);
        } else if (i10 == 3) {
            u4Var.f7888w0.b0(3);
        } else {
            u4Var.f7888w0.b0(i10 != 2 ? 1 : 2);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void v3(u4 u4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            u4Var.f7888w0.G();
        } else {
            u4Var.f7888w0.R(i10 == 1);
        }
        u4Var.S3();
    }

    public static /* synthetic */ void w3(u4 u4Var, mark.via.common.widget.w0 w0Var, View view, k.p pVar) {
        u4Var.getClass();
        u4Var.f7888w0.d0((w0Var.getProgress() * 5) + 50);
        u4Var.S3();
    }

    public static /* synthetic */ void z3(u4 u4Var, TextView textView) {
        u4Var.getClass();
        textView.setText(z8.f.c());
        textView.setGravity(17);
        textView.setTextSize(0, x8.h.s(u4Var.I()));
        textView.setTextColor(g6.e.a(u4Var.I(), x7.k.f13665k));
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        X3();
        super.D1();
    }

    public final void F3() {
        w5.k.l(I()).d0(x7.u.f14165t1).b0(new String[]{N3(this.f7883r0.m2().g(), true), N3(true, false), N3(false, false)}, this.f7888w0.m() ? this.f7888w0.l(false) ? 1 : 2 : 0, new AdapterView.OnItemClickListener() { // from class: jb.r4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.A3(this.f7844a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final List G3(ba.b bVar, String str) {
        String strF4;
        String strM3;
        String strM32;
        String strM33;
        String strM34;
        w9.p pVarM2 = this.f7883r0.m2();
        ArrayList arrayList = new ArrayList();
        boolean zS = bVar.s();
        arrayList.add(new a6.n(1, a1(x7.u.f14207w4, str), zS));
        arrayList.add(new a6.l(Z0(x7.u.R1)));
        int i10 = bVar.i(this.f7883r0.F0());
        String strF42 = String.format(Locale.ROOT, "%d%%", Integer.valueOf(i10));
        if (i10 != bVar.i(0)) {
            strF42 = f4(strF42);
        }
        arrayList.add(new a6.q(14, Z0(x7.u.Pc), strF42, !zS));
        List listE = z8.b4.e(I());
        String strF43 = null;
        listE.add(ja.c.l(-999, bVar.c(null), null));
        int iL0 = bVar.j() == -1000 ? this.f7883r0.l0() : bVar.j();
        Iterator it = listE.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ja.c cVar = (ja.c) it.next();
            if (cVar.d() == iL0) {
                strF43 = cVar.g();
                break;
            }
        }
        if (bVar.j() == -1000 && strF43 != null) {
            strF43 = f4(strF43);
        }
        arrayList.add(new a6.q(2, Z0(x7.u.C0), strF43, !zS));
        arrayList.add(new a6.q(3, Z0(x7.u.T), N3(bVar.p(pVarM2.l()), !bVar.q()), !zS));
        if (bVar.y()) {
            strF4 = M3(bVar.x(false), false);
        } else {
            String strM35 = M3(pVarM2.q(), false);
            if (pVarM2.r()) {
                strM35 = Z0(x7.u.D6);
            }
            strF4 = f4(strM35);
        }
        arrayList.add(new a6.q(4, Z0(x7.u.f14235y6), strF4, !zS));
        arrayList.add(new a6.q(6, Z0(x7.u.f14076m7), M3(bVar.B(pVarM2.t()), !bVar.C()), !zS));
        arrayList.add(new a6.l(Z0(x7.u.Q1)));
        arrayList.add(new a6.q(5, Z0(x7.u.f14165t1), N3(bVar.l(pVarM2.g()), !bVar.m()), !zS));
        arrayList.add(new a6.q(8, Z0(x7.u.I), N3(bVar.z(pVarM2.s()), !bVar.A()), !zS));
        arrayList.add(new a6.l(Z0(x7.u.S1)));
        int iG = bVar.g();
        if (iG == 0) {
            char c10 = pVarM2.v() ? (char) 3 : (char) 2;
            String strM36 = M3(c10 != 2, false);
            if (c10 == 3) {
                strM36 = Z0(x7.u.f14000h1);
            }
            strM3 = f4(strM36);
        } else if (iG == 3) {
            strM3 = Z0(x7.u.f14000h1);
        } else {
            strM3 = M3(iG == 1, false);
        }
        arrayList.add(new a6.q(11, Z0(x7.u.f14105o8), strM3, !zS));
        int iA = bVar.a();
        if (iA == 0) {
            char c11 = pVarM2.i() ? (char) 3 : (char) 2;
            String strM37 = M3(c11 != 2, false);
            if (c11 == 3) {
                strM37 = Z0(x7.u.f14000h1);
            }
            strM32 = f4(strM37);
        } else if (iA == 3) {
            strM32 = Z0(x7.u.f14000h1);
        } else {
            strM32 = M3(iA == 1, false);
        }
        arrayList.add(new a6.q(12, Z0(x7.u.F1), strM32, !zS));
        int iB = bVar.b();
        if (iB == 0) {
            int iE = pVarM2.e();
            String strM38 = M3(iE != 2, false);
            if (iE == 3) {
                strM38 = Z0(x7.u.f14000h1);
            }
            strM33 = f4(strM38);
        } else if (iB == 3) {
            strM33 = Z0(x7.u.f14000h1);
        } else {
            strM33 = M3(iB == 1, false);
        }
        arrayList.add(new a6.q(7, Z0(x7.u.f13987g2), strM33, !zS));
        int iH = bVar.h();
        boolean z10 = iH == 0;
        if (z10) {
            iH = pVarM2.f();
        }
        String strM39 = M3(iH != 2, false);
        if (iH == 3) {
            strM39 = Z0(x7.u.f14000h1);
        }
        if (z10) {
            strM39 = f4(strM39);
        }
        arrayList.add(new a6.q(9, Z0(x7.u.f14036j9), strM39, !zS));
        boolean zO = bVar.o();
        String strM310 = bVar.n(pVarM2.k()) ? M3(true, false) : Z0(x7.u.f13939ca);
        if (!zO) {
            strM310 = f4(strM310);
        }
        arrayList.add(new a6.q(10, Z0(x7.u.X9), strM310, !zS));
        int iF = bVar.f();
        if (iF == 0) {
            char c12 = pVarM2.u() ? (char) 3 : (char) 2;
            String strM311 = M3(c12 != 2, false);
            if (c12 == 3) {
                strM311 = Z0(x7.u.f14000h1);
            }
            strM34 = f4(strM311);
        } else if (iF == 3) {
            strM34 = Z0(x7.u.f14000h1);
        } else {
            strM34 = M3(iF == 1, false);
        }
        arrayList.add(new a6.q(13, Z0(x7.u.G7), strM34, !zS));
        arrayList.add(new a6.l(Z0(x7.u.f14123pc)));
        arrayList.add(new a6.q(15, Z0(x7.u.Fa), N3(bVar.v(pVarM2.p()), !bVar.w()), !zS));
        return arrayList;
    }

    public final void H3() {
        char c10 = this.f7883r0.m2().i() ? (char) 3 : (char) 2;
        String strM3 = M3(c10 != 2, false);
        if (c10 == 3) {
            strM3 = Z0(x7.u.f14000h1);
        }
        w5.k.l(I()).d0(x7.u.F1).b0(new String[]{f4(strM3), L3(true, false), L3(false, false), Z0(x7.u.f14000h1)}, this.f7888w0.a(), new AdapterView.OnItemClickListener() { // from class: jb.k4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.C3(this.f7762a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void I3() {
        int iE = this.f7883r0.m2().e();
        String strM3 = M3(iE != 2, false);
        if (iE == 3) {
            strM3 = Z0(x7.u.f14000h1);
        }
        w5.k.l(I()).d0(x7.u.f13987g2).b0(new String[]{f4(strM3), L3(true, false), L3(false, false), Z0(x7.u.f14000h1)}, this.f7888w0.b(), new AdapterView.OnItemClickListener() { // from class: jb.h4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.p3(this.f7721a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void J3() {
        w5.k.l(I()).d0(x7.u.G0).u(false).i(this.f7888w0.c(null), Z0(x7.u.C0), 3).V(R.string.ok, new k.m() { // from class: jb.l4
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                u4.g3(this.f7775a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void K3() {
        w5.k.l(I()).d0(x7.u.T).b0(new String[]{N3(this.f7883r0.m2().l(), true), N3(true, false), N3(false, false)}, this.f7888w0.q() ? this.f7888w0.p(false) ? 1 : 2 : 0, new AdapterView.OnItemClickListener() { // from class: jb.n4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.v3(this.f7799a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final String L3(boolean z10, boolean z11) {
        return z11 ? f4(M3(z10, false)) : z10 ? Z0(x7.u.U0) : Z0(x7.u.f14139r1);
    }

    public final String M3(boolean z10, boolean z11) {
        return z11 ? f4(M3(z10, false)) : z10 ? Z0(x7.u.Z0) : Z0(x7.u.f14204w1);
    }

    public final String N3(boolean z10, boolean z11) {
        return z11 ? f4(N3(z10, false)) : z10 ? Z0(x7.u.f13938c9) : Z0(x7.u.Y8);
    }

    public final void O3() {
        w5.k.l(I()).d0(x7.u.Fa).b0(new String[]{N3(this.f7883r0.m2().p(), true), N3(true, false), N3(false, false)}, this.f7888w0.w() ? this.f7888w0.v(false) ? 1 : 2 : 0, new AdapterView.OnItemClickListener() { // from class: jb.p4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.D3(this.f7819a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void P3() {
        int i10 = this.f7888w0.y() ? this.f7888w0.x(false) ? 1 : 2 : 0;
        w9.p pVarM2 = this.f7883r0.m2();
        String strM3 = M3(pVarM2.q(), false);
        if (pVarM2.r()) {
            strM3 = Z0(x7.u.D6);
        }
        w5.k.l(I()).d0(x7.u.f14235y6).b0(new String[]{f4(strM3), L3(true, false), L3(false, false)}, i10, new AdapterView.OnItemClickListener() { // from class: jb.z3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                u4.h3(this.f7950a, adapterView, view, i11, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void Q3() {
        w5.k.l(I()).d0(x7.u.I).b0(new String[]{N3(this.f7883r0.m2().s(), true), N3(true, false), N3(false, false)}, this.f7888w0.A() ? this.f7888w0.z(false) ? 1 : 2 : 0, new AdapterView.OnItemClickListener() { // from class: jb.s4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.k3(this.f7859a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void R3() {
        w5.k.l(I()).d0(x7.u.f14076m7).b0(new String[]{L3(this.f7883r0.m2().t(), true), L3(true, false), L3(false, false)}, this.f7888w0.C() ? this.f7888w0.B(false) ? 1 : 2 : 0, new AdapterView.OnItemClickListener() { // from class: jb.q4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.E3(this.f7828a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void T3() {
        char c10 = this.f7883r0.m2().u() ? (char) 3 : (char) 2;
        String strM3 = M3(c10 != 2, false);
        if (c10 == 3) {
            strM3 = Z0(x7.u.f14000h1);
        }
        w5.k.l(I()).d0(x7.u.G7).b0(new String[]{f4(strM3), L3(true, false), L3(false, false), Z0(x7.u.f14000h1)}, this.f7888w0.f(), new AdapterView.OnItemClickListener() { // from class: jb.i4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.t3(this.f7734a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void U3() {
        char c10 = this.f7883r0.m2().v() ? (char) 3 : (char) 2;
        String strM3 = M3(c10 != 2, false);
        if (c10 == 3) {
            strM3 = Z0(x7.u.f14000h1);
        }
        w5.k.l(I()).d0(x7.u.f14105o8).b0(new String[]{f4(strM3), L3(true, false), L3(false, false), Z0(x7.u.f14000h1)}, this.f7888w0.g(), new AdapterView.OnItemClickListener() { // from class: jb.o4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.u3(this.f7810a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f7883r0 = pa.r.j();
        this.f7884s0 = pa.r.k();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        y5.f fVar = new y5.f(Collections.EMPTY_LIST);
        this.f7885t0 = fVar;
        fVar.K(a6.n.class, new a6.p(new y5.g() { // from class: jb.g4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7712a.Y3(view2, i10, (a6.n) obj);
            }
        }));
        this.f7885t0.K(a6.q.class, new a6.s(new y5.g() { // from class: jb.m4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7789a.Z3(view2, i10, (a6.q) obj);
            }
        }));
        this.f7885t0.K(a6.l.class, new a6.m());
        this.f10459q0.setAdapter(this.f7885t0);
        this.f7886u0 = y0() != null ? y0().getString("domain", "www.example.com") : "www.example.com";
        this.f7887v0 = y0() != null ? y0().getInt("flags", 0) : 0;
        ba.a aVarI = this.f7884s0.i(this.f7886u0);
        this.f7888w0 = aVarI;
        if (aVarI.r() && (this.f7887v0 & 4) != 0) {
            this.f7888w0.S(true);
        }
        S3();
    }

    public final void X3() {
        int i10;
        Bundle bundle = new Bundle();
        ba.b bVarD = this.f7884s0.d(this.f7886u0, true);
        if ((bVarD != null || this.f7888w0.r()) && (bVarD == null || bVarD.equals(this.f7888w0))) {
            i10 = 0;
        } else {
            if (this.f7888w0.r()) {
                this.f7884s0.b(this.f7886u0);
            } else {
                this.f7884s0.g(this.f7886u0, this.f7888w0);
            }
            i10 = 1;
        }
        int i11 = (this.f7887v0 & 1) == 0 ? i10 : 1;
        if ((this.f7889x0 & 2) != 0) {
            i11 |= 2;
        }
        if (i11 != 0) {
            bundle.putInt("changed", i11);
        }
        N0().x1("result", bundle);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.Ic);
        zVar.c(new z.b(0, 0, null, Z0(x7.u.Y)), new View.OnClickListener() { // from class: jb.v3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u4 u4Var = this.f7903a;
                w5.k.l(u4Var.I()).d0(x7.u.fg).J(u4Var.a1(x7.u.f14021i8, u4Var.f7886u0)).V(x7.u.Y, new k.m() { // from class: jb.x3
                    @Override // w5.k.m
                    public final void a(View view2, k.p pVar) {
                        u4.j3(u4Var, view2, pVar);
                    }
                }).N(R.string.cancel, null).f0();
            }
        });
    }

    public final void a4() {
        int iF = this.f7883r0.m2().f();
        String strM3 = M3(iF != 2, false);
        if (iF == 3) {
            strM3 = Z0(x7.u.f14000h1);
        }
        w5.k.l(I()).d0(x7.u.f14036j9).b0(new String[]{f4(strM3), L3(true, false), L3(false, false), Z0(x7.u.f14000h1)}, this.f7888w0.h(), new AdapterView.OnItemClickListener() { // from class: jb.j4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.r3(this.f7748a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void b4() {
        w5.k.l(I()).d0(x7.u.X9).b0(new String[]{f4(this.f7883r0.m2().k() ? M3(true, false) : Z0(x7.u.f13939ca)), M3(true, false), Z0(x7.u.f13939ca)}, this.f7888w0.o() ? this.f7888w0.n(true) ? 1 : 2 : 0, new AdapterView.OnItemClickListener() { // from class: jb.f4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u4.m3(this.f7701a, adapterView, view, i10, j10);
            }
        }).V(R.string.ok, null).f0();
    }

    public final void d4() {
        if ((this.f7887v0 & 2) != 0) {
            this.f7889x0 |= 2;
            l0().onBackPressed();
            return;
        }
        final int iF0 = this.f7883r0.F0();
        final int i10 = this.f7888w0.i(iF0);
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: jb.a4
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        final TextView textView = (TextView) new h6.a(new TextView(I()), new LinearLayout.LayoutParams(-1, -2)).r(1, 12, 16, 12, 16).n(1, 76).V(new a.InterfaceC0076a() { // from class: jb.b4
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                u4.z3(this.f7650a, (TextView) obj);
            }
        }).l();
        final mark.via.common.widget.w0 w0Var = (mark.via.common.widget.w0) new h6.a(new mark.via.common.widget.w0(new ContextThemeWrapper(l0(), x7.v.f14259f)), new LinearLayout.LayoutParams(-1, -2)).H(1, 16, 0, 16, 0).t(1, 16).V(new a.InterfaceC0076a() { // from class: jb.c4
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                u4.o3(this.f7659a, iF0, textView, i10, (mark.via.common.widget.w0) obj);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(w0Var);
        w5.k kVarN = w5.k.l(I()).y(linearLayout).V(R.string.ok, new k.m() { // from class: jb.d4
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                u4.w3(this.f7676a, w0Var, view, pVar);
            }
        }).N(R.string.cancel, null);
        if (i10 == this.f7888w0.i(0)) {
            kVarN.R(x7.u.Y, new View.OnClickListener() { // from class: jb.e4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u4.B3(this.f7688a, view);
                }
            });
        }
        kVarN.f0();
    }

    public final void e4() {
        String strG;
        final List listE = z8.b4.e(I());
        int iL0 = this.f7883r0.l0();
        Iterator it = listE.iterator();
        while (true) {
            if (!it.hasNext()) {
                strG = "";
                break;
            }
            ja.c cVar = (ja.c) it.next();
            if (cVar.d() == iL0) {
                strG = cVar.g();
                break;
            }
        }
        listE.add(0, ja.c.l(-1000, f4(strG), null));
        listE.add(ja.c.l(-999, Z0(x7.u.G0), this.f7888w0.c(null)));
        int size = listE.size();
        String[] strArr = new String[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((ja.c) listE.get(i11)).g();
            if (((ja.c) listE.get(i11)).d() == this.f7888w0.j()) {
                i10 = i11;
            }
        }
        w5.k.l(I()).d0(x7.u.C0).b0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: jb.y3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                u4.l3(this.f7936a, listE, adapterView, view, i12, j10);
            }
        }).f0();
    }

    public final String f4(String str) {
        return a1(x7.u.X2, str);
    }
}
