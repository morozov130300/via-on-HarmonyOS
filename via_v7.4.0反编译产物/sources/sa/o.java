package sa;

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
import c8.lc;
import com.tuyafeng.support.widget.z;
import h6.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import sa.o;
import w5.k;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public p5.c f11929o0;

    /* renamed from: p0, reason: collision with root package name */
    public com.tuyafeng.support.widget.y f11930p0;

    /* renamed from: q0, reason: collision with root package name */
    public ScrollView f11931q0;

    /* renamed from: r0, reason: collision with root package name */
    public EditText f11932r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f11933s0 = -1;

    /* renamed from: t0, reason: collision with root package name */
    public com.tuyafeng.support.widget.z f11934t0;

    /* renamed from: u0, reason: collision with root package name */
    public com.tuyafeng.support.widget.w f11935u0;

    /* renamed from: v0, reason: collision with root package name */
    public String f11936v0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            w5.k.l(o.this.I()).d0(x7.u.f13949d6).J(Html.fromHtml(o.this.Z0(x7.u.Hc))).V(R.string.ok, null).R(x7.u.f14249z7, new View.OnClickListener() { // from class: sa.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o.a aVar = this.f11919a;
                    o.this.u3(new Runnable() { // from class: sa.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            z8.b0.P(o.this.I(), "https://www.tampermonkey.net/documentation.php");
                        }
                    });
                }
            }).f0();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends v5.c {
        public b() {
        }

        @Override // v5.c
        public void a(View view) {
            o.this.w3();
        }
    }

    public static /* synthetic */ void b3(o oVar, Runnable runnable, Integer num) {
        oVar.getClass();
        if (num.intValue() == 0) {
            return;
        }
        oVar.f11933s0 = num.intValue();
        oVar.N0().x1("script_result_v2", v5.a.b().d(Name.MARK, oVar.f11933s0).a());
        if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ void c3(ProgressBar progressBar) {
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(x8.h.x(progressBar.getContext()));
        progressBar.setMax(100);
        progressBar.setProgress(1);
    }

    public static /* synthetic */ Integer d3(o oVar, r5.c cVar, r5.a aVar) {
        int iH;
        if (cVar != null) {
            oVar.getClass();
            aVar.g(cVar.j());
            iH = oVar.f11929o0.p(cVar.e(), aVar) ? cVar.e() : 0;
        } else {
            iH = oVar.f11929o0.h(aVar);
        }
        return Integer.valueOf(iH);
    }

    public static /* synthetic */ void e3(o oVar, View view, k.p pVar) {
        oVar.f11932r0.getText().replace(0, 0, "// ==UserScript==\n// @name         New Userscript\n// @namespace    https://viayoo.com/\n// @version      0.1\n// @description  try to take over the world!\n// @author       You\n// @run-at       document-end\n// @match        https://*/*\n// @grant        none\n// ==/UserScript==\n\n");
        oVar.f11932r0.clearFocus();
        oVar.f11931q0.scrollTo(0, 0);
        g6.y.j(oVar.f11931q0, true);
    }

    public static /* synthetic */ void g3(o oVar, Reference reference) {
        oVar.getClass();
        TextView textView = (TextView) reference.get();
        if (textView == null) {
            return;
        }
        oVar.f11935u0.f(100);
        textView.setAlpha(1.0f);
        textView.setEnabled(true);
    }

    public static /* synthetic */ void h3(q4.b bVar) {
        bVar.setFillViewport(true);
        r3.f(bVar);
        r3.h(bVar);
    }

    public static /* synthetic */ void l3(o oVar, EditText editText) {
        oVar.getClass();
        x8.g.h(editText);
        editText.setInputType(655361);
        editText.setTextColor(g6.e.a(oVar.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(oVar.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(oVar.I()));
        editText.setGravity(51);
        editText.setTypeface(Typeface.MONOSPACE);
        editText.setHint(oVar.Z0(x7.u.Gb));
        r3.o(editText, false);
    }

    public static /* synthetic */ void m3(final o oVar, String str) {
        oVar.getClass();
        oVar.f11936v0 = z8.v0.d(str);
        final WeakReference weakReference = new WeakReference(oVar.f11932r0);
        x8.g.g(oVar.f11932r0, str, new Runnable() { // from class: sa.i
            @Override // java.lang.Runnable
            public final void run() {
                o.g3(this.f11906e, weakReference);
            }
        });
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
        super.V2();
    }

    private boolean s3() {
        if (!this.f11932r0.isEnabled()) {
            return true;
        }
        String string = this.f11932r0.getText().toString();
        return string.isEmpty() || z8.v0.d(string).equals(this.f11936v0);
    }

    private void t3() {
        pc.a.a("load script code for %d", Integer.valueOf(this.f11933s0));
        this.f11932r0.setEnabled(false);
        this.f11932r0.setAlpha(0.25f);
        this.f11935u0.f(30);
        ((autodispose2.m) x6.f.h(new Callable() { // from class: sa.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                o oVar = this.f11898e;
                return oVar.f11929o0.g(oVar.f11933s0);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: sa.h
            @Override // a7.e
            public final void accept(Object obj) {
                o.m3(this.f11903e, (String) obj);
            }
        }, new x7.c0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (s3()) {
            runnable.run();
        } else {
            w5.k.l(I()).d0(x7.u.f14193v3).I(x7.u.f14185u8).V(x7.u.f14201vb, new k.m() { // from class: sa.j
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    this.f11912a.v3(runnable);
                }
            }).N(x7.u.N4, new View.OnClickListener() { // from class: sa.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    runnable.run();
                }
            }).f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(final Runnable runnable) {
        if (!this.f11932r0.isEnabled()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        String string = this.f11932r0.getText().toString();
        final r5.c cVarK = this.f11929o0.k(this.f11933s0);
        final r5.a aVarF = r5.a.f(string, cVarK == null ? null : cVarK.b());
        if (aVarF == null) {
            w5.k.l(I()).d0(x7.u.Mf).I(x7.u.S7).V(R.string.ok, new k.m() { // from class: sa.l
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    o.e3(this.f11917a, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
        } else {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: sa.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return o.d3(this.f11872e, cVarK, aVarF);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: sa.c
                @Override // a7.e
                public final void accept(Object obj) {
                    o.b3(this.f11877e, runnable, (Integer) obj);
                }
            }, new x7.g0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3() {
        if (!this.f11932r0.isEnabled() && s3()) {
            r3();
        }
        v3(new f(this));
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        EditText editText = this.f11932r0;
        if (editText != null) {
            z8.f.e(editText);
        }
        super.O1();
    }

    @Override // o8.h
    public void V2() {
        u3(new f(this));
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f11930p0 = (com.tuyafeng.support.widget.y) view.findViewById(g6.y.f6242a);
        x3(true);
        int i10 = y0() != null ? y0().getInt(Name.MARK, -1) : -1;
        this.f11933s0 = i10;
        if (i10 > 0) {
            this.f11934t0.setTitle(Z0(x7.u.D));
            t3();
            return;
        }
        this.f11934t0.setTitle(Z0(x7.u.f14190v0));
        String string = y0() == null ? null : y0().getString("url");
        String strReplace = (i6.i0.f7006a.s(string) ? "// ==UserScript==\n// @name         New Userscript\n// @namespace    https://viayoo.com/\n// @version      0.1\n// @description  try to take over the world!\n// @author       You\n// @run-at       document-end\n// @match        https://*/*\n// @grant        none\n// ==/UserScript==\n\n(function() {\n    'use strict';\n\n    // Your code here...\n})();".replace("https://*/*", string) : "// ==UserScript==\n// @name         New Userscript\n// @namespace    https://viayoo.com/\n// @version      0.1\n// @description  try to take over the world!\n// @author       You\n// @run-at       document-end\n// @match        https://*/*\n// @grant        none\n// ==/UserScript==\n\n(function() {\n    'use strict';\n\n    // Your code here...\n})();").replace("https://viayoo.com/", "https://viayoo.com/" + g6.p.b(6));
        this.f11932r0.setText(strReplace);
        this.f11936v0 = z8.v0.d(strReplace);
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f11931q0 = (ScrollView) new h6.a(new q4.b(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: sa.a
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.h3((q4.b) obj);
            }
        }).l();
        this.f11932r0 = (EditText) new h6.a(new EditText(I()), new FrameLayout.LayoutParams(-1, -2)).T(1, 16).N(1, 12).f(0).V(new a.InterfaceC0076a() { // from class: sa.d
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.l3(this.f11881a, (EditText) obj);
            }
        }).l();
        ProgressBar progressBar = (ProgressBar) new h6.a(new ProgressBar(I(), null, R.attr.progressBarStyleHorizontal), new FrameLayout.LayoutParams(-1, g6.y.h(I(), 3.0f))).V(new a.InterfaceC0076a() { // from class: sa.e
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.c3((ProgressBar) obj);
            }
        }).l();
        this.f11935u0 = new com.tuyafeng.support.widget.w(progressBar);
        this.f11931q0.addView(this.f11932r0);
        frameLayout.addView(this.f11931q0);
        frameLayout.addView(progressBar);
        return frameLayout;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.D);
        zVar.c(new z.b(1, 0, null, Z0(x7.u.f13949d6)), new a());
        zVar.c(new z.b(0, 0, null, Z0(x7.u.Z)), new b());
        this.f11934t0 = zVar;
    }

    @Override // o8.h
    public boolean l() {
        return s3();
    }

    public final void x3(boolean z10) {
        this.f11930p0.setGestureEnabled(!z10);
        this.f11932r0.setFocusable(z10);
        if (z10) {
            return;
        }
        z8.f.e(this.f11932r0);
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f11929o0 = lc.c().d();
    }
}
