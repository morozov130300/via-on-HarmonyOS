package p9;

import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f10996a;

    /* renamed from: b, reason: collision with root package name */
    public e f10997b;

    /* renamed from: c, reason: collision with root package name */
    public String f10998c;

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
        return this.f10998c;
    }

    public e c() {
        return this.f10997b;
    }

    public void d(String str) {
        this.f10998c = str;
    }

    public void e(int i10) {
        this.f10996a = i10;
    }

    public void f(e eVar) {
        this.f10997b = eVar;
    }

    public String toString() {
        return "ChatChoice{index=" + this.f10996a + ", message=" + this.f10997b + ", finishReason='" + this.f10998c + "'}";
    }
}
