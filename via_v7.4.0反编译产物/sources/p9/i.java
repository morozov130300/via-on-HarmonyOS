package p9;

import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public String f11025a;

    /* renamed from: b, reason: collision with root package name */
    public j f11026b;

    /* renamed from: c, reason: collision with root package name */
    public String f11027c;

    /* renamed from: d, reason: collision with root package name */
    public int f11028d;

    public static i a(JSONObject jSONObject) {
        i iVar = new i();
        iVar.f(s.f(jSONObject, Name.MARK));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("function");
        if (jSONObjectOptJSONObject != null) {
            iVar.e(j.a(jSONObjectOptJSONObject));
        }
        iVar.h(s.f(jSONObject, "type"));
        iVar.g(jSONObject.optInt("index", 0));
        return iVar;
    }

    public j b() {
        return this.f11026b;
    }

    public String c() {
        return this.f11025a;
    }

    public int d() {
        return this.f11028d;
    }

    public void e(j jVar) {
        this.f11026b = jVar;
    }

    public void f(String str) {
        this.f11025a = str;
    }

    public void g(int i10) {
        this.f11028d = i10;
    }

    public void h(String str) {
        this.f11027c = str;
    }

    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Name.MARK, this.f11025a);
        j jVar = this.f11026b;
        if (jVar != null) {
            jSONObject.put("function", jVar.f());
        }
        jSONObject.put("type", this.f11027c);
        return jSONObject;
    }

    public String toString() {
        return "ChatMessageToolCall{id='" + this.f11025a + "', function=" + this.f11026b + ", type='" + this.f11027c + "', index=" + this.f11028d + '}';
    }
}
