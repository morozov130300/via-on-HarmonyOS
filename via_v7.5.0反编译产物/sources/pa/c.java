package pa;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11628b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f11631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f11635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f11638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11640n;

    public c(JSONObject jSONObject) {
        this.f11635i = jSONObject;
    }

    public void a(String str) {
        this.f11627a = str;
    }

    public void b(boolean z10) {
        this.f11636j = z10;
    }

    public void c(int i10) {
        this.f11637k = i10;
    }

    public void d(boolean z10) {
        this.f11639m = z10;
    }

    public void e(boolean z10) {
        this.f11640n = z10;
    }

    public void f(int i10) {
        this.f11628b = i10;
    }

    public void g(String str) {
        this.f11632f = str;
    }

    public void h(String str) {
        this.f11629c = str;
    }

    public void i(String str) {
        this.f11631e = str;
    }

    public void j(String str) {
        this.f11630d = str;
    }

    public void k(int i10) {
        this.f11633g = i10;
    }

    public void l(String str) {
        this.f11634h = str;
    }

    public void m(int i10) {
        this.f11638l = i10;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.f11640n) {
                jSONObject.put("finalUrl", this.f11627a);
                jSONObject.put("readyState", this.f11628b);
                jSONObject.put("status", this.f11633g);
                jSONObject.put("statusText", this.f11634h);
                jSONObject.put("responseHeaders", this.f11629c);
            }
            if (!this.f11639m && !this.f11640n) {
                String str = this.f11630d;
                if (str != null) {
                    jSONObject.put("responseType", str.isEmpty() ? "undefined" : this.f11630d);
                }
                String str2 = this.f11632f;
                if (str2 != null) {
                    jSONObject.put("responseDataUrl", str2);
                }
                String str3 = this.f11631e;
                if (str3 != null) {
                    jSONObject.put("responseText", str3);
                }
                JSONObject jSONObject2 = this.f11635i;
                if (jSONObject2 != null) {
                    jSONObject.put("context", jSONObject2);
                }
                return jSONObject;
            }
            jSONObject.put("lengthComputable", this.f11636j);
            jSONObject.put("loaded", this.f11637k);
            jSONObject.put("total", this.f11638l);
            return jSONObject;
        } catch (JSONException unused) {
            tc.a.a("Could not serialize GM XHR response", new Object[0]);
            return null;
        }
    }

    public String o() {
        JSONObject jSONObjectN = n();
        return jSONObjectN == null ? "" : JSONObject.quote(jSONObjectN.toString());
    }
}
