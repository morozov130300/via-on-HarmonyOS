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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f8 extends i8.a {
    public WebView E0;
    public final androidx.activity.o F0 = new a(true);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends androidx.activity.o {
        public a(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.o
        public void d() {
            if (f8.this.E0 != null && f8.this.E0.canGoBack()) {
                f8.this.E0.goBack();
            } else {
                j(false);
                f8.this.V2();
            }
        }
    }

    public static /* synthetic */ void j3(final f8 f8Var, TextView textView) {
        f8Var.getClass();
        textView.setText(R.string.ok);
        textView.setTextColor(v8.h.j(f8Var.G()));
        textView.setGravity(17);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(0, v8.h.q(f8Var.G()));
        textView.setOnClickListener(new View.OnClickListener() { // from class: hb.e8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5859a.V2();
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
        f8Var.F2(bundleM3);
        return f8Var;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.E0 = (WebView) new b6.a(new WebView(G()), new FrameLayout.LayoutParams(-1, -1)).r(1, 0, 14, 0, 48).l();
        TextView textView = (TextView) new b6.a(new TextView(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.x.h(G(), 48.0f), 80)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13786e)).V(new b6.a.InterfaceC0033a() { // from class: hb.d8
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f8.j3(this.f5847a, (TextView) obj);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        frameLayout.addView(this.E0);
        frameLayout.addView(textView);
        return frameLayout;
    }

    @Override // androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void D1() {
        WebView webView = this.E0;
        if (webView != null) {
            webView.destroy();
            this.E0 = null;
        }
        super.D1();
    }

    @Override // androidx.fragment.app.Fragment
    public void M1() {
        s4.b.h(this.E0);
        super.M1();
    }

    @Override // i8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        s4.b.i(this.E0);
        Dialog dialogX2 = X2();
        if (dialogX2 == null) {
            return;
        }
        dialogX2.setCanceledOnTouchOutside(false);
        dialogX2.setCancelable(true);
        Window window = dialogX2.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        double dP = com.tuyafeng.support.utils.x.p(G());
        Double.isNaN(dP);
        attributes.width = Math.min((int) (dP * 0.95d), com.tuyafeng.support.utils.x.h(G(), 400.0f));
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        String string = w0() == null ? null : w0().getString("url");
        if (string == null || string.isEmpty()) {
            L0().e1();
            return;
        }
        i0().h().h(b1(), this.F0);
        this.E0.setWebChromeClient(new WebChromeClient());
        this.E0.setWebViewClient(new b());
        s4.b.f(this.E0);
        WebSettings settings = this.E0.getSettings();
        settings.setCacheMode(-1);
        settings.setLoadWithOverviewMode(false);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        x8.r3.g(this.E0);
        this.E0.setHorizontalScrollBarEnabled(false);
        this.E0.loadUrl(string);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            c6.a2 a2Var = c6.a2.f1958a;
            if (a2Var.t(str) || a2Var.m(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String string = ((Build.VERSION.SDK_INT >= 21 || webResourceRequest != null) && webResourceRequest.getUrl() != null) ? webResourceRequest.getUrl().toString() : null;
            if (string != null) {
                c6.a2 a2Var = c6.a2.f1958a;
                if (!a2Var.t(string) && !a2Var.m(string)) {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }
}
