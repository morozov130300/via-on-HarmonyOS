package p9;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f11002a;

    /* renamed from: b, reason: collision with root package name */
    public int f11003b;

    /* renamed from: c, reason: collision with root package name */
    public String f11004c;

    /* renamed from: d, reason: collision with root package name */
    public List f11005d;

    /* renamed from: e, reason: collision with root package name */
    public k f11006e;

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
        return this.f11005d;
    }

    public void d(List list) {
        this.f11005d = list;
    }

    public void e(int i10) {
        this.f11003b = i10;
    }

    public void f(String str) {
        this.f11002a = str;
    }

    public void g(String str) {
        this.f11004c = str;
    }

    public void h(k kVar) {
        this.f11006e = kVar;
    }

    public String toString() {
        return "ChatCompletion{id='" + this.f11002a + "', created=" + this.f11003b + ", model='" + this.f11004c + "', choices=" + this.f11005d + ", usage=" + this.f11006e + '}';
    }
}
