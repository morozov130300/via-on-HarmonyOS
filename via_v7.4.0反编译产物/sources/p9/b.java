package p9;

import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f10999a;

    /* renamed from: b, reason: collision with root package name */
    public e f11000b;

    /* renamed from: c, reason: collision with root package name */
    public String f11001c;

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        bVar.f(jSONObject.optInt("index", 0));
        bVar.e(s.f(jSONObject, "finish_reason"));
        bVar.d(e.a(jSONObject.getJSONObject("delta")));
        return bVar;
    }

    public e b() {
        return this.f11000b;
    }

    public String c() {
        return this.f11001c;
    }

    public void d(e eVar) {
        this.f11000b = eVar;
    }

    public void e(String str) {
        this.f11001c = str;
    }

    public void f(int i10) {
        this.f10999a = i10;
    }

    public String toString() {
        return "ChatChoiceDelta{index=" + this.f10999a + ", delta=" + this.f11000b + ", finishReason='" + this.f11001c + "'}";
    }
}
