package n9;

import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f10755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10757d;

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
        return this.f10755b;
    }

    public String c() {
        return this.f10754a;
    }

    public int d() {
        return this.f10757d;
    }

    public void e(j jVar) {
        this.f10755b = jVar;
    }

    public void f(String str) {
        this.f10754a = str;
    }

    public void g(int i10) {
        this.f10757d = i10;
    }

    public void h(String str) {
        this.f10756c = str;
    }

    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Name.MARK, this.f10754a);
        j jVar = this.f10755b;
        if (jVar != null) {
            jSONObject.put("function", jVar.f());
        }
        jSONObject.put("type", this.f10756c);
        return jSONObject;
    }

    public String toString() {
        return "ChatMessageToolCall{id='" + this.f10754a + "', function=" + this.f10755b + ", type='" + this.f10756c + "', index=" + this.f10757d + '}';
    }
}
