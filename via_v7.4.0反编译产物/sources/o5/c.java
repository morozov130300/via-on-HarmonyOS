package o5;

import org.json.JSONException;
import org.json.JSONObject;
import s5.d;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: o, reason: collision with root package name */
    public static final String f10397o = "o5.c";

    /* renamed from: a, reason: collision with root package name */
    public String f10398a;

    /* renamed from: b, reason: collision with root package name */
    public int f10399b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f10400c;

    /* renamed from: d, reason: collision with root package name */
    public String f10401d;

    /* renamed from: e, reason: collision with root package name */
    public String f10402e;

    /* renamed from: f, reason: collision with root package name */
    public String f10403f;

    /* renamed from: g, reason: collision with root package name */
    public int f10404g;

    /* renamed from: h, reason: collision with root package name */
    public String f10405h;

    /* renamed from: i, reason: collision with root package name */
    public JSONObject f10406i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10407j;

    /* renamed from: k, reason: collision with root package name */
    public long f10408k;

    /* renamed from: l, reason: collision with root package name */
    public long f10409l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10410m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10411n;

    public c(JSONObject jSONObject) {
        this.f10406i = jSONObject;
    }

    public void a(String str) {
        this.f10398a = str;
    }

    public void b(boolean z10) {
        this.f10407j = z10;
    }

    public void c(int i10) {
        this.f10408k = i10;
    }

    public void d(boolean z10) {
        this.f10410m = z10;
    }

    public void e(boolean z10) {
        this.f10411n = z10;
    }

    public void f(int i10) {
        this.f10399b = i10;
    }

    public void g(String str) {
        this.f10403f = str;
    }

    public void h(String str) {
        this.f10400c = str;
    }

    public void i(String str) {
        this.f10402e = str;
    }

    public void j(String str) {
        this.f10401d = str;
    }

    public void k(int i10) {
        this.f10404g = i10;
    }

    public void l(String str) {
        this.f10405h = str;
    }

    public void m(int i10) {
        this.f10409l = i10;
    }

    public JSONObject n() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.f10411n) {
                jSONObject.put("finalUrl", this.f10398a);
                jSONObject.put("readyState", this.f10399b);
                jSONObject.put("status", this.f10404g);
                jSONObject.put("statusText", this.f10405h);
                jSONObject.put("responseHeaders", this.f10400c);
            }
            if (!this.f10410m && !this.f10411n) {
                String str = this.f10401d;
                if (str != null) {
                    jSONObject.put("responseType", str.isEmpty() ? "undefined" : this.f10401d);
                }
                String str2 = this.f10403f;
                if (str2 != null) {
                    jSONObject.put("responseDataUrl", str2);
                }
                String str3 = this.f10402e;
                if (str3 != null) {
                    jSONObject.put("responseText", str3);
                }
                JSONObject jSONObject2 = this.f10406i;
                if (jSONObject2 != null) {
                    jSONObject.put("context", jSONObject2);
                }
                return jSONObject;
            }
            jSONObject.put("lengthComputable", this.f10407j);
            jSONObject.put("loaded", this.f10408k);
            jSONObject.put("total", this.f10409l);
            return jSONObject;
        } catch (JSONException e10) {
            d.c(f10397o, "Failed to generate JSON response object:" + e10.getMessage());
            return null;
        }
    }

    public String o() throws JSONException {
        JSONObject jSONObjectN = n();
        return jSONObjectN == null ? "" : JSONObject.quote(jSONObjectN.toString());
    }
}
