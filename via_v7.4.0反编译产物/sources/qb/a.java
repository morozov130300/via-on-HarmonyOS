package qb;

import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11442a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11443b;

    /* renamed from: c, reason: collision with root package name */
    public int f11444c;

    /* renamed from: d, reason: collision with root package name */
    public e f11445d;

    public a(String str, int i10, int i11, e eVar) {
        this.f11442a = str;
        this.f11443b = i10;
        this.f11444c = i11;
        this.f11445d = eVar;
    }

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
        return this.f11444c & 112;
    }

    public int c() {
        return this.f11444c;
    }

    public String d() {
        return this.f11442a;
    }

    public e e() {
        return this.f11445d;
    }

    public int f() {
        return this.f11443b;
    }

    public boolean g() {
        return (this.f11444c & 1) == 1;
    }

    public void h(boolean z10) {
        if (z10) {
            this.f11444c |= 1;
        } else {
            this.f11444c &= -2;
        }
    }

    public void i(int i10) {
        this.f11444c = (i10 & 112) | (this.f11444c & (-113));
    }

    public JSONObject j(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Name.MARK, this.f11442a);
            jSONObject.put("flags", this.f11444c);
            jSONObject.put("type", this.f11443b);
            if (this.f11443b == 1) {
                e eVar = this.f11445d;
                if (eVar instanceof f) {
                    jSONObject.put("config", ((f) eVar).h(str, str2));
                    return jSONObject;
                }
            }
            return jSONObject;
        } catch (JSONException e10) {
            pc.a.b(e10);
            return jSONObject;
        }
    }

    public String toString() {
        return "SyncingConfig{id='" + this.f11442a + "', type=" + this.f11443b + ", flags=" + this.f11444c + ", storageConfig=" + this.f11445d + '}';
    }
}
