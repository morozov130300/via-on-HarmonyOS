package p9;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f11016a;

    /* renamed from: b, reason: collision with root package name */
    public List f11017b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11018c;

    /* renamed from: d, reason: collision with root package name */
    public double f11019d;

    /* renamed from: e, reason: collision with root package name */
    public List f11020e;

    public f(String str, List list, boolean z10, double d10, List list2) {
        this.f11016a = str;
        this.f11017b = list;
        this.f11018c = z10;
        this.f11019d = d10;
        this.f11020e = list2;
    }

    public String a() {
        return b().toString();
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", this.f11016a);
        jSONObject.put("stream", this.f11018c);
        jSONObject.put("temperature", this.f11019d);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f11017b.iterator();
        while (it.hasNext()) {
            jSONArray.put(((e) it.next()).k());
        }
        jSONObject.put("messages", jSONArray);
        List list = this.f11020e;
        if (list == null || list.isEmpty()) {
            return jSONObject;
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.f11020e.iterator();
        if (it2.hasNext()) {
            n.g.a(it2.next());
            throw null;
        }
        jSONObject.put("tools", jSONArray2);
        return jSONObject;
    }

    public String toString() {
        return "ChatRequest{model='" + this.f11016a + "', messages=" + this.f11017b + ", stream=" + this.f11018c + ", temperature=" + this.f11019d + '}';
    }
}
