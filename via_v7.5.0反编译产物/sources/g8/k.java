package g8;

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
import c6.a2;
import com.tuyafeng.wormhole.UserAgentPreset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import mark.via.browser.kd;
import mark.via.common.widget.m1;
import org.simpleframework.xml.strategy.Name;
import x8.j3;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends i8.a {
    public RecyclerView J0;
    public m1 K0;
    public View L0;
    public View M0;
    public t5.f N0;
    public u9.l O0;
    public int R0;
    public int E0 = -1;
    public int F0 = 80;
    public final List G0 = new ArrayList();
    public String H0 = null;
    public String I0 = null;
    public int P0 = 0;
    public int Q0 = 0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements g8.a.d {
        public a() {
        }

        @Override // g8.a.d
        public void a(int i10) {
            double d10 = i10;
            double d11 = k.this.R0 * 5;
            Double.isNaN(d10);
            Double.isNaN(d11);
            k.this.K0.setCurrentIndex((int) Math.ceil(d10 / d11));
        }

        @Override // g8.a.d
        public void b(int i10) {
            double d10 = i10;
            double d11 = k.this.R0 * 5;
            Double.isNaN(d10);
            Double.isNaN(d11);
            k.this.K0.setCurrentIndex((int) Math.ceil(d10 / d11));
        }
    }

    public static /* synthetic */ void l3(k kVar, ImageView imageView) {
        imageView.setImageDrawable(lb.g.a(kVar.G(), w7.o.K, w7.u.me));
        imageView.setContentDescription(kVar.X0(w7.u.f13972a5));
        r3.n(imageView);
    }

    public static /* synthetic */ void m3(k kVar, View view, int i10, f8.a aVar) {
        kVar.getClass();
        if (aVar.c() != 9) {
            kVar.P0 = aVar.c();
            kVar.Q0 = (aVar.e() ? 0 : 4) | 1 | (aVar.f() ? 8 : 0);
            kVar.V2();
            return;
        }
        int iB2 = kVar.J0.getLayoutManager() instanceof GridLayoutManager ? ((GridLayoutManager) kVar.J0.getLayoutManager()).b2() : -1;
        if (iB2 == -1 || kVar.N0.g() <= kVar.R0 * 5) {
            return;
        }
        int currentIndex = kVar.K0.getCurrentIndex() + 1;
        int i11 = iB2 + (kVar.R0 * 5);
        if (i11 >= kVar.N0.g()) {
            i11 = 0;
            currentIndex = 0;
        }
        kVar.J0.p1(i11);
        kVar.K0.setCurrentIndex(currentIndex);
        if (kVar.X2() == null || kVar.X2().getWindow() == null) {
            return;
        }
        com.tuyafeng.support.utils.x.B(kVar.X2().getWindow().getDecorView(), (kVar.F0 & 80) == 80);
    }

    public static /* synthetic */ boolean n3(k kVar, View view, int i10, f8.a aVar) {
        kVar.getClass();
        kVar.P0 = aVar.c();
        kVar.Q0 = (aVar.e() ? 0 : 4) | 2 | (aVar.f() ? 8 : 0);
        kVar.V2();
        return true;
    }

    public static /* synthetic */ void o3(k kVar, ImageView imageView) {
        imageView.setImageDrawable(lb.g.a(kVar.G(), w7.o.E0, w7.u.sf));
        imageView.setContentDescription(kVar.X0(R.string.cancel));
        r3.n(imageView);
    }

    public static /* synthetic */ void p3(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int width = view.getWidth() % 5;
        if (view.getPaddingEnd() != width) {
            view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), width, view.getPaddingBottom());
        }
    }

    public static /* synthetic */ void r3(k kVar, View view) {
        kVar.P0 = 21;
        kVar.Q0 = 1;
        kVar.V2();
    }

    public static k y3(String str, String str2, int i10, int i11) {
        Bundle bundle = new Bundle();
        k kVar = new k();
        bundle.putString("title", str2);
        bundle.putString("url", str);
        bundle.putInt("width", i10);
        bundle.putInt("gravity", i11);
        kVar.F2(bundle);
        return kVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z10 = (this.F0 & 48) == 48;
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: g8.b
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        this.J0 = (RecyclerView) new b6.a(new RecyclerView(G()), new FrameLayout.LayoutParams(-1, -1)).B(1, 12).l();
        this.K0 = (m1) new b6.a(new m1(G()), new LinearLayout.LayoutParams(-2, -2)).p(81).B(1, z10 ? 4 : 2).t(1, z10 ? 2 : 4).l();
        LinearLayout linearLayout2 = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(G(), w7.n.f13749b))).p(80).V(new b6.a.InterfaceC0033a() { // from class: g8.c
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        Space space = (Space) new b6.a(new Space(G()), new LinearLayout.LayoutParams(0, -2)).W(3.0f).l();
        this.L0 = new b6.a(new ImageView(G()), new LinearLayout.LayoutParams(0, -1)).W(1.0f).E(com.tuyafeng.support.utils.f.d(G(), w7.n.f13748a)).d(w7.o.f13783d).V(new b6.a.InterfaceC0033a() { // from class: g8.d
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k.l3(this.f5555a, (ImageView) obj);
            }
        }).l();
        this.M0 = new b6.a(new ImageView(G()), new LinearLayout.LayoutParams(0, -1)).W(1.0f).E(com.tuyafeng.support.utils.f.d(G(), w7.n.f13748a)).d(w7.o.f13783d).V(new b6.a.InterfaceC0033a() { // from class: g8.e
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k.o3(this.f5556a, (ImageView) obj);
            }
        }).l();
        linearLayout2.addView(space);
        linearLayout2.addView(this.L0);
        linearLayout2.addView(this.M0);
        if (!z10) {
            linearLayout.addView(this.J0);
            linearLayout.addView(this.K0);
            linearLayout.addView(linearLayout2);
            return linearLayout;
        }
        linearLayout.addView(linearLayout2);
        linearLayout.addView(this.K0);
        linearLayout.addView(this.J0);
        this.M0.setRotation(180.0f);
        return linearLayout;
    }

    public void A3(int i10) {
        int iW3 = w3(36);
        if (iW3 < 0) {
            return;
        }
        f8.a aVar = (f8.a) this.G0.get(iW3);
        if (aVar.e()) {
            aVar.j(i10 == 3);
            this.N0.m(iW3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        z3();
        super.B1();
    }

    public final void B3(int i10, int i11) {
        List listU3 = u3(this.G0, i10, i11);
        this.G0.clear();
        this.G0.addAll(listU3);
    }

    @Override // i8.a, androidx.fragment.app.Fragment
    public void R1() {
        Window window;
        super.R1();
        Dialog dialogX2 = X2();
        if (dialogX2 == null || (window = dialogX2.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = this.E0;
        attributes.height = -2;
        int i10 = this.F0;
        attributes.gravity = i10;
        attributes.dimAmount = 0.2f;
        attributes.windowAnimations = (i10 & 48) == 48 ? w7.v.f14328e : w7.v.f14327d;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.M0.setOnClickListener(new View.OnClickListener() { // from class: g8.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f5557a.V2();
            }
        });
        this.L0.setOnClickListener(new View.OnClickListener() { // from class: g8.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k.r3(this.f5558a, view2);
            }
        });
        this.O0 = la.s.j();
        x3();
        int i10 = this.G0.size() > 5 ? 2 : 1;
        this.R0 = i10;
        B3(5, i10);
        this.J0.setLayoutManager(new GridLayoutManager(G(), this.R0, 0, false));
        this.J0.setItemAnimator(null);
        this.J0.setHasFixedSize(true);
        r3.e(this.J0);
        this.N0 = new t5.f(this.G0);
        f8.c cVar = new f8.c();
        cVar.j(new t5.g() { // from class: g8.h
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                k.m3(this.f5559a, view2, i11, (f8.a) obj);
            }
        });
        cVar.k(new t5.h() { // from class: g8.i
            @Override // t5.h
            public final boolean a(View view2, int i11, Object obj) {
                return k.n3(this.f5560a, view2, i11, (f8.a) obj);
            }
        });
        this.N0.K(f8.a.class, cVar);
        this.J0.setAdapter(this.N0);
        this.J0.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: g8.j
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                k.p3(view2, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
        int i11 = this.R0 * 5;
        double size = this.G0.size();
        double d10 = i11;
        Double.isNaN(size);
        Double.isNaN(d10);
        int iCeil = (int) Math.ceil(size / d10);
        this.K0.setIndicatorItemCount(iCeil);
        this.K0.setCurrentIndex(0);
        if (iCeil > 1) {
            g8.a aVar = new g8.a(1);
            aVar.b(this.J0);
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
                    arrayList.add(i16 >= size ? f8.a.g() : (f8.a) list.get(i16));
                }
            }
        }
        return arrayList;
    }

    public final f8.a v3(int i10) {
        for (f8.a aVar : this.G0) {
            if (aVar.c() == i10) {
                return aVar;
            }
        }
        return null;
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (w0() != null) {
            this.E0 = w0().getInt("width", this.E0);
            this.F0 = w0().getInt("gravity", this.F0);
            this.H0 = w0().getString("url", this.H0);
            this.I0 = w0().getString("title", this.I0);
        }
    }

    public final int w3(int i10) {
        int size = this.G0.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((f8.a) this.G0.get(i11)).c() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void x3() {
        this.G0.clear();
        int[] iArrV0 = this.O0.v0();
        HashSet hashSet = new HashSet();
        boolean z10 = false;
        for (int i10 : iArrV0) {
            if (hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            hashSet.add(Integer.valueOf(i10));
            this.G0.add(l.a(G(), i10));
        }
        f8.a aVarV3 = v3(1);
        if (aVarV3 != null) {
            aVarV3.j(this.O0.e());
            aVarV3.h(Y0(aVarV3.f() ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.Q)));
        }
        f8.a aVarV4 = v3(5);
        if (aVarV4 != null) {
            aVarV4.j(this.O0.n2().s());
            aVarV4.h(Y0(aVarV4.f() ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.J)));
        }
        f8.a aVarV5 = v3(7);
        if (aVarV5 != null) {
            boolean z11 = la.s.d().a(this.H0) != null;
            aVarV5.k(X0(z11 ? w7.u.N1 : w7.u.f13994c));
            aVarV5.j(z11);
        }
        f8.a aVarV6 = v3(40);
        if (aVarV6 != null) {
            boolean z12 = la.s.f().a(this.H0) != null;
            aVarV6.k(X0(z12 ? w7.u.f14278w5 : w7.u.f14008d));
            aVarV6.j(z12);
        }
        f8.a aVarV7 = v3(8);
        if (aVarV7 != null) {
            aVarV7.j(this.O0.n2().l());
            aVarV7.h(Y0(aVarV7.f() ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.U)));
        }
        f8.a aVarV8 = v3(12);
        if (aVarV8 != null) {
            aVarV8.i(!a2.f1958a.m(this.H0));
        }
        f8.a aVarV9 = v3(14);
        if (aVarV9 != null) {
            aVarV9.i(a2.f1958a.t(this.H0));
        }
        f8.a aVarV10 = v3(15);
        if (aVarV10 != null) {
            a2 a2Var = a2.f1958a;
            aVarV10.i(a2Var.t(this.H0) || (Build.VERSION.SDK_INT >= 21 && a2Var.m(this.H0)));
        }
        f8.a aVarV11 = v3(16);
        if (aVarV11 != null) {
            aVarV11.j(this.O0.O1());
            aVarV11.h(Y0(aVarV11.f() ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.H)));
        }
        f8.a aVarV12 = v3(17);
        if (aVarV12 != null) {
            u9.p pVarN2 = this.O0.n2();
            boolean z13 = pVarN2.r() || !pVarN2.q();
            aVarV12.k(X0(pVarN2.r() ? w7.u.G6 : !pVarN2.q() ? w7.u.H6 : w7.u.I6));
            aVarV12.j(z13);
        }
        a2 a2Var2 = a2.f1958a;
        y9.b bVarD = (!a2Var2.t(this.H0) || s9.d.l(G(), this.H0)) ? null : la.s.k().d(a2Var2.f(this.H0), true);
        boolean z14 = bVarD != null && bVarD.s();
        f8.a aVarV13 = v3(19);
        if (aVarV13 != null) {
            aVarV13.j(((!z14 || bVarD.j() == -1000) ? this.O0.o0() : bVarD.j()) != UserAgentPreset.DEFAULT.getPresetId());
            if (aVarV13.f()) {
                aVarV13.h(Y0(w7.u.f14267v7, X0(w7.u.F0)));
            }
        }
        f8.a aVarV14 = v3(26);
        if (aVarV14 != null) {
            aVarV14.j(z14);
            aVarV14.h(Y0(aVarV14.f() ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.Xc)));
        }
        f8.a aVarV15 = v3(27);
        if (aVarV15 != null) {
            aVarV15.j(a2Var2.t(this.H0) && this.O0.n2().C() && !p9.a.a().r(this.H0) && kd.c().f().C(this.H0));
            aVarV15.h(Y0(aVarV15.f() ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.Ic)));
        }
        f8.a aVarV16 = v3(29);
        if (aVarV16 != null) {
            aVarV16.j(this.O0.H0() != 100);
            aVarV16.i(!a2Var2.m(this.H0));
            aVarV16.h(Y0(w7.u.f14267v7, X0(w7.u.ed)));
        }
        f8.a aVarV17 = v3(30);
        if (aVarV17 != null) {
            boolean zA = j3.a(G());
            int iL0 = zA ? this.O0.l0() - 1 : 0;
            aVarV17.i(zA);
            if (iL0 == 0) {
                aVarV17.k(X0(w7.u.f13991ba));
                aVarV17.j(false);
            } else {
                aVarV17.k(com.tuyafeng.support.utils.e.c(G(), w7.j.f13716g, iL0));
                aVarV17.j(true);
            }
        }
        f8.a aVarV18 = v3(28);
        if (aVarV18 != null) {
            aVarV18.j(this.O0.n2().g());
            aVarV18.h(Y0(aVarV18.f() ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.G1)));
        }
        f8.a aVarV19 = v3(32);
        if (aVarV19 != null) {
            aVarV19.i(!s9.d.l(G(), this.H0));
        }
        f8.a aVarV20 = v3(23);
        if (aVarV20 != null) {
            if (this.O0.n2().g() && this.O0.n2().t() && a2Var2.t(this.H0)) {
                z10 = true;
            }
            aVarV20.i(z10);
        }
        f8.a aVarV21 = v3(33);
        if (aVarV21 != null) {
            aVarV21.i(!s9.d.l(G(), this.H0));
        }
        f8.a aVarV22 = v3(36);
        if (aVarV22 != null) {
            aVarV22.i(!s9.d.l(G(), this.H0));
        }
        f8.a aVarV23 = v3(37);
        if (aVarV23 != null) {
            aVarV23.i(!s9.d.l(G(), this.H0));
        }
        f8.a aVarV24 = v3(38);
        if (aVarV24 != null) {
            aVarV24.i(true ^ s9.d.l(G(), this.H0));
            aVarV24.j(this.O0.a());
        }
        f8.a aVarV25 = v3(41);
        if (aVarV25 != null) {
            aVarV25.i(a2Var2.t(this.H0));
        }
    }

    public final void z3() {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, this.P0);
        bundle.putInt("flags", this.Q0);
        L0().y1("menu_result", bundle);
    }
}
