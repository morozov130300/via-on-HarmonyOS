package ja;

import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f7630a;

    /* renamed from: b, reason: collision with root package name */
    public String f7631b;

    /* renamed from: c, reason: collision with root package name */
    public String f7632c;

    /* renamed from: d, reason: collision with root package name */
    public String f7633d;

    /* renamed from: e, reason: collision with root package name */
    public int f7634e;

    /* renamed from: f, reason: collision with root package name */
    public int f7635f;

    /* renamed from: g, reason: collision with root package name */
    public long f7636g;

    /* renamed from: h, reason: collision with root package name */
    public long f7637h;

    public c() {
    }

    public c(int i10, String str, String str2, int i11) {
        this.f7630a = i10;
        this.f7631b = str;
        this.f7632c = str2;
        this.f7635f = i11;
    }

    public static c i(int i10, String str) {
        return j(i10, str, null);
    }

    public static c j(int i10, String str, String str2) {
        c cVar = new c(i10, str, str2, 2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.s(jCurrentTimeMillis);
        cVar.p(jCurrentTimeMillis);
        return cVar;
    }

    public static c k(String str, String str2) {
        return j(0, str, str2);
    }

    public static c l(int i10, String str, String str2) {
        c cVar = new c(i10, str, str2, 1);
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.s(jCurrentTimeMillis);
        cVar.p(jCurrentTimeMillis);
        return cVar;
    }

    public static c m(String str, String str2) {
        return l(0, str, str2);
    }

    public static c n(JSONObject jSONObject) {
        c cVar;
        c cVar2 = null;
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                cVar = new c();
            } catch (Exception e10) {
                e = e10;
            }
            try {
                cVar.r(jSONObject.optInt(Name.MARK));
                cVar.u(jSONObject.optString("title"));
                cVar.o(jSONObject.optString("content"));
                cVar.t(jSONObject.optString("note"));
                cVar.q(jSONObject.optInt("flag"));
                cVar.v(jSONObject.optInt("type"));
                cVar.s(jSONObject.optLong("lastUpdatedAt"));
                cVar.p(jSONObject.optLong("createdAt"));
                return cVar;
            } catch (Exception e11) {
                e = e11;
                cVar2 = cVar;
                e.printStackTrace();
                return cVar2;
            }
        }
        return cVar2;
    }

    public String a() {
        return this.f7632c;
    }

    public long b() {
        return this.f7637h;
    }

    public int c() {
        return this.f7634e;
    }

    public int d() {
        return this.f7630a;
    }

    public long e() {
        return this.f7636g;
    }

    public String f() {
        return this.f7633d;
    }

    public String g() {
        return this.f7631b;
    }

    public int h() {
        return this.f7635f;
    }

    public void o(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.f7632c = str;
    }

    public void p(long j10) {
        this.f7637h = j10;
    }

    public void q(int i10) {
        this.f7634e = i10;
    }

    public void r(int i10) {
        this.f7630a = i10;
    }

    public void s(long j10) {
        this.f7636g = j10;
    }

    public void t(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.f7633d = str;
    }

    public String toString() {
        return "SettingsData{id=" + this.f7630a + ", key='" + this.f7631b + "', content='" + this.f7632c + "', note='" + this.f7633d + "', flag=" + this.f7634e + ", type=" + this.f7635f + ", lastUpdatedAt=" + this.f7636g + ", createdAt=" + this.f7637h + '}';
    }

    public void u(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.f7631b = str;
    }

    public void v(int i10) {
        this.f7635f = i10;
    }

    public JSONObject w() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Name.MARK, Integer.valueOf(this.f7630a));
            jSONObject.putOpt("title", this.f7631b);
            jSONObject.putOpt("content", this.f7632c);
            jSONObject.putOpt("note", this.f7633d);
            jSONObject.putOpt("flag", Integer.valueOf(this.f7634e));
            jSONObject.putOpt("type", Integer.valueOf(this.f7635f));
            jSONObject.putOpt("lastUpdatedAt", Long.valueOf(this.f7636g));
            jSONObject.putOpt("createdAt", Long.valueOf(this.f7637h));
            return jSONObject;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return jSONObject;
        }
    }
}
