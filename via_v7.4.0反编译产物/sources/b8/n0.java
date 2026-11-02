package b8;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n0 extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public y f1879m0;

    /* renamed from: n0, reason: collision with root package name */
    public RecyclerView f1880n0;

    /* renamed from: o0, reason: collision with root package name */
    public y5.f f1881o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f1882p0;

    /* renamed from: q0, reason: collision with root package name */
    public View f1883q0;

    /* renamed from: r0, reason: collision with root package name */
    public ImageView f1884r0;

    /* renamed from: s0, reason: collision with root package name */
    public EditText f1885s0;

    /* renamed from: t0, reason: collision with root package name */
    public ImageView f1886t0;

    /* renamed from: u0, reason: collision with root package name */
    public EditText f1887u0;

    /* renamed from: v0, reason: collision with root package name */
    public TextView f1888v0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            n0.this.n3(!r2.m3());
        }
    }

    public static /* synthetic */ boolean b3(n0 n0Var, View view, int i10, KeyEvent keyEvent) {
        if (i10 == 66) {
            n0Var.j3();
            return true;
        }
        n0Var.getClass();
        return false;
    }

    public static /* synthetic */ void d3(n0 n0Var, View view) {
        if (n0Var.f1883q0.getVisibility() == 0) {
            n0Var.k3();
        }
        n0Var.f1879m0.O(0);
    }

    public static /* synthetic */ void g3(final n0 n0Var, a8.f fVar, List list) {
        n0Var.getClass();
        int size = list.size();
        n0Var.f1888v0.setVisibility(size == 0 ? 0 : 8);
        n0Var.f1880n0.setVisibility(size == 0 ? 8 : 0);
        final int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((a8.a) list.get(i10)).c()) {
                break;
            } else {
                i10++;
            }
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new a8.b(n0Var.f1881o0.H(), list));
        n0Var.f1881o0.M(list);
        fVar.o(14 - (size > 6 ? Math.min((size - 6) / 2, 8) : 0));
        eVarB.c(n0Var.f1881o0);
        if (i10 >= 0) {
            n0Var.f1880n0.post(new Runnable() { // from class: b8.m0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1876e.f1880n0.p1(i10);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13876k, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        this.f1888v0 = (TextView) view.findViewById(x7.p.f13818k1);
        ImageView imageView = (ImageView) view.findViewById(x7.p.K);
        imageView.setImageDrawable(lb.b.a(I(), x7.o.f13759r, x7.u.Sd));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: b8.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n0.d3(this.f1847a, view2);
            }
        });
        this.f1882p0 = (TextView) view.findViewById(x7.p.H1);
        ImageView imageView2 = (ImageView) view.findViewById(x7.p.W);
        this.f1884r0 = imageView2;
        imageView2.setImageDrawable(lb.b.a(I(), x7.o.f13747n, x7.u.Rd));
        this.f1884r0.setOnClickListener(new View.OnClickListener() { // from class: b8.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f1855a.p3();
            }
        });
        EditText editText = (EditText) view.findViewById(x7.p.f13816k);
        this.f1885s0 = editText;
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: b8.f0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return n0.b3(this.f1857a, view2, i10, keyEvent);
            }
        });
        this.f1883q0 = view.findViewById(x7.p.V0);
        ((ImageView) view.findViewById(x7.p.X)).setImageDrawable(lb.b.a(I(), x7.o.f13724f0, x7.u.fe));
        view.findViewById(x7.p.f13854w1).setOnClickListener(new View.OnClickListener() { // from class: b8.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f1859a.j3();
            }
        });
        this.f1887u0 = (EditText) view.findViewById(x7.p.f13828o);
        ImageView imageView3 = (ImageView) view.findViewById(x7.p.f13799e0);
        this.f1886t0 = imageView3;
        imageView3.setImageDrawable(lb.b.a(I(), x7.o.f13737j1, x7.u.qf));
        this.f1886t0.setOnClickListener(new a());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.f1880n0 = recyclerView;
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f1880n0.setLayoutManager(new LinearLayoutManager(I()));
        r3.d(this.f1880n0);
        r3.a(this.f1880n0);
        this.f1881o0 = new y5.f(Collections.EMPTY_LIST);
        final a8.f fVar = new a8.f();
        fVar.j(new y5.g() { // from class: b8.h0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f1865a.f1879m0.N(((a8.a) obj).a().b());
            }
        });
        this.f1881o0.K(a8.a.class, fVar);
        this.f1880n0.setAdapter(this.f1881o0);
        ((autodispose2.n) u8.c.a(this.f1887u0).f(100L, TimeUnit.MILLISECONDS).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: b8.i0
            @Override // a7.e
            public final void accept(Object obj) {
                this.f1867e.f1879m0.y(((CharSequence) obj).toString());
            }
        }, new x7.g0());
        this.f1879m0.A().g(d1(), new androidx.lifecycle.m() { // from class: b8.j0
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                n0.g3(this.f1869a, fVar, (List) obj);
            }
        });
    }

    public final void j3() {
        z8.f.e(this.f1884r0);
        String string = this.f1885s0.getText().toString();
        if (string.isEmpty()) {
            g6.y.X(this.f1885s0);
            g6.n.i(this.f1885s0);
        } else {
            this.f1879m0.w(string);
            this.f1885s0.setText("");
            k3();
        }
    }

    public final void k3() {
        x.r.c(this.f1884r0).c(0.0f).d(80L).f();
        x.r.c(this.f1883q0).a(0.0f).d(150L).e(x8.h.b()).i(new Runnable() { // from class: b8.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1872e.f1883q0.setVisibility(8);
            }
        }).f();
        x.r.c(this.f1880n0).h(-g6.f.d(I(), x7.n.C)).e(x8.h.b()).d(150L).i(new Runnable() { // from class: b8.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1874e.f1880n0.setTranslationY(0.0f);
            }
        }).f();
    }

    public final boolean l3() {
        return this.f1883q0.getVisibility() == 0;
    }

    public final boolean m3() {
        return this.f1887u0.getVisibility() == 0;
    }

    public final void n3(boolean z10) {
        if (l3()) {
            k3();
        }
        if (z10) {
            x.r.c(this.f1882p0).a(0.0f).d(100L).i(new Runnable() { // from class: b8.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1849e.f1882p0.setVisibility(8);
                }
            }).f();
            x.r.c(this.f1886t0).a(0.0f).d(100L).i(new Runnable() { // from class: b8.c0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1851e.f1886t0.setVisibility(8);
                }
            }).f();
            this.f1887u0.setAlpha(0.0f);
            this.f1887u0.setVisibility(0);
            x.r.c(this.f1887u0).a(1.0f).d(100L).f();
            x.r.c(this.f1884r0).c(45.0f).d(80L).f();
            this.f1887u0.requestFocus();
            z8.f.l(this.f1887u0);
            return;
        }
        this.f1887u0.setText("");
        z8.f.e(this.f1887u0);
        this.f1882p0.setVisibility(0);
        x.r.c(this.f1882p0).a(1.0f).d(100L).f();
        this.f1886t0.setVisibility(0);
        x.r.c(this.f1886t0).a(1.0f).d(100L).f();
        x.r.c(this.f1887u0).a(0.0f).d(100L).i(new Runnable() { // from class: b8.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1853e.f1887u0.setVisibility(8);
            }
        }).f();
        x.r.c(this.f1884r0).c(0.0f).d(80L).f();
    }

    public final void o3() {
        this.f1883q0.setAlpha(0.0f);
        this.f1883q0.setVisibility(0);
        this.f1880n0.setTranslationY(-g6.f.d(I(), x7.n.C));
        x.r.c(this.f1884r0).c(45.0f).d(80L).f();
        x.r.c(this.f1883q0).a(1.0f).d(150L).e(x8.h.b()).f();
        x.r.c(this.f1880n0).h(0.0f).e(x8.h.b()).d(150L).f();
    }

    public final void p3() {
        if (m3()) {
            n3(false);
        } else if (this.f1883q0.getVisibility() == 8) {
            o3();
        } else {
            k3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f1879m0 = (y) new androidx.lifecycle.y(B2(), pa.r.n()).a(y.class);
    }
}
