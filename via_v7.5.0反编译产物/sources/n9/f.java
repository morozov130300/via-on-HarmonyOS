package n9;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f10746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f10748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f10749e;

    public f(String str, List list, boolean z10, double d10, List list2) {
        this.f10745a = str;
        this.f10746b = list;
        this.f10747c = z10;
        this.f10748d = d10;
        this.f10749e = list2;
    }

    public String a() {
        return b().toString();
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", this.f10745a);
        jSONObject.put("stream", this.f10747c);
        jSONObject.put("temperature", this.f10748d);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f10746b.iterator();
        while (it.hasNext()) {
            jSONArray.put(((e) it.next()).k());
        }
        jSONObject.put("messages", jSONArray);
        List list = this.f10749e;
        if (list == null || list.isEmpty()) {
            return jSONObject;
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.f10749e.iterator();
        if (it2.hasNext()) {
            n.g.a(it2.next());
            throw null;
        }
        jSONObject.put("tools", jSONArray2);
        return jSONObject;
    }

    public String toString() {
        return "ChatRequest{model='" + this.f10745a + "', messages=" + this.f10746b + ", stream=" + this.f10747c + ", temperature=" + this.f10748d + '}';
    }
}
