package qa;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import h6.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import qa.j0;
import qa.v0;
import z8.r3;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v0 extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public f1 f11423m0;

    /* renamed from: n0, reason: collision with root package name */
    public y9.a f11424n0;

    /* renamed from: o0, reason: collision with root package name */
    public List f11425o0;

    /* renamed from: p0, reason: collision with root package name */
    public y5.f f11426p0;

    /* renamed from: q0, reason: collision with root package name */
    public j0 f11427q0;

    /* renamed from: r0, reason: collision with root package name */
    public GridLayoutManager f11428r0;

    /* renamed from: s0, reason: collision with root package name */
    public RecyclerView f11429s0;

    /* renamed from: t0, reason: collision with root package name */
    public RelativeLayout f11430t0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends j.i {

        /* renamed from: f, reason: collision with root package name */
        public int f11431f;

        /* renamed from: g, reason: collision with root package name */
        public int f11432g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f11433h;

        public a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.c0 c0Var, int i10) {
            super.A(c0Var, i10);
            if (i10 != 0 && c0Var != null) {
                this.f11433h = i10 == 2;
                int iK = c0Var.k();
                this.f11431f = iK;
                this.f11432g = iK;
            }
            if (this.f11433h && i10 == 0) {
                this.f11433h = false;
                if (this.f11431f != this.f11432g) {
                    w9.n.e().w(true);
                    z8.h.b(new Runnable() { // from class: qa.u0
                        @Override // java.lang.Runnable
                        public final void run() {
                            v0.a aVar = this.f11421e;
                            v0.this.f11424n0.y(aVar.f11431f, aVar.f11432g);
                        }
                    });
                }
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.c0 c0Var, int i10) {
            v0.this.j3(c0Var.k());
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            v0.this.f11426p0.p(c0Var.k(), c0Var2.k());
            return true;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void z(RecyclerView recyclerView, RecyclerView.c0 c0Var, int i10, RecyclerView.c0 c0Var2, int i11, int i12, int i13) {
            super.z(recyclerView, c0Var, i10, c0Var2, i11, i12, i13);
            v0.this.f11425o0.add(i11, (n9.b) v0.this.f11425o0.remove(i10));
            this.f11432g = i11;
        }
    }

    public static /* synthetic */ void V2(v0 v0Var, n9.b bVar, int i10, View view) {
        long jS = v0Var.f11424n0.s(bVar);
        if (jS <= 0 || v0Var.j1()) {
            return;
        }
        bVar.m((int) jS);
        v0Var.f11425o0.add(i10, bVar);
        v0Var.f11426p0.o(i10);
    }

    public static /* synthetic */ void Y2(final v0 v0Var, TextView textView) {
        v0Var.getClass();
        textView.setOnClickListener(new View.OnClickListener() { // from class: qa.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11415a.f11423m0.j(true);
            }
        });
        textView.setText(x7.u.K3);
        textView.setGravity(17);
        textView.setTextColor(x8.h.j(v0Var.I()));
        textView.setTextSize(0, x8.h.r(v0Var.I()));
        r3.q(textView);
    }

    public static /* synthetic */ void Z2(v0 v0Var, RecyclerView recyclerView) {
        r3.d(v0Var.f11429s0);
        r3.f(recyclerView);
    }

    public static /* synthetic */ void b3(v0 v0Var, TextView textView) {
        v0Var.getClass();
        textView.setText(x7.u.K);
        textView.setGravity(17);
        textView.setTextColor(x8.h.p(v0Var.I()));
        textView.setTextSize(0, x8.h.s(v0Var.I()));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        r3.q(textView);
    }

    public static /* synthetic */ void c3(v0 v0Var, List list) {
        v0Var.f11425o0.clear();
        v0Var.f11425o0.addAll(list);
        v0Var.f11426p0.l();
    }

    private void i3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: qa.s0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f11417e.f11424n0.h();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.t0
            @Override // a7.e
            public final void accept(Object obj) {
                v0.c3(this.f11419e, (List) obj);
            }
        }, new x7.c0());
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11430t0 = (RelativeLayout) new h6.a(new RelativeLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        TextView textView = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-2, -2)).o(g6.y.l()).m(g6.f.d(I(), x7.n.f13685d)).h(9).V(new a.InterfaceC0076a() { // from class: qa.k0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                v0.b3(this.f11386a, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-2, -2)).g(144, textView.getId()).h(8).N(1, 16).V(new a.InterfaceC0076a() { // from class: qa.l0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                v0.Y2(this.f11388a, (TextView) obj);
            }
        }).l();
        this.f11429s0 = (RecyclerView) new h6.a(new RecyclerView(I()), new RelativeLayout.LayoutParams(-1, -2)).g(32, textView.getId()).V(new a.InterfaceC0076a() { // from class: qa.m0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                v0.Z2(this.f11390a, (RecyclerView) obj);
            }
        }).l();
        this.f11430t0.addView(textView);
        this.f11430t0.addView(textView2);
        this.f11430t0.addView(this.f11429s0);
        return this.f11430t0;
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        this.f11426p0 = new y5.f(this.f11425o0);
        j0 j0Var = new j0(w3.m(I()), pa.r.j().X2(), I().getResources());
        this.f11427q0 = j0Var;
        j0Var.j(new y5.g() { // from class: qa.n0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                v0 v0Var = this.f11392a;
                v0Var.f11423m0.m((n9.b) v0Var.f11425o0.get(i10));
            }
        });
        this.f11427q0.p(new j0.a() { // from class: qa.o0
            @Override // qa.j0.a
            public final void a(View view2, int i10) {
                this.f11406a.j3(i10);
            }
        });
        this.f11426p0.K(n9.b.class, this.f11427q0);
        this.f11428r0 = new GridLayoutManager(I(), 4);
        l3(g6.y.h(I(), Resources.getSystem().getConfiguration().screenWidthDp));
        this.f11429s0.setLayoutManager(this.f11428r0);
        androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e();
        eVar.x(100L);
        this.f11429s0.setItemAnimator(eVar);
        this.f11429s0.setAdapter(this.f11426p0);
        new androidx.recyclerview.widget.j(new a(51, 0)).m(this.f11429s0);
        this.f11423m0.f11367i.g(d1(), new androidx.lifecycle.m() { // from class: qa.p0
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f11408a.k3((n9.b) obj);
            }
        });
        i3();
    }

    public final void j3(final int i10) {
        List list = this.f11425o0;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return;
        }
        n9.b bVar = (n9.b) this.f11425o0.remove(i10);
        final n9.b bVar2 = new n9.b(bVar.g(), bVar.e(), bVar.b(), bVar.d(), bVar.f(), bVar.a());
        bVar2.k(bVar.a());
        bVar2.p(bVar.f());
        this.f11426p0.u(i10);
        this.f11424n0.d(bVar.c());
        w9.n.e().w(true);
        g6.n.t(l0(), a1(x7.u.f14062l7, bVar.e()), Z0(x7.u.Ug), new View.OnClickListener() { // from class: qa.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v0.V2(this.f11411a, bVar2, i10, view);
            }
        });
    }

    public final void k3(n9.b bVar) {
        if (bVar == null) {
            return;
        }
        int size = this.f11425o0.size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            } else if (((n9.b) this.f11425o0.get(size)).c() == bVar.c()) {
                break;
            } else {
                size--;
            }
        }
        if (size >= 0) {
            this.f11425o0.set(size, bVar);
            this.f11426p0.m(size);
        }
    }

    public final void l3(int i10) {
        if (this.f11429s0 == null || this.f11428r0 == null) {
            return;
        }
        int iM = this.f11427q0.m() + g6.y.h(I(), 18.0f);
        int iH = g6.y.h(I(), 540.0f) / iM;
        int i11 = !pa.r.j().X().d() ? 1 : 0;
        int i12 = iH / 2;
        while (true) {
            if (iH < 0) {
                break;
            }
            if (i10 >= (iH + i11) * iM) {
                i12 = iH;
                break;
            }
            iH--;
        }
        pc.a.a("calc count: %d, pass count: %d", Integer.valueOf(i12), Integer.valueOf(this.f11423m0.k()));
        int iMax = Math.max(i12, this.f11423m0.k());
        int i13 = (i10 - (iM * iMax)) / 2;
        if (i13 > 0) {
            this.f11429s0.setPadding(i13, 0, i13, 0);
        } else {
            this.f11429s0.setPadding(0, 0, 0, 0);
        }
        this.f11428r0.e3(iMax);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i10 = I().getResources().getConfiguration().orientation;
        int i11 = configuration.orientation;
        super.onConfigurationChanged(configuration);
        f1 f1Var = this.f11423m0;
        if (f1Var == null || this.f11429s0 == null || this.f11428r0 == null) {
            return;
        }
        f1Var.l(0);
        l3(g6.y.h(I(), configuration.screenWidthDp));
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f11424n0 = pa.r.f();
        this.f11425o0 = new ArrayList();
        if (M0() != null) {
            this.f11423m0 = (f1) new androidx.lifecycle.y(M0()).a(f1.class);
        }
    }
}
