package oa;

import android.R;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import c6.a2;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import mark.via.browser.kd;
import org.simpleframework.xml.strategy.Name;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public qa.c f11041r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public com.tuyafeng.support.widget.d0 f11042s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ScrollView f11043t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f11044u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f11045v0 = -1;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f11046w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public com.tuyafeng.support.widget.b0 f11047x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public String f11048y0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            q5.k.l(q.this.G()).f0(w7.u.f14183p6).K(Html.fromHtml(q.this.X0(w7.u.Wc))).X(R.string.ok, null).T(w7.u.L7, new View.OnClickListener() { // from class: oa.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    q.a aVar = this.f11035a;
                    q.this.u3(new Runnable() { // from class: oa.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            x8.z.O(q.this.G(), "https://www.tampermonkey.net/documentation.php");
                        }
                    });
                }
            }).h0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends p5.c {
        public b() {
        }

        @Override // p5.c
        public void a(View view) {
            q.this.w3();
        }
    }

    public static /* synthetic */ Integer b3(q qVar, ra.c cVar, ra.a aVar) {
        int iA;
        if (cVar != null) {
            qVar.getClass();
            aVar.f(cVar.j());
            iA = qVar.f11041r0.p(cVar.e(), aVar) ? cVar.e() : 0;
        } else {
            iA = qVar.f11041r0.a(aVar);
        }
        return Integer.valueOf(iA);
    }

    public static /* synthetic */ void d3(final q qVar, String str) {
        qVar.getClass();
        qVar.f11048y0 = x8.v0.d(str);
        final WeakReference weakReference = new WeakReference(qVar.f11044u0);
        v8.g.g(qVar.f11044u0, str, new Runnable() { // from class: oa.l
            @Override // java.lang.Runnable
            public final void run() {
                q.h3(this.f11027c, weakReference);
            }
        });
    }

    public static /* synthetic */ void e3(ProgressBar progressBar) {
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(1);
    }

    public static /* synthetic */ void f3(r5.b bVar) {
        bVar.setFillViewport(true);
        r3.g(bVar);
    }

    public static /* synthetic */ void g3(q qVar, ProgressBar progressBar) {
        r3.k(qVar.f11044u0);
        r3.i(qVar.f11043t0);
        progressBar.setProgressDrawable(v8.h.w(qVar.G()));
    }

    public static /* synthetic */ void h3(q qVar, Reference reference) {
        qVar.getClass();
        TextView textView = (TextView) reference.get();
        if (textView == null) {
            return;
        }
        qVar.f11047x0.f(100);
        textView.setAlpha(1.0f);
        textView.setEnabled(true);
    }

    public static /* synthetic */ void j3(q qVar, View view, q5.k.p pVar) {
        qVar.f11044u0.getText().replace(0, 0, "// ==UserScript==\n// @name         New Userscript\n// @namespace    https://viayoo.com/\n// @version      0.1\n// @description  try to take over the world!\n// @author       You\n// @run-at       document-end\n// @match        https://*/*\n// @grant        none\n// ==/UserScript==\n\n");
        qVar.f11044u0.clearFocus();
        qVar.f11043t0.scrollTo(0, 0);
        com.tuyafeng.support.utils.x.j(qVar.f11043t0, true);
    }

    public static /* synthetic */ void k3(q qVar, Runnable runnable, Integer num) {
        qVar.getClass();
        if (num.intValue() == 0) {
            return;
        }
        qVar.f11045v0 = num.intValue();
        qVar.L0().y1("script_result_v2", p5.a.b().d(Name.MARK, qVar.f11045v0).a());
        if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ void m3(q qVar, EditText editText) {
        qVar.getClass();
        v8.g.h(editText);
        editText.setInputType(655361);
        editText.setTextSize(0, v8.h.q(qVar.G()));
        editText.setGravity(51);
        editText.setTypeface(Typeface.MONOSPACE);
        editText.setHint(qVar.X0(w7.u.Tb));
        r3.p(editText, false);
    }

    public static Bundle p3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    public static Bundle q3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3() {
        super.T2();
    }

    private boolean s3() {
        if (!this.f11044u0.isEnabled()) {
            return true;
        }
        String string = this.f11044u0.getText().toString();
        return string.isEmpty() || x8.v0.d(string).equals(this.f11048y0);
    }

    private void t3() {
        tc.a.a("load script code for %d", Integer.valueOf(this.f11045v0));
        this.f11044u0.setEnabled(false);
        this.f11044u0.setAlpha(0.25f);
        this.f11047x0.f(30);
        ((autodispose2.m) r6.f.h(new Callable() { // from class: oa.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q qVar = this.f11021c;
                return qVar.f11041r0.f(qVar.f11045v0);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: oa.k
            @Override // u6.f
            public final void accept(Object obj) {
                q.d3(this.f11025c, (String) obj);
            }
        }, new w7.a0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (s3()) {
            runnable.run();
        } else {
            q5.k.l(G()).f0(w7.u.I3).J(w7.u.G8).X(w7.u.Ib, new q5.k.m() { // from class: oa.m
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f11030a.v3(runnable);
                }
            }).P(w7.u.f13972a5, new View.OnClickListener() { // from class: oa.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    runnable.run();
                }
            }).h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(final Runnable runnable) {
        if (!this.f11044u0.isEnabled()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        String string = this.f11044u0.getText().toString();
        final ra.c cVarK = this.f11041r0.k(this.f11045v0);
        final ra.a aVarE = ra.a.e(string, cVarK == null ? null : cVarK.b());
        if (aVarE == null) {
            q5.k.l(G()).f0(w7.u.cg).J(w7.u.f14031e8).X(R.string.ok, new q5.k.m() { // from class: oa.c
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    q.j3(this.f10987a, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        } else {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: oa.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return q.b3(this.f10990c, cVarK, aVarE);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: oa.e
                @Override // u6.f
                public final void accept(Object obj) {
                    q.k3(this.f10995c, runnable, (Integer) obj);
                }
            }, new w7.e0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3() {
        if (!this.f11044u0.isEnabled() && s3()) {
            r3();
        }
        v3(new i(this));
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        EditText editText = this.f11044u0;
        if (editText != null) {
            x8.f.e(editText);
        }
        super.M1();
    }

    @Override // m8.g
    public void T2() {
        u3(new i(this));
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f11042s0 = (com.tuyafeng.support.widget.d0) view.findViewById(com.tuyafeng.support.utils.x.f3593a);
        x3(true);
        int i10 = w0() != null ? w0().getInt(Name.MARK, -1) : -1;
        this.f11045v0 = i10;
        if (i10 > 0) {
            this.f11046w0.setTitle(X0(w7.u.E));
            t3();
            return;
        }
        this.f11046w0.setTitle(X0(w7.u.f14286x0));
        String string = w0() == null ? null : w0().getString("url");
        String strReplace = (a2.f1958a.t(string) ? "// ==UserScript==\n// @name         New Userscript\n// @namespace    https://viayoo.com/\n// @version      0.1\n// @description  try to take over the world!\n// @author       You\n// @run-at       document-end\n// @match        https://*/*\n// @grant        none\n// ==/UserScript==\n\n(function() {\n    'use strict';\n\n    // Your code here...\n})();".replace("https://*/*", string) : "// ==UserScript==\n// @name         New Userscript\n// @namespace    https://viayoo.com/\n// @version      0.1\n// @description  try to take over the world!\n// @author       You\n// @run-at       document-end\n// @match        https://*/*\n// @grant        none\n// ==/UserScript==\n\n(function() {\n    'use strict';\n\n    // Your code here...\n})();").replace("https://viayoo.com/", "https://viayoo.com/" + com.tuyafeng.support.utils.p.b(6));
        this.f11044u0.setText(strReplace);
        this.f11048y0 = x8.v0.d(strReplace);
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f11043t0 = (ScrollView) new b6.a(new r5.b(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: oa.b
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q.f3((r5.b) obj);
            }
        }).l();
        this.f11044u0 = (EditText) new b6.a(new EditText(G()), new FrameLayout.LayoutParams(-1, -2)).T(1, 16).N(1, 12).f(0).V(new b6.a.InterfaceC0033a() { // from class: oa.f
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q.m3(this.f10999a, (EditText) obj);
            }
        }).l();
        final ProgressBar progressBar = (ProgressBar) new b6.a(new ProgressBar(G(), null, R.attr.progressBarStyleHorizontal), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.x.h(G(), 3.0f))).V(new b6.a.InterfaceC0033a() { // from class: oa.g
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q.e3((ProgressBar) obj);
            }
        }).l();
        this.f11047x0 = new com.tuyafeng.support.widget.b0(progressBar);
        this.f11043t0.addView(this.f11044u0);
        frameLayout.addView(this.f11043t0);
        frameLayout.addView(progressBar);
        X2(new Runnable() { // from class: oa.h
            @Override // java.lang.Runnable
            public final void run() {
                q.g3(this.f11010c, progressBar);
            }
        });
        return frameLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.E);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 0, null, X0(w7.u.f14183p6)), new a());
        e0Var.c(new com.tuyafeng.support.widget.e0.b(0, 0, null, X0(w7.u.f13967a0)), new b());
        this.f11046w0 = e0Var;
    }

    @Override // m8.g
    public boolean l() {
        return s3();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f11041r0 = kd.c().f();
    }

    public final void x3(boolean z10) {
        this.f11042s0.setGestureEnabled(!z10);
        this.f11044u0.setFocusable(z10);
        if (z10) {
            return;
        }
        x8.f.e(this.f11044u0);
    }
}
