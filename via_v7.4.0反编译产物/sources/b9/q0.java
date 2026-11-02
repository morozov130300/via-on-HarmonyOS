package b9;

import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tuyafeng.support.widget.y;
import com.tuyafeng.support.widget.z;
import h6.a;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q0 extends o8.a {

    /* renamed from: s0, reason: collision with root package name */
    public static final int f2041s0 = g6.y.l();

    /* renamed from: t0, reason: collision with root package name */
    public static final int f2042t0 = g6.y.l();

    /* renamed from: m0, reason: collision with root package name */
    public p9.o f2043m0;

    /* renamed from: n0, reason: collision with root package name */
    public k6.e f2044n0;

    /* renamed from: o0, reason: collision with root package name */
    public com.tuyafeng.support.widget.z f2045o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f2046p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f2047q0;

    /* renamed from: r0, reason: collision with root package name */
    public CharSequence f2048r0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f2049b;

        public a(LinearLayout linearLayout) {
            this.f2049b = linearLayout;
        }

        @Override // v5.d
        public void a(View view) {
            g6.y.N(this.f2049b);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements y.a {
        public b() {
        }

        @Override // com.tuyafeng.support.widget.y.a
        public void a(int i10, float f10) {
            if (f10 < 1.0f || q0.this.j1()) {
                return;
            }
            q0.this.N0().e1();
        }

        @Override // com.tuyafeng.support.widget.y.a
        public boolean b(int i10) {
            return !g6.i.d(q0.this);
        }

        @Override // com.tuyafeng.support.widget.y.a
        public void c(int i10) {
        }
    }

    public static /* synthetic */ void W2(q0 q0Var, w.d dVar) {
        q0Var.getClass();
        Object obj = dVar.f13207a;
        if (obj == null) {
            q0Var.f2046p0.setText(q0Var.Z0(x7.u.f14115p4));
            return;
        }
        q0Var.f2047q0 = (String) obj;
        q0Var.f2048r0 = (CharSequence) dVar.f13208b;
        q0Var.g3(true);
    }

    public static /* synthetic */ void Y2(q0 q0Var, TextView textView) {
        x8.g.m(textView, x8.h.r(q0Var.I()));
        x8.g.l(textView);
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(o6.a.a());
        x8.g.d(textView);
    }

    public static /* synthetic */ w.d Z2(q0 q0Var, String str) {
        String strTrim;
        Spanned spannedB;
        p9.n nVarM = q0Var.f2043m0.m(str);
        if (nVarM == null || nVarM.b() == null || nVarM.b().isEmpty()) {
            strTrim = null;
            spannedB = null;
        } else {
            if (nVarM.f() == null || nVarM.f().isEmpty()) {
                strTrim = nVarM.b().trim();
            } else {
                strTrim = "> " + nVarM.f().trim().replace("\n", "\n> ") + "\n\n" + nVarM.b().trim();
            }
            spannedB = q0Var.f2044n0.b(strTrim);
        }
        return w.d.a(strTrim, spannedB);
    }

    public static /* synthetic */ void a3(ScrollView scrollView) {
        r3.f(scrollView);
        scrollView.setFillViewport(true);
    }

    public static /* synthetic */ void c3(final q0 q0Var, LinearLayout linearLayout, com.tuyafeng.support.widget.z zVar) {
        q0Var.getClass();
        zVar.setOnClickListener(q0Var.new a(linearLayout));
        zVar.setTitle(q0Var.Z0(x7.u.Q7));
        zVar.l(lb.b.a(q0Var.I(), x7.o.f13759r, x7.u.Sd), q0Var.I().getString(x7.u.C8), new View.OnClickListener() { // from class: b9.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2025a.N0().c1();
            }
        });
        zVar.c(new z.b(f2041s0, 0, null, q0Var.Z0(x7.u.N7), false), new View.OnClickListener() { // from class: b9.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2030a.g3(true);
            }
        });
        zVar.c(new z.b(f2042t0, 0, null, q0Var.Z0(x7.u.f14187ua), false), new View.OnClickListener() { // from class: b9.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2037a.g3(false);
            }
        });
    }

    public static /* synthetic */ void d3(q0 q0Var, LinearLayout linearLayout, com.tuyafeng.support.widget.y yVar) {
        q0Var.getClass();
        yVar.p(linearLayout);
        yVar.setEdgeSize(-2);
        yVar.setScrollThresholdSize(g6.y.h(q0Var.I(), 200.0f));
        yVar.n(q0Var.new b());
    }

    private void e3(final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.l0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q0.Z2(this.f2014e, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: b9.m0
            @Override // a7.e
            public final void accept(Object obj) {
                q0.W2(this.f2020e, (w.d) obj);
            }
        }, new x7.g0());
    }

    public static Bundle f3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, str);
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new LinearLayout.LayoutParams(-1, -1)).f(g6.e.a(I(), x7.k.f13656b)).V(new a.InterfaceC0076a() { // from class: b9.g0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        com.tuyafeng.support.widget.z zVar = (com.tuyafeng.support.widget.z) new h6.a(new com.tuyafeng.support.widget.z(I()), new LinearLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: b9.h0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q0.c3(this.f1994a, linearLayout, (com.tuyafeng.support.widget.z) obj);
            }
        }).l();
        this.f2045o0 = zVar;
        linearLayout.addView(zVar);
        ScrollView scrollView = (ScrollView) new h6.a(new ScrollView(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: b9.i0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q0.a3((ScrollView) obj);
            }
        }).l();
        TextView textView = (TextView) new h6.a(new TextView(I()), new FrameLayout.LayoutParams(-1, -2)).T(1, 16).N(1, 16).V(new a.InterfaceC0076a() { // from class: b9.j0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q0.Y2(this.f2002a, (TextView) obj);
            }
        }).l();
        this.f2046p0 = textView;
        scrollView.addView(textView);
        linearLayout.addView(scrollView);
        return (com.tuyafeng.support.widget.y) new h6.a(new com.tuyafeng.support.widget.y(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: b9.k0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q0.d3(this.f2009a, linearLayout, (com.tuyafeng.support.widget.y) obj);
            }
        }).l();
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        String string = y0() == null ? null : y0().getString(Name.MARK);
        if (string == null) {
            this.f2046p0.setText(Z0(x7.u.f14115p4));
            return;
        }
        this.f2043m0 = pa.r.e();
        this.f2044n0 = pa.r.h();
        e3(string);
    }

    public final void g3(boolean z10) {
        this.f2046p0.setText(z10 ? this.f2048r0 : this.f2047q0);
        this.f2045o0.j(f2041s0, !z10);
        this.f2045o0.j(f2042t0, z10);
    }
}
