package o5;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import s5.d;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static final String f10363e = "a";

    /* renamed from: a, reason: collision with root package name */
    public final p5.c f10364a;

    /* renamed from: b, reason: collision with root package name */
    public final n5.b f10365b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0102a f10366c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f10367d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: o5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0102a {
        void a(String str, String str2);

        void b(String str, String str2);

        void c(String str, boolean z10, int i10);
    }

    public a(WebView webView, n5.b bVar, InterfaceC0102a interfaceC0102a) {
        this.f10365b = bVar;
        this.f10364a = bVar.d();
        this.f10366c = interfaceC0102a;
        this.f10367d = new WeakReference(webView);
    }

    public final void a(String str, String str2, String str3) {
        if (j(str) || i(str2, 1048584)) {
            return;
        }
        this.f10364a.a(str2, str3);
    }

    public final void b(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 2048)) {
            return;
        }
        this.f10366c.b(str3, str4);
    }

    public final String c(String str, String str2, String str3) {
        if (j(str) || i(str2, 32)) {
            return null;
        }
        String strE = this.f10364a.E(str2, str3);
        return strE == null ? "undefined" : strE;
    }

    @JavascriptInterface
    public String call(String str, String str2) {
        if (j(str2)) {
            return null;
        }
        return f((WebView) this.f10367d.get(), str);
    }

    public final String d(String str, String str2, String str3) {
        if (j(str) || i(str2, 67108880)) {
            return null;
        }
        String strD = this.f10364a.D(str2, str3);
        return strD == null ? "undefined" : strD;
    }

    public final String e(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 2097154)) {
            return "undefined";
        }
        String strF = this.f10364a.f(str2, str3);
        return strF == null ? str4 : strF;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String f(WebView webView, String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("secret");
                if (j(strOptString)) {
                    return null;
                }
                String strOptString2 = jSONObject.optString("name");
                String strOptString3 = jSONObject.optString("identifier");
                if (strOptString2 != null && !strOptString2.isEmpty() && strOptString3 != null && !strOptString3.isEmpty()) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("arguments");
                    switch (strOptString2.hashCode()) {
                        case -1446301452:
                            if (strOptString2.equals("openOptions") && jSONObjectOptJSONObject != null) {
                                n(strOptString, jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("namespace"));
                                break;
                            }
                            break;
                        case -1130697082:
                            if (strOptString2.equals("deleteValue") && jSONObjectOptJSONObject != null) {
                                a(strOptString, strOptString3, jSONObjectOptJSONObject.optString("name"));
                                break;
                            }
                            break;
                        case -61010092:
                            if (strOptString2.equals("setClipboard") && jSONObjectOptJSONObject != null) {
                                o(strOptString, strOptString3, jSONObjectOptJSONObject.optString("data"), jSONObjectOptJSONObject.optString("type"));
                                break;
                            }
                            break;
                        case 107332:
                            if (strOptString2.equals("log") && jSONObjectOptJSONObject != null) {
                                l(strOptString, strOptString3, jSONObjectOptJSONObject.optString("message"));
                                break;
                            }
                            break;
                        case 3237038:
                            if (strOptString2.equals("info")) {
                                return g(strOptString, strOptString3);
                            }
                            break;
                        case 433179488:
                            if (strOptString2.equals("listValues")) {
                                return k(strOptString, strOptString3);
                            }
                            break;
                        case 552559728:
                            if (strOptString2.equals("xmlhttpRequest") && jSONObjectOptJSONObject != null) {
                                return q(webView, strOptString, strOptString3, jSONObjectOptJSONObject.optString("details"));
                            }
                            break;
                        case 594258251:
                            if (strOptString2.equals("getResourceURL") && jSONObjectOptJSONObject != null) {
                                return d(strOptString, strOptString3, jSONObjectOptJSONObject.optString("resource"));
                            }
                            break;
                        case 1207466352:
                            if (strOptString2.equals("isInstalled") && jSONObjectOptJSONObject != null) {
                                return h(strOptString, jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("namespace"));
                            }
                            break;
                        case 1242126545:
                            if (strOptString2.equals("getResourceText") && jSONObjectOptJSONObject != null) {
                                return c(strOptString, strOptString3, jSONObjectOptJSONObject.optString("resource"));
                            }
                            break;
                        case 1406685743:
                            if (strOptString2.equals("setValue") && jSONObjectOptJSONObject != null) {
                                p(strOptString, strOptString3, jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("value", "undefined"));
                                break;
                            }
                            break;
                        case 1427818632:
                            if (strOptString2.equals("download") && jSONObjectOptJSONObject != null) {
                                b(strOptString, strOptString3, jSONObjectOptJSONObject.optString("url"), jSONObjectOptJSONObject.optString("name"));
                                break;
                            }
                            break;
                        case 1525822470:
                            if (strOptString2.equals("openInTab") && jSONObjectOptJSONObject != null) {
                                m(strOptString, strOptString3, jSONObjectOptJSONObject.optString("url"), jSONObjectOptJSONObject.optString("options"));
                                break;
                            }
                            break;
                        case 1967798203:
                            if (strOptString2.equals("getValue") && jSONObjectOptJSONObject != null) {
                                return e(strOptString, strOptString3, jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("value", "undefined"));
                            }
                            break;
                    }
                }
                return null;
            } catch (Exception e10) {
                d.h(f10363e, e10);
            }
        }
        return null;
    }

    public final String g(String str, String str2) throws JSONException {
        if (j(str) || str2 == null || str2.isEmpty()) {
            return null;
        }
        r5.c cVarQ = this.f10364a.q(str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scriptHandler", "Via");
            jSONObject.put("version", "2.0.0");
            jSONObject.put("scriptWillUpdate", false);
            JSONObject jSONObject2 = new JSONObject();
            if (cVarQ != null) {
                jSONObject2.put("version", cVarQ.i());
                jSONObject2.put("downloadURL", cVarQ.b());
                jSONObject2.put("homepage", cVarQ.c());
                jSONObject2.put("lastModified", cVarQ.f());
                jSONObject2.put("name", cVarQ.g());
                jSONObject2.put("supportURL", cVarQ.h());
            }
            jSONObject.put("script", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e10) {
            d.h(f10363e, e10);
            return "{}";
        }
    }

    public final String h(String str, String str2, String str3) throws JSONException {
        if (!j(str) && str2 != null && str3 != null) {
            d.a(f10363e, "is installed, name: " + str2 + ", namespace: " + str3);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", str2);
                r5.c cVarQ = this.f10364a.q(s5.c.a(str3 + str2));
                jSONObject.put("installed", cVarQ != null);
                if (cVarQ != null) {
                    jSONObject.put("enabled", cVarQ.j());
                    jSONObject.put("version", cVarQ.i());
                }
                return jSONObject.toString();
            } catch (Exception e10) {
                d.h(f10363e, e10);
            }
        }
        return null;
    }

    public final boolean i(String str, int i10) {
        return !this.f10364a.A(str, i10);
    }

    public final boolean j(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return !str.equals(this.f10365b.c());
    }

    public final String k(String str, String str2) {
        if (j(str) || i(str2, 4194308)) {
            return null;
        }
        String[] strArrJ = this.f10364a.j(str2);
        if (strArrJ == null || strArrJ.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : strArrJ) {
            sb2.append(",");
            sb2.append(str3);
        }
        sb2.deleteCharAt(0);
        return sb2.toString();
    }

    public final void l(String str, String str2, String str3) {
        if (j(str) || i(str2, 512)) {
            return;
        }
        d.a(f10363e, str2 + ": " + str3);
    }

    public final void m(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 268468224)) {
            return;
        }
        int iOptInt = -1;
        boolean zOptBoolean = false;
        try {
            JSONObject jSONObject = new JSONObject(str4);
            zOptBoolean = jSONObject.optBoolean("active", false);
            iOptInt = jSONObject.optInt("insert", -1);
        } catch (JSONException e10) {
            d.h(f10363e, e10);
        }
        this.f10366c.c(str3, zOptBoolean, iOptInt);
    }

    public final void n(String str, String str2, String str3) {
        if (j(str)) {
            return;
        }
        d.a(f10363e, "open options, name: " + str2 + ", namespace: " + str3);
    }

    public final void o(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 1073742848)) {
            return;
        }
        if (str4 == null || str4.isEmpty() || "undefined".equals(str4) || "null".equals(str4)) {
            str4 = "text/plain";
        }
        this.f10366c.a(str3, str4);
    }

    public final void p(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 8388609)) {
            return;
        }
        this.f10364a.d(str2, str3, str4);
    }

    public final String q(WebView webView, String str, String str2, String str3) {
        if (j(str) || i(str2, -2147483392)) {
            return "";
        }
        new b(webView, str3, this.f10365b.a()).b();
        return null;
    }
}
