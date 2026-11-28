package l9;

import com.tuyafeng.support.utils.p;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7505a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f7509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7511g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7506b = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7512h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String[] f7513i = new String[0];

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
        return this.f7508d;
    }

    public String b() {
        return this.f7511g;
    }

    public int c() {
        return this.f7505a;
    }

    public String d() {
        return this.f7510f;
    }

    public String e() {
        return this.f7507c;
    }

    public int f() {
        return this.f7506b;
    }

    public String[] g() {
        return this.f7513i;
    }

    public String h() {
        return this.f7509e;
    }

    public boolean i() {
        return (this.f7512h & 1) == 1;
    }

    public boolean j() {
        return !k();
    }

    public boolean k() {
        String str;
        String str2 = this.f7509e;
        return str2 == null || str2.isEmpty() || (str = this.f7511g) == null || str.isEmpty();
    }

    public void m(String str) {
        this.f7508d = str;
    }

    public void n(String str) {
        this.f7511g = str;
    }

    public void o(int i10) {
        this.f7512h = i10;
    }

    public void p(int i10) {
        this.f7505a = i10;
    }

    public void q(String str) {
        this.f7510f = str;
    }

    public void r(String str) {
        this.f7507c = str;
    }

    public void s(int i10) {
        this.f7506b = i10;
    }

    public final void t(String[] strArr) {
        this.f7513i = strArr;
    }

    public String toString() {
        return "AddonItem{id=" + this.f7505a + ", oid=" + this.f7506b + ", name='" + this.f7507c + "', author='" + this.f7508d + "', url='" + this.f7509e + "', info='" + this.f7510f + "', code='" + this.f7511g + "', flag=" + this.f7512h + '}';
    }

    public void u(String str) {
        this.f7509e = str;
        t((str == null || str.isEmpty()) ? new String[0] : (String[]) p.o(str, ',').toArray(new String[0]));
    }
}
