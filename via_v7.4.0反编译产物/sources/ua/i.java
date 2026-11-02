package ua;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import h6.a;
import i6.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mark.via.common.widget.SizedLinearLayoutManager;
import mark.via.common.widget.v0;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public c0 f12903m0;

    /* renamed from: n0, reason: collision with root package name */
    public TextView f12904n0;

    /* renamed from: o0, reason: collision with root package name */
    public ImageView f12905o0;

    /* renamed from: p0, reason: collision with root package name */
    public RecyclerView f12906p0;

    /* renamed from: q0, reason: collision with root package name */
    public y5.f f12907q0;

    /* renamed from: r0, reason: collision with root package name */
    public List f12908r0 = Collections.EMPTY_LIST;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            return b6.c.h().a(viewGroup);
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, a6.q qVar, int i10) {
            gVar.X(b6.c.f1828c, qVar.a());
        }
    }

    public static /* synthetic */ void X2(i iVar, v0 v0Var) {
        SizedLinearLayoutManager sizedLinearLayoutManager = new SizedLinearLayoutManager(iVar.I());
        int iMin = Math.min(g6.y.y(iVar.I()) / 2, g6.y.h(iVar.I(), 600.0f));
        int iMin2 = Math.min(g6.y.y(iVar.I()) / 4, g6.y.h(iVar.I(), 200.0f));
        sizedLinearLayoutManager.N2(iMin);
        sizedLinearLayoutManager.O2(iMin2);
        v0Var.setLayoutManager(sizedLinearLayoutManager);
        r3.d(v0Var);
        r3.h(v0Var);
    }

    public static /* synthetic */ void Y2(i iVar, ImageView imageView) {
        imageView.setImageDrawable(lb.b.a(iVar.I(), x7.o.f13759r, x7.u.Sd));
        imageView.setContentDescription(iVar.Z0(x7.u.C8));
        imageView.setColorFilter(g6.e.a(iVar.I(), x7.k.f13662h));
    }

    public static /* synthetic */ void Z2(i iVar, r5.c cVar) {
        iVar.f12904n0.setText(cVar.g());
        iVar.c3(cVar, iVar.f12903m0.t());
    }

    public static /* synthetic */ void a3(i iVar, TextView textView) {
        textView.setTextSize(0, x8.h.s(iVar.I()));
        textView.setTextColor(g6.e.a(iVar.I(), x7.k.f13665k));
        textView.setText(x7.u.uc);
        x8.g.k(textView);
        r3.n(textView);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        x8.g.d(textView);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int iL = g6.y.l();
        int iL2 = g6.y.l();
        this.f12904n0 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).H(1, 6, 16, 16, 16).g(2, iL2).V(new a.InterfaceC0076a() { // from class: ua.a
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                i.a3(this.f12879a, (TextView) obj);
            }
        }).l();
        this.f12905o0 = (ImageView) new h6.a(new ImageView(I()), new RelativeLayout.LayoutParams(g6.y.h(I(), 48.0f), -2)).o(iL2).e(g6.f.e(I(), x7.o.f13720e)).F(1, 13).g(16, iL).g(128, iL).V(new a.InterfaceC0076a() { // from class: ua.b
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                i.Y2(this.f12881a, (ImageView) obj);
            }
        }).l();
        this.f12906p0 = (RecyclerView) new h6.a(new v0(I()), new RelativeLayout.LayoutParams(-1, -2)).g(32, iL).V(new a.InterfaceC0076a() { // from class: ua.c
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                i.X2(this.f12884a, (v0) obj);
            }
        }).l();
        RelativeLayout relativeLayout = (RelativeLayout) new h6.a(new RelativeLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        relativeLayout.addView(this.f12904n0);
        relativeLayout.addView(this.f12906p0);
        relativeLayout.addView(this.f12905o0);
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
        this.f12905o0.setOnClickListener(new View.OnClickListener() { // from class: ua.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12898a.f12903m0.z(0);
            }
        });
        this.f12907q0 = new y5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: ua.e
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f12899a.f12903m0.x((a6.q) obj);
            }
        });
        this.f12907q0.K(a6.q.class, aVar);
        this.f12906p0.setAdapter(this.f12907q0);
        this.f12903m0.f12892m.g(d1(), new androidx.lifecycle.m() { // from class: ua.f
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                i.Z2(this.f12900a, (r5.c) obj);
            }
        });
        this.f12903m0.f12896q.g(d1(), new androidx.lifecycle.m() { // from class: ua.g
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f12901a.d3(((Boolean) obj).booleanValue());
            }
        });
        this.f12903m0.q().g(d1(), new androidx.lifecycle.m() { // from class: ua.h
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                i iVar = this.f12902a;
                iVar.c3(iVar.f12903m0.u(), iVar.f12903m0.t());
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c3(r5.c cVar, List list) {
        String strF;
        ArrayList arrayList = new ArrayList();
        boolean z10 = cVar != null && cVar.j();
        arrayList.add(new a6.q(2, Z0(z10 ? x7.u.A4 : x7.u.E3)));
        arrayList.add(new a6.q(1, Z0(x7.u.D)));
        if (z10) {
            i0 i0Var = i0.f7006a;
            strF = i0Var.s(this.f12903m0.v()) ? i0Var.f(this.f12903m0.v()) : null;
        }
        if (z10 && strF != null && strF.length() > 3) {
            arrayList.add(new a6.q(4, a1(x7.u.K4, strF)));
        }
        arrayList.add(new a6.q(3, Z0(x7.u.f14055l0)));
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new a6.q(-1, (String) it.next()));
            }
        }
        this.f12908r0 = arrayList;
        this.f12907q0.M(arrayList);
        this.f12907q0.l();
    }

    public final void d3(boolean z10) {
        ((a6.q) this.f12908r0.get(0)).b(Z0(z10 ? x7.u.A4 : x7.u.E3));
        this.f12907q0.m(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        if (M0() != null) {
            this.f12903m0 = (c0) new androidx.lifecycle.y(M0()).a(c0.class);
        }
    }
}
