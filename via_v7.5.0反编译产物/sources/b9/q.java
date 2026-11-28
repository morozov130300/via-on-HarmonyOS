package b9;

import android.content.Context;
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
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.e0;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.common.widget.o0;
import mark.via.settings.search.SettingsSearchLocator;
import w7.a0;
import w7.u;
import x8.h3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q extends m8.g {
    public int[] B0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public t f1807r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public u9.l f1808s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public FrameLayout f1809t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public FrameLayout f1810u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public RadioGroup f1811v0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public WebView f1813x0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f1812w0 = -1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final int f1814y0 = -14540254;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Drawable f1815z0 = null;
    public int A0 = -1;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            if (q.this.f1812w0 == view.getId()) {
                q.this.A3(-1);
                q.this.f1811v0.clearCheck();
            } else {
                q.this.A3(view.getId());
                q.this.f1811v0.check(view.getId());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends p5.c {
        public b() {
        }

        @Override // p5.c
        public void a(View view) {
            View viewA1 = q.this.a1();
            if (viewA1 != null) {
                final View viewFindViewById = viewA1.findViewById(w7.p.f13880j0);
                y.r.c(viewFindViewById).a(0.0f).h(-100.0f).d(240L).i(new Runnable() { // from class: b9.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewFindViewById.setVisibility(8);
                    }
                }).f();
            }
            q.this.f1808s0.y1("about:home");
            u9.n.e().w(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends ViewOutlineProvider {
        public d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.tuyafeng.support.utils.f.d(q.this.G(), w7.n.f13763p));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3() {
        WebView webView = this.f1813x0;
        if (webView == null || webView.getParent() == null) {
            return;
        }
        final String strD = this.f1808s0.d();
        File file = (strD == null || strD.isEmpty()) ? null : new File(strD);
        if (file == null || !file.exists()) {
            int iF0 = this.f1808s0.f0();
            if (iF0 == -1) {
                iF0 = com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c);
            }
            this.f1815z0 = new ColorDrawable(iF0);
            this.A0 = -1;
            C3();
            return;
        }
        final String strB = h9.a.b(G());
        final boolean zExists = new File(strB).exists();
        final int iS = x.s(G());
        final int iQ = x.q(G());
        ((autodispose2.m) r6.f.h(new Callable() { // from class: b9.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q.c3(this.f1791c, zExists, strB, strD, iS, iQ);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: b9.g
            @Override // u6.f
            public final void accept(Object obj) {
                q.b3(this.f1797c, (o0) obj);
            }
        }, new a0());
        if (zExists) {
            return;
        }
        x8.h.b(new Runnable() { // from class: b9.h
            @Override // java.lang.Runnable
            public final void run() {
                h9.a.c(this.f1798c.G(), strD);
            }
        });
    }

    public static /* synthetic */ void a3(q qVar) {
        x.P(qVar.f1811v0, new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.e.a(qVar.G(), w7.k.f13724d)).d(v8.h.e(qVar.G()), 0.0f).a());
        qVar.f1810u0.setVisibility(8);
    }

    public static /* synthetic */ void b3(q qVar, o0 o0Var) {
        qVar.f1815z0 = o0Var;
        qVar.A0 = -1;
        qVar.C3();
    }

    public static /* synthetic */ o0 c3(q qVar, boolean z10, String str, String str2, int i10, int i11) {
        qVar.getClass();
        Bitmap bitmapDecodeFile = z10 ? BitmapFactory.decodeFile(str) : x8.i.c(str2, i10, i11);
        if (bitmapDecodeFile != null) {
            return new o0(qVar.R0(), bitmapDecodeFile);
        }
        return null;
    }

    public static /* synthetic */ void g3(q qVar) {
        qVar.getClass();
        x.P(qVar.f1811v0, new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.e.a(qVar.G(), w7.k.f13724d)).a());
    }

    public static /* synthetic */ boolean k3(View view, MotionEvent motionEvent) {
        return true;
    }

    public static List t3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, q.class, u.Kc);
        hVar.b(w7.p.f13907s0, u.hd, new String[0]);
        hVar.b(w7.p.f13910t0, u.id, new String[0]);
        hVar.b(w7.p.f13901q0, u.fd, new String[0]);
        hVar.b(w7.p.f13904r0, u.F, new String[0]);
        hVar.b(w7.p.f13898p0, u.Dc, new String[0]);
        return hVar.f();
    }

    private void x3() {
        h3.n(G(), this.B0);
    }

    private void y3() {
        this.B0 = h3.o(G());
    }

    public final void A3(int i10) {
        Class cls;
        if (i10 == -1) {
            if (this.f1810u0.getVisibility() == 0) {
                y.r.c(this.f1810u0).h(this.f1810u0.getHeight()).i(new Runnable() { // from class: b9.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a3(this.f1788c);
                    }
                }).d(200L).e(v8.h.b()).f();
            }
            this.f1812w0 = i10;
            return;
        }
        if (this.f1810u0.getVisibility() == 8) {
            y.r.c(this.f1810u0).h(0.0f).j(new Runnable() { // from class: b9.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1789c.f1810u0.setVisibility(0);
                }
            }).i(new Runnable() { // from class: b9.e
                @Override // java.lang.Runnable
                public final void run() {
                    q.g3(this.f1790c);
                }
            }).d(200L).e(v8.h.b()).f();
        }
        if (i10 == w7.p.f13907s0) {
            cls = c9.t.class;
        } else if (i10 == w7.p.f13901q0) {
            cls = c9.h.class;
        } else if (i10 == w7.p.f13904r0) {
            cls = c9.k.class;
        } else if (i10 == w7.p.f13910t0) {
            cls = c9.u.class;
        } else {
            cls = i10 == w7.p.f13898p0 ? c9.x.class : null;
        }
        if (cls == null) {
            return;
        }
        this.f1812w0 = i10;
        x0().q().u(w7.p.E, cls, z3(i10), null).i();
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        u9.n.e().u(true);
        this.f1809t0.removeAllViews();
        s4.b.a(this.f1813x0);
        this.f1813x0 = null;
        super.B1();
    }

    public final void C3() {
        WebView webView = this.f1813x0;
        if (webView == null) {
            return;
        }
        if (this.f1815z0 == null) {
            y.r.a0(webView, new ColorDrawable(com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c)));
            return;
        }
        int i10 = x.C(this.f1808s0.f0()) ? 128 : 64;
        if (!this.f1808s0.e()) {
            i10 = 0;
        }
        int iMax = Math.max(i10, (int) ((this.f1807r0.k().b() / 100.0f) * 255.0f));
        if (this.A0 == iMax) {
            return;
        }
        this.A0 = iMax;
        y.r.a0(this.f1813x0, new LayerDrawable(new Drawable[]{this.f1815z0, new ColorDrawable(Color.argb(iMax, 0, 0, 0))}));
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void D1() {
        super.D1();
        x3();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        WebView webView = this.f1813x0;
        if (webView != null) {
            webView.onPause();
        }
        super.M1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        WebView webView = this.f1813x0;
        if (webView != null) {
            webView.onResume();
        }
        super.R1();
    }

    @Override // androidx.fragment.app.Fragment
    public void S1(Bundle bundle) {
        bundle.putInt("custom_section", this.f1812w0);
        super.S1(bundle);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        y3();
        h3.u(G(), -14540254);
        h3.t(G(), com.tuyafeng.support.utils.e.a(G(), w7.k.f13724d));
        x.P(this.f7947o0, new ColorDrawable(-14540254));
        this.f1809t0 = (FrameLayout) view.findViewById(w7.p.D);
        this.f1810u0 = (FrameLayout) view.findViewById(w7.p.E);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(w7.p.f13913u0);
        this.f1811v0 = radioGroup;
        radioGroup.check(this.f1812w0);
        this.f1811v0.setClipToPadding(true);
        h3.f(this.f7947o0, null, this.f1811v0);
        com.tuyafeng.support.utils.g gVarD = new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.e.a(G(), w7.k.f13724d)).d(v8.h.e(G()), 0.0f);
        x.P(this.f1811v0, gVarD.a());
        x.P(this.f1810u0, gVarD.a());
        int childCount = this.f1811v0.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RadioButton radioButton = (RadioButton) this.f1811v0.getChildAt(i10);
            v8.g.d(radioButton);
            radioButton.setOnClickListener(new a());
        }
        v3();
        ((autodispose2.n) p8.d.d(G()).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: b9.i
            @Override // u6.f
            public final void accept(Object obj) {
                this.f1800c.f1813x0.loadUrl((String) obj);
            }
        }, new a0());
        this.f1807r0.f1822e.g(b1(), new androidx.lifecycle.o() { // from class: b9.j
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f1801a.w3();
            }
        });
        this.f1807r0.f1824g.g(b1(), new androidx.lifecycle.o() { // from class: b9.k
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f1802a.B3();
            }
        });
        this.f1807r0.f1826i.g(b1(), new androidx.lifecycle.o() { // from class: b9.l
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f1803a.f1813x0.clearCache(false);
            }
        });
        this.f1807r0.f1828k.g(b1(), new androidx.lifecycle.o() { // from class: b9.m
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f1804a.A3(-1);
            }
        });
        this.f1813x0.post(new Runnable() { // from class: b9.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f1805c.B3();
            }
        });
        Bundle bundleW0 = w0();
        if (SettingsSearchLocator.c(bundleW0) && bundle == null) {
            int i11 = bundleW0.getInt("settings_search_section", bundleW0.getInt("settings_search_target"));
            if (!bundleW0.containsKey("settings_search_section")) {
                bundleW0.remove("settings_search_target");
            }
            this.f1811v0.check(i11);
            A3(i11);
        } else if (this.f1812w0 != -1) {
            this.f1810u0.setVisibility(0);
        }
        if ("about:home".equals(this.f1808s0.p())) {
            view.findViewById(w7.p.f13880j0).setVisibility(8);
        } else {
            view.findViewById(w7.p.f13880j0).setVisibility(0);
            view.findViewById(w7.p.f13929z1).setOnClickListener(new b());
        }
    }

    @Override // m8.g
    public boolean W2() {
        return false;
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(w7.r.f13947p, viewGroup, false);
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, u.Kc);
        e0Var.setBackgroundColor(-14540254);
        e0Var.setContentColor(-1);
    }

    public final WebResourceResponse u3() {
        WebResourceResponse webResourceResponse = null;
        try {
            WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/css", "UTF-8", new BufferedInputStream(new FileInputStream(new File(G().getFilesDir(), "homepage.css").getAbsolutePath())));
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
        WebView webView = new WebView(G());
        this.f1813x0 = webView;
        this.f1809t0.addView(webView);
        this.f1813x0.setOnTouchListener(new View.OnTouchListener() { // from class: b9.o
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return q.k3(view, motionEvent);
            }
        });
        this.f1813x0.setHorizontalScrollBarEnabled(false);
        this.f1813x0.setVerticalScrollBarEnabled(false);
        this.f1813x0.setBackgroundColor(0);
        this.f1813x0.setScaleX(0.95f);
        this.f1813x0.setScaleY(0.95f);
        this.f1813x0.setClickable(false);
        this.f1813x0.setFocusable(false);
        WebSettings settings = this.f1813x0.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        this.f1813x0.setWebViewClient(new c());
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1813x0.setOutlineProvider(new d());
            this.f1813x0.setClipToOutline(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (bundle != null) {
            this.f1812w0 = bundle.getInt("custom_section", -1);
        }
        this.f1807r0 = (t) new androidx.lifecycle.a0(this).a(t.class);
        this.f1808s0 = la.s.j();
        u9.n.e().u(true).t(true);
    }

    public final void w3() {
        C3();
        ((autodispose2.n) p8.d.d(G()).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: b9.p
            @Override // u6.f
            public final void accept(Object obj) {
                this.f1806c.f1813x0.reload();
            }
        }, new a0());
    }

    public final Bundle z3(int i10) {
        Bundle bundleW0 = w0();
        if (bundleW0 == null || bundleW0.getInt("settings_search_section", -1) != i10) {
            return null;
        }
        return new Bundle(bundleW0);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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

    @Override // m8.g
    public void S2() {
    }
}
