package b9;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import b9.a2;
import c9.e;
import c9.o;
import h6.a;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p8.d;
import w5.k;
import z5.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a2 extends o8.a {

    /* renamed from: y0, reason: collision with root package name */
    public static final int f1925y0 = g6.y.l();

    /* renamed from: m0, reason: collision with root package name */
    public e0 f1926m0;

    /* renamed from: n0, reason: collision with root package name */
    public RecyclerView f1927n0;

    /* renamed from: o0, reason: collision with root package name */
    public y5.f f1928o0;

    /* renamed from: p0, reason: collision with root package name */
    public RecyclerView f1929p0;

    /* renamed from: q0, reason: collision with root package name */
    public y5.f f1930q0;

    /* renamed from: r0, reason: collision with root package name */
    public EditText f1931r0;

    /* renamed from: s0, reason: collision with root package name */
    public ImageView f1932s0;

    /* renamed from: t0, reason: collision with root package name */
    public TextView f1933t0;

    /* renamed from: u0, reason: collision with root package name */
    public TextView f1934u0;

    /* renamed from: w0, reason: collision with root package name */
    public int f1936w0;

    /* renamed from: v0, reason: collision with root package name */
    public int f1935v0 = 1;

    /* renamed from: x0, reason: collision with root package name */
    public final p8.d f1937x0 = new p8.d(this, "text/plain");

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        public static /* synthetic */ void b(a aVar, WeakReference weakReference) {
            aVar.getClass();
            View view = (View) weakReference.get();
            if (view == null) {
                return;
            }
            a2.this.N3(view);
        }

        @Override // v5.c
        public void a(View view) {
            z8.f.e(a2.this.f1931r0);
            final WeakReference weakReference = new WeakReference(view);
            view.postDelayed(new Runnable() { // from class: b9.z1
                @Override // java.lang.Runnable
                public final void run() {
                    a2.a.b(this.f2098e, weakReference);
                }
            }, 30L);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends RecyclerView {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends LinearLayoutManager {
        public c(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean t1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends v5.c {
        public d() {
        }

        @Override // v5.c
        public void a(View view) {
            if (a2.this.f1926m0.r0()) {
                a2.this.f1926m0.F0();
                return;
            }
            a2.this.f1926m0.z0(a2.this.f1931r0.getText().toString(), new WeakReference(a2.this.I()));
            a2.this.f1931r0.setText("");
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            a2.this.f1932s0.setVisibility((z10 || a2.this.f1926m0.r0()) ? 0 : 8);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f implements FragmentManager.m {
        public f() {
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void a(androidx.activity.b bVar) {
            androidx.fragment.app.e0.c(this, bVar);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void b(Fragment fragment, boolean z10) {
            androidx.fragment.app.e0.b(this, fragment, z10);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void c(Fragment fragment, boolean z10) {
            androidx.fragment.app.e0.d(this, fragment, z10);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void d() {
            androidx.fragment.app.e0.a(this);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public void onBackStackChanged() {
            a2.this.f1926m0.D0(a2.this.z0().u0() == 0);
        }
    }

    public static /* synthetic */ void A3(a2 a2Var, Boolean bool) {
        a2Var.getClass();
        if (bool == null) {
            return;
        }
        a2Var.S3(bool.booleanValue());
        a2Var.f1932s0.setVisibility((bool.booleanValue() || a2Var.f1931r0.hasFocus()) ? 0 : 8);
    }

    public static /* synthetic */ void B3(ImageView imageView) {
        imageView.setVisibility(8);
        r3.l(imageView, -1);
    }

    private void L3() {
        this.f1926m0.m0().g(d1(), new androidx.lifecycle.m() { // from class: b9.b1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                a2.y3(this.f1944a, (Integer) obj);
            }
        });
        this.f1926m0.j0().g(d1(), new androidx.lifecycle.m() { // from class: b9.d1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                a2 a2Var = this.f1957a;
                p9.r rVar = (p9.r) obj;
                a2Var.f1933t0.setText(rVar == null ? a2Var.Z0(x7.u.H8) : g6.p.n(rVar.d(), a2Var.Z0(x7.u.H8)));
            }
        });
        this.f1926m0.c0().g(d1(), new androidx.lifecycle.m() { // from class: b9.e1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                a2.g3(this.f1981a, (List) obj);
            }
        });
        this.f1926m0.b0().g(d1(), new androidx.lifecycle.m() { // from class: b9.f1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                a2.A3(this.f1987a, (Boolean) obj);
            }
        });
        this.f1926m0.f0().g(d1(), new androidx.lifecycle.m() { // from class: b9.g1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f1991a.R3((List) obj);
            }
        });
        this.f1926m0.T().g(d1(), new androidx.lifecycle.m() { // from class: b9.h1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                a2.m3(this.f1996a, (Integer) obj);
            }
        });
    }

    public static /* synthetic */ void U2(final a2 a2Var, ImageView imageView) {
        a2Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(a2Var.I(), x7.o.C1, x7.u.yf));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: b9.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1924a.f1926m0.y0(0);
            }
        });
    }

    public static /* synthetic */ void W2(a2 a2Var, View view, o.a aVar, CharSequence charSequence, c9.a0 a0Var) {
        a2Var.getClass();
        int iA = aVar.a();
        if (iA == c9.g0.f2994d) {
            a2Var.H3(a0Var);
        } else if (iA == c9.g0.f2995e) {
            a2Var.M3(a0Var);
        } else if (iA == c9.g0.f2996f) {
            a2Var.I3(a0Var);
        }
    }

    public static /* synthetic */ void Z2(a2 a2Var, View view, c9.a aVar, int i10) {
        a2Var.f1926m0.A0(null);
        a2Var.f1926m0.v0();
    }

    public static /* synthetic */ boolean a3(a2 a2Var, View view, int i10, c9.g gVar) {
        a2Var.P3(gVar, view);
        return true;
    }

    public static /* synthetic */ void b3(a2 a2Var, w5.a aVar) {
        a2Var.getClass();
        x8.g.h(aVar);
        aVar.setInputType(131073);
        aVar.setMaxLines(5);
        aVar.setMinLines(1);
        aVar.setGravity(48);
        aVar.setHint(x7.u.Q7);
        x8.g.l(aVar);
        x8.g.m(aVar, x8.h.r(a2Var.I()));
    }

    public static /* synthetic */ Boolean e3(a2 a2Var, Uri uri, String str) throws IOException {
        a2Var.getClass();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(z8.b1.l(a2Var.I(), uri)));
            try {
                bufferedWriter.write(str);
                Boolean bool = Boolean.TRUE;
                bufferedWriter.close();
                return bool;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.b(e10);
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ void g3(final a2 a2Var, List list) {
        a2Var.Q3(list);
        a2Var.f1927n0.post(new Runnable() { // from class: b9.i1
            @Override // java.lang.Runnable
            public final void run() {
                this.f1999e.f1927n0.p1(r0.f1928o0.g() - 1);
            }
        });
    }

    public static /* synthetic */ void i3(a2 a2Var, TextView textView) {
        textView.setTextColor(x8.h.q(a2Var.I()));
        x8.g.m(textView, x8.h.t(a2Var.I()));
        r3.e(textView);
        x8.g.d(textView);
    }

    public static /* synthetic */ void l3(a2 a2Var, String str, Boolean bool) {
        a2Var.getClass();
        if (bool.booleanValue()) {
            if (str != null) {
                g6.n.l(a2Var.I(), x7.u.f14193v3, a2Var.I().getString(x7.u.X4, str));
            } else {
                a2Var.f1926m0.E0(a2Var.Z0(x7.u.T2));
            }
        }
    }

    public static /* synthetic */ void m3(a2 a2Var, Integer num) {
        a2Var.getClass();
        if (num.intValue() != 1) {
            return;
        }
        if (a2Var.z0().u0() > 0) {
            a2Var.z0().e1();
        } else {
            a2Var.f1926m0.K();
        }
    }

    public static /* synthetic */ void n3(a2 a2Var, View view, o.a aVar, CharSequence charSequence, c9.a0 a0Var) {
        a2Var.getClass();
        int iA = aVar.a();
        if (iA == c9.l.f3008d) {
            a2Var.H3(a0Var);
        } else if (iA == c9.l.f3009e) {
            a2Var.M3(a0Var);
        } else if (iA == c9.l.f3010f) {
            a2Var.I3(a0Var);
        }
    }

    public static /* synthetic */ void p3(a2 a2Var, TextView textView) {
        a2Var.getClass();
        x8.g.l(textView);
        x8.g.m(textView, x8.h.s(a2Var.I()));
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(x7.u.H8);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        x8.g.d(textView);
    }

    public static /* synthetic */ void r3(a2 a2Var, View view, int i10, c9.q qVar) {
        a2Var.getClass();
        if (qVar.b()) {
            return;
        }
        a2Var.f1926m0.C0(qVar.a().d());
    }

    public static /* synthetic */ void s3(a2 a2Var, ImageView imageView) {
        a2Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(a2Var.I(), x7.o.K0, x7.u.cf));
        imageView.setOnClickListener(a2Var.new a());
    }

    public static /* synthetic */ void u3(a2 a2Var, View view, AdapterView adapterView, View view2, int i10, long j10) {
        if (j10 == 1) {
            a2Var.G3(view);
            return;
        }
        if (j10 == 3) {
            a2Var.O3(view);
        } else if (j10 == 2) {
            a2Var.J3();
        } else {
            a2Var.getClass();
        }
    }

    public static /* synthetic */ void x3(a2 a2Var, int i10, List list, AdapterView adapterView, View view, int i11, long j10) {
        a2Var.getClass();
        if (i11 == i10) {
            return;
        }
        String str = (String) list.get(i11);
        a2Var.f1926m0.B0(str);
        a2Var.f1926m0.E0(str);
    }

    public static /* synthetic */ void y3(a2 a2Var, Integer num) {
        if (num == null) {
            a2Var.getClass();
        } else {
            a2Var.f1928o0.n(num.intValue(), "");
        }
    }

    public static /* synthetic */ void z3(RecyclerView recyclerView) {
        r3.f(recyclerView);
        r3.d(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) new h6.a(new RelativeLayout(I()), new FrameLayout.LayoutParams(-1, -1)).o(f1925y0).l();
        int iL = g6.y.l();
        int iL2 = g6.y.l();
        int iL3 = g6.y.l();
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -2)).o(iL2).B(1, 7).V(new a.InterfaceC0076a() { // from class: b9.u1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        ImageView imageView = (ImageView) new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(-2, -2)).X(g6.f.d(I(), x7.n.f13686e)).m(g6.f.d(I(), x7.n.f13685d)).S(g6.f.d(I(), x7.n.f13684c)).z(1, 3).d(x7.o.f13720e).i(x7.u.Kf).V(new a.InterfaceC0076a() { // from class: b9.v1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                a2.U2(this.f2084a, (ImageView) obj);
            }
        }).l();
        this.f1933t0 = (TextView) new h6.a(new TextView(I()), new LinearLayout.LayoutParams(0, -2)).p(16).v(1, 16).W(1.0f).V(new a.InterfaceC0076a() { // from class: b9.w1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                a2.p3(this.f2087a, (TextView) obj);
            }
        }).l();
        ImageView imageView2 = (ImageView) new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(-2, -2)).X(g6.f.d(I(), x7.n.f13686e)).m(g6.f.d(I(), x7.n.f13685d)).E(g6.f.d(I(), x7.n.f13684c)).v(1, 3).d(x7.o.f13720e).i(x7.u.f14198v8).V(new a.InterfaceC0076a() { // from class: b9.x1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                a2.s3(this.f2091a, (ImageView) obj);
            }
        }).l();
        this.f1927n0 = (RecyclerView) new h6.a(new RecyclerView(I()), new RelativeLayout.LayoutParams(-1, -1)).g(32, iL2).g(64, iL3).V(new a.InterfaceC0076a() { // from class: b9.y1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                a2.z3((RecyclerView) obj);
            }
        }).l();
        this.f1934u0 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-2, -2)).h(144).h(9).V(new a.InterfaceC0076a() { // from class: b9.s0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                a2.i3(this.f2075a, (TextView) obj);
            }
        }).l();
        this.f1929p0 = (RecyclerView) new h6.a(new b(I()), new RelativeLayout.LayoutParams(-1, -2)).o(iL3).n(1, 32).g(64, iL).N(1, 12).B(1, 8).V(new a.InterfaceC0076a() { // from class: b9.t0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((RecyclerView) obj).setClipToPadding(false);
            }
        }).l();
        LinearLayout linearLayout2 = (LinearLayout) new h6.a(new LinearLayout(I()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).x(1, 16).D(1, 8).h(128).e(new g6.g().l(g6.y.h(I(), 2.0f)).k(g6.f.b(I(), x7.m.f13673c)).c(x8.h.e(I())).a()).V(new a.InterfaceC0076a() { // from class: b9.u0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        this.f1931r0 = (EditText) new h6.a(new w5.a(I()), new LinearLayout.LayoutParams(0, -2)).f(0).N(1, 12).R(1, 9).J(1, 9).p(16).W(1.0f).V(new a.InterfaceC0076a() { // from class: b9.v0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                a2.b3(this.f2083a, (w5.a) obj);
            }
        }).l();
        this.f1932s0 = (ImageView) new h6.a(new ImageView(I()), new LinearLayout.LayoutParams(-2, -2)).Y(1, 32).n(1, 32).N(1, 6).p(80).v(1, 4).B(1, 4).t(1, 4).V(new a.InterfaceC0076a() { // from class: b9.w0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                a2.B3((ImageView) obj);
            }
        }).l();
        linearLayout.addView(imageView);
        linearLayout.addView(this.f1933t0);
        linearLayout.addView(imageView2);
        linearLayout2.addView(this.f1931r0);
        linearLayout2.addView(this.f1932s0);
        relativeLayout.addView(linearLayout);
        relativeLayout.addView(this.f1927n0);
        relativeLayout.addView(this.f1934u0);
        relativeLayout.addView(this.f1929p0);
        relativeLayout.addView(linearLayout2);
        S3(false);
        return relativeLayout;
    }

    public final void G3(View view) {
        w5.k.l(I()).d0(x7.u.f13917b2).F(new String[]{Z0(x7.u.f14153s2)}, new AdapterView.OnItemClickListener() { // from class: b9.m1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                this.f2021a.f1926m0.M();
            }
        }).h0(view);
    }

    public final void H3(c9.a0 a0Var) {
        ((autodispose2.m) this.f1926m0.a0(a0Var.getId()).k(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: b9.k1
            @Override // a7.e
            public final void accept(Object obj) {
                g6.n.a(this.f2011e.I(), (String) obj, x7.u.og);
            }
        }, new x7.g0());
    }

    public final void I3(final c9.a0 a0Var) {
        CharSequence charSequenceI = g6.p.i(a0Var.a(), 50);
        w5.k.l(I()).d0(x7.u.f14215x).J(a1(x7.u.f13988g3, charSequenceI != null ? charSequenceI.toString().replace("\n", " ") : "")).V(R.string.ok, new k.m() { // from class: b9.l1
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                this.f2016a.f1926m0.N(a0Var.getId());
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void J3() {
        this.f1937x0.d(g6.p.n(this.f1933t0.getText().toString(), Z0(x7.u.bh)) + "_" + z8.t1.d() + ".txt", new d.a() { // from class: b9.p1
            @Override // p8.d.a
            public final void a(Uri uri, String str) {
                this.f2038a.K3(uri, str);
            }
        });
    }

    public final void K3(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        ((autodispose2.m) this.f1926m0.Q().j(new a7.f() { // from class: b9.q1
            @Override // a7.f
            public final Object apply(Object obj) {
                return a2.e3(this.f2052a, uri, (String) obj);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new a7.e() { // from class: b9.r1
            @Override // a7.e
            public final void accept(Object obj) {
                a2.l3(this.f2059e, str, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public final void M3(c9.a0 a0Var) {
        this.f1926m0.D0(false);
        androidx.fragment.app.l0 l0VarQ = z0().q();
        int i10 = x7.i.f13638c;
        int i11 = x7.i.f13642g;
        l0VarQ.v(i10, i11, i11, x7.i.f13641f).c(f1925y0, q0.class, q0.f3(a0Var.getId()), null).g(null).i();
    }

    public final void N3(final View view) {
        if (this.f1928o0.g() <= 0) {
            O3(view);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new k.l(3, g6.p.n(this.f1926m0.U(), Z0(x7.u.f14025ic))));
        arrayList.add(new k.l(2, Z0(x7.u.f13920b5)));
        arrayList.add(new k.l(1, Z0(x7.u.f13917b2)));
        w5.k.l(I()).C(arrayList, new AdapterView.OnItemClickListener() { // from class: b9.j1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                a2.u3(this.f2003a, view, adapterView, view2, i10, j10);
            }
        }).h0(view);
    }

    public final void O3(View view) {
        final List listS = this.f1926m0.S();
        if (listS == null || listS.isEmpty()) {
            this.f1926m0.L(1);
        } else {
            if (listS.size() == 1) {
                return;
            }
            String strU = this.f1926m0.U();
            final int iIndexOf = strU == null ? -1 : listS.indexOf(strU);
            w5.k.l(I()).d0(x7.u.f14025ic).b0((String[]) listS.toArray(new String[0]), iIndexOf, new AdapterView.OnItemClickListener() { // from class: b9.o1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                    a2.x3(this.f2031a, iIndexOf, listS, adapterView, view2, i10, j10);
                }
            }).h0(view);
        }
    }

    public final void P3(final c9.a0 a0Var, View view) {
        z5.a.e(I()).a(new a.c(Z0(x7.u.C2), new View.OnClickListener() { // from class: b9.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2089a.H3(a0Var);
            }
        })).a(new a.c(Z0(x7.u.W), new View.OnClickListener() { // from class: b9.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2093a.M3(a0Var);
            }
        })).a(new a.c(Z0(x7.u.f14215x), new View.OnClickListener() { // from class: b9.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2096a.I3(a0Var);
            }
        })).f(view);
    }

    public final void Q3(List list) {
        boolean z10 = list.isEmpty() == (this.f1928o0.g() > 0);
        if (!z10 && !list.isEmpty() && this.f1928o0.g() > 0) {
            boolean zEquals = ((c9.a0) list.get(0)).getId().equals(((c9.a0) this.f1928o0.H().get(0)).getId());
            boolean z11 = !zEquals;
            if (zEquals) {
                this.f1935v0++;
            }
            z10 = z11;
        }
        if (z10) {
            this.f1928o0.M(list);
            this.f1928o0.l();
        } else {
            f.e eVarB = androidx.recyclerview.widget.f.b(new c9.b0(this.f1928o0.H(), list));
            this.f1928o0.M(list);
            eVarB.c(this.f1928o0);
        }
        this.f1934u0.setVisibility(list.isEmpty() ? 0 : 8);
    }

    public final void R3(List list) {
        ArrayList arrayList = new ArrayList();
        if (this.f1928o0.g() <= 0 && this.f1926m0.q0()) {
            arrayList.add(this.f1926m0.R().e());
        }
        arrayList.addAll(list);
        boolean z10 = arrayList.isEmpty() != (this.f1930q0.g() == 0);
        if (!z10) {
            z10 = this.f1935v0 == this.f1936w0;
        }
        this.f1936w0 = this.f1935v0;
        if (z10) {
            this.f1930q0.M(arrayList);
            this.f1930q0.l();
        } else {
            f.e eVarB = androidx.recyclerview.widget.f.b(new c9.p(this.f1930q0.H(), arrayList));
            this.f1930q0.M(arrayList);
            eVarB.c(this.f1930q0);
        }
        this.f1929p0.setVisibility(arrayList.isEmpty() ? 8 : 0);
    }

    public final void S3(boolean z10) {
        if (z10) {
            this.f1932s0.setImageDrawable(lb.b.a(I(), x7.o.f13773v1, x7.u.uf));
            this.f1932s0.setContentDescription(Z0(x7.u.ld));
            g6.y.O(this.f1932s0, new g6.g().f(1).h(g6.f.b(I(), x7.m.f13671a)).j(g6.f.b(I(), x7.m.f13671a) | Integer.MIN_VALUE).a());
        } else {
            this.f1932s0.setImageDrawable(lb.b.a(I(), x7.o.f13740k1, x7.u.rf));
            this.f1932s0.setContentDescription(Z0(x7.u.f14039jc));
            g6.y.O(this.f1932s0, new g6.g().f(1).h(x8.h.j(I())).j(x8.h.k(I())).a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        List list = Collections.EMPTY_LIST;
        this.f1930q0 = new y5.f(list);
        c9.e eVar = new c9.e();
        eVar.r(new e.b() { // from class: b9.r0
            @Override // c9.e.b
            public final void a(View view2, c9.a aVar, int i10) {
                a2.Z2(this.f2058a, view2, aVar, i10);
            }
        });
        this.f1930q0.K(c9.a.class, eVar);
        c9.s sVar = new c9.s();
        sVar.j(new y5.g() { // from class: b9.c1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                a2.r3(this.f1953a, view2, i10, (c9.q) obj);
            }
        });
        this.f1930q0.K(c9.q.class, sVar);
        this.f1929p0.setLayoutManager(new LinearLayoutManager(I(), 0, false));
        this.f1929p0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.d(this.f1929p0);
        this.f1929p0.k(new com.tuyafeng.support.widget.x(0, g6.y.h(I(), 4.0f)));
        this.f1929p0.setAdapter(this.f1930q0);
        this.f1928o0 = new y5.f(list);
        c9.g0 g0Var = new c9.g0();
        g0Var.r(new c9.c0() { // from class: b9.n1
            @Override // c9.c0
            public final void a(View view2, o.a aVar, CharSequence charSequence, c9.a0 a0Var) {
                a2.W2(this.f2026a, view2, aVar, charSequence, a0Var);
            }
        });
        this.f1928o0.K(c9.d0.class, g0Var);
        c9.l lVar = new c9.l();
        lVar.x(new c9.c0() { // from class: b9.s1
            @Override // c9.c0
            public final void a(View view2, o.a aVar, CharSequence charSequence, c9.a0 a0Var) {
                a2.n3(this.f2076a, view2, aVar, charSequence, a0Var);
            }
        });
        lVar.k(new y5.h() { // from class: b9.t1
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return a2.a3(this.f2079a, view2, i10, (c9.g) obj);
            }
        });
        this.f1928o0.K(c9.g.class, lVar);
        c cVar = new c(I());
        cVar.E2(true);
        this.f1927n0.setLayoutManager(cVar);
        this.f1927n0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f1927n0.setAdapter(this.f1928o0);
        this.f1932s0.setOnClickListener(new d());
        this.f1931r0.setOnFocusChangeListener(new e());
        z0().m(new f());
        L3();
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f1926m0 = (e0) new androidx.lifecycle.y(B2(), pa.r.n()).a(e0.class);
    }
}
