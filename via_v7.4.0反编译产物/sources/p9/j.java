package p9;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public String f11029a;

    /* renamed from: b, reason: collision with root package name */
    public String f11030b;

    public j() {
    }

    public j(String str, String str2) {
        this.f11029a = str;
        this.f11030b = str2;
    }

    public static j a(JSONObject jSONObject) {
        j jVar = new j();
        jVar.e(s.f(jSONObject, "name"));
        jVar.d(s.f(jSONObject, "arguments"));
        return jVar;
    }

    public String b() {
        return this.f11030b;
    }

    public String c() {
        return this.f11029a;
    }

    public void d(String str) {
        this.f11030b = str;
    }

    public void e(String str) {
        this.f11029a = str;
    }

    public JSONObject f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f11029a);
        jSONObject.put("arguments", this.f11030b);
        return jSONObject;
    }

    public String toString() {
        return "ChatMessageToolCallFunction{name='" + this.f11029a + "', arguments='" + this.f11030b + "'}";
    }
}
