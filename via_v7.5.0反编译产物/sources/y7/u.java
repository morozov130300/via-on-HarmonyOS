package y7;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import x8.c1;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public EditText f14924r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public String f14925s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public u4.a f14926t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public String f14927u0 = "";

    public static /* synthetic */ void a3(u uVar, final Runnable runnable, x.d dVar) {
        uVar.getClass();
        Object obj = dVar.f14456b;
        if (obj != null && !((List) obj).isEmpty()) {
            q5.k.l(uVar.G()).f0(w7.u.Ag).K(TextUtils.join("\n", (Iterable) dVar.f14456b)).u(false).v(false).X(R.string.ok, new q5.k.m() { // from class: y7.k
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    u.g3(runnable, view, pVar);
                }
            }).h0();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ s5.a b3(u uVar) {
        uVar.getClass();
        return s5.a.f(c1.O(new File(uVar.f14925s0)));
    }

    public static /* synthetic */ void c3(u uVar, s5.a aVar) {
        uVar.getClass();
        if (!aVar.d()) {
            uVar.f14927u0 = "";
            return;
        }
        String str = (String) aVar.b();
        uVar.f14927u0 = x8.v0.d(str);
        uVar.f14924r0.setText(str);
    }

    public static /* synthetic */ x.d e3(u uVar, String str) {
        if (!uVar.f14926t0.p(str)) {
            return new x.d(Boolean.FALSE, null);
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split("\n")) {
            if (!str2.isEmpty() && str2.charAt(0) != '!' && b5.c.v(str2) == null) {
                arrayList.add(str2);
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.add(0, uVar.G().getString(w7.u.V5));
        }
        return new x.d(Boolean.TRUE, arrayList);
    }

    public static /* synthetic */ void g3(Runnable runnable, View view, q5.k.p pVar) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ void h3(u uVar, ScrollView scrollView) {
        r3.k(uVar.f14924r0);
        r3.i(scrollView);
    }

    public static /* synthetic */ void l3(final u uVar, View view) {
        uVar.getClass();
        uVar.t3(new Runnable() { // from class: y7.j
            @Override // java.lang.Runnable
            public final void run() {
                x8.z.O(this.f14890c.G(), "https://help.eyeo.com/en/adblockplus/how-to-write-filters");
            }
        });
    }

    public static /* synthetic */ void m3(u uVar, EditText editText) {
        uVar.getClass();
        v8.g.h(editText);
        editText.setInputType(655361);
        editText.setTextSize(0, v8.h.q(uVar.G()));
        editText.setGravity(48);
        editText.setTypeface(Typeface.MONOSPACE);
        editText.setHint(w7.u.f14172o9);
        r3.p(editText, false);
    }

    public static /* synthetic */ void n3(r5.b bVar) {
        bVar.setFillViewport(true);
        r3.g(bVar);
    }

    private void s3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y7.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return u.b3(this.f14910c);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y7.r
            @Override // u6.f
            public final void accept(Object obj) {
                u.c3(this.f14912c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        EditText editText = this.f14924r0;
        if (editText != null) {
            x8.f.e(editText);
        }
        super.M1();
    }

    @Override // m8.g
    public void T2() {
        t3(new n(this));
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f14925s0 = this.f14926t0.d();
        s3();
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        final ScrollView scrollView = (ScrollView) new b6.a(new r5.b(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: y7.f
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u.n3((r5.b) obj);
            }
        }).l();
        EditText editText = (EditText) new b6.a(new EditText(G()), new FrameLayout.LayoutParams(-1, -2)).T(1, 16).N(1, 12).f(0).V(new b6.a.InterfaceC0033a() { // from class: y7.l
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u.m3(this.f14896a, (EditText) obj);
            }
        }).l();
        this.f14924r0 = editText;
        scrollView.addView(editText);
        X2(new Runnable() { // from class: y7.m
            @Override // java.lang.Runnable
            public final void run() {
                u.h3(this.f14898c, scrollView);
            }
        });
        return scrollView;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.X2);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.f14183p6)), new View.OnClickListener() { // from class: y7.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14906a.r3();
            }
        });
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.f13967a0)), new View.OnClickListener() { // from class: y7.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14908a.v3();
            }
        });
    }

    @Override // m8.g
    public boolean l() {
        return q3();
    }

    public final void p3() {
        super.T2();
    }

    public final boolean q3() {
        return x8.v0.d(this.f14924r0.getText().toString()).equals(this.f14927u0);
    }

    public final void r3() {
        q5.k.l(G()).f0(w7.u.f14183p6).J(w7.u.Vc).X(R.string.ok, null).T(w7.u.L7, new View.OnClickListener() { // from class: y7.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.l3(this.f14914a, view);
            }
        }).h0();
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).h(this);
    }

    public final void t3(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (q3()) {
            runnable.run();
        } else {
            q5.k.l(G()).f0(w7.u.I3).J(w7.u.G8).X(w7.u.Ib, new q5.k.m() { // from class: y7.t
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f14916a.u3(runnable);
                }
            }).P(w7.u.f13972a5, new View.OnClickListener() { // from class: y7.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    runnable.run();
                }
            }).h0();
        }
    }

    public final void u3(final Runnable runnable) {
        final String string = this.f14924r0.getText().toString();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y7.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return u.e3(this.f14884c, string);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y7.i
            @Override // u6.f
            public final void accept(Object obj) {
                u.a3(this.f14887c, runnable, (x.d) obj);
            }
        }, new w7.e0());
    }

    public final void v3() {
        if (q3()) {
            p3();
        } else {
            u3(new n(this));
        }
    }
}
