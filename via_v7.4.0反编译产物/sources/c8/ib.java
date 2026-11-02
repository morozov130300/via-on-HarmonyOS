package c8;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import c8.ib;
import com.tuyafeng.support.widget.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class ib {

    /* renamed from: a, reason: collision with root package name */
    public com.tuyafeng.support.widget.v f2504a;

    /* renamed from: b, reason: collision with root package name */
    public WebView f2505b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2506c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2507d;

    /* renamed from: e, reason: collision with root package name */
    public int f2508e = -1;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a implements v.b {

        /* renamed from: a, reason: collision with root package name */
        public final WebView f2509a;

        /* renamed from: b, reason: collision with root package name */
        public final float f2510b;

        /* renamed from: c, reason: collision with root package name */
        public final float f2511c;

        public a(WebView webView, float f10, float f11) {
            this.f2509a = webView;
            this.f2510b = f10;
            this.f2511c = f11;
        }

        public static /* synthetic */ void e(ValueCallback valueCallback, String str) {
            if (str.length() > 1 && str.charAt(0) == str.charAt(str.length() - 1) && str.charAt(0) == '\"') {
                str = str.substring(1, str.length() - 1);
            }
            try {
                valueCallback.onReceiveValue(Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception e10) {
                pc.a.i(e10);
                valueCallback.onReceiveValue(0);
            }
        }

        @Override // com.tuyafeng.support.widget.v.b
        public void a(final ValueCallback valueCallback) {
            String strB;
            if (Build.VERSION.SDK_INT <= 19 || (strB = nc.b(this.f2509a.getContext())) == null) {
                valueCallback.onReceiveValue(0);
            } else {
                this.f2509a.evaluateJavascript(strB, new ValueCallback() { // from class: c8.hb
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        ib.a.e(valueCallback, (String) obj);
                    }
                });
            }
        }

        @Override // com.tuyafeng.support.widget.v.b
        public void b(int i10) {
            WebView webView = this.f2509a;
            s4.b.g(webView, nc.c(webView.getContext(), i10));
        }

        @Override // com.tuyafeng.support.widget.v.b
        public void c(float f10) {
            WebView webView = this.f2509a;
            s4.b.g(webView, nc.e(webView.getContext(), f10));
        }

        @Override // com.tuyafeng.support.widget.v.b
        public float d() {
            return this.f2511c;
        }

        @Override // com.tuyafeng.support.widget.v.b
        public float getDuration() {
            return this.f2510b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(ib ibVar, String str, String str2) throws NumberFormatException {
        float f10;
        ibVar.getClass();
        boolean z10 = false;
        if (str2.length() > 1 && str2.charAt(0) == str2.charAt(str2.length() - 1) && str2.charAt(0) == '\"') {
            str2 = str2.substring(1, str2.length() - 1);
        }
        String[] strArrSplit = str2.split(",");
        int i10 = 9;
        int i11 = 16;
        if (strArrSplit.length <= 2) {
            ibVar.f2504a.E(16, 9);
            return;
        }
        float f11 = 1.0f;
        try {
            if ("Infinity".equalsIgnoreCase(strArrSplit[0])) {
                f10 = -1.0f;
            } else {
                f10 = Float.parseFloat(strArrSplit[0]);
                try {
                    f11 = Float.parseFloat(strArrSplit[1]);
                } catch (Exception e10) {
                    e = e10;
                    pc.a.i(e);
                    if (f10 > 0.0f) {
                        ibVar.f2504a.setSpeedAdjustable(z8.b0.R(str));
                        if (ibVar.f2506c) {
                            ibVar.f2504a.setProgressGestureEnabled(!ibVar.f2506c && z8.b0.S(str));
                            ibVar.f2504a.setControllerCallback(new a(ibVar.f2505b, f10, f11));
                        }
                    }
                    ibVar.f2504a.setVolumeGestureEnabled(!ibVar.f2506c && z8.b0.Y(str));
                    com.tuyafeng.support.widget.v vVar = ibVar.f2504a;
                    if (ibVar.f2506c) {
                        z10 = true;
                    }
                    vVar.setBrightnessGestureEnabled(z10);
                    ibVar.f2504a.E(i11, i10);
                    ibVar.f2504a.setToolbarEnabled(ibVar.f2507d & z8.b0.X(str));
                }
            }
            i11 = Integer.parseInt(strArrSplit[2]);
            i10 = Integer.parseInt(strArrSplit[3]);
        } catch (Exception e11) {
            e = e11;
            f10 = 0.0f;
        }
        if (f10 > 0.0f && ibVar.f2504a.isShown()) {
            ibVar.f2504a.setSpeedAdjustable(z8.b0.R(str));
            ibVar.f2504a.setProgressGestureEnabled(!ibVar.f2506c && z8.b0.S(str));
            ibVar.f2504a.setControllerCallback(new a(ibVar.f2505b, f10, f11));
        }
        ibVar.f2504a.setVolumeGestureEnabled(!ibVar.f2506c && z8.b0.Y(str));
        com.tuyafeng.support.widget.v vVar2 = ibVar.f2504a;
        if (ibVar.f2506c && z8.b0.Y(str)) {
            z10 = true;
        }
        vVar2.setBrightnessGestureEnabled(z10);
        ibVar.f2504a.E(i11, i10);
        ibVar.f2504a.setToolbarEnabled(ibVar.f2507d & z8.b0.X(str));
    }

    public ib b(WebView webView) {
        this.f2505b = webView;
        return this;
    }

    public ib c(boolean z10) {
        this.f2506c = z10;
        return this;
    }

    public void d() {
        com.tuyafeng.support.widget.v vVar = this.f2504a;
        if (vVar == null || this.f2505b == null) {
            return;
        }
        vVar.setSystemOrientation(this.f2508e);
        String strA = nc.a(this.f2505b.getContext());
        if (strA == null) {
            return;
        }
        final String strF = i6.i0.f7006a.f(this.f2505b.getUrl());
        this.f2504a.setControllerCallback(null);
        this.f2505b.evaluateJavascript(strA, new ValueCallback() { // from class: c8.gb
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) throws NumberFormatException {
                ib.a(this.f2469a, strF, (String) obj);
            }
        });
    }

    public ib e(int i10) {
        this.f2508e = i10;
        return this;
    }

    public ib f(boolean z10) {
        this.f2507d = z10;
        return this;
    }

    public ib g(com.tuyafeng.support.widget.v vVar) {
        this.f2504a = vVar;
        return this;
    }
}
