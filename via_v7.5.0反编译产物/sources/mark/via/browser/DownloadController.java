package mark.via.browser;

import android.R;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.AdapterView;
import androidx.fragment.app.Fragment;
import androidx.webkit.JavaScriptExecutionException;
import com.tuyafeng.support.utils.FragmentUtils;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class DownloadController implements mark.via.download.w.a, androidx.lifecycle.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f8918c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u9.l f8919e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final x.h f8920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x.h f8921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h.a f8922o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f8923p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c5.a f8924q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final mark.via.download.i f8926s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public mark.via.download.o f8927t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.activity.result.b f8928u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final androidx.activity.result.b f8929v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final androidx.activity.result.b f8930w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final j5.c f8931x = new a();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final mark.via.download.u1 f8925r = mark.via.download.u1.d();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements j5.c {
        public a() {
        }

        public static /* synthetic */ void b(a aVar, g5.c cVar, View view) {
            aVar.getClass();
            x8.e1.j(DownloadController.this.f8918c.G(), x8.e1.b(cVar));
        }

        public static /* synthetic */ void d(a aVar, g5.c cVar, String str, w8.h.a aVar2, Boolean bool) {
            aVar.getClass();
            if (bool.booleanValue()) {
                w8.h.w(DownloadController.this.f8918c.i0(), aVar2, cVar.f());
            } else {
                w8.h.s(DownloadController.this.f8918c.G(), cVar);
                com.tuyafeng.support.utils.n.s(DownloadController.this.f8918c.G(), DownloadController.this.f8918c.Y0(w7.u.H5, str));
            }
        }

        @Override // j5.c
        public void I(final g5.c cVar, int i10, int i11) {
            if (DownloadController.this.f8918c.o1()) {
                boolean zE = g5.b.e(i11);
                if (g5.b.a(i11)) {
                    final String strQ = com.tuyafeng.support.utils.p.q(cVar.l(), 24);
                    String strK = cVar.k();
                    boolean zEquals = "application/vnd.android.package-archive".equals(cVar.k());
                    if (zE && zEquals) {
                        final w8.h.a aVarP = w8.h.p(DownloadController.this.f8918c.G(), cVar);
                        if (aVarP != null) {
                            ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.i9
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    return Boolean.valueOf(w8.h.y(DownloadController.this.f8918c.G(), cVar, aVarP));
                                }
                            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(DownloadController.this.f8918c.b1()))).a(new u6.f() { // from class: mark.via.browser.j9
                                @Override // u6.f
                                public final void accept(Object obj) {
                                    DownloadController.a.d(this.f9258c, cVar, strQ, aVarP, (Boolean) obj);
                                }
                            }, new w7.e0());
                            return;
                        } else {
                            com.tuyafeng.support.utils.n.t(DownloadController.this.f8918c.G(), DownloadController.this.f8918c.Y0(w7.u.G5, strQ), DownloadController.this.f8918c.X0(w7.u.f14170o7), new View.OnClickListener() { // from class: mark.via.browser.k9
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    DownloadController.a.b(this.f9283a, cVar, view);
                                }
                            });
                            return;
                        }
                    }
                    if (zE && strK != null && strK.startsWith("image/")) {
                        mark.via.download.t1.g(DownloadController.this.f8918c.G(), cVar.f());
                    }
                    com.tuyafeng.support.utils.n.t(DownloadController.this.f8918c.G(), zE ? DownloadController.this.f8918c.Y0(w7.u.G5, strQ) : DownloadController.this.f8918c.Y0(w7.u.H5, strQ), DownloadController.this.f8918c.X0(w7.u.oi), new View.OnClickListener() { // from class: mark.via.browser.l9
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DownloadController.this.f8923p.run();
                        }
                    });
                }
            }
        }
    }

    public DownloadController(final Fragment fragment, final u9.l lVar, x.h hVar, x.h hVar2, h.a aVar, Runnable runnable) {
        this.f8918c = fragment;
        this.f8919e = lVar;
        this.f8920m = hVar;
        this.f8921n = hVar2;
        this.f8922o = aVar;
        this.f8923p = runnable;
        this.f8924q = c5.b.r(fragment.G());
        this.f8926s = mark.via.download.i.y(fragment.G());
        this.f8928u = x8.y1.d(fragment, new Runnable() { // from class: mark.via.browser.v8
            @Override // java.lang.Runnable
            public final void run() {
                this.f9708c.C();
            }
        });
        this.f8929v = fragment.w2(new s5.d(), new androidx.activity.result.a() { // from class: mark.via.browser.z8
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                DownloadController.l(this.f9825a, fragment, lVar, (Uri) obj);
            }
        });
        this.f8930w = x8.y1.e(fragment, null, null);
        FragmentUtils.f(fragment, this);
    }

    public static /* synthetic */ void d(DownloadController downloadController, String[][] strArr, Runnable runnable, AdapterView adapterView, View view, int i10, long j10) {
        downloadController.getClass();
        String str = strArr[0][i10];
        downloadController.f8919e.G0(str);
        downloadController.f8925r.h(str);
        Context contextG = downloadController.f8918c.G();
        Fragment fragment = downloadController.f8918c;
        com.tuyafeng.support.utils.n.s(contextG, fragment.Y0(w7.u.F7, fragment.X0(w7.u.C0), strArr[1][i10]));
        runnable.run();
    }

    public static /* synthetic */ void l(DownloadController downloadController, Fragment fragment, u9.l lVar, Uri uri) {
        downloadController.getClass();
        if (uri == null) {
            return;
        }
        fragment.G().getContentResolver().takePersistableUriPermission(uri, 3);
        lVar.r(uri.toString());
        downloadController.C();
    }

    public static /* synthetic */ void n(DownloadController downloadController, View view, File file, int i10, String str, mark.via.download.o oVar, long j10, WebView webView) {
        if (!downloadController.f8918c.g1() || view == null || downloadController.f8918c.a1() != view) {
            if (file != null) {
                downloadController.f8926s.D(Uri.fromFile(file).toString());
            }
        } else {
            if (file == null) {
                downloadController.O(i10);
                return;
            }
            if (com.tuyafeng.support.utils.p.f(str)) {
                str = oVar.e();
            }
            if (com.tuyafeng.support.utils.p.f(oVar.d()) && !com.tuyafeng.support.utils.p.f(oVar.b())) {
                oVar.n(l5.b.b(oVar.h(), oVar.b(), str));
            }
            oVar.s(Uri.fromFile(file).toString());
            oVar.m(j10);
            if (!com.tuyafeng.support.utils.p.f(str)) {
                oVar.p(str);
            }
            downloadController.L(oVar, webView);
        }
    }

    public static /* synthetic */ void p(final DownloadController downloadController, final View view, final mark.via.download.o oVar, final WebView webView, final File file, final String str, final long j10, final int i10) {
        downloadController.getClass();
        q6.b.b().d(new Runnable() { // from class: mark.via.browser.y8
            @Override // java.lang.Runnable
            public final void run() {
                DownloadController.n(this.f9783c, view, file, i10, str, oVar, j10, webView);
            }
        });
    }

    public static /* synthetic */ void q(DownloadController downloadController, mark.via.download.o oVar, Uri uri, View view, q5.k.p pVar) {
        downloadController.f8927t = oVar;
        try {
            downloadController.f8929v.a(uri);
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    public static /* synthetic */ void r(q9 q9Var, q9.b bVar, String str) {
        if (q9Var.i(bVar)) {
            bVar.d(str);
        }
    }

    public static /* synthetic */ void s(final DownloadController downloadController, final mark.via.download.o oVar, x.d dVar) {
        downloadController.getClass();
        int iIntValue = ((Integer) dVar.f14455a).intValue();
        if (iIntValue == 2) {
            com.tuyafeng.support.utils.n.q(downloadController.f8918c.G(), w7.u.f14027e4);
            return;
        }
        if (iIntValue == 3) {
            com.tuyafeng.support.utils.n.r(downloadController.f8918c.G(), w7.u.tg, w7.u.f14099j6, new View.OnClickListener() { // from class: mark.via.browser.w8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f9733a.M(oVar);
                }
            });
            return;
        }
        long j10 = downloadController.f8924q.j((g5.c) dVar.f14456b);
        if (j10 > 0) {
            downloadController.f8926s.m(oVar.h());
            mark.via.download.k.c(downloadController.f8918c.G(), j10);
            com.tuyafeng.support.utils.n.r(downloadController.f8918c.G(), w7.u.f14167o4, w7.u.oi, new View.OnClickListener() { // from class: mark.via.browser.x8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f9756a.f8923p.run();
                }
            });
        }
    }

    public static /* synthetic */ x.d u(DownloadController downloadController, mark.via.download.o oVar, String str) {
        downloadController.getClass();
        g5.c cVar = new g5.c();
        cVar.K(oVar.d());
        cVar.L(oVar.f() == null ? str : oVar.f());
        cVar.T(oVar.h());
        cVar.O(true);
        cVar.J(oVar.e());
        cVar.R(oVar.c());
        if (downloadController.f8926s.C(oVar.h())) {
            cVar.F(true);
        }
        cVar.Q(90);
        if (URLUtil.isNetworkUrl(cVar.t())) {
            cVar.x(8);
            HashMap map = new HashMap();
            if (!com.tuyafeng.support.utils.p.f(oVar.i())) {
                map.put("User-Agent", oVar.i());
            }
            if (!com.tuyafeng.support.utils.p.f(oVar.g())) {
                map.put("Referer", oVar.g());
            }
            if (!com.tuyafeng.support.utils.p.f(oVar.a())) {
                map.put("Authorization", oVar.a());
            }
            if (!map.isEmpty()) {
                cVar.G(map);
            }
            mark.via.download.t1.c(cVar);
        } else {
            cVar.x(1);
        }
        return x.d.a(Integer.valueOf(mark.via.download.t1.i(downloadController.f8918c.G(), cVar, str)), cVar);
    }

    public final String A(String str) {
        Bundle bundleC = p5.b.d().c("dl");
        if (bundleC == null) {
            return null;
        }
        return bundleC.getString(str);
    }

    public void B(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            com.tuyafeng.support.utils.n.q(this.f8918c.G(), w7.u.X1);
        } else {
            K(new mark.via.download.o.b().j(str2).e(A(str)).b());
        }
    }

    public final void C() {
        mark.via.download.o oVar = this.f8927t;
        if (oVar == null) {
            return;
        }
        K(oVar);
        this.f8927t = null;
    }

    public void D() {
        if (this.f8924q.n()) {
            return;
        }
        this.f8924q.k();
    }

    public void E(q9.b bVar, byte[] bArr) {
        this.f8926s.A(bVar, bArr);
    }

    public boolean F(JSONObject jSONObject) {
        return this.f8926s.B(jSONObject);
    }

    public void G(t4.b bVar, String str, String str2, String str3, String str4, long j10) {
        String url;
        int iLastIndexOf;
        String strT;
        if (str != null) {
            url = bVar.getUrl();
            if (url == null || url.isEmpty() || url.equals(str)) {
                url = bVar.getReferer();
            }
            if (bVar.getProgress() >= 100) {
                bVar.stopLoading();
            }
        } else {
            url = null;
        }
        String strA = A(str);
        if (strA != null && !strA.isEmpty() && (((iLastIndexOf = strA.lastIndexOf(46)) < 0 || iLastIndexOf < strA.length() - 11 || iLastIndexOf == strA.length() - 1) && (strT = x8.c1.t(l5.b.b(str, str3, str4))) != null && strT.length() < 10 && !"bin".equals(strT))) {
            strA = strA + "." + strT;
        }
        L(new mark.via.download.o.b().j(str).k(str2).c(str3).g(str4).i(url).d(j10).e(strA).a((String) this.f8922o.apply(c6.a2.f1958a.g(url))).b(), bVar);
    }

    public void H(int i10) {
        if (i10 == 0 || !this.f8924q.i()) {
            return;
        }
        mark.via.download.k.d(this.f8918c.G());
    }

    public void I(WebView webView) {
        this.f8926s.q(webView);
    }

    public void J() {
        if (this.f8925r.g(this.f8918c.G())) {
            return;
        }
        this.f8923p.run();
    }

    public void K(mark.via.download.o oVar) {
        L(oVar, (WebView) this.f8920m.get());
    }

    public void L(final mark.via.download.o oVar, final WebView webView) {
        boolean zA;
        if (FragmentUtils.e(this.f8918c) || oVar == null || oVar.h() == null) {
            if (oVar != null) {
                this.f8926s.D(oVar.h());
                return;
            }
            return;
        }
        boolean zStartsWith = oVar.h().startsWith("blob:");
        if (zStartsWith || this.f8926s.C(oVar.h()) || !this.f8925r.e() || !this.f8925r.a(this.f8918c.i0(), oVar.h())) {
            if (Build.VERSION.SDK_INT >= 33 && !com.tuyafeng.support.utils.f.g(this.f8918c.G(), "android.permission.POST_NOTIFICATIONS")) {
                try {
                    this.f8930w.a("android.permission.POST_NOTIFICATIONS");
                } catch (Exception e10) {
                    tc.a.j(e10);
                }
            }
            boolean z10 = false;
            if (!zStartsWith) {
                if (oVar.h().startsWith("https://wormhole.app/download-stream/")) {
                    if (webView == null) {
                        com.tuyafeng.support.utils.n.q(this.f8918c.G(), w7.u.X1);
                        return;
                    }
                    com.tuyafeng.support.utils.n.q(this.f8918c.G(), w7.u.Na);
                    y(oVar.h(), l5.b.b(oVar.h(), oVar.b(), oVar.e()));
                    s4.b.g(webView, "javascript:(function(){(n=\"__URL__\",fetch(n).then(function(n){return n.blob()}).then(function(n){return new Promise(function(t,e){var o=new FileReader;o.onloadend=function(){t(o.result)};o.onerror=e;o.readAsDataURL(n)})})).then(function(n){window.via.postMessage(\"__SECRET__\",JSON.stringify({action:119,url:\"__URL__\",data:n}))}).catch(function(n){});var n})();".replace("__URL__", oVar.h()).replace("__SECRET__", (CharSequence) this.f8921n.get()));
                    return;
                }
                String strY = this.f8919e.y();
                if (x8.b1.o(strY)) {
                    zA = x8.b1.a(this.f8918c.G(), Uri.parse(strY));
                } else {
                    int i10 = Build.VERSION.SDK_INT;
                    zA = i10 >= 29 || i10 < 23 || com.tuyafeng.support.utils.f.g(this.f8918c.G(), "android.permission.WRITE_EXTERNAL_STORAGE");
                }
                if (zA) {
                    mark.via.download.w.p3(oVar).g3(this.f8918c.x0(), null);
                    return;
                } else {
                    M(oVar);
                    return;
                }
            }
            if (webView == null) {
                O(1);
                return;
            }
            com.tuyafeng.support.utils.n.q(this.f8918c.G(), w7.u.Na);
            if (com.tuyafeng.support.utils.p.f(oVar.d())) {
                oVar.n(A(oVar.h()));
            }
            final View viewA1 = this.f8918c.a1();
            final q9 q9VarM = q9.m(webView);
            final q9.b bVarN = q9VarM.n(oVar.h());
            if (bVarN != null && r0.l.a("WEB_MESSAGE_ARRAY_BUFFER")) {
                z10 = true;
            }
            String strS = this.f8926s.s(this, webView, z10 ? bVarN : null, z10 ? new x.a() { // from class: mark.via.browser.b9
                @Override // x.a
                public final void accept(Object obj) {
                    q6.b.b().d(new Runnable() { // from class: mark.via.browser.e9
                        @Override // java.lang.Runnable
                        public final void run() {
                            DownloadController.r(q9Var, bVar, str);
                        }
                    });
                }
            } : null, new mark.via.download.i.a() { // from class: mark.via.browser.c9
                @Override // mark.via.download.i.a
                public final void a(File file, String str, long j10, int i11) {
                    DownloadController.p(this.f9061a, viewA1, oVar, webView, file, str, j10, i11);
                }
            });
            String strA = d.a(this.f8918c.y0(), (String) this.f8921n.get(), oVar.h(), strS, z10);
            if (bVarN == null) {
                s4.b.g(webView, strA);
            } else {
                bVarN.c(strA, new b(strS));
            }
        }
    }

    public final void M(final mark.via.download.o oVar) {
        this.f8927t = null;
        String strY = this.f8919e.y();
        if (x8.b1.o(strY)) {
            this.f8927t = oVar;
            final Uri uri = Uri.parse(strY);
            q5.k.l(this.f8918c.G()).g0(this.f8918c.X0(w7.u.tg)).K(this.f8918c.X0(w7.u.f14241t8)).X(R.string.ok, new q5.k.m() { // from class: mark.via.browser.f9
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    DownloadController.q(this.f9140a, oVar, uri, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23 || i10 >= 29) {
            return;
        }
        this.f8927t = oVar;
        try {
            this.f8928u.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    public void N(final Runnable runnable) {
        final String[][] strArrC = this.f8925r.c(this.f8918c.i0());
        String strO2 = this.f8919e.O2();
        int i10 = 0;
        if (strO2 != null) {
            int length = strArrC[0].length;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (strO2.equals(strArrC[0][i12])) {
                    i11 = i12;
                }
            }
            i10 = i11;
        }
        q5.k.l(this.f8918c.G()).f0(w7.u.C0).d0(strArrC[1], i10, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.d9
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i13, long j10) {
                DownloadController.d(this.f9091a, strArrC, runnable, adapterView, view, i13, j10);
            }
        }).h0();
    }

    public final void O(int i10) {
        int i11;
        int i12;
        int i13;
        switch (i10) {
            case 1:
                i11 = w7.u.B1;
                int i14 = i11;
                i12 = i10;
                i13 = i14;
                break;
            case 2:
                i11 = w7.u.f14300y1;
                int i15 = i11;
                i12 = i10;
                i13 = i15;
                break;
            case 3:
                i11 = w7.u.A1;
                int i16 = i11;
                i12 = i10;
                i13 = i16;
                break;
            case 4:
                i11 = w7.u.C1;
                int i17 = i11;
                i12 = i10;
                i13 = i17;
                break;
            case 5:
                i11 = w7.u.f14313z1;
                int i18 = i11;
                i12 = i10;
                i13 = i18;
                break;
            case 6:
                i11 = w7.u.f14274w1;
                int i19 = i11;
                i12 = i10;
                i13 = i19;
                break;
            case 7:
                i11 = w7.u.f14287x1;
                int i110 = i11;
                i12 = i10;
                i13 = i110;
                break;
            default:
                i13 = w7.u.D1;
                i12 = 0;
                break;
        }
        Context contextG = this.f8918c.G();
        Fragment fragment = this.f8918c;
        com.tuyafeng.support.utils.n.s(contextG, fragment.Y0(w7.u.f14261v1, fragment.X0(i13), Integer.valueOf(i12)));
    }

    public void P() {
        this.f8925r.h(this.f8919e.O2());
    }

    @Override // mark.via.download.w.a
    public void a(mark.via.download.o oVar) {
        if (oVar == null || oVar.d() == null || oVar.h() == null) {
            return;
        }
        String strH = oVar.h();
        if (this.f8926s.C(strH)) {
            z(oVar);
            return;
        }
        if (URLUtil.isFileUrl(strH)) {
            com.tuyafeng.support.utils.n.q(this.f8918c.G(), w7.u.X1);
            return;
        }
        if (!this.f8925r.f()) {
            z(oVar);
            return;
        }
        if (!URLUtil.isNetworkUrl(strH)) {
            com.tuyafeng.support.utils.n.q(this.f8918c.G(), w7.u.Z1);
        } else if (this.f8925r.b(this.f8918c.G(), oVar.h(), oVar.d(), oVar.i(), oVar.e()) > 0) {
            com.tuyafeng.support.utils.n.r(this.f8918c.G(), w7.u.f14167o4, w7.u.oi, new View.OnClickListener() { // from class: mark.via.browser.a9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadController downloadController = this.f9005a;
                    downloadController.f8925r.g(downloadController.f8918c.G());
                }
            });
        } else {
            com.tuyafeng.support.utils.n.q(this.f8918c.G(), w7.u.f14027e4);
        }
    }

    @Override // androidx.lifecycle.d
    public void b(androidx.lifecycle.j jVar) {
        this.f8924q.e(this.f8931x);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void c(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.a(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public void f(androidx.lifecycle.j jVar) {
        this.f8924q.c(this.f8931x);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void g(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.e(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public void i(androidx.lifecycle.j jVar) {
        this.f8926s.q(this);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void j(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.d(this, jVar);
    }

    public void y(String str, String str2) {
        if (com.tuyafeng.support.utils.p.f(str) || com.tuyafeng.support.utils.p.f(str2)) {
            return;
        }
        p5.b.a().e("dl").f(60).d(str, str2).a();
    }

    public final void z(final mark.via.download.o oVar) {
        if (oVar == null || oVar.d() == null || oVar.h() == null) {
            return;
        }
        final String strY = this.f8919e.y();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.g9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DownloadController.u(this.f9161c, oVar, strY);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f8918c.b1()))).a(new u6.f() { // from class: mark.via.browser.h9
            @Override // u6.f
            public final void accept(Object obj) {
                DownloadController.s(this.f9202c, oVar, (x.d) obj);
            }
        }, new w7.e0());
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements r0.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8933a;

        public b(String str) {
            this.f8933a = str;
        }

        @Override // r0.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onError(JavaScriptExecutionException javaScriptExecutionException) {
            r6.p pVarC = a7.a.c();
            final String str = this.f8933a;
            pVarC.d(new Runnable() { // from class: mark.via.browser.m9
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadController.this.f8926s.w(str, 1);
                }
            });
        }

        @Override // r0.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onResult(String str) {
        }
    }
}
