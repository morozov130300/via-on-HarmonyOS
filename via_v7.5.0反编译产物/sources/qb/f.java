package qb;

import org.json.JSONException;
import org.json.JSONObject;
import x8.w0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11866e;

    public f() {
        this(null, null, null, false, null);
    }

    public static f b(JSONObject jSONObject, String str, String str2) {
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("user");
        String strOptString3 = jSONObject.optString("pass");
        String strOptString4 = jSONObject.optString("path");
        boolean zOptBoolean = jSONObject.optBoolean("digestAuth", false);
        if (!strOptString2.isEmpty()) {
            strOptString2 = w0.a(str, str2, strOptString2);
        }
        String str3 = strOptString2;
        if (!strOptString3.isEmpty()) {
            strOptString3 = w0.a(str, str2, strOptString3);
        }
        return new f(strOptString, str3, strOptString3, zOptBoolean, strOptString4);
    }

    @Override // qb.e
    public boolean a() {
        String str;
        String str2;
        String str3 = this.f11862a;
        return str3 == null || str3.isEmpty() || (str = this.f11863b) == null || str.isEmpty() || (str2 = this.f11864c) == null || str2.isEmpty();
    }

    public String c() {
        return this.f11862a;
    }

    public String d() {
        return this.f11864c;
    }

    public String e() {
        return this.f11866e;
    }

    public String f() {
        return this.f11863b;
    }

    public boolean g() {
        return this.f11865d;
    }

    public JSONObject h(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str3 = this.f11862a;
        if (str3 != null && !str3.isEmpty()) {
            jSONObject.put("url", this.f11862a);
        }
        String str4 = this.f11863b;
        if (str4 != null && !str4.isEmpty()) {
            jSONObject.put("user", w0.f(str, str2, this.f11863b));
        }
        String str5 = this.f11864c;
        if (str5 != null && !str5.isEmpty()) {
            jSONObject.put("pass", w0.f(str, str2, this.f11864c));
        }
        jSONObject.put("digestAuth", this.f11865d);
        jSONObject.put("path", this.f11866e);
        return jSONObject;
    }

    public f(String str, String str2, String str3, boolean z10, String str4) {
        if (str == null || str.isEmpty()) {
            this.f11862a = null;
        } else {
            if (str.charAt(str.length() - 1) != '/') {
                str = str + "/";
            }
            this.f11862a = str;
        }
        this.f11863b = str2;
        this.f11864c = str3;
        this.f11865d = z10;
        this.f11866e = str4;
    }
}
