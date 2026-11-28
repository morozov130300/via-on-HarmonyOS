package x7;

import android.R;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c6.a2;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.b0;
import com.tuyafeng.support.widget.e0;
import v8.h;
import w7.n;
import w7.o;
import w7.u;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public e0 f14533r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public WebView f14534s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public b0 f14535t0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            g.this.f14535t0.f(i10);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            g.this.f14533r0.setTitle(str);
        }
    }

    public static /* synthetic */ void a3(final g gVar, TextView textView) {
        gVar.getClass();
        textView.setText(R.string.ok);
        textView.setTextColor(h.j(gVar.G()));
        textView.setGravity(17);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(0, h.q(gVar.G()));
        textView.setOnClickListener(new View.OnClickListener() { // from class: x7.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14532a.f3();
            }
        });
    }

    public static /* synthetic */ void c3(ProgressBar progressBar) {
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(h.w(progressBar.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3() {
        super.T2();
    }

    public static Bundle g3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str2);
        bundle.putString("url", str);
        return bundle;
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void D1() {
        WebView webView = this.f14534s0;
        if (webView != null) {
            webView.destroy();
            this.f14534s0 = null;
        }
        super.D1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        s4.b.h(this.f14534s0);
        super.M1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        s4.b.i(this.f14534s0);
    }

    @Override // m8.g
    public void T2() {
        WebView webView = this.f14534s0;
        if (webView == null || !webView.canGoBack()) {
            super.T2();
        } else {
            this.f14534s0.goBack();
        }
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        String string = w0() == null ? null : w0().getString("url");
        if (string == null || string.isEmpty()) {
            L0().e1();
            return;
        }
        this.f14534s0.setWebChromeClient(new a());
        this.f14534s0.setWebViewClient(new b());
        s4.b.f(this.f14534s0);
        WebSettings settings = this.f14534s0.getSettings();
        settings.setCacheMode(-1);
        settings.setLoadWithOverviewMode(false);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        r3.g(this.f14534s0);
        this.f14534s0.setHorizontalScrollBarEnabled(false);
        this.f14534s0.loadUrl(string);
        v3.b(this.f14533r0, w0() == null ? X0(u.Ah) : w0().getString("title"));
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f14534s0 = (WebView) new b6.a(new WebView(G()), new FrameLayout.LayoutParams(-1, -1)).s(com.tuyafeng.support.utils.f.d(G(), n.E)).l();
        ProgressBar progressBar = (ProgressBar) new b6.a(new ProgressBar(G(), null, R.attr.progressBarStyleHorizontal), new FrameLayout.LayoutParams(-1, x.h(G(), 2.0f))).f(0).V(new b6.a.InterfaceC0033a() { // from class: x7.d
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g.c3((ProgressBar) obj);
            }
        }).l();
        TextView textView = (TextView) new b6.a(new TextView(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(G(), n.E), 80)).d(o.f13786e).V(new b6.a.InterfaceC0033a() { // from class: x7.e
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g.a3(this.f14531a, (TextView) obj);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        frameLayout.addView(this.f14534s0);
        frameLayout.addView(progressBar);
        frameLayout.addView(textView);
        this.f14535t0 = new b0(progressBar);
        return frameLayout;
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        super.Z2(e0Var);
        this.f14533r0 = e0Var;
    }

    @Override // m8.g
    public boolean l() {
        WebView webView = this.f14534s0;
        return webView == null || !webView.canGoBack();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            g.this.f14535t0.f(100);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            g.this.f14535t0.f(0);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            a2 a2Var = a2.f1958a;
            if (a2Var.t(str) || a2Var.m(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String string = ((Build.VERSION.SDK_INT >= 21 || webResourceRequest != null) && webResourceRequest.getUrl() != null) ? webResourceRequest.getUrl().toString() : null;
            if (string != null) {
                a2 a2Var = a2.f1958a;
                if (!a2Var.t(string) && !a2Var.m(string)) {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }
}
