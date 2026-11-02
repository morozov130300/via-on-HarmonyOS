package i8;

import android.R;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c8.lc;
import h6.a;
import i6.i0;
import i8.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import mark.via.common.widget.m1;
import org.simpleframework.xml.strategy.Name;
import z8.n3;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends k8.a {
    public RecyclerView H0;
    public m1 I0;
    public View J0;
    public View K0;
    public y5.f L0;
    public w9.l M0;
    public int P0;
    public int C0 = -1;
    public int D0 = 80;
    public final List E0 = new ArrayList();
    public String F0 = null;
    public String G0 = null;
    public int N0 = 0;
    public int O0 = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.d {
        public a() {
        }

        @Override // i8.a.d
        public void a(int i10) {
            double d10 = i10;
            double d11 = k.this.P0 * 5;
            Double.isNaN(d10);
            Double.isNaN(d11);
            k.this.I0.setCurrentIndex((int) Math.ceil(d10 / d11));
        }

        @Override // i8.a.d
        public void b(int i10) {
            double d10 = i10;
            double d11 = k.this.P0 * 5;
            Double.isNaN(d10);
            Double.isNaN(d11);
            k.this.I0.setCurrentIndex((int) Math.ceil(d10 / d11));
        }
    }

    public static /* synthetic */ void l3(k kVar, ImageView imageView) {
        imageView.setImageDrawable(lb.b.a(kVar.I(), x7.o.L, x7.u.Xd));
        imageView.setContentDescription(kVar.Z0(x7.u.N4));
        r3.m(imageView);
    }

    public static /* synthetic */ void m3(k kVar, View view, int i10, h8.a aVar) {
        kVar.getClass();
        if (aVar.c() != 9) {
            kVar.N0 = aVar.c();
            kVar.O0 = (aVar.e() ? 0 : 4) | 1 | (aVar.f() ? 8 : 0);
            kVar.X2();
            return;
        }
        int iB2 = kVar.H0.getLayoutManager() instanceof GridLayoutManager ? ((GridLayoutManager) kVar.H0.getLayoutManager()).b2() : -1;
        if (iB2 == -1 || kVar.L0.g() <= kVar.P0 * 5) {
            return;
        }
        int currentIndex = kVar.I0.getCurrentIndex() + 1;
        int i11 = iB2 + (kVar.P0 * 5);
        if (i11 >= kVar.L0.g()) {
            i11 = 0;
            currentIndex = 0;
        }
        kVar.H0.p1(i11);
        kVar.I0.setCurrentIndex(currentIndex);
        if (kVar.Z2() == null || kVar.Z2().getWindow() == null) {
            return;
        }
        g6.y.B(kVar.Z2().getWindow().getDecorView(), (kVar.D0 & 80) == 80);
    }

    public static /* synthetic */ boolean n3(k kVar, View view, int i10, h8.a aVar) {
        kVar.getClass();
        kVar.N0 = aVar.c();
        kVar.O0 = (aVar.e() ? 0 : 4) | 2 | (aVar.f() ? 8 : 0);
        kVar.X2();
        return true;
    }

    public static /* synthetic */ void o3(k kVar, ImageView imageView) {
        imageView.setImageDrawable(lb.b.a(kVar.I(), x7.o.G0, x7.u.bf));
        imageView.setContentDescription(kVar.Z0(R.string.cancel));
        r3.m(imageView);
    }

    public static /* synthetic */ void p3(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int width = view.getWidth() % 5;
        if (view.getPaddingEnd() != width) {
            view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), width, view.getPaddingBottom());
        }
    }

    public static /* synthetic */ void r3(k kVar, View view) {
        kVar.N0 = 21;
        kVar.O0 = 1;
        kVar.X2();
    }

    public static k y3(String str, String str2, int i10, int i11) {
        Bundle bundle = new Bundle();
        k kVar = new k();
        bundle.putString("title", str2);
        bundle.putString("url", str);
        bundle.putInt("width", i10);
        bundle.putInt("gravity", i11);
        kVar.H2(bundle);
        return kVar;
    }

    private void z3() {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, this.N0);
        bundle.putInt("flags", this.O0);
        N0().x1("menu_result", bundle);
    }

    public void A3(int i10) {
        int iW3 = w3(36);
        if (iW3 < 0) {
            return;
        }
        h8.a aVar = (h8.a) this.E0.get(iW3);
        if (aVar.e()) {
            aVar.j(i10 == 3);
            this.L0.m(iW3);
        }
    }

    public final void B3(int i10, int i11) {
        List listU3 = u3(this.E0, i10, i11);
        this.E0.clear();
        this.E0.addAll(listU3);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z10 = (this.D0 & 48) == 48;
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: i8.b
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        this.H0 = (RecyclerView) new h6.a(new RecyclerView(I()), new FrameLayout.LayoutParams(-1, -1)).B(1, 12).l();
        this.I0 = (m1) new h6.a(new m1(I()), new LinearLayout.LayoutParams(-2, -2)).p(81).B(1, z10 ? 4 : 2).t(1, z10 ? 2 : 4).l();
        LinearLayout linearLayout2 = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, g6.f.d(I(), x7.n.f13683b))).p(80).V(new a.InterfaceC0076a() { // from class: i8.c
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        Space space = (Space) new h6.a(new Space(I()), new LinearLayout.LayoutParams(0, -2)).W(3.0f).l();
        this.J0 = new h6.a(new ImageView(I()), new LinearLayout.LayoutParams(0, -1)).W(1.0f).E(g6.f.d(I(), x7.n.f13682a)).d(x7.o.f13720e).V(new a.InterfaceC0076a() { // from class: i8.d
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k.l3(this.f7068a, (ImageView) obj);
            }
        }).l();
        this.K0 = new h6.a(new ImageView(I()), new LinearLayout.LayoutParams(0, -1)).W(1.0f).E(g6.f.d(I(), x7.n.f13682a)).d(x7.o.f13720e).V(new a.InterfaceC0076a() { // from class: i8.e
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k.o3(this.f7069a, (ImageView) obj);
            }
        }).l();
        linearLayout2.addView(space);
        linearLayout2.addView(this.J0);
        linearLayout2.addView(this.K0);
        if (!z10) {
            linearLayout.addView(this.H0);
            linearLayout.addView(this.I0);
            linearLayout.addView(linearLayout2);
            return linearLayout;
        }
        linearLayout.addView(linearLayout2);
        linearLayout.addView(this.I0);
        linearLayout.addView(this.H0);
        this.K0.setRotation(180.0f);
        return linearLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        z3();
        super.D1();
    }

    @Override // k8.a, androidx.fragment.app.Fragment
    public void T1() {
        Window window;
        super.T1();
        Dialog dialogZ2 = Z2();
        if (dialogZ2 == null || (window = dialogZ2.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = this.C0;
        attributes.height = -2;
        int i10 = this.D0;
        attributes.gravity = i10;
        attributes.dimAmount = 0.2f;
        attributes.windowAnimations = (i10 & 48) == 48 ? x7.v.f14258e : x7.v.f14257d;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.K0.setOnClickListener(new View.OnClickListener() { // from class: i8.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7070a.X2();
            }
        });
        this.J0.setOnClickListener(new View.OnClickListener() { // from class: i8.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k.r3(this.f7071a, view2);
            }
        });
        this.M0 = pa.r.j();
        x3();
        int i10 = this.E0.size() > 5 ? 2 : 1;
        this.P0 = i10;
        B3(5, i10);
        this.H0.setLayoutManager(new GridLayoutManager(I(), this.P0, 0, false));
        this.H0.setItemAnimator(null);
        this.H0.setHasFixedSize(true);
        r3.d(this.H0);
        this.L0 = new y5.f(this.E0);
        h8.c cVar = new h8.c();
        cVar.j(new y5.g() { // from class: i8.h
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                k.m3(this.f7072a, view2, i11, (h8.a) obj);
            }
        });
        cVar.k(new y5.h() { // from class: i8.i
            @Override // y5.h
            public final boolean a(View view2, int i11, Object obj) {
                return k.n3(this.f7073a, view2, i11, (h8.a) obj);
            }
        });
        this.L0.K(h8.a.class, cVar);
        this.H0.setAdapter(this.L0);
        this.H0.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: i8.j
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                k.p3(view2, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
        int i11 = this.P0 * 5;
        double size = this.E0.size();
        double d10 = i11;
        Double.isNaN(size);
        Double.isNaN(d10);
        int iCeil = (int) Math.ceil(size / d10);
        this.I0.setIndicatorItemCount(iCeil);
        this.I0.setCurrentIndex(0);
        if (iCeil > 1) {
            i8.a aVar = new i8.a(1);
            aVar.b(this.H0);
            aVar.z(new a());
        }
    }

    public final List u3(List list, int i10, int i11) {
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        int size = list.size();
        int i12 = i10 * i11;
        double d10 = size;
        double d11 = i12;
        Double.isNaN(d10);
        Double.isNaN(d11);
        int iCeil = (int) Math.ceil(d10 / d11);
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < iCeil; i13++) {
            for (int i14 = 0; i14 < i10; i14++) {
                for (int i15 = 0; i15 < i11; i15++) {
                    int i16 = (i13 * i12) + i14 + (i15 * i10);
                    arrayList.add(i16 >= size ? h8.a.g() : (h8.a) list.get(i16));
                }
            }
        }
        return arrayList;
    }

    public final h8.a v3(int i10) {
        for (h8.a aVar : this.E0) {
            if (aVar.c() == i10) {
                return aVar;
            }
        }
        return null;
    }

    public final int w3(int i10) {
        int size = this.E0.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((h8.a) this.E0.get(i11)).c() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void x3() {
        this.E0.clear();
        int[] iArrT0 = this.M0.t0();
        HashSet hashSet = new HashSet();
        boolean z10 = false;
        for (int i10 : iArrT0) {
            if (hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            hashSet.add(Integer.valueOf(i10));
            this.E0.add(l.a(I(), i10));
        }
        h8.a aVarV3 = v3(1);
        if (aVarV3 != null) {
            aVarV3.j(this.M0.d());
            aVarV3.h(a1(aVarV3.f() ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.P)));
        }
        h8.a aVarV32 = v3(5);
        if (aVarV32 != null) {
            aVarV32.j(this.M0.m2().s());
            aVarV32.h(a1(aVarV32.f() ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.I)));
        }
        h8.a aVarV33 = v3(7);
        if (aVarV33 != null) {
            boolean z11 = pa.r.d().a(this.F0) != null;
            aVarV33.k(Z0(z11 ? x7.u.A1 : x7.u.f13928c));
            aVarV33.j(z11);
        }
        h8.a aVarV34 = v3(40);
        if (aVarV34 != null) {
            boolean z12 = pa.r.f().a(this.F0) != null;
            aVarV34.k(Z0(z12 ? x7.u.f14060l5 : x7.u.f13942d));
            aVarV34.j(z12);
        }
        h8.a aVarV35 = v3(8);
        if (aVarV35 != null) {
            aVarV35.j(this.M0.m2().l());
            aVarV35.h(a1(aVarV35.f() ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.T)));
        }
        h8.a aVarV36 = v3(12);
        if (aVarV36 != null) {
            aVarV36.i(!i0.f7006a.l(this.F0));
        }
        h8.a aVarV37 = v3(14);
        if (aVarV37 != null) {
            aVarV37.i(i0.f7006a.s(this.F0));
        }
        h8.a aVarV38 = v3(15);
        if (aVarV38 != null) {
            i0 i0Var = i0.f7006a;
            aVarV38.i(i0Var.s(this.F0) || (Build.VERSION.SDK_INT >= 21 && i0Var.l(this.F0)));
        }
        h8.a aVarV39 = v3(16);
        if (aVarV39 != null) {
            aVarV39.j(this.M0.O1());
            aVarV39.h(a1(aVarV39.f() ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.G)));
        }
        h8.a aVarV310 = v3(17);
        if (aVarV310 != null) {
            w9.p pVarM2 = this.M0.m2();
            boolean z13 = pVarM2.r() || !pVarM2.q();
            aVarV310.k(Z0(pVarM2.r() ? x7.u.f14183u6 : !pVarM2.q() ? x7.u.f14196v6 : x7.u.f14209w6));
            aVarV310.j(z13);
        }
        h8.a aVarV311 = v3(19);
        if (aVarV311 != null) {
            aVarV311.j(this.M0.l0() != 0);
            if (aVarV311.f()) {
                aVarV311.h(a1(x7.u.f14034j7, Z0(x7.u.C0)));
            }
        }
        h8.a aVarV312 = v3(26);
        if (aVarV312 != null) {
            String strE = i0.f7006a.e(this.F0);
            ba.b bVarE = g6.p.f(strE) ? null : pa.r.k().e(strE);
            aVarV312.j(bVarE != null && bVarE.s());
            aVarV312.h(a1(aVarV312.f() ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.Ic)));
        }
        h8.a aVarV313 = v3(27);
        if (aVarV313 != null) {
            aVarV313.j(i0.f7006a.s(this.F0) && this.M0.m2().D() && !r9.g.a().e(this.F0) && lc.c().d().C(this.F0));
            aVarV313.h(a1(aVarV313.f() ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.uc)));
        }
        h8.a aVarV314 = v3(29);
        if (aVarV314 != null) {
            aVarV314.j(this.M0.F0() != 100);
            aVarV314.i(!i0.f7006a.l(this.F0));
            aVarV314.h(a1(x7.u.f14034j7, Z0(x7.u.Pc)));
        }
        h8.a aVarV315 = v3(30);
        if (aVarV315 != null) {
            boolean zA = n3.a(I());
            int iI0 = zA ? this.M0.i0() - 1 : 0;
            aVarV315.i(zA);
            if (iI0 == 0) {
                aVarV315.k(Z0(x7.u.P9));
                aVarV315.j(false);
            } else {
                aVarV315.k(g6.e.c(I(), x7.j.f13650g, iI0));
                aVarV315.j(true);
            }
        }
        h8.a aVarV316 = v3(28);
        if (aVarV316 != null) {
            aVarV316.j(this.M0.m2().g());
            aVarV316.h(a1(aVarV316.f() ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.f14165t1)));
        }
        h8.a aVarV317 = v3(32);
        if (aVarV317 != null) {
            aVarV317.i(!u9.d.m(I(), this.F0));
        }
        h8.a aVarV318 = v3(23);
        if (aVarV318 != null) {
            if (this.M0.m2().g() && this.M0.m2().t() && i0.f7006a.s(this.F0)) {
                z10 = true;
            }
            aVarV318.i(z10);
        }
        h8.a aVarV319 = v3(33);
        if (aVarV319 != null) {
            aVarV319.i(!u9.d.m(I(), this.F0));
        }
        h8.a aVarV320 = v3(36);
        if (aVarV320 != null) {
            aVarV320.i(!u9.d.m(I(), this.F0));
        }
        h8.a aVarV321 = v3(37);
        if (aVarV321 != null) {
            aVarV321.i(!u9.d.m(I(), this.F0));
        }
        h8.a aVarV322 = v3(38);
        if (aVarV322 != null) {
            aVarV322.i(true ^ u9.d.m(I(), this.F0));
            aVarV322.j(this.M0.S0());
        }
        h8.a aVarV323 = v3(41);
        if (aVarV323 != null) {
            aVarV323.i(i0.f7006a.s(this.F0));
        }
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        if (y0() != null) {
            this.C0 = y0().getInt("width", this.C0);
            this.D0 = y0().getInt("gravity", this.D0);
            this.F0 = y0().getString("url", this.F0);
            this.G0 = y0().getString("title", this.G0);
        }
    }
}
