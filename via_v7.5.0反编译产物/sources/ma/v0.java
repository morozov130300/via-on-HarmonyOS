package ma;

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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import x8.r3;
import x8.w3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v0 extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public f1 f8065o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public w9.a f8066p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public List f8067q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public t5.f f8068r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public j0 f8069s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public GridLayoutManager f8070t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public RecyclerView f8071u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public RelativeLayout f8072v0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends androidx.recyclerview.widget.j.i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8073f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8074g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8075h;

        public a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.d0 d0Var, int i10) {
            super.A(d0Var, i10);
            if (i10 != 0 && d0Var != null) {
                this.f8075h = i10 == 2;
                int iK = d0Var.k();
                this.f8073f = iK;
                this.f8074g = iK;
            }
            if (this.f8075h && i10 == 0) {
                this.f8075h = false;
                if (this.f8073f != this.f8074g) {
                    u9.n.e().u(true);
                    x8.h.b(new Runnable() { // from class: ma.u0
                        @Override // java.lang.Runnable
                        public final void run() {
                            v0.a aVar = this.f8063c;
                            v0.this.f8066p0.y(aVar.f8073f, aVar.f8074g);
                        }
                    });
                }
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.d0 d0Var, int i10) {
            v0.this.h3(d0Var.k());
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            v0.this.f8068r0.p(d0Var.k(), d0Var2.k());
            return true;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void z(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i10, RecyclerView.d0 d0Var2, int i11, int i12, int i13) {
            super.z(recyclerView, d0Var, i10, d0Var2, i11, i12, i13);
            v0.this.f8067q0.add(i11, (l9.b) v0.this.f8067q0.remove(i10));
            this.f8074g = i11;
        }
    }

    public static /* synthetic */ void T2(v0 v0Var, l9.b bVar, int i10, View view) {
        long jS = v0Var.f8066p0.s(bVar);
        if (jS <= 0 || v0Var.h1()) {
            return;
        }
        bVar.m((int) jS);
        v0Var.f8067q0.add(i10, bVar);
        v0Var.f8068r0.o(i10);
    }

    public static /* synthetic */ void W2(final v0 v0Var, TextView textView) {
        v0Var.getClass();
        textView.setOnClickListener(new View.OnClickListener() { // from class: ma.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8057a.f8065o0.j(true);
            }
        });
        textView.setText(w7.u.X3);
        textView.setGravity(17);
        textView.setTextColor(v8.h.j(v0Var.G()));
        textView.setTextSize(0, v8.h.q(v0Var.G()));
        r3.r(textView);
    }

    public static /* synthetic */ void X2(v0 v0Var, RecyclerView recyclerView) {
        r3.e(v0Var.f8071u0);
        r3.g(recyclerView);
    }

    public static /* synthetic */ void Z2(v0 v0Var, TextView textView) {
        v0Var.getClass();
        textView.setText(w7.u.L);
        textView.setGravity(17);
        textView.setTextColor(v8.h.o(v0Var.G()));
        textView.setTextSize(0, v8.h.r(v0Var.G()));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        r3.r(textView);
    }

    public static /* synthetic */ void a3(v0 v0Var, List list) {
        v0Var.f8067q0.clear();
        v0Var.f8067q0.addAll(list);
        v0Var.f8068r0.l();
    }

    private void g3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: ma.s0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f8059c.f8066p0.h();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.t0
            @Override // u6.f
            public final void accept(Object obj) {
                v0.a3(this.f8061c, (List) obj);
            }
        }, new w7.a0());
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8072v0 = (RelativeLayout) new b6.a(new RelativeLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        TextView textView = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-2, -2)).o(com.tuyafeng.support.utils.x.l()).m(com.tuyafeng.support.utils.f.d(G(), w7.n.f13751d)).h(9).V(new b6.a.InterfaceC0033a() { // from class: ma.k0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                v0.Z2(this.f8028a, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-2, -2)).g(144, textView.getId()).h(8).N(1, 16).V(new b6.a.InterfaceC0033a() { // from class: ma.l0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                v0.W2(this.f8030a, (TextView) obj);
            }
        }).l();
        this.f8071u0 = (RecyclerView) new b6.a(new RecyclerView(G()), new RelativeLayout.LayoutParams(-1, -2)).g(32, textView.getId()).V(new b6.a.InterfaceC0033a() { // from class: ma.m0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                v0.X2(this.f8032a, (RecyclerView) obj);
            }
        }).l();
        this.f8072v0.addView(textView);
        this.f8072v0.addView(textView2);
        this.f8072v0.addView(this.f8071u0);
        return this.f8072v0;
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        this.f8068r0 = new t5.f(this.f8067q0);
        j0 j0Var = new j0(w3.m(G()), la.s.j().a3(), G().getResources());
        this.f8069s0 = j0Var;
        j0Var.j(new t5.g() { // from class: ma.n0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                v0 v0Var = this.f8034a;
                v0Var.f8065o0.m((l9.b) v0Var.f8067q0.get(i10));
            }
        });
        this.f8069s0.p(new j0.a() { // from class: ma.o0
            @Override // ma.j0.a
            public final void a(View view2, int i10) {
                this.f8048a.h3(i10);
            }
        });
        this.f8068r0.K(l9.b.class, this.f8069s0);
        this.f8070t0 = new GridLayoutManager(G(), 4);
        j3(com.tuyafeng.support.utils.x.h(G(), Resources.getSystem().getConfiguration().screenWidthDp));
        this.f8071u0.setLayoutManager(this.f8070t0);
        androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e();
        eVar.x(100L);
        this.f8071u0.setItemAnimator(eVar);
        this.f8071u0.setAdapter(this.f8068r0);
        new androidx.recyclerview.widget.j(new a(51, 0)).m(this.f8071u0);
        this.f8065o0.f8009i.g(b1(), new androidx.lifecycle.o() { // from class: ma.p0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f8050a.i3((l9.b) obj);
            }
        });
        g3();
    }

    public final void h3(final int i10) {
        List list = this.f8067q0;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return;
        }
        l9.b bVar = (l9.b) this.f8067q0.remove(i10);
        final l9.b bVar2 = new l9.b(bVar.g(), bVar.e(), bVar.b(), bVar.d(), bVar.f(), bVar.a());
        bVar2.k(bVar.a());
        bVar2.p(bVar.f());
        this.f8068r0.u(i10);
        this.f8066p0.d(bVar.c());
        u9.n.e().u(true);
        com.tuyafeng.support.utils.n.t(i0(), Y0(w7.u.f14293x7, bVar.e()), X0(w7.u.th), new View.OnClickListener() { // from class: ma.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v0.T2(this.f8053a, bVar2, i10, view);
            }
        });
    }

    public final void i3(l9.b bVar) {
        if (bVar == null) {
            return;
        }
        int size = this.f8067q0.size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            } else if (((l9.b) this.f8067q0.get(size)).c() == bVar.c()) {
                break;
            } else {
                size--;
            }
        }
        if (size >= 0) {
            this.f8067q0.set(size, bVar);
            this.f8068r0.m(size);
        }
    }

    public final void j3(int i10) {
        if (this.f8071u0 == null || this.f8070t0 == null) {
            return;
        }
        int iM = this.f8069s0.m() + com.tuyafeng.support.utils.x.h(G(), 18.0f);
        int iH = com.tuyafeng.support.utils.x.h(G(), 540.0f) / iM;
        int i11 = !la.s.j().a0().e() ? 1 : 0;
        int i12 = iH / 2;
        while (iH >= 0) {
            if (i10 >= (iH + i11) * iM) {
                i12 = iH;
                break;
            }
            iH--;
        }
        tc.a.a("calc count: %d, pass count: %d", Integer.valueOf(i12), Integer.valueOf(this.f8065o0.k()));
        int iMax = Math.max(i12, this.f8065o0.k());
        int i13 = (i10 - (iM * iMax)) / 2;
        if (i13 > 0) {
            this.f8071u0.setPadding(i13, 0, i13, 0);
        } else {
            this.f8071u0.setPadding(0, 0, 0, 0);
        }
        this.f8070t0.e3(iMax);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i10 = G().getResources().getConfiguration().orientation;
        int i11 = configuration.orientation;
        super.onConfigurationChanged(configuration);
        f1 f1Var = this.f8065o0;
        if (f1Var == null || this.f8071u0 == null || this.f8070t0 == null) {
            return;
        }
        f1Var.l(0);
        j3(com.tuyafeng.support.utils.x.h(G(), configuration.screenWidthDp));
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f8066p0 = la.s.f();
        this.f8067q0 = new ArrayList();
        if (K0() != null) {
            this.f8065o0 = (f1) new androidx.lifecycle.a0(K0()).a(f1.class);
        }
    }
}
