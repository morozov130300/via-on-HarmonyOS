package n9;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f10726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10727c;

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        aVar.e(jSONObject.optInt("index", 0));
        aVar.d(s.f(jSONObject, "finish_reason"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("message");
        if (jSONObjectOptJSONObject != null) {
            aVar.f(e.a(jSONObjectOptJSONObject));
        }
        return aVar;
    }

    public String b() {
        return this.f10727c;
    }

    public e c() {
        return this.f10726b;
    }

    public void d(String str) {
        this.f10727c = str;
    }

    public void e(int i10) {
        this.f10725a = i10;
    }

    public void f(e eVar) {
        this.f10726b = eVar;
    }

    public String toString() {
        return "ChatChoice{index=" + this.f10725a + ", message=" + this.f10726b + ", finishReason='" + this.f10727c + "'}";
    }
}
