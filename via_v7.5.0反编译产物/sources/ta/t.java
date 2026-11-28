package ta;

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
import c6.a2;
import java.util.Collections;
import java.util.List;
import mark.via.common.widget.SizedLinearLayoutManager;
import mark.via.common.widget.v0;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public c0 f12641o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public RecyclerView f12642p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ImageView f12643q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public TextView f12644r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public TextView f12645s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public t5.f f12646t0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        public static /* synthetic */ void q(a aVar, v5.o oVar) {
            aVar.getClass();
            TextView textView = (TextView) oVar.findViewById(v5.o.f13406c);
            textView.setTextSize(0, v8.h.q(t.this.G()));
            r3.q(textView);
            oVar.findViewById(v5.o.f13407e).setVisibility(8);
            CheckBox checkBox = (CheckBox) oVar.findViewById(v5.o.f13408m);
            checkBox.setClickable(true);
            checkBox.setFocusable(true);
            com.tuyafeng.support.utils.x.i(checkBox, com.tuyafeng.support.utils.x.h(t.this.G(), 24.0f));
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            return new b6.a(new v5.o(viewGroup.getContext()), new FrameLayout.LayoutParams(-1, -2)).F(1, 16).V(new b6.a.InterfaceC0033a() { // from class: ta.r
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    t.a.q(this.f12638a, (v5.o) obj);
                }
            }).l();
        }

        @Override // t5.i
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, final ra.c cVar, int i10) {
            v5.o oVar = (v5.o) gVar.f1138a;
            gVar.X(v5.o.f13406c, cVar.g());
            CheckBox checkBox = (CheckBox) oVar.findViewById(v5.o.f13408m);
            checkBox.setOnCheckedChangeListener(null);
            checkBox.setChecked(cVar.j());
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ta.s
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    t.this.f12641o0.B(cVar, z10);
                }
            });
        }
    }

    public static /* synthetic */ void T2(t tVar, TextView textView) {
        textView.setTextSize(0, v8.h.r(tVar.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(tVar.G(), w7.k.f13732l));
        textView.setText(w7.u.Ic);
        v8.g.k(textView);
        r3.o(textView);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        v8.g.d(textView);
    }

    public static /* synthetic */ void U2(t tVar, ImageView imageView) {
        imageView.setImageDrawable(lb.g.a(tVar.G(), w7.o.f13810m, w7.u.ge));
        imageView.setColorFilter(com.tuyafeng.support.utils.e.a(tVar.G(), w7.k.f13729i));
        imageView.setContentDescription(tVar.X0(w7.u.f14286x0));
    }

    public static /* synthetic */ void V2(t tVar, v0 v0Var) {
        SizedLinearLayoutManager sizedLinearLayoutManager = new SizedLinearLayoutManager(tVar.G());
        int iMin = Math.min(com.tuyafeng.support.utils.x.y(tVar.G()) / 2, com.tuyafeng.support.utils.x.h(tVar.G(), 600.0f));
        int iMin2 = Math.min(com.tuyafeng.support.utils.x.y(tVar.G()) / 5, com.tuyafeng.support.utils.x.h(tVar.G(), 200.0f));
        sizedLinearLayoutManager.N2(iMin);
        sizedLinearLayoutManager.O2(iMin2);
        v0Var.setLayoutManager(sizedLinearLayoutManager);
        r3.e(v0Var);
        r3.i(v0Var);
    }

    public static /* synthetic */ void X2(t tVar, List list) {
        tVar.f12646t0.M(list);
        tVar.f12646t0.l();
        tVar.f12645s0.setVisibility(list.isEmpty() ? 0 : 8);
        tVar.f12642p0.setVisibility(list.isEmpty() ? 8 : 0);
    }

    public static /* synthetic */ void Y2(t tVar, TextView textView) {
        tVar.getClass();
        r3.f(textView);
        textView.setTextSize(0, v8.h.s(tVar.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(tVar.G(), w7.k.f13732l));
        textView.setVisibility(8);
        textView.setGravity(17);
    }

    public static /* synthetic */ void Z2(t tVar, View view, int i10, ra.c cVar) {
        tVar.f12641o0.y(cVar);
        tVar.f12641o0.z(1);
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int iL = com.tuyafeng.support.utils.x.l();
        int iL2 = com.tuyafeng.support.utils.x.l();
        this.f12644r0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).F(1, 16).g(4, iL2).V(new b6.a.InterfaceC0033a() { // from class: ta.j
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.T2(this.f12630a, (TextView) obj);
            }
        }).l();
        this.f12643q0 = (ImageView) new b6.a(new ImageView(G()), new RelativeLayout.LayoutParams(-2, -2)).o(iL2).Y(1, 48).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13783d)).F(1, 13).h(8).g(16, iL).g(128, iL).V(new b6.a.InterfaceC0033a() { // from class: ta.k
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.U2(this.f12631a, (ImageView) obj);
            }
        }).l();
        this.f12642p0 = (RecyclerView) new b6.a(new v0(G()), new RelativeLayout.LayoutParams(-1, -2)).g(32, iL).V(new b6.a.InterfaceC0033a() { // from class: ta.l
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.V2(this.f12632a, (v0) obj);
            }
        }).l();
        this.f12645s0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-1, -2)).n(1, 100).g(32, iL).V(new b6.a.InterfaceC0033a() { // from class: ta.m
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.Y2(this.f12633a, (TextView) obj);
            }
        }).l();
        RelativeLayout relativeLayout = (RelativeLayout) new b6.a(new RelativeLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        relativeLayout.addView(this.f12644r0);
        relativeLayout.addView(this.f12643q0);
        relativeLayout.addView(this.f12642p0);
        relativeLayout.addView(this.f12645s0);
        return relativeLayout;
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        View viewA1 = a1();
        if (viewA1 != null) {
            viewA1.requestLayout();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f12646t0 = new t5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: ta.n
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                t.Z2(this.f12634a, view2, i10, (ra.c) obj);
            }
        });
        this.f12646t0.K(ra.c.class, aVar);
        this.f12642p0.setAdapter(this.f12646t0);
        this.f12643q0.setOnClickListener(new View.OnClickListener() { // from class: ta.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12635a.f12641o0.x(new v5.q(0, null));
            }
        });
        String strG = a2.f1958a.g(this.f12641o0.v());
        this.f12644r0.setText(strG.isEmpty() ? X0(w7.u.Ic) : Y0(w7.u.wg, strG));
        this.f12641o0.f12610k.g(b1(), new androidx.lifecycle.o() { // from class: ta.p
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                t.X2(this.f12636a, (List) obj);
            }
        });
        this.f12641o0.f12616q.g(b1(), new androidx.lifecycle.o() { // from class: ta.q
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                t tVar = this.f12637a;
                tVar.c3(tVar.f12641o0.r(), ((Boolean) obj).booleanValue());
            }
        });
    }

    public final int b3(int i10) {
        List list = (List) this.f12641o0.f12610k.e();
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((ra.c) list.get(i11)).e() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void c3(int i10, boolean z10) {
        List list;
        int iB3 = b3(i10);
        if (iB3 >= 0 && (list = (List) this.f12641o0.f12610k.e()) != null) {
            ((ra.c) list.get(iB3)).n(z10);
            this.f12646t0.m(iB3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (K0() != null) {
            this.f12641o0 = (c0) new androidx.lifecycle.a0(K0()).a(c0.class);
        }
    }
}
