package e8;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Objects;
import q0.d;
import z8.b4;
import z8.r3;
import z8.t1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i extends p4.a {

    /* renamed from: d, reason: collision with root package name */
    public static final int f4821d = x7.p.I0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f4822e = x7.p.J0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f4823f = g6.y.l();

    /* renamed from: g, reason: collision with root package name */
    public static final int f4824g = g6.y.l();

    /* renamed from: h, reason: collision with root package name */
    public static final int f4825h = g6.y.l();

    /* renamed from: i, reason: collision with root package name */
    public static final int f4826i = g6.y.l();

    /* renamed from: a, reason: collision with root package name */
    public final ca.d f4827a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f4828b;

    /* renamed from: c, reason: collision with root package name */
    public final a f4829c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void C(n4.a aVar, String str);

        boolean E(View view, MotionEvent motionEvent);

        o5.a Q(WebView webView);

        boolean S();

        boolean h0(String str);

        void onDownloadStart(String str, String str2, String str3, String str4, long j10);

        d8.e y();
    }

    public i(ca.d dVar, w9.l lVar, a aVar) {
        this.f4827a = dVar;
        this.f4828b = lVar;
        this.f4829c = aVar;
    }

    public static /* synthetic */ boolean G(i iVar, View view, MotionEvent motionEvent) {
        a aVar = iVar.f4829c;
        return aVar != null && aVar.E(view, motionEvent);
    }

    public static /* synthetic */ void H(i iVar, t4.b bVar, String str) {
        iVar.getClass();
        bVar.stopLoading();
        iVar.B(bVar, str);
        bVar.setReferer(bVar.getReferer());
        bVar.loadUrl(str);
    }

    public static /* synthetic */ boolean I(i iVar, View view) {
        a aVar = iVar.f4829c;
        return aVar != null && aVar.S();
    }

    @Override // p4.a
    public void B(t4.b bVar, String str) {
        L(bVar);
        M(bVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a1  */
    @Override // p4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C(t4.b bVar) {
        String string;
        s4.b.f(bVar);
        bVar.getSettings().setMediaPlaybackRequiresUserGesture(false);
        r3.f(bVar);
        if (Build.VERSION.SDK_INT >= 26) {
            bVar.setImportantForAutofill(1);
        }
        bVar.setScrollBarSize(g6.f.d(bVar.getContext(), x7.n.f13690i));
        final a aVar = this.f4829c;
        Objects.requireNonNull(aVar);
        bVar.setDownloadListener(new DownloadListener() { // from class: e8.d
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                aVar.onDownloadStart(str, str2, str3, str4, j10);
            }
        });
        bVar.setOnLongClickListener(new View.OnLongClickListener() { // from class: e8.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return i.I(this.f4800a, view);
            }
        });
        bVar.setOnTouchListener(new View.OnTouchListener() { // from class: e8.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return i.G(this.f4803a, view, motionEvent);
            }
        });
        bVar.removeJavascriptInterface("searchBoxJavaBridge_");
        bVar.removeJavascriptInterface("accessibility");
        bVar.removeJavascriptInterface("accessibilityTraversal");
        bVar.addJavascriptInterface(this.f4829c.y(), "via");
        bVar.addJavascriptInterface(this.f4829c.Q(bVar), "via_gm");
        ArrayList arrayList = new ArrayList();
        String strC = pa.r.o().c();
        if (strC == null) {
            string = "Web search";
        } else {
            int identifier = bVar.getContext().getResources().getIdentifier("websearch", "string", strC);
            if (identifier <= 0) {
                identifier = bVar.getContext().getResources().getIdentifier("websearch", "string", "android");
            }
            if (identifier > 0) {
                string = bVar.getContext().getString(identifier);
            }
        }
        arrayList.add(new n4.a(0, string, 1));
        arrayList.add(new n4.a(0, bVar.getContext().getString(x7.u.Vb), 1));
        arrayList.add(new n4.a(f4823f, bVar.getContext().getString(x7.u.Tb)));
        arrayList.add(new n4.a(f4824g, bVar.getContext().getString(x7.u.E5)));
        bVar.setActionItems(arrayList);
        final a aVar2 = this.f4829c;
        Objects.requireNonNull(aVar2);
        bVar.setOnActionItemClickListener(new n4.b() { // from class: e8.g
            @Override // n4.b
            public final void a(n4.a aVar3, String str) {
                aVar2.C(aVar3, str);
            }
        });
        r3.h(bVar);
        J(bVar.getSettings());
    }

    @Override // p4.a
    public int E(final t4.b bVar, final String str, boolean z10, boolean z11) {
        if (bVar != null) {
            int i10 = f4821d;
            if (bVar.getTag(i10) != null) {
                bVar.setTag(i10, null);
                i6.i0 i0Var = i6.i0.f7006a;
                if (i0Var.s(str)) {
                    ba.b bVarE = this.f4827a.e(i0Var.f(str));
                    if (bVarE == null || bVarE.r()) {
                        return 2;
                    }
                    if (bVarE.k()) {
                        bVar.postDelayed(new Runnable() { // from class: e8.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                i.H(this.f4813e, bVar, str);
                            }
                        }, 20L);
                        return 3;
                    }
                    B(bVar, str);
                    return 2;
                }
            }
        }
        if (this.f4829c.h0(str)) {
            return 3;
        }
        if (N(bVar, str, z10)) {
            return 1;
        }
        if (bVar == null) {
            return 0;
        }
        if (z10) {
            String url = bVar.getUrl();
            ca.d dVar = this.f4827a;
            i6.i0 i0Var2 = i6.i0.f7006a;
            ba.b bVarE2 = dVar.e(i0Var2.e(url));
            ba.b bVarE3 = this.f4827a.e(i0Var2.e(str));
            if (bVarE2 != null && bVarE2.s() && ((bVarE3 == null || !bVarE3.s()) && (bVarE2.j() != -1 || bVarE2.p(false)))) {
                str = url;
            }
        }
        B(bVar, str);
        return 2;
    }

    public final void J(WebSettings webSettings) {
        if (q0.g.a("WEB_AUTHENTICATION")) {
            q0.e.f(webSettings, 2);
        } else {
            pc.a.a("Web Auth is disabled", new Object[0]);
        }
    }

    public final boolean K(String str) {
        String strE = i6.i0.f7006a.e(str);
        ba.b bVarE = this.f4827a.e(strE);
        return (bVarE != null && bVarE.s() && bVarE.w()) ? bVarE.v(true) : this.f4828b.m2().p() && z8.b0.J(strE);
    }

    public final void L(t4.b bVar) {
        WebSettings settings = bVar.getSettings();
        w9.p pVarM2 = this.f4828b.m2();
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 >= 29) {
            boolean z11 = this.f4828b.d() && this.f4828b.Z();
            if (q0.g.a("ALGORITHMIC_DARKENING")) {
                q0.e.c(settings, z11);
            } else if (q0.g.a("FORCE_DARK")) {
                q0.e.d(settings, z11 ? 2 : 0);
            }
        }
        settings.setSupportMultipleWindows(pVarM2.w());
        settings.setGeolocationEnabled(true);
        if (m8.a.f8678c <= 18) {
            settings.setSavePassword(pVarM2.A());
        }
        settings.setCacheMode(-1);
        if (i10 >= 26) {
            try {
                settings.setSafeBrowsingEnabled(!pVarM2.y());
            } catch (Throwable th) {
                pc.a.i(th);
            }
        }
        try {
            if (pVarM2.m()) {
                bVar.h(1);
            } else {
                bVar.j(1);
            }
            if (pVarM2.z()) {
                bVar.h(2);
            } else {
                bVar.j(2);
            }
            if (pVarM2.B()) {
                bVar.h(4);
            } else {
                bVar.j(4);
            }
            if (this.f4828b.g()) {
                bVar.setAcceptLanguageLocales(t1.f());
            } else {
                bVar.setAcceptLanguageLocales(null);
            }
        } catch (Exception unused) {
        }
        boolean zJ = pVarM2.j();
        CookieManager.getInstance().setAcceptCookie(zJ);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager cookieManager = CookieManager.getInstance();
            if (zJ && pVarM2.C()) {
                z10 = true;
            }
            cookieManager.setAcceptThirdPartyCookies(bVar, z10);
        }
        WebView.setWebContentsDebuggingEnabled(pVarM2.G());
    }

    public final void M(t4.b bVar, String str) {
        int i10 = f4822e;
        String str2 = (String) bVar.getTag(i10);
        WebSettings settings = bVar.getSettings();
        w9.p pVarM2 = this.f4828b.m2();
        if (str != null && i6.i0.f7006a.l(str)) {
            if ("f".equals(str2)) {
                return;
            }
            bVar.setBackgroundColor(0);
            settings.setLoadsImagesAutomatically(true);
            settings.setBlockNetworkImage(false);
            settings.setJavaScriptEnabled(true);
            settings.setUserAgentString(this.f4828b.L1());
            O(settings);
            settings.setTextZoom(100);
            bVar.setTag(i10, "f");
            return;
        }
        String strE = i6.i0.f7006a.e(str);
        ba.b bVarE = this.f4827a.e(strE);
        if (strE.length() <= 0 || bVarE == null || !bVarE.s()) {
            if (this.f4828b.R0().equals(str2)) {
                return;
            }
            settings.setUserAgentString(this.f4828b.L1());
            O(settings);
            settings.setJavaScriptEnabled(pVarM2.t());
            settings.setLoadsImagesAutomatically(pVarM2.H());
            settings.setBlockNetworkImage(!pVarM2.H());
            settings.setTextZoom(this.f4828b.F0());
            bVar.setTag(i10, this.f4828b.R0());
        } else {
            if (strE.equals(str2)) {
                return;
            }
            boolean zP = bVarE.p(pVarM2.l());
            int iL0 = bVarE.j() == -1000 ? this.f4828b.l0() : bVarE.j();
            settings.setUserAgentString(b4.c(iL0, iL0 <= 0 ? bVarE.c(this.f4828b.L1()) : y9.d.c().b(iL0), this.f4828b.Y1(), zP, this.f4828b.U(), this.f4828b.h2(), this.f4828b.i1().e()));
            O(settings);
            settings.setJavaScriptEnabled(bVarE.B(pVarM2.t()));
            boolean zX = bVarE.x(pVarM2.H());
            settings.setLoadsImagesAutomatically(zX);
            settings.setBlockNetworkImage(!zX);
            settings.setTextZoom(bVarE.i(this.f4828b.F0()));
            bVar.setTag(i10, strE);
        }
        bVar.setBackgroundColor((this.f4828b.d() && (this.f4828b.S2() || this.f4828b.O0())) ? -16777216 : -1);
    }

    public final boolean N(t4.b bVar, String str, boolean z10) {
        if (bVar == null || str == null) {
            return (z10 || K(str)) ? false : true;
        }
        int i10 = f4821d;
        if (bVar.getTag(i10) != null) {
            bVar.setTag(i10, null);
            return false;
        }
        boolean zK = !z10;
        String url = bVar.getUrl();
        boolean zM = u9.d.m(bVar.getContext(), str);
        if (zM != u9.d.m(bVar.getContext(), url)) {
            return true;
        }
        if (zM) {
            return false;
        }
        if (!z10) {
            int iLastIndexOf = str.lastIndexOf(35);
            int iLastIndexOf2 = url == null ? -1 : url.lastIndexOf(35);
            if (url != null && (iLastIndexOf >= 0 || iLastIndexOf2 >= 0)) {
                if (iLastIndexOf < 0) {
                    iLastIndexOf = str.length();
                }
                if (iLastIndexOf2 < 0) {
                    iLastIndexOf2 = url.length();
                }
                if (iLastIndexOf == iLastIndexOf2 && str.regionMatches(0, url, 0, iLastIndexOf)) {
                    zK = false;
                }
            }
            if (zK && !K(str)) {
                zK = K(url);
            }
            if (zK && z8.b0.K(url)) {
                return false;
            }
        }
        return zK;
    }

    public final void O(WebSettings webSettings) {
        String userAgentString;
        if (webSettings == null || !q0.g.a("USER_AGENT_METADATA") || (userAgentString = webSettings.getUserAgentString()) == null || userAgentString.isEmpty() || userAgentString.contains("Android")) {
            return;
        }
        q0.d dVarB = q0.e.b(webSettings);
        String str = "Windows";
        boolean z10 = false;
        if (!userAgentString.contains("Windows")) {
            if (userAgentString.contains("iPhone") || userAgentString.contains("iPad")) {
                str = "iOS";
                z10 = true;
            } else {
                str = userAgentString.contains("Macintosh") ? "macOS" : "Unknown";
            }
        }
        ArrayList arrayList = new ArrayList();
        for (d.b bVar : dVarB.c()) {
            if (!bVar.a().contains("Android")) {
                arrayList.add(bVar);
            }
        }
        String strD = dVarB.d();
        if (strD != null) {
            strD = strD.trim();
            if (strD.isEmpty()) {
                strD = null;
            }
        }
        q0.e.e(webSettings, new d.c().h(str).i(dVarB.g()).e(strD).g(dVarB.e()).c(dVarB.b()).b(dVarB.a()).j(dVarB.i()).f(z10).d(arrayList).a());
    }

    @Override // p4.a
    public boolean c(ConsoleMessage consoleMessage) {
        return true;
    }

    @Override // p4.a
    public boolean d(String str, int i10, String str2) {
        return true;
    }

    @Override // p4.a
    public boolean u(t4.b bVar, int i10, String str, String str2) {
        if (i10 != -10) {
            return false;
        }
        this.f4829c.h0(str2);
        return true;
    }
}
