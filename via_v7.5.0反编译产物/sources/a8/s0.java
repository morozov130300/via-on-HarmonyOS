package a8;

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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s0 extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public a0 f179o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public RecyclerView f180p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public t5.f f181q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public TextView f182r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public View f183s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ImageView f184t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f185u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ImageView f186v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public EditText f187w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public TextView f188x0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            s0 s0Var = s0.this;
            s0Var.m3(!s0Var.l3());
        }
    }

    public static /* synthetic */ void V2(final s0 s0Var, v0 v0Var, final List list) {
        s0Var.getClass();
        int size = list.size();
        s0Var.f188x0.setVisibility(size == 0 ? 0 : 8);
        s0Var.f180p0.setVisibility(size != 0 ? 0 : 8);
        final int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((t0) list.get(i10)).c()) {
                break;
            } else {
                i10++;
            }
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new z7.b(s0Var.f181q0.H(), list));
        s0Var.f181q0.M(list);
        boolean zP = v0Var.p(!s0Var.f179o0.L());
        v0Var.m(size);
        eVarB.c(s0Var.f181q0);
        if (zP) {
            s0Var.f181q0.r(0, size, Boolean.TRUE);
        }
        if (!s0Var.f179o0.y() || i10 < 0) {
            return;
        }
        s0Var.f180p0.post(new Runnable() { // from class: a8.f0
            @Override // java.lang.Runnable
            public final void run() {
                s0.Z2(this.f139c, list, i10);
            }
        });
    }

    public static /* synthetic */ boolean W2(s0 s0Var, View view, int i10, KeyEvent keyEvent) {
        if (i10 == 66) {
            s0Var.i3();
            return true;
        }
        s0Var.getClass();
        return false;
    }

    public static /* synthetic */ void Y2(s0 s0Var, View view) {
        if (s0Var.f183s0.getVisibility() == 0) {
            s0Var.j3();
        }
        s0Var.f179o0.V(0);
    }

    public static /* synthetic */ void Z2(s0 s0Var, List list, int i10) {
        if (s0Var.f181q0.H() == list) {
            s0Var.f180p0.p1(i10);
        }
    }

    public static /* synthetic */ void e3(s0 s0Var, Integer num) {
        s0Var.getClass();
        if (num.intValue() == 0 && s0Var.l3()) {
            s0Var.m3(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l3() {
        return this.f187w0.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3(boolean z10) {
        if (k3()) {
            j3();
        }
        if (z10) {
            y.r.c(this.f182r0).a(0.0f).d(100L).i(new Runnable() { // from class: a8.g0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f143c.f182r0.setVisibility(8);
                }
            }).f();
            y.r.c(this.f186v0).a(0.0f).d(100L).i(new Runnable() { // from class: a8.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f149c.f186v0.setVisibility(8);
                }
            }).f();
            this.f187w0.setAlpha(0.0f);
            this.f187w0.setVisibility(0);
            y.r.c(this.f187w0).a(1.0f).d(100L).f();
            y.r.c(this.f184t0).c(45.0f).d(80L).f();
            this.f187w0.requestFocus();
            x8.f.l(this.f187w0);
            return;
        }
        this.f187w0.setText("");
        x8.f.e(this.f187w0);
        this.f182r0.setVisibility(0);
        y.r.c(this.f182r0).a(1.0f).d(100L).f();
        this.f186v0.setVisibility(0);
        y.r.c(this.f186v0).a(1.0f).d(100L).f();
        y.r.c(this.f187w0).a(0.0f).d(100L).i(new Runnable() { // from class: a8.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f151c.f187w0.setVisibility(8);
            }
        }).f();
        y.r.c(this.f184t0).c(0.0f).d(80L).f();
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13942k, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        this.f188x0 = (TextView) view.findViewById(w7.p.f13884k1);
        ImageView imageView = (ImageView) view.findViewById(w7.p.J);
        imageView.setImageDrawable(lb.g.a(G(), w7.o.f13822q, w7.u.he));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: a8.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                s0.Y2(this.f135a, view2);
            }
        });
        this.f182r0 = (TextView) view.findViewById(w7.p.H1);
        ImageView imageView2 = (ImageView) view.findViewById(w7.p.V);
        this.f184t0 = imageView2;
        imageView2.setImageDrawable(lb.g.a(G(), w7.o.f13810m, w7.u.ge));
        this.f184t0.setOnClickListener(new View.OnClickListener() { // from class: a8.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f153a.o3();
            }
        });
        EditText editText = (EditText) view.findViewById(w7.p.f13882k);
        this.f185u0 = editText;
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: a8.k0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return s0.W2(this.f155a, view2, i10, keyEvent);
            }
        });
        this.f183s0 = view.findViewById(w7.p.V0);
        ((ImageView) view.findViewById(w7.p.W)).setImageDrawable(lb.g.a(G(), w7.o.f13787e0, w7.u.ue));
        view.findViewById(w7.p.f13920w1).setOnClickListener(new View.OnClickListener() { // from class: a8.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f157a.i3();
            }
        });
        this.f187w0 = (EditText) view.findViewById(w7.p.f13891n);
        ImageView imageView3 = (ImageView) view.findViewById(w7.p.f13859c0);
        this.f186v0 = imageView3;
        imageView3.setImageDrawable(lb.g.a(G(), w7.o.f13797h1, w7.u.Hf));
        this.f186v0.setOnClickListener(new a());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.f180p0 = recyclerView;
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f180p0.setLayoutManager(new LinearLayoutManager(G()));
        r3.e(this.f180p0);
        r3.a(this.f180p0);
        this.f181q0 = new t5.f(Collections.EMPTY_LIST);
        final a0 a0Var = this.f179o0;
        Objects.requireNonNull(a0Var);
        final v0 v0Var = new v0(new v0.a() { // from class: a8.m0
            @Override // a8.v0.a
            public final void a(String str) {
                a0Var.Y(str);
            }
        });
        v0Var.j(new t5.g() { // from class: a8.n0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f161a.f179o0.T(((t0) obj).a().b());
            }
        });
        this.f181q0.K(t0.class, v0Var);
        this.f180p0.setAdapter(this.f181q0);
        this.f179o0.I().g(b1(), new androidx.lifecycle.o() { // from class: a8.o0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                s0.e3(this.f166a, (Integer) obj);
            }
        });
        ((autodispose2.n) s8.c.a(this.f187w0).L(s8.b.a(b1()))).a(new u6.f() { // from class: a8.p0
            @Override // u6.f
            public final void accept(Object obj) {
                this.f171c.f179o0.B(((CharSequence) obj).toString());
            }
        }, new w7.e0());
        this.f179o0.D().g(b1(), new androidx.lifecycle.o() { // from class: a8.q0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                s0.V2(this.f173a, v0Var, (List) obj);
            }
        });
    }

    public final void i3() {
        x8.f.e(this.f184t0);
        String string = this.f185u0.getText().toString();
        if (string.isEmpty()) {
            com.tuyafeng.support.utils.x.Y(this.f185u0);
            com.tuyafeng.support.utils.n.i(this.f185u0);
        } else {
            this.f179o0.z(string);
            this.f185u0.setText("");
            j3();
        }
    }

    public final void j3() {
        y.r.c(this.f184t0).c(0.0f).d(80L).f();
        y.r.c(this.f183s0).a(0.0f).d(150L).e(v8.h.b()).i(new Runnable() { // from class: a8.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f176c.f183s0.setVisibility(8);
            }
        }).f();
        y.r.c(this.f180p0).h(-com.tuyafeng.support.utils.f.d(G(), w7.n.E)).e(v8.h.b()).d(150L).i(new Runnable() { // from class: a8.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f137c.f180p0.setTranslationY(0.0f);
            }
        }).f();
    }

    public final boolean k3() {
        return this.f183s0.getVisibility() == 0;
    }

    public final void n3() {
        this.f183s0.setAlpha(0.0f);
        this.f183s0.setVisibility(0);
        this.f180p0.setTranslationY(-com.tuyafeng.support.utils.f.d(G(), w7.n.E));
        y.r.c(this.f184t0).c(45.0f).d(80L).f();
        y.r.c(this.f183s0).a(1.0f).d(150L).e(v8.h.b()).f();
        y.r.c(this.f180p0).h(0.0f).e(v8.h.b()).d(150L).f();
    }

    public final void o3() {
        if (l3()) {
            m3(false);
        } else if (this.f183s0.getVisibility() == 8) {
            n3();
        } else {
            j3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f179o0 = (a0) new androidx.lifecycle.a0(z2(), la.s.n()).a(a0.class);
    }
}
