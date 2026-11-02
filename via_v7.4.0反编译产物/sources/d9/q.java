package d9;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tuyafeng.support.widget.z;
import e9.v;
import g6.y;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import mark.via.common.widget.o0;
import x7.c0;
import x7.u;
import z8.l3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public t f4620o0;

    /* renamed from: p0, reason: collision with root package name */
    public w9.l f4621p0;

    /* renamed from: q0, reason: collision with root package name */
    public FrameLayout f4622q0;

    /* renamed from: r0, reason: collision with root package name */
    public FrameLayout f4623r0;

    /* renamed from: s0, reason: collision with root package name */
    public RadioGroup f4624s0;

    /* renamed from: u0, reason: collision with root package name */
    public WebView f4626u0;

    /* renamed from: y0, reason: collision with root package name */
    public int[] f4630y0;

    /* renamed from: t0, reason: collision with root package name */
    public int f4625t0 = -1;

    /* renamed from: v0, reason: collision with root package name */
    public final int f4627v0 = -14540254;

    /* renamed from: w0, reason: collision with root package name */
    public Drawable f4628w0 = null;

    /* renamed from: x0, reason: collision with root package name */
    public int f4629x0 = -1;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            if (q.this.f4625t0 == view.getId()) {
                q.this.z3(-1);
                q.this.f4624s0.clearCheck();
            } else {
                q.this.z3(view.getId());
                q.this.f4624s0.check(view.getId());
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends v5.c {
        public b() {
        }

        @Override // v5.c
        public void a(View view) {
            View viewC1 = q.this.c1();
            if (viewC1 != null) {
                final View viewFindViewById = viewC1.findViewById(x7.p.f13826n0);
                x.r.c(viewFindViewById).a(0.0f).h(-100.0f).d(240L).i(new Runnable() { // from class: d9.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewFindViewById.setVisibility(8);
                    }
                }).f();
            }
            q.this.f4621p0.x1("about:home");
            w9.n.e().y(true);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest.getUrl().toString().endsWith("homepage.css")) {
                return q.this.u3();
            }
            return null;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str != null && str.endsWith("homepage.css")) {
                return q.this.u3();
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends ViewOutlineProvider {
        public d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), g6.f.d(q.this.I(), x7.n.f13697p));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A3() {
        WebView webView = this.f4626u0;
        if (webView == null || webView.getParent() == null) {
            return;
        }
        final String strC = this.f4621p0.c();
        File file = (strC == null || strC.isEmpty()) ? null : new File(strC);
        if (file == null || !file.exists()) {
            int iC0 = this.f4621p0.c0();
            if (iC0 == -1) {
                iC0 = g6.e.a(I(), x7.k.f13656b);
            }
            this.f4628w0 = new ColorDrawable(iC0);
            this.f4629x0 = -1;
            B3();
            return;
        }
        final String strB = j9.a.b(I());
        final boolean zExists = new File(strB).exists();
        final int iS = y.s(I());
        final int iQ = y.q(I());
        ((autodispose2.m) x6.f.h(new Callable() { // from class: d9.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q.d3(this.f4604e, zExists, strB, strC, iS, iQ);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: d9.g
            @Override // a7.e
            public final void accept(Object obj) {
                q.c3(this.f4610e, (o0) obj);
            }
        }, new c0());
        if (zExists) {
            return;
        }
        z8.h.b(new Runnable() { // from class: d9.h
            @Override // java.lang.Runnable
            public final void run() {
                j9.a.c(this.f4611e.I(), strC);
            }
        });
    }

    public static /* synthetic */ void b3(q qVar) {
        y.O(qVar.f4624s0, new g6.g().h(g6.e.a(qVar.I(), x7.k.f13657c)).d(x8.h.e(qVar.I()), 0.0f).a());
        qVar.f4623r0.setVisibility(8);
    }

    public static /* synthetic */ void c3(q qVar, o0 o0Var) {
        qVar.f4628w0 = o0Var;
        qVar.f4629x0 = -1;
        qVar.B3();
    }

    public static /* synthetic */ o0 d3(q qVar, boolean z10, String str, String str2, int i10, int i11) {
        qVar.getClass();
        Bitmap bitmapDecodeFile = z10 ? BitmapFactory.decodeFile(str) : z8.i.c(str2, i10, i11);
        if (bitmapDecodeFile != null) {
            return new o0(qVar.T0(), bitmapDecodeFile);
        }
        return null;
    }

    public static /* synthetic */ void h3(q qVar) {
        qVar.getClass();
        y.O(qVar.f4624s0, new g6.g().h(g6.e.a(qVar.I(), x7.k.f13657c)).a());
    }

    public static /* synthetic */ boolean l3(View view, MotionEvent motionEvent) {
        return true;
    }

    private void x3() {
        l3.k(I(), this.f4630y0);
    }

    private void y3() {
        this.f4630y0 = l3.l(I());
    }

    public final void B3() {
        WebView webView = this.f4626u0;
        if (webView == null) {
            return;
        }
        if (this.f4628w0 == null) {
            x.r.Z(webView, new ColorDrawable(g6.e.a(I(), x7.k.f13656b)));
            return;
        }
        int i10 = y.C(this.f4621p0.c0()) ? 128 : 64;
        if (!this.f4621p0.d()) {
            i10 = 0;
        }
        int iMax = Math.max(i10, (int) ((this.f4620o0.k().b() / 100.0f) * 255.0f));
        if (this.f4629x0 == iMax) {
            return;
        }
        this.f4629x0 = iMax;
        x.r.Z(this.f4626u0, new LayerDrawable(new Drawable[]{this.f4628w0, new ColorDrawable(Color.argb(iMax, 0, 0, 0))}));
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        w9.n.e().w(true);
        this.f4622q0.removeAllViews();
        s4.b.a(this.f4626u0);
        this.f4626u0 = null;
        super.D1();
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() {
        super.F1();
        x3();
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        WebView webView = this.f4626u0;
        if (webView != null) {
            webView.onPause();
        }
        super.O1();
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void T1() {
        WebView webView = this.f4626u0;
        if (webView != null) {
            webView.onResume();
        }
        super.T1();
    }

    @Override // o8.h
    public void U2() {
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        y3();
        l3.r(I(), -14540254);
        l3.q(I(), g6.e.a(I(), x7.k.f13657c));
        y.O(this.f10460m0, new ColorDrawable(-14540254));
        this.f4622q0 = (FrameLayout) view.findViewById(x7.p.E);
        this.f4623r0 = (FrameLayout) view.findViewById(x7.p.F);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(x7.p.f13859y0);
        this.f4624s0 = radioGroup;
        radioGroup.check(this.f4625t0);
        this.f4624s0.setClipToPadding(true);
        l3.c(this.f10460m0, null, this.f4624s0);
        Drawable drawableA = new g6.g().h(g6.e.a(I(), x7.k.f13657c)).d(x8.h.e(I()), 0.0f).a();
        y.O(this.f4624s0, drawableA);
        y.O(this.f4623r0, drawableA);
        int childCount = this.f4624s0.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RadioButton radioButton = (RadioButton) this.f4624s0.getChildAt(i10);
            x8.g.d(radioButton);
            radioButton.setOnClickListener(new a());
        }
        v3();
        ((autodispose2.n) r8.d.d(I()).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: d9.i
            @Override // a7.e
            public final void accept(Object obj) {
                this.f4613e.f4626u0.loadUrl((String) obj);
            }
        }, new c0());
        this.f4620o0.f4637e.g(d1(), new androidx.lifecycle.m() { // from class: d9.j
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f4614a.w3();
            }
        });
        this.f4620o0.f4639g.g(d1(), new androidx.lifecycle.m() { // from class: d9.k
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f4615a.A3();
            }
        });
        this.f4620o0.f4641i.g(d1(), new androidx.lifecycle.m() { // from class: d9.l
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f4616a.f4626u0.clearCache(false);
            }
        });
        this.f4620o0.f4643k.g(d1(), new androidx.lifecycle.m() { // from class: d9.m
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f4617a.z3(-1);
            }
        });
        this.f4626u0.post(new Runnable() { // from class: d9.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f4618e.A3();
            }
        });
        if ("about:home".equals(this.f4621p0.n())) {
            view.findViewById(x7.p.f13826n0).setVisibility(8);
        } else {
            view.findViewById(x7.p.f13826n0).setVisibility(0);
            view.findViewById(x7.p.f13860y1).setOnClickListener(new b());
        }
    }

    @Override // o8.h
    public boolean Y2() {
        return false;
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(x7.r.f13881p, viewGroup, false);
    }

    @Override // o8.h
    public void a3(z zVar) {
        super.a3(zVar);
        v3.a(zVar, u.vc);
        zVar.setBackgroundColor(-14540254);
        zVar.setContentColor(-1);
    }

    public final WebResourceResponse u3() {
        WebResourceResponse webResourceResponse = null;
        try {
            WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/css", "UTF-8", new BufferedInputStream(new FileInputStream(new File(I().getFilesDir(), "homepage.css").getAbsolutePath())));
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    return webResourceResponse2;
                }
                HashMap map = new HashMap();
                map.put("Cache-Control", "no-cache");
                map.put("Access-Control-Allow-Origin", "*");
                map.put("Content-Type", "text/css");
                webResourceResponse2.setResponseHeaders(map);
                return webResourceResponse2;
            } catch (FileNotFoundException e10) {
                e = e10;
                webResourceResponse = webResourceResponse2;
                e.printStackTrace();
                return webResourceResponse;
            }
        } catch (FileNotFoundException e11) {
            e = e11;
        }
    }

    public final void v3() {
        WebView webView = new WebView(I());
        this.f4626u0 = webView;
        this.f4622q0.addView(webView);
        this.f4626u0.setOnTouchListener(new View.OnTouchListener() { // from class: d9.o
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return q.l3(view, motionEvent);
            }
        });
        this.f4626u0.setHorizontalScrollBarEnabled(false);
        this.f4626u0.setVerticalScrollBarEnabled(false);
        this.f4626u0.setBackgroundColor(0);
        this.f4626u0.setScaleX(0.95f);
        this.f4626u0.setScaleY(0.95f);
        this.f4626u0.setClickable(false);
        this.f4626u0.setFocusable(false);
        WebSettings settings = this.f4626u0.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        int i10 = Build.VERSION.SDK_INT;
        settings.setAllowFileAccessFromFileURLs(true);
        this.f4626u0.setWebViewClient(new c());
        if (i10 >= 21) {
            this.f4626u0.setOutlineProvider(new d());
            this.f4626u0.setClipToOutline(true);
        }
    }

    public final void w3() {
        B3();
        ((autodispose2.n) r8.d.d(I()).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: d9.p
            @Override // a7.e
            public final void accept(Object obj) {
                this.f4619e.f4626u0.reload();
            }
        }, new c0());
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f4620o0 = (t) new androidx.lifecycle.y(this).a(t.class);
        this.f4621p0 = pa.r.j();
        w9.n.e().w(true).v(true);
    }

    public final void z3(int i10) {
        if (i10 == -1) {
            if (this.f4623r0.getVisibility() == 0) {
                x.r.c(this.f4623r0).h(this.f4623r0.getHeight()).i(new Runnable() { // from class: d9.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.b3(this.f4601e);
                    }
                }).d(200L).e(x8.h.b()).f();
            }
            this.f4625t0 = i10;
            return;
        }
        if (this.f4623r0.getVisibility() == 8) {
            x.r.c(this.f4623r0).h(0.0f).j(new Runnable() { // from class: d9.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4602e.f4623r0.setVisibility(0);
                }
            }).i(new Runnable() { // from class: d9.e
                @Override // java.lang.Runnable
                public final void run() {
                    q.h3(this.f4603e);
                }
            }).d(200L).e(x8.h.b()).f();
        }
        Class cls = i10 == x7.p.f13853w0 ? e9.u.class : i10 == x7.p.f13847u0 ? e9.i.class : i10 == x7.p.f13850v0 ? e9.l.class : i10 == x7.p.f13856x0 ? v.class : i10 == x7.p.f13844t0 ? e9.y.class : null;
        if (cls == null) {
            return;
        }
        this.f4625t0 = i10;
        z0().q().u(x7.p.F, cls, null, null).i();
    }
}
