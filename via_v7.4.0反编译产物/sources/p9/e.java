package p9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f11011a;

    /* renamed from: b, reason: collision with root package name */
    public String f11012b;

    /* renamed from: c, reason: collision with root package name */
    public String f11013c;

    /* renamed from: d, reason: collision with root package name */
    public List f11014d;

    /* renamed from: e, reason: collision with root package name */
    public String f11015e;

    public e() {
        this(null, null);
    }

    public e(String str, String str2) {
        this.f11011a = str;
        this.f11013c = str2;
    }

    public static e a(JSONObject jSONObject) {
        e eVar = new e();
        eVar.f(s.f(jSONObject, "content"));
        eVar.g(s.f(jSONObject, "reasoning_content"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tool_calls");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(i.a(jSONArrayOptJSONArray.getJSONObject(i10)));
            }
            eVar.j(arrayList);
        }
        eVar.i(s.f(jSONObject, "tool_call_id"));
        eVar.h(s.f(jSONObject, "role"));
        return eVar;
    }

    public static e l(String str) {
        e eVar = new e();
        eVar.h("user");
        eVar.f(str);
        return eVar;
    }

    public String b() {
        return this.f11011a;
    }

    public String c() {
        return this.f11012b;
    }

    public String d() {
        return this.f11013c;
    }

    public List e() {
        return this.f11014d;
    }

    public void f(String str) {
        this.f11011a = str;
    }

    public void g(String str) {
        this.f11012b = str;
    }

    public void h(String str) {
        this.f11013c = str;
    }

    public void i(String str) {
        this.f11015e = str;
    }

    public void j(List list) {
        this.f11014d = list;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", this.f11011a);
        jSONObject.put("role", this.f11013c);
        List list = this.f11014d;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f11014d.iterator();
            while (it.hasNext()) {
                jSONArray.put(((i) it.next()).i());
            }
            jSONObject.put("tool_calls", jSONArray);
        }
        String str = this.f11015e;
        if (str != null) {
            jSONObject.put("tool_call_id", str);
        }
        return jSONObject;
    }

    public String toString() {
        return "ChatMessage{content='" + this.f11011a + "', reasoningContent='" + this.f11012b + "', role='" + this.f11013c + "', toolCalls=" + this.f11014d + ", toolCallId='" + this.f11015e + "'}";
    }
}
