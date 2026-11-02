package r5;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    public static final String f11578f = "e";

    /* renamed from: a, reason: collision with root package name */
    public int f11579a;

    /* renamed from: b, reason: collision with root package name */
    public String f11580b;

    /* renamed from: c, reason: collision with root package name */
    public String f11581c;

    /* renamed from: d, reason: collision with root package name */
    public String f11582d;

    /* renamed from: e, reason: collision with root package name */
    public String f11583e;

    public static e a(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                e eVar = new e();
                eVar.k(jSONObject.optInt("runAt", 0));
                eVar.j(jSONObject.optString("matches"));
                eVar.g(jSONObject.optString("excludeMatches"));
                eVar.i(jSONObject.optString("includes"));
                eVar.h(jSONObject.optString("excludes"));
                return eVar;
            } catch (Exception e10) {
                s5.d.h(f11578f, e10);
            }
        }
        return null;
    }

    public static String l(e eVar) throws JSONException {
        if (eVar != null && (eVar.f11579a != 0 || eVar.f11580b != null || eVar.f11581c != null || eVar.f11582d != null || eVar.f11583e != null)) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (eVar.f() != 0) {
                    jSONObject.put("runAt", eVar.f());
                }
                jSONObject.put("matches", eVar.e());
                jSONObject.put("excludeMatches", eVar.b());
                jSONObject.put("includes", eVar.d());
                jSONObject.put("excludes", eVar.c());
                return jSONObject.toString();
            } catch (JSONException e10) {
                s5.d.h(f11578f, e10);
            }
        }
        return null;
    }

    public String b() {
        return this.f11581c;
    }

    public String c() {
        return this.f11583e;
    }

    public String d() {
        return this.f11582d;
    }

    public String e() {
        return this.f11580b;
    }

    public int f() {
        return this.f11579a;
    }

    public void g(String str) {
        this.f11581c = str;
    }

    public void h(String str) {
        this.f11583e = str;
    }

    public void i(String str) {
        this.f11582d = str;
    }

    public void j(String str) {
        this.f11580b = str;
    }

    public void k(int i10) {
        this.f11579a = i10;
    }
}
