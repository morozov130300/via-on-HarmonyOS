package ra;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import g6.y;
import h6.a;
import x7.k;
import x7.n;
import x7.o;
import x7.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public TextView f11625m0;

    /* renamed from: n0, reason: collision with root package name */
    public TextView f11626n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f11627o0;

    public static /* synthetic */ void W2(h hVar, TextView textView) {
        textView.setTextSize(0, x8.h.s(hVar.I()));
        textView.setTextColor(g6.e.a(hVar.I(), k.f13663i));
        textView.setGravity(17);
    }

    public static /* synthetic */ void X2(h hVar, TextView textView) {
        textView.setTextSize(0, x8.h.s(hVar.I()));
        textView.setTextColor(g6.e.a(hVar.I(), k.f13665k));
        textView.setText(u.G2);
        textView.setGravity(17);
    }

    public static /* synthetic */ void Y2(h hVar, TextView textView) {
        textView.setMaxWidth(y.h(hVar.I(), 300.0f));
        textView.setMinWidth(y.h(hVar.I(), 120.0f));
        textView.setTextSize(0, x8.h.s(hVar.I()));
        textView.setTextColor(g6.e.a(hVar.I(), k.f13665k));
        textView.setGravity(17);
    }

    public static /* synthetic */ void a3(h hVar, TextView textView) {
        textView.setTextSize(0, x8.h.t(hVar.I()));
        textView.setTextColor(g6.e.a(hVar.I(), k.f13665k));
        textView.setText(u.f13980f9);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
    }

    public static Bundle c3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", i10);
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11625m0 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-2, -2)).o(y.l()).h(144).h(9).x(1, 32).B(1, 12).t(1, 24).V(new a.InterfaceC0076a() { // from class: ra.d
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                h.Y2(this.f11621a, (TextView) obj);
            }
        }).l();
        TextView textView = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-2, -2)).o(y.l()).g(64, this.f11625m0.getId()).g(9, this.f11625m0.getId()).x(1, 16).V(new a.InterfaceC0076a() { // from class: ra.e
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                h.a3(this.f11622a, (TextView) obj);
            }
        }).l();
        this.f11626n0 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-2, -2)).o(y.l()).g(32, this.f11625m0.getId()).g(9, this.f11625m0.getId()).e(new g6.g().c(g6.f.d(I(), n.f13697p)).h(x8.h.j(I())).j(x8.h.k(I())).a()).F(1, 12).V(new a.InterfaceC0076a() { // from class: ra.f
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                h.W2(this.f11623a, (TextView) obj);
            }
        }).l();
        this.f11627o0 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-2, -2)).o(y.l()).g(32, this.f11626n0.getId()).g(9, this.f11625m0.getId()).d(o.f13720e).B(1, 8).F(1, 12).V(new a.InterfaceC0076a() { // from class: ra.g
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                h.X2(this.f11624a, (TextView) obj);
            }
        }).l();
        RelativeLayout relativeLayout = (RelativeLayout) new h6.a(new RelativeLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        relativeLayout.addView(textView);
        relativeLayout.addView(this.f11625m0);
        relativeLayout.addView(this.f11626n0);
        relativeLayout.addView(this.f11627o0);
        x8.g.f(relativeLayout);
        return relativeLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        d3(y0() == null ? 0 : y0().getInt("code"));
    }

    public final void b3() {
        l0().finish();
        System.exit(0);
    }

    public final void d3(int i10) {
        if (i10 == 1) {
            this.f11625m0.setText(u.f14159s8);
            this.f11626n0.setText(u.f13936c7);
            this.f11626n0.setOnClickListener(new View.OnClickListener() { // from class: ra.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z8.f.g(this.f11618a.l0(), "com.google.android.webview");
                }
            });
        } else {
            this.f11625m0.setText(u.H2);
            this.f11626n0.setText(u.I2);
            this.f11626n0.setOnClickListener(new View.OnClickListener() { // from class: ra.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z8.f.k(this.f11619a.I());
                }
            });
        }
        this.f11627o0.setOnClickListener(new View.OnClickListener() { // from class: ra.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11620a.b3();
            }
        });
    }
}
