package p9;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f11007a;

    /* renamed from: b, reason: collision with root package name */
    public int f11008b;

    /* renamed from: c, reason: collision with root package name */
    public String f11009c;

    /* renamed from: d, reason: collision with root package name */
    public List f11010d;

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
        return this.f11010d;
    }

    public void d(List list) {
        this.f11010d = list;
    }

    public void e(int i10) {
        this.f11008b = i10;
    }

    public void f(String str) {
        this.f11007a = str;
    }

    public void g(String str) {
        this.f11009c = str;
    }

    public String toString() {
        return "ChatCompletionDelta{id='" + this.f11007a + "', created=" + this.f11008b + ", model='" + this.f11009c + "', choices=" + this.f11010d + '}';
    }
}
