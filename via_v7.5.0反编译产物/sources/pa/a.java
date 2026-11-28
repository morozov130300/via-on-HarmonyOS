package pa;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import oa.k1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qa.c f11595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k1 f11596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0111a f11597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference f11598d;

    /* JADX INFO: renamed from: pa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0111a {
        void a(String str, String str2);

        void b(String str, String str2);

        void c(String str, boolean z10, int i10);
    }

    public a(WebView webView, k1 k1Var, InterfaceC0111a interfaceC0111a) {
        this.f11596b = k1Var;
        this.f11595a = k1Var.f();
        this.f11597c = interfaceC0111a;
        this.f11598d = new WeakReference(webView);
    }

    public final void a(String str, String str2, String str3) {
        if (j(str) || i(str2, 1048584)) {
            return;
        }
        this.f11595a.b(str2, str3);
    }

    public final void b(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 2048)) {
            return;
        }
        this.f11597c.b(str3, str4);
    }

    public final String c(String str, String str2, String str3) {
        if (j(str) || i(str2, 32)) {
            return null;
        }
        String strF = this.f11595a.F(str2, str3);
        return strF == null ? "undefined" : strF;
    }

    @JavascriptInterface
    public String call(String str, String str2) {
        if (j(str2)) {
            return null;
        }
        return f((WebView) this.f11598d.get(), str);
    }

    public final String d(String str, String str2, String str3) {
        if (j(str) || i(str2, 67108880)) {
            return null;
        }
        String strE = this.f11595a.E(str2, str3);
        return strE == null ? "undefined" : strE;
    }

    public final String e(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 2097154)) {
            return "undefined";
        }
        String strE = this.f11595a.e(str2, str3);
        return strE == null ? str4 : strE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String f(WebView webView, String str) {
        Exception exc;
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("secret");
                if (j(strOptString)) {
                    return null;
                }
                String strOptString2 = jSONObject.optString("name");
                String strOptString3 = jSONObject.optString("identifier");
                if (strOptString2 == null || strOptString2.isEmpty() || strOptString3 == null || strOptString3.isEmpty()) {
                    return null;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("arguments");
                try {
                    try {
                        switch (strOptString2.hashCode()) {
                            case -1446301452:
                                if (strOptString2.equals("openOptions") && jSONObjectOptJSONObject != null) {
                                    n(strOptString, jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("namespace"));
                                }
                                break;
                            case -1130697082:
                                if (strOptString2.equals("deleteValue") && jSONObjectOptJSONObject != null) {
                                    a(strOptString, strOptString3, jSONObjectOptJSONObject.optString("name"));
                                }
                                break;
                            case -61010092:
                                if (strOptString2.equals("setClipboard") && jSONObjectOptJSONObject != null) {
                                    p(strOptString, strOptString3, jSONObjectOptJSONObject.optString("data"), jSONObjectOptJSONObject.optString("type"));
                                }
                                break;
                            case 107332:
                                if (strOptString2.equals("log") && jSONObjectOptJSONObject != null) {
                                    l(strOptString, strOptString3, jSONObjectOptJSONObject.optString("message"));
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
                                    return r(webView, strOptString, strOptString3, jSONObjectOptJSONObject.optString("details"), null);
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
                                    q(strOptString, strOptString3, jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("value", "undefined"));
                                }
                                break;
                            case 1427818632:
                                if (strOptString2.equals("download") && jSONObjectOptJSONObject != null) {
                                    b(strOptString, strOptString3, jSONObjectOptJSONObject.optString("url"), jSONObjectOptJSONObject.optString("name"));
                                }
                                break;
                            case 1525822470:
                                if (strOptString2.equals("openInTab") && jSONObjectOptJSONObject != null) {
                                    m(strOptString, strOptString3, jSONObjectOptJSONObject.optString("url"), jSONObjectOptJSONObject.optString("options"));
                                }
                                break;
                            case 1967798203:
                                if (strOptString2.equals("getValue") && jSONObjectOptJSONObject != null) {
                                    return e(strOptString, strOptString3, jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("value", "undefined"));
                                }
                                break;
                            default:
                                break;
                        }
                    } catch (Exception e10) {
                        exc = e10;
                        tc.a.i("Invalid userscript JSON (%s)", exc.getClass().getSimpleName());
                    }
                } catch (Exception e11) {
                    e = e11;
                    exc = e;
                    tc.a.i("Invalid userscript JSON (%s)", exc.getClass().getSimpleName());
                }
            } catch (Exception e12) {
                e = e12;
            }
            exc = e;
            tc.a.i("Invalid userscript JSON (%s)", exc.getClass().getSimpleName());
        }
        return null;
    }

    public final String g(String str, String str2) {
        if (j(str) || str2 == null || str2.isEmpty()) {
            return null;
        }
        ra.c cVarR = this.f11595a.r(str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scriptHandler", "Via");
            jSONObject.put("version", "2.0.0");
            jSONObject.put("scriptWillUpdate", false);
            JSONObject jSONObject2 = new JSONObject();
            if (cVarR != null) {
                jSONObject2.put("version", cVarR.i());
                jSONObject2.put("downloadURL", cVarR.b());
                jSONObject2.put("homepage", cVarR.c());
                jSONObject2.put("lastModified", cVarR.f());
                jSONObject2.put("name", cVarR.g());
                jSONObject2.put("supportURL", cVarR.h());
            }
            jSONObject.put("script", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e10) {
            tc.a.i("Invalid userscript JSON (%s)", e10.getClass().getSimpleName());
            return "{}";
        }
    }

    public final String h(String str, String str2, String str3) {
        if (!j(str) && str2 != null && str3 != null) {
            tc.a.a("is installed, name: " + str2 + ", namespace: " + str3, new Object[0]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", str2);
                ra.c cVarR = this.f11595a.r(ua.b.a(str3 + str2));
                jSONObject.put("installed", cVarR != null);
                if (cVarR != null) {
                    jSONObject.put("enabled", cVarR.j());
                    jSONObject.put("version", cVarR.i());
                }
                return jSONObject.toString();
            } catch (Exception e10) {
                tc.a.i("Invalid userscript JSON (%s)", e10.getClass().getSimpleName());
            }
        }
        return null;
    }

    public final boolean i(String str, int i10) {
        return !this.f11595a.A(str, i10);
    }

    public final boolean j(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return !str.equals(this.f11596b.d());
    }

    public final String k(String str, String str2) {
        if (j(str) || i(str2, 4194308)) {
            return null;
        }
        String[] strArrJ = this.f11595a.j(str2);
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
        tc.a.a(str2 + ": " + str3, new Object[0]);
    }

    public final void m(String str, String str2, String str3, String str4) {
        boolean zOptBoolean;
        if (j(str) || i(str2, 268468224)) {
            return;
        }
        int iOptInt = -1;
        try {
            JSONObject jSONObject = new JSONObject(str4);
            zOptBoolean = jSONObject.optBoolean("active", false);
            try {
                iOptInt = jSONObject.optInt("insert", -1);
            } catch (JSONException e10) {
                e = e10;
                tc.a.i("Invalid userscript JSON (%s)", e.getClass().getSimpleName());
            }
        } catch (JSONException e11) {
            e = e11;
            zOptBoolean = false;
        }
        this.f11597c.c(str3, zOptBoolean, iOptInt);
    }

    public final void n(String str, String str2, String str3) {
        if (j(str)) {
            return;
        }
        tc.a.a("open options, name: " + str2 + ", namespace: " + str3, new Object[0]);
    }

    public void o(JSONObject jSONObject, k1.a aVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("arguments");
        if (jSONObjectOptJSONObject == null || !"xmlhttpRequest".equals(jSONObject.optString("name"))) {
            return;
        }
        r((WebView) this.f11598d.get(), jSONObject.optString("secret"), jSONObject.optString("identifier"), jSONObjectOptJSONObject.optString("details"), aVar);
    }

    public final void p(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 1073742848)) {
            return;
        }
        if (str4 == null || str4.isEmpty() || "undefined".equals(str4) || "null".equals(str4)) {
            str4 = "text/plain";
        }
        this.f11597c.a(str3, str4);
    }

    public final void q(String str, String str2, String str3, String str4) {
        if (j(str) || i(str2, 8388609)) {
            return;
        }
        this.f11595a.c(str2, str3, str4);
    }

    public final String r(WebView webView, String str, String str2, String str3, k1.a aVar) {
        if (j(str) || str2 == null || str2.isEmpty() || i(str2, -2147483392)) {
            return "";
        }
        new b(webView, str3, aVar).c();
        return null;
    }
}
