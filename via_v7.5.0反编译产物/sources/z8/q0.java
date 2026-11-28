package z8;

import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q0 extends m8.a {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f15472u0 = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f15473v0 = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public n9.o f15474o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public e6.e f15475p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f15476q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public TextView f15477r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public String f15478s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public CharSequence f15479t0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f15480b;

        public a(LinearLayout linearLayout) {
            this.f15480b = linearLayout;
        }

        @Override // p5.d
        public void a(View view) {
            com.tuyafeng.support.utils.x.O(this.f15480b);
        }
    }

    public static /* synthetic */ void U2(q0 q0Var, x.d dVar) {
        q0Var.getClass();
        Object obj = dVar.f14455a;
        if (obj == null) {
            q0Var.f15477r0.setText(q0Var.X0(w7.u.C4));
            return;
        }
        q0Var.f15478s0 = (String) obj;
        q0Var.f15479t0 = (CharSequence) dVar.f14456b;
        q0Var.e3(true);
    }

    public static /* synthetic */ void W2(q0 q0Var, TextView textView) {
        v8.g.m(textView, v8.h.q(q0Var.G()));
        v8.g.l(textView);
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(i6.a.a());
        v8.g.d(textView);
    }

    public static /* synthetic */ x.d X2(q0 q0Var, String str) {
        String strTrim;
        Spanned spannedB;
        n9.n nVarQ = q0Var.f15474o0.q(str);
        if (nVarQ == null || nVarQ.b() == null || nVarQ.b().isEmpty()) {
            strTrim = null;
            spannedB = null;
        } else {
            if (nVarQ.f() == null || nVarQ.f().isEmpty()) {
                strTrim = nVarQ.b().trim();
            } else {
                strTrim = "> " + nVarQ.f().trim().replace("\n", "\n> ") + "\n\n" + nVarQ.b().trim();
            }
            spannedB = q0Var.f15475p0.b(strTrim);
        }
        return x.d.a(strTrim, spannedB);
    }

    public static /* synthetic */ void Y2(ScrollView scrollView) {
        r3.g(scrollView);
        scrollView.setFillViewport(true);
    }

    public static /* synthetic */ void a3(final q0 q0Var, LinearLayout linearLayout, com.tuyafeng.support.widget.e0 e0Var) {
        q0Var.getClass();
        e0Var.setOnClickListener(q0Var.new a(linearLayout));
        e0Var.setTitle(q0Var.X0(w7.u.f14003c8));
        e0Var.m(lb.g.a(q0Var.G(), w7.o.f13822q, w7.u.he), q0Var.G().getString(w7.u.O8), new View.OnClickListener() { // from class: z8.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15455a.L0().c1();
            }
        });
        e0Var.c(new com.tuyafeng.support.widget.e0.b(f15472u0, 0, null, q0Var.X0(w7.u.Z7), false), new View.OnClickListener() { // from class: z8.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15460a.e3(true);
            }
        });
        e0Var.c(new com.tuyafeng.support.widget.e0.b(f15473v0, 0, null, q0Var.X0(w7.u.Ga), false), new View.OnClickListener() { // from class: z8.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15467a.e3(false);
            }
        });
    }

    public static /* synthetic */ void b3(q0 q0Var, LinearLayout linearLayout, com.tuyafeng.support.widget.d0 d0Var) {
        q0Var.getClass();
        d0Var.p(linearLayout);
        d0Var.setEdgeSize(-2);
        d0Var.setScrollThresholdSize(com.tuyafeng.support.utils.x.h(q0Var.G(), 200.0f));
        d0Var.n(q0Var.new b());
    }

    private void c3(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.l0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q0.X2(this.f15444c, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: z8.m0
            @Override // u6.f
            public final void accept(Object obj) {
                q0.U2(this.f15450c, (x.d) obj);
            }
        }, new w7.e0());
    }

    public static Bundle d3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, str);
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new LinearLayout.LayoutParams(-1, -1)).f(com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c)).V(new b6.a.InterfaceC0033a() { // from class: z8.g0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        com.tuyafeng.support.widget.e0 e0Var = (com.tuyafeng.support.widget.e0) new b6.a(new com.tuyafeng.support.widget.e0(G()), new LinearLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: z8.h0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q0.a3(this.f15423a, linearLayout, (com.tuyafeng.support.widget.e0) obj);
            }
        }).l();
        this.f15476q0 = e0Var;
        linearLayout.addView(e0Var);
        ScrollView scrollView = (ScrollView) new b6.a(new ScrollView(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: z8.i0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q0.Y2((ScrollView) obj);
            }
        }).l();
        TextView textView = (TextView) new b6.a(new TextView(G()), new FrameLayout.LayoutParams(-1, -2)).T(1, 16).N(1, 16).V(new b6.a.InterfaceC0033a() { // from class: z8.j0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q0.W2(this.f15431a, (TextView) obj);
            }
        }).l();
        this.f15477r0 = textView;
        scrollView.addView(textView);
        linearLayout.addView(scrollView);
        return (com.tuyafeng.support.widget.d0) new b6.a(new com.tuyafeng.support.widget.d0(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: z8.k0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q0.b3(this.f15438a, linearLayout, (com.tuyafeng.support.widget.d0) obj);
            }
        }).l();
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        String string = w0() == null ? null : w0().getString(Name.MARK);
        if (string == null) {
            this.f15477r0.setText(X0(w7.u.C4));
            return;
        }
        this.f15474o0 = la.s.e();
        this.f15475p0 = la.s.h();
        c3(string);
    }

    public final void e3(boolean z10) {
        this.f15477r0.setText(z10 ? this.f15479t0 : this.f15478s0);
        this.f15476q0.k(f15472u0, !z10);
        this.f15476q0.k(f15473v0, z10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements com.tuyafeng.support.widget.d0.a {
        public b() {
        }

        @Override // com.tuyafeng.support.widget.d0.a
        public void a(int i10, float f10) {
            if (f10 < 1.0f || q0.this.h1()) {
                return;
            }
            q0.this.L0().e1();
        }

        @Override // com.tuyafeng.support.widget.d0.a
        public boolean b(int i10) {
            return !FragmentUtils.e(q0.this);
        }

        @Override // com.tuyafeng.support.widget.d0.a
        public void c(int i10) {
        }
    }
}
