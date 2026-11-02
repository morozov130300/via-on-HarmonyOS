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
import h6.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import tb.k0;
import w5.k;
import x.k0;
import z8.l3;
import z8.r3;
import z8.v2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k0 extends o8.a implements o8.c {
    public w9.l A0;
    public String B0;
    public ka.g D0;
    public Map I0;
    public int K0;

    /* renamed from: o0, reason: collision with root package name */
    public RelativeLayout f12382o0;

    /* renamed from: p0, reason: collision with root package name */
    public LinearLayout f12383p0;

    /* renamed from: q0, reason: collision with root package name */
    public e f12384q0;

    /* renamed from: r0, reason: collision with root package name */
    public ImageView f12385r0;

    /* renamed from: s0, reason: collision with root package name */
    public ImageView f12386s0;

    /* renamed from: t0, reason: collision with root package name */
    public ImageView f12387t0;

    /* renamed from: u0, reason: collision with root package name */
    public TextView f12388u0;

    /* renamed from: v0, reason: collision with root package name */
    public ImageView f12389v0;

    /* renamed from: w0, reason: collision with root package name */
    public View f12390w0;

    /* renamed from: x0, reason: collision with root package name */
    public RecyclerView f12391x0;

    /* renamed from: y0, reason: collision with root package name */
    public y5.f f12392y0;

    /* renamed from: m0, reason: collision with root package name */
    public int f12380m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    public int f12381n0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public final List f12393z0 = new ArrayList();
    public boolean C0 = false;
    public List E0 = null;
    public boolean F0 = false;
    public final w9.b G0 = new w9.b(0);
    public boolean H0 = true;
    public final Map J0 = new HashMap();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f12394c;

        public a(boolean z10) {
            this.f12394c = z10;
        }

        public static /* synthetic */ void q(a aVar, ka.a aVar2, View view) {
            aVar.getClass();
            String strB = aVar2.b();
            if (strB == null || strB.isEmpty()) {
                return;
            }
            k0.this.f12384q0.setText(strB);
            k0.this.f12384q0.setSelection(k0.this.f12384q0.length());
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            View viewA = b6.c.e(x7.r.A).a(viewGroup);
            ((ImageView) viewA.findViewById(x7.p.Q)).setImageDrawable(lb.b.a(viewA.getContext(), x7.o.f13715c0, x7.u.de));
            TextView textView = (TextView) viewA.findViewById(x7.p.E1);
            TextView textView2 = (TextView) viewA.findViewById(x7.p.F1);
            r3.p(textView);
            r3.p(textView2);
            r3.n(textView);
            r3.n(textView2);
            x8.g.d(textView);
            x8.g.d(textView2);
            return viewA;
        }

        @Override // y5.i
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, final ka.a aVar, int i10) {
            int i11;
            int i12;
            gVar.X(x7.p.E1, g6.p.j(aVar.c(), 256));
            gVar.X(x7.p.F1, g6.p.j(aVar.e(), 256));
            gVar.Y(x7.p.E1, !TextUtils.isEmpty(aVar.c()));
            gVar.Y(x7.p.F1, !TextUtils.isEmpty(aVar.e()));
            int iD = aVar.d();
            if (iD == 1) {
                i11 = x7.o.U;
                i12 = x7.u.ce;
            } else if (iD == 2) {
                i11 = x7.o.f13774w;
                i12 = x7.u.Td;
            } else if (iD == 4) {
                i11 = x7.o.f13782y1;
                i12 = x7.u.vf;
            } else if (iD == 8 || iD == 32) {
                i11 = x7.o.f13748n0;
                i12 = x7.u.ie;
            } else {
                i11 = x7.o.f13737j1;
                i12 = x7.u.qf;
            }
            gVar.V(x7.p.f13808h0, lb.b.a(k0.this.I(), i11, i12));
            if (!this.f12394c) {
                gVar.P(x7.p.Q).setRotation(-90.0f);
            }
            gVar.P(x7.p.Q).setOnClickListener(new View.OnClickListener() { // from class: tb.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.a.q(this.f12377a, aVar, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bundle C3(String str, String str2, String str3, int i10, boolean z10, boolean z11, int i11, boolean z12, boolean z13) {
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

    private void G3() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        x.r.d0(this.f12382o0, new x.m() { // from class: tb.y
            @Override // x.m
            public final x.k0 a(View view, x.k0 k0Var) {
                return k0.Y2(this.f12425a, view, k0Var);
            }
        });
    }

    public static /* synthetic */ void U2(k0 k0Var, View view) {
        k0Var.f12385r0.setVisibility(8);
        k0Var.f12393z0.clear();
        k0Var.f12392y0.l();
        k0Var.f12384q0.setText("");
        k0Var.D3();
    }

    public static /* synthetic */ void V2(k0 k0Var, boolean z10, RecyclerView recyclerView) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        k0Var.getClass();
        r3.d(recyclerView);
        recyclerView.setScrollBarSize(g6.f.d(k0Var.I(), x7.n.f13690i));
        recyclerView.setVerticalScrollBarEnabled(true);
        g6.y.V(recyclerView, g6.f.e(recyclerView.getContext(), x7.m.f13676f));
        recyclerView.setFadingEdgeLength(g6.y.h(k0Var.I(), 32.0f));
        recyclerView.setVerticalFadingEdgeEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        boolean z11 = !z10;
        linearLayoutManager.E2(z11);
        linearLayoutManager.D2(z11);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
    }

    public static /* synthetic */ void W2(View view) {
        view.setClickable(true);
        view.setFocusable(false);
        view.setImportantForAccessibility(2);
    }

    public static /* synthetic */ void X2(k0 k0Var, ImageView imageView) {
        k0Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.f13783z, x7.u.Ud));
        imageView.setContentDescription(k0Var.Z0(x7.u.f14058l3));
    }

    public static /* synthetic */ x.k0 Y2(k0 k0Var, View view, x.k0 k0Var2) {
        int i10;
        k0Var.getClass();
        if (!l3.i(k0Var2, view)) {
            if (k0Var.G0.b(4)) {
                l3.d(k0Var2, true, view, null, null);
                return k0Var2;
            }
            boolean zB = k0Var.G0.b(1);
            l3.d(k0Var2, true, view, zB ? k0Var.f12383p0 : null, zB ? null : k0Var.f12383p0);
            return k0Var2;
        }
        r.f fVarF = k0Var2.f(k0.m.b() | k0.m.f());
        char c10 = 0;
        if (r.f.f11464e.equals(fVarF)) {
            boolean zB2 = k0Var.G0.b(1);
            l3.d(k0Var2, false, view, zB2 ? k0Var.f12383p0 : null, zB2 ? null : k0Var.f12383p0);
            return k0Var2;
        }
        if (Resources.getSystem().getConfiguration().orientation == 2) {
            view.setPadding(fVarF.f11465a, 0, fVarF.f11467c, 0);
            k0Var.f12383p0.setPadding(0, 0, 0, 0);
            return k0Var2;
        }
        x.c cVarE = k0Var2.e();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (cVarE != null && measuredWidth > 0 && measuredHeight > 0) {
            r.f fVarF2 = k0Var2.f(k0.m.c());
            List<Rect> listA = cVarE.a();
            int[] iArr = {0, 0, 0, 0};
            int[] iArr2 = {0, 0, 0, 0};
            int iH = g6.y.h(view.getContext(), 16.0f);
            for (Rect rect : listA) {
                int i11 = rect.top;
                if (i11 <= iH) {
                    int i12 = rect.left;
                    int i13 = iH * 2;
                    if (i12 < i13) {
                        iArr[c10] = Math.max(iArr[c10], rect.right);
                    } else if (rect.right >= measuredWidth - i13) {
                        iArr[2] = Math.max(iArr[2], measuredWidth - i12);
                    } else {
                        iArr[1] = Math.max(iArr[1], rect.bottom);
                    }
                } else {
                    if (fVarF2.f11468d <= 0 && (i10 = rect.bottom) >= measuredHeight - iH) {
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
                    c10 = 0;
                }
                c10 = 0;
            }
            if (k0Var.G0.b(1)) {
                k0Var.f12383p0.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            } else {
                k0Var.f12383p0.setPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            }
            view.setPadding(0, 0, 0, 0);
        }
        return k0Var2;
    }

    public static /* synthetic */ void Z2(k0 k0Var, TextView textView) {
        textView.setTextColor(x8.h.p(k0Var.I()));
        textView.setTextSize(0, x8.h.v(k0Var.I()));
        textView.setGravity(17);
        x8.g.d(textView);
        textView.setVisibility(8);
    }

    public static /* synthetic */ void a3(k0 k0Var, View view) {
        String string = k0Var.f12384q0.getText().toString();
        if (string.isEmpty() || string.equals(k0Var.B0)) {
            string = null;
        }
        k0Var.L3(string);
        k0Var.A3();
    }

    public static /* synthetic */ void b3(final k0 k0Var, String str, Bundle bundle) {
        k0Var.getClass();
        String string = bundle.getString("resultUrl", null);
        boolean z10 = bundle.getBoolean("resultGo", false);
        final int[] intArray = bundle.getIntArray("resultSelection");
        if (string != null) {
            k0Var.f12384q0.setText(string);
            if (z10) {
                k0Var.Q3();
            } else {
                k0Var.f12384q0.post(new Runnable() { // from class: tb.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        k0.u3(this.f12354e, intArray);
                    }
                });
            }
        }
        k0Var.N0().x("resultUrl");
    }

    public static /* synthetic */ void c3(k0 k0Var, androidx.lifecycle.h hVar, Lifecycle.Event event) {
        RelativeLayout relativeLayout;
        k0Var.getClass();
        if (event != Lifecycle.Event.ON_DESTROY || (relativeLayout = k0Var.f12382o0) == null) {
            return;
        }
        relativeLayout.setDescendantFocusability(131072);
    }

    public static /* synthetic */ boolean e3(final k0 k0Var, View view, int i10, ka.a aVar) {
        k0Var.getClass();
        if (aVar.d() != 32) {
            return false;
        }
        w5.k.l(k0Var.I()).d0(x7.u.f13931c2).I(x7.u.f13945d2).V(R.string.ok, new k.m() { // from class: tb.z
            @Override // w5.k.m
            public final void a(View view2, k.p pVar) {
                k0.k3(this.f12426a, view2, pVar);
            }
        }).N(R.string.cancel, null).f0();
        return true;
    }

    public static /* synthetic */ void g3(k0 k0Var, ImageView imageView) {
        k0Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.M, x7.u.Yd));
        imageView.setContentDescription(k0Var.Z0(x7.u.f14086n3));
    }

    public static /* synthetic */ void j3(k0 k0Var, HorizontalScrollView horizontalScrollView) {
        k0Var.getClass();
        horizontalScrollView.setFillViewport(true);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setHorizontalFadingEdgeEnabled(true);
        horizontalScrollView.setFadingEdgeLength(g6.y.h(k0Var.I(), 12.0f));
        r3.f(horizontalScrollView);
    }

    public static /* synthetic */ void k3(k0 k0Var, View view, k.p pVar) {
        k0Var.D0.i(null);
        k0Var.f12384q0.setText((CharSequence) null);
    }

    public static /* synthetic */ boolean l3(k0 k0Var, View view, int i10, KeyEvent keyEvent) {
        k0Var.getClass();
        if (i10 == 67 && keyEvent.getAction() == 0 && k0Var.f12384q0.getSelectionStart() == 0 && k0Var.f12384q0.getSelectionEnd() == 0 && k0Var.K0 != 0) {
            k0Var.E3();
            return true;
        }
        if (i10 != 66 || keyEvent.getAction() != 1) {
            return false;
        }
        k0Var.Q3();
        return true;
    }

    public static /* synthetic */ void m3(k0 k0Var, List list) {
        int i10 = k0Var.f12381n0;
        if (i10 != k0Var.f12380m0) {
            k0Var.f12380m0 = i10;
            if (list.isEmpty()) {
                k0Var.F0 = true;
                return;
            } else {
                k0Var.f12393z0.clear();
                k0Var.F0 = false;
            }
        }
        if (k0Var.F0) {
            k0Var.f12393z0.clear();
        }
        k0Var.f12393z0.addAll(list);
        k0Var.f12392y0.l();
        k0Var.f12391x0.p1(0);
        k0Var.D3();
    }

    public static /* synthetic */ void n3(k0 k0Var, ImageView imageView) {
        k0Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.f13737j1, x7.u.qf));
        imageView.setContentDescription(k0Var.Z0(x7.u.Kb));
    }

    public static /* synthetic */ String p3(k0 k0Var, CharSequence charSequence) {
        ImageView imageView = k0Var.f12385r0;
        if (imageView != null) {
            imageView.setVisibility(charSequence.length() == 0 ? 8 : 0);
        }
        return k0Var.z3(charSequence.toString());
    }

    public static /* synthetic */ x6.l q3(k0 k0Var, String str) {
        k0Var.f12381n0++;
        d dVarF3 = k0Var.F3(str.toString());
        if (dVarF3.d() == 2) {
            ka.a aVar = new ka.a(0, dVarF3.f(), null, 64);
            aVar.h(dVarF3.f());
            return x6.j.w(Collections.singletonList(aVar));
        }
        int iW = k0Var.A0.W();
        if (dVarF3.g()) {
            iW = v2.f(dVarF3.c(), iW);
        }
        return k0Var.D0.r(dVarF3.e(), k0Var.A0.X1(), iW).D(g7.a.c());
    }

    public static /* synthetic */ void r3(k0 k0Var, e eVar) {
        k0Var.getClass();
        x8.g.h(eVar);
        eVar.setHint(x7.u.Tb);
        eVar.setImeOptions(2);
        eVar.setInputType(524289);
        eVar.setGravity(16);
        eVar.setSelectAllOnFocus(true);
        eVar.setTextColor(g6.e.a(k0Var.I(), x7.k.f13665k));
        eVar.setHintTextColor(g6.e.a(k0Var.I(), x7.k.f13665k));
        if (Build.VERSION.SDK_INT >= 26) {
            eVar.setImportantForAutofill(2);
        }
        eVar.setTextSize(0, g6.f.d(k0Var.I(), x7.n.A));
        eVar.setSingleLine(true);
        eVar.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        r3.n(eVar);
        x8.g.d(eVar);
    }

    public static /* synthetic */ void s3(k0 k0Var, View view, int i10, ka.a aVar) {
        k0Var.getClass();
        if (aVar.d() == 4) {
            k0Var.N3("VIA-SWITCH-TAB:" + aVar.a());
            return;
        }
        if (aVar.d() == 64) {
            k0Var.f12384q0.setText(aVar.b());
            e eVar = k0Var.f12384q0;
            eVar.setSelection(eVar.length());
        } else if (k0Var.K0 == 0 || !(aVar.d() == 16 || aVar.d() == 32)) {
            k0Var.N3(aVar.b());
        } else {
            k0Var.M3(k0Var.K0, aVar.b());
        }
    }

    public static /* synthetic */ void t3(k0 k0Var, ImageView imageView) {
        k0Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.f13736j0, x7.u.he));
        imageView.setContentDescription(k0Var.Z0(x7.u.Tb));
    }

    public static /* synthetic */ void u3(k0 k0Var, int[] iArr) {
        z8.f.l(k0Var.f12384q0);
        if (iArr == null || iArr.length != 2 || iArr[0] == -1) {
            e eVar = k0Var.f12384q0;
            eVar.setSelection(eVar.getText().length());
        }
    }

    public static /* synthetic */ void v3(k0 k0Var, List list, int i10, AdapterView adapterView, View view, int i11, long j10) {
        k0Var.getClass();
        ja.c cVar = (ja.c) list.get(i11);
        if (cVar.d() == i10) {
            return;
        }
        if (v2.g(cVar.d())) {
            k0Var.A0.o1(cVar.a());
        }
        k0Var.A0.q(cVar.d());
        k0Var.R3();
        k0Var.C0 = true;
    }

    public static /* synthetic */ void w3(k0 k0Var) {
        if (k0Var.K0 != 0) {
            k0Var.E3();
        }
    }

    public final void A3() {
        N0().e1();
    }

    public final void B3() {
        ((autodispose2.n) u8.c.a(this.f12384q0).x(new a7.f() { // from class: tb.b0
            @Override // a7.f
            public final Object apply(Object obj) {
                return k0.p3(this.f12359a, (CharSequence) obj);
            }
        }).h().f(200L, TimeUnit.MILLISECONDS).F(new a7.f() { // from class: tb.c0
            @Override // a7.f
            public final Object apply(Object obj) {
                return k0.q3(this.f12360a, (String) obj);
            }
        }).D(g7.a.c()).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: tb.d0
            @Override // a7.e
            public final void accept(Object obj) {
                k0.m3(this.f12365e, (List) obj);
            }
        }, new x7.c0());
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.G0.d(y0() == null ? 0 : y0().getInt("uiflags", 0));
        final boolean zB = this.G0.b(1);
        int iD = g6.f.d(I(), x7.n.E);
        int iD2 = g6.f.d(I(), x7.n.D);
        this.f12382o0 = (RelativeLayout) new h6.a(new RelativeLayout(I()), new ViewGroup.LayoutParams(-1, -1)).j(Z0(R.string.cancel)).l();
        this.f12383p0 = (LinearLayout) new h6.a(new LinearLayout(I()), new RelativeLayout.LayoutParams(-1, -2)).o(g6.y.l()).h(zB ? 1 : 128).V(new a.InterfaceC0076a() { // from class: tb.l
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        this.f12387t0 = (ImageView) new h6.a(new ImageView(I()), new LinearLayout.LayoutParams(iD, iD)).o(g6.y.l()).E(iD2).d(x7.o.f13726g).V(new a.InterfaceC0076a() { // from class: tb.m
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k0.n3(this.f12396a, (ImageView) obj);
            }
        }).l();
        this.f12388u0 = (TextView) new h6.a(new TextView(I()), new LinearLayout.LayoutParams(-2, -2)).p(16).x(1, 4).H(1, 6, 2, 6, 2).e(new g6.g().k(x8.h.p(I())).l(g6.y.h(I(), 1.0f)).c(g6.y.h(I(), 4.0f)).a()).V(new a.InterfaceC0076a() { // from class: tb.n
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k0.Z2(this.f12398a, (TextView) obj);
            }
        }).l();
        this.f12385r0 = (ImageView) new h6.a(new ImageView(I()), new LinearLayout.LayoutParams(iD, iD)).o(g6.y.l()).E(iD2).d(x7.o.f13726g).V(new a.InterfaceC0076a() { // from class: tb.o
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k0.X2(this.f12400a, (ImageView) obj);
            }
        }).l();
        this.f12386s0 = (ImageView) new h6.a(new ImageView(I()), new LinearLayout.LayoutParams(iD, iD)).o(g6.y.l()).E(iD2).d(x7.o.f13726g).V(new a.InterfaceC0076a() { // from class: tb.p
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k0.g3(this.f12401a, (ImageView) obj);
            }
        }).l();
        this.f12389v0 = (ImageView) new h6.a(new ImageView(I()), new LinearLayout.LayoutParams(iD, iD)).o(g6.y.l()).E(iD2).d(x7.o.f13726g).V(new a.InterfaceC0076a() { // from class: tb.r
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k0.t3(this.f12404a, (ImageView) obj);
            }
        }).l();
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) new h6.a(new HorizontalScrollView(I()), new LinearLayout.LayoutParams(0, iD)).W(1.0f).V(new a.InterfaceC0076a() { // from class: tb.s
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k0.j3(this.f12406a, (HorizontalScrollView) obj);
            }
        }).l();
        this.f12384q0 = (e) new h6.a(new e(I()), new FrameLayout.LayoutParams(-2, iD)).f(0).p(16).V(new a.InterfaceC0076a() { // from class: tb.t
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k0.r3(this.f12408a, (e) obj);
            }
        }).l();
        this.f12391x0 = (RecyclerView) new h6.a(new RecyclerView(I()), new RelativeLayout.LayoutParams(-1, -2)).f(g6.e.a(I(), x7.k.f13656b)).g(zB ? 32 : 64, this.f12383p0.getId()).r(1, 0, zB ? 0 : 72, 0, zB ? 72 : 0).V(new a.InterfaceC0076a() { // from class: tb.u
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                k0.V2(this.f12409a, zB, (RecyclerView) obj);
            }
        }).l();
        this.f12390w0 = new h6.a(new View(I()), new RelativeLayout.LayoutParams(-1, -2)).g(16, this.f12383p0.getId()).g(128, this.f12383p0.getId()).f(x8.h.c(I())).V(new a.InterfaceC0076a() { // from class: tb.v
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k0.W2((View) obj);
            }
        }).l();
        this.f12383p0.addView(this.f12387t0);
        this.f12383p0.addView(this.f12388u0);
        horizontalScrollView.addView(this.f12384q0);
        this.f12383p0.addView(horizontalScrollView);
        this.f12383p0.addView(this.f12385r0);
        this.f12383p0.addView(this.f12386s0);
        this.f12383p0.addView(this.f12389v0);
        this.f12382o0.addView(this.f12390w0);
        this.f12382o0.addView(this.f12391x0);
        this.f12382o0.addView(this.f12383p0);
        return this.f12382o0;
    }

    public final void D3() {
        boolean zIsEmpty = this.f12393z0.isEmpty();
        if (this.H0 == zIsEmpty) {
            return;
        }
        this.H0 = zIsEmpty;
        S3();
    }

    public final void E3() {
        this.K0 = 0;
        this.f12388u0.setText((CharSequence) null);
        this.f12388u0.setVisibility(8);
    }

    public final d F3(String str) {
        if (str == null) {
            str = "";
        }
        String strA = b.a(str);
        return strA != null ? d.a(str, strA) : (this.K0 == 0 || str.isEmpty()) ? d.h(str) : d.b(str, this.K0);
    }

    public final String H3(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            this.C0 = true;
            return str3;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str) || u9.d.m(I(), str)) {
            return "";
        }
        String strZ0 = pa.r.j().Z0();
        i6.g0 g0Var = i6.g0.f6993a;
        String strG = g0Var.g(str, strZ0);
        return TextUtils.isEmpty(strG) ? g0Var.f(str) : strG;
    }

    public final void I3(View view) {
        Bundle bundle = y0() == null ? new Bundle() : y0();
        boolean zB = this.G0.b(1);
        int i10 = bundle.getInt("bg", 0);
        boolean zB2 = this.G0.b(2);
        this.f12392y0 = new y5.f(this.f12393z0);
        a aVar = new a(zB);
        this.f12392y0.K(ka.a.class, aVar);
        this.f12391x0.setAdapter(this.f12392y0);
        aVar.j(new y5.g() { // from class: tb.e0
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                k0.s3(this.f12368a, view2, i11, (ka.a) obj);
            }
        });
        aVar.k(new y5.h() { // from class: tb.f0
            @Override // y5.h
            public final boolean a(View view2, int i11, Object obj) {
                return k0.e3(this.f12369a, view2, i11, (ka.a) obj);
            }
        });
        String string = bundle.getString("title", "");
        String string2 = bundle.getString("url", "");
        String string3 = bundle.getString("keyword", "");
        int i11 = bundle.getInt("search_engine", 0);
        if (i11 != 0 && i11 != this.A0.M1()) {
            y3(i11);
        }
        this.B0 = H3(string2, string3, string);
        String strK3 = K3();
        if (bundle.getBoolean("incognito", false)) {
            int imeOptions = this.f12384q0.getImeOptions();
            int i12 = 524288 | imeOptions;
            if (Build.VERSION.SDK_INT >= 26) {
                i12 = 17301504 | imeOptions;
            }
            this.f12384q0.setImeOptions(i12);
        }
        e eVar = this.f12384q0;
        if (strK3 == null || strK3.isEmpty()) {
            strK3 = this.B0;
        }
        eVar.setText(strK3);
        this.f12384q0.setOnDeleteAtStart(new Runnable() { // from class: tb.g0
            @Override // java.lang.Runnable
            public final void run() {
                k0.w3(this.f12371e);
            }
        });
        this.f12384q0.setOnKeyListener(new View.OnKeyListener() { // from class: tb.h0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i13, KeyEvent keyEvent) {
                return k0.l3(this.f12373a, view2, i13, keyEvent);
            }
        });
        this.f12385r0.setVisibility(this.f12384q0.length() == 0 ? 8 : 0);
        this.f12385r0.setOnClickListener(new View.OnClickListener() { // from class: tb.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k0.U2(this.f12375a, view2);
            }
        });
        this.f12387t0.setOnClickListener(new View.OnClickListener() { // from class: tb.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12370a.O3(view2);
            }
        });
        this.f12389v0.setOnClickListener(new View.OnClickListener() { // from class: tb.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12372a.Q3();
            }
        });
        this.f12386s0.setOnClickListener(new View.OnClickListener() { // from class: tb.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12374a.J3();
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: tb.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k0.a3(this.f12376a, view2);
            }
        });
        if (zB2) {
            boolean zC = g6.y.C(i10);
            Context contextI = I();
            int i13 = R.color.white;
            int iB = g6.f.b(contextI, zC ? x7.m.f13677g : R.color.white);
            Context contextI2 = I();
            if (zC) {
                i13 = x7.m.f13674d;
            }
            g6.y.S(g6.f.b(contextI2, i13), this.f12387t0, this.f12385r0, this.f12386s0, this.f12389v0);
            this.f12384q0.setTextColor(iB);
            this.f12384q0.setHintTextColor(iB);
            this.f12388u0.setTextColor(iB);
            g6.y.O(this.f12388u0, new g6.g().k(iB).l(g6.y.h(I(), 1.0f)).c(g6.y.h(I(), 4.0f)).a());
            this.f12390w0.setBackgroundColor(i10);
        } else {
            S3();
        }
        int iD = g6.f.d(I(), x7.n.f13697p);
        g6.y.O(this.f12391x0, new g6.g().h(x8.h.c(I())).e(zB ? 0.0f : iD, zB ? 0.0f : iD, zB ? iD : 0.0f, zB ? iD : 0.0f).a());
        int i14 = this.G0.b(4) ? iD : 0;
        g6.y.O(this.f12382o0, new g6.g().h(g6.f.b(I(), x7.m.f13680j)).i(1887469696).e(!zB ? 0.0f : i14, !zB ? 0.0f : i14, !zB ? i14 : 0.0f, zB ? 0.0f : i14).a());
        this.f12384q0.post(new Runnable() { // from class: tb.k
            @Override // java.lang.Runnable
            public final void run() {
                z8.f.l(this.f12379e.f12384q0);
            }
        });
        G3();
    }

    public final void J3() {
        N0().y1("resultUrl", this, new androidx.fragment.app.i0() { // from class: tb.x
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                k0.b3(this.f12424a, str, bundle);
            }
        });
        androidx.fragment.app.l0 l0VarX = N0().q().x(true);
        int i10 = x7.i.f13636a;
        int i11 = x7.i.f13642g;
        l0VarX.v(i10, i11, i11, x7.i.f13637b).c(g6.i.f6223a, w0.class, w0.f3(this.f12384q0.getText().toString(), new int[]{this.f12384q0.getSelectionStart(), this.f12384q0.getSelectionEnd()}), null).g(null).i();
    }

    public final String K3() {
        String str;
        Bundle bundleC = v5.b.d().c("URL_INPUT_CACHE");
        if (bundleC == null) {
            return null;
        }
        String string = bundleC.getString("url");
        String string2 = bundleC.getString("title");
        if (!(TextUtils.isEmpty(string) && TextUtils.isEmpty(this.B0)) && ((str = this.B0) == null || !str.equals(string))) {
            return null;
        }
        y3(bundleC.getInt("active_search_engine", 0));
        return string2;
    }

    public final void L3(String str) {
        if (str == null || str.isEmpty()) {
            v5.b.d().b("URL_INPUT_CACHE");
        } else {
            v5.b.a().e("URL_INPUT_CACHE").f(180).d("url", this.B0).d("title", str).b("active_search_engine", this.K0).a();
        }
    }

    public final void M3(int i10, String str) {
        z8.f.e(this.f12384q0);
        A3();
        Bundle bundle = new Bundle();
        bundle.putInt("input_action", 2);
        bundle.putInt("input_engine", i10);
        bundle.putString("input_query", str);
        bundle.putString("input", str);
        N0().x1("input", bundle);
    }

    public final void N3(String str) {
        z8.f.e(this.f12384q0);
        A3();
        if (this.C0 || !this.B0.equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("input", str);
            N0().x1("input", bundle);
        }
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        z8.f.e(this.f12384q0);
        super.O1();
    }

    public final void O3(View view) {
        z8.f.e(this.f12384q0);
        final List listE = v2.e(I());
        int size = listE.size();
        String[] strArr = new String[size];
        final int iM1 = this.A0.M1();
        int i10 = -1;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((ja.c) listE.get(i11)).g();
            if (((ja.c) listE.get(i11)).d() == iM1) {
                i10 = i11;
            }
        }
        w5.k.l(I()).d0(x7.u.Kb).b0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: tb.w
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                k0.v3(this.f12413a, listE, iM1, adapterView, view2, i12, j10);
            }
        }).f0();
    }

    public void P3(List list) {
        this.E0 = list;
        ka.g gVar = this.D0;
        if (gVar != null) {
            gVar.t(list);
        }
    }

    public final void Q3() {
        d dVarF3 = F3(this.f12384q0.getText().toString());
        L3(null);
        if (dVarF3.d() != 2) {
            if (dVarF3.g()) {
                M3(dVarF3.c(), dVarF3.e());
                return;
            } else {
                N3(dVarF3.e());
                return;
            }
        }
        int i10 = this.K0;
        if (i10 != 0) {
            M3(i10, dVarF3.e());
        } else {
            N3(dVarF3.e());
        }
    }

    public final void R3() {
        this.D0.s(this.A0.W());
    }

    public final void S3() {
        if (this.G0.b(4)) {
            boolean zIsEmpty = this.f12393z0.isEmpty();
            boolean zB = this.G0.b(1);
            int iD = g6.f.d(I(), x7.n.f13697p);
            int i10 = (zB || zIsEmpty) ? iD : 0;
            if (zB && !zIsEmpty) {
                iD = 0;
            }
            float f10 = i10;
            float f11 = iD;
            g6.y.O(this.f12390w0, new g6.g().h(x8.h.c(I())).e(f10, f10, f11, f11).a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        I3(view);
        B3();
    }

    @Override // o8.c
    public void m(FragmentManager fragmentManager, Fragment fragment) {
        if (fragment instanceof w0) {
            this.f12382o0.setDescendantFocusability(393216);
            this.f12382o0.clearFocus();
            ((w0) fragment).k0().a(new androidx.lifecycle.f() { // from class: tb.q
                @Override // androidx.lifecycle.f
                public final void a(androidx.lifecycle.h hVar, Lifecycle.Event event) {
                    k0.c3(this.f12402e, hVar, event);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        pa.r.b(I()).b(this);
        this.D0.t(this.E0);
        R3();
        this.I0 = c.f(this.A0);
        for (ja.c cVar : v2.e(I())) {
            this.J0.put(Integer.valueOf(cVar.d()), cVar.g());
        }
    }

    public final void y3(int i10) {
        String str = (String) this.J0.get(Integer.valueOf(i10));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.K0 = i10;
        this.f12388u0.setText(g6.p.j(str, 16));
        this.f12388u0.setVisibility(0);
    }

    public final String z3(String str) {
        int iB;
        if (this.K0 != 0 || (iB = c.b(this.I0, str)) == 0) {
            return str;
        }
        int iE = g6.p.e(str);
        y3(iB);
        String strTrim = str.substring(iE).trim();
        this.f12384q0.setText(strTrim);
        this.f12384q0.setSelection(strTrim.length());
        return strTrim;
    }
}
