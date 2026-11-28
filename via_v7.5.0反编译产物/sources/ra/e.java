package ra;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f12110e;

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
                tc.a.i("Invalid userscript JSON (%s)", e10.getClass().getSimpleName());
            }
        }
        return null;
    }

    public static String l(e eVar) {
        if (eVar != null && (eVar.f12106a != 0 || eVar.f12107b != null || eVar.f12108c != null || eVar.f12109d != null || eVar.f12110e != null)) {
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
                tc.a.i("Invalid userscript JSON (%s)", e10.getClass().getSimpleName());
            }
        }
        return null;
    }

    public String b() {
        return this.f12108c;
    }

    public String c() {
        return this.f12110e;
    }

    public String d() {
        return this.f12109d;
    }

    public String e() {
        return this.f12107b;
    }

    public int f() {
        return this.f12106a;
    }

    public void g(String str) {
        this.f12108c = str;
    }

    public void h(String str) {
        this.f12110e = str;
    }

    public void i(String str) {
        this.f12109d = str;
    }

    public void j(String str) {
        this.f12107b = str;
    }

    public void k(int i10) {
        this.f12106a = i10;
    }
}
