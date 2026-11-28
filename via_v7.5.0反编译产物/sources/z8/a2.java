package z8;

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
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a2 extends m8.a {
    public static final int A0 = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public e0 f15355o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public RecyclerView f15356p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public t5.f f15357q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public RecyclerView f15358r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public t5.f f15359s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public EditText f15360t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ImageView f15361u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public TextView f15362v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public TextView f15363w0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f15365y0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f15364x0 = 1;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final n8.d f15366z0 = new n8.d(this, "text/plain");

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        public static /* synthetic */ void b(a aVar, WeakReference weakReference) {
            aVar.getClass();
            View view = (View) weakReference.get();
            if (view == null) {
                return;
            }
            a2.this.L3(view);
        }

        @Override // p5.c
        public void a(View view) {
            x8.f.e(a2.this.f15360t0);
            final WeakReference weakReference = new WeakReference(view);
            view.postDelayed(new Runnable() { // from class: z8.z1
                @Override // java.lang.Runnable
                public final void run() {
                    a2.a.b(this.f15527c, weakReference);
                }
            }, 30L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends p5.c {
        public d() {
        }

        @Override // p5.c
        public void a(View view) {
            if (a2.this.f15355o0.r0()) {
                a2.this.f15355o0.F0();
                return;
            }
            a2.this.f15355o0.z0(a2.this.f15360t0.getText().toString(), new WeakReference(a2.this.G()));
            a2.this.f15360t0.setText("");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            a2.this.f15361u0.setVisibility((z10 || a2.this.f15355o0.r0()) ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements FragmentManager.m {
        public f() {
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void a(androidx.activity.b bVar) {
            androidx.fragment.app.e0.c(this, bVar);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void d(Fragment fragment, boolean z10) {
            androidx.fragment.app.e0.b(this, fragment, z10);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void h(Fragment fragment, boolean z10) {
            androidx.fragment.app.e0.d(this, fragment, z10);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void k() {
            androidx.fragment.app.e0.a(this);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public void onBackStackChanged() {
            a2.this.f15355o0.D0(a2.this.x0().u0() == 0);
        }
    }

    private void J3() {
        this.f15355o0.m0().g(b1(), new androidx.lifecycle.o() { // from class: z8.b1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                a2.w3(this.f15373a, (Integer) obj);
            }
        });
        this.f15355o0.j0().g(b1(), new androidx.lifecycle.o() { // from class: z8.d1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                a2 a2Var = this.f15386a;
                n9.r rVar = (n9.r) obj;
                a2Var.f15362v0.setText(rVar == null ? a2Var.X0(w7.u.T8) : com.tuyafeng.support.utils.p.n(rVar.d(), a2Var.X0(w7.u.T8)));
            }
        });
        this.f15355o0.c0().g(b1(), new androidx.lifecycle.o() { // from class: z8.e1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                a2.e3(this.f15410a, (List) obj);
            }
        });
        this.f15355o0.b0().g(b1(), new androidx.lifecycle.o() { // from class: z8.f1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                a2.y3(this.f15416a, (Boolean) obj);
            }
        });
        this.f15355o0.f0().g(b1(), new androidx.lifecycle.o() { // from class: z8.g1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f15420a.P3((List) obj);
            }
        });
        this.f15355o0.T().g(b1(), new androidx.lifecycle.o() { // from class: z8.h1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                a2.k3(this.f15425a, (Integer) obj);
            }
        });
    }

    public static /* synthetic */ void S2(final a2 a2Var, ImageView imageView) {
        a2Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(a2Var.G(), w7.o.A1, w7.u.Pf));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: z8.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15354a.f15355o0.y0(0);
            }
        });
    }

    public static /* synthetic */ void U2(a2 a2Var, View view, a9.o.a aVar, CharSequence charSequence, a9.a0 a0Var) {
        a2Var.getClass();
        int iA = aVar.a();
        if (iA == a9.g0.f223d) {
            a2Var.F3(a0Var);
        } else if (iA == a9.g0.f224e) {
            a2Var.K3(a0Var);
        } else if (iA == a9.g0.f225f) {
            a2Var.G3(a0Var);
        }
    }

    public static /* synthetic */ void X2(a2 a2Var, View view, a9.a aVar, int i10) {
        a2Var.f15355o0.A0(null);
        a2Var.f15355o0.v0();
    }

    public static /* synthetic */ boolean Y2(a2 a2Var, View view, int i10, a9.g gVar) {
        a2Var.N3(gVar, view);
        return true;
    }

    public static /* synthetic */ void Z2(a2 a2Var, q5.a aVar) {
        a2Var.getClass();
        v8.g.h(aVar);
        aVar.setInputType(131073);
        aVar.setMaxLines(5);
        aVar.setMinLines(1);
        aVar.setGravity(48);
        aVar.setHint(w7.u.f14003c8);
        v8.g.l(aVar);
        v8.g.m(aVar, v8.h.q(a2Var.G()));
    }

    public static /* synthetic */ Boolean c3(a2 a2Var, Uri uri, String str) {
        a2Var.getClass();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(x8.b1.l(a2Var.G(), uri)));
            try {
                bufferedWriter.write(str);
                Boolean bool = Boolean.TRUE;
                bufferedWriter.close();
                return bool;
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e10) {
            tc.a.b(e10);
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ void e3(final a2 a2Var, List list) {
        a2Var.O3(list);
        a2Var.f15356p0.post(new Runnable() { // from class: z8.i1
            @Override // java.lang.Runnable
            public final void run() {
                a2 a2Var2 = this.f15428c;
                a2Var2.f15356p0.p1(a2Var2.f15357q0.g() - 1);
            }
        });
    }

    public static /* synthetic */ void g3(a2 a2Var, TextView textView) {
        textView.setTextColor(v8.h.p(a2Var.G()));
        v8.g.m(textView, v8.h.s(a2Var.G()));
        r3.f(textView);
        v8.g.d(textView);
    }

    public static /* synthetic */ void j3(a2 a2Var, String str, Boolean bool) {
        a2Var.getClass();
        if (bool.booleanValue()) {
            if (str != null) {
                com.tuyafeng.support.utils.n.l(a2Var.G(), w7.u.I3, a2Var.G().getString(w7.u.f14112k5, str));
            } else {
                a2Var.f15355o0.E0(a2Var.X0(w7.u.f14040f3));
            }
        }
    }

    public static /* synthetic */ void k3(a2 a2Var, Integer num) {
        a2Var.getClass();
        if (num.intValue() != 1) {
            return;
        }
        if (a2Var.x0().u0() > 0) {
            a2Var.x0().e1();
        } else {
            a2Var.f15355o0.K();
        }
    }

    public static /* synthetic */ void l3(a2 a2Var, View view, a9.o.a aVar, CharSequence charSequence, a9.a0 a0Var) {
        a2Var.getClass();
        int iA = aVar.a();
        if (iA == a9.l.f237d) {
            a2Var.F3(a0Var);
        } else if (iA == a9.l.f238e) {
            a2Var.K3(a0Var);
        } else if (iA == a9.l.f239f) {
            a2Var.G3(a0Var);
        }
    }

    public static /* synthetic */ void n3(a2 a2Var, TextView textView) {
        a2Var.getClass();
        v8.g.l(textView);
        v8.g.m(textView, v8.h.r(a2Var.G()));
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(w7.u.T8);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        v8.g.d(textView);
    }

    public static /* synthetic */ void p3(a2 a2Var, View view, int i10, a9.q qVar) {
        a2Var.getClass();
        if (qVar.b()) {
            return;
        }
        a2Var.f15355o0.C0(qVar.a().d());
    }

    public static /* synthetic */ void q3(a2 a2Var, ImageView imageView) {
        a2Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(a2Var.G(), w7.o.I0, w7.u.tf));
        imageView.setOnClickListener(a2Var.new a());
    }

    public static /* synthetic */ void s3(a2 a2Var, View view, AdapterView adapterView, View view2, int i10, long j10) {
        if (j10 == 1) {
            a2Var.E3(view);
            return;
        }
        if (j10 == 3) {
            a2Var.M3(view);
        } else if (j10 == 2) {
            a2Var.H3();
        } else {
            a2Var.getClass();
        }
    }

    public static /* synthetic */ void v3(a2 a2Var, int i10, List list, AdapterView adapterView, View view, int i11, long j10) {
        a2Var.getClass();
        if (i11 == i10) {
            return;
        }
        String str = (String) list.get(i11);
        a2Var.f15355o0.B0(str);
        a2Var.f15355o0.E0(str);
    }

    public static /* synthetic */ void w3(a2 a2Var, Integer num) {
        if (num == null) {
            a2Var.getClass();
        } else {
            a2Var.f15357q0.n(num.intValue(), "");
        }
    }

    public static /* synthetic */ void x3(RecyclerView recyclerView) {
        r3.g(recyclerView);
        r3.e(recyclerView);
    }

    public static /* synthetic */ void y3(a2 a2Var, Boolean bool) {
        a2Var.getClass();
        if (bool == null) {
            return;
        }
        a2Var.Q3(bool.booleanValue());
        a2Var.f15361u0.setVisibility((bool.booleanValue() || a2Var.f15360t0.hasFocus()) ? 0 : 8);
    }

    public static /* synthetic */ void z3(ImageView imageView) {
        imageView.setVisibility(8);
        r3.m(imageView, -1);
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) new b6.a(new RelativeLayout(G()), new FrameLayout.LayoutParams(-1, -1)).o(A0).l();
        int iL = com.tuyafeng.support.utils.x.l();
        int iL2 = com.tuyafeng.support.utils.x.l();
        int iL3 = com.tuyafeng.support.utils.x.l();
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).o(iL2).B(1, 7).V(new b6.a.InterfaceC0033a() { // from class: z8.u1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        ImageView imageView = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-2, -2)).X(com.tuyafeng.support.utils.f.d(G(), w7.n.f13752e)).m(com.tuyafeng.support.utils.f.d(G(), w7.n.f13751d)).S(com.tuyafeng.support.utils.f.d(G(), w7.n.f13750c)).z(1, 3).d(w7.o.f13783d).i(w7.u.ag).V(new b6.a.InterfaceC0033a() { // from class: z8.v1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                a2.S2(this.f15513a, (ImageView) obj);
            }
        }).l();
        this.f15362v0 = (TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(0, -2)).p(16).v(1, 16).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: z8.w1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                a2.n3(this.f15516a, (TextView) obj);
            }
        }).l();
        ImageView imageView2 = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-2, -2)).X(com.tuyafeng.support.utils.f.d(G(), w7.n.f13752e)).m(com.tuyafeng.support.utils.f.d(G(), w7.n.f13751d)).E(com.tuyafeng.support.utils.f.d(G(), w7.n.f13750c)).v(1, 3).d(w7.o.f13783d).i(w7.u.H8).V(new b6.a.InterfaceC0033a() { // from class: z8.x1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                a2.q3(this.f15520a, (ImageView) obj);
            }
        }).l();
        this.f15356p0 = (RecyclerView) new b6.a(new RecyclerView(G()), new RelativeLayout.LayoutParams(-1, -1)).g(32, iL2).g(64, iL3).V(new b6.a.InterfaceC0033a() { // from class: z8.y1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                a2.x3((RecyclerView) obj);
            }
        }).l();
        this.f15363w0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-2, -2)).h(144).h(9).V(new b6.a.InterfaceC0033a() { // from class: z8.s0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                a2.g3(this.f15504a, (TextView) obj);
            }
        }).l();
        this.f15358r0 = (RecyclerView) new b6.a(new b(G()), new RelativeLayout.LayoutParams(-1, -2)).o(iL3).n(1, 32).g(64, iL).N(1, 12).B(1, 8).V(new b6.a.InterfaceC0033a() { // from class: z8.t0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((RecyclerView) obj).setClipToPadding(false);
            }
        }).l();
        LinearLayout linearLayout2 = (LinearLayout) new b6.a(new LinearLayout(G()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).x(1, 16).D(1, 8).h(128).e(new com.tuyafeng.support.utils.g().l(com.tuyafeng.support.utils.x.h(G(), 2.0f)).k(com.tuyafeng.support.utils.f.b(G(), w7.m.f13739c)).c(v8.h.e(G())).a()).V(new b6.a.InterfaceC0033a() { // from class: z8.u0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        this.f15360t0 = (EditText) new b6.a(new q5.a(G()), new LinearLayout.LayoutParams(0, -2)).f(0).N(1, 12).R(1, 9).J(1, 9).p(16).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: z8.v0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                a2.Z2(this.f15512a, (q5.a) obj);
            }
        }).l();
        this.f15361u0 = (ImageView) new b6.a(new ImageView(G()), new LinearLayout.LayoutParams(-2, -2)).Y(1, 32).n(1, 32).N(1, 6).p(80).v(1, 4).B(1, 4).t(1, 4).V(new b6.a.InterfaceC0033a() { // from class: z8.w0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                a2.z3((ImageView) obj);
            }
        }).l();
        linearLayout.addView(imageView);
        linearLayout.addView(this.f15362v0);
        linearLayout.addView(imageView2);
        linearLayout2.addView(this.f15360t0);
        linearLayout2.addView(this.f15361u0);
        relativeLayout.addView(linearLayout);
        relativeLayout.addView(this.f15356p0);
        relativeLayout.addView(this.f15363w0);
        relativeLayout.addView(this.f15358r0);
        relativeLayout.addView(linearLayout2);
        Q3(false);
        return relativeLayout;
    }

    public final void E3(View view) {
        q5.k.l(G()).f0(w7.u.f14165o2).G(new String[]{X0(w7.u.F2)}, new AdapterView.OnItemClickListener() { // from class: z8.m1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                this.f15451a.f15355o0.M();
            }
        }).j0(view);
    }

    public final void F3(a9.a0 a0Var) {
        ((autodispose2.m) this.f15355o0.a0(a0Var.getId()).k(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: z8.k1
            @Override // u6.f
            public final void accept(Object obj) {
                com.tuyafeng.support.utils.n.a(this.f15440c.G(), (String) obj, w7.u.Eg);
            }
        }, new w7.e0());
    }

    public final void G3(final a9.a0 a0Var) {
        CharSequence charSequenceI = com.tuyafeng.support.utils.p.i(a0Var.a(), 50);
        q5.k.l(G()).f0(w7.u.f14298y).K(Y0(w7.u.f14222s3, charSequenceI != null ? charSequenceI.toString().replace("\n", " ") : "")).X(R.string.ok, new q5.k.m() { // from class: z8.l1
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                this.f15446a.f15355o0.N(a0Var.getId());
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void H3() {
        this.f15366z0.d(com.tuyafeng.support.utils.p.n(this.f15362v0.getText().toString(), X0(w7.u.Ah)) + "_" + x8.s1.d() + ".txt", new n8.d.a() { // from class: z8.p1
            @Override // n8.d.a
            public final void a(Uri uri, String str) {
                this.f15468a.I3(uri, str);
            }
        });
    }

    public final void I3(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        ((autodispose2.m) this.f15355o0.Q().j(new u6.g() { // from class: z8.q1
            @Override // u6.g
            public final Object apply(Object obj) {
                return a2.c3(this.f15483a, uri, (String) obj);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: z8.r1
            @Override // u6.f
            public final void accept(Object obj) {
                a2.j3(this.f15488c, str, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public final void K3(a9.a0 a0Var) {
        this.f15355o0.D0(false);
        androidx.fragment.app.l0 l0VarQ = x0().q();
        int i10 = w7.i.f13705c;
        int i11 = w7.i.f13709g;
        l0VarQ.v(i10, i11, i11, w7.i.f13708f).c(A0, q0.class, q0.d3(a0Var.getId()), null).g(null).i();
    }

    public final void L3(final View view) {
        if (this.f15357q0.g() <= 0) {
            M3(view);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new q5.k.l(3, com.tuyafeng.support.utils.p.n(this.f15355o0.U(), X0(w7.u.wc))));
        arrayList.add(new q5.k.l(2, X0(w7.u.f14168o5)));
        arrayList.add(new q5.k.l(1, X0(w7.u.f14165o2)));
        q5.k.l(G()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: z8.j1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                a2.s3(this.f15432a, view, adapterView, view2, i10, j10);
            }
        }).j0(view);
    }

    public final void M3(View view) {
        final List listS = this.f15355o0.S();
        if (listS == null || listS.isEmpty()) {
            this.f15355o0.L(1);
        } else {
            if (listS.size() == 1) {
                return;
            }
            String strU = this.f15355o0.U();
            final int iIndexOf = strU == null ? -1 : listS.indexOf(strU);
            q5.k.l(G()).f0(w7.u.wc).d0((String[]) listS.toArray(new String[0]), iIndexOf, new AdapterView.OnItemClickListener() { // from class: z8.o1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                    a2.v3(this.f15461a, iIndexOf, listS, adapterView, view2, i10, j10);
                }
            }).j0(view);
        }
    }

    public final void N3(final a9.a0 a0Var, View view) {
        u5.a.e(G()).a(new u5.a.c(X0(w7.u.O2), new View.OnClickListener() { // from class: z8.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f15518a.F3(a0Var);
            }
        })).a(new u5.a.c(X0(w7.u.X), new View.OnClickListener() { // from class: z8.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f15522a.K3(a0Var);
            }
        })).a(new u5.a.c(X0(w7.u.f14298y), new View.OnClickListener() { // from class: z8.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f15525a.G3(a0Var);
            }
        })).f(view);
    }

    public final void O3(List list) {
        boolean z10 = list.isEmpty() == (this.f15357q0.g() > 0);
        if (!z10 && !list.isEmpty() && this.f15357q0.g() > 0) {
            boolean zEquals = ((a9.a0) list.get(0)).getId().equals(((a9.a0) this.f15357q0.H().get(0)).getId());
            boolean z11 = !zEquals;
            if (zEquals) {
                this.f15364x0++;
            }
            z10 = z11;
        }
        if (z10) {
            this.f15357q0.M(list);
            this.f15357q0.l();
        } else {
            androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new a9.b0(this.f15357q0.H(), list));
            this.f15357q0.M(list);
            eVarB.c(this.f15357q0);
        }
        this.f15363w0.setVisibility(list.isEmpty() ? 0 : 8);
    }

    public final void P3(List list) {
        ArrayList arrayList = new ArrayList();
        if (this.f15357q0.g() <= 0 && this.f15355o0.q0()) {
            arrayList.add(this.f15355o0.R().e());
        }
        arrayList.addAll(list);
        boolean z10 = arrayList.isEmpty() != (this.f15359s0.g() == 0);
        if (!z10) {
            z10 = this.f15364x0 == this.f15365y0;
        }
        this.f15365y0 = this.f15364x0;
        if (z10) {
            this.f15359s0.M(arrayList);
            this.f15359s0.l();
        } else {
            androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new a9.p(this.f15359s0.H(), arrayList));
            this.f15359s0.M(arrayList);
            eVarB.c(this.f15359s0);
        }
        this.f15358r0.setVisibility(arrayList.isEmpty() ? 8 : 0);
    }

    public final void Q3(boolean z10) {
        if (z10) {
            this.f15361u0.setImageDrawable(lb.g.a(G(), w7.o.f13833t1, w7.u.Lf));
            this.f15361u0.setContentDescription(X0(w7.u.Bd));
            com.tuyafeng.support.utils.x.P(this.f15361u0, new com.tuyafeng.support.utils.g().f(1).h(com.tuyafeng.support.utils.f.b(G(), w7.m.f13737a)).j(com.tuyafeng.support.utils.f.b(G(), w7.m.f13737a) | Integer.MIN_VALUE).a());
        } else {
            this.f15361u0.setImageDrawable(lb.g.a(G(), w7.o.f13800i1, w7.u.If));
            this.f15361u0.setContentDescription(X0(w7.u.xc));
            com.tuyafeng.support.utils.x.P(this.f15361u0, new com.tuyafeng.support.utils.g().f(1).h(v8.h.j(G())).j(v8.h.k(G())).a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        List list = Collections.EMPTY_LIST;
        this.f15359s0 = new t5.f(list);
        a9.e eVar = new a9.e();
        eVar.r(new a9.e.b() { // from class: z8.r0
            @Override // a9.e.b
            public final void a(View view2, a9.a aVar, int i10) {
                a2.X2(this.f15487a, view2, aVar, i10);
            }
        });
        this.f15359s0.K(a9.a.class, eVar);
        a9.s sVar = new a9.s();
        sVar.j(new t5.g() { // from class: z8.c1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                a2.p3(this.f15382a, view2, i10, (a9.q) obj);
            }
        });
        this.f15359s0.K(a9.q.class, sVar);
        this.f15358r0.setLayoutManager(new LinearLayoutManager(G(), 0, false));
        this.f15358r0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.e(this.f15358r0);
        this.f15358r0.k(new com.tuyafeng.support.widget.c0(0, com.tuyafeng.support.utils.x.h(G(), 4.0f)));
        this.f15358r0.setAdapter(this.f15359s0);
        this.f15357q0 = new t5.f(list);
        a9.g0 g0Var = new a9.g0();
        g0Var.r(new a9.c0() { // from class: z8.n1
            @Override // a9.c0
            public final void a(View view2, a9.o.a aVar, CharSequence charSequence, a9.a0 a0Var) {
                a2.U2(this.f15456a, view2, aVar, charSequence, a0Var);
            }
        });
        this.f15357q0.K(a9.d0.class, g0Var);
        a9.l lVar = new a9.l();
        lVar.x(new a9.c0() { // from class: z8.s1
            @Override // a9.c0
            public final void a(View view2, a9.o.a aVar, CharSequence charSequence, a9.a0 a0Var) {
                a2.l3(this.f15505a, view2, aVar, charSequence, a0Var);
            }
        });
        lVar.k(new t5.h() { // from class: z8.t1
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return a2.Y2(this.f15508a, view2, i10, (a9.g) obj);
            }
        });
        this.f15357q0.K(a9.g.class, lVar);
        c cVar = new c(G());
        cVar.E2(true);
        this.f15356p0.setLayoutManager(cVar);
        this.f15356p0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f15356p0.setAdapter(this.f15357q0);
        this.f15361u0.setOnClickListener(new d());
        this.f15360t0.setOnFocusChangeListener(new e());
        x0().m(new f());
        J3();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f15355o0 = (e0) new androidx.lifecycle.a0(z2(), la.s.n()).a(e0.class);
    }
}
