package tb;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c6.y1;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import x8.h3;
import x8.q2;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k0 extends m8.a implements m8.c {
    public t5.f A0;
    public u9.l C0;
    public String D0;
    public ha.g F0;
    public Map K0;
    public int M0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public RelativeLayout f12681q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public LinearLayout f12682r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public e f12683s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ImageView f12684t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ImageView f12685u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ImageView f12686v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public TextView f12687w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ImageView f12688x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public View f12689y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public RecyclerView f12690z0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f12679o0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f12680p0 = 0;
    public final List B0 = new ArrayList();
    public boolean E0 = false;
    public List G0 = null;
    public boolean H0 = false;
    public final u9.b I0 = new u9.b(0);
    public boolean J0 = true;
    public final Map L0 = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f12691c;

        public a(boolean z10) {
            this.f12691c = z10;
        }

        public static /* synthetic */ void q(a aVar, ha.a aVar2, View view) {
            aVar.getClass();
            String strB = aVar2.b();
            if (strB == null || strB.isEmpty()) {
                return;
            }
            k0.this.f12683s0.setText(strB);
            k0.this.f12683s0.setSelection(k0.this.f12683s0.length());
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            View viewA = w5.c.e(w7.r.f13957z).a(viewGroup);
            ((ImageView) viewA.findViewById(w7.p.O)).setImageDrawable(lb.g.a(viewA.getContext(), w7.o.f13778b0, w7.u.se));
            TextView textView = (TextView) viewA.findViewById(w7.p.F1);
            TextView textView2 = (TextView) viewA.findViewById(w7.p.G1);
            r3.q(textView);
            r3.q(textView2);
            r3.o(textView);
            r3.o(textView2);
            v8.g.d(textView);
            v8.g.d(textView2);
            return viewA;
        }

        @Override // t5.i
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, final ha.a aVar, int i10) {
            int i11;
            int i12;
            gVar.X(w7.p.F1, com.tuyafeng.support.utils.p.j(aVar.c(), 256));
            gVar.X(w7.p.G1, com.tuyafeng.support.utils.p.j(aVar.e(), 256));
            gVar.Y(w7.p.F1, !TextUtils.isEmpty(aVar.c()));
            gVar.Y(w7.p.G1, !TextUtils.isEmpty(aVar.e()));
            int iD = aVar.d();
            if (iD == 1) {
                i11 = w7.o.T;
                i12 = w7.u.re;
            } else if (iD == 2) {
                i11 = w7.o.f13837v;
                i12 = w7.u.ie;
            } else if (iD == 4) {
                i11 = w7.o.f13842w1;
                i12 = w7.u.Mf;
            } else if (iD == 8 || iD == 32) {
                i11 = w7.o.f13817o0;
                i12 = w7.u.ye;
            } else {
                i11 = w7.o.f13797h1;
                i12 = w7.u.Hf;
            }
            gVar.V(w7.p.f13868f0, lb.g.a(k0.this.G(), i11, i12));
            if (!this.f12691c) {
                gVar.P(w7.p.O).setRotation(-90.0f);
            }
            gVar.P(w7.p.O).setOnClickListener(new View.OnClickListener() { // from class: tb.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.a.q(this.f12676a, aVar, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bundle B3(String str, String str2, String str3, int i10, boolean z10, boolean z11, int i11, boolean z12, boolean z13) {
        Bundle bundle = new Bundle();
        int i12 = z10;
        if (z11) {
            i12 = (z10 ? 1 : 0) | 2;
        }
        if (z12) {
            i12 = (i12 == true ? 1 : 0) | 4;
        }
        bundle.putInt("uiflags", i12);
        bundle.putString("keyword", str3);
        bundle.putString("title", str);
        bundle.putString("url", str2);
        bundle.putInt("search_engine", i10);
        bundle.putInt("bg", i11);
        if (z13) {
            bundle.putBoolean("incognito", true);
        }
        return bundle;
    }

    private void F3() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        y.r.e0(this.f12681q0, new y.m() { // from class: tb.y
            @Override // y.m
            public final y.k0 a(View view, y.k0 k0Var) {
                return k0.W2(this.f12722a, view, k0Var);
            }
        });
    }

    public static /* synthetic */ void S2(k0 k0Var, View view) {
        k0Var.f12684t0.setVisibility(8);
        k0Var.B0.clear();
        k0Var.A0.l();
        k0Var.f12683s0.setText("");
        k0Var.C3();
    }

    public static /* synthetic */ void T2(k0 k0Var, boolean z10, RecyclerView recyclerView) {
        k0Var.getClass();
        r3.e(recyclerView);
        recyclerView.setScrollBarSize(com.tuyafeng.support.utils.f.d(k0Var.G(), w7.n.f13756i));
        recyclerView.setVerticalScrollBarEnabled(true);
        com.tuyafeng.support.utils.x.W(recyclerView, com.tuyafeng.support.utils.f.e(recyclerView.getContext(), w7.m.f13742f));
        recyclerView.setFadingEdgeLength(com.tuyafeng.support.utils.x.h(k0Var.G(), 32.0f));
        recyclerView.setVerticalFadingEdgeEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        boolean z11 = !z10;
        linearLayoutManager.E2(z11);
        linearLayoutManager.D2(z11);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
    }

    public static /* synthetic */ void U2(View view) {
        view.setClickable(true);
        view.setFocusable(false);
        view.setImportantForAccessibility(2);
    }

    public static /* synthetic */ void V2(k0 k0Var, ImageView imageView) {
        k0Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.f13846y, w7.u.je));
        imageView.setContentDescription(k0Var.X0(w7.u.f14289x3));
    }

    public static /* synthetic */ y.k0 W2(k0 k0Var, View view, y.k0 k0Var2) {
        k0Var.y3(view, k0Var2);
        h3.d(view, k0Var2);
        return k0Var2;
    }

    public static /* synthetic */ void X2(k0 k0Var, TextView textView) {
        textView.setTextColor(v8.h.o(k0Var.G()));
        textView.setTextSize(0, v8.h.u(k0Var.G()));
        textView.setGravity(17);
        v8.g.d(textView);
        textView.setVisibility(8);
    }

    public static /* synthetic */ void Y2(k0 k0Var, View view) {
        String string = k0Var.f12683s0.getText().toString();
        if (string.isEmpty() || string.equals(k0Var.D0)) {
            string = null;
        }
        k0Var.K3(string);
        k0Var.z3();
    }

    public static /* synthetic */ void Z2(final k0 k0Var, String str, Bundle bundle) {
        k0Var.getClass();
        String string = bundle.getString("resultUrl", null);
        boolean z10 = bundle.getBoolean("resultGo", false);
        final int[] intArray = bundle.getIntArray("resultSelection");
        if (string != null) {
            k0Var.f12683s0.setText(string);
            if (z10) {
                k0Var.P3();
            } else {
                k0Var.f12681q0.setDescendantFocusability(131072);
                k0Var.f12683s0.post(new Runnable() { // from class: tb.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        k0.s3(this.f12653c, intArray);
                    }
                });
            }
        }
        k0Var.L0().x("resultUrl");
    }

    public static /* synthetic */ void a3(k0 k0Var, androidx.lifecycle.j jVar, Lifecycle.Event event) {
        RelativeLayout relativeLayout;
        k0Var.getClass();
        if (event != Lifecycle.Event.ON_DESTROY || (relativeLayout = k0Var.f12681q0) == null) {
            return;
        }
        relativeLayout.setDescendantFocusability(131072);
    }

    public static /* synthetic */ boolean c3(final k0 k0Var, View view, int i10, ha.a aVar) {
        k0Var.getClass();
        if (aVar.d() != 32) {
            return false;
        }
        q5.k.l(k0Var.G()).f0(w7.u.f14179p2).J(w7.u.f14193q2).X(R.string.ok, new q5.k.m() { // from class: tb.z
            @Override // q5.k.m
            public final void a(View view2, q5.k.p pVar) {
                k0.i3(this.f12723a, view2, pVar);
            }
        }).P(R.string.cancel, null).h0();
        return true;
    }

    public static /* synthetic */ void e3(k0 k0Var, ImageView imageView) {
        k0Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.L, w7.u.ne));
        imageView.setContentDescription(k0Var.X0(w7.u.B3));
    }

    public static /* synthetic */ void h3(k0 k0Var, HorizontalScrollView horizontalScrollView) {
        k0Var.getClass();
        horizontalScrollView.setFillViewport(true);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setHorizontalFadingEdgeEnabled(true);
        horizontalScrollView.setFadingEdgeLength(com.tuyafeng.support.utils.x.h(k0Var.G(), 12.0f));
        r3.g(horizontalScrollView);
    }

    public static /* synthetic */ void i3(k0 k0Var, View view, q5.k.p pVar) {
        k0Var.F0.i(null);
        k0Var.f12683s0.setText((CharSequence) null);
    }

    public static /* synthetic */ boolean j3(k0 k0Var, View view, int i10, KeyEvent keyEvent) {
        k0Var.getClass();
        if (i10 == 67 && keyEvent.getAction() == 0 && k0Var.f12683s0.getSelectionStart() == 0 && k0Var.f12683s0.getSelectionEnd() == 0 && k0Var.M0 != 0) {
            k0Var.D3();
            return true;
        }
        if (i10 != 66 || keyEvent.getAction() != 1) {
            return false;
        }
        k0Var.P3();
        return true;
    }

    public static /* synthetic */ void k3(k0 k0Var, List list) {
        int i10 = k0Var.f12680p0;
        if (i10 != k0Var.f12679o0) {
            k0Var.f12679o0 = i10;
            if (list.isEmpty()) {
                k0Var.H0 = true;
                return;
            } else {
                k0Var.B0.clear();
                k0Var.H0 = false;
            }
        }
        if (k0Var.H0) {
            k0Var.B0.clear();
        }
        k0Var.B0.addAll(list);
        k0Var.A0.l();
        k0Var.f12690z0.p1(0);
        k0Var.C3();
    }

    public static /* synthetic */ void l3(k0 k0Var, ImageView imageView) {
        k0Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.f13797h1, w7.u.Hf));
        imageView.setContentDescription(k0Var.X0(w7.u.Xb));
    }

    public static /* synthetic */ String n3(k0 k0Var, CharSequence charSequence) {
        ImageView imageView = k0Var.f12684t0;
        if (imageView != null) {
            imageView.setVisibility(charSequence.length() == 0 ? 8 : 0);
        }
        return k0Var.x3(charSequence.toString());
    }

    public static /* synthetic */ r6.n o3(k0 k0Var, String str) {
        k0Var.f12680p0++;
        d dVarE3 = k0Var.E3(str.toString());
        if (dVarE3.d() == 2) {
            ha.a aVar = new ha.a(0, dVarE3.f(), null, 64);
            aVar.h(dVarE3.f());
            return r6.j.z(Collections.singletonList(aVar));
        }
        int iY = k0Var.C0.Y();
        if (dVarE3.g()) {
            iY = q2.f(dVarE3.c(), iY);
        }
        return k0Var.F0.r(dVarE3.e(), k0Var.C0.X1(), iY).G(a7.a.c());
    }

    public static /* synthetic */ void p3(k0 k0Var, e eVar) {
        k0Var.getClass();
        v8.g.h(eVar);
        eVar.setHint(w7.u.f14063gc);
        eVar.setImeOptions(2);
        eVar.setInputType(524289);
        eVar.setGravity(16);
        eVar.setSelectAllOnFocus(true);
        eVar.setTextColor(com.tuyafeng.support.utils.e.a(k0Var.G(), w7.k.f13732l));
        eVar.setHintTextColor(com.tuyafeng.support.utils.e.a(k0Var.G(), w7.k.f13732l));
        if (Build.VERSION.SDK_INT >= 26) {
            eVar.setImportantForAutofill(2);
        }
        eVar.setTextSize(0, com.tuyafeng.support.utils.f.d(k0Var.G(), w7.n.C));
        eVar.setSingleLine(true);
        eVar.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        r3.o(eVar);
        v8.g.d(eVar);
    }

    public static /* synthetic */ void q3(k0 k0Var, View view, int i10, ha.a aVar) {
        k0Var.getClass();
        if (aVar.d() == 4) {
            k0Var.M3("VIA-SWITCH-TAB:" + aVar.a());
            return;
        }
        if (aVar.d() == 64) {
            k0Var.f12683s0.setText(aVar.b());
            e eVar = k0Var.f12683s0;
            eVar.setSelection(eVar.length());
        } else if (k0Var.M0 == 0 || !(aVar.d() == 16 || aVar.d() == 32)) {
            k0Var.M3(aVar.b());
        } else {
            k0Var.L3(k0Var.M0, aVar.b());
        }
    }

    public static /* synthetic */ void r3(k0 k0Var, ImageView imageView) {
        k0Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.f13802j0, w7.u.xe));
        imageView.setContentDescription(k0Var.X0(w7.u.f14063gc));
    }

    public static /* synthetic */ void s3(k0 k0Var, int[] iArr) {
        x8.f.l(k0Var.f12683s0);
        if (iArr == null || iArr.length != 2 || iArr[0] == -1) {
            e eVar = k0Var.f12683s0;
            eVar.setSelection(eVar.getText().length());
        }
    }

    public static /* synthetic */ void t3(k0 k0Var, List list, int i10, AdapterView adapterView, View view, int i11, long j10) {
        k0Var.getClass();
        ga.c cVar = (ga.c) list.get(i11);
        if (cVar.d() == i10) {
            return;
        }
        if (q2.g(cVar.d())) {
            k0Var.C0.p1(cVar.a());
        }
        k0Var.C0.s(cVar.d());
        k0Var.Q3();
        k0Var.E0 = true;
    }

    public static /* synthetic */ void u3(k0 k0Var) {
        if (k0Var.M0 != 0) {
            k0Var.D3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.I0.d(w0() == null ? 0 : w0().getInt("uiflags", 0));
        final boolean zB = this.I0.b(1);
        int iD = com.tuyafeng.support.utils.f.d(G(), w7.n.G);
        int iD2 = com.tuyafeng.support.utils.f.d(G(), w7.n.F);
        this.f12681q0 = (RelativeLayout) new b6.a(new RelativeLayout(G()), new ViewGroup.LayoutParams(-1, -1)).j(X0(R.string.cancel)).l();
        this.f12682r0 = (LinearLayout) new b6.a(new LinearLayout(G()), new RelativeLayout.LayoutParams(-1, -2)).o(com.tuyafeng.support.utils.x.l()).h(zB ? 1 : 128).V(new b6.a.InterfaceC0033a() { // from class: tb.q
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        this.f12686v0 = (ImageView) new b6.a(new ImageView(G()), new LinearLayout.LayoutParams(iD, iD)).o(com.tuyafeng.support.utils.x.l()).E(iD2).d(w7.o.f13789f).V(new b6.a.InterfaceC0033a() { // from class: tb.b0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.l3(this.f12658a, (ImageView) obj);
            }
        }).l();
        this.f12687w0 = (TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(-2, -2)).p(16).x(1, 4).H(1, 6, 2, 6, 2).e(new com.tuyafeng.support.utils.g().k(v8.h.o(G())).l(com.tuyafeng.support.utils.x.h(G(), 1.0f)).c(com.tuyafeng.support.utils.x.h(G(), 4.0f)).a()).V(new b6.a.InterfaceC0033a() { // from class: tb.c0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.X2(this.f12659a, (TextView) obj);
            }
        }).l();
        this.f12684t0 = (ImageView) new b6.a(new ImageView(G()), new LinearLayout.LayoutParams(iD, iD)).o(com.tuyafeng.support.utils.x.l()).E(iD2).d(w7.o.f13789f).V(new b6.a.InterfaceC0033a() { // from class: tb.d0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.V2(this.f12664a, (ImageView) obj);
            }
        }).l();
        this.f12685u0 = (ImageView) new b6.a(new ImageView(G()), new LinearLayout.LayoutParams(iD, iD)).o(com.tuyafeng.support.utils.x.l()).E(iD2).d(w7.o.f13789f).V(new b6.a.InterfaceC0033a() { // from class: tb.e0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.e3(this.f12667a, (ImageView) obj);
            }
        }).l();
        this.f12688x0 = (ImageView) new b6.a(new ImageView(G()), new LinearLayout.LayoutParams(iD, iD)).o(com.tuyafeng.support.utils.x.l()).E(iD2).d(w7.o.f13789f).V(new b6.a.InterfaceC0033a() { // from class: tb.f0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.r3(this.f12668a, (ImageView) obj);
            }
        }).l();
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) new b6.a(new HorizontalScrollView(G()), new LinearLayout.LayoutParams(0, iD)).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: tb.g0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.h3(this.f12669a, (HorizontalScrollView) obj);
            }
        }).l();
        this.f12683s0 = (e) new b6.a(new e(G()), new FrameLayout.LayoutParams(-2, iD)).f(0).p(16).V(new b6.a.InterfaceC0033a() { // from class: tb.h0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.p3(this.f12671a, (e) obj);
            }
        }).l();
        this.f12690z0 = (RecyclerView) new b6.a(new RecyclerView(G()), new RelativeLayout.LayoutParams(-1, -2)).f(com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c)).g(zB ? 32 : 64, this.f12682r0.getId()).r(1, 0, zB ? 0 : 72, 0, zB ? 72 : 0).V(new b6.a.InterfaceC0033a() { // from class: tb.i0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.T2(this.f12673a, zB, (RecyclerView) obj);
            }
        }).l();
        this.f12689y0 = new b6.a(new View(G()), new RelativeLayout.LayoutParams(-1, -2)).g(16, this.f12682r0.getId()).g(128, this.f12682r0.getId()).f(v8.h.c(G())).V(new b6.a.InterfaceC0033a() { // from class: tb.g
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.U2((View) obj);
            }
        }).l();
        this.f12682r0.addView(this.f12686v0);
        this.f12682r0.addView(this.f12687w0);
        horizontalScrollView.addView(this.f12683s0);
        this.f12682r0.addView(horizontalScrollView);
        this.f12682r0.addView(this.f12684t0);
        this.f12682r0.addView(this.f12685u0);
        this.f12682r0.addView(this.f12688x0);
        this.f12681q0.addView(this.f12689y0);
        this.f12681q0.addView(this.f12690z0);
        this.f12681q0.addView(this.f12682r0);
        return this.f12681q0;
    }

    public final void A3() {
        ((autodispose2.n) s8.c.a(this.f12683s0).A(new u6.g() { // from class: tb.i
            @Override // u6.g
            public final Object apply(Object obj) {
                return k0.n3(this.f12672a, (CharSequence) obj);
            }
        }).i().g(200L, TimeUnit.MILLISECONDS).I(new u6.g() { // from class: tb.j
            @Override // u6.g
            public final Object apply(Object obj) {
                return k0.o3(this.f12675a, (String) obj);
            }
        }).G(a7.a.c()).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: tb.k
            @Override // u6.f
            public final void accept(Object obj) {
                k0.k3(this.f12678c, (List) obj);
            }
        }, new w7.a0());
    }

    public final void C3() {
        boolean zIsEmpty = this.B0.isEmpty();
        if (this.J0 == zIsEmpty) {
            return;
        }
        this.J0 = zIsEmpty;
        R3();
    }

    public final void D3() {
        this.M0 = 0;
        this.f12687w0.setText((CharSequence) null);
        this.f12687w0.setVisibility(8);
    }

    public final d E3(String str) {
        if (str == null) {
            str = "";
        }
        String strA = b.a(str);
        if (strA != null) {
            return d.a(str, strA);
        }
        return (this.M0 == 0 || str.isEmpty()) ? d.h(str) : d.b(str, this.M0);
    }

    public final String G3(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            this.E0 = true;
            return str3;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str) || s9.d.l(G(), str)) {
            return "";
        }
        String strB1 = la.s.j().b1();
        y1 y1Var = y1.f2139a;
        String strG = y1Var.g(str, strB1);
        return TextUtils.isEmpty(strG) ? y1Var.f(str) : strG;
    }

    public final void H3(View view) {
        Bundle bundle = w0() == null ? new Bundle() : w0();
        boolean zB = this.I0.b(1);
        int i10 = bundle.getInt("bg", 0);
        boolean zB2 = this.I0.b(2);
        this.A0 = new t5.f(this.B0);
        a aVar = new a(zB);
        this.A0.K(ha.a.class, aVar);
        this.f12690z0.setAdapter(this.A0);
        aVar.j(new t5.g() { // from class: tb.l
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                k0.q3(this.f12693a, view2, i11, (ha.a) obj);
            }
        });
        aVar.k(new t5.h() { // from class: tb.m
            @Override // t5.h
            public final boolean a(View view2, int i11, Object obj) {
                return k0.c3(this.f12694a, view2, i11, (ha.a) obj);
            }
        });
        String string = bundle.getString("title", "");
        String string2 = bundle.getString("url", "");
        String string3 = bundle.getString("keyword", "");
        int i11 = bundle.getInt("search_engine", 0);
        if (i11 != 0 && i11 != this.C0.M1()) {
            w3(i11);
        }
        this.D0 = G3(string2, string3, string);
        String strJ3 = J3();
        if (bundle.getBoolean("incognito", false)) {
            int imeOptions = this.f12683s0.getImeOptions();
            int i12 = 524288 | imeOptions;
            if (Build.VERSION.SDK_INT >= 26) {
                i12 = 17301504 | imeOptions;
            }
            this.f12683s0.setImeOptions(i12);
        }
        e eVar = this.f12683s0;
        if (strJ3 == null || strJ3.isEmpty()) {
            strJ3 = this.D0;
        }
        eVar.setText(strJ3);
        this.f12683s0.setOnDeleteAtStart(new Runnable() { // from class: tb.n
            @Override // java.lang.Runnable
            public final void run() {
                k0.u3(this.f12696c);
            }
        });
        this.f12683s0.setOnKeyListener(new View.OnKeyListener() { // from class: tb.o
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i13, KeyEvent keyEvent) {
                return k0.j3(this.f12698a, view2, i13, keyEvent);
            }
        });
        this.f12684t0.setVisibility(this.f12683s0.length() == 0 ? 8 : 0);
        this.f12684t0.setOnClickListener(new View.OnClickListener() { // from class: tb.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k0.S2(this.f12699a, view2);
            }
        });
        this.f12686v0.setOnClickListener(new View.OnClickListener() { // from class: tb.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12701a.N3(view2);
            }
        });
        this.f12688x0.setOnClickListener(new View.OnClickListener() { // from class: tb.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12703a.P3();
            }
        });
        this.f12685u0.setOnClickListener(new View.OnClickListener() { // from class: tb.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12705a.I3();
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: tb.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k0.Y2(this.f12706a, view2);
            }
        });
        if (zB2) {
            boolean zC = com.tuyafeng.support.utils.x.C(i10);
            Context contextG = G();
            int i13 = R.color.white;
            int iB = com.tuyafeng.support.utils.f.b(contextG, zC ? w7.m.f13743g : R.color.white);
            Context contextG2 = G();
            if (zC) {
                i13 = w7.m.f13740d;
            }
            com.tuyafeng.support.utils.x.T(com.tuyafeng.support.utils.f.b(contextG2, i13), this.f12686v0, this.f12684t0, this.f12685u0, this.f12688x0);
            this.f12683s0.setTextColor(iB);
            this.f12683s0.setHintTextColor(iB);
            this.f12687w0.setTextColor(iB);
            com.tuyafeng.support.utils.x.P(this.f12687w0, new com.tuyafeng.support.utils.g().k(iB).l(com.tuyafeng.support.utils.x.h(G(), 1.0f)).c(com.tuyafeng.support.utils.x.h(G(), 4.0f)).a());
            this.f12689y0.setBackgroundColor(i10);
        } else {
            R3();
        }
        int iD = com.tuyafeng.support.utils.f.d(G(), w7.n.f13763p);
        com.tuyafeng.support.utils.x.P(this.f12690z0, new com.tuyafeng.support.utils.g().h(v8.h.c(G())).e(zB ? 0.0f : iD, zB ? 0.0f : iD, zB ? iD : 0.0f, zB ? iD : 0.0f).a());
        int i14 = this.I0.b(4) ? iD : 0;
        com.tuyafeng.support.utils.x.P(this.f12681q0, new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.f.b(G(), w7.m.f13746j)).i(1887469696).e(!zB ? 0.0f : i14, !zB ? 0.0f : i14, !zB ? i14 : 0.0f, zB ? 0.0f : i14).a());
        this.f12683s0.post(new Runnable() { // from class: tb.v
            @Override // java.lang.Runnable
            public final void run() {
                x8.f.l(this.f12708c.f12683s0);
            }
        });
        F3();
    }

    public final void I3() {
        L0().z1("resultUrl", this, new androidx.fragment.app.i0() { // from class: tb.x
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                k0.Z2(this.f12721a, str, bundle);
            }
        });
        androidx.fragment.app.l0 l0VarX = L0().q().x(true);
        int i10 = w7.i.f13703a;
        int i11 = w7.i.f13709g;
        l0VarX.v(i10, i11, i11, w7.i.f13704b).c(FragmentUtils.f3568a, w0.class, w0.d3(this.f12683s0.getText().toString(), new int[]{this.f12683s0.getSelectionStart(), this.f12683s0.getSelectionEnd()}), null).g(null).i();
    }

    public final String J3() {
        String str;
        Bundle bundleC = p5.b.d().c("URL_INPUT_CACHE");
        if (bundleC == null) {
            return null;
        }
        String string = bundleC.getString("url");
        String string2 = bundleC.getString("title");
        if (!(TextUtils.isEmpty(string) && TextUtils.isEmpty(this.D0)) && ((str = this.D0) == null || !str.equals(string))) {
            return null;
        }
        w3(bundleC.getInt("active_search_engine", 0));
        return string2;
    }

    public final void K3(String str) {
        if (str == null || str.isEmpty()) {
            p5.b.d().b("URL_INPUT_CACHE");
        } else {
            p5.b.a().e("URL_INPUT_CACHE").f(180).d("url", this.D0).d("title", str).b("active_search_engine", this.M0).a();
        }
    }

    public final void L3(int i10, String str) {
        x8.f.e(this.f12683s0);
        z3();
        Bundle bundle = new Bundle();
        bundle.putInt("input_action", 2);
        bundle.putInt("input_engine", i10);
        bundle.putString("input_query", str);
        bundle.putString("input", str);
        L0().y1("input", bundle);
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        x8.f.e(this.f12683s0);
        super.M1();
    }

    public final void M3(String str) {
        x8.f.e(this.f12683s0);
        z3();
        if (this.E0 || !this.D0.equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("input", str);
            L0().y1("input", bundle);
        }
    }

    public final void N3(View view) {
        x8.f.e(this.f12683s0);
        final List listE = q2.e(G());
        int size = listE.size();
        String[] strArr = new String[size];
        final int iM1 = this.C0.M1();
        int i10 = -1;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((ga.c) listE.get(i11)).g();
            if (((ga.c) listE.get(i11)).d() == iM1) {
                i10 = i11;
            }
        }
        q5.k.l(G()).f0(w7.u.Xb).d0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: tb.w
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                k0.t3(this.f12710a, listE, iM1, adapterView, view2, i12, j10);
            }
        }).h0();
    }

    public void O3(List list) {
        this.G0 = list;
        ha.g gVar = this.F0;
        if (gVar != null) {
            gVar.t(list);
        }
    }

    public final void P3() {
        d dVarE3 = E3(this.f12683s0.getText().toString());
        K3(null);
        if (dVarE3.d() != 2) {
            if (dVarE3.g()) {
                L3(dVarE3.c(), dVarE3.e());
                return;
            } else {
                M3(dVarE3.e());
                return;
            }
        }
        int i10 = this.M0;
        if (i10 != 0) {
            L3(i10, dVarE3.e());
        } else {
            M3(dVarE3.e());
        }
    }

    public final void Q3() {
        this.F0.s(this.C0.Y());
    }

    public final void R3() {
        if (this.I0.b(4)) {
            boolean zIsEmpty = this.B0.isEmpty();
            boolean zB = this.I0.b(1);
            int iD = com.tuyafeng.support.utils.f.d(G(), w7.n.f13763p);
            int i10 = (zB || zIsEmpty) ? iD : 0;
            if (zB && !zIsEmpty) {
                iD = 0;
            }
            float f10 = i10;
            float f11 = iD;
            com.tuyafeng.support.utils.x.P(this.f12689y0, new com.tuyafeng.support.utils.g().h(v8.h.c(G())).e(f10, f10, f11, f11).a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        H3(view);
        A3();
    }

    @Override // m8.c
    public void m(FragmentManager fragmentManager, Fragment fragment) {
        if (fragment instanceof w0) {
            this.f12681q0.setDescendantFocusability(393216);
            this.f12681q0.clearFocus();
            ((w0) fragment).h0().a(new androidx.lifecycle.h() { // from class: tb.h
                @Override // androidx.lifecycle.h
                public final void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
                    k0.a3(this.f12670c, jVar, event);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        la.s.b(G()).b(this);
        this.F0.t(this.G0);
        Q3();
        this.K0 = c.f(this.C0);
        for (ga.c cVar : q2.e(G())) {
            this.L0.put(Integer.valueOf(cVar.d()), cVar.g());
        }
    }

    public final void w3(int i10) {
        String str = (String) this.L0.get(Integer.valueOf(i10));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.M0 = i10;
        this.f12687w0.setText(com.tuyafeng.support.utils.p.j(str, 16));
        this.f12687w0.setVisibility(0);
    }

    public final String x3(String str) {
        int iB;
        if (this.M0 != 0 || (iB = c.b(this.K0, str)) == 0) {
            return str;
        }
        int iE = com.tuyafeng.support.utils.p.e(str);
        w3(iB);
        String strTrim = str.substring(iE).trim();
        this.f12683s0.setText(strTrim);
        this.f12683s0.setSelection(strTrim.length());
        return strTrim;
    }

    public final void y3(View view, y.k0 k0Var) {
        int i10;
        if (!h3.l(k0Var, view)) {
            if (this.I0.b(4)) {
                h3.g(k0Var, true, view, null, null);
                return;
            } else {
                boolean zB = this.I0.b(1);
                h3.g(k0Var, true, view, zB ? this.f12682r0 : null, zB ? null : this.f12682r0);
                return;
            }
        }
        r.f fVarF = k0Var.f(y.k0.m.b() | y.k0.m.f());
        if (r.f.f11874e.equals(fVarF)) {
            boolean zB2 = this.I0.b(1);
            h3.g(k0Var, false, view, zB2 ? this.f12682r0 : null, zB2 ? null : this.f12682r0);
            return;
        }
        if (Resources.getSystem().getConfiguration().orientation == 2) {
            view.setPadding(fVarF.f11875a, 0, fVarF.f11877c, 0);
            this.f12682r0.setPadding(0, 0, 0, 0);
            return;
        }
        y.c cVarE = k0Var.e();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (cVarE == null || measuredWidth <= 0 || measuredHeight <= 0) {
            view.setPadding(0, 0, 0, 0);
            return;
        }
        r.f fVarF2 = k0Var.f(y.k0.m.c());
        List<Rect> listA = cVarE.a();
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int iH = com.tuyafeng.support.utils.x.h(view.getContext(), 16.0f);
        for (Rect rect : listA) {
            int i11 = rect.top;
            if (i11 <= iH) {
                int i12 = rect.left;
                int i13 = iH * 2;
                if (i12 < i13) {
                    iArr[0] = Math.max(iArr[0], rect.right);
                } else if (rect.right >= measuredWidth - i13) {
                    iArr[2] = Math.max(iArr[2], measuredWidth - i12);
                } else {
                    iArr[1] = Math.max(iArr[1], rect.bottom);
                }
            } else if (fVarF2.f11878d <= 0 && (i10 = rect.bottom) >= measuredHeight - iH) {
                int i14 = rect.left;
                int i15 = iH * 2;
                if (i14 < i15) {
                    iArr2[0] = Math.max(iArr2[0], rect.right);
                } else if (rect.right >= measuredWidth - i15) {
                    iArr2[2] = Math.max(iArr2[2], measuredWidth - i14);
                } else {
                    iArr2[3] = Math.max(iArr2[3], i10 - i11);
                }
            }
        }
        if (this.I0.b(1)) {
            this.f12682r0.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else {
            this.f12682r0.setPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        }
        view.setPadding(0, 0, 0, 0);
    }

    public final void z3() {
        L0().e1();
    }
}
