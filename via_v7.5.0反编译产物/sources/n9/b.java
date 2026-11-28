package n9;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f10729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10730c;

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        bVar.f(jSONObject.optInt("index", 0));
        bVar.e(s.f(jSONObject, "finish_reason"));
        bVar.d(e.a(jSONObject.getJSONObject("delta")));
        return bVar;
    }

    public e b() {
        return this.f10729b;
    }

    public String c() {
        return this.f10730c;
    }

    public void d(e eVar) {
        this.f10729b = eVar;
    }

    public void e(String str) {
        this.f10730c = str;
    }

    public void f(int i10) {
        this.f10728a = i10;
    }

    public String toString() {
        return "ChatChoiceDelta{index=" + this.f10728a + ", delta=" + this.f10729b + ", finishReason='" + this.f10730c + "'}";
    }
}
