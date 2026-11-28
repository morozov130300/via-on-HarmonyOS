package n9;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10759b;

    public j() {
    }

    public static j a(JSONObject jSONObject) {
        j jVar = new j();
        jVar.e(s.f(jSONObject, "name"));
        jVar.d(s.f(jSONObject, "arguments"));
        return jVar;
    }

    public String b() {
        return this.f10759b;
    }

    public String c() {
        return this.f10758a;
    }

    public void d(String str) {
        this.f10759b = str;
    }

    public void e(String str) {
        this.f10758a = str;
    }

    public JSONObject f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f10758a);
        jSONObject.put("arguments", this.f10759b);
        return jSONObject;
    }

    public String toString() {
        return "ChatMessageToolCallFunction{name='" + this.f10758a + "', arguments='" + this.f10759b + "'}";
    }

    public j(String str, String str2) {
        this.f10758a = str;
        this.f10759b = str2;
    }
}
