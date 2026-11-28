package mark.via.browser;

import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class sb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tuyafeng.support.widget.a0 f9651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f9652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9655e = -1;

    public sb b(WebView webView) {
        this.f9652b = webView;
        return this;
    }

    public sb c(boolean z10) {
        this.f9653c = z10;
        return this;
    }

    public void d() {
        this.f9651a.setSystemOrientation(this.f9655e);
        String strG = c6.a2.f1958a.g(this.f9652b.getUrl());
        boolean z10 = false;
        this.f9651a.setVolumeGestureEnabled(this.f9653c && x8.z.X(strG));
        this.f9651a.setBrightnessGestureEnabled(this.f9653c && x8.z.X(strG));
        com.tuyafeng.support.widget.a0 a0Var = this.f9651a;
        if (this.f9654d && x8.z.W(strG)) {
            z10 = true;
        }
        a0Var.setToolbarEnabled(z10);
        rd.q(this.f9652b).C(new Runnable() { // from class: mark.via.browser.rb
            @Override // java.lang.Runnable
            public final void run() {
                this.f9606c.h();
            }
        });
    }

    public void e() {
        this.f9651a.setControllerCallback(null);
        rd.q(this.f9652b).D();
    }

    public sb f(int i10) {
        this.f9655e = i10;
        return this;
    }

    public sb g(boolean z10) {
        this.f9654d = z10;
        return this;
    }

    public final void h() {
        rd rdVarQ = rd.q(this.f9652b);
        String strG = c6.a2.f1958a.g(this.f9652b.getUrl());
        int iT = rdVarQ.t();
        int iR = rdVarQ.r();
        com.tuyafeng.support.widget.a0 a0Var = this.f9651a;
        if (iT <= 0) {
            iT = 16;
        }
        if (iR <= 0) {
            iR = 9;
        }
        a0Var.M(iT, iR);
        if (!rdVarQ.u()) {
            this.f9651a.setControllerCallback(null);
            return;
        }
        this.f9651a.setSpeedAdjustable(x8.z.Q(strG));
        this.f9651a.setProgressGestureEnabled(this.f9653c && x8.z.R(strG));
        this.f9651a.setControllerCallback(rdVarQ);
    }

    public sb i(com.tuyafeng.support.widget.a0 a0Var) {
        this.f9651a = a0Var;
        return this;
    }
}
