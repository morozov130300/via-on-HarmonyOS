package na;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tuyafeng.support.utils.x;
import w7.k;
import w7.n;
import w7.o;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public TextView f10817o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public TextView f10818p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public TextView f10819q0;

    public static /* synthetic */ void U2(h hVar, TextView textView) {
        textView.setTextSize(0, v8.h.r(hVar.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(hVar.G(), k.f13730j));
        textView.setGravity(17);
    }

    public static /* synthetic */ void V2(h hVar, TextView textView) {
        textView.setTextSize(0, v8.h.r(hVar.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(hVar.G(), k.f13732l));
        textView.setText(u.S2);
        textView.setGravity(17);
    }

    public static /* synthetic */ void W2(h hVar, TextView textView) {
        textView.setMaxWidth(x.h(hVar.G(), 300.0f));
        textView.setMinWidth(x.h(hVar.G(), 120.0f));
        textView.setTextSize(0, v8.h.r(hVar.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(hVar.G(), k.f13732l));
        textView.setGravity(17);
    }

    public static /* synthetic */ void Y2(h hVar, TextView textView) {
        textView.setTextSize(0, v8.h.s(hVar.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(hVar.G(), k.f13732l));
        textView.setText(u.f14200q9);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
    }

    public static Bundle a3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", i10);
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10817o0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-2, -2)).o(x.l()).h(144).h(9).x(1, 32).B(1, 12).t(1, 24).V(new b6.a.InterfaceC0033a() { // from class: na.d
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                h.W2(this.f10813a, (TextView) obj);
            }
        }).l();
        TextView textView = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-2, -2)).o(x.l()).g(64, this.f10817o0.getId()).g(9, this.f10817o0.getId()).x(1, 16).V(new b6.a.InterfaceC0033a() { // from class: na.e
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                h.Y2(this.f10814a, (TextView) obj);
            }
        }).l();
        this.f10818p0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-2, -2)).o(x.l()).g(32, this.f10817o0.getId()).g(9, this.f10817o0.getId()).e(new com.tuyafeng.support.utils.g().c(com.tuyafeng.support.utils.f.d(G(), n.f13763p)).h(v8.h.j(G())).j(v8.h.k(G())).a()).F(1, 12).V(new b6.a.InterfaceC0033a() { // from class: na.f
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                h.U2(this.f10815a, (TextView) obj);
            }
        }).l();
        this.f10819q0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-2, -2)).o(x.l()).g(32, this.f10818p0.getId()).g(9, this.f10817o0.getId()).d(o.f13783d).B(1, 8).F(1, 12).V(new b6.a.InterfaceC0033a() { // from class: na.g
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                h.V2(this.f10816a, (TextView) obj);
            }
        }).l();
        RelativeLayout relativeLayout = (RelativeLayout) new b6.a(new RelativeLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        relativeLayout.addView(textView);
        relativeLayout.addView(this.f10817o0);
        relativeLayout.addView(this.f10818p0);
        relativeLayout.addView(this.f10819q0);
        v8.g.f(relativeLayout);
        return relativeLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        b3(w0() == null ? 0 : w0().getInt("code"));
    }

    public final void Z2() {
        i0().finish();
        System.exit(0);
    }

    public final void b3(int i10) {
        if (i10 == 1) {
            this.f10817o0.setText(u.E8);
            this.f10818p0.setText(u.f14170o7);
            this.f10818p0.setOnClickListener(new View.OnClickListener() { // from class: na.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x8.f.g(this.f10810a.i0(), "com.google.android.webview");
                }
            });
        } else {
            this.f10817o0.setText(u.T2);
            this.f10818p0.setText(u.U2);
            this.f10818p0.setOnClickListener(new View.OnClickListener() { // from class: na.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x8.f.k(this.f10811a.G());
                }
            });
        }
        this.f10819q0.setOnClickListener(new View.OnClickListener() { // from class: na.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10812a.Z2();
            }
        });
    }
}
