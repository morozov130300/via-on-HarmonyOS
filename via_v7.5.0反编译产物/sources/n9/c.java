package n9;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f10734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f10735e;

    public static c a(String str) {
        return b(new JSONObject(str));
    }

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        cVar.f(s.f(jSONObject, Name.MARK));
        cVar.e(jSONObject.getInt("created"));
        cVar.g(s.f(jSONObject, "model"));
        cVar.h(k.a(jSONObject.getJSONObject("usage")));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("choices");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(a.a(jSONArrayOptJSONArray.getJSONObject(i10)));
            }
            cVar.d(arrayList);
        }
        return cVar;
    }

    public List c() {
        return this.f10734d;
    }

    public void d(List list) {
        this.f10734d = list;
    }

    public void e(int i10) {
        this.f10732b = i10;
    }

    public void f(String str) {
        this.f10731a = str;
    }

    public void g(String str) {
        this.f10733c = str;
    }

    public void h(k kVar) {
        this.f10735e = kVar;
    }

    public String toString() {
        return "ChatCompletion{id='" + this.f10731a + "', created=" + this.f10732b + ", model='" + this.f10733c + "', choices=" + this.f10734d + ", usage=" + this.f10735e + '}';
    }
}
