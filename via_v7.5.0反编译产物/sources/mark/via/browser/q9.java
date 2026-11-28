package mark.via.browser;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.webkit.JavaScriptExecutionException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q9 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final r0.m f9551k = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WebView f9554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f9560i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f9552a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f9553b = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f9561j = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q9 f9562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r0.c f9563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri f9564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f9566e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f9567f;

        public /* synthetic */ b(q9 q9Var, r0.c cVar, Uri uri, int i10, int i11, a aVar) {
            this(q9Var, cVar, uri, i10, i11);
        }

        public void b(String str) {
            c(str, q9.f9551k);
        }

        public void c(String str, r0.m mVar) {
            this.f9562a.j(this, str, mVar);
        }

        public void d(String str) {
            this.f9563b.b(str);
        }

        public b(q9 q9Var, r0.c cVar, Uri uri, int i10, int i11) {
            this.f9562a = q9Var;
            this.f9563b = cVar;
            this.f9564c = uri;
            this.f9565d = i10;
            this.f9566e = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f9568c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final r0.m f9569e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f9570m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f9571n;

        public c(b bVar, String str, r0.m mVar) {
            this.f9570m = q9.e(q9.this);
            this.f9568c = bVar;
            this.f9571n = bVar.f9567f ? str : null;
            this.f9569e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q9.this.l(this, null);
        }
    }

    public q9(WebView webView) {
        this.f9554c = webView;
    }

    public static /* synthetic */ void b(q9 q9Var, b bVar, r0.m mVar, String str) {
        if (q9Var.i(bVar)) {
            mVar.onResult(str);
        } else {
            mVar.onError(new JavaScriptExecutionException(1, "Frame destroyed"));
        }
    }

    public static /* synthetic */ long e(q9 q9Var) {
        long j10 = q9Var.f9556e + 1;
        q9Var.f9556e = j10;
        return j10;
    }

    public static q9 m(WebView webView) {
        q9 q9Var = (q9) webView.getTag(w7.p.E0);
        if (q9Var != null) {
            return q9Var;
        }
        q9 q9Var2 = new q9(webView);
        webView.setTag(w7.p.E0, q9Var2);
        return q9Var2;
    }

    public static boolean o(String str, String str2) {
        if ("null".equals(str2)) {
            return str.startsWith("blob:null/") && str.length() > 10;
        }
        return str.startsWith("blob:") && r(str.substring(5), str2);
    }

    public static boolean q() {
        return Build.VERSION.SDK_INT >= 24 && r0.l.a("JS_INJECTION_IN_FRAME_AND_WORLD");
    }

    public static boolean r(String str, String str2) {
        try {
            URI uri = new URI(str);
            URL url = new URL(str2);
            String protocol = url.getProtocol();
            if ((!"https".equalsIgnoreCase(protocol) && !"http".equalsIgnoreCase(protocol)) || !protocol.equalsIgnoreCase(uri.getScheme())) {
                return false;
            }
            URL url2 = uri.toURL();
            if (!url.getHost().isEmpty() && url.getHost().equalsIgnoreCase(url2.getHost())) {
                int port = "https".equalsIgnoreCase(protocol) ? 443 : 80;
                int port2 = url2.getPort() == -1 ? port : url2.getPort();
                if (url.getPort() != -1) {
                    port = url.getPort();
                }
                if (port2 <= 65535 && port2 == port) {
                    return true;
                }
            }
        } catch (MalformedURLException | URISyntaxException unused) {
        }
        return false;
    }

    public static boolean s() {
        if (q()) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 24 && r0.l.a("DOCUMENT_START_SCRIPT") && r0.l.a("WEB_MESSAGE_LISTENER");
    }

    public static r0.f v(WebView webView, String str, String str2, Set set, String str3, r0.k.a aVar) {
        q9 q9VarM = m(webView);
        boolean zQ = q();
        q9VarM.f9557f = !zQ;
        q9VarM.f9559h = str3;
        if (!zQ && q9VarM.f9560i == null) {
            q9VarM.f9560i = new Handler(Looper.getMainLooper());
        }
        if (q9VarM.f9557f) {
            r0.k.d(webView, str2, set, aVar);
        } else {
            r0.k.c(webView, str2, set, r0.k.g(webView, ""), aVar);
        }
        try {
            return q9VarM.f9557f ? r0.k.a(webView, str, set) : r0.k.b(webView, str, 0, set, r0.k.g(webView, ""));
        } catch (RuntimeException e10) {
            y(webView, str2);
            throw e10;
        }
    }

    public static void x(WebView webView, r0.f fVar, String str) {
        m(webView).h();
        fVar.remove();
        y(webView, str);
    }

    public static void y(WebView webView, String str) {
        if (q()) {
            r0.k.m(webView, r0.k.g(webView, ""), str);
        } else {
            r0.k.l(webView, str);
        }
    }

    public void A(b bVar, String str, boolean z10) {
        if (o(str, bVar.f9564c.toString())) {
            if (z10) {
                if (this.f9553b.get(str) == bVar) {
                    this.f9553b.remove(str);
                }
            } else {
                if (this.f9553b.containsKey(str)) {
                    return;
                }
                this.f9553b.put(str, bVar);
            }
        }
    }

    public Collection B(b bVar, boolean z10) {
        if (!this.f9557f) {
            return Collections.EMPTY_LIST;
        }
        boolean z11 = bVar.f9567f;
        if (!z11 && (z10 || this.f9558g)) {
            return w(bVar);
        }
        if (!z10 || !z11 || this.f9558g) {
            return Collections.EMPTY_LIST;
        }
        this.f9558g = true;
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : z()) {
            if (bVar2 != bVar) {
                arrayList.addAll(w(bVar2));
            }
        }
        return arrayList;
    }

    public final void g() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f9561j.values().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!i(cVar.f9568c)) {
                it.remove();
                this.f9560i.removeCallbacks(cVar);
                arrayList.add(cVar);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).f9569e.onError(new JavaScriptExecutionException(1, "Frame destroyed"));
        }
    }

    public void h() {
        this.f9552a.clear();
        this.f9553b.clear();
        this.f9555d = 0;
        this.f9558g = false;
        g();
    }

    public boolean i(b bVar) {
        Map map = (Map) this.f9552a.get(bVar.f9563b);
        return map != null && map.get(Integer.valueOf(bVar.f9565d)) == bVar;
    }

    public final void j(final b bVar, String str, final r0.m mVar) {
        boolean z10;
        if (!i(bVar) || ((z10 = this.f9558g) && !bVar.f9567f)) {
            mVar.onError(new JavaScriptExecutionException(1, "Frame destroyed"));
            return;
        }
        if (z10) {
            this.f9554c.evaluateJavascript(str, new ValueCallback() { // from class: mark.via.browser.p9
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    q9.b(this.f9437a, bVar, mVar, (String) obj);
                }
            });
            return;
        }
        if (!this.f9557f) {
            if (bVar.f9565d != 0) {
                str = "window.__VIA_FRAMES.execute(" + bVar.f9565d + "," + JSONObject.quote(str) + ");";
            }
            bVar.f9563b.a(str, mVar);
            return;
        }
        c cVar = new c(bVar, str, mVar);
        this.f9561j.put(Long.valueOf(cVar.f9570m), cVar);
        this.f9560i.postDelayed(cVar, 10000L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Name.MARK, cVar.f9570m).put("frame", bVar.f9565d).put("secret", this.f9559h);
            bVar.f9563b.b("VIA_EXEC " + jSONObject + "\n" + str);
        } catch (RuntimeException | JSONException unused) {
            l(cVar, null);
        }
    }

    public b k(r0.c cVar, int i10) {
        Map map = (Map) this.f9552a.get(cVar);
        if (map == null) {
            return null;
        }
        return (b) map.get(Integer.valueOf(i10));
    }

    public final void l(c cVar, String str) {
        if (this.f9561j.remove(Long.valueOf(cVar.f9570m)) != cVar) {
            return;
        }
        this.f9560i.removeCallbacks(cVar);
        if (str != null) {
            cVar.f9569e.onResult(str);
        } else {
            cVar.f9569e.onError(new JavaScriptExecutionException(0, "Frame execution failed"));
        }
    }

    public b n(String str) {
        return (b) this.f9553b.get(str);
    }

    public boolean p() {
        return this.f9558g;
    }

    public b t(r0.c cVar, Uri uri, int i10) {
        int iMax = Math.max(0, i10);
        Map map = (Map) this.f9552a.get(cVar);
        if (map == null) {
            map = new HashMap();
            this.f9552a.put(cVar, map);
        }
        b bVar = (b) map.get(Integer.valueOf(iMax));
        if (bVar != null) {
            return bVar;
        }
        int i11 = this.f9555d;
        this.f9555d = i11 + 1;
        b bVar2 = new b(this, cVar, uri, iMax, i11, null);
        map.put(Integer.valueOf(iMax), bVar2);
        return bVar2;
    }

    public Collection u(r0.c cVar, JSONObject jSONObject) {
        c cVar2 = (c) this.f9561j.get(Long.valueOf(jSONObject.optLong(Name.MARK)));
        if (cVar2 == null || cVar2.f9568c.f9563b != cVar || cVar2.f9568c.f9565d != jSONObject.optInt("frame", -1) || !i(cVar2.f9568c)) {
            return Collections.EMPTY_LIST;
        }
        if (jSONObject.optBoolean("ok") || !jSONObject.optBoolean("evalBlocked")) {
            l(cVar2, jSONObject.optBoolean("ok") ? jSONObject.optString("result", "null") : null);
            return Collections.EMPTY_LIST;
        }
        Collection collectionB = B(cVar2.f9568c, true);
        if (!i(cVar2.f9568c)) {
            return collectionB;
        }
        this.f9561j.remove(Long.valueOf(cVar2.f9570m));
        this.f9560i.removeCallbacks(cVar2);
        j(cVar2.f9568c, cVar2.f9571n, cVar2.f9569e);
        return collectionB;
    }

    public Collection w(b bVar) {
        Collection collectionSingletonList;
        if (!i(bVar)) {
            return Collections.EMPTY_LIST;
        }
        if (bVar.f9565d == 0) {
            collectionSingletonList = ((Map) this.f9552a.remove(bVar.f9563b)).values();
        } else {
            Map map = (Map) this.f9552a.get(bVar.f9563b);
            map.remove(Integer.valueOf(bVar.f9565d));
            if (map.isEmpty()) {
                this.f9552a.remove(bVar.f9563b);
            }
            collectionSingletonList = Collections.singletonList(bVar);
        }
        Iterator it = this.f9553b.values().iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2 == bVar || (bVar.f9565d == 0 && bVar2.f9563b == bVar.f9563b)) {
                it.remove();
            }
        }
        g();
        return collectionSingletonList;
    }

    public List z() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f9552a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(((Map) it.next()).values());
        }
        Collections.sort(arrayList, new Comparator() { // from class: mark.via.browser.o9
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((q9.b) obj).f9566e, ((q9.b) obj2).f9566e);
            }
        });
        return arrayList;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements r0.m {
        @Override // r0.m
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(JavaScriptExecutionException javaScriptExecutionException) {
            if (javaScriptExecutionException.getErrorType() != 1) {
                tc.a.i("Frame script execution failed (%d)", Integer.valueOf(javaScriptExecutionException.getErrorType()));
            }
        }

        @Override // r0.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResult(String str) {
        }
    }
}
