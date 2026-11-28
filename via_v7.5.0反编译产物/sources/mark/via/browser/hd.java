package mark.via.browser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class hd extends m8.g {
    public RecyclerView A0;
    public View B0;
    public com.tuyafeng.support.widget.f0 C0;
    public com.tuyafeng.support.widget.f0.b D0;
    public com.tuyafeng.support.widget.f0.b E0;
    public boolean F0;
    public boolean G0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final List f9208r0 = new ArrayList();

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public List f9209s0 = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public String f9210t0 = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final t8.b f9211u0 = new t8.b();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f9212v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public Drawable f9213w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public EditText f9214x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public ka.h f9215y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public mark.via.common.widget.r0 f9216z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            View viewA = w5.c.c().a(viewGroup);
            x8.r3.q((TextView) viewA.findViewById(w5.c.f13660d));
            return viewA;
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, ka.f fVar, int i10) {
            x8.y0.i((ImageView) gVar.P(w5.c.f13661e), x8.x0.c().d(hd.this.G(), fVar.f()), hd.this.f9213w0);
            String strJ = com.tuyafeng.support.utils.p.j(fVar.e(), 256);
            if (com.tuyafeng.support.utils.p.f(strJ)) {
                strJ = hd.this.X0(w7.u.Ah);
            }
            gVar.X(w5.c.f13659c, strJ);
            gVar.X(w5.c.f13660d, c6.y1.f2139a.d(fVar.f()));
        }
    }

    public static /* synthetic */ void b3(hd hdVar, int i10, Boolean bool) {
        hdVar.getClass();
        if (bool.booleanValue()) {
            w5.b bVarC = hdVar.f9211u0.c(i10);
            hdVar.f9211u0.f(i10);
            hdVar.f9209s0.remove(i10);
            hdVar.f9212v0.u(i10);
            if (bVarC.c()) {
                hdVar.f9212v0.n(i10 - 1, Boolean.FALSE);
            }
            hdVar.r3(hdVar.f9212v0.g() == 0);
        }
    }

    public static /* synthetic */ void c3(hd hdVar, CharSequence charSequence) {
        hdVar.getClass();
        hdVar.u3(charSequence.toString());
    }

    public static /* synthetic */ boolean d3(final hd hdVar, View view, final int i10, final ka.f fVar) {
        hdVar.getClass();
        q5.k.l(view.getContext()).G(new String[]{hdVar.X0(w7.u.R), hdVar.X0(w7.u.S), hdVar.X0(w7.u.f14298y), hdVar.X0(w7.u.f14218s), hdVar.X0(w7.u.f14037f0)}, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.cd
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                hd.k3(this.f9069a, fVar, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return true;
    }

    public static /* synthetic */ void e3(hd hdVar, View view, int i10, ka.f fVar) {
        if (!hdVar.f9208r0.contains(fVar.c())) {
            hdVar.f9208r0.add(fVar.c());
        }
        hdVar.f9210t0 = fVar.c();
        hdVar.i0().onBackPressed();
    }

    public static /* synthetic */ void g3(final hd hdVar, View view, q5.k.p pVar) {
        hdVar.getClass();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.uc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f9696c.f9215y0.h());
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(hdVar.b1()))).a(new u6.f() { // from class: mark.via.browser.vc
            @Override // u6.f
            public final void accept(Object obj) {
                hd.m3(this.f9712c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public static /* synthetic */ void j3(hd hdVar, View view, com.tuyafeng.support.widget.f0.b bVar) {
        hdVar.getClass();
        int iA = bVar.a();
        if (iA == w7.p.M0) {
            hdVar.p3();
        } else if (iA == w7.p.P0) {
            FragmentUtils.i(hdVar, hb.e7.class);
        }
    }

    public static /* synthetic */ void k3(final hd hdVar, final ka.f fVar, final int i10, AdapterView adapterView, View view, int i11, long j10) {
        hdVar.getClass();
        if (i11 == 0 || i11 == 1) {
            hdVar.f9208r0.remove(fVar.c());
            hdVar.f9208r0.add(fVar.c());
            if (i11 != 1) {
                com.tuyafeng.support.utils.n.q(hdVar.G(), w7.u.I9);
                return;
            } else {
                hdVar.f9210t0 = fVar.c();
                hdVar.i0().onBackPressed();
                return;
            }
        }
        if (i11 == 2) {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.sc
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(this.f9656c.f9215y0.b(fVar.c()));
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(hdVar.b1()))).a(new u6.f() { // from class: mark.via.browser.tc
                @Override // u6.f
                public final void accept(Object obj) {
                    hd.b3(this.f9674c, i10, (Boolean) obj);
                }
            }, new w7.e0());
        } else if (i11 == 3) {
            com.tuyafeng.support.utils.n.a(hdVar.G(), fVar.f(), w7.u.Fg);
        } else {
            if (i11 != 4) {
                return;
            }
            x8.e1.k(hdVar.G(), fVar.f());
        }
    }

    public static /* synthetic */ void m3(hd hdVar, Boolean bool) {
        hdVar.getClass();
        if (bool.booleanValue()) {
            hdVar.q3();
        }
    }

    private void q3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.gd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f9180c.f9215y0.g();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new fd(this), new w7.e0());
    }

    private void r3(boolean z10) {
        this.f9216z0.setSearchVisible(this.f9214x0.length() > 0 || !z10);
        if (z10 == this.F0) {
            return;
        }
        this.f9216z0.setEmpty(z10);
        this.F0 = z10;
        s3(z10);
    }

    private void s3(boolean z10) {
        this.D0.j(z10);
        this.C0.l(this.D0);
    }

    private void t3() {
        RecyclerView recyclerView = this.A0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        p5.b.C0110b c0110bF = p5.b.a().e("CLOSED_TABS_CACHE").f(180);
        EditText editText = this.f9214x0;
        if (editText != null) {
            c0110bF.d("query", editText.getText().toString());
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.A0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0110bF.b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0110bF.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        if (!this.f9208r0.isEmpty()) {
            String[] strArr = (String[]) this.f9208r0.toArray(new String[0]);
            Bundle bundle = new Bundle();
            bundle.putStringArray("tabs", strArr);
            bundle.putString("selected", this.f9210t0);
            L0().y1("restore_tabs", bundle);
        }
        super.B1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        t3();
        super.M1();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        Bundle bundleC = p5.b.d().c("CLOSED_TABS_CACHE");
        if (bundleC != null) {
            this.f9214x0.setText(bundleC.getString("query", ""));
        }
        ((autodispose2.n) s8.c.a(this.f9214x0).g(100L, TimeUnit.MILLISECONDS).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.browser.rc
            @Override // u6.f
            public final void accept(Object obj) {
                hd.c3(this.f9607c, (CharSequence) obj);
            }
        }, new w7.e0());
        this.C0.setOnActionClickListener(new com.tuyafeng.support.widget.f0.c() { // from class: mark.via.browser.yc
            @Override // com.tuyafeng.support.widget.f0.c
            public final void a(View view2, com.tuyafeng.support.widget.f0.b bVar) {
                hd.j3(this.f9800a, view2, bVar);
            }
        });
        Drawable drawableC = lb.g.c(G(), w7.o.f13817o0, w7.u.ye);
        this.f9213w0 = drawableC;
        com.tuyafeng.support.utils.h.a(drawableC, com.tuyafeng.support.utils.e.a(view.getContext(), w7.k.f13729i));
        x8.r3.e(this.A0);
        x8.r3.g(this.A0);
        this.f9211u0.h(new t8.a(G()));
        Context contextG = G();
        t8.b bVar = this.f9211u0;
        Objects.requireNonNull(bVar);
        x5.b bVar2 = new x5.b(contextG, new zc(bVar));
        bVar2.o(1);
        bVar2.n(com.tuyafeng.support.utils.e.a(G(), w7.k.f13722b));
        this.A0.k(bVar2);
        this.A0.n(bVar2);
        this.A0.setLayoutManager(new LinearLayoutManager(G()));
        this.f9212v0 = new t5.f(new ArrayList());
        a aVar = new a();
        aVar.j(new t5.g() { // from class: mark.via.browser.ad
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                hd.e3(this.f9020a, view2, i10, (ka.f) obj);
            }
        });
        aVar.k(new t5.h() { // from class: mark.via.browser.bd
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return hd.d3(this.f9038a, view2, i10, (ka.f) obj);
            }
        });
        this.f9212v0.K(ka.f.class, aVar);
        this.A0.setAdapter(this.f9212v0);
        q3();
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        mark.via.common.widget.r0 r0Var = (mark.via.common.widget.r0) new b6.a(new mark.via.common.widget.r0(G()), new ViewGroup.LayoutParams(-1, -1)).l();
        r0Var.setSearchVisible(false);
        RecyclerView recyclerView = r0Var.f10038c;
        this.A0 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.B0 = r0Var.f10040m;
        this.f9214x0 = r0Var.f10041n;
        this.C0 = r0Var.f10042o;
        com.tuyafeng.support.widget.f0.b bVar = new com.tuyafeng.support.widget.f0.b(w7.p.M0, X0(w7.u.f14311z));
        this.D0 = bVar;
        bVar.i(true);
        this.D0.j(false);
        com.tuyafeng.support.widget.f0.b bVar2 = new com.tuyafeng.support.widget.f0.b(w7.p.P0, X0(w7.u.H8));
        this.E0 = bVar2;
        this.C0.b(bVar2);
        this.C0.c(this.D0);
        this.f9216z0 = r0Var;
        return r0Var;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.f14020db));
    }

    public final void p3() {
        com.tuyafeng.support.utils.n.e(G(), w7.u.f14311z, w7.u.K3, new q5.k.m() { // from class: mark.via.browser.dd
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                hd.g3(this.f9097a, view, pVar);
            }
        });
    }

    public final void u3(final String str) {
        if (str == null || str.isEmpty()) {
            q3();
        } else {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.ed
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f9123c.f9215y0.c(str, 1024);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new fd(this), new w7.e0());
        }
    }

    public final void v3(List list) {
        RecyclerView recyclerView;
        Collections.sort(list, new Comparator() { // from class: mark.via.browser.wc
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((ka.f) obj2).d(), ((ka.f) obj).d());
            }
        });
        this.f9209s0 = list;
        this.f9211u0.g(list, new t8.c() { // from class: mark.via.browser.xc
            @Override // t8.c
            public final long a(Object obj) {
                return ((ka.f) obj).d();
            }
        });
        this.f9212v0.M(this.f9209s0);
        this.f9212v0.l();
        r3(list.isEmpty());
        if (this.G0) {
            return;
        }
        this.G0 = true;
        Bundle bundleC = p5.b.d().c("CLOSED_TABS_CACHE");
        if (bundleC == null || (recyclerView = this.A0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutManager) this.A0.getLayoutManager()).B2(bundleC.getInt("position", 0), bundleC.getInt("offset", 0));
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        la.s.b(G()).w(this);
    }
}
