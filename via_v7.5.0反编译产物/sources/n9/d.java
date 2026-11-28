package n9;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f10739d;

    public static d a(String str) {
        return b(new JSONObject(str));
    }

    public static d b(JSONObject jSONObject) {
        d dVar = new d();
        dVar.f(s.f(jSONObject, Name.MARK));
        dVar.e(jSONObject.optInt("created", 0));
        dVar.g(s.f(jSONObject, "model"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("choices");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(b.a(jSONArrayOptJSONArray.getJSONObject(i10)));
            }
            dVar.d(arrayList);
        }
        return dVar;
    }

    public List c() {
        return this.f10739d;
    }

    public void d(List list) {
        this.f10739d = list;
    }

    public void e(int i10) {
        this.f10737b = i10;
    }

    public void f(String str) {
        this.f10736a = str;
    }

    public void g(String str) {
        this.f10738c = str;
    }

    public String toString() {
        return "ChatCompletionDelta{id='" + this.f10736a + "', created=" + this.f10737b + ", model='" + this.f10738c + "', choices=" + this.f10739d + '}';
    }
}
