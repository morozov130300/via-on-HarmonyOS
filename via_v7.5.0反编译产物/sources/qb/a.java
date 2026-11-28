package qb;

import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f11855d;

    public a(a aVar) {
        this(aVar.d(), aVar.f(), aVar.c(), aVar.e());
    }

    public static a a(JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && jSONObject.length() != 0) {
            String strOptString = jSONObject.optString(Name.MARK);
            int iOptInt = jSONObject.optInt("type");
            if (!strOptString.isEmpty() && iOptInt == 1 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("config")) != null && jSONObjectOptJSONObject.length() != 0) {
                return new a(strOptString, iOptInt, jSONObject.optInt("flags"), f.b(jSONObjectOptJSONObject, str, str2));
            }
        }
        return null;
    }

    public int b() {
        return this.f11854c & 112;
    }

    public int c() {
        return this.f11854c;
    }

    public String d() {
        return this.f11852a;
    }

    public e e() {
        return this.f11855d;
    }

    public int f() {
        return this.f11853b;
    }

    public boolean g() {
        return (this.f11854c & 1) == 1;
    }

    public void h(boolean z10) {
        if (z10) {
            this.f11854c |= 1;
        } else {
            this.f11854c &= -2;
        }
    }

    public void i(int i10) {
        this.f11854c = (i10 & 112) | (this.f11854c & (-113));
    }

    public JSONObject j(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Name.MARK, this.f11852a);
            jSONObject.put("flags", this.f11854c);
            jSONObject.put("type", this.f11853b);
            if (this.f11853b == 1) {
                e eVar = this.f11855d;
                if (eVar instanceof f) {
                    jSONObject.put("config", ((f) eVar).h(str, str2));
                    return jSONObject;
                }
            }
            return jSONObject;
        } catch (JSONException e10) {
            tc.a.b(e10);
            return jSONObject;
        }
    }

    public String toString() {
        return "SyncingConfig{id='" + this.f11852a + "', type=" + this.f11853b + ", flags=" + this.f11854c + ", storageConfig=" + this.f11855d + '}';
    }

    public a(String str, int i10, int i11, e eVar) {
        this.f11852a = str;
        this.f11853b = i10;
        this.f11854c = i11;
        this.f11855d = eVar;
    }
}
