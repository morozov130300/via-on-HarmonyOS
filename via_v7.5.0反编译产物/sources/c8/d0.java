package c8;

import android.R;
import android.app.Activity;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import mark.via.browser.sb;
import x8.j3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f2175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f2176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.tuyafeng.support.widget.a0 f2178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f2179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public sb f2180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2184j;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        t4.b H();

        boolean a();

        void k0(boolean z10);
    }

    public d0(Activity activity, u9.l lVar, a aVar) {
        this.f2175a = activity;
        this.f2176b = lVar;
        this.f2177c = aVar;
    }

    @Override // q4.a
    public boolean A(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.f2184j || view == null || K()) {
            M(customViewCallback);
            return true;
        }
        t4.b bVarH = this.f2177c.H();
        if (bVarH == null) {
            M(customViewCallback);
            return true;
        }
        this.f2182h = SystemClock.elapsedRealtime();
        boolean z10 = false;
        if (this.f2183i > 1) {
            this.f2176b.o(0);
        }
        this.f2181g = this.f2175a.getRequestedOrientation();
        this.f2179e = customViewCallback;
        view.setKeepScreenOn(true);
        com.tuyafeng.support.widget.a0 a0Var = new com.tuyafeng.support.widget.a0(this.f2175a);
        this.f2178d = a0Var;
        a0Var.setBackgroundColor(-16777216);
        FrameLayout frameLayout = (FrameLayout) this.f2175a.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.addView(this.f2178d, layoutParams);
        this.f2178d.addView(view, 0, new FrameLayout.LayoutParams(layoutParams));
        this.f2178d.setTitle(bVarH.getTitle());
        boolean zA = this.f2177c.a();
        sb sbVarF = new sb().i(this.f2178d).b(bVarH).f(this.f2181g);
        if (!zA && this.f2176b.G1()) {
            z10 = true;
        }
        sb sbVarG = sbVarF.c(z10).g(!zA);
        this.f2180f = sbVarG;
        sbVarG.d();
        this.f2177c.k0(true);
        return true;
    }

    public void J() {
        this.f2184j = true;
        i();
    }

    public boolean K() {
        return this.f2178d != null;
    }

    public boolean L() {
        com.tuyafeng.support.widget.a0 a0Var = this.f2178d;
        return a0Var != null && a0Var.H();
    }

    public final void M(WebChromeClient.CustomViewCallback customViewCallback) {
        if (customViewCallback != null) {
            try {
                customViewCallback.onCustomViewHidden();
            } catch (Exception unused) {
            }
        }
    }

    public void N(boolean z10) {
        com.tuyafeng.support.widget.a0 a0Var = this.f2178d;
        if (a0Var != null) {
            a0Var.setInPipMode(z10);
        }
    }

    @Override // q4.a
    public View a() {
        return LayoutInflater.from(this.f2175a).inflate(w7.r.f13932a, (ViewGroup) this.f2175a.findViewById(R.id.content), false);
    }

    @Override // q4.a
    public boolean i() {
        if (!K()) {
            return true;
        }
        this.f2180f.e();
        this.f2180f = null;
        this.f2183i = SystemClock.elapsedRealtime() - this.f2182h < 800 ? this.f2183i + 1 : 0;
        j3.i(this.f2175a, this.f2181g);
        this.f2178d.getChildAt(0).setKeepScreenOn(false);
        ViewGroup viewGroup = (ViewGroup) this.f2178d.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f2178d);
        }
        this.f2178d.removeAllViews();
        this.f2178d = null;
        WebChromeClient.CustomViewCallback customViewCallback = this.f2179e;
        this.f2179e = null;
        M(customViewCallback);
        if (!this.f2184j && !K()) {
            this.f2177c.k0(false);
        }
        return true;
    }
}
