package ua;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import h6.a;
import i6.i0;
import java.util.Collections;
import java.util.List;
import mark.via.common.widget.SizedLinearLayoutManager;
import mark.via.common.widget.v0;
import ua.t;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class t extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public c0 f12921m0;

    /* renamed from: n0, reason: collision with root package name */
    public RecyclerView f12922n0;

    /* renamed from: o0, reason: collision with root package name */
    public ImageView f12923o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f12924p0;

    /* renamed from: q0, reason: collision with root package name */
    public TextView f12925q0;

    /* renamed from: r0, reason: collision with root package name */
    public y5.f f12926r0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        public static /* synthetic */ void q(a aVar, a6.o oVar) {
            aVar.getClass();
            TextView textView = (TextView) oVar.findViewById(a6.o.f122e);
            textView.setTextSize(0, x8.h.r(t.this.I()));
            r3.p(textView);
            oVar.findViewById(a6.o.f123j).setVisibility(8);
            CheckBox checkBox = (CheckBox) oVar.findViewById(a6.o.f124k);
            checkBox.setClickable(true);
            checkBox.setFocusable(true);
            g6.y.i(checkBox, g6.y.h(t.this.I(), 24.0f));
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            return new h6.a(new a6.o(viewGroup.getContext()), new FrameLayout.LayoutParams(-1, -2)).F(1, 16).V(new a.InterfaceC0076a() { // from class: ua.r
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    t.a.q(this.f12918a, (a6.o) obj);
                }
            }).l();
        }

        @Override // y5.i
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, final r5.c cVar, int i10) {
            a6.o oVar = (a6.o) gVar.f1219a;
            gVar.X(a6.o.f122e, cVar.g());
            CheckBox checkBox = (CheckBox) oVar.findViewById(a6.o.f124k);
            checkBox.setOnCheckedChangeListener(null);
            checkBox.setChecked(cVar.j());
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ua.s
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    t.this.f12921m0.B(cVar, z10);
                }
            });
        }
    }

    public static /* synthetic */ void V2(t tVar, TextView textView) {
        textView.setTextSize(0, x8.h.s(tVar.I()));
        textView.setTextColor(g6.e.a(tVar.I(), x7.k.f13665k));
        textView.setText(x7.u.uc);
        x8.g.k(textView);
        r3.n(textView);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        x8.g.d(textView);
    }

    public static /* synthetic */ void W2(t tVar, ImageView imageView) {
        imageView.setImageDrawable(lb.b.a(tVar.I(), x7.o.f13747n, x7.u.Rd));
        imageView.setColorFilter(g6.e.a(tVar.I(), x7.k.f13662h));
        imageView.setContentDescription(tVar.Z0(x7.u.f14190v0));
    }

    public static /* synthetic */ void X2(t tVar, v0 v0Var) {
        SizedLinearLayoutManager sizedLinearLayoutManager = new SizedLinearLayoutManager(tVar.I());
        int iMin = Math.min(g6.y.y(tVar.I()) / 2, g6.y.h(tVar.I(), 600.0f));
        int iMin2 = Math.min(g6.y.y(tVar.I()) / 5, g6.y.h(tVar.I(), 200.0f));
        sizedLinearLayoutManager.N2(iMin);
        sizedLinearLayoutManager.O2(iMin2);
        v0Var.setLayoutManager(sizedLinearLayoutManager);
        r3.d(v0Var);
        r3.h(v0Var);
    }

    public static /* synthetic */ void Z2(t tVar, List list) {
        tVar.f12926r0.M(list);
        tVar.f12926r0.l();
        tVar.f12925q0.setVisibility(list.isEmpty() ? 0 : 8);
        tVar.f12922n0.setVisibility(list.isEmpty() ? 8 : 0);
    }

    public static /* synthetic */ void a3(t tVar, TextView textView) {
        tVar.getClass();
        r3.e(textView);
        textView.setTextSize(0, x8.h.t(tVar.I()));
        textView.setTextColor(g6.e.a(tVar.I(), x7.k.f13665k));
        textView.setVisibility(8);
        textView.setGravity(17);
    }

    public static /* synthetic */ void b3(t tVar, View view, int i10, r5.c cVar) {
        tVar.f12921m0.y(cVar);
        tVar.f12921m0.z(1);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int iL = g6.y.l();
        int iL2 = g6.y.l();
        this.f12924p0 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).F(1, 16).g(4, iL2).V(new a.InterfaceC0076a() { // from class: ua.j
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                t.V2(this.f12910a, (TextView) obj);
            }
        }).l();
        this.f12923o0 = (ImageView) new h6.a(new ImageView(I()), new RelativeLayout.LayoutParams(-2, -2)).o(iL2).Y(1, 48).e(g6.f.e(I(), x7.o.f13720e)).F(1, 13).h(8).g(16, iL).g(128, iL).V(new a.InterfaceC0076a() { // from class: ua.k
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                t.W2(this.f12911a, (ImageView) obj);
            }
        }).l();
        this.f12922n0 = (RecyclerView) new h6.a(new v0(I()), new RelativeLayout.LayoutParams(-1, -2)).g(32, iL).V(new a.InterfaceC0076a() { // from class: ua.l
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                t.X2(this.f12912a, (v0) obj);
            }
        }).l();
        this.f12925q0 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-1, -2)).n(1, 100).g(32, iL).V(new a.InterfaceC0076a() { // from class: ua.m
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                t.a3(this.f12913a, (TextView) obj);
            }
        }).l();
        RelativeLayout relativeLayout = (RelativeLayout) new h6.a(new RelativeLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        relativeLayout.addView(this.f12924p0);
        relativeLayout.addView(this.f12923o0);
        relativeLayout.addView(this.f12922n0);
        relativeLayout.addView(this.f12925q0);
        return relativeLayout;
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        View viewC1 = c1();
        if (viewC1 != null) {
            viewC1.requestLayout();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f12926r0 = new y5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: ua.n
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                t.b3(this.f12914a, view2, i10, (r5.c) obj);
            }
        });
        this.f12926r0.K(r5.c.class, aVar);
        this.f12922n0.setAdapter(this.f12926r0);
        this.f12923o0.setOnClickListener(new View.OnClickListener() { // from class: ua.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12915a.f12921m0.x(new a6.q(0, null));
            }
        });
        String strF = i0.f7006a.f(this.f12921m0.v());
        this.f12924p0.setText(strF.isEmpty() ? Z0(x7.u.uc) : a1(x7.u.gg, strF));
        this.f12921m0.f12890k.g(d1(), new androidx.lifecycle.m() { // from class: ua.p
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                t.Z2(this.f12916a, (List) obj);
            }
        });
        this.f12921m0.f12896q.g(d1(), new androidx.lifecycle.m() { // from class: ua.q
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                t tVar = this.f12917a;
                tVar.e3(tVar.f12921m0.r(), ((Boolean) obj).booleanValue());
            }
        });
    }

    public final int d3(int i10) {
        List list = (List) this.f12921m0.f12890k.e();
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((r5.c) list.get(i11)).e() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void e3(int i10, boolean z10) {
        List list;
        int iD3 = d3(i10);
        if (iD3 >= 0 && (list = (List) this.f12921m0.f12890k.e()) != null) {
            ((r5.c) list.get(iD3)).n(z10);
            this.f12926r0.m(iD3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        if (M0() != null) {
            this.f12921m0 = (c0) new androidx.lifecycle.y(M0()).a(c0.class);
        }
    }
}
