package hb;

import android.R;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f8 extends k8.a {
    public WebView C0;
    public final androidx.activity.o D0 = new a(true);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends androidx.activity.o {
        public a(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.o
        public void d() {
            if (f8.this.C0 != null && f8.this.C0.canGoBack()) {
                f8.this.C0.goBack();
            } else {
                j(false);
                f8.this.X2();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String string = ((Build.VERSION.SDK_INT >= 21 || webResourceRequest != null) && webResourceRequest.getUrl() != null) ? webResourceRequest.getUrl().toString() : null;
            if (string != null) {
                i6.i0 i0Var = i6.i0.f7006a;
                if (!i0Var.s(string) && !i0Var.l(string)) {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            i6.i0 i0Var = i6.i0.f7006a;
            if (i0Var.s(str) || i0Var.l(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }
    }

    public static /* synthetic */ void j3(final f8 f8Var, TextView textView) {
        f8Var.getClass();
        textView.setText(R.string.ok);
        textView.setTextColor(x8.h.j(f8Var.I()));
        textView.setGravity(17);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(0, x8.h.r(f8Var.I()));
        textView.setOnClickListener(new View.OnClickListener() { // from class: hb.e8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6538a.X2();
            }
        });
    }

    public static Bundle m3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str2);
        bundle.putString("url", str);
        return bundle;
    }

    public static f8 n3(String str, String str2) {
        Bundle bundleM3 = m3(str, str2);
        f8 f8Var = new f8();
        f8Var.H2(bundleM3);
        return f8Var;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.C0 = (WebView) new h6.a(new WebView(I()), new FrameLayout.LayoutParams(-1, -1)).r(1, 0, 14, 0, 48).l();
        TextView textView = (TextView) new h6.a(new TextView(I()), new FrameLayout.LayoutParams(-1, g6.y.h(I(), 48.0f), 80)).e(g6.f.e(I(), x7.o.f13723f)).V(new a.InterfaceC0076a() { // from class: hb.d8
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                f8.j3(this.f6527a, (TextView) obj);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        frameLayout.addView(this.C0);
        frameLayout.addView(textView);
        return frameLayout;
    }

    @Override // androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void F1() {
        WebView webView = this.C0;
        if (webView != null) {
            webView.destroy();
            this.C0 = null;
        }
        super.F1();
    }

    @Override // androidx.fragment.app.Fragment
    public void O1() {
        s4.b.h(this.C0);
        super.O1();
    }

    @Override // k8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        s4.b.i(this.C0);
        Dialog dialogZ2 = Z2();
        if (dialogZ2 == null) {
            return;
        }
        dialogZ2.setCanceledOnTouchOutside(false);
        dialogZ2.setCancelable(true);
        Window window = dialogZ2.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        double dP = g6.y.p(I());
        Double.isNaN(dP);
        attributes.width = Math.min((int) (dP * 0.95d), g6.y.h(I(), 400.0f));
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        String string = y0() == null ? null : y0().getString("url");
        if (string == null || string.isEmpty()) {
            N0().e1();
            return;
        }
        l0().h().h(d1(), this.D0);
        this.C0.setWebChromeClient(new WebChromeClient());
        this.C0.setWebViewClient(new b());
        s4.b.f(this.C0);
        WebSettings settings = this.C0.getSettings();
        settings.setCacheMode(-1);
        settings.setLoadWithOverviewMode(false);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        z8.r3.f(this.C0);
        this.C0.setHorizontalScrollBarEnabled(false);
        this.C0.loadUrl(string);
    }
}
