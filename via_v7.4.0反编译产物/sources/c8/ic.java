package c8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
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
import com.tuyafeng.support.widget.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import v5.b;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class ic extends o8.h {
    public a0.b A0;
    public a0.b B0;
    public boolean C0;
    public boolean D0;

    /* renamed from: o0, reason: collision with root package name */
    public final List f2512o0 = new ArrayList();

    /* renamed from: p0, reason: collision with root package name */
    public List f2513p0 = Collections.EMPTY_LIST;

    /* renamed from: q0, reason: collision with root package name */
    public String f2514q0 = null;

    /* renamed from: r0, reason: collision with root package name */
    public final v8.b f2515r0 = new v8.b();

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f2516s0;

    /* renamed from: t0, reason: collision with root package name */
    public Drawable f2517t0;

    /* renamed from: u0, reason: collision with root package name */
    public EditText f2518u0;

    /* renamed from: v0, reason: collision with root package name */
    public na.h f2519v0;

    /* renamed from: w0, reason: collision with root package name */
    public mark.via.common.widget.r0 f2520w0;

    /* renamed from: x0, reason: collision with root package name */
    public RecyclerView f2521x0;

    /* renamed from: y0, reason: collision with root package name */
    public View f2522y0;

    /* renamed from: z0, reason: collision with root package name */
    public com.tuyafeng.support.widget.a0 f2523z0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            View viewA = b6.c.c().a(viewGroup);
            z8.r3.p((TextView) viewA.findViewById(b6.c.f1829d));
            return viewA;
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, na.f fVar, int i10) {
            ImageView imageView = (ImageView) gVar.P(b6.c.f1830e);
            Bitmap bitmapD = z8.x0.c().d(ic.this.I(), fVar.f());
            if (bitmapD != null) {
                imageView.setImageBitmap(bitmapD);
            } else {
                imageView.setImageDrawable(ic.this.f2517t0);
            }
            String strJ = g6.p.j(fVar.e(), 256);
            if (g6.p.f(strJ)) {
                strJ = ic.this.Z0(x7.u.bh);
            }
            gVar.X(b6.c.f1828c, strJ);
            gVar.X(b6.c.f1829d, i6.g0.f6993a.d(fVar.f()));
        }
    }

    public static /* synthetic */ void c3(ic icVar, int i10, Boolean bool) {
        icVar.getClass();
        if (bool.booleanValue()) {
            b6.b bVarC = icVar.f2515r0.c(i10);
            icVar.f2515r0.f(i10);
            icVar.f2513p0.remove(i10);
            icVar.f2516s0.u(i10);
            if (bVarC.c()) {
                icVar.f2516s0.n(i10 - 1, Boolean.FALSE);
            }
            icVar.s3(icVar.f2516s0.g() == 0);
        }
    }

    public static /* synthetic */ void d3(ic icVar, CharSequence charSequence) {
        icVar.getClass();
        icVar.v3(charSequence.toString());
    }

    public static /* synthetic */ boolean e3(final ic icVar, View view, final int i10, final na.f fVar) {
        icVar.getClass();
        w5.k.l(view.getContext()).F(new String[]{icVar.Z0(x7.u.Q), icVar.Z0(x7.u.R), icVar.Z0(x7.u.f14215x), icVar.Z0(x7.u.f14150s), icVar.Z0(x7.u.f13943d0)}, new AdapterView.OnItemClickListener() { // from class: c8.dc
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                ic.l3(this.f2407a, fVar, i10, adapterView, view2, i11, j10);
            }
        }).h0(view);
        return true;
    }

    public static /* synthetic */ void f3(ic icVar, View view, int i10, na.f fVar) {
        if (!icVar.f2512o0.contains(fVar.c())) {
            icVar.f2512o0.add(fVar.c());
        }
        icVar.f2514q0 = fVar.c();
        icVar.l0().onBackPressed();
    }

    public static /* synthetic */ void h3(final ic icVar, View view, k.p pVar) {
        icVar.getClass();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.vb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f2888e.f2519v0.h());
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(icVar.d1()))).a(new a7.e() { // from class: c8.wb
            @Override // a7.e
            public final void accept(Object obj) {
                ic.n3(this.f2905e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public static /* synthetic */ void k3(ic icVar, View view, a0.b bVar) {
        icVar.getClass();
        int iA = bVar.a();
        if (iA == x7.p.M0) {
            icVar.q3();
        } else if (iA == x7.p.P0) {
            g6.i.g(icVar, hb.e7.class);
        }
    }

    public static /* synthetic */ void l3(final ic icVar, final na.f fVar, final int i10, AdapterView adapterView, View view, int i11, long j10) {
        icVar.getClass();
        if (i11 == 0 || i11 == 1) {
            icVar.f2512o0.remove(fVar.c());
            icVar.f2512o0.add(fVar.c());
            if (i11 != 1) {
                g6.n.q(icVar.I(), x7.u.f14212w9);
                return;
            } else {
                icVar.f2514q0 = fVar.c();
                icVar.l0().onBackPressed();
                return;
            }
        }
        if (i11 == 2) {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.tb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(this.f2850e.f2519v0.a(fVar.c()));
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(icVar.d1()))).a(new a7.e() { // from class: c8.ub
                @Override // a7.e
                public final void accept(Object obj) {
                    ic.c3(this.f2871e, i10, (Boolean) obj);
                }
            }, new x7.g0());
        } else if (i11 == 3) {
            g6.n.a(icVar.I(), fVar.f(), x7.u.pg);
        } else {
            if (i11 != 4) {
                return;
            }
            z8.f1.k(icVar.I(), fVar.f());
        }
    }

    public static /* synthetic */ void n3(ic icVar, Boolean bool) {
        icVar.getClass();
        if (bool.booleanValue()) {
            icVar.r3();
        }
    }

    private void r3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.hc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2490e.f2519v0.g();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new gc(this), new x7.g0());
    }

    private void s3(boolean z10) {
        if (z10 == this.C0) {
            return;
        }
        this.f2520w0.setEmpty(z10);
        this.C0 = z10;
        t3(z10);
    }

    private void t3(boolean z10) {
        this.A0.j(z10);
        this.f2523z0.j(this.A0);
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        if (!this.f2512o0.isEmpty()) {
            String[] strArr = (String[]) this.f2512o0.toArray(new String[0]);
            Bundle bundle = new Bundle();
            bundle.putStringArray("tabs", strArr);
            bundle.putString("selected", this.f2514q0);
            N0().x1("restore_tabs", bundle);
        }
        super.D1();
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        u3();
        super.O1();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        Drawable drawableA = lb.b.a(I(), x7.o.f13783z, x7.u.Ud);
        if (drawableA != null) {
            drawableA.setColorFilter(g6.e.a(I(), x7.k.f13662h), PorterDuff.Mode.SRC_IN);
        }
        g6.y.P(this.f2518u0, drawableA);
        Bundle bundleC = v5.b.d().c("CLOSED_TABS_CACHE");
        if (bundleC != null) {
            this.f2518u0.setText(bundleC.getString("query", ""));
        }
        ((autodispose2.n) u8.c.a(this.f2518u0).f(100L, TimeUnit.MILLISECONDS).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: c8.sb
            @Override // a7.e
            public final void accept(Object obj) {
                ic.d3(this.f2831e, (CharSequence) obj);
            }
        }, new x7.g0());
        this.f2523z0.setOnActionClickListener(new a0.c() { // from class: c8.zb
            @Override // com.tuyafeng.support.widget.a0.c
            public final void a(View view2, a0.b bVar) {
                ic.k3(this.f2974a, view2, bVar);
            }
        });
        Drawable drawableA2 = lb.b.a(I(), x7.o.f13748n0, x7.u.ie);
        this.f2517t0 = drawableA2;
        g6.h.a(drawableA2, g6.e.a(view.getContext(), x7.k.f13662h));
        z8.r3.d(this.f2521x0);
        z8.r3.f(this.f2521x0);
        this.f2515r0.h(new v8.a(I()));
        Context contextI = I();
        v8.b bVar = this.f2515r0;
        Objects.requireNonNull(bVar);
        c6.b bVar2 = new c6.b(contextI, new ac(bVar));
        bVar2.o(1);
        bVar2.n(g6.e.a(I(), x7.k.f13655a));
        this.f2521x0.k(bVar2);
        this.f2521x0.setLayoutManager(new LinearLayoutManager(I()));
        this.f2516s0 = new y5.f(new ArrayList());
        a aVar = new a();
        aVar.j(new y5.g() { // from class: c8.bc
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                ic.f3(this.f2361a, view2, i10, (na.f) obj);
            }
        });
        aVar.k(new y5.h() { // from class: c8.cc
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return ic.e3(this.f2389a, view2, i10, (na.f) obj);
            }
        });
        this.f2516s0.K(na.f.class, aVar);
        this.f2521x0.setAdapter(this.f2516s0);
        r3();
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        mark.via.common.widget.r0 r0Var = (mark.via.common.widget.r0) new h6.a(new mark.via.common.widget.r0(I()), new ViewGroup.LayoutParams(-1, -1)).l();
        RecyclerView recyclerView = r0Var.f9734e;
        this.f2521x0 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f2522y0 = r0Var.f9736k;
        this.f2518u0 = r0Var.f9737l;
        this.f2523z0 = r0Var.f9738m;
        a0.b bVar = new a0.b(x7.p.M0, Z0(x7.u.f14228y));
        this.A0 = bVar;
        bVar.i(true);
        this.A0.j(false);
        a0.b bVar2 = new a0.b(x7.p.P0, Z0(x7.u.f14198v8));
        this.B0 = bVar2;
        this.f2523z0.b(bVar2);
        this.f2523z0.c(this.A0);
        this.f2520w0 = r0Var;
        return r0Var;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.Ra));
    }

    public final void q3() {
        g6.n.e(I(), x7.u.f14228y, x7.u.f14219x3, new k.m() { // from class: c8.ec
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                ic.h3(this.f2430a, view, pVar);
            }
        });
    }

    public final void u3() {
        RecyclerView recyclerView = this.f2521x0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        b.C0148b c0148bF = v5.b.a().e("CLOSED_TABS_CACHE").f(180);
        EditText editText = this.f2518u0;
        if (editText != null) {
            c0148bF.d("query", editText.getText().toString());
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f2521x0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0148bF.b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0148bF.a();
    }

    public final void v3(final String str) {
        if (str == null || str.isEmpty()) {
            r3();
        } else {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.fc
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f2455e.f2519v0.b(str, 1024);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new gc(this), new x7.g0());
        }
    }

    public final void w3(List list) {
        RecyclerView recyclerView;
        Collections.sort(list, new Comparator() { // from class: c8.xb
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((na.f) obj2).d(), ((na.f) obj).d());
            }
        });
        this.f2513p0 = list;
        this.f2515r0.g(list, new v8.c() { // from class: c8.yb
            @Override // v8.c
            public final long a(Object obj) {
                return ((na.f) obj).d();
            }
        });
        this.f2516s0.M(this.f2513p0);
        this.f2516s0.l();
        s3(list.isEmpty());
        if (this.D0) {
            return;
        }
        this.D0 = true;
        Bundle bundleC = v5.b.d().c("CLOSED_TABS_CACHE");
        if (bundleC == null || (recyclerView = this.f2521x0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutManager) this.f2521x0.getLayoutManager()).B2(bundleC.getInt("position", 0), bundleC.getInt("offset", 0));
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        pa.r.b(I()).s(this);
    }
}
