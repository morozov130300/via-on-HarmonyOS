package z8;

import android.R;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r2 extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public e0 f15490o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public RecyclerView f15491p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public TextView f15492q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public t5.f f15493r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f15494s0 = true;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public w5.a f15495t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public l8.b f15496u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public TextView f15497v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ImageView f15498w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ImageView f15499x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public ImageView f15500y0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements w5.a.InterfaceC0153a {
        public a() {
        }

        @Override // w5.a.InterfaceC0153a
        public void a(int i10) {
            r2.this.f15497v0.setText(String.valueOf(i10));
        }

        @Override // w5.a.InterfaceC0153a
        public void b(boolean z10) {
            if (z10) {
                r2.this.f15490o0.F0();
                a(r2.this.f15495t0.a());
            } else {
                r2.this.f15493r0.r(0, r2.this.f15493r0.g(), Boolean.FALSE);
                r2.this.f15497v0.setText(w7.u.ag);
            }
            r2.this.f15490o0.D0(!z10);
            r2.this.f15499x0.setVisibility(z10 ? 8 : 0);
            r2.this.f15498w0.setVisibility(z10 ? 0 : 8);
            com.tuyafeng.support.utils.x.j((ViewGroup) r2.this.f15497v0.getParent(), true);
            r2.this.f15500y0.setImageDrawable(z10 ? lb.g.a(r2.this.G(), w7.o.C, w7.u.le) : lb.g.a(r2.this.G(), w7.o.f13810m, w7.u.ge));
            r2.this.f15500y0.setContentDescription(r2.this.X0(z10 ? w7.u.f14298y : w7.u.T8));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements l8.a {
        public b() {
        }

        @Override // l8.a
        public boolean a(int i10) {
            return r2.this.f15495t0.d(i10);
        }

        @Override // l8.a
        public void b(int i10, boolean z10) {
            if (r2.this.f15495t0.j(i10, z10)) {
                r2.this.f15493r0.n(i10, Boolean.valueOf(z10));
            }
        }

        @Override // l8.a
        public boolean c(int i10) {
            return r2.this.f15495t0.c();
        }
    }

    public static /* synthetic */ void S2(r2 r2Var, String[] strArr, View view, q5.k.p pVar) {
        r2Var.f15495t0.k(false);
        r2Var.f15490o0.O(strArr);
    }

    public static /* synthetic */ void T2(final r2 r2Var, ImageView imageView) {
        r2Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(r2Var.G(), w7.o.f13810m, w7.u.ge));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: z8.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r2.d3(this.f15417a, view);
            }
        });
    }

    public static /* synthetic */ void U2(r2 r2Var, List list) {
        r2Var.s3(r2Var.p3(list));
        r2Var.f15491p0.setVisibility(list.isEmpty() ? 8 : 0);
        r2Var.f15492q0.setVisibility(list.isEmpty() ? 0 : 8);
        if (r2Var.f15494s0) {
            r2Var.f15494s0 = false;
            r2Var.f15491p0.p1(0);
        }
    }

    public static /* synthetic */ boolean X2(r2 r2Var, int i10) {
        return r2Var.f15495t0.c() && r2Var.f15495t0.d(i10);
    }

    public static /* synthetic */ void Y2(final r2 r2Var, ImageView imageView) {
        r2Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(r2Var.G(), w7.o.f13803j1, w7.u.Jf));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: z8.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15421a.f15490o0.L(1);
            }
        });
    }

    public static /* synthetic */ boolean Z2(r2 r2Var, View view, int i10, n9.r rVar) {
        if (!r2Var.f15495t0.c()) {
            r2Var.f15495t0.k(true);
        }
        r2Var.f15496u0.n(true, i10);
        return true;
    }

    public static /* synthetic */ void a3(final r2 r2Var, ImageView imageView) {
        r2Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(r2Var.G(), w7.o.f13846y, w7.u.je));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: z8.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15485a.f15495t0.k(false);
            }
        });
        imageView.setVisibility(8);
    }

    public static /* synthetic */ void b3(r2 r2Var, View view, int i10, n9.r rVar) {
        if (!r2Var.f15495t0.c()) {
            r2Var.f15490o0.t0(rVar.c());
            r2Var.f15490o0.y0(1);
            return;
        }
        r2Var.f15495t0.h(i10);
        if (r2Var.f15495t0.a() == 0) {
            r2Var.f15495t0.k(false);
        } else {
            r2Var.f15493r0.n(i10, Boolean.valueOf(r2Var.f15495t0.d(i10)));
        }
    }

    public static /* synthetic */ void c3(r2 r2Var, TextView textView) {
        r2Var.getClass();
        v8.g.l(textView);
        v8.g.m(textView, v8.h.r(r2Var.G()));
        textView.setSingleLine();
        textView.setText(w7.u.ag);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        v8.g.d(textView);
    }

    public static /* synthetic */ void d3(r2 r2Var, View view) {
        if (r2Var.f15495t0.c()) {
            r2Var.q3();
        } else {
            r2Var.f15490o0.t0(null);
            r2Var.f15490o0.y0(1);
        }
    }

    public static /* synthetic */ void e3(r2 r2Var, Integer num) {
        r2Var.getClass();
        if (num.intValue() != 0) {
            return;
        }
        if (r2Var.f15495t0.c()) {
            r2Var.f15495t0.k(false);
        } else {
            r2Var.f15490o0.K();
        }
    }

    private List p3(List list) {
        return new ArrayList(list);
    }

    private void r3() {
        this.f15490o0.k0().g(b1(), new androidx.lifecycle.o() { // from class: z8.c2
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                r2.U2(this.f15383a, (List) obj);
            }
        });
        this.f15490o0.i0().g(b1(), new androidx.lifecycle.o() { // from class: z8.d2
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f15387a.f15494s0 = true;
            }
        });
        this.f15490o0.T().g(b1(), new androidx.lifecycle.o() { // from class: z8.e2
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                r2.e3(this.f15411a, (Integer) obj);
            }
        });
    }

    private void s3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new a9.t(this.f15493r0.H(), list));
        this.f15493r0.M(list);
        eVarB.c(this.f15493r0);
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: z8.k2
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        LinearLayout linearLayout2 = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).B(1, 7).V(new b6.a.InterfaceC0033a() { // from class: z8.l2
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        this.f15498w0 = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-2, -2)).X(com.tuyafeng.support.utils.f.d(G(), w7.n.f13752e)).m(com.tuyafeng.support.utils.f.d(G(), w7.n.f13751d)).E(com.tuyafeng.support.utils.f.d(G(), w7.n.f13750c)).z(1, 3).d(w7.o.f13783d).i(R.string.cancel).V(new b6.a.InterfaceC0033a() { // from class: z8.m2
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                r2.a3(this.f15452a, (ImageView) obj);
            }
        }).l();
        this.f15497v0 = (TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(0, -2)).p(16).z(1, 16).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: z8.n2
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                r2.c3(this.f15457a, (TextView) obj);
            }
        }).l();
        this.f15499x0 = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-2, -2)).X(com.tuyafeng.support.utils.f.d(G(), w7.n.f13752e)).m(com.tuyafeng.support.utils.f.d(G(), w7.n.f13751d)).E(com.tuyafeng.support.utils.f.d(G(), w7.n.f13750c)).v(1, 3).d(w7.o.f13783d).i(w7.u.U0).V(new b6.a.InterfaceC0033a() { // from class: z8.o2
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                r2.Y2(this.f15464a, (ImageView) obj);
            }
        }).l();
        this.f15500y0 = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-2, -2)).X(com.tuyafeng.support.utils.f.d(G(), w7.n.f13752e)).m(com.tuyafeng.support.utils.f.d(G(), w7.n.f13751d)).E(com.tuyafeng.support.utils.f.d(G(), w7.n.f13750c)).v(1, 3).d(w7.o.f13783d).i(w7.u.O8).V(new b6.a.InterfaceC0033a() { // from class: z8.p2
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                r2.T2(this.f15469a, (ImageView) obj);
            }
        }).l();
        this.f15491p0 = (RecyclerView) new b6.a(new mark.via.common.widget.v0(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        TextView textViewB = r3.b(G());
        this.f15492q0 = textViewB;
        v8.g.d(textViewB);
        this.f15492q0.setVisibility(8);
        linearLayout2.addView(this.f15498w0);
        linearLayout2.addView(this.f15497v0);
        linearLayout2.addView(this.f15499x0);
        linearLayout2.addView(this.f15500y0);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(this.f15492q0);
        linearLayout.addView(this.f15491p0);
        return linearLayout;
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        if (this.f15494s0) {
            this.f15490o0.w0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        w5.a aVar = new w5.a();
        this.f15495t0 = aVar;
        aVar.i(new a());
        l8.b bVar = new l8.b(G(), new b());
        this.f15496u0 = bVar;
        bVar.p(com.tuyafeng.support.utils.x.h(G(), com.tuyafeng.support.utils.l.d(G()) ? -48.0f : 48.0f));
        this.f15491p0.n(this.f15496u0);
        this.f15491p0.setLayoutManager(new LinearLayoutManager(G()));
        this.f15491p0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.g(this.f15491p0);
        r3.i(this.f15491p0);
        this.f15493r0 = new t5.f(Collections.EMPTY_LIST);
        a9.y yVar = new a9.y();
        yVar.t(new a9.y.a() { // from class: z8.b2
            @Override // a9.y.a
            public final boolean a(int i10) {
                return r2.X2(this.f15374a, i10);
            }
        });
        yVar.j(new t5.g() { // from class: z8.i2
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                r2.b3(this.f15429a, view2, i10, (n9.r) obj);
            }
        });
        yVar.k(new t5.h() { // from class: z8.j2
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return r2.Z2(this.f15434a, view2, i10, (n9.r) obj);
            }
        });
        this.f15493r0.K(n9.r.class, yVar);
        this.f15491p0.setAdapter(this.f15493r0);
        r3();
    }

    public final void q3() {
        int[] iArrB = this.f15495t0.b(true);
        if (iArrB.length == 0) {
            return;
        }
        final String[] strArr = new String[iArrB.length];
        String[] strArr2 = new String[iArrB.length];
        for (int i10 = 0; i10 < iArrB.length; i10++) {
            n9.r rVar = (n9.r) this.f15493r0.H().get(iArrB[i10]);
            strArr[i10] = rVar.c();
            strArr2[i10] = rVar.d();
        }
        q5.k.l(G()).f0(w7.u.f14298y).K(iArrB.length == 1 ? Y0(w7.u.f14222s3, strArr2[0]) : Y0(w7.u.f14236t3, Integer.valueOf(iArrB.length))).X(R.string.ok, new q5.k.m() { // from class: z8.h2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                r2.S2(this.f15426a, strArr, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f15490o0 = (e0) new androidx.lifecycle.a0(z2(), la.s.n()).a(e0.class);
    }
}
