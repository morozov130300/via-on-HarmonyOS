package c8;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import c6.a2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import x8.c4;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends q4.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f2216d = w7.p.G0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f2217e = w7.p.I0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f2218f = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2219g = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f2220h = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z9.d f2221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f2222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2223c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        boolean C(View view, MotionEvent motionEvent);

        pa.a O(WebView webView);

        boolean P();

        void X(t4.b bVar, String str, String str2, String str3, String str4, long j10);

        boolean g0(t4.b bVar, String str);

        void x(o4.a aVar, String str);

        b8.e y();
    }

    public i(z9.d dVar, u9.l lVar, a aVar) {
        this.f2221a = dVar;
        this.f2222b = lVar;
        this.f2223c = aVar;
    }

    public static /* synthetic */ void K(i iVar, t4.b bVar, String str) {
        iVar.getClass();
        bVar.stopLoading();
        iVar.D(bVar, str);
        bVar.setReferer(bVar.getReferer());
        bVar.loadUrl(str);
    }

    public static /* synthetic */ boolean L(i iVar, View view) {
        a aVar = iVar.f2223c;
        return aVar != null && aVar.P();
    }

    public static /* synthetic */ boolean M(i iVar, View view, MotionEvent motionEvent) {
        a aVar = iVar.f2223c;
        return aVar != null && aVar.C(view, motionEvent);
    }

    @Override // q4.a
    public void D(t4.b bVar, String str) {
        P(bVar);
        Q(bVar, str);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x009c  */
    @Override // q4.a
    public void F(final t4.b bVar) {
        String string;
        s4.b.f(bVar);
        bVar.getSettings().setMediaPlaybackRequiresUserGesture(false);
        r3.g(bVar);
        if (Build.VERSION.SDK_INT >= 26) {
            bVar.setImportantForAutofill(1);
        }
        bVar.setScrollBarSize(com.tuyafeng.support.utils.f.d(bVar.getContext(), w7.n.f13756i));
        bVar.setDownloadListener(new DownloadListener() { // from class: c8.d
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                this.f2173a.f2223c.X(bVar, str, str2, str3, str4, j10);
            }
        });
        bVar.setOnLongClickListener(new View.OnLongClickListener() { // from class: c8.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return i.L(this.f2188a, view);
            }
        });
        bVar.setOnTouchListener(new View.OnTouchListener() { // from class: c8.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return i.M(this.f2196a, view, motionEvent);
            }
        });
        bVar.removeJavascriptInterface("searchBoxJavaBridge_");
        bVar.removeJavascriptInterface("accessibility");
        bVar.removeJavascriptInterface("accessibilityTraversal");
        bVar.addJavascriptInterface(this.f2223c.y(), "via");
        bVar.addJavascriptInterface(this.f2223c.O(bVar), "via_gm");
        ArrayList arrayList = new ArrayList();
        String strC = la.s.o().c();
        if (strC == null) {
            string = "Web search";
        } else {
            int identifier = bVar.getContext().getResources().getIdentifier("websearch", "string", strC);
            if (identifier <= 0) {
                identifier = bVar.getContext().getResources().getIdentifier("websearch", "string", "android");
            }
            if (identifier > 0) {
                string = bVar.getContext().getString(identifier);
            } else {
                string = "Web search";
            }
        }
        arrayList.add(new o4.a(0, string, 1));
        arrayList.add(new o4.a(0, bVar.getContext().getString(w7.u.f14091ic), 1));
        arrayList.add(new o4.a(f2218f, bVar.getContext().getString(w7.u.f14063gc)));
        arrayList.add(new o4.a(f2219g, bVar.getContext().getString(w7.u.Q5)));
        bVar.setActionItems(arrayList);
        final a aVar = this.f2223c;
        Objects.requireNonNull(aVar);
        bVar.setOnActionItemClickListener(new o4.b() { // from class: c8.g
            @Override // o4.b
            public final void a(o4.a aVar2, String str) {
                aVar.x(aVar2, str);
            }
        });
        r3.i(bVar);
        N(bVar.getSettings());
    }

    @Override // q4.a
    public boolean I(t4.b bVar, q4.k kVar) {
        String strB = kVar.b();
        boolean zD = kVar.d();
        if (strB == null) {
            return (zD || O(strB)) ? false : true;
        }
        if (bVar.getTag(f2216d) != null) {
            return false;
        }
        boolean zO = !zD;
        String url = bVar.getUrl();
        boolean zL = s9.d.l(bVar.getContext(), strB);
        if (zL != s9.d.l(bVar.getContext(), url)) {
            return true;
        }
        if (zL) {
            return false;
        }
        if (!zD) {
            int iLastIndexOf = strB.lastIndexOf(35);
            int iLastIndexOf2 = url == null ? -1 : url.lastIndexOf(35);
            if (url != null && (iLastIndexOf >= 0 || iLastIndexOf2 >= 0)) {
                if (iLastIndexOf < 0) {
                    iLastIndexOf = strB.length();
                }
                if (iLastIndexOf2 < 0) {
                    iLastIndexOf2 = url.length();
                }
                if (iLastIndexOf == iLastIndexOf2 && strB.regionMatches(0, url, 0, iLastIndexOf)) {
                    zO = false;
                }
            }
            if (zO && !O(strB)) {
                zO = O(url);
            }
            if (zO && x8.z.J(url)) {
                return false;
            }
        }
        return zO;
    }

    public final void N(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        if (r0.l.a("WEB_AUTHENTICATION")) {
            r0.j.f(webSettings, 2);
        } else {
            tc.a.a("Web Auth is disabled", new Object[0]);
        }
    }

    public final boolean O(String str) {
        String strF = a2.f1958a.f(str);
        y9.b bVarE = this.f2221a.e(strF);
        if (bVarE != null && bVarE.s() && bVarE.w()) {
            return bVarE.v(true);
        }
        return this.f2222b.n2().p() && x8.z.I(strF);
    }

    public final void P(t4.b bVar) {
        WebSettings settings = bVar.getSettings();
        u9.p pVarN2 = this.f2222b.n2();
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 >= 29) {
            boolean z11 = this.f2222b.e() && this.f2222b.c0();
            if (r0.l.a("ALGORITHMIC_DARKENING")) {
                r0.j.c(settings, z11);
            } else if (r0.l.a("FORCE_DARK")) {
                r0.j.d(settings, z11 ? 2 : 0);
            }
        }
        settings.setSupportMultipleWindows(pVarN2.w());
        settings.setGeolocationEnabled(true);
        settings.setCacheMode(-1);
        if (i10 >= 26) {
            try {
                settings.setSafeBrowsingEnabled(!pVarN2.y());
            } catch (Throwable th) {
                tc.a.j(th);
            }
        }
        try {
            if (pVarN2.m()) {
                bVar.h(1);
            } else {
                bVar.j(1);
            }
            if (pVarN2.z()) {
                bVar.h(2);
            } else {
                bVar.j(2);
            }
            if (pVarN2.A()) {
                bVar.h(4);
            } else {
                bVar.j(4);
            }
            if (this.f2222b.h()) {
                bVar.setAcceptLanguageLocales(x8.s1.f());
            } else {
                bVar.setAcceptLanguageLocales(null);
            }
        } catch (Exception unused) {
        }
        boolean zJ = pVarN2.j();
        CookieManager.getInstance().setAcceptCookie(zJ);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager cookieManager = CookieManager.getInstance();
            if (zJ && pVarN2.B()) {
                z10 = true;
            }
            cookieManager.setAcceptThirdPartyCookies(bVar, z10);
        }
        WebView.setWebContentsDebuggingEnabled(pVarN2.F());
    }

    public final void Q(t4.b bVar, String str) {
        int i10 = f2217e;
        String str2 = (String) bVar.getTag(i10);
        WebSettings settings = bVar.getSettings();
        u9.p pVarN2 = this.f2222b.n2();
        if (str != null && a2.f1958a.m(str)) {
            if ("f".equals(str2)) {
                return;
            }
            bVar.setBackgroundColor(0);
            settings.setLoadsImagesAutomatically(true);
            settings.setBlockNetworkImage(false);
            settings.setJavaScriptEnabled(true);
            settings.setUserAgentString(this.f2222b.L1());
            R(settings);
            settings.setTextZoom(100);
            bVar.setTag(i10, "f");
            return;
        }
        String strF = a2.f1958a.f(str);
        y9.b bVarE = this.f2221a.e(strF);
        if (strF.length() <= 0 || bVarE == null || !bVarE.s()) {
            if (this.f2222b.U0().equals(str2)) {
                return;
            }
            settings.setUserAgentString(this.f2222b.L1());
            R(settings);
            settings.setJavaScriptEnabled(pVarN2.t());
            settings.setLoadsImagesAutomatically(pVarN2.G());
            settings.setBlockNetworkImage(!pVarN2.G());
            settings.setTextZoom(this.f2222b.H0());
            bVar.setTag(i10, this.f2222b.U0());
        } else {
            if (strF.equals(str2)) {
                return;
            }
            settings.setUserAgentString(c4.c(bVarE.j() == -1000 ? this.f2222b.o0() : bVarE.j(), bVarE.j() == -1000 ? this.f2222b.L(null) : bVarE.c(null), this.f2222b.Z1(), bVarE.p(pVarN2.l()) && bVarE.j() == -1000, this.f2222b.V(), this.f2222b.i2(), this.f2222b.j1().e()));
            R(settings);
            settings.setJavaScriptEnabled(bVarE.B(pVarN2.t()));
            boolean zX = bVarE.x(pVarN2.G());
            settings.setLoadsImagesAutomatically(zX);
            settings.setBlockNetworkImage(!zX);
            settings.setTextZoom(bVarE.i(this.f2222b.H0()));
            bVar.setTag(i10, strF);
        }
        bVar.setBackgroundColor((this.f2222b.e() && (this.f2222b.V2() || this.f2222b.R0())) ? -16777216 : -1);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0085 A[Catch: UnsupportedOperationException -> 0x004d, TryCatch #0 {UnsupportedOperationException -> 0x004d, blocks: (B:16:0x002d, B:37:0x0072, B:38:0x007f, B:40:0x0085, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:50:0x00ac, B:52:0x00c3, B:54:0x00cb, B:55:0x00d2, B:21:0x003d, B:27:0x0050, B:30:0x005c, B:33:0x0067), top: B:59:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a0 A[Catch: UnsupportedOperationException -> 0x004d, TryCatch #0 {UnsupportedOperationException -> 0x004d, blocks: (B:16:0x002d, B:37:0x0072, B:38:0x007f, B:40:0x0085, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:50:0x00ac, B:52:0x00c3, B:54:0x00cb, B:55:0x00d2, B:21:0x003d, B:27:0x0050, B:30:0x005c, B:33:0x0067), top: B:59:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ab A[PHI: r3
  0x00ab: PHI (r3v4 java.lang.String) = (r3v3 java.lang.String), (r3v6 java.lang.String) binds: [B:45:0x009e, B:47:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0095 A[SYNTHETIC] */
    public final void R(WebSettings webSettings) {
        String userAgentString;
        boolean z10;
        ArrayList arrayList;
        String strF;
        r0.g.c cVarD;
        String str = "Linux";
        if (Build.VERSION.SDK_INT < 24 || webSettings == null || !r0.l.a("USER_AGENT_METADATA") || (userAgentString = webSettings.getUserAgentString()) == null || userAgentString.isEmpty() || userAgentString.contains("Android")) {
            return;
        }
        try {
            r0.g gVarB = r0.j.b(webSettings);
            String str2 = null;
            String str3 = "Desktop";
            if (!userAgentString.contains("Windows")) {
                if (userAgentString.contains("iPhone")) {
                    str3 = "Mobile";
                    str = "iOS";
                    z10 = true;
                } else if (userAgentString.contains("iPad")) {
                    str3 = "Tablet";
                    str = "iOS";
                } else if (userAgentString.contains("Macintosh")) {
                    str = "macOS";
                } else if (!userAgentString.contains("Linux")) {
                    str = "Unknown";
                    str3 = null;
                }
                arrayList = new ArrayList();
                for (r0.g.b bVar : gVarB.d()) {
                    if (bVar.a().contains("Android")) {
                        arrayList.add(bVar);
                    }
                }
                strF = gVarB.f();
                if (strF != null) {
                    strF = strF.trim();
                    if (strF.isEmpty()) {
                        str2 = strF;
                    }
                } else {
                    str2 = strF;
                }
                cVarD = new r0.g.c(gVarB).i(str).f(str2).g(z10).d(arrayList);
                if (str3 != null && r0.l.a("USER_AGENT_METADATA_FORM_FACTORS")) {
                    cVarD.e(Collections.singletonList(str3));
                }
                r0.j.e(webSettings, cVarD.a());
            }
            str = "Windows";
            z10 = false;
            arrayList = new ArrayList();
            while (r6.hasNext()) {
                if (bVar.a().contains("Android")) {
                    arrayList.add(bVar);
                }
            }
            strF = gVarB.f();
            if (strF != null) {
                strF = strF.trim();
                if (strF.isEmpty()) {
                    str2 = strF;
                }
            } else {
                str2 = strF;
            }
            cVarD = new r0.g.c(gVarB).i(str).f(str2).g(z10).d(arrayList);
            if (str3 != null) {
                cVarD.e(Collections.singletonList(str3));
            }
            r0.j.e(webSettings, cVarD.a());
        } catch (UnsupportedOperationException e10) {
            tc.a.c(e10, "WebView does not support updating user-agent metadata", new Object[0]);
        }
    }

    @Override // q4.a
    public boolean c(ConsoleMessage consoleMessage) {
        return true;
    }

    @Override // q4.a
    public boolean d(String str, int i10, String str2) {
        return true;
    }

    @Override // q4.a
    public boolean n(final t4.b bVar, q4.k kVar) {
        final String strB = kVar.b();
        if (bVar != null) {
            int i10 = f2216d;
            if (bVar.getTag(i10) != null) {
                a2 a2Var = a2.f1958a;
                if (a2Var.t(strB)) {
                    y9.b bVarE = this.f2221a.e(a2Var.g(strB));
                    if (bVarE == null || !bVarE.k()) {
                        return false;
                    }
                    bVar.setTag(i10, null);
                    bVar.postDelayed(new Runnable() { // from class: c8.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.K(this.f2209c, bVar, strB);
                        }
                    }, 20L);
                    return true;
                }
            }
        }
        return this.f2223c.g0(bVar, strB);
    }

    @Override // q4.a
    public void s(t4.b bVar, q4.k kVar) {
        String strB = kVar.b();
        int i10 = f2216d;
        boolean z10 = bVar.getTag(i10) != null;
        bVar.setTag(i10, null);
        if (!z10 && kVar.d()) {
            String url = bVar.getUrl();
            z9.d dVar = this.f2221a;
            a2 a2Var = a2.f1958a;
            y9.b bVarE = dVar.e(a2Var.f(url));
            y9.b bVarE2 = this.f2221a.e(a2Var.f(strB));
            if (bVarE != null && bVarE.s() && ((bVarE2 == null || !bVarE2.s()) && (bVarE.j() != -1 || bVarE.p(false)))) {
                strB = url;
            }
        }
        D(bVar, strB);
    }

    @Override // q4.a
    public boolean w(t4.b bVar, int i10, String str, String str2) {
        if (i10 != -10) {
            return false;
        }
        this.f2223c.g0(bVar, str2);
        return true;
    }
}
