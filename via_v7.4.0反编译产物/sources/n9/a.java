package n9;

import g6.p;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f10251a;

    /* renamed from: c, reason: collision with root package name */
    public String f10253c;

    /* renamed from: d, reason: collision with root package name */
    public String f10254d;

    /* renamed from: e, reason: collision with root package name */
    public String f10255e;

    /* renamed from: f, reason: collision with root package name */
    public String f10256f;

    /* renamed from: g, reason: collision with root package name */
    public String f10257g;

    /* renamed from: b, reason: collision with root package name */
    public int f10252b = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f10258h = 0;

    /* renamed from: i, reason: collision with root package name */
    public String[] f10259i = new String[0];

    public static a l(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null && !jSONObject.isNull("url") && !jSONObject.isNull("code")) {
            aVar.u(jSONObject.optString("url"));
            aVar.n(jSONObject.optString("code"));
            if (!jSONObject.isNull("oid")) {
                aVar.s(jSONObject.optInt("oid"));
            }
            if (!jSONObject.isNull("name")) {
                aVar.r(jSONObject.optString("name"));
            }
            if (!jSONObject.isNull("author")) {
                aVar.m(jSONObject.optString("author"));
            }
            if (!jSONObject.isNull("info")) {
                aVar.q(jSONObject.optString("info"));
            }
            if (!jSONObject.isNull("flag")) {
                aVar.o(jSONObject.optInt("flag", 0));
            }
        }
        return aVar;
    }

    public String a() {
        return this.f10254d;
    }

    public String b() {
        return this.f10257g;
    }

    public int c() {
        return this.f10251a;
    }

    public String d() {
        return this.f10256f;
    }

    public String e() {
        return this.f10253c;
    }

    public int f() {
        return this.f10252b;
    }

    public String[] g() {
        return this.f10259i;
    }

    public String h() {
        return this.f10255e;
    }

    public boolean i() {
        return (this.f10258h & 1) == 1;
    }

    public boolean j() {
        return !k();
    }

    public boolean k() {
        String str;
        String str2 = this.f10255e;
        return str2 == null || str2.isEmpty() || (str = this.f10257g) == null || str.isEmpty();
    }

    public void m(String str) {
        this.f10254d = str;
    }

    public void n(String str) {
        this.f10257g = str;
    }

    public void o(int i10) {
        this.f10258h = i10;
    }

    public void p(int i10) {
        this.f10251a = i10;
    }

    public void q(String str) {
        this.f10256f = str;
    }

    public void r(String str) {
        this.f10253c = str;
    }

    public void s(int i10) {
        this.f10252b = i10;
    }

    public final void t(String[] strArr) {
        this.f10259i = strArr;
    }

    public String toString() {
        return "AddonItem{id=" + this.f10251a + ", oid=" + this.f10252b + ", name='" + this.f10253c + "', author='" + this.f10254d + "', url='" + this.f10255e + "', info='" + this.f10256f + "', code='" + this.f10257g + "', flag=" + this.f10258h + '}';
    }

    public void u(String str) {
        this.f10255e = str;
        t((str == null || str.isEmpty()) ? new String[0] : (String[]) p.o(str, ',').toArray(new String[0]));
    }
}
